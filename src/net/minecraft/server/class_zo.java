package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class class_zo extends class_yx {
	private static final class_jz f;
	private final Set g;
	private class_aco h;

	public class_zo(class_ago var1) {
		super(var1);
		g = Sets.newHashSet();
	}

	public class_zo(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
		g = Sets.newHashSet();
	}

	public class_zo(class_ago var1, double var2, double var4, double var6, class_aco var8) {
		this(var1, var2, var4, var6);
		this.a(var8);
	}

	public class_zo(class_ago var1, class_rg var2, class_aco var3) {
		super(var1, var2);
		g = Sets.newHashSet();
		this.a(var3);
	}

	private void a(class_aco var1) {
		List var2 = class_adb.h(var1);
		if (!var2.isEmpty()) {
			Iterator var3 = var2.iterator();

			while (var3.hasNext()) {
				class_qr var4 = (class_qr) var3.next();
				g.add(new class_qr(var4));
			}

			ac.b(f, Integer.valueOf(class_adb.a(g)));
		}

		h = var1.k();
		h.b = 1;
	}

	@Override
	protected void h() {
		super.h();
		ac.a(f, Integer.valueOf(0));
	}

	@Override
	public void r_() {
		super.r_();
		int var1;
		double var2;
		double var4;
		double var6;
		if (a) {
			if (o.D) {
				var1 = ((Integer) ac.a(f)).intValue();
				if ((var1 > 0) && ((b % 5) == 0)) {
					var2 = ((var1 >> 16) & 255) / 255.0D;
					var4 = ((var1 >> 8) & 255) / 255.0D;
					var6 = ((var1 >> 0) & 255) / 255.0D;
					o.a(class_cy.p, s + ((V.nextDouble() - 0.5D) * J), t + (V.nextDouble() * K), u + ((V.nextDouble() - 0.5D) * J), var2, var4, var6, new int[0]);
				}
			} else if (!g.isEmpty() && (b >= 200)) {
				o.a(this, (byte) 0);
				g.clear();
				ac.b(f, Integer.valueOf(0));
			}
		} else if (o.D) {
			var1 = ((Integer) ac.a(f)).intValue();
			if (var1 > 0) {
				var2 = ((var1 >> 16) & 255) / 255.0D;
				var4 = ((var1 >> 8) & 255) / 255.0D;
				var6 = ((var1 >> 0) & 255) / 255.0D;

				for (int var8 = 0; var8 < 2; ++var8) {
					o.a(class_cy.p, s + ((V.nextDouble() - 0.5D) * J), t + (V.nextDouble() * K), u + ((V.nextDouble() - 0.5D) * J), var2, var4, var6, new int[0]);
				}
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (h != null) {
			var1.a("Item", h.b(new class_dn()));
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("Item", 10)) {
			h = class_aco.a(var1.o("Item"));
		}

	}

	@Override
	protected void a(class_rg var1) {
		super.a(var1);
		if (!g.isEmpty()) {
			Iterator var2 = g.iterator();

			while (var2.hasNext()) {
				class_qr var3 = (class_qr) var2.next();
				var1.c(var3);
			}
		}

	}

	@Override
	protected class_aco i() {
		return g.isEmpty() ? new class_aco(Items.g) : h;
	}

	static {
		f = class_kc.a(class_zo.class, class_kb.b);
	}
}
