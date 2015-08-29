package net.minecraft.server;

import java.text.DecimalFormat;
import java.util.Random;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public final class class_aco {
	public static final DecimalFormat a = new DecimalFormat("#.##");
	public int b;
	public int c;
	private Item d;
	private class_dn e;
	private int f;
	private EntityItemFrame g;
	private Block h;
	private boolean i;
	private Block j;
	private boolean k;

	public class_aco(Block var1) {
		this(var1, 1);
	}

	public class_aco(Block var1, int var2) {
		this(var1, var2, 0);
	}

	public class_aco(Block var1, int var2, int var3) {
		this(Item.a(var1), var2, var3);
	}

	public class_aco(Item var1) {
		this(var1, 1);
	}

	public class_aco(Item var1, int var2) {
		this(var1, var2, 0);
	}

	public class_aco(Item var1, int var2, int var3) {
		h = null;
		i = false;
		j = null;
		k = false;
		d = var1;
		b = var2;
		f = var3;
		if (f < 0) {
			f = 0;
		}

	}

	public static class_aco a(class_dn var0) {
		class_aco var1 = new class_aco();
		var1.c(var0);
		return var1.b() != null ? var1 : null;
	}

	private class_aco() {
		h = null;
		i = false;
		j = null;
		k = false;
	}

	public class_aco a(int var1) {
		class_aco var2 = new class_aco(d, var1, f);
		if (e != null) {
			var2.e = (class_dn) e.b();
		}

		b -= var1;
		return var2;
	}

	public Item b() {
		return d;
	}

	public class_pw a(class_yu var1, class_ago var2, class_cj var3, class_pu var4, class_cq var5, float var6, float var7, float var8) {
		class_pw var9 = this.b().a(this, var1, var2, var3, var4, var5, var6, var7, var8);
		if (var9 == class_pw.a) {
			var1.b(StatisticList.c(Item.b(d)));
		}

		return var9;
	}

	public float a(Block var1) {
		return this.b().a(this, var1);
	}

	public class_px a(class_ago var1, class_yu var2, class_pu var3) {
		return this.b().a(this, var1, var2, var3);
	}

	public class_aco a(class_ago var1, EntityLiving var2) {
		return this.b().a(this, var1, var2);
	}

	public class_dn b(class_dn var1) {
		class_ke var2 = (class_ke) Item.e.b(d);
		var1.a("id", var2 == null ? "minecraft:air" : var2.toString());
		var1.a("Count", (byte) b);
		var1.a("Damage", (short) f);
		if (e != null) {
			var1.a("tag", e);
		}

		return var1;
	}

	public void c(class_dn var1) {
		d = Item.d(var1.l("id"));
		b = var1.f("Count");
		f = var1.g("Damage");
		if (f < 0) {
			f = 0;
		}

		if (var1.b("tag", 10)) {
			e = var1.o("tag");
			if (d != null) {
				d.a(e);
			}
		}

	}

	public int c() {
		return this.b().j();
	}

	public boolean d() {
		return (this.c() > 1) && (!e() || !g());
	}

	public boolean e() {
		return d == null ? false : (d.l() <= 0 ? false : !n() || !o().p("Unbreakable"));
	}

	public boolean f() {
		return d.k();
	}

	public boolean g() {
		return e() && (f > 0);
	}

	public int h() {
		return f;
	}

	public int i() {
		return f;
	}

	public void b(int var1) {
		f = var1;
		if (f < 0) {
			f = 0;
		}

	}

	public int j() {
		return d == null ? 0 : d.l();
	}

	public boolean a(int var1, Random var2) {
		if (!e()) {
			return false;
		} else {
			if (var1 > 0) {
				int var3 = class_afl.a(class_afn.r, this);
				int var4 = 0;

				for (int var5 = 0; (var3 > 0) && (var5 < var1); ++var5) {
					if (class_afh.a(this, var3, var2)) {
						++var4;
					}
				}

				var1 -= var4;
				if (var1 <= 0) {
					return false;
				}
			}

			f += var1;
			return f > j();
		}
	}

	public void a(int var1, EntityLiving var2) {
		if (!(var2 instanceof class_yu) || !((class_yu) var2).bI.d) {
			if (e()) {
				if (this.a(var1, var2.bj())) {
					var2.b(this);
					--b;
					if (var2 instanceof class_yu) {
						class_yu var3 = (class_yu) var2;
						var3.b(StatisticList.d(Item.b(d)));
					}

					if (b < 0) {
						b = 0;
					}

					f = 0;
				}

			}
		}
	}

	public void a(EntityLiving var1, class_yu var2) {
		boolean var3 = d.a(this, var1, var2);
		if (var3) {
			var2.b(StatisticList.c(Item.b(d)));
		}

	}

	public void a(class_ago var1, Block var2, class_cj var3, class_yu var4) {
		boolean var5 = d.a(this, var1, var2, var3, var4);
		if (var5) {
			var4.b(StatisticList.c(Item.b(d)));
		}

	}

	public boolean b(Block var1) {
		return d.b(var1);
	}

	public boolean a(class_yu var1, EntityLiving var2, class_pu var3) {
		return d.a(this, var1, var2, var3);
	}

	public class_aco k() {
		class_aco var1 = new class_aco(d, b, f);
		if (e != null) {
			var1.e = (class_dn) e.b();
		}

		return var1;
	}

	public static boolean a(class_aco var0, class_aco var1) {
		return (var0 == null) && (var1 == null) ? true : ((var0 != null) && (var1 != null) ? ((var0.e == null) && (var1.e != null) ? false : (var0.e == null) || var0.e.equals(var1.e)) : false);
	}

	public static boolean b(class_aco var0, class_aco var1) {
		return (var0 == null) && (var1 == null) ? true : ((var0 != null) && (var1 != null) ? var0.d(var1) : false);
	}

	private boolean d(class_aco var1) {
		return b != var1.b ? false : (d != var1.d ? false : (f != var1.f ? false : ((e == null) && (var1.e != null) ? false : (e == null) || e.equals(var1.e))));
	}

	public static boolean c(class_aco var0, class_aco var1) {
		return var0 == var1 ? true : ((var0 != null) && (var1 != null) ? var0.a(var1) : false);
	}

	public boolean a(class_aco var1) {
		return (var1 != null) && (d == var1.d) && (f == var1.f);
	}

	public String a() {
		return d.e_(this);
	}

	public static class_aco b(class_aco var0) {
		return var0 == null ? null : var0.k();
	}

	@Override
	public String toString() {
		return b + "x" + d.a() + "@" + f;
	}

	public void a(class_ago var1, Entity var2, int var3, boolean var4) {
		if (c > 0) {
			--c;
		}

		if (d != null) {
			d.a(this, var1, var2, var3, var4);
		}

	}

	public void a(class_ago var1, class_yu var2, int var3) {
		var2.a(StatisticList.b(Item.b(d)), var3);
		d.b(this, var1, var2);
	}

	public int l() {
		return this.b().e(this);
	}

	public class_ady m() {
		return this.b().f(this);
	}

	public void a(class_ago var1, EntityLiving var2, int var3) {
		this.b().a(this, var1, var2, var3);
	}

	public boolean n() {
		return e != null;
	}

	public class_dn o() {
		return e;
	}

	public class_dn a(String var1, boolean var2) {
		if ((e != null) && e.b(var1, 10)) {
			return e.o(var1);
		} else if (var2) {
			class_dn var3 = new class_dn();
			this.a(var1, var3);
			return var3;
		} else {
			return null;
		}
	}

	public class_du p() {
		return e == null ? null : e.c("ench", 10);
	}

	public void d(class_dn var1) {
		e = var1;
	}

	public String q() {
		String var1 = this.b().a(this);
		if ((e != null) && e.b("display", 10)) {
			class_dn var2 = e.o("display");
			if (var2.b("Name", 8)) {
				var1 = var2.l("Name");
			}
		}

		return var1;
	}

	public class_aco c(String var1) {
		if (e == null) {
			e = new class_dn();
		}

		if (!e.b("display", 10)) {
			e.a("display", (new class_dn()));
		}

		e.o("display").a("Name", var1);
		return this;
	}

	public void r() {
		if (e != null) {
			if (e.b("display", 10)) {
				class_dn var1 = e.o("display");
				var1.q("Name");
				if (var1.c_()) {
					e.q("display");
					if (e.c_()) {
						this.d((class_dn) null);
					}
				}

			}
		}
	}

	public boolean s() {
		return e == null ? false : (!e.b("display", 10) ? false : e.o("display").b("Name", 8));
	}

	public class_adc u() {
		return this.b().g(this);
	}

	public boolean v() {
		return !this.b().f_(this) ? false : !w();
	}

	public void a(class_afj var1, int var2) {
		if (e == null) {
			this.d(new class_dn());
		}

		if (!e.b("ench", 9)) {
			e.a("ench", (new class_du()));
		}

		class_du var3 = e.c("ench", 10);
		class_dn var4 = new class_dn();
		var4.a("id", (short) class_afj.b(var1));
		var4.a("lvl", (short) ((byte) var2));
		var3.a(var4);
	}

	public boolean w() {
		return (e != null) && e.b("ench", 9);
	}

	public void a(String var1, class_eb var2) {
		if (e == null) {
			this.d(new class_dn());
		}

		e.a(var1, var2);
	}

	public boolean x() {
		return this.b().s();
	}

	public boolean y() {
		return g != null;
	}

	public void a(EntityItemFrame var1) {
		g = var1;
	}

	public EntityItemFrame z() {
		return g;
	}

	public int A() {
		return n() && e.b("RepairCost", 3) ? e.h("RepairCost") : 0;
	}

	public void c(int var1) {
		if (!n()) {
			e = new class_dn();
		}

		e.a("RepairCost", var1);
	}

	public Multimap a(class_rc var1) {
		Object var2;
		if (n() && e.b("AttributeModifiers", 9)) {
			var2 = HashMultimap.create();
			class_du var3 = e.c("AttributeModifiers", 10);

			for (int var4 = 0; var4 < var3.c(); ++var4) {
				class_dn var5 = var3.b(var4);
				class_rr var6 = class_yf.a(var5);
				if ((var6 != null) && (var6.a().getLeastSignificantBits() != 0L) && (var6.a().getMostSignificantBits() != 0L)) {
					((Multimap) var2).put(var5.l("AttributeName"), var6);
				}
			}
		} else {
			var2 = this.b().a(var1);
		}

		return (Multimap) var2;
	}

	public void a(Item var1) {
		d = var1;
	}

	public IChatBaseComponent B() {
		class_fa var1 = new class_fa(q());
		if (s()) {
			var1.b().b(Boolean.valueOf(true));
		}

		IChatBaseComponent var2 = (new class_fa("[")).a(var1).a("]");
		if (d != null) {
			class_dn var3 = new class_dn();
			this.b(var3);
			var2.b().a(new class_ew(class_ew.class_a_in_class_ew.c, new class_fa(var3.toString())));
			var2.b().a(u().e);
		}

		return var2;
	}

	public boolean c(Block var1) {
		if (var1 == h) {
			return i;
		} else {
			h = var1;
			if (n() && e.b("CanDestroy", 9)) {
				class_du var2 = e.c("CanDestroy", 8);

				for (int var3 = 0; var3 < var2.c(); ++var3) {
					Block var4 = Block.b(var2.g(var3));
					if (var4 == var1) {
						i = true;
						return true;
					}
				}
			}

			i = false;
			return false;
		}
	}

	public boolean d(Block var1) {
		if (var1 == j) {
			return k;
		} else {
			j = var1;
			if (n() && e.b("CanPlaceOn", 9)) {
				class_du var2 = e.c("CanPlaceOn", 8);

				for (int var3 = 0; var3 < var2.c(); ++var3) {
					Block var4 = Block.b(var2.g(var3));
					if (var4 == var1) {
						k = true;
						return true;
					}
				}
			}

			k = false;
			return false;
		}
	}
}
