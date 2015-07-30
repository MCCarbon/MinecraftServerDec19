package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.PacketHandshakingInSetProtocol;

public interface PacketHandshakingInListener extends PacketListener {

	void handle(PacketHandshakingInSetProtocol packet);

}
