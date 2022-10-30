
package net.mcreator.oriearth.world.inventory;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.Container;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.oriearth.init.OriearthModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class AccessoriesMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private BlockPos pos;
	private final Container inventory;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;

	public AccessoriesMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		this(id, inv, new SimpleContainer(0));
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
		}
	}

	public AccessoriesMenu(int id, Inventory inv, Container container) {
		super(OriearthModMenus.ACCESSORIES, id);
		this.entity = inv.player;
		this.world = inv.player.level;
		this.inventory = container;
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 0 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 0) {
				if (!this.moveItemStackTo(itemstack1, 0, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 0, false)) {
				if (index < 0 + 27) {
					if (!this.moveItemStackTo(itemstack1, 0 + 27, this.slots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else {
					if (!this.moveItemStackTo(itemstack1, 0, 0 + 27, false)) {
						return ItemStack.EMPTY;
					}
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.set(itemstack);
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	protected boolean moveItemStackTo(ItemStack itemstack, int i, int j, boolean bl) {
		ItemStack itemstack2;
		Slot slot = this.slots.get(i);
		boolean bl2 = false;
		int k = i;
		if (bl) {
			k = j - 1;
		}
		if (itemstack.isStackable()) {
			while (slot.mayPlace(itemstack) && !itemstack.isEmpty() && (bl ? k >= i : k < j)) {
				slot = this.slots.get(k);
				itemstack2 = slot.getItem();
				if (!itemstack2.isEmpty() && ItemStack.isSameItemSameTags(itemstack, itemstack2)) {
					int l = itemstack2.getCount() + itemstack.getCount();
					if (l <= itemstack.getMaxStackSize()) {
						itemstack.setCount(0);
						itemstack2.setCount(l);
						slot.set(itemstack);
						bl2 = true;
					} else if (itemstack2.getCount() < itemstack.getMaxStackSize()) {
						itemstack.shrink(itemstack.getMaxStackSize() - itemstack2.getCount());
						itemstack2.setCount(itemstack.getMaxStackSize());
						slot.set(itemstack);
						bl2 = true;
					}
				}
				if (bl) {
					--k;
					continue;
				}
				++k;
			}
		}
		if (slot.mayPlace(itemstack) && !itemstack.isEmpty()) {
			k = bl ? j - 1 : i;
			while (bl ? k >= i : k < j) {
				slot = this.slots.get(k);
				itemstack2 = slot.getItem();
				if (itemstack2.isEmpty() && slot.mayPlace(itemstack)) {
					if (itemstack.getCount() > slot.getMaxStackSize()) {
						slot.set(itemstack.split(slot.getMaxStackSize()));
					} else {
						slot.set(itemstack.split(itemstack.getCount()));
					}
					slot.set(itemstack);
					bl2 = true;
					break;
				}
				if (bl) {
					--k;
					continue;
				}
				++k;
			}
		}
		return bl2;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
