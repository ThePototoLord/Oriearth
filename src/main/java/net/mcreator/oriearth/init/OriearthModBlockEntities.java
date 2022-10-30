
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oriearth.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.oriearth.block.entity.IntensemoltenforgeblockBlockEntity;
import net.mcreator.oriearth.OriearthMod;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class OriearthModBlockEntities {
	public static BlockEntityType<?> INTENSEMOLTENFORGEBLOCK;

	public static void load() {
		INTENSEMOLTENFORGEBLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(OriearthMod.MODID, "intensemoltenforgeblock"),
				FabricBlockEntityTypeBuilder.create(IntensemoltenforgeblockBlockEntity::new, OriearthModBlocks.INTENSEMOLTENFORGEBLOCK).build(null));
	}
}
