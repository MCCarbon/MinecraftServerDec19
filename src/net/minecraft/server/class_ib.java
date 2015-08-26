package net.minecraft.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

public class class_ib implements Packet {
	private int a;
	private final List b = Lists.newArrayList();

	public class_ib() {
	}

	public class_ib(int var1, Collection var2) {
		a = var1;
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			class_rq var4 = (class_rq) var3.next();
			b.add(new class_ib.class_a_in_class_ib(var4.a().a(), var4.b(), var4.c()));
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		int var2 = var1.readInt();

		for (int var3 = 0; var3 < var2; ++var3) {
			String var4 = var1.c(64);
			double var5 = var1.readDouble();
			ArrayList var7 = Lists.newArrayList();
			int var8 = var1.g();

			for (int var9 = 0; var9 < var8; ++var9) {
				UUID var10 = var1.i();
				var7.add(new class_rr(var10, "Unknown synced attribute modifier", var1.readDouble(), var1.readByte()));
			}

			b.add(new class_ib.class_a_in_class_ib(var4, var5, var7));
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeInt(b.size());
		Iterator var2 = b.iterator();

		while (var2.hasNext()) {
			class_ib.class_a_in_class_ib var3 = (class_ib.class_a_in_class_ib) var2.next();
			var1.a(var3.a());
			var1.writeDouble(var3.b());
			var1.b(var3.c().size());
			Iterator var4 = var3.c().iterator();

			while (var4.hasNext()) {
				class_rr var5 = (class_rr) var4.next();
				var1.a(var5.a());
				var1.writeDouble(var5.d());
				var1.writeByte(var5.c());
			}
		}

	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}

	public class class_a_in_class_ib {
		private final String b;
		private final double c;
		private final Collection d;

		public class_a_in_class_ib(String var2, double var3, Collection var5) {
			b = var2;
			c = var3;
			d = var5;
		}

		public String a() {
			return b;
		}

		public double b() {
			return c;
		}

		public Collection c() {
			return d;
		}
	}
}
