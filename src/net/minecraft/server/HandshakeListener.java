package net.minecraft.server;

public class HandshakeListener implements PacketHandshakingInListener {

	private final MinecraftServer mcserver;
	private final NetworkManager networkManager;

	public HandshakeListener(MinecraftServer mcserver, NetworkManager networkManager) {
		this.mcserver = mcserver;
		this.networkManager = networkManager;
	}

	@Override
	public void handle(PacketHandshakingInSetProtocol packet) {
		switch (packet.getNextProtocol()) {
			case LOGIN: {
				networkManager.setProtocol(EnumProtocol.LOGIN);
				class_fa message;
				if (packet.getProtocolVersion() > 51) {
					message = new class_fa("Outdated server! I\'m still on 15w31c");
					networkManager.sendPacket(new class_jk(message));
					networkManager.close(message);
				} else if (packet.getProtocolVersion() < 51) {
					message = new class_fa("Outdated client! Please use 15w31c");
					networkManager.sendPacket(new class_jk(message));
					networkManager.close(message);
				} else {
					networkManager.setPacketListener((new class_lq(mcserver, networkManager)));
				}
				break;
			}
			case STATUS: {
				networkManager.setProtocol(EnumProtocol.STATUS);
				networkManager.setPacketListener((new class_lr(mcserver, networkManager)));
				break;
			}
			default:
				throw new UnsupportedOperationException("Invalid intention " + packet.getNextProtocol());
		}

	}

	@Override
	public void disconnect(IChatBaseComponent chat) {
	}

}
