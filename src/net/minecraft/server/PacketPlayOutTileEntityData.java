package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutTileEntityData implements Packet<PacketListenerPlayOut> {

	private BlockPosition position;
	private int type;
	private NBTTagCompound data;

	public PacketPlayOutTileEntityData() {
	}

	public PacketPlayOutTileEntityData(BlockPosition position, int type, NBTTagCompound data) {
		this.position = position;
		this.type = type;
		this.data = data;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.position = serializer.readBlockPosition();
		this.type = serializer.readUnsignedByte();
		this.data = serializer.readNBTTagCompund();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeBlockPosition(this.position);
		serializer.writeByte((byte) this.type);
		serializer.writeNBTTagCompound(this.data);
	}

	public void handle(PacketListenerPlayOut listener) {
		listener.a(this);
	}

}
