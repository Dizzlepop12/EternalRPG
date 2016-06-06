package com.eternal;

import java.util.ArrayList;

import com.eternal.base.ModBlock;
import com.eternal.base.ModOre;
import com.eternal.blocks.BlockIcestoneActivator;
import com.eternal.blocks.BlockInfusersTable;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.ModelLoader;

public class EternalBlocks {
	
	public static ArrayList <String> blockName = new ArrayList <String>();
	
	public static final Block frosticOre = new ModOre("frosticOre", "Frostic Ore");
	public static final Block infusersTable = new BlockInfusersTable("infusersTable", "Infusers Table");
	public static final Block IcestoneActivator = new BlockIcestoneActivator("icestoneActivator", "Icestone Activator");
	public static final Block testUnbreakable = new ModBlock("testffef", "edededed").setResistance(10000000).setBlockUnbreakable();
	
	public static void init(){}
}
