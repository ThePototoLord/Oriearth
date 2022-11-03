
package net.mcreator.oriearth.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

import net.mcreator.oriearth.init.OriearthModItems;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;

public class BladeOfThePhoenixItem extends SwordItem {
	public BladeOfThePhoenixItem() {
		super(new Tier() {
			public int getUses() {
				return 2512;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().craftRemainder(OriearthModItems.BLADE_OF_THE_PHOENIX));
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Right-Click Ability'"));
		list.add(Component.literal("*Summon Fireball*"));
	}
}
