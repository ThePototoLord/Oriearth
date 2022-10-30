
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oriearth.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.oriearth.block.IntensemoltenforgeblockBlock;
import net.mcreator.oriearth.OriearthMod;

public class OriearthModBlocks {
	public static Block INTENSEMOLTENFORGEBLOCK;

	public static void load() {
		INTENSEMOLTENFORGEBLOCK = Registry.register(Registry.BLOCK, new ResourceLocation(OriearthMod.MODID, "intensemoltenforgeblock"),
				new IntensemoltenforgeblockBlock());
	}

	public static void clientLoad() {
		IntensemoltenforgeblockBlock.clientInit();
	}
}
