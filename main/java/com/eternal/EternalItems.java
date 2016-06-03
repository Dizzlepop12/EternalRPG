package com.eternal;

import java.util.ArrayList;

import com.eternal.base.ItemMod;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class EternalItems {
	
	public static ArrayList<String> itemNames = new ArrayList<String>();
	
	public static final Item frosticCrystal = new ItemMod("frosticCrystal", "Frostic Crystal");

	public static void init(){}
}
