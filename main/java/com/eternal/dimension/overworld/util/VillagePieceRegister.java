package com.eternal.dimension.overworld.util;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class VillagePieceRegister {
	
	public static void addVillagePiece(Class className, String structureName) { 
		try { 
			MapGenStructureIO.registerStructure(className, structureName); 
		} 
		catch (Exception e) {

		}
	}

	public static void addVillageCreationHandler(VillagerRegistry.IVillageCreationHandler v) { 
    	VillagerRegistry.instance().registerVillageCreationHandler(v); 
    }
}
