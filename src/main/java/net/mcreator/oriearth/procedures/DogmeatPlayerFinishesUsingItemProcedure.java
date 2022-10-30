package net.mcreator.oriearth.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.oriearth.OriearthMod;

import java.util.Map;

public class DogmeatPlayerFinishesUsingItemProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OriearthMod.LOGGER.warn("Failed to load dependency entity for procedure DogmeatPlayerFinishesUsingItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 1));
	}
}
