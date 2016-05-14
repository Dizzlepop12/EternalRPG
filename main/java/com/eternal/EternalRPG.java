package com.eternal;

import com.eternal.proxy.ProxyClientServer;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(name = EternalRPG.MOD_NAME, modid = EternalRPG.MODID, version = EternalRPG.VERSION)
public class EternalRPG {
	
	public static final String MOD_NAME = "Journey Into the Light";
    public static final String MODID = "eternalRPG";
    public static final String VERSION = "1.0";
    
    @Instance(EternalRPG.MODID)
    public static EternalRPG instance;
    
    @SidedProxy(clientSide = "com.eternal.proxy.ProxyClient", serverSide = "com.eternal.proxy.ProxyClientServer")
    public static ProxyClientServer proxy;
    public static SimpleNetworkWrapper wrapper;
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("EternalRPGNetwork");
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
