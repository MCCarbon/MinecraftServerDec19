package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class class_apb extends TileEntity {
	private String a = "";
	private String f = "";
	private String g = "";
	private class_cj h = new class_cj(1, 1, 1);
	private class_cj i = new class_cj(0, 0, 0);
	private Block.class_a_in_class_ail j;
	private Block.class_c_in_class_ail k;
	private class_apb.class_a_in_class_apb l;
	private boolean m;

	public class_apb() {
		j = Block.class_a_in_class_ail.a;
		k = Block.class_c_in_class_ail.a;
		l = class_apb.class_a_in_class_apb.d;
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("name", a);
		var1.a("author", f);
		var1.a("metadata", g);
		var1.a("posX", h.n());
		var1.a("posY", h.o());
		var1.a("posZ", h.p());
		var1.a("sizeX", i.n());
		var1.a("sizeY", i.o());
		var1.a("sizeZ", i.p());
		var1.a("rotation", k.toString());
		var1.a("mirror", j.toString());
		var1.a("mode", l.toString());
		var1.a("ignoreEntities", m);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = var1.l("name");
		f = var1.l("author");
		g = var1.l("metadata");
		h = new class_cj(var1.h("posX"), var1.h("posY"), var1.h("posZ"));
		i = new class_cj(var1.h("sizeX"), var1.h("sizeY"), var1.h("sizeZ"));

		try {
			k = Block.class_c_in_class_ail.valueOf(var1.l("rotation"));
		} catch (IllegalArgumentException var5) {
			k = Block.class_c_in_class_ail.a;
		}

		try {
			j = Block.class_a_in_class_ail.valueOf(var1.l("mirror"));
		} catch (IllegalArgumentException var4) {
			j = Block.class_a_in_class_ail.a;
		}

		try {
			l = class_apb.class_a_in_class_apb.valueOf(var1.l("mode"));
		} catch (IllegalArgumentException var3) {
			l = class_apb.class_a_in_class_apb.d;
		}

		m = var1.p("ignoreEntities");
	}

	@Override
	public Packet x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new PacketPlayOutTileEntityData(c, 7, var1);
	}

	public void a(String var1) {
		a = var1;
	}

	public void b(class_cj var1) {
		h = var1;
	}

	public void c(class_cj var1) {
		i = var1;
	}

	public void a(Block.class_a_in_class_ail var1) {
		j = var1;
	}

	public void a(Block.class_c_in_class_ail var1) {
		k = var1;
	}

	public void b(String var1) {
		g = var1;
	}

	public void a(class_apb.class_a_in_class_apb var1) {
		l = var1;
		class_apn var2 = b.p(v());
		if (var2.c() == Blocks.STRUCTURE_BLOCK) {
			b.a(v(), var2.a(class_ann.a, var1), 2);
		}

	}

	public void a(boolean var1) {
		m = var1;
	}

	public boolean l() {
		if (l != class_apb.class_a_in_class_apb.a) {
			return false;
		} else {
			class_cj var1 = v();
			boolean var2 = true;
			class_cj var3 = new class_cj(var1.n() - 128, 0, var1.p() - 128);
			class_cj var4 = new class_cj(var1.n() + 128, 255, var1.p() + 128);
			List var5 = this.a(var3, var4);
			List var6 = this.a(var5);
			if (var6.size() < 1) {
				return false;
			} else {
				class_aua var7 = this.a(var1, var6);
				if (((var7.d - var7.a) > 1) && ((var7.e - var7.b) > 1) && ((var7.f - var7.c) > 1)) {
					h = new class_cj((var7.a - var1.n()) + 1, (var7.b - var1.o()) + 1, (var7.c - var1.p()) + 1);
					i = new class_cj(var7.d - var7.a - 1, var7.e - var7.b - 1, var7.f - var7.c - 1);
					o_();
					b.h(var1);
					return true;
				} else {
					return false;
				}
			}
		}
	}

	private List a(List var1) {
		Iterable var2 = Iterables.filter(var1, (Predicate) (new Predicate() {
			public boolean a(class_apb var1) {
				return (var1.l == class_apb.class_a_in_class_apb.c) && a.equals(var1.a);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_apb) var1);
			}
		}));
		return Lists.newArrayList(var2);
	}

	private List a(class_cj var1, class_cj var2) {
		ArrayList var3 = Lists.newArrayList();
		Iterator var4 = class_cj.b(var1, var2).iterator();

		while (var4.hasNext()) {
			class_cj.class_a_in_class_cj var5 = (class_cj.class_a_in_class_cj) var4.next();
			class_apn var6 = b.p(var5);
			if (var6.c() == Blocks.STRUCTURE_BLOCK) {
				TileEntity var7 = b.s(var5);
				if ((var7 != null) && (var7 instanceof class_apb)) {
					var3.add(var7);
				}
			}
		}

		return var3;
	}

	private class_aua a(class_cj var1, List var2) {
		class_aua var3;
		if (var2.size() > 1) {
			class_cj var4 = ((class_apb) var2.get(0)).v();
			var3 = new class_aua(var4, var4);
		} else {
			var3 = new class_aua(var1, var1);
		}

		Iterator var7 = var2.iterator();

		while (var7.hasNext()) {
			class_apb var5 = (class_apb) var7.next();
			class_cj var6 = var5.v();
			if (var6.n() < var3.a) {
				var3.a = var6.n();
			} else if (var6.n() > var3.d) {
				var3.d = var6.n();
			}

			if (var6.o() < var3.b) {
				var3.b = var6.o();
			} else if (var6.o() > var3.e) {
				var3.e = var6.o();
			}

			if (var6.p() < var3.c) {
				var3.c = var6.p();
			} else if (var6.p() > var3.f) {
				var3.f = var6.p();
			}
		}

		return var3;
	}

	public boolean m() {
		if ((l == class_apb.class_a_in_class_apb.a) && !b.D) {
			class_cj var1 = v().a(h);
			class_auy var2 = ((class_ll) b).x();
			class_ava var3 = var2.a(new class_ke(a));
			var3.a(b, var1, i, !m, Blocks.BARRIER);
			var3.a(f);
			var2.c(new class_ke(a));
			return true;
		} else {
			return false;
		}
	}

	public boolean n() {
		if ((l == class_apb.class_a_in_class_apb.b) && !b.D) {
			class_cj var1 = v().a(h);
			class_auy var2 = ((class_ll) b).x();
			class_ava var3 = var2.a(new class_ke(a));
			if (!class_of.b(var3.b())) {
				f = var3.b();
			}

			if (!i.equals(var3.a())) {
				i = var3.a();
				return false;
			} else {
				class_cj var4 = var3.a(k);
				Iterator var5 = b.b((Entity) null, (new class_ayk(var1, var4.a(var1).a(-1, -1, -1)))).iterator();

				while (var5.hasNext()) {
					Entity var6 = (Entity) var5.next();
					b.f(var6);
				}

				class_auz var7 = (new class_auz()).a(j).a(k).a(m).a((class_agi) null).a((Block) null).b(false);
				var3.a(b, var1, var7);
				return true;
			}
		} else {
			return false;
		}
	}

	public static enum class_a_in_class_apb implements class_oe {
		a("save", 0),
		b("load", 1),
		c("corner", 2),
		d("data", 3);

		private static final class_apb.class_a_in_class_apb[] e;
		private final String f;
		private final int g;

		private class_a_in_class_apb(String var3, int var4) {
			f = var3;
			g = var4;
		}

		@Override
		public String l() {
			return f;
		}

		public int a() {
			return g;
		}

		public static class_apb.class_a_in_class_apb a(int var0) {
			if ((var0 < 0) || (var0 >= e.length)) {
				var0 = 0;
			}

			return e[var0];
		}

		static {
			e = new class_apb.class_a_in_class_apb[values().length];
			class_apb.class_a_in_class_apb[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_apb.class_a_in_class_apb var3 = var0[var2];
				e[var3.a()] = var3;
			}

		}
	}
}
