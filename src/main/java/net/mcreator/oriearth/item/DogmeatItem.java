
package net.mcreator.oriearth.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.oriearth.procedures.DogmeatPlayerFinishesUsingItemProcedure;

public class DogmeatItem extends Item {
	public DogmeatItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.EPIC)
				.food((new FoodProperties.Builder()).nutrition(4).saturationMod(4f)

						.meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 26;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		DogmeatPlayerFinishesUsingItemProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		return retval;
	}
}
