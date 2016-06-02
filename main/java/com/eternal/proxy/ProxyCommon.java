package com.eternal.proxy;

import com.eternal.EternalBlocks;
import com.eternal.EternalItems;
import com.eternal.EternalRPG;
import com.eternal.EternalTabs;
import com.eternal.dimension.overworld.util.VillageComponentAlchemist;
import com.eternal.dimension.overworld.util.VillageHandlerAlchemist;
import com.eternal.dimension.overworld.util.VillagePieceRegister;
import com.eternal.registry.RegistryLang;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ProxyCommon {
	
	public void registerClient() {}
	public void clientInit(FMLInitializationEvent event) {}
	public void clientPreInit() {}
	
    @EventHandler
    public static void init(FMLInitializationEvent event) {
    	VillagePieceRegister.addVillagePiece(VillageComponentAlchemist.class, "AlchemistHut");
    	VillagePieceRegister.addVillageCreationHandler(new VillageHandlerAlchemist()); 
    }
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
		EternalTabs.init();    
		EternalBlocks.init();
		EternalItems.init();
		if (EternalRPG.DEV) RegistryLang.instance.register();
    }
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}
}
