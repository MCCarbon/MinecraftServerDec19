package net.minecraft.server;

import java.util.UUID;

import com.google.common.base.Optional;

public class class_kb {
	private static final class_ct m = new class_ct();
	public static final class_ka a = new class_ka() {
		public void a(PacketDataSerializer var1, Byte var2) {
			var1.writeByte(var2.byteValue());
		}

		public Byte b(PacketDataSerializer var1) {
			return Byte.valueOf(var1.readByte());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Byte) var2);
		}
	};
	public static final class_ka b = new class_ka() {
		public void a(PacketDataSerializer var1, Integer var2) {
			var1.b(var2.intValue());
		}

		public Integer b(PacketDataSerializer var1) {
			return Integer.valueOf(var1.g());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Integer) var2);
		}
	};
	public static final class_ka c = new class_ka() {
		public void a(PacketDataSerializer var1, Float var2) {
			var1.writeFloat(var2.floatValue());
		}

		public Float b(PacketDataSerializer var1) {
			return Float.valueOf(var1.readFloat());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Float) var2);
		}
	};
	public static final class_ka d = new class_ka() {
		public void a(PacketDataSerializer var1, String var2) {
			var1.a(var2);
		}

		public String b(PacketDataSerializer var1) {
			return var1.c(32767);
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (String) var2);
		}
	};
	public static final class_ka e = new class_ka() {
		public void a(PacketDataSerializer var1, class_eu var2) {
			var1.a(var2);
		}

		public class_eu b(PacketDataSerializer var1) {
			return var1.f();
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (class_eu) var2);
		}
	};
	public static final class_ka f = new class_ka() {
		public void a(PacketDataSerializer var1, Optional var2) {
			var1.a((class_aco) var2.orNull());
		}

		public Optional b(PacketDataSerializer var1) {
			return Optional.fromNullable(var1.k());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Optional) var2);
		}
	};
	public static final class_ka g = new class_ka() {
		public void a(PacketDataSerializer var1, Boolean var2) {
			var1.writeBoolean(var2.booleanValue());
		}

		public Boolean b(PacketDataSerializer var1) {
			return Boolean.valueOf(var1.readBoolean());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Boolean) var2);
		}
	};
	public static final class_ka h = new class_ka() {
		public void a(PacketDataSerializer var1, class_dc var2) {
			var1.writeFloat(var2.b());
			var1.writeFloat(var2.c());
			var1.writeFloat(var2.d());
		}

		public class_dc b(PacketDataSerializer var1) {
			return new class_dc(var1.readFloat(), var1.readFloat(), var1.readFloat());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (class_dc) var2);
		}
	};
	public static final class_ka i = new class_ka() {
		public void a(PacketDataSerializer var1, class_cj var2) {
			var1.a(var2);
		}

		public class_cj b(PacketDataSerializer var1) {
			return var1.e();
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (class_cj) var2);
		}
	};
	public static final class_ka j = new class_ka() {
		public void a(PacketDataSerializer var1, Optional var2) {
			var1.writeBoolean(var2.isPresent());
			if (var2.isPresent()) {
				var1.a((class_cj) var2.get());
			}

		}

		public Optional b(PacketDataSerializer var1) {
			return !var1.readBoolean() ? Optional.absent() : Optional.of(var1.e());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Optional) var2);
		}
	};
	public static final class_ka k = new class_ka() {
		public void a(PacketDataSerializer var1, class_cq var2) {
			var1.a(var2);
		}

		public class_cq b(PacketDataSerializer var1) {
			return (class_cq) var1.a(class_cq.class);
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (class_cq) var2);
		}
	};
	public static final class_ka l = new class_ka() {
		public void a(PacketDataSerializer var1, Optional var2) {
			var1.writeBoolean(var2.isPresent());
			if (var2.isPresent()) {
				var1.a((UUID) var2.get());
			}

		}

		public Optional b(PacketDataSerializer var1) {
			return !var1.readBoolean() ? Optional.absent() : Optional.of(var1.i());
		}

		@Override
		public class_jz a(int var1) {
			return new class_jz(var1, this);
		}

		// $FF: synthetic method
		@Override
		public Object a(PacketDataSerializer var1) {
			return this.b(var1);
		}

		// $FF: synthetic method
		// $FF: bridge method
		@Override
		public void a(PacketDataSerializer var1, Object var2) {
			this.a(var1, (Optional) var2);
		}
	};

	public static void a(class_ka var0) {
		m.a(var0, m.a());
	}

	public static class_ka a(int var0) {
		return (class_ka) m.a(var0);
	}

	public static int b(class_ka var0) {
		return m.a(var0);
	}

	static {
		a(a);
		a(b);
		a(c);
		a(d);
		a(e);
		a(f);
		a(g);
		a(h);
		a(i);
		a(j);
		a(k);
		a(l);
	}
}
