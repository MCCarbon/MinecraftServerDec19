package net.minecraft.server;

import java.util.Iterator;

public class class_lh implements class_agq {
	private MinecraftServer a;
	private class_ll b;

	public class_lh(MinecraftServer var1, class_ll var2) {
		a = var1;
		b = var2;
	}

	@Override
	public void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
	}

	@Override
	public void a(Entity var1) {
		b.u().a(var1);
		if (var1 instanceof class_lm) {
			b.t.a((class_lm) var1);
		}

	}

	@Override
	public void b(Entity var1) {
		b.u().b(var1);
		b.ab().a(var1);
		if (var1 instanceof class_lm) {
			b.t.b((class_lm) var1);
		}

	}

	@Override
	public void a(String var1, double var2, double var4, double var6, float var8, float var9) {
		a.ar().a(var2, var4, var6, var8 > 1.0F ? (double) (16.0F * var8) : 16.0D, b.t.p().a(), new class_gt(var1, var2, var4, var6, var8, var9));
	}

	@Override
	public void a(class_yu var1, String var2, double var3, double var5, double var7, float var9, float var10) {
		a.ar().a(var1, var3, var5, var7, var9 > 1.0F ? (double) (16.0F * var9) : 16.0D, b.t.p().a(), new class_gt(var2, var3, var5, var7, var9, var10));
	}

	@Override
	public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
	}

	@Override
	public void a(class_cj var1) {
		b.v().a(var1);
	}

	@Override
	public void b(class_cj var1) {
	}

	@Override
	public void a(String var1, class_cj var2) {
	}

	@Override
	public void a(class_yu var1, int var2, class_cj var3, int var4) {
		a.ar().a(var1, var3.n(), var3.o(), var3.p(), 64.0D, b.t.p().a(), new class_gr(var2, var3, var4, false));
	}

	@Override
	public void a(int var1, class_cj var2, int var3) {
		a.ar().a((new class_gr(var1, var2, var3, true)));
	}

	@Override
	public void b(int var1, class_cj var2, int var3) {
		Iterator var4 = a.ar().v().iterator();

		while (var4.hasNext()) {
			class_lm var5 = (class_lm) var4.next();
			if ((var5 != null) && (var5.o == b) && (var5.G() != var1)) {
				double var6 = var2.n() - var5.s;
				double var8 = var2.o() - var5.t;
				double var10 = var2.p() - var5.u;
				if (((var6 * var6) + (var8 * var8) + (var10 * var10)) < 1024.0D) {
					var5.a.a((new PacketPlayOutBlockBreakAnimation(var1, var2, var3)));
				}
			}
		}

	}
}
