package net.minecraft.server;

import java.io.IOException;

public interface Packet<T extends PacketListener> {
	void decode(PacketDataSerializer var1) throws IOException;

	void encode(PacketDataSerializer var1) throws IOException;

	void handle(PacketListener var1);
}
