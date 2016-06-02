package com.eternal.dimension.overworld.util; 

import java.util.List; 
import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight; 
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler; 

public class VillageHandlerAlchemist implements IVillageCreationHandler { 
	
	@Override
	public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) { 
		return new StructureVillagePieces.PieceWeight(VillageComponentAlchemist.class, 15, i + random.nextInt(3));
	} 

	@Override
	public Class<?> getComponentClass() { 
		return VillageComponentAlchemist.class; 
	} 

	@Override
	public Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, EnumFacing p4, int p5) { 
		return VillageComponentAlchemist.build(startPiece, pieces, random, p1, p2, p3, p4, p5); 
	} 
}