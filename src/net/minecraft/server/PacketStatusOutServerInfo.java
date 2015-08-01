package net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class PacketStatusOutServerInfo implements Packet<PacketStatusOutListener> {

	private static final Gson gson = new GsonBuilder()
	.registerTypeAdapter(ServerPing.ServerData.class, new ServerPing.ServerData.Serializer())
	.registerTypeAdapter(ServerPing.ServerPingPlayerSample.class, new ServerPing.ServerPingPlayerSample.Serializer())
	.registerTypeAdapter(ServerPing.class, new ServerPing.Serializer())
	.registerTypeHierarchyAdapter(IChatBaseComponent.class, new IChatBaseComponent.ChatSerializer())
	.registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifier.ChatModifierSerializer())
	.registerTypeAdapterFactory(new ChatTypeAdapterFactory()).create();

	private ServerPing serverping;

	public PacketStatusOutServerInfo() {
	}

	public PacketStatusOutServerInfo(ServerPing serverping) {
		this.serverping = serverping;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.serverping = JsonHelper.fromJson(gson, serializer.readString(32767), ServerPing.class);
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(gson.toJson(this.serverping));
	}

	public void handle(PacketStatusOutListener listener) {
		listener.handle(this);
	}

}
