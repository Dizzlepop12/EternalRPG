package com.eternal.proxy;

import com.eternal.EternalBlocks;
import com.eternal.EternalRPG;
import com.eternal.EternalTabs;
import com.eternal.registry.RegistryLang;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ProxyCommon {
	
	public void registerClient() {}
	public void clientInit(FMLInitializationEvent event) {}
	public void clientPreInit() {}
	
    @EventHandler
    public static void init(FMLInitializationEvent event) {}
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
		EternalTabs.init();    
		EternalBlocks.init();
		if (EternalRPG.DEV) RegistryLang.instance.register();
    }
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}
}
