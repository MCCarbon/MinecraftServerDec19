package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_qh {
	private final List a = Lists.newArrayList();
	private final class_rg b;
	private int c;
	private int d;
	private int e;
	private boolean f;
	private boolean g;
	private String h;

	public class_qh(class_rg var1) {
		b = var1;
	}

	public void a() {
		k();
		if (b.j_()) {
			Block var1 = b.o.p(new class_cj(b.s, b.aX().b, b.u)).c();
			if (var1 == Blocks.LADDER) {
				h = "ladder";
			} else if (var1 == Blocks.VINE) {
				h = "vines";
			}
		} else if (b.Y()) {
			h = "water";
		}

	}

	public void a(class_qi var1, float var2, float var3) {
		g();
		this.a();
		class_qg var4 = new class_qg(var1, b.W, var2, var3, h, b.O);
		a.add(var4);
		c = b.W;
		g = true;
		if (var4.f() && !f && b.al()) {
			f = true;
			d = b.W;
			e = d;
			b.i();
		}

	}

	public class_eu b() {
		if (a.isEmpty()) {
			return new class_fb("death.attack.generic", new Object[] { b.f_() });
		} else {
			class_qg var1 = j();
			class_qg var2 = (class_qg) a.get(a.size() - 1);
			class_eu var4 = var2.h();
			Entity var5 = var2.a().j();
			Object var3;
			if ((var1 != null) && (var2.a() == class_qi.i)) {
				class_eu var6 = var1.h();
				if ((var1.a() != class_qi.i) && (var1.a() != class_qi.j)) {
					if ((var6 == null) || ((var4 != null) && var6.equals(var4))) {
						if (var4 != null) {
							class_aco var9 = var5 instanceof class_rg ? ((class_rg) var5).bG() : null;
							if ((var9 != null) && var9.s()) {
								var3 = new class_fb("death.fell.finish.item", new Object[] { b.f_(), var4, var9.B() });
							} else {
								var3 = new class_fb("death.fell.finish", new Object[] { b.f_(), var4 });
							}
						} else {
							var3 = new class_fb("death.fell.killer", new Object[] { b.f_() });
						}
					} else {
						Entity var7 = var1.a().j();
						class_aco var8 = var7 instanceof class_rg ? ((class_rg) var7).bG() : null;
						if ((var8 != null) && var8.s()) {
							var3 = new class_fb("death.fell.assist.item", new Object[] { b.f_(), var6, var8.B() });
						} else {
							var3 = new class_fb("death.fell.assist", new Object[] { b.f_(), var6 });
						}
					}
				} else {
					var3 = new class_fb("death.fell.accident." + this.a(var1), new Object[] { b.f_() });
				}
			} else {
				var3 = var2.a().c(b);
			}

			return (class_eu) var3;
		}
	}

	public class_rg c() {
		class_rg var1 = null;
		class_yu var2 = null;
		float var3 = 0.0F;
		float var4 = 0.0F;
		Iterator var5 = a.iterator();

		while (true) {
			class_qg var6;
			do {
				do {
					if (!var5.hasNext()) {
						if ((var2 != null) && (var4 >= (var3 / 3.0F))) {
							return var2;
						}

						return var1;
					}

					var6 = (class_qg) var5.next();
					if ((var6.a().j() instanceof class_yu) && ((var2 == null) || (var6.c() > var4))) {
						var4 = var6.c();
						var2 = (class_yu) var6.a().j();
					}
				} while (!(var6.a().j() instanceof class_rg));
			} while ((var1 != null) && (var6.c() <= var3));

			var3 = var6.c();
			var1 = (class_rg) var6.a().j();
		}
	}

	private class_qg j() {
		class_qg var1 = null;
		class_qg var2 = null;
		float var3 = 0.0F;
		float var4 = 0.0F;

		for (int var5 = 0; var5 < a.size(); ++var5) {
			class_qg var6 = (class_qg) a.get(var5);
			class_qg var7 = var5 > 0 ? (class_qg) a.get(var5 - 1) : null;
			if (((var6.a() == class_qi.i) || (var6.a() == class_qi.j)) && (var6.j() > 0.0F) && ((var1 == null) || (var6.j() > var4))) {
				if (var5 > 0) {
					var1 = var7;
				} else {
					var1 = var6;
				}

				var4 = var6.j();
			}

			if ((var6.g() != null) && ((var2 == null) || (var6.c() > var3))) {
				var2 = var6;
				var3 = var6.c();
			}
		}

		if ((var4 > 5.0F) && (var1 != null)) {
			return var1;
		} else if ((var3 > 5.0F) && (var2 != null)) {
			return var2;
		} else {
			return null;
		}
	}

	private String a(class_qg var1) {
		return var1.g() == null ? "generic" : var1.g();
	}

	public int f() {
		return f ? b.W - d : e - d;
	}

	private void k() {
		h = null;
	}

	public void g() {
		int var1 = f ? 300 : 100;
		if (g && (!b.al() || ((b.W - c) > var1))) {
			boolean var2 = f;
			g = false;
			f = false;
			e = b.W;
			if (var2) {
				b.j();
			}

			a.clear();
		}

	}

	public class_rg h() {
		return b;
	}
}
