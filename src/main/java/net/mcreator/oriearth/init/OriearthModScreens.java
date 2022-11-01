
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oriearth.init;

import net.mcreator.oriearth.client.gui.IntensemoltenforgeScreen;
import net.mcreator.oriearth.client.gui.AccessoriesScreen;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class OriearthModScreens {
	public static void load() {
		ScreenRegistry.register(OriearthModMenus.ACCESSORIES, AccessoriesScreen::new);
		ScreenRegistry.register(OriearthModMenus.INTENSEMOLTENFORGE, IntensemoltenforgeScreen::new);
	}
}
