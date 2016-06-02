package com.eternal.base;

import java.util.Random;

import com.dizzleAPI.Sc;
import com.eternal.EternalBlocks;
import com.eternal.EternalItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class ModOre extends ModBlock {

	public ModOre(String name, String finalName) {
		super(name, finalName);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1, Random par2, int par3) {
		if(this == EternalBlocks.frosticOre) return EternalItems.frosticCrystal;
		return Sc.itemToBlock(this);
	}
}
