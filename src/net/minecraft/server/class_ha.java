package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class class_ha implements Packet {
	private class_ha.class_a_in_class_ha a;
	private final List b = Lists.newArrayList();

	public class_ha() {
	}

	public class_ha(class_ha.class_a_in_class_ha var1, class_lm... var2) {
		a = var1;
		class_lm[] var3 = var2;
		int var4 = var2.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_lm var6 = var3[var5];
			b.add(new class_ha.class_b_in_class_ha(var6.cl(), var6.h, var6.c.b(), var6.F()));
		}

	}

	public class_ha(class_ha.class_a_in_class_ha var1, Iterable var2) {
		a = var1;
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			class_lm var4 = (class_lm) var3.next();
			b.add(new class_ha.class_b_in_class_ha(var4.cl(), var4.h, var4.c.b(), var4.F()));
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = (class_ha.class_a_in_class_ha) var1.a(class_ha.class_a_in_class_ha.class);
		int var2 = var1.g();

		for (int var3 = 0; var3 < var2; ++var3) {
			GameProfile var4 = null;
			int var5 = 0;
			class_agr.class_a_in_class_agr var6 = null;
			IChatBaseComponent var7 = null;
			switch (class_ha.SyntheticClass_1.a[a.ordinal()]) {
				case 1:
					var4 = new GameProfile(var1.i(), var1.c(16));
					int var8 = var1.g();
					int var9 = 0;

					for (; var9 < var8; ++var9) {
						String var10 = var1.c(32767);
						String var11 = var1.c(32767);
						if (var1.readBoolean()) {
							var4.getProperties().put(var10, new Property(var10, var11, var1.c(32767)));
						} else {
							var4.getProperties().put(var10, new Property(var10, var11));
						}
					}

					var6 = class_agr.class_a_in_class_agr.a(var1.g());
					var5 = var1.g();
					if (var1.readBoolean()) {
						var7 = var1.f();
					}
					break;
				case 2:
					var4 = new GameProfile(var1.i(), (String) null);
					var6 = class_agr.class_a_in_class_agr.a(var1.g());
					break;
				case 3:
					var4 = new GameProfile(var1.i(), (String) null);
					var5 = var1.g();
					break;
				case 4:
					var4 = new GameProfile(var1.i(), (String) null);
					if (var1.readBoolean()) {
						var7 = var1.f();
					}
					break;
				case 5:
					var4 = new GameProfile(var1.i(), (String) null);
			}

			b.add(new class_ha.class_b_in_class_ha(var4, var5, var6, var7));
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.b(b.size());
		Iterator var2 = b.iterator();

		while (true) {
			while (var2.hasNext()) {
				class_ha.class_b_in_class_ha var3 = (class_ha.class_b_in_class_ha) var2.next();
				switch (class_ha.SyntheticClass_1.a[a.ordinal()]) {
					case 1:
						var1.a(var3.a().getId());
						var1.a(var3.a().getName());
						var1.b(var3.a().getProperties().size());
						Iterator var4 = var3.a().getProperties().values().iterator();

						while (var4.hasNext()) {
							Property var5 = (Property) var4.next();
							var1.a(var5.getName());
							var1.a(var5.getValue());
							if (var5.hasSignature()) {
								var1.writeBoolean(true);
								var1.a(var5.getSignature());
							} else {
								var1.writeBoolean(false);
							}
						}

						var1.b(var3.c().a());
						var1.b(var3.b());
						if (var3.d() == null) {
							var1.writeBoolean(false);
						} else {
							var1.writeBoolean(true);
							var1.a(var3.d());
						}
						break;
					case 2:
						var1.a(var3.a().getId());
						var1.b(var3.c().a());
						break;
					case 3:
						var1.a(var3.a().getId());
						var1.b(var3.b());
						break;
					case 4:
						var1.a(var3.a().getId());
						if (var3.d() == null) {
							var1.writeBoolean(false);
						} else {
							var1.writeBoolean(true);
							var1.a(var3.d());
						}
						break;
					case 5:
						var1.a(var3.a().getId());
				}
			}

			return;
		}
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("action", a).add("entries", b).toString();
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_ha.class_a_in_class_ha.values().length];

		static {
			try {
				a[class_ha.class_a_in_class_ha.a.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_ha.class_a_in_class_ha.b.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_ha.class_a_in_class_ha.c.ordinal()] = 3;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_ha.class_a_in_class_ha.d.ordinal()] = 4;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_ha.class_a_in_class_ha.e.ordinal()] = 5;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public class class_b_in_class_ha {
		private final int b;
		private final class_agr.class_a_in_class_agr c;
		private final GameProfile d;
		private final IChatBaseComponent e;

		public class_b_in_class_ha(GameProfile var2, int var3, class_agr.class_a_in_class_agr var4, IChatBaseComponent var5) {
			d = var2;
			b = var3;
			c = var4;
			e = var5;
		}

		public GameProfile a() {
			return d;
		}

		public int b() {
			return b;
		}

		public class_agr.class_a_in_class_agr c() {
			return c;
		}

		public IChatBaseComponent d() {
			return e;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("latency", b).add("gameMode", c).add("profile", d).add("displayName", e == null ? null : IChatBaseComponent.class_a_in_class_eu.a(e)).toString();
		}
	}

	public static enum class_a_in_class_ha {
		a,
		b,
		c,
		d,
		e;
	}
}
