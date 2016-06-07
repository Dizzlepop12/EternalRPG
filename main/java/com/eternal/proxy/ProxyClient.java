package com.eternal.proxy;

import com.dizzle_api.GuiHelper;
import com.dizzle_api.RenderHelper;
import com.eternal.EternalBlocks;
import com.eternal.EternalItems;
import com.eternal.EternalRPG;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ProxyClient extends ProxyCommon{

	@Override
	public void registerClient() {
		NetworkRegistry.INSTANCE.registerGuiHandler(EternalRPG.instance, new GuiHelper());
	}
	
	@Override
	public void clientPreInit() {}
	
	@Override
	public void registerModModels() {
		for(String s : EternalBlocks.blockName) {
			Item i = GameRegistry.findItem(EternalRPG.MODID, s);
			RenderHelper.registerItemRender(i, s);
		}

		for(String s : EternalItems.itemNames) {
			Item i = GameRegistry.findItem(EternalRPG.MODID, s);
			RenderHelper.registerItemRender(i, s);
		}
	}
}
