package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.PacketLoginOutSuccess;
import net.minecraft.server.PacketLoginOutEncryptionBegin;
import net.minecraft.server.PacketLoginOutSetCompression;
import net.minecraft.server.PacketLoginOutDisconnect;

public interface PacketLoginOutListener extends PacketListener {

	void handle(PacketLoginOutEncryptionBegin packet);

	void handle(PacketLoginOutSuccess packet);

	void handle(PacketLoginOutDisconnect packet);

	void handle(PacketLoginOutSetCompression packet);

}
