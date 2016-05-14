package com.eternal.base;

import java.util.Random;

import com.eternal.EternalBlocks;
import com.eternal.EternalRPG;
import com.eternal.EternalTabs;
import com.eternal.enums.EnumMaterial;
import com.eternal.enums.EnumTool;
import com.eternal.registry.RegistryLang;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EternalBlock extends Block {

	private EnumMaterial blockType;
	private Item drop = null;
	private Random rand;
	public int lightLow, lightHigh;
	public boolean brightness;
	public String name;
	private boolean isOpaque = true, isNormalCube = true;
	
	public EternalBlock(String name, String finalName, float hardness) {
		this(EnumMaterial.ROCK, name, finalName, hardness, EternalTabs.blocks);
	}

	public EternalBlock(String name, String finalName) {
		this(EnumMaterial.ROCK, name, finalName, 2.0F, EternalTabs.blocks);
	}

	public EternalBlock(EnumMaterial type, String name, String finalName, float hardness) {
		this(type, name, finalName, hardness, EternalTabs.blocks);
	}

	public EternalBlock(String name, String finalName, boolean breakable, CreativeTabs tab) {
		this(EnumMaterial.ROCK, name, finalName, tab);
	}

	public EternalBlock(String name, String finalName, boolean breakable) {
		this(name, finalName, breakable, EternalTabs.blocks);
	}

	public EternalBlock(EnumMaterial blockType, String name, String finalName, CreativeTabs tab) {
		super(blockType.getBlockType());
		RegistryLang.addBlock(name, finalName);
		this.blockType = blockType;
		setHardness(2.0F);
		rand = new Random();
		setStepSound(blockType.getSoundType());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		this.name = name; 
		EternalBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public EternalBlock(EnumMaterial blockType, String name, String finalName, float hardness, CreativeTabs tab) {
		super(blockType.getBlockType());
		RegistryLang.addBlock(name, finalName);
		this.blockType = blockType;
		rand = new Random();
		setStepSound(blockType.getSoundType());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setHardness(hardness);
		this.name = name;
		EternalBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public Block addName(String name) {
		EternalBlocks.blockName.add(name);
		return this;
	}

	public String getName() {
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(drop == null) return EternalRPG.itemToBlock(this);
		return drop;
	}

	public EternalBlock setHarvestLevel(EnumTool tool) {
		setHarvestLevel(tool.getType(), tool.getLevel());
		return this;
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.SOLID;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return isOpaque;
	}

	@Override
	public boolean isNormalCube() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, BlockPos pos, IBlockState state, Random random) {}

	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		return true;
	}
}