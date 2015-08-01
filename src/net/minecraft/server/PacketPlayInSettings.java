package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.EnumMainHandOption;
import net.minecraft.server.class_xa;

public class PacketPlayInSettings implements Packet<PacketListenerPlayIn> {

	private String locale;
	private int viewDistance;
	private class_xa.ChatMode chatMode;
	private boolean chatColors;
	private int skinParts;
	private EnumMainHandOption mainhand;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.locale = serializer.readString(7);
		this.viewDistance = serializer.readByte();
		this.chatMode = serializer.readEnum(class_xa.ChatMode.class);
		this.chatColors = serializer.readBoolean();
		this.skinParts = serializer.readUnsignedByte();
		this.mainhand = serializer.readEnum(EnumMainHandOption.class);
	}

	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeString(this.locale);
		var1.writeByte(this.viewDistance);
		var1.writeEnum(this.chatMode);
		var1.writeBoolean(this.chatColors);
		var1.writeByte(this.skinParts);
		var1.writeEnum(this.mainhand);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public String getLocale() {
		return this.locale;
	}

	public class_xa.ChatMode getChatMode() {
		return this.chatMode;
	}

	public boolean getChatColors() {
		return this.chatColors;
	}

	public int getSkinParts() {
		return this.skinParts;
	}

	public EnumMainHandOption getMainHand() {
		return this.mainhand;
	}

}
