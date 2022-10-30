
package net.mcreator.oriearth.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.oriearth.procedures.DognoodleschooleffectsProcedure;

public class DognoodlestewItem extends Item {
	public DognoodlestewItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).fireResistant().rarity(Rarity.EPIC)
				.food((new FoodProperties.Builder()).nutrition(10).saturationMod(69f)

						.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 29;
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		DognoodleschooleffectsProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
	}
}
