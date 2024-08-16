package net.thep2wking.oedldoedlcore.content.itemblock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import codechicken.lib.util.ClientUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBlockBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.config.categories.Content.Spawner.SpawnerEntitySource;
import net.thep2wking.oedldoedlcore.util.ModNBTUtil;

public class ItemBlockMobSpawner extends ModItemBlockBase {
    public static Map<String, ResourceLocation> rlCache = new WeakHashMap<>();
    public static List<String> randomDisplayList = null;
    public static Map<String, Entity> renderEntityMap = new HashMap<>();
    public static volatile int elapsedTicks;
    public static Set<String> entityNameList = new HashSet<String>();
    public static final Map<ResourceLocation, String> ENTITIES = Maps.<ResourceLocation, String>newLinkedHashMap();

    public ItemBlockMobSpawner(Block block, EnumRarity rarity, boolean hasEffect, int tooltipLines,
            int annotationLines) {
        super(block, rarity, hasEffect, tooltipLines, annotationLines);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        if (CoreConfig.TOOLTIPS.ANNOTATION_TOOLTIPS && CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER
                && CoreConfig.CONTENT.SPAWNER.DISPLAY_NAME && Loader.isModLoaded("codechickenlib")) {
            Entity entity = null;
            try {
                entity = getRenderEntity(itemstack);
                if (entity == null || (entity instanceof IProjectile || entity instanceof EntityItem
                        || entity instanceof EntityLightningBolt || entity instanceof EntityAreaEffectCloud)) {
                    return;
                }
                if (entity != null) {
                    if (!GuiScreen.isShiftKeyDown()) {
                        list.add(displayEntityName(itemstack, entity));
                    } else {
                        list.add(displayEntityID(itemstack, entity));
                    }
                }
            } catch (Throwable e) {
                System.err.println("Exception while creating entity for name: " + getEntityString(itemstack));
                entity = new EntityPig(ClientUtils.getWorld());
            }
        }
    }

    public String displayEntityName(ItemStack stack, Entity entityDisplay) {
        Entity entity = entityDisplay;
        String entityName = "entity." + EntityList.getTranslationName(getCachedRegName(getEntityString(stack)))
                + ".name";
        String entityColor = "\u00A7" + (entity instanceof IMob ? "4" : "3");
        return I18n.format(entityColor + I18n.format(entityName));
    }

    public String displayEntityID(ItemStack stack, Entity entityDisplay) {
        Entity entity = entityDisplay;
        String entityName = stack.getTagCompound().getString("EntityName");
        String entityColor = "\u00A7" + (entity instanceof IMob ? "4" : "3");
        return entityColor + (entityName);
    }

    public Entity getRenderEntity(ItemStack stack) {
        return getRenderEntity(getEntityString(stack));
    }

    public static Entity getRenderEntity(String name) {
        if (name.equals("[Random-Display]")) {
            if (randomDisplayList == null) {
                randomDisplayList = new ArrayList<>();
                EntityList.ENTITY_EGGS.forEach(
                        (resourceLocation, entityEggInfo) -> randomDisplayList.add(entityEggInfo.spawnedID + ""));
            }
            if (randomDisplayList.size() > 0) {
                name = randomDisplayList.get((elapsedTicks / 20) % randomDisplayList.size());
            }
        }
        if (!renderEntityMap.containsKey(name) && CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER
                && Loader.isModLoaded("codechickenlib")) {
            World world = ClientUtils.getWorld();
            if (world == null) {
                return null;
            }
            Entity entity = null;
            try {
                entity = EntityList.createEntityByIDFromName(getCachedRegName(name), world);
                if (entity == null) {
                    System.err.println("Entity creation failed for name: " + name);
                }
            } catch (Throwable e) {
                System.err.println("Exception while creating entity for name: " + name);
                entity = new EntityPig(world);
            }
            renderEntityMap.put(name, entity);
        }
        return renderEntityMap.get(name);
    }

    public static boolean verifyExistance(ItemStack stack, String tag) {
        NBTTagCompound compound = stack.getTagCompound();
        return compound == null ? false : stack.getTagCompound().hasKey(tag);
    }

    public static String getString(ItemStack stack, String tag, String defaultExpected) {
        return verifyExistance(stack, tag) ? stack.getTagCompound().getString(tag) : defaultExpected;
    }

    public static String getEntityString(ItemStack stack) {
        return getString(stack, "EntityName", "nothing");
    }

    public static ItemStack setString(ItemStack stack, String tag, String s) {
        getCompound(stack).setString(tag, s);
        return stack;
    }

    public static NBTTagCompound getCompound(ItemStack stack) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        return stack.getTagCompound();
    }

    public void setEntity(ResourceLocation entityName, ItemStack stack) {
        setString(stack, "EntityName", String.valueOf(entityName));
    }

    @Nullable
    public NBTTagCompound getEntityData(ItemStack stack) {
        NBTTagCompound compound = getCompound(stack);
        if (compound.hasKey("EntityData")) {
            return compound.getCompoundTag("EntityData");
        }
        return null;
    }

    public static ResourceLocation getCachedRegName(String name) {
        return rlCache.computeIfAbsent(name, ResourceLocation::new);
    }

    public static void fillEntityMap() {
        if (CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER && Loader.isModLoaded("codechickenlib")) {
            for (ResourceLocation entityRL : EntityList.getEntityNameList()) {
                String entityDomain = entityRL.getResourceDomain();
                String entityPath = entityRL.getResourcePath();
                String entityName = entityDomain + ":" + entityPath;
                Entity entity = null;
                if (CoreConfig.CONTENT.SPAWNER.ENTITY_SOURCE == SpawnerEntitySource.ENTITY_EGGS) {
                    try {
                        entity = EntityList.createEntityByIDFromName(getCachedRegName(entityName),
                                ClientUtils.getWorld());
                        if (entity == null || (entity instanceof IProjectile || entity instanceof EntityItem
                                || entity instanceof EntityLightningBolt || entity instanceof EntityAreaEffectCloud)) {
                            return;
                        }
                    } catch (Throwable e) {
                        System.err.println("Exception while creating entity for name: " + entityName);
                        entity = new EntityPig(ClientUtils.getWorld());
                    }
                } else if (CoreConfig.CONTENT.SPAWNER.ENTITY_SOURCE == SpawnerEntitySource.ENTITY_LIVING) {
                    try {
                        entity = EntityList.createEntityByIDFromName(getCachedRegName(entityName),
                                ClientUtils.getWorld());
                        if (entity instanceof EntityLiving) {
                            ENTITIES.put(entityRL, entityName);
                        }
                        if (entity == null || (entity instanceof IProjectile || entity instanceof EntityItem
                                || entity instanceof EntityLightningBolt || entity instanceof EntityAreaEffectCloud)) {
                            System.err.println("Entity creation failed for name: " + entityName);
                        }
                    } catch (Throwable e) {
                        System.err.println("Exception while creating entity for name: " + entityName);
                        entity = new EntityPig(ClientUtils.getWorld());
                    }
                } else if (CoreConfig.CONTENT.SPAWNER.ENTITY_SOURCE == SpawnerEntitySource.ENTITY_REGISTRY) {
                    try {
                        entity = EntityList.createEntityByIDFromName(getCachedRegName(entityName),
                                ClientUtils.getWorld());
                        if (entity instanceof Entity
                                && !(entity instanceof IProjectile) && !(entity instanceof EntityItem)
                                && !(entity instanceof EntityFireball) && !(entity instanceof EntityLightningBolt)
                                && !(entity instanceof EntityItemFrame) && !(entity instanceof EntityPainting)
                                && !(entity instanceof EntityEnderEye) && !(entity instanceof EntityTNTPrimed)
                                && !(entity instanceof EntityFallingBlock) && !(entity instanceof EntityLeashKnot)
                                && !(entity instanceof EntityShulkerBullet) && !(entity instanceof EntityLlamaSpit)
                                && !(entity instanceof EntityEvokerFangs)
                                && !(entity instanceof EntityFireworkRocket)
                                && !(entity instanceof EntityAreaEffectCloud)) {
                            ENTITIES.put(entityRL, entityName);
                        }
                        if (entity == null || (entity instanceof IProjectile || entity instanceof EntityItem
                                || entity instanceof EntityLightningBolt || entity instanceof EntityAreaEffectCloud)) {
                            System.err.println("Entity creation failed for name: " + entityName);
                        }
                    } catch (Throwable e) {
                        System.err.println("Exception while creating entity for name: " + entityName);
                        entity = new EntityPig(ClientUtils.getWorld());
                    }
                }
            }
        }
    }

    public static void displaySpawners(NonNullList<ItemStack> itemList, Item item) {
        if (CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER && Loader.isModLoaded("codechickenlib")) {
            fillEntityMap();
        }

        String[] blacklistArray = CoreConfig.CONTENT.SPAWNER.BLACKLIST;
        Set<String> blacklist = new HashSet<>(Arrays.asList(blacklistArray));

        if (CoreConfig.CONTENT.SPAWNER.ENTITY_SOURCE == SpawnerEntitySource.ENTITY_EGGS) {
            List<Map.Entry<ResourceLocation, EntityEggInfo>> sortedEntityEggsList = new ArrayList<>(
                    EntityList.ENTITY_EGGS.entrySet());
            sortedEntityEggsList.sort(Comparator.comparing(entry -> entry.getKey().toString()));
            sortedEntityEggsList.forEach(entry -> {
                ResourceLocation resourceLocation = entry.getKey();
                String resourceLocationString = resourceLocation.getResourceDomain() + ":"
                        + resourceLocation.getResourcePath();
                boolean containsBlacklistedWord = blacklist.stream().anyMatch(resourceLocationString::contains);
                if (!containsBlacklistedWord) {
                    itemList.add(ModNBTUtil.addNBTItem(item, "EntityName", resourceLocationString));
                }
            });
        } else if (CoreConfig.CONTENT.SPAWNER.ENTITY_SOURCE == SpawnerEntitySource.ENTITY_LIVING) {
            List<Map.Entry<ResourceLocation, String>> sortedEntitiesList = new ArrayList<>(ENTITIES.entrySet());
            sortedEntitiesList.sort(Comparator.comparing(entry -> entry.getKey().toString()));
            sortedEntitiesList.forEach(entry -> {
                ResourceLocation resourceLocation = entry.getKey();
                String resourceLocationString = resourceLocation.getResourceDomain() + ":"
                        + resourceLocation.getResourcePath();
                boolean containsBlacklistedWord = blacklist.stream().anyMatch(resourceLocationString::contains);
                if (!containsBlacklistedWord) {
                    itemList.add(ModNBTUtil.addNBTItem(item, "EntityName", resourceLocationString));
                }
            });
        } else if (CoreConfig.CONTENT.SPAWNER.ENTITY_SOURCE == SpawnerEntitySource.ENTITY_REGISTRY) {
            List<Map.Entry<ResourceLocation, String>> sortedEntitiesList = new ArrayList<>(ENTITIES.entrySet());
            sortedEntitiesList.sort(Comparator.comparing(entry -> entry.getKey().toString()));
            sortedEntitiesList.forEach(entry -> {
                ResourceLocation resourceLocation = entry.getKey();
                String resourceLocationString = resourceLocation.getResourceDomain() + ":"
                        + resourceLocation.getResourcePath();
                boolean containsBlacklistedWord = blacklist.stream().anyMatch(resourceLocationString::contains);
                if (!containsBlacklistedWord) {
                    itemList.add(ModNBTUtil.addNBTItem(item, "EntityName", resourceLocationString));
                }
            });
        }

        ENTITIES.clear();
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        if (!block.isReplaceable(worldIn, pos)) {
            pos = pos.offset(facing);
        }
        ItemStack itemstack = player.getHeldItem(hand);
        if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack)
                && worldIn.mayPlace(Blocks.MOB_SPAWNER, pos, false, facing, player)) {
            int i = this.getMetadata(itemstack.getMetadata());
            IBlockState iblockstate1 = Blocks.MOB_SPAWNER.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ,
                    i,
                    player, hand);
            if (placeBlockAt(itemstack, player, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate1)) {
                iblockstate1 = worldIn.getBlockState(pos);
                SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, player);
                worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS,
                        (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                itemstack.shrink(1);
            }
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
            float hitX, float hitY, float hitZ, IBlockState newState) {
        Entity entity = EntityList.createEntityByIDFromName(getCachedRegName(getEntityString(stack)),
                ClientUtils.getWorld());
        if (!world.setBlockState(pos, newState, 11))
            return false;
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.MOB_SPAWNER) {
            setTileEntityNBT(world, player, pos, stack);
            if (entity != null) {
                this.onBlockPlacedBy(world, pos, state, player, stack);
            } else {
                Blocks.MOB_SPAWNER.onBlockPlacedBy(world, pos, state, player, stack);
            }
            if (player instanceof EntityPlayerMP)
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos, stack);
        }
        return true;
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
            ItemStack stack) {
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) worldIn.getTileEntity(pos);
        if (tileentitymobspawner != null) {
            String mobtype = getEntityString(stack);
            if (mobtype != null) {
                tileentitymobspawner.getSpawnerBaseLogic().setEntityId(getCachedRegName(getEntityString(stack)));
            }
        }
    }

    public static boolean setTileEntityNBT(World worldIn, @Nullable EntityPlayer player, BlockPos pos,
            ItemStack stackIn) {
        MinecraftServer minecraftserver = worldIn.getMinecraftServer();
        if (minecraftserver == null) {
            return false;
        } else {
            NBTTagCompound nbttagcompound = stackIn.getSubCompound("BlockEntityTag");
            if (nbttagcompound != null) {
                TileEntity tileentity = worldIn.getTileEntity(pos);
                if (tileentity != null) {
                    if (!worldIn.isRemote && tileentity.onlyOpsCanSetNbt()
                            && (player == null || !player.canUseCommandBlock())) {
                        return false;
                    }
                    NBTTagCompound nbttagcompound1 = tileentity.writeToNBT(new NBTTagCompound());
                    NBTTagCompound nbttagcompound2 = nbttagcompound1.copy();
                    nbttagcompound1.merge(nbttagcompound);
                    nbttagcompound1.setInteger("x", pos.getX());
                    nbttagcompound1.setInteger("y", pos.getY());
                    nbttagcompound1.setInteger("z", pos.getZ());
                    if (!nbttagcompound1.equals(nbttagcompound2)) {
                        tileentity.readFromNBT(nbttagcompound1);
                        tileentity.markDirty();
                        return true;
                    }
                }
            }
            return false;
        }
    }
}