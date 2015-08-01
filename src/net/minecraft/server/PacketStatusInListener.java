package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.PacketStatusInPing;
import net.minecraft.server.PacketStatusInStart;

public interface PacketStatusInListener extends PacketListener {

	void handle(PacketStatusInPing packet);

	void handle(PacketStatusInStart packet);

}
