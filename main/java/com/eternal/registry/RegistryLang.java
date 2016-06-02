package com.eternal.registry;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RegistryLang {

	public static RegistryLang instance = new RegistryLang();
	public String location = "C:/Users/Camden/Desktop/EternalRPG/src/EternalRPG/main/resources/assets/eternalRPG/lang/";
	private BufferedWriter writer;
	public static ArrayList<String> 
		blockUnloc = new ArrayList<String>(), 
		blockFinal = new ArrayList<String>(), 
		itemUnloc = new ArrayList<String>(), 
		itemFinal = new ArrayList<String>(), 
		fileText = new ArrayList<String>(),
		mobUnloc = new ArrayList<String>(), 
		mobFinal = new ArrayList<String>();
	
	public RegistryLang() {
		File lang = new File(location + "en_US.lang");
		try {
			lang.mkdirs();
			if(lang.exists()) lang.delete();
			lang.createNewFile();
			writer = new BufferedWriter(new FileWriter(lang));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void creativeTabs() {
		writeToFile("itemGroup.eternal.blocks=EternalRPG: Blocks");
		writeToFile("itemGroup.eternal.items=EternalRPG: Items");
	}
	
	public void achievements() {}
	
	public void achievementDescription() {}
	
	public void misc() {}

	public void register() {
		block();
		item();
		mob();
		creativeTabs();
		misc();
		achievements();
		achievementDescription();
		closeFile();
	}

	public static void addBlock(String unloc, String finalName) {
		blockUnloc.add(unloc);
		blockFinal.add(finalName);
	}

	public static void addItem(String unloc, String finalName) {
		itemUnloc.add(unloc);
		itemFinal.add(finalName);
	}

	public static void addMob(String unloc, String finalName) {
		mobUnloc.add("eternalRPG." + unloc);
		mobFinal.add(finalName);
	}
	
	public void block() {
		for(int i = 0; i < blockUnloc.size(); i++)
			writeToFile("tile." + blockUnloc.get(i) + ".name=" + blockFinal.get(i));
	}

	public void mob() {
		for(int i = 0; i < mobUnloc.size(); i++)
			writeToFile("entity." + mobUnloc.get(i) + ".name=" + mobFinal.get(i));
	}

	public void item() {
		for(int i = 0; i < itemUnloc.size(); i++)
			writeToFile("item." + itemUnloc.get(i) + ".name=" + itemFinal.get(i));
	}

	private void writeToFile(String s) {
		try {
			instance.writer.write(s + "\n");
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

	private void closeFile() {
		try {
			instance.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}