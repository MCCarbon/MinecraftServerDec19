package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;

public interface Packet<T extends PacketListener> {

	void decode(PacketDataSerializer serializer) throws IOException;

	void encode(PacketDataSerializer serializer) throws IOException;

	void handle(T listener);

}
