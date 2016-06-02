package com.eternal.dimension.overworld.util; 

import java.util.List; 
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks; 
import net.minecraft.init.Items; 
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent; 
import net.minecraft.world.World; 
import net.minecraft.world.gen.structure.StructureBoundingBox; 
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start; 
import net.minecraft.world.gen.structure.StructureVillagePieces.Village; 

public class VillageComponentAlchemist extends StructureVillagePieces.Village { 
	private int averageGroundLevel = -1; 

	public VillageComponentAlchemist(StructureVillagePieces.Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, EnumFacing par5) { 
		this.coordBaseMode = par5; 
		this.boundingBox = par4StructureBoundingBox; 
	} 

	public static final WeightedRandomChestContent[] test = { 
			new WeightedRandomChestContent(Items.apple, 0, 1, 4, 85), 
			new WeightedRandomChestContent(Items.book, 0, 1, 2, 35), 
			new WeightedRandomChestContent(Items.flint_and_steel, 0, 1, 1, 2) }; 
	private boolean hasMadeChest; 

	@Override
	protected void writeStructureToNBT(NBTTagCompound par1NBTTagCompound) { 
		super.writeStructureToNBT(par1NBTTagCompound); 
		par1NBTTagCompound.setBoolean("alchemistCreatedChest", this.hasMadeChest); 
	} 

	@Override
	protected void readStructureFromNBT(NBTTagCompound par1NBTTagCompound) { 
		super.readStructureFromNBT(par1NBTTagCompound); 
		this.hasMadeChest = par1NBTTagCompound.getBoolean("alchemistCreatedChest"); 
	} 

	public static VillageComponentAlchemist build(StructureVillagePieces.Start start, List<StructureComponent> piece, Random rand, int par1, int par2, int par3, EnumFacing facing, int par4) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par1, par2, par3, 0, 0, 0, 4, 6, 5, facing);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(piece, structureboundingbox) == null ? new VillageComponentAlchemist(start, par4, rand, structureboundingbox, facing) : null;
    }

	private static int widX = 9; 
	private static int heiY = 7; 
	private static int lenZ = 11; 

	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) { 
		spawnVillagers(world, sbb, 2, 3, 5, 1); 
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(world, sbb);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
        }

        this.fillWithBlocks(world, sbb, 1, 1, 1, 3, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 0, 0, 0, 3, 0, 4, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 1, 0, 1, 2, 0, 3, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);

        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 1, 4, 0, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 2, 4, 0, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 1, 4, 4, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 2, 4, 4, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 0, 4, 1, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 0, 4, 2, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 0, 4, 3, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 3, 4, 1, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 3, 4, 2, sbb);
        this.setBlockState(world, Blocks.diamond_block.getDefaultState(), 3, 4, 3, sbb);
        this.fillWithBlocks(world, sbb, 0, 1, 0, 0, 3, 0, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 3, 1, 0, 3, 3, 0, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 0, 1, 4, 0, 3, 4, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 3, 1, 4, 3, 3, 4, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 0, 1, 1, 0, 3, 3, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 3, 1, 1, 3, 3, 3, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 1, 1, 0, 2, 3, 0, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.fillWithBlocks(world, sbb, 1, 1, 4, 2, 3, 4, Blocks.diamond_block.getDefaultState(), Blocks.diamond_block.getDefaultState(), false);
        this.setBlockState(world, Blocks.glass_pane.getDefaultState(), 0, 2, 2, sbb);
        this.setBlockState(world, Blocks.glass_pane.getDefaultState(), 3, 2, 2, sbb);

        this.setBlockState(world, Blocks.air.getDefaultState(), 1, 1, 0, sbb);
        this.setBlockState(world, Blocks.air.getDefaultState(), 1, 2, 0, sbb);
        this.placeDoorCurrentPosition(world, sbb, random, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

        if (this.getBlockStateFromPos(world, 1, 0, -1, sbb).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world, 1, -1, -1, sbb).getBlock().getMaterial() != Material.air)
        {
            this.setBlockState(world, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 0, -1, sbb);
        }

        for (int i = 0; i < 5; ++i)
        {
            for (int j = 0; j < 4; ++j)
            {
                this.clearCurrentPositionBlocksUpwards(world, j, 6, i, sbb);
                this.replaceAirAndLiquidDownwards(world, Blocks.diamond_block.getDefaultState(), j, -1, i, sbb);
            }
        }

        this.spawnVillagers(world, sbb, 1, 1, 2, 1);
        return true;
	} 

	public int getVillagerType(int i) { 
		return 99; 
	} 
} 