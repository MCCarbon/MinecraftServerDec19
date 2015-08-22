package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_api extends TileEntity implements class_ks {
	private class_apn a;
	private class_cq f;
	private boolean g;
	private boolean h;
	private float i;
	private float j;
	private List k = Lists.newArrayList();

	public class_api() {
	}

	public class_api(class_apn var1, class_cq var2, boolean var3, boolean var4) {
		a = var1;
		f = var2;
		g = var3;
		h = var4;
	}

	public class_apn b() {
		return a;
	}

	@Override
	public int u() {
		return 0;
	}

	public boolean d() {
		return g;
	}

	public class_cq e() {
		return f;
	}

	public float a(float var1) {
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		return j + ((i - j) * var1);
	}

	private void a(float var1, float var2) {
		if (g) {
			var1 = 1.0F - var1;
		} else {
			--var1;
		}

		class_ayk var3 = Blocks.M.a(b, c, a, var1, f);
		if (var3 != null) {
			List var4 = b.b((Entity) null, var3);
			if (!var4.isEmpty()) {
				k.addAll(var4);
				Iterator var5 = k.iterator();

				while (true) {
					while (var5.hasNext()) {
						Entity var6 = (Entity) var5.next();
						if ((a.c() == Blocks.cE) && g) {
							switch (class_api.SyntheticClass_1.a[f.k().ordinal()]) {
								case 1:
									var6.v = f.g();
									break;
								case 2:
									var6.w = f.h();
									break;
								case 3:
									var6.x = f.i();
							}
						} else {
							var6.d(var2 * f.g(), var2 * f.h(), var2 * f.i());
						}
					}

					k.clear();
					break;
				}
			}
		}

	}

	public void h() {
		if ((j < 1.0F) && (b != null)) {
			j = i = 1.0F;
			b.t(c);
			y();
			if (b.p(c).c() == Blocks.M) {
				b.a(c, a, 3);
				b.e(c, a.c());
			}
		}

	}

	@Override
	public void c() {
		j = i;
		if (j >= 1.0F) {
			this.a(1.0F, 0.25F);
			b.t(c);
			y();
			if (b.p(c).c() == Blocks.M) {
				b.a(c, a, 3);
				b.e(c, a.c());
			}

		} else {
			i += 0.5F;
			if (i >= 1.0F) {
				i = 1.0F;
			}

			if (g) {
				this.a(i, (i - j) + 0.0625F);
			}

		}
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = Block.c(var1.h("blockId")).a(var1.h("blockData"));
		f = class_cq.a(var1.h("facing"));
		j = i = var1.j("progress");
		g = var1.p("extending");
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("blockId", Block.a(a.c()));
		var1.a("blockData", a.c().c(a));
		var1.a("facing", f.a());
		var1.a("progress", j);
		var1.a("extending", g);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.class_a_in_class_cq.values().length];

		static {
			try {
				a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
