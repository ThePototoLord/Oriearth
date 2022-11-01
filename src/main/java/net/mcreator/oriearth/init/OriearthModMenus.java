
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oriearth.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.oriearth.world.inventory.IntensemoltenforgeMenu;
import net.mcreator.oriearth.world.inventory.AccessoriesMenu;
import net.mcreator.oriearth.client.gui.IntensemoltenforgeScreen;
import net.mcreator.oriearth.client.gui.AccessoriesScreen;
import net.mcreator.oriearth.OriearthMod;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

public class OriearthModMenus {
	public static MenuType<AccessoriesMenu> ACCESSORIES;
	public static MenuType<IntensemoltenforgeMenu> INTENSEMOLTENFORGE;

	public static void load() {
		ACCESSORIES = ScreenHandlerRegistry.registerExtended(new ResourceLocation(OriearthMod.MODID, "accessories"), AccessoriesMenu::new);
		AccessoriesScreen.screenInit();
		INTENSEMOLTENFORGE = ScreenHandlerRegistry.registerExtended(new ResourceLocation(OriearthMod.MODID, "intensemoltenforge"),
				IntensemoltenforgeMenu::new);
		IntensemoltenforgeScreen.screenInit();
	}
}
