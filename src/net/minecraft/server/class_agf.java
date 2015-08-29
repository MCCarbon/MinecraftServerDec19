package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

public abstract class class_agf {
	private int a = 20;
	private final List b = Lists.newArrayList();
	private class_agy c = new class_agy();
	private double d;
	private double e;
	private int f = 200;
	private int g = 800;
	private int h = 4;
	private Entity i;
	private int j = 6;
	private int k = 16;
	private int l = 4;

	private String f() {
		return c.b().l("id");
	}

	public void a(String var1) {
		c.b().a("id", var1);
	}

	private boolean g() {
		class_cj var1 = this.b();
		return this.a().b(var1.n() + 0.5D, var1.o() + 0.5D, var1.p() + 0.5D, k);
	}

	public void c() {
		if (g()) {
			class_cj var1 = this.b();
			double var6;
			if (this.a().D) {
				double var13 = var1.n() + this.a().s.nextFloat();
				double var14 = var1.o() + this.a().s.nextFloat();
				var6 = var1.p() + this.a().s.nextFloat();
				this.a().a(class_cy.l, var13, var14, var6, 0.0D, 0.0D, 0.0D, new int[0]);
				this.a().a(class_cy.A, var13, var14, var6, 0.0D, 0.0D, 0.0D, new int[0]);
				if (a > 0) {
					--a;
				}

				e = d;
				d = (d + 1000.0F / (a + 200.0F)) % 360.0D;
			} else {
				if (a == -1) {
					h();
				}

				if (a > 0) {
					--a;
					return;
				}

				boolean var2 = false;
				int var3 = 0;

				while (true) {
					if (var3 >= h) {
						if (var2) {
							h();
						}
						break;
					}

					Entity var4 = EntityTypes.a(f(), this.a());
					if (var4 == null) {
						return;
					}

					int var5 = this.a().a(var4.getClass(), (new class_ayk(var1.n(), var1.o(), var1.p(), var1.n() + 1, var1.o() + 1, var1.p() + 1)).b(l, l, l)).size();
					if (var5 >= j) {
						h();
						return;
					}

					var6 = var1.n() + ((this.a().s.nextDouble() - this.a().s.nextDouble()) * l) + 0.5D;
					double var8 = (var1.o() + this.a().s.nextInt(3)) - 1;
					double var10 = var1.p() + ((this.a().s.nextDouble() - this.a().s.nextDouble()) * l) + 0.5D;
					EntityInsentient var12 = var4 instanceof EntityInsentient ? (EntityInsentient) var4 : null;
					var4.b(var6, var8, var10, this.a().s.nextFloat() * 360.0F, 0.0F);
					if ((var12 == null) || (var12.cj() && var12.ck())) {
						this.a(var4, true);
						this.a().b(2004, var1, 0);
						if (var12 != null) {
							var12.A();
						}

						var2 = true;
					}

					++var3;
				}
			}

		}
	}

	private Entity a(Entity var1, boolean var2) {
		if (c != null) {
			class_dn var3 = c.b();
			if ((var1 instanceof EntityInsentient) && (var3.d() == 1) && var3.b("id", 8)) {
				((EntityInsentient) var1).a(var1.o.E(new class_cj(var1)), (class_rj) null);
			}

			class_dn var4 = new class_dn();
			var1.d(var4);
			UUID var5 = var1.aQ();
			var4.a(var3);
			var1.a(var5);
			var1.f(var4);
			if ((var1.o != null) && var2) {
				var1.o.a(var1);
			}

			class_dn var7;
			for (Entity var6 = var1; var4.b("Riding", 10); var4 = var7) {
				var7 = var4.o("Riding");
				Entity var8 = EntityTypes.a(var7.l("id"), var1.o);
				if (var8 != null) {
					class_dn var9 = new class_dn();
					var8.d(var9);
					UUID var10 = var1.aQ();
					var9.a(var7);
					var1.a(var10);
					var8.f(var9);
					var8.b(var6.s, var6.t, var6.u, var6.y, var6.z);
					if ((var1.o != null) && var2) {
						var1.o.a(var8);
					}

					var6.a(var8);
				}

				var6 = var8;
			}
		} else if ((var1 instanceof EntityLiving) && (var1.o != null) && var2) {
			if (var1 instanceof EntityInsentient) {
				((EntityInsentient) var1).a(var1.o.E(new class_cj(var1)), (class_rj) null);
			}

			var1.o.a(var1);
		}

		return var1;
	}

	private void h() {
		if (g <= f) {
			a = f;
		} else {
			int var10003 = g - f;
			a = f + this.a().s.nextInt(var10003);
		}

		if (!b.isEmpty()) {
			this.a((class_agy) class_oi.a(this.a().s, b));
		}

		this.a(1);
	}

	public void a(class_dn var1) {
		a = var1.g("Delay");
		b.clear();
		if (var1.b("SpawnPotentials", 9)) {
			class_du var2 = var1.c("SpawnPotentials", 10);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				b.add(new class_agy(var2.b(var3)));
			}
		}

		class_dn var4 = var1.o("SpawnData");
		if (!var4.b("id", 8)) {
			var4.a("id", "Pig");
		}

		this.a(new class_agy(1, var4));
		if (var1.b("MinSpawnDelay", 99)) {
			f = var1.g("MinSpawnDelay");
			g = var1.g("MaxSpawnDelay");
			h = var1.g("SpawnCount");
		}

		if (var1.b("MaxNearbyEntities", 99)) {
			j = var1.g("MaxNearbyEntities");
			k = var1.g("RequiredPlayerRange");
		}

		if (var1.b("SpawnRange", 99)) {
			l = var1.g("SpawnRange");
		}

		if (this.a() != null) {
			i = null;
		}

	}

	public void b(class_dn var1) {
		String var2 = f();
		if (!class_of.b(var2)) {
			var1.a("Delay", (short) a);
			var1.a("MinSpawnDelay", (short) f);
			var1.a("MaxSpawnDelay", (short) g);
			var1.a("SpawnCount", (short) h);
			var1.a("MaxNearbyEntities", (short) j);
			var1.a("RequiredPlayerRange", (short) k);
			var1.a("SpawnRange", (short) l);
			if (c != null) {
				var1.a("SpawnData", c.b().b());
			}

			if ((c != null) || !b.isEmpty()) {
				class_du var3 = new class_du();
				if (!b.isEmpty()) {
					Iterator var4 = b.iterator();

					while (var4.hasNext()) {
						class_agy var5 = (class_agy) var4.next();
						var3.a(var5.a());
					}
				} else {
					var3.a(c.a());
				}

				var1.a("SpawnPotentials", var3);
			}

		}
	}

	public boolean b(int var1) {
		if ((var1 == 1) && this.a().D) {
			a = f;
			return true;
		} else {
			return false;
		}
	}

	public void a(class_agy var1) {
		c = var1;
	}

	public abstract void a(int var1);

	public abstract class_ago a();

	public abstract class_cj b();
}
