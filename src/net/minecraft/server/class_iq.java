package net.minecraft.server;

import java.io.IOException;

public class class_iq implements Packet {
	protected double a;
	protected double b;
	protected double c;
	protected float d;
	protected float e;
	protected boolean f;
	protected boolean g;
	protected boolean h;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		f = var1.readUnsignedByte() != 0;
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(f ? 1 : 0);
	}

	public double a() {
		return a;
	}

	public double b() {
		return b;
	}

	public double c() {
		return c;
	}

	public float d() {
		return d;
	}

	public float e() {
		return e;
	}

	public boolean f() {
		return f;
	}

	public boolean g() {
		return g;
	}

	public boolean h() {
		return h;
	}

	public void a(boolean var1) {
		g = var1;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}

	public static class class_c_in_class_iq extends class_iq {
		public class_c_in_class_iq() {
			h = true;
		}

		@Override
		public void decode(PacketDataSerializer var1) throws IOException {
			d = var1.readFloat();
			e = var1.readFloat();
			super.decode(var1);
		}

		@Override
		public void encode(PacketDataSerializer var1) throws IOException {
			var1.writeFloat(d);
			var1.writeFloat(e);
			super.encode(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void handle(PacketListener var1) {
			super.a((class_id) var1);
		}
	}

	public static class class_a_in_class_iq extends class_iq {
		public class_a_in_class_iq() {
			g = true;
		}

		@Override
		public void decode(PacketDataSerializer var1) throws IOException {
			a = var1.readDouble();
			b = var1.readDouble();
			c = var1.readDouble();
			super.decode(var1);
		}

		@Override
		public void encode(PacketDataSerializer var1) throws IOException {
			var1.writeDouble(a);
			var1.writeDouble(b);
			var1.writeDouble(c);
			super.encode(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void handle(PacketListener var1) {
			super.a((class_id) var1);
		}
	}

	public static class class_b_in_class_iq extends class_iq {
		public class_b_in_class_iq() {
			g = true;
			h = true;
		}

		@Override
		public void decode(PacketDataSerializer var1) throws IOException {
			a = var1.readDouble();
			b = var1.readDouble();
			c = var1.readDouble();
			d = var1.readFloat();
			e = var1.readFloat();
			super.decode(var1);
		}

		@Override
		public void encode(PacketDataSerializer var1) throws IOException {
			var1.writeDouble(a);
			var1.writeDouble(b);
			var1.writeDouble(c);
			var1.writeFloat(d);
			var1.writeFloat(e);
			super.encode(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void handle(PacketListener var1) {
			super.a((class_id) var1);
		}
	}
}
