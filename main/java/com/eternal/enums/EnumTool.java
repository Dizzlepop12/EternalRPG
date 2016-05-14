package com.eternal.enums;

import net.minecraft.item.*;

public enum EnumTool {
    WOOD("pickaxe", Item.ToolMaterial.WOOD.getHarvestLevel()),
    GOLD("pickaxe", Item.ToolMaterial.GOLD.getHarvestLevel()),
    STONE("pickaxe", Item.ToolMaterial.STONE.getHarvestLevel()),
    IRON("pickaxe", Item.ToolMaterial.IRON.getHarvestLevel()),
    DIAMOND("pickaxe", Item.ToolMaterial.EMERALD.getHarvestLevel());
	
	private String toolType;
	private int harvestLevel;
	private EnumTool(String toolType, int harvestLevel) {
		this.toolType = toolType;
		this.harvestLevel = harvestLevel;
	}
	
	public String getType() {
		return toolType;
	}
	
	public int getLevel() {
		return harvestLevel;
	}
}
