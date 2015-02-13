package com.timthebrick.tinystorage.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.timthebrick.tinystorage.network.PacketHandler;
import com.timthebrick.tinystorage.network.message.PacketTileEntityTinyStorage;
import com.timthebrick.tinystorage.reference.Names;

public class TileEntityTinyStorage extends TileEntity {

	protected ForgeDirection orientation;
	protected byte state;
	protected String customName;
	protected String owner;
	protected String textureName;

	public TileEntityTinyStorage() {
		orientation = ForgeDirection.SOUTH;
		state = 0;
		customName = "";
		owner = "";
		textureName = "";
	}

	public ForgeDirection getOrientation() {
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation) {
		this.orientation = orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	public short getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTextureName() {
		return textureName;
	}

	public void setCustomTextureName(String textureName) {
		this.textureName = textureName;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey(Names.NBT.DIRECTION)) {
			this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(Names.NBT.DIRECTION));
		}

		if (nbtTagCompound.hasKey(Names.NBT.STATE)) {
			this.state = nbtTagCompound.getByte(Names.NBT.STATE);
		}

		if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME)) {
			this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
		}

		if (nbtTagCompound.hasKey(Names.NBT.OWNER)) {
			this.owner = nbtTagCompound.getString(Names.NBT.OWNER);
		}

		if (nbtTagCompound.hasKey(Names.NBT.TEXTURE_NAME)) {
			this.textureName = nbtTagCompound.getString(Names.NBT.TEXTURE_NAME);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte(Names.NBT.DIRECTION, (byte) orientation.ordinal());
		nbtTagCompound.setByte(Names.NBT.STATE, state);

		if (this.hasCustomName()) {
			nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
		}

		if (this.hasOwner()) {
			nbtTagCompound.setString(Names.NBT.OWNER, owner);
		}

		if (this.hasCustomTextureName()) {
			nbtTagCompound.setString(Names.NBT.TEXTURE_NAME, textureName);
		}
	}

	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}

	public boolean hasOwner() {
		return owner != null && owner.length() > 0;
	}

	public boolean hasCustomTextureName() {
		return textureName != null && textureName.length() > 0;
	}

	@Override
	public Packet getDescriptionPacket() {
		return PacketHandler.INSTANCE.getPacketFrom(new PacketTileEntityTinyStorage(this));
	}

}
