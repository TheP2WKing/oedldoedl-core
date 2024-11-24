package net.thep2wking.oedldoedlcore.api.bauble;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

/**
 * @author TheP2WKing
 */
public abstract class ModItemBaubleBase extends ModItemBase implements IBauble, IRenderBauble {
    public final SoundEvent sound;
    public final BaubleType baubleType;
    public final boolean isBodyModel;

    /**
     * @author TheP2WKing
     * @param modid           String
     * @param name            String
     * @param tab             {@link CreativeTabs}
     * @param sound           {@link SoundEvent}
     * @param baubleType      {@link BaubleType}
     * @param isBodyModel     boolean
     * @param rarity          {@link EnumRarity}
     * @param hasEffect       boolean
     * @param tooltipLines    int
     * @param annotationLines int
     */
    public ModItemBaubleBase(String modid, String name, CreativeTabs tab, SoundEvent sound, BaubleType baubleType,
            boolean isBodyModel, EnumRarity rarity, boolean hasEffect, int tooltipLines,
            int annotationLines) {
        super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
        this.sound = sound;
        this.baubleType = baubleType;
        this.isBodyModel = isBodyModel;
        setMaxStackSize(1);
    }

    private boolean hasBaubleRender = true;

    public ModItemBaubleBase setNoRender() {
        hasBaubleRender = false;
        return this;
    }

    public boolean hasBaubleRender() {
        return hasBaubleRender;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return this.baubleType;
    }

    public void getEquipmentSound(EntityLivingBase player) {
        player.playSound(sound, 0.75f, 0.9f);
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    public double armor;
    public double armorToughness;

    public ModItemBaubleBase setArmorValues(double armor, double armorToughness) {
        this.armor = armor;
        this.armorToughness = armorToughness;
        return this;
    }

    public abstract boolean hasAttributeModifier();

    public Multimap<IAttribute, AttributeModifier> getBaubleAttributeModifiers() {
        Multimap<IAttribute, AttributeModifier> multimap = LinkedListMultimap.create();
        if (armorToughness != 0) {
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS, new AttributeModifier(
                    ModReferences.ATTRIBUTE_ARMOR_TOUGHNESS, armorToughness, AttributeModifierOperation.ADD));
        }
        if (armor != 0) {
            multimap.put(SharedMonsterAttributes.ARMOR,
                    new AttributeModifier(ModReferences.ATTRIBUTE_ARMOR, armor, AttributeModifierOperation.ADD));
        }
        return multimap;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        IBaublesItemHandler itemHandler = BaublesApi.getBaublesHandler(player);
        ItemStack stack = player.getHeldItem(hand);
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null) {
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        for (IAttribute attribute : this.getBaubleAttributeModifiers().keySet()) {
            String key = attribute.getName();
            UUID uuid = nbt.hasUniqueId(key) ? nbt.getUniqueId(key) : UUID.randomUUID();
            nbt.setUniqueId(key, uuid);
        }
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            if (itemHandler.getStackInSlot(i).isEmpty() && itemHandler.isItemValidForSlot(i, stack, player)) {
                ItemStack itemToEquip = stack.copy();
                itemToEquip.setTagCompound(nbt);
                itemHandler.setStackInSlot(i, itemToEquip);
                if (!player.capabilities.isCreativeMode) {
                    stack.setCount(0);
                }
                this.onEquipped(itemToEquip, player);
                return new ActionResult<>(EnumActionResult.SUCCESS, stack);
            }
        }
        return new ActionResult<>(EnumActionResult.FAIL, stack);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        this.getEquipmentSound(player);
        if (!player.world.isRemote && this.hasAttributeModifier()) {
            NBTTagCompound nbt = itemstack.getTagCompound();
            if (nbt == null) {
                nbt = new NBTTagCompound();
                itemstack.setTagCompound(nbt);
            }
            for (IAttribute attribute : this.getBaubleAttributeModifiers().keySet()) {
                String key = attribute.getName();
                UUID uuid = nbt.hasUniqueId(key) ? nbt.getUniqueId(key) : UUID.randomUUID();
                nbt.setUniqueId(key, uuid);
                IAttributeInstance attributeInstance = player.getEntityAttribute(attribute);
                if (uuid != null && attribute != null && attributeInstance.getModifier(uuid) == null) {
                    for (AttributeModifier modifier : this.getBaubleAttributeModifiers().get(attribute)) {
                        modifier = new AttributeModifier(uuid, modifier.getName(), modifier.getAmount(),
                                modifier.getOperation());
                        attributeInstance.applyModifier(modifier);
                    }
                }
            }
        }
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        this.getEquipmentSound(player);
        if (!player.world.isRemote) {
            NBTTagCompound nbt = itemstack.getTagCompound();
            if (nbt != null) {
                for (IAttribute attribute : this.getBaubleAttributeModifiers().keySet()) {
                    String key = attribute.getName();
                    UUID uuid = nbt.getUniqueId(key);
                    IAttributeInstance attributeInstance = player.getEntityAttribute(attribute);
                    for (AttributeModifier modifier : this.getBaubleAttributeModifiers().get(attribute)) {
                        if (uuid != null && attributeInstance.getModifier(uuid) != null) {
                            modifier = new AttributeModifier(uuid, modifier.getName(), modifier.getAmount(),
                                    modifier.getOperation());
                            attributeInstance.removeModifier(modifier);
                        }
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped baubleModel;

    @SideOnly(Side.CLIENT)
    public abstract ModelBiped getBaubleModel();

    @SideOnly(Side.CLIENT)
    public ResourceLocation getTexture() {
        return new ResourceLocation(modid, "textures/models/bauble/" + name + ".png");
    }

    @SideOnly(Side.CLIENT)
    public float getScaleFactor() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public double getEyeOffset() {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onPlayerBaubleRender(ItemStack itemStack, EntityPlayer player, RenderType renderType,
            float partialTicks) {
        if (!this.isBodyModel && this.hasBaubleRender() && this.getBaubleModel() != null
                && renderType == RenderType.HEAD) {
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(getTexture());
            Helper.translateToHeadLevel(player);

            float scaleFactor = getScaleFactor();
            float s = 1.0F / 16.0F;
            GlStateManager.scale(s * scaleFactor, s * scaleFactor, s * scaleFactor);
            GlStateManager.rotate(-90, 0, 1, 0);

            // rendering of baubles is slighty offset (default = y26)
            float eyeOffset = (float) getEyeOffset();
            if (!player.isSneaking()) {
                GlStateManager.translate(0, 26.075 - eyeOffset, 0);
            } else {
                GlStateManager.translate(0, 26.125 - eyeOffset, 0);
            }

            GlStateManager.enableLighting();
            GlStateManager.enableRescaleNormal();

            if (baubleModel == null)
                baubleModel = getBaubleModel();

            if (this.hasBaubleRender()) {
                baubleModel.bipedHead.render(1);
                baubleModel.setRotationAngles(player.limbSwing, player.limbSwingAmount, player.ticksExisted,
                        player.cameraYaw, player.cameraPitch, s, player);
                if (this.hasEffect(itemStack)) {
                    this.renderEnchantmentGlint(player, baubleModel, 1, false);
                }
            }

            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
        } else if (this.isBodyModel && this.hasBaubleRender() && this.getBaubleModel() != null
                && renderType == RenderType.BODY) {
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(getTexture());
            Helper.rotateIfSneaking(player);

            float scaleFactor = getScaleFactor();
            float s = 1.0F / 16.0F;
            GlStateManager.scale(s * scaleFactor, s * scaleFactor, s * scaleFactor);
            float eyeOffset = (float) getEyeOffset();
            GlStateManager.translate(0, 0 - eyeOffset, 0);

            GlStateManager.enableLighting();
            GlStateManager.enableRescaleNormal();

            if (baubleModel == null)
                baubleModel = getBaubleModel();

            if (this.hasBaubleRender()) {
                baubleModel.bipedBody.render(1);
                baubleModel.setRotationAngles(player.limbSwing, player.limbSwingAmount, player.ticksExisted,
                        player.cameraYaw, player.cameraPitch, s, player);
                if (this.hasEffect(itemStack)) {
                    this.renderEnchantmentGlint(player, baubleModel, 1, true);
                }
            }

            // GlStateManager.disableColorMaterial();
            GlStateManager.disableRescaleNormal();
            // GlStateManager.disableLighting();
            GlStateManager.popMatrix();
        }
    }

    private void renderEnchantmentGlint(EntityPlayer player, ModelBiped baubleModel, float s, boolean isBody) {
        GlStateManager.pushMatrix();
        GlStateManager.depthFunc(GL11.GL_EQUAL);
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
        GlStateManager.color(0.5F, 0.25F, 0.8F, 1.0F);
        ResourceLocation ENCHANTED_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        Minecraft.getMinecraft().getTextureManager().bindTexture(ENCHANTED_ITEM_GLINT);
        GlStateManager.matrixMode(GL11.GL_TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.scale(8.0F, 8.0F, 8.0F);
        float f = (float) (Minecraft.getSystemTime() % 3000L) / 3000.0F / 8.0F;
        GlStateManager.translate(f, 0.0F, 0.0F);
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        if (!isBody) {
            baubleModel.bipedHead.render(1);
            baubleModel.setRotationAngles(player.limbSwing, player.limbSwingAmount, player.ticksExisted,
                    player.cameraYaw, player.cameraPitch, s, player);
        } else {
            baubleModel.bipedBody.render(1);
            baubleModel.setRotationAngles(player.limbSwing, player.limbSwingAmount, player.ticksExisted,
                    player.cameraYaw, player.cameraPitch, s, player);
        }
        GlStateManager.matrixMode(GL11.GL_TEXTURE);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(GL11.GL_LEQUAL);
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

    private void addAttributeHeader(List<String> tooltip) {
        if (!this.getBaubleAttributeModifiers().isEmpty()) {
            TextComponentTranslation headerComponent = new TextComponentTranslation(
                    "baubles." + OedldoedlCore.MODID + ".attribute");
            headerComponent.getStyle().setColor(TextFormatting.GRAY);
            tooltip.add("");
            tooltip.add(headerComponent.getFormattedText());
        }
    }

    private void addAttibuteInformation(List<String> tooltipIn) {
        for (IAttribute attribute : this.getBaubleAttributeModifiers().keySet()) {
            for (AttributeModifier modifier : this.getBaubleAttributeModifiers().get(attribute)) {
                TextComponentString attributeComponent = new TextComponentString(" ");
                TextComponentTranslation attributeNameComponent = new TextComponentTranslation(
                        "attribute.name." + attribute.getName());

                double amount = modifier.getAmount();
                if (modifier.getOperation() == 1 || modifier.getOperation() == 2) {
                    amount *= 100;
                }

                String formattedAmount = (amount % 1 == 0) ? String.format("%d", (int) amount)
                        : String.format("%.1f", amount);

                TextComponentTranslation operationComponent = new TextComponentTranslation(
                        this.getOperationComponent(modifier.getOperation()).getKey(), formattedAmount,
                        attributeNameComponent);

                attributeComponent.getStyle().setColor(TextFormatting.BLUE);
                attributeComponent.appendSibling(operationComponent);
                tooltipIn.add(attributeComponent.getFormattedText());
            }
        }
    }

    private TextComponentTranslation getOperationComponent(int operationType) {
        switch (operationType) {
            case 0:
                return new TextComponentTranslation("attribute.modifier.plus.0");
            case 1:
                return new TextComponentTranslation("attribute.modifier.plus.1");
            case 2:
                return new TextComponentTranslation("attribute.modifier.plus.2");
            default:
                return new TextComponentTranslation("attribute.modifier.unknown");
        }
    }

    public void addDefaultAttributeInformation(List<String> tooltip) {
        if (this.hasAttributeModifier()) {
            this.addAttributeHeader(tooltip);
            this.addAttibuteInformation(tooltip);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (ModTooltips.showAnnotationTip()) {
            for (int i = 1; i <= annotationLines; ++i) {
                ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), i);
            }
        }
        if (ModTooltips.showInfoTip()) {
            for (int i = 1; i <= tooltipLines; ++i) {
                ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
            }
        } else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
            ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
        }

        addDefaultAttributeInformation(tooltip);
    }
}