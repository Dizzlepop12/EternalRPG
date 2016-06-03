package com.eternal.container.gui;

import io.netty.buffer.Unpooled;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.eternal.EternalRPG;
import com.eternal.container.ContainerInfusers;
import com.eternal.tileentity.TileEntityInfusersTable;

public class GuiInfusersTable extends GuiContainer {

	private TileEntityInfusersTable table;

	public GuiInfusersTable(InventoryPlayer inventory, TileEntityInfusersTable table, World w) {
		super(new ContainerInfusers(inventory, table, w));
		this.table = table;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = "eternalrpg.infusersTable";
		this.fontRendererObj.drawString(I18n.format(s), this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 0xFFFFFF);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 0xFFFFFF);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(new ResourceLocation(EternalRPG.PREFIX + "textures/gui/infusers.png"));
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void initGui() {
		super.initGui();
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
		this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload("ERPG|INFUSERS", packetbuffer));
	}
}