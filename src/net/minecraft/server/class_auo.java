package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

import com.google.common.collect.Maps;

public abstract class class_auo extends class_arr {
	private class_auq d;
	protected Map e = Maps.newHashMap();

	public abstract String a();

	@Override
	protected final synchronized void a(class_ago var1, final int var2, final int var3, int var4, int var5, class_arl var6) {
		this.a(var1);
		if (!e.containsKey(Long.valueOf(class_agi.a(var2, var3)))) {
			b.nextInt();

			try {
				if (this.a(var2, var3)) {
					class_aus var7 = this.b(var2, var3);
					e.put(Long.valueOf(class_agi.a(var2, var3)), var7);
					if (var7.a()) {
						this.a(var2, var3, var7);
					}
				}

			} catch (Throwable var10) {
				class_b var8 = class_b.a(var10, "Exception preparing structure feature");
				class_c var9 = var8.a("Feature being prepared");
				var9.a("Is feature chunk", new Callable() {
					public String a() throws Exception {
						return class_auo.this.a(var2, var3) ? "True" : "False";
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				var9.a("Chunk location", String.format("%d,%d", new Object[] { Integer.valueOf(var2), Integer.valueOf(var3) }));
				var9.a("Chunk pos hash", new Callable() {
					public String a() throws Exception {
						return String.valueOf(class_agi.a(var2, var3));
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				var9.a("Structure type", new Callable() {
					public String a() throws Exception {
						return class_auo.this.getClass().getCanonicalName();
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				throw new class_e(var8);
			}
		}
	}

	public synchronized boolean a(class_ago var1, Random var2, class_agi var3) {
		this.a(var1);
		int var4 = (var3.a << 4) + 8;
		int var5 = (var3.b << 4) + 8;
		boolean var6 = false;
		Iterator var7 = e.values().iterator();

		while (var7.hasNext()) {
			class_aus var8 = (class_aus) var7.next();
			if (var8.a() && var8.a(var3) && var8.b().a(var4, var5, var4 + 15, var5 + 15)) {
				var8.a(var1, var2, new class_aua(var4, var5, var4 + 15, var5 + 15));
				var8.b(var3);
				var6 = true;
				this.a(var8.e(), var8.f(), var8);
			}
		}

		return var6;
	}

	public boolean b(class_cj var1) {
		this.a(c);
		return c(var1) != null;
	}

	protected class_aus c(class_cj var1) {
		Iterator var2 = e.values().iterator();

		while (true) {
			class_aus var3;
			do {
				do {
					if (!var2.hasNext()) {
						return null;
					}

					var3 = (class_aus) var2.next();
				} while (!var3.a());
			} while (!var3.b().b(var1));

			Iterator var4 = var3.c().iterator();

			while (var4.hasNext()) {
				class_aur var5 = (class_aur) var4.next();
				if (var5.c().b(var1)) {
					return var3;
				}
			}
		}
	}

	public boolean a(class_ago var1, class_cj var2) {
		this.a(var1);
		Iterator var3 = e.values().iterator();

		class_aus var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (class_aus) var3.next();
		} while (!var4.a() || !var4.b().b(var2));

		return true;
	}

	public class_cj b(class_ago var1, class_cj var2) {
		c = var1;
		this.a(var1);
		b.setSeed(var1.L());
		long var3 = b.nextLong();
		long var5 = b.nextLong();
		long var7 = (var2.n() >> 4) * var3;
		long var9 = (var2.p() >> 4) * var5;
		b.setSeed(var7 ^ var9 ^ var1.L());
		this.a(var1, var2.n() >> 4, var2.p() >> 4, 0, 0, (class_arl) null);
		double var11 = Double.MAX_VALUE;
		class_cj var13 = null;
		Iterator var14 = e.values().iterator();

		class_cj var17;
		double var18;
		while (var14.hasNext()) {
			class_aus var15 = (class_aus) var14.next();
			if (var15.a()) {
				class_aur var16 = (class_aur) var15.c().get(0);
				var17 = var16.a();
				var18 = var17.i(var2);
				if (var18 < var11) {
					var11 = var18;
					var13 = var17;
				}
			}
		}

		if (var13 != null) {
			return var13;
		} else {
			List var20 = y_();
			if (var20 != null) {
				class_cj var21 = null;
				Iterator var22 = var20.iterator();

				while (var22.hasNext()) {
					var17 = (class_cj) var22.next();
					var18 = var17.i(var2);
					if (var18 < var11) {
						var11 = var18;
						var21 = var17;
					}
				}

				return var21;
			} else {
				return null;
			}
		}
	}

	protected List y_() {
		return null;
	}

	private void a(class_ago var1) {
		if (d == null) {
			d = (class_auq) var1.a(class_auq.class, this.a());
			if (d == null) {
				d = new class_auq(this.a());
				var1.a(this.a(), d);
			} else {
				class_dn var2 = d.a();
				Iterator var3 = var2.c().iterator();

				while (var3.hasNext()) {
					String var4 = (String) var3.next();
					class_eb var5 = var2.c(var4);
					if (var5.a() == 10) {
						class_dn var6 = (class_dn) var5;
						if (var6.e("ChunkX") && var6.e("ChunkZ")) {
							int var7 = var6.h("ChunkX");
							int var8 = var6.h("ChunkZ");
							class_aus var9 = class_aup.a(var6, var1);
							if (var9 != null) {
								e.put(Long.valueOf(class_agi.a(var7, var8)), var9);
							}
						}
					}
				}
			}
		}

	}

	private void a(int var1, int var2, class_aus var3) {
		d.a(var3.a(var1, var2), var1, var2);
		d.c();
	}

	protected abstract boolean a(int var1, int var2);

	protected abstract class_aus b(int var1, int var2);
}
