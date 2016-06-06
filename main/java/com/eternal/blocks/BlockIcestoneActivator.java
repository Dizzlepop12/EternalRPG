package com.eternal.blocks;

import com.eternal.EternalBlocks;
import com.eternal.EternalTabs;
import com.eternal.base.ModBlock;
import com.eternal.enums.EnumMaterial;
import com.eternal.enums.EnumSounds;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockIcestoneActivator extends ModBlock {

	public BlockIcestoneActivator(String name, String finalName) {
		super(EnumMaterial.GLASS, finalName, finalName, EternalTabs.blocks);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(worldIn.getBlockState(pos.up()).getBlock() == Blocks.coal_ore && playerIn.getHeldItem() !=null && playerIn.getHeldItem().getItem() == Items.blaze_rod) {
			worldIn.setBlockState(pos.add(0, 0, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 1, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 2, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 3, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.setBlockState(pos.add(0, 3, 0), EternalBlocks.testUnbreakable.getDefaultState());
			worldIn.newExplosion((Entity)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, true);
			EnumSounds.playSound(EnumSounds.PORTAL_CREATION, worldIn, playerIn);
			return true;
		}
		return false;
	}
}
