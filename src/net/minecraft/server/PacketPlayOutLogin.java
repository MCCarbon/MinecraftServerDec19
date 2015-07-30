package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_om;

public class PacketPlayOutLogin implements Packet<PacketListenerPlayOut> {

	private int entityId;
	private boolean hardcore;
	private class_aeq.class_a_in_class_aeq gameMode;
	private int dimension;
	private class_om difficulty;
	private int maxplayers;
	private class_aes levelType;
	private boolean reducedDebug;

	public PacketPlayOutLogin() {
	}

	public PacketPlayOutLogin(int entityId, class_aeq.class_a_in_class_aeq gameMode, boolean hardcore, int dimension, class_om difficulty, int maxplayers, class_aes levelType, boolean reducedDebug) {
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
		this.gameMode = class_aeq.class_a_in_class_aeq.a(gm);
		this.dimension = serializer.readByte();
		this.difficulty = class_om.a(serializer.readUnsignedByte());
		this.maxplayers = serializer.readUnsignedByte();
		this.levelType = class_aes.a(serializer.readString(16));
		if (this.levelType == null) {
			this.levelType = class_aes.b;
		}

		this.reducedDebug = serializer.readBoolean();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeInt(this.entityId);
		int gmh = this.gameMode.a();
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
