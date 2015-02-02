package com.timthebrick.tinystorage.network;

import com.timthebrick.tinystorage.network.message.MessageTileEntityTinyStorage;
import com.timthebrick.tinystorage.reference.References;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(References.MOD_ID.toLowerCase());

	public static void init() {
		INSTANCE.registerMessage(MessageTileEntityTinyStorage.class, MessageTileEntityTinyStorage.class, 0, Side.CLIENT);
	}

}
