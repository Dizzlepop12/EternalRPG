package com.eternal;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EternalTabs extends CreativeTabs {
	
	public static final EternalTabs blocks = new EternalTabs("eternal.blocks");

	public Item item;
	
	public EternalTabs(String name) {
		super(name);
	}
	
	public void setIcon(Item item) {
		this.item = item;
	}
	
	public void setIcon(Block block) {
		this.item = Item.getItemFromBlock(block);
	}
    
    public void setIcon(ItemStack icon) {
        this.item = icon.getItem();
    }
	
	@Override
	public Item getTabIconItem() {
		return item;
	}
	
	public static void init() {
		blocks.setIcon(Blocks.anvil);
	}
}
