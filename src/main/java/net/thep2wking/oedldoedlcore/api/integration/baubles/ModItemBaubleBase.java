package net.thep2wking.oedldoedlcore.api.integration.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModItemBaubleBase extends ModItemBase implements IBauble, IRenderBauble {
    public final SoundEvent sound;
    public final BaubleType baubleType;
    public ModelBiped baubleModel;

    /**
     * @author TheP2WKing
     * @param modid           String
     * @param name            String
     * @param tab             {@link CreativeTabs}
     * @param sound           {@link SoundEvent}
     * @param baubleType      {@link BaubleType}
     * @param baubleModel     {@link ModelBiped}
     * @param rarity          {@link EnumRarity}
     * @param hasEffect       boolean
     * @param tooltipLines    int
     * @param annotationLines int
     */
    public ModItemBaubleBase(String modid, String name, CreativeTabs tab, SoundEvent sound, BaubleType baubleType,
            ModelBiped baubleModel, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
        super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
        this.sound = sound;
        this.baubleType = baubleType;
        this.baubleModel = baubleModel;
        setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        if (CoreConfig.PROPERTIES.BAUBLES.BAUBLE_USE_ANY_SLOT) {
            return BaubleType.TRINKET;
        }
        return baubleType;
    }

    @SuppressWarnings("null")
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {
            IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
            for (int i = 0; i < baubles.getSlots(); i++)
                if ((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty())
                        && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
                    baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
                    player.playSound(this.sound, 0.75f, 1f);
                    if (!player.capabilities.isCreativeMode) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    }
                    onEquipped(player.getHeldItem(hand), player);
                    break;
                }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        player.playSound(this.sound, 0.75f, 1f);
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        player.playSound(this.sound, 0.75f, 1f);
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getBaubleModel() {
        return baubleModel;
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(modid, "textures/models/bauble/" + name + ".png");
    }

    @Override
    public void onPlayerBaubleRender(ItemStack itemStack, EntityPlayer player, RenderType renderType,
            float partialTicks) {
        if (renderType != RenderType.HEAD)
            return;

        Minecraft.getMinecraft().renderEngine.bindTexture(getTexture());
        Helper.translateToHeadLevel(player);

        float s = 1.0F / 16F;
        GlStateManager.scale(s, s, s);
        GlStateManager.rotate(-90, 0, 1, 0);
        GlStateManager.translate(0, 26, 0);
        if (baubleModel == null)
            baubleModel = getBaubleModel();

        if (CoreConfig.PROPERTIES.BAUBLES.BAUBLE_RENDER) {
            baubleModel.bipedHead.render(1);
        }
    }
}