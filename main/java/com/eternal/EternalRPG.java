package com.eternal;

import com.eternal.proxy.ProxyCommon;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(
	name = EternalRPG.MOD_NAME, 
	modid = EternalRPG.MODID, 
	version = EternalRPG.VERSION)

public class EternalRPG {

	public static final String MOD_NAME = "EternalRPG";
	public static final String MODID = "eternalRPG";
	public static final String PREFIX = MODID + ":";
	public static final String VERSION = "1.0";
	public static final boolean DEV = true;

	@Instance
		(EternalRPG.MODID)
		public static EternalRPG instance;

	@SidedProxy(
		clientSide = "com.eternal.proxy.ProxyClient", 
		serverSide = "com.eternal.proxy.ProxyCommon")
	
	public static ProxyCommon proxy;
	public static SimpleNetworkWrapper wrapper;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("EternalRPGNetwork");
		proxy.preInit(event);
	}
}
