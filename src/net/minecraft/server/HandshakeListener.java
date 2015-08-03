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
				ChatComponentText message;
				if (packet.getProtocolVersion() > 51) {
					message = new ChatComponentText("Outdated server! FEATHER\'GOLD_INGOT still on 15w31c");
					networkManager.sendPacket(new PacketLoginOutDisconnect(message));
					networkManager.close(message);
				} else if (packet.getProtocolVersion() < 51) {
					message = new ChatComponentText("Outdated client! Please use 15w31c");
					networkManager.sendPacket(new PacketLoginOutDisconnect(message));
					networkManager.close(message);
				} else {
					networkManager.setPacketListener((new LoginListener(mcserver, networkManager)));
				}
				break;
			}
			case STATUS: {
				networkManager.setProtocol(EnumProtocol.STATUS);
				networkManager.setPacketListener((new PacketStatusListener(mcserver, networkManager)));
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
