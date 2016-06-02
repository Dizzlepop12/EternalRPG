package com.dizzleAPI;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class DizzleShortcuts {
	
	public static Item itemToBlock(Block block) {
		return Item.getItemFromBlock(block);
	}
}
