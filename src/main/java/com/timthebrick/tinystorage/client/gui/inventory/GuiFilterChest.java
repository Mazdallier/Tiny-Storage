package com.timthebrick.tinystorage.client.gui.inventory;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.timthebrick.tinystorage.inventory.ContainerFilterChest;
import com.timthebrick.tinystorage.reference.Names;
import com.timthebrick.tinystorage.reference.References;
import com.timthebrick.tinystorage.tileentity.TileEntityFilterChest;

public class GuiFilterChest extends GuiContainer {

	private TileEntityFilterChest tileEntity;

	public GuiFilterChest(InventoryPlayer inventoryPlayer, TileEntityFilterChest tileEntity) {
		super(new ContainerFilterChest(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
		if (this.tileEntity.getState() == 0) {
			xSize = 176;
			ySize = 133;
		} else if (this.tileEntity.getState() == 1) {
			xSize = 176;
			ySize = 151;
		} else if (this.tileEntity.getState() == 2) {
			xSize = 176;
			ySize = 169;
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()), 8, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 8, ySize - 95 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (tileEntity.getState() == 0) {
			this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiFilterChestSmall.png"));
		} else if (tileEntity.getState() == 1) {
			this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiFilterChestMedium.png"));
		} else if (tileEntity.getState() == 2) {
			this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiFilterChestLarge.png"));
		}
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}

	@Override
	public void initGui() {
		super.initGui();
	}

}
