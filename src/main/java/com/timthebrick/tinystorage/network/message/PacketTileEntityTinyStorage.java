package com.timthebrick.tinystorage.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

import com.timthebrick.tinystorage.tileentity.TileEntityTinyStorage;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketTileEntityTinyStorage implements IMessage, IMessageHandler<PacketTileEntityTinyStorage, IMessage> {
	public int x, y, z;
	public byte orientation, state;
	public String customName, owner, uniqueOwner;

	public PacketTileEntityTinyStorage() {
	}

	public PacketTileEntityTinyStorage(TileEntityTinyStorage tileEntity) {
		this.x = tileEntity.xCoord;
		this.y = tileEntity.yCoord;
		this.z = tileEntity.zCoord;
		this.orientation = (byte) tileEntity.getOrientation().ordinal();
		this.state = (byte) tileEntity.getState();
		this.customName = tileEntity.getCustomName();
		this.owner = tileEntity.getOwner();
		this.uniqueOwner = tileEntity.getUniqueOwner();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.orientation = buf.readByte();
		this.state = buf.readByte();
		int customNameLength = buf.readInt();
		this.customName = new String(buf.readBytes(customNameLength).array());
		int ownerLength = buf.readInt();
		this.owner = new String(buf.readBytes(ownerLength).array());
		int uniqueOwnerLength = buf.readInt();
		this.uniqueOwner = new String(buf.readBytes(uniqueOwnerLength).array());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(orientation);
		buf.writeByte(state);
		buf.writeInt(customName.length());
		buf.writeBytes(customName.getBytes());
		buf.writeInt(owner.length());
		buf.writeBytes(owner.getBytes());
		buf.writeInt(uniqueOwner.length());
		buf.writeBytes(uniqueOwner.getBytes());
	}

	@Override
	public IMessage onMessage(PacketTileEntityTinyStorage message, MessageContext ctx) {
		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

		if (tileEntity instanceof TileEntityTinyStorage) {
			((TileEntityTinyStorage) tileEntity).setOrientation(message.orientation);
			((TileEntityTinyStorage) tileEntity).setState(message.state);
			((TileEntityTinyStorage) tileEntity).setCustomName(message.customName);
			((TileEntityTinyStorage) tileEntity).setOwner(message.owner);
			((TileEntityTinyStorage) tileEntity).setUniqueOwner(message.uniqueOwner);
		}
		return null;
	}

	@Override
	public String toString() {
		return String.format("PacketTileEntityTinyStorage - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s, uniqueOwner:%s", x, y, z, orientation, state, customName, owner, uniqueOwner);
	}

}
