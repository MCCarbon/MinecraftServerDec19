package net.minecraft.server;

import java.io.IOException;

public class class_gw implements Packet {
	protected int a;
	protected byte b;
	protected byte c;
	protected byte d;
	protected byte e;
	protected byte f;
	protected boolean g;
	protected boolean h;

	public class_gw() {
	}

	public class_gw(int var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	@Override
	public String toString() {
		return "Entity_" + super.toString();
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}

	public static class class_c_in_class_gw extends class_gw {
		public class_c_in_class_gw() {
			h = true;
		}

		public class_c_in_class_gw(int var1, byte var2, byte var3, boolean var4) {
			super(var1);
			e = var2;
			f = var3;
			h = true;
			g = var4;
		}

		@Override
		public void decode(PacketDataSerializer var1) throws IOException {
			super.decode(var1);
			e = var1.readByte();
			f = var1.readByte();
			g = var1.readBoolean();
		}

		@Override
		public void encode(PacketDataSerializer var1) throws IOException {
			super.encode(var1);
			var1.writeByte(e);
			var1.writeByte(f);
			var1.writeBoolean(g);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void handle(PacketListener var1) {
			super.a((PacketListenerPlayOut) var1);
		}
	}

	public static class class_a_in_class_gw extends class_gw {
		public class_a_in_class_gw() {
		}

		public class_a_in_class_gw(int var1, byte var2, byte var3, byte var4, boolean var5) {
			super(var1);
			b = var2;
			c = var3;
			d = var4;
			g = var5;
		}

		@Override
		public void decode(PacketDataSerializer var1) throws IOException {
			super.decode(var1);
			b = var1.readByte();
			c = var1.readByte();
			d = var1.readByte();
			g = var1.readBoolean();
		}

		@Override
		public void encode(PacketDataSerializer var1) throws IOException {
			super.encode(var1);
			var1.writeByte(b);
			var1.writeByte(c);
			var1.writeByte(d);
			var1.writeBoolean(g);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void handle(PacketListener var1) {
			super.a((PacketListenerPlayOut) var1);
		}
	}

	public static class class_b_in_class_gw extends class_gw {
		public class_b_in_class_gw() {
			h = true;
		}

		public class_b_in_class_gw(int var1, byte var2, byte var3, byte var4, byte var5, byte var6, boolean var7) {
			super(var1);
			b = var2;
			c = var3;
			d = var4;
			e = var5;
			f = var6;
			g = var7;
			h = true;
		}

		@Override
		public void decode(PacketDataSerializer var1) throws IOException {
			super.decode(var1);
			b = var1.readByte();
			c = var1.readByte();
			d = var1.readByte();
			e = var1.readByte();
			f = var1.readByte();
			g = var1.readBoolean();
		}

		@Override
		public void encode(PacketDataSerializer var1) throws IOException {
			super.encode(var1);
			var1.writeByte(b);
			var1.writeByte(c);
			var1.writeByte(d);
			var1.writeByte(e);
			var1.writeByte(f);
			var1.writeBoolean(g);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void handle(PacketListener var1) {
			super.a((PacketListenerPlayOut) var1);
		}
	}
}
