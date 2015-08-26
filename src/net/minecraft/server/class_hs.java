package net.minecraft.server;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.Lists;

public class class_hs implements Packet {
	private String a = "";
	private String b = "";
	private String c = "";
	private String d = "";
	private String e;
	private int f;
	private Collection g;
	private int h;
	private int i;

	public class_hs() {
		e = class_ayu.class_a_in_class_ayu.a.e;
		f = -1;
		g = Lists.newArrayList();
	}

	public class_hs(class_ayp var1, int var2) {
		e = class_ayu.class_a_in_class_ayu.a.e;
		f = -1;
		g = Lists.newArrayList();
		a = var1.b();
		h = var2;
		if ((var2 == 0) || (var2 == 2)) {
			b = var1.c();
			c = var1.e();
			d = var1.f();
			i = var1.k();
			e = var1.i().e;
			f = var1.l().getId();
		}

		if (var2 == 0) {
			g.addAll(var1.d());
		}

	}

	public class_hs(class_ayp var1, Collection var2, int var3) {
		e = class_ayu.class_a_in_class_ayu.a.e;
		f = -1;
		g = Lists.newArrayList();
		if ((var3 != 3) && (var3 != 4)) {
			throw new IllegalArgumentException("Method must be join or leave for player constructor");
		} else if ((var2 != null) && !var2.isEmpty()) {
			h = var3;
			a = var1.b();
			g.addAll(var2);
		} else {
			throw new IllegalArgumentException("Players cannot be null/empty");
		}
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(16);
		h = var1.readByte();
		if ((h == 0) || (h == 2)) {
			b = var1.c(32);
			c = var1.c(16);
			d = var1.c(16);
			i = var1.readByte();
			e = var1.c(32);
			f = var1.readByte();
		}

		if ((h == 0) || (h == 3) || (h == 4)) {
			int var2 = var1.g();

			for (int var3 = 0; var3 < var2; ++var3) {
				g.add(var1.c(40));
			}
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(h);
		if ((h == 0) || (h == 2)) {
			var1.a(b);
			var1.a(c);
			var1.a(d);
			var1.writeByte(i);
			var1.a(e);
			var1.writeByte(f);
		}

		if ((h == 0) || (h == 3) || (h == 4)) {
			var1.b(g.size());
			Iterator var2 = g.iterator();

			while (var2.hasNext()) {
				String var3 = (String) var2.next();
				var1.a(var3);
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
}
