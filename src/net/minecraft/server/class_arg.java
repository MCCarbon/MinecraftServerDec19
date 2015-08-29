package net.minecraft.server;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;

public class class_arg {
	private static final Logger a = LogManager.getLogger();
	private static final Predicate b;
	private final class_lj c;
	private final class_ll d;
	private final List e;
	private final class_apr f;
	private int g;
	private int h;
	private int i;
	private int j;
	private boolean k;
	private boolean l;
	private UUID m;
	private boolean n;
	private class_cj o;
	private boolean p;
	private int q;

	public class_arg(class_ll var1, class_dn var2) {
		c = new class_lj(new class_fb("entity.EnderDragon.name", new Object[0]), class_pn.class_a_in_class_pn.a, class_pn.class_b_in_class_pn.a, false, true);
		e = Lists.newArrayList();
		g = 0;
		h = 0;
		i = 0;
		j = 0;
		k = false;
		l = false;
		m = null;
		n = false;
		o = null;
		p = false;
		q = 0;
		d = var1;
		if (var2.b("DragonKilled", 1)) {
			if (var2.b("DragonUUID")) {
				m = var2.a("DragonUUID");
			}

			k = var2.p("DragonKilled");
			l = var2.p("PreviouslyKilled");
			p = var2.p("IsRespawning");
			q = var2.h("RespawnTime");
			if (var2.b("ExitPortalLocation", 10)) {
				o = class_dy.c(var2.o("ExitPortalLocation"));
			}
		} else {
			n = true;
			k = true;
			l = true;
			p = false;
			q = 0;
		}

		if (var2.b("Gateways", 9)) {
			class_du var3 = var2.c("Gateways", 3);

			for (int var4 = 0; var4 < var3.c(); ++var4) {
				e.add(Integer.valueOf(var3.c(var4)));
			}
		} else {
			e.addAll(ContiguousSet.create(Range.closedOpen(Integer.valueOf(0), Integer.valueOf(20)), DiscreteDomain.integers()));
			Collections.shuffle(e, new Random(var1.L()));
		}

		f = class_aps.a().a(new String[] { "       ", "       ", "       ", "   #   ", "       ", "       ", "       " }).a(new String[] { "       ", "       ", "       ", "   #   ", "       ", "       ", "       " }).a(new String[] { "       ", "       ", "       ", "   #   ", "       ", "       ", "       " }).a(new String[] { "  ###  ", " #   # ", "#     #", "#  #  #", "#     #", " #   # ", "  ###  " })
				.a(new String[] { "       ", "  ###  ", " ##### ", " ##### ", " ##### ", "  ###  ", "       " }).a('#', class_apq.a(class_apu.a(Blocks.BEDROCK))).b();
	}

	public class_dn a() {
		if (n) {
			return new class_dn();
		} else {
			class_dn var1 = new class_dn();
			if (m != null) {
				var1.a("DragonUUID", m);
			}

			var1.a("DragonKilled", k);
			var1.a("PreviouslyKilled", l);
			if (o != null) {
				var1.a("ExitPortalLocation", class_dy.a(o));
			}

			class_du var2 = new class_du();
			Iterator var3 = e.iterator();

			while (var3.hasNext()) {
				int var4 = ((Integer) var3.next()).intValue();
				var2.a((new class_dt(var4)));
			}

			var1.a("Gateways", var2);
			return var1;
		}
	}

	public void b() {
		c.c(!k);
		if (++j >= 20) {
			j();
			j = 0;
		}

		if (!c.c().isEmpty()) {
			List var1;
			if (n) {
				a.info("Scanning for legacy world dragon fight...");
				i();
				n = false;
				if (g()) {
					a.info("Found that the dragon has been killed in this world already.");
					l = true;
				} else {
					a.info("Found that the dragon has not yet been killed in this world.");
					l = false;
				}

				var1 = d.a(class_vx.class, class_rb.a);
				if (!var1.isEmpty()) {
					class_vx var2 = (class_vx) var1.get(0);
					m = var2.aQ();
					a.info("Found that there\'s a dragon still alive (" + var2 + ")");
					k = false;
				} else {
					k = true;
				}

				if (!l && k) {
					k = false;
				}
			}

			if (p) {
				++q;
				if (q <= 400) {
					f();
				} else {
					class_atm.class_a_in_class_atm[] var8 = class_ahz.a(d);
					class_atm var9 = new class_atm();
					Random var3 = new Random();
					class_atm.class_a_in_class_atm[] var4 = var8;
					int var5 = var8.length;

					for (int var6 = 0; var6 < var5; ++var6) {
						class_atm.class_a_in_class_atm var7 = var4[var6];
						var9.a(var7);
						var9.b(d, var3, new class_cj(var7.a(), 45, var7.b()));
					}

					p = false;
					q = 0;
					k = false;
					m();
				}
			}

			if (!k) {
				if ((m == null) || (++g >= 1200)) {
					i();
					var1 = d.a(class_vx.class, class_rb.a);
					if (!var1.isEmpty()) {
						m = ((class_vx) var1.get(0)).aQ();
					} else {
						m();
						this.a(false);
					}

					g = 0;
				}

				if (++i >= 100) {
					k();
					i = 0;
				}
			}
		}

	}

	private void f() {
		if ((q % 40) == 0) {
			class_atm.class_a_in_class_atm[] var1 = class_ahz.a(d);
			int var2 = q / 40;
			if ((var2 >= 0) && (var2 < var1.length)) {
				class_atm.class_a_in_class_atm var3 = var1[var2];
				byte var4 = 10;
				Iterator var5 = class_cj.b(new class_cj(var3.a() - var4, var3.d() - var4, var3.b() - var4), new class_cj(var3.a() + var4, var3.d() + var4, var3.b() + var4)).iterator();

				while (var5.hasNext()) {
					class_cj.class_a_in_class_cj var6 = (class_cj.class_a_in_class_cj) var5.next();
					d.g(var6);
				}

				d.a((Entity) null, var3.a() + 0.5F, var3.d(), var3.b() + 0.5F, 5.0F, true);
				class_atm var7 = new class_atm();
				var7.a(var3);
				var7.a(false);
				var7.b(d, new Random(), new class_cj(var3.a(), 45, var3.b()));
			}
		}

	}

	private boolean g() {
		for (int var1 = -8; var1 <= 8; ++var1) {
			for (int var2 = -8; var2 <= 8; ++var2) {
				class_aqn var3 = d.a(var1, var2);
				Iterator var4 = var3.s().values().iterator();

				while (var4.hasNext()) {
					TileEntity var5 = (TileEntity) var4.next();
					if (var5 instanceof class_apd) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private class_apr.class_b_in_class_apr h() {
		int var1;
		int var2;
		for (var1 = -8; var1 <= 8; ++var1) {
			for (var2 = -8; var2 <= 8; ++var2) {
				class_aqn var3 = d.a(var1, var2);
				Iterator var4 = var3.s().values().iterator();

				while (var4.hasNext()) {
					TileEntity var5 = (TileEntity) var4.next();
					if (var5 instanceof class_apd) {
						class_apr.class_b_in_class_apr var6 = f.a(d, var5.v());
						if (var6 != null) {
							class_cj var7 = var6.a(3, 3, 4).d();
							if ((o == null) && (var7.n() == 0) && (var7.p() == 0)) {
								o = var7;
							}

							return var6;
						}
					}
				}
			}
		}

		var1 = d.m(class_aso.a).o();

		for (var2 = var1; var2 >= 0; --var2) {
			class_apr.class_b_in_class_apr var8 = f.a(d, new class_cj(class_aso.a.n(), var2, class_aso.a.p()));
			if (var8 != null) {
				if (o == null) {
					o = var8.a(3, 3, 4).d();
				}

				return var8;
			}
		}

		return null;
	}

	private void i() {
		for (int var1 = -8; var1 <= 8; ++var1) {
			for (int var2 = -8; var2 <= 8; ++var2) {
				d.a(var1, var2);
			}
		}

	}

	private void j() {
		HashSet var1 = Sets.newHashSet();
		Iterator var2 = d.b(class_lm.class, b).iterator();

		while (var2.hasNext()) {
			class_lm var3 = (class_lm) var2.next();
			c.a(var3);
			var1.add(var3);
		}

		HashSet var5 = Sets.newHashSet((Iterable) c.c());
		var5.removeAll(var1);
		Iterator var6 = var5.iterator();

		while (var6.hasNext()) {
			class_lm var4 = (class_lm) var6.next();
			c.b(var4);
		}

	}

	private void k() {
		i = 0;
		h = 0;
		class_atm.class_a_in_class_atm[] var1 = class_ahz.a(d);
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_atm.class_a_in_class_atm var4 = var1[var3];
			h += d.a(EntityEnderCrystal.class, var4.f()).size();
		}

		a.debug("Found {} end crystals still alive", new Object[] { Integer.valueOf(h) });
	}

	public void a(class_vx var1) {
		if (var1.aQ().equals(m)) {
			c.a(0.0F);
			c.c(false);
			this.a(true);
			l();
			if (!l) {
				d.a(d.m(class_aso.a), Blocks.DRAGON_EGG.getBlockData());
			}

			l = true;
			k = true;
		}

	}

	private void l() {
		if (!e.isEmpty()) {
			int var1 = ((Integer) e.remove(e.size() - 1)).intValue();
			int var2 = (int) (96.0D * Math.cos(2.0D * (-3.141592653589793D + (0.15707963267948966D * var1))));
			int var3 = (int) (96.0D * Math.sin(2.0D * (-3.141592653589793D + (0.15707963267948966D * var1))));
			this.a(new class_cj(var2, 75, var3));
		}
	}

	private void a(class_cj var1) {
		d.b(3000, var1, 0);
		(new class_asm()).b(d, new Random(), var1);
	}

	private void a(boolean var1) {
		class_aso var2 = new class_aso(var1);
		if (o == null) {
			for (o = d.r(class_aso.a).b(); (d.p(o).c() == Blocks.BEDROCK) && (o.o() > d.H()); o = o.b()) {
				;
			}
		}

		var2.b(d, new Random(), o);
	}

	private void m() {
		d.f(new class_cj(0, 128, 0));
		class_vx var1 = new class_vx(d);
		var1.b(0.0D, 128.0D, 0.0D, d.s.nextFloat() * 360.0F, 0.0F);
		d.a(var1);
		m = var1.aQ();
	}

	public void b(class_vx var1) {
		if (var1.aQ().equals(m)) {
			c.a(var1.bu() / var1.bB());
			g = 0;
		}

	}

	public int c() {
		return h;
	}

	public void a(EntityEnderCrystal var1, class_qi var2) {
		k();
		Entity var3 = d.a(m);
		if (var3 instanceof class_vx) {
			((class_vx) var3).a(var1, new class_cj(var1), var2);
		}

	}

	public boolean d() {
		return l;
	}

	public void e() {
		if (k && !p) {
			for (class_apr.class_b_in_class_apr var1 = h(); var1 != null; var1 = h()) {
				for (int var2 = 0; var2 < f.c(); ++var2) {
					for (int var3 = 0; var3 < f.b(); ++var3) {
						for (int var4 = 0; var4 < f.a(); ++var4) {
							class_apq var5 = var1.a(var2, var3, var4);
							if ((var5.a().c() == Blocks.BEDROCK) || (var5.a().c() == Blocks.END_PORTAL)) {
								d.a(var5.d(), Blocks.END_STONE.getBlockData());
							}
						}
					}
				}
			}

			p = true;
			q = 0;
			this.a(false);
		}

	}

	static {
		b = Predicates.and(class_rb.a, class_rb.a(0.0D, 128.0D, 0.0D, 192.0D));
	}
}
