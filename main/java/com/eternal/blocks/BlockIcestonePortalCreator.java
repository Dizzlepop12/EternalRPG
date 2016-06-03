package com.eternal.blocks;

import com.dizzle_api.GuiHelper.GuiIDs;
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

public class BlockIcestonePortalCreator extends ModBlockContainer {

	public BlockIcestonePortalCreator(String name, String f) {
		super(EnumMaterial.GLASS, name, f, 2.0F, EternalTabs.blocks);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityInfusersTable tile = (TileEntityInfusersTable)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote) {
			if(tile != null) { 
				playerIn.openGui(EternalRPG.instance, GuiIDs.INFUSERS.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			return true;
		}
		
		else if(worldIn.getBlockState(pos.up()).getBlock() == Blocks.coal_ore && playerIn.getHeldItem() !=null && playerIn.getHeldItem().getItem() == Items.blaze_rod) {
			worldIn.setBlockState(pos.add(0, 0, 0), Blocks.bookshelf.getDefaultState());
			worldIn.newExplosion((Entity)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, true);
            EnumSounds.playSound(EnumSounds.PORTAL_CREATION, worldIn, playerIn);
			return true;
		}
		return false;
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
