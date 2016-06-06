package com.eternal.enums;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;

public enum EnumMaterial {

	ROCK(Material.rock, Block.soundTypeStone),
	GRASS_ROUGH(Material.rock, Block.soundTypeGrass),
	DIRT_ROUGH(Material.rock, Block.soundTypeGravel),
	WOOD_ROUGH(Material.rock, Block.soundTypeWood),
	GLASS_ROUGH(Material.rock, Block.soundTypeGlass),
	SNOW_ROUGH(Material.rock, Block.soundTypeSnow),
	WOOL_ROUGH(Material.rock, Block.soundTypeCloth),
	
	ROCK_UNBREAK(Material.barrier, Block.soundTypeStone),
	GRASS_UNBREAK(Material.barrier, Block.soundTypeGrass),
	DIRT_UNBREAK(Material.barrier, Block.soundTypeGravel),
	WOOD_UNBREAK(Material.barrier, Block.soundTypeWood),
	GLASS_UNBREAK(Material.barrier, Block.soundTypeGlass),
	SNOW_UNBREAK(Material.barrier, Block.soundTypeSnow),
	WOOL_UNBREAK(Material.barrier, Block.soundTypeCloth),
	
	GRASS(Material.grass, Block.soundTypeGrass),
	DIRT(Material.ground, Block.soundTypeGravel),
	WOOD(Material.wood, Block.soundTypeWood),
	GLASS(Material.glass, Block.soundTypeGlass),
	SNOW(Material.snow, Block.soundTypeSnow),
	WOOL(Material.cloth, Block.soundTypeCloth);
	
	private Material material;
	private SoundType sound;
	
	public Material getBlockType() {
		return material;
	}
	
	public SoundType getSoundType() {
		return sound;
	}
	
	private EnumMaterial(Material material, SoundType sound) {
		this.material = material;
		this.sound = sound;
	}
}
