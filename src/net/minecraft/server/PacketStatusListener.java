package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.NetworkManager;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.PacketStatusOutPong;
import net.minecraft.server.PacketStatusOutServerInfo;
import net.minecraft.server.PacketStatusInListener;
import net.minecraft.server.PacketStatusInPing;
import net.minecraft.server.PacketStatusInStart;

public class PacketStatusListener implements PacketStatusInListener {

	private static final IChatBaseComponent message = new class_fa("Status request has been handled.");
	private final MinecraftServer mcserver;
	private final NetworkManager networkManager;
	private boolean handledStart;

	public PacketStatusListener(MinecraftServer mcserver, NetworkManager networkManager) {
		this.mcserver = mcserver;
		this.networkManager = networkManager;
	}

	public void disconnect(IChatBaseComponent message) {
	}

	public void handle(PacketStatusInStart packet) {
		if (this.handledStart) {
			this.networkManager.close(message);
		} else {
			this.handledStart = true;
			this.networkManager.sendPacket(new PacketStatusOutServerInfo(this.mcserver.aG()));
		}
	}

	public void handle(PacketStatusInPing packet) {
		this.networkManager.sendPacket(new PacketStatusOutPong(packet.getTimeStamp()));
		this.networkManager.close(message);
	}

}
