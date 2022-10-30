
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oriearth.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.oriearth.item.TotemofhealthItem;
import net.mcreator.oriearth.item.RicenoodlesItem;
import net.mcreator.oriearth.item.RicebowlItem;
import net.mcreator.oriearth.item.ReinforcednetheriteswordcaskItem;
import net.mcreator.oriearth.item.ReinforcednetheriteswordItem;
import net.mcreator.oriearth.item.ReinforcednetheritepickaxeItem;
import net.mcreator.oriearth.item.DognoodlestewItem;
import net.mcreator.oriearth.item.DogmeatItem;
import net.mcreator.oriearth.item.DogdropItem;
import net.mcreator.oriearth.OriearthMod;

public class OriearthModItems {
	public static Item DOGMEAT;
	public static Item DOGDROP;
	public static Item REINFORCEDNETHERITESWORD;
	public static Item TOTEMOFHEALTH;
	public static Item DOGNOODLESTEW;
	public static Item RICEBOWL;
	public static Item RICENOODLES;
	public static Item REINFORCEDNETHERITESWORDCASK;
	public static Item INTENSEMOLTENFORGEBLOCK;
	public static Item REINFORCEDNETHERITEPICKAXE;

	public static void load() {
		DOGMEAT = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "dogmeat"), new DogmeatItem());
		DOGDROP = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "dogdrop"), new DogdropItem());
		REINFORCEDNETHERITESWORD = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "reinforcednetheritesword"),
				new ReinforcednetheriteswordItem());
		TOTEMOFHEALTH = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "totemofhealth"), new TotemofhealthItem());
		DOGNOODLESTEW = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "dognoodlestew"), new DognoodlestewItem());
		RICEBOWL = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "ricebowl"), new RicebowlItem());
		RICENOODLES = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "ricenoodles"), new RicenoodlesItem());
		REINFORCEDNETHERITESWORDCASK = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "reinforcednetheriteswordcask"),
				new ReinforcednetheriteswordcaskItem());
		INTENSEMOLTENFORGEBLOCK = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "intensemoltenforgeblock"),
				new BlockItem(OriearthModBlocks.INTENSEMOLTENFORGEBLOCK, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		REINFORCEDNETHERITEPICKAXE = Registry.register(Registry.ITEM, new ResourceLocation(OriearthMod.MODID, "reinforcednetheritepickaxe"),
				new ReinforcednetheritepickaxeItem());
	}
}