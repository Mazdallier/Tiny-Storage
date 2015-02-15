package com.timthebrick.tinystorage.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.timthebrick.tinystorage.core.TinyStorageLog;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		TinyStorageLog.info("Initialising Crafting Recipes");

		// Storage Upgrades
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemStorageUpgrade, 3, 0), "sss", "l l", "sss", 's', new ItemStack(Items.stick, 1), 'l', new ItemStack(Blocks.log, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0),
				new ItemStack(ModItems.itemStorageUpgrade, 1, 0));
		
		//Chest Filters
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemChestFilter, 3, 0), "sss", "l l", "sss", 's', new ItemStack(Items.stick, 1), 'l', new ItemStack(Items.string, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemChestFilter, 1, 1), new ItemStack(ModItems.itemChestFilter, 1, 0), new ItemStack(ModItems.itemChestFilter, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemChestFilter, 1, 2), new ItemStack(ModItems.itemChestFilter, 1, 1), new ItemStack(ModItems.itemChestFilter, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemChestFilter, 1, 2), new ItemStack(ModItems.itemChestFilter, 1, 0), new ItemStack(ModItems.itemChestFilter, 1, 0),
				new ItemStack(ModItems.itemChestFilter, 1, 0));

		// Tiny Chests
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestOakLog, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(Blocks.log, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestOakLog, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(Blocks.log, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestOakLog, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(Blocks.log, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestSpruceLog, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(Blocks.log, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestSpruceLog, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(Blocks.log, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestSpruceLog, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(Blocks.log, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestBirchLog, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(Blocks.log, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestBirchLog, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(Blocks.log, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestBirchLog, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(Blocks.log, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestJungleLog, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(Blocks.log, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestJungleLog, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(Blocks.log, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestJungleLog, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(Blocks.log, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestAcaciaLog, 1, 0), new ItemStack(ModItems.itemStorageUpgrade, 1, 0), new ItemStack(Blocks.log2, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestAcaciaLog, 1, 1), new ItemStack(ModItems.itemStorageUpgrade, 1, 1), new ItemStack(Blocks.log2, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockTinyChestAcaciaLog, 1, 2), new ItemStack(ModItems.itemStorageUpgrade, 1, 2), new ItemStack(Blocks.log2, 1, 0));
	}

}
