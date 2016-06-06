package com.eternal.blocks;

import com.dizzle_api.GuiHelper;
import com.eternal.EternalRPG;
import com.eternal.EternalTabs;
import com.eternal.base.ModBlock;
import com.eternal.base.ModBlockContainer;
import com.eternal.enums.EnumMaterial;
import com.eternal.enums.EnumSounds;
import com.eternal.tileentity.TileEntityInfusersTable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockInfusersTable extends ModBlockContainer {

	public BlockInfusersTable(String name, String f) {
		super(EnumMaterial.GLASS, name, f, 2.0F, EternalTabs.blocks);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote) return true;

		TileEntity te = worldIn.getTileEntity(pos);
		if(te == null || playerIn.isSneaking()) return false;
		playerIn.openGui(EternalRPG.instance, GuiHelper.infusers, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity instanceof TileEntityInfusersTable)
			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityInfusersTable)tileentity);
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityInfusersTable();
	}
}
