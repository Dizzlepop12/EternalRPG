package com.eternal.base;

import java.util.List;

import com.eternal.EternalItems;
import com.eternal.EternalTabs;
import com.eternal.enums.EnumSounds;
import com.eternal.registry.RegistryLang;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMod extends Item {
	
	protected int healAmount = 0;

	public ItemMod(String name, String finalName){
		this(name, finalName, EternalTabs.items);
	}

	public ItemMod(String name, String finalName, CreativeTabs tab){
		RegistryLang.addItem(name, finalName);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		EternalItems.itemNames.add(name);
		GameRegistry.registerItem(this, name);
	}

	public ItemMod setHealAmount(int healAmount){
		this.healAmount = healAmount;
		return this;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(healAmount != 0){
			if(player.getHealth() < player.getMaxHealth()){
				player.heal(healAmount);
				player.inventory.consumeInventoryItem(this);
			}
		}
		return stack;
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, boolean magic, String sound, boolean damage, ItemStack item, int dam) {
		if(!w.isRemote){
			if(magic) w.spawnEntityInWorld(entity);
		}
		if(magic) {
			EnumSounds.playSound(sound, w, p);
			if(damage) item.damageItem(dam, p);
		}
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, String sound, boolean damage, ItemStack item, int dam) {
		if(!w.isRemote){
			w.spawnEntityInWorld(entity);
			EnumSounds.playSound(sound, w, p);
			if(damage) item.damageItem(dam, p);
		}
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, boolean magic, String sound) {
		spawnEntityIntoWorld(w, p, entity, magic, sound, false, new ItemStack(Items.apple), 0);
	}
	

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list){ }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean par4) {
		addInformation(item, player, list);
	}
}
