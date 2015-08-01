package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.PacketLoginInStart;
import net.minecraft.server.PacketLoginInEncryptionBegin;

public interface PacketLoginInListener extends PacketListener {

	void handle(PacketLoginInStart packet);

	void handle(PacketLoginInEncryptionBegin packet);

}
