package com.dizzle_api;

import com.eternal.container.ContainerInfusers;
import com.eternal.container.gui.GuiInfusersTable;
import com.eternal.tileentity.TileEntityInfusersTable;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World; 
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHelper implements IGuiHandler {
	
	public static int id = 0;
	public static int 
	infusers = id++;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(ID == infusers) return new ContainerInfusers(player.inventory, (TileEntityInfusersTable)entity, world);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(ID == infusers) return new GuiInfusersTable(player.inventory, (TileEntityInfusersTable)entity, world);
		return null;
	}
}
