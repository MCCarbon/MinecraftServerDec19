package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.WorldType;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_om;

public class PacketPlayOutLogin implements Packet<PacketListenerPlayOut> {

	private int entityId;
	private boolean hardcore;
	private WorldSettings.EnumGameMode gameMode;
	private int dimension;
	private class_om difficulty;
	private int maxplayers;
	private WorldType levelType;
	private boolean reducedDebug;

	public PacketPlayOutLogin() {
	}

	public PacketPlayOutLogin(int entityId, WorldSettings.EnumGameMode gameMode, boolean hardcore, int dimension, class_om difficulty, int maxplayers, WorldType levelType, boolean reducedDebug) {
		this.entityId = entityId;
		this.dimension = dimension;
		this.difficulty = difficulty;
		this.gameMode = gameMode;
		this.maxplayers = maxplayers;
		this.hardcore = hardcore;
		this.levelType = levelType;
		this.reducedDebug = reducedDebug;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readInt();
		short gmh = serializer.readUnsignedByte();
		this.hardcore = (gmh & 8) == 8;
		int gm = gmh & -9;
		this.gameMode = WorldSettings.EnumGameMode.getById(gm);
		this.dimension = serializer.readByte();
		this.difficulty = class_om.a(serializer.readUnsignedByte());
		this.maxplayers = serializer.readUnsignedByte();
		this.levelType = WorldType.getType(serializer.readString(16));
		if (this.levelType == null) {
			this.levelType = WorldType.NORMAL;
		}

		this.reducedDebug = serializer.readBoolean();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeInt(this.entityId);
		int gmh = this.gameMode.getId();
		if (this.hardcore) {
			gmh |= 8;
		}
		serializer.writeByte(gmh);
		serializer.writeByte(this.dimension);
		serializer.writeByte(this.difficulty.a());
		serializer.writeByte(this.maxplayers);
		serializer.writeString(this.levelType.a());
		serializer.writeBoolean(this.reducedDebug);
	}

	public void handle(PacketListenerPlayOut listener) {
		listener.a(this);
	}

}
