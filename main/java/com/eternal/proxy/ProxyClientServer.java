package com.eternal.proxy;

import com.eternal.EternalTabs;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ProxyClientServer {
	
	public void registerClient() {}
	public void clientInit(FMLInitializationEvent event) {}
	public void clientPreInit() {}
	
    @EventHandler
    public static void init(FMLInitializationEvent event) {}
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
		EternalTabs.init();    
    }
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}
}
