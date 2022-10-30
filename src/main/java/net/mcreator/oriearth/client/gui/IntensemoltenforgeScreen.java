
package net.mcreator.oriearth.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.oriearth.world.inventory.IntensemoltenforgeMenu;
import net.mcreator.oriearth.network.IntensemoltenforgeButtonMessage;
import net.mcreator.oriearth.OriearthMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class IntensemoltenforgeScreen extends AbstractContainerScreen<IntensemoltenforgeMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public IntensemoltenforgeScreen(IntensemoltenforgeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("oriearth:textures/screens/intensemoltenforge.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("oriearth:textures/screens/upgradetableiconhammer.png"));
		this.blit(ms, this.leftPos + 17, this.topPos + 4, 0, 0, 30, 30, 30, 30);

		RenderSystem.setShaderTexture(0, new ResourceLocation("oriearth:textures/screens/upgradetableiconinto.png"));
		this.blit(ms, this.leftPos + 108, this.topPos + 36, 0, 0, 22, 15, 22, 15);

		RenderSystem.setShaderTexture(0, new ResourceLocation("oriearth:textures/screens/upgradetableiconplus.png"));
		this.blit(ms, this.leftPos + 53, this.topPos + 37, 0, 0, 13, 13, 13, 13);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 45, this.topPos + 58, 77, 20, Component.literal("Forge Item"), e -> {
			if (true)
				ClientPlayNetworking.send(new ResourceLocation("oriearth:intensemoltenforge_button_" + 0),
						new IntensemoltenforgeButtonMessage(0, x, y, z));
		}));
	}

	public static void screenInit() {
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(OriearthMod.MODID, "intensemoltenforge_button_0"),
				IntensemoltenforgeButtonMessage::apply);
	}
}
