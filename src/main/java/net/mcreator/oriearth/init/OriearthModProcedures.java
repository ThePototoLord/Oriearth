
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oriearth.init;

import net.mcreator.oriearth.procedures.TotemofhealthproProcedure;
import net.mcreator.oriearth.procedures.IntenseforgeprocessProcedure;
import net.mcreator.oriearth.procedures.DognoodleschooleffectsProcedure;
import net.mcreator.oriearth.procedures.DogmeatPlayerFinishesUsingItemProcedure;
import net.mcreator.oriearth.procedures.DogknifeeffectProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class OriearthModProcedures {
	public static void load() {
		new DogmeatPlayerFinishesUsingItemProcedure();
		new DognoodleschooleffectsProcedure();
		new IntenseforgeprocessProcedure();
		new TotemofhealthproProcedure();
		new DogknifeeffectProcedure();
		new PhoenixabilityrProcedure();
	}
}
