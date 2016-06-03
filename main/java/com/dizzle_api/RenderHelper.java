package com.dizzle_api;

import org.lwjgl.opengl.GL11;

import com.eternal.EternalRPG;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHelper {
	
	@SideOnly(Side.CLIENT)
	public static void renderItem(ItemStack stack, double x, double y, double z, float scale) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		if(stack != null) {
			GL11.glTranslated(x, y, z);
			GL11Helper.scale(scale);
			renderItem.renderItemModelForEntity(stack, null, null);
		}
	}
	
	public static void registerModelBakery(Item i, String[] names) {
		ModelBakery.addVariantName(i, names);
	}

	public static void registerModelBakery(Block b, String[] names) {
		ModelBakery.addVariantName(Sc.itemToBlock(b), names);
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemRender(Item item, int metadata, String itemName) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(item, metadata, new ModelResourceLocation(EternalRPG.PREFIX + itemName, "inventory"));
	}

	public static void registerBlockRender(Block block, int metadata, String blockName) {
		registerItemRender(Item.getItemFromBlock(block), metadata, blockName);
	}

	public static void registerItemRender(Item item, String itemName) {
		registerItemRender(item, 0, itemName);		
	}
	
	public static void init() {}
}
