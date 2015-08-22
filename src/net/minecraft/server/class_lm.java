package net.minecraft.server;

import io.netty.buffer.Unpooled;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;

public class class_lm extends class_yu implements class_zz {
	private static final Logger bP = LogManager.getLogger();
	private String bQ = "en_US";
	public class_lt a;
	public final MinecraftServer b;
	public final class_ln c;
	public double d;
	public double e;
	public final List f = Lists.newLinkedList();
	private final List bR = Lists.newLinkedList();
	private final class_nc bS;
	private float bT = Float.MIN_VALUE;
	private int bU = Integer.MIN_VALUE;
	private int bV = Integer.MIN_VALUE;
	private int bW = Integer.MIN_VALUE;
	private int bX = Integer.MIN_VALUE;
	private int bY = Integer.MIN_VALUE;
	private float bZ = -1.0E8F;
	private int ca = -99999999;
	private boolean cb = true;
	private int cc = -99999999;
	private int cd = 60;
	private class_yu.class_b_in_class_yu ce;
	private boolean cf = true;
	private long cg = System.currentTimeMillis();
	private class_qx ch = null;
	private int ci;
	public boolean g;
	public int h;
	public boolean i;

	public class_lm(MinecraftServer var1, class_ll var2, GameProfile var3, class_ln var4) {
		super(var2, var3);
		var4.b = this;
		c = var4;
		class_cj var5 = var2.O();
		if (!var2.t.m() && (var2.R().q() != class_agr.class_a_in_class_agr.d)) {
			int var6 = Math.max(5, var1.ay() - 6);
			int var7 = class_oa.c(var2.ah().b(var5.n(), var5.p()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.a(V.nextInt(var6 * 2) - var6, 0, V.nextInt(var6 * 2) - var6));
		}

		b = var1;
		bS = var1.ar().a((class_yu) this);
		S = 0.0F;
		this.a(var5, 0.0F, 0.0F);

		while (!var2.a(this, aX()).isEmpty() && (t < 255.0D)) {
			this.b(s, t + 1.0D, u);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("playerGameType", 99)) {
			if (MinecraftServer.P().az()) {
				c.a(MinecraftServer.P().m());
			} else {
				c.a(class_agr.class_a_in_class_agr.a(var1.h("playerGameType")));
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("playerGameType", c.b().a());
	}

	@Override
	public void a(int var1) {
		super.a(var1);
		cc = -1;
	}

	@Override
	public void b(int var1) {
		super.b(var1);
		cc = -1;
	}

	public void g_() {
		bs.a((class_zz) this);
	}

	@Override
	public void i() {
		super.i();
		a.a((new class_gz(bz(), class_gz.class_a_in_class_gz.a)));
	}

	@Override
	public void j() {
		super.j();
		a.a((new class_gz(bz(), class_gz.class_a_in_class_gz.b)));
	}

	@Override
	protected class_acn k() {
		return new class_adi(this);
	}

	@Override
	public void r_() {
		c.a();
		--cd;
		if (Z > 0) {
			--Z;
		}

		bs.b();
		if (!o.D && !bs.a((class_yu) this)) {
			this.o();
			bs = br;
		}

		int var4;
		while (!bR.isEmpty()) {
			int var1 = Math.min(bR.size(), Integer.MAX_VALUE);
			int[] var2 = new int[var1];
			Iterator var3 = bR.iterator();
			var4 = 0;

			while (var3.hasNext() && (var4 < var1)) {
				var2[var4++] = ((Integer) var3.next()).intValue();
				var3.remove();
			}

			a.a((new class_hc(var2)));
		}

		if (!f.isEmpty()) {
			ArrayList var6 = Lists.newArrayList();
			Iterator var8 = f.iterator();
			ArrayList var9 = Lists.newArrayList();

			class_aqn var5;
			while (var8.hasNext() && (var6.size() < 10)) {
				class_agi var10 = (class_agi) var8.next();
				if (var10 != null) {
					if (o.e(new class_cj(var10.a << 4, 0, var10.b << 4))) {
						var5 = o.a(var10.a, var10.b);
						if (var5.i()) {
							var6.add(var5);
							var9.addAll(((class_ll) o).a(var10.a * 16, 0, var10.b * 16, (var10.a * 16) + 16, 256, (var10.b * 16) + 16));
							var8.remove();
						}
					}
				} else {
					var8.remove();
				}
			}

			if (!var6.isEmpty()) {
				if (var6.size() == 1) {
					a.a((new class_gp((class_aqn) var6.get(0), true, '\uffff')));
				} else {
					var4 = 0;

					for (int var11 = var6.size(); var4 < var11; ++var4) {
						a.a((new class_gp((class_aqn) var6.get(var4), true, '\uffff')));
					}
				}

				Iterator var12 = var9.iterator();

				while (var12.hasNext()) {
					class_aoi var13 = (class_aoi) var12.next();
					this.a(var13);
				}

				var12 = var6.iterator();

				while (var12.hasNext()) {
					var5 = (class_aqn) var12.next();
					v().u().a(this, var5);
				}
			}
		}

		class_qx var7 = D();
		if (var7 != this) {
			if (!var7.al()) {
				this.e(this);
			} else {
				this.a(var7.s, var7.t, var7.u, var7.y, var7.z);
				b.ar().d(this);
				if (aA()) {
					this.e(this);
				}
			}
		}

	}

	public void h_() {
		try {
			super.r_();

			for (int var1 = 0; var1 < bq.n_(); ++var1) {
				class_aco var5 = bq.a(var1);
				if ((var5 != null) && var5.b().f()) {
					class_ff var6 = ((class_abo) var5.b()).a(var5, o, this);
					if (var6 != null) {
						a.a(var6);
					}
				}
			}

			if ((bu() != bZ) || (ca != bt.a()) || ((bt.e() == 0.0F) != cb)) {
				a.a((new class_hq(bu(), bt.a(), bt.e())));
				bZ = bu();
				ca = bt.a();
				cb = bt.e() == 0.0F;
			}

			if ((bu() + bU()) != bT) {
				bT = bu() + bU();
				this.a(class_ayy.g, class_oa.f(bT));
			}

			if (bt.a() != bU) {
				bU = bt.a();
				this.a(class_ayy.h, class_oa.f(bU));
			}

			if (aF() != bV) {
				bV = aF();
				this.a(class_ayy.i, class_oa.f(bV));
			}

			if (by() != bW) {
				bW = by();
				this.a(class_ayy.j, class_oa.f(bW));
			}

			if (bK != bY) {
				bY = bK;
				this.a(class_ayy.k, class_oa.f(bY));
			}

			if (bJ != bX) {
				bX = bJ;
				this.a(class_ayy.l, class_oa.f(bX));
			}

			if (bK != cc) {
				cc = bK;
				a.a((new class_hp(bL, bK, bJ)));
			}

			if ((((W % 20) * 5) == 0) && !B().a(class_my.L)) {
				this.n();
			}

		} catch (Throwable var4) {
			class_b var2 = class_b.a(var4, "Ticking player");
			class_c var3 = var2.a("Player being ticked");
			this.a(var3);
			throw new class_e(var2);
		}
	}

	private void a(class_ayy var1, int var2) {
		Collection var3 = cx().a(var1);
		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			class_ayo var5 = (class_ayo) var4.next();
			class_ayq var6 = cx().c(e_(), var5);
			var6.c(var2);
		}

	}

	protected void n() {
		class_ahb var1 = o.b(new class_cj(class_oa.c(s), 0, class_oa.c(u)));
		String var2 = var1.ah;
		class_nj var3 = (class_nj) B().b((class_nd) class_my.L);
		if (var3 == null) {
			var3 = (class_nj) B().a(class_my.L, new class_nj());
		}

		var3.add(var2);
		if (B().b(class_my.L) && (var3.size() >= class_ahb.n.size())) {
			HashSet var4 = Sets.newHashSet((Iterable) class_ahb.n);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				Iterator var7 = var4.iterator();

				while (var7.hasNext()) {
					class_ahb var8 = (class_ahb) var7.next();
					if (var8.ah.equals(var6)) {
						var7.remove();
					}
				}

				if (var4.isEmpty()) {
					break;
				}
			}

			if (var4.isEmpty()) {
				this.b(class_my.L);
			}
		}

	}

	@Override
	public void a(class_qi var1) {
		a.a((new class_gz(bz(), class_gz.class_a_in_class_gz.c)));
		if (o.S().b("showDeathMessages")) {
			class_ayu var2 = aE();
			if ((var2 != null) && (var2.j() != class_ayu.class_a_in_class_ayu.a)) {
				if (var2.j() == class_ayu.class_a_in_class_ayu.c) {
					b.ar().a(this, bz().b());
				} else if (var2.j() == class_ayu.class_a_in_class_ayu.d) {
					b.ar().b(this, bz().b());
				}
			} else {
				b.ar().a(bz().b());
			}
		}

		if (!o.S().b("keepInventory")) {
			bq.m();
		}

		Collection var6 = o.ab().a(class_ayy.d);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			class_ayo var4 = (class_ayo) var3.next();
			class_ayq var5 = cx().c(e_(), var4);
			var5.a();
		}

		class_rg var7 = bA();
		if (var7 != null) {
			class_qz.class_a_in_class_qz var8 = (class_qz.class_a_in_class_qz) class_qz.a.get(class_qz.b(var7));
			if (var8 != null) {
				this.b(var8.e);
			}

			var7.b(this, ba);
		}

		this.b(class_nh.z);
		this.a(class_nh.h);
		bz().g();
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			boolean var3 = b.ag() && cC() && "fall".equals(var1.q);
			if (!var3 && (cd > 0) && (var1 != class_qi.j)) {
				return false;
			} else {
				if (var1 instanceof class_qj) {
					class_qx var4 = var1.j();
					if ((var4 instanceof class_yu) && !this.a((class_yu) var4)) {
						return false;
					}

					if (var4 instanceof class_yx) {
						class_yx var5 = (class_yx) var4;
						if ((var5.e instanceof class_yu) && !this.a((class_yu) var5.e)) {
							return false;
						}
					}
				}

				return super.a(var1, var2);
			}
		}
	}

	@Override
	public boolean a(class_yu var1) {
		return !cC() ? false : super.a(var1);
	}

	private boolean cC() {
		return b.al();
	}

	@Override
	public class_qx a(int var1, class_cj var2) {
		if ((am == 1) && (var1 == 1)) {
			this.b(class_my.D);
			o.e(this);
			i = true;
			a.a((new class_gn(4, 0.0F)));
			return this;
		} else {
			if ((am == 0) && (var1 == 1)) {
				this.b(class_my.C);
				class_cj var3 = b.a(var1).o();
				if (var3 != null) {
					a.a(var3.n(), var3.o(), var3.p(), 0.0F, 0.0F);
				}

				var1 = 1;
			} else {
				this.b(class_my.y);
			}

			b.ar().a(this, var1, var2);
			cc = -1;
			bZ = -1.0F;
			ca = -1;
			return this;
		}
	}

	@Override
	public boolean a(class_lm var1) {
		return var1.w() ? D() == this : (w() ? false : super.a(var1));
	}

	private void a(class_aoi var1) {
		if (var1 != null) {
			class_ff var2 = var1.x_();
			if (var2 != null) {
				a.a(var2);
			}
		}

	}

	@Override
	public void a(class_qx var1, int var2) {
		super.a(var1, var2);
		bs.b();
	}

	@Override
	public class_yu.class_a_in_class_yu a(class_cj var1) {
		class_yu.class_a_in_class_yu var2 = super.a(var1);
		if (var2 == class_yu.class_a_in_class_yu.a) {
			class_hb var3 = new class_hb(this, var1);
			v().u().a(this, var3);
			a.a(s, t, u, y, z);
			a.a(var3);
		}

		return var2;
	}

	@Override
	public void a(boolean var1, boolean var2, boolean var3) {
		if (bQ()) {
			v().u().b(this, new class_fq(this, 2));
		}

		super.a(var1, var2, var3);
		if (a != null) {
			a.a(s, t, u, y, z);
		}

	}

	@Override
	public void a(class_qx var1) {
		class_qx var2 = m;
		super.a(var1);
		if (var1 != var2) {
			a.a((new class_hm(0, this, m)));
			a.a(s, t, u, y, z);
		}

	}

	@Override
	protected void a(double var1, boolean var3, class_ail var4, class_cj var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = class_oa.c(s);
		int var5 = class_oa.c(t - 0.20000000298023224D);
		int var6 = class_oa.c(u);
		class_cj var7 = new class_cj(var4, var5, var6);
		class_ail var8 = o.p(var7).c();
		if (var8.v() == class_avq.a) {
			class_ail var9 = o.p(var7.b()).c();
			if ((var9 instanceof class_akb) || (var9 instanceof class_anx) || (var9 instanceof class_akc)) {
				var7 = var7.b();
				var8 = o.p(var7).c();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	@Override
	public void a(class_aoz var1) {
		var1.a(this);
		a.a((new class_gx(var1.v())));
	}

	private void cD() {
		ci = (ci % 100) + 1;
	}

	@Override
	public void a(class_pv var1) {
		cD();
		a.a((new class_gd(ci, var1.k(), var1.f_())));
		bs = var1.a(bq, this);
		bs.d = ci;
		bs.a((class_zz) this);
	}

	@Override
	public void a(class_pp var1) {
		if (bs != br) {
			this.o();
		}

		if (var1 instanceof class_qa) {
			class_qa var2 = (class_qa) var1;
			if (var2.q_() && !this.a(var2.i()) && !w()) {
				a.a((new class_fz(new class_fb("container.isLocked", new Object[] { var1.f_() }), (byte) 2)));
				a.a((new class_gt("random.door_close", s, t, u, 1.0F, 1.0F)));
				return;
			}
		}

		cD();
		if (var1 instanceof class_pv) {
			a.a((new class_gd(ci, ((class_pv) var1).k(), var1.f_(), var1.n_())));
			bs = ((class_pv) var1).a(bq, this);
		} else {
			a.a((new class_gd(ci, "minecraft:container", var1.f_(), var1.n_())));
			bs = new class_aaa(bq, var1, this);
		}

		bs.d = ci;
		bs.a((class_zz) this);
	}

	@Override
	public void a(class_aga var1) {
		cD();
		bs = new class_aan(bq, var1, o);
		bs.d = ci;
		bs.a((class_zz) this);
		class_aam var2 = ((class_aan) bs).e();
		class_eu var3 = var1.f_();
		a.a((new class_gd(ci, "minecraft:villager", var3, var2.n_())));
		class_agc var4 = var1.a_(this);
		if (var4 != null) {
			PacketDataSerializer var5 = new PacketDataSerializer(Unpooled.buffer());
			var5.writeInt(ci);
			var4.a(var5);
			a.a((new class_gi("MC|TrList", var5)));
		}

	}

	@Override
	public void a(class_vf var1, class_pp var2) {
		if (bs != br) {
			this.o();
		}

		cD();
		a.a((new class_gd(ci, "EntityHorse", var2.f_(), var2.n_(), var1.G())));
		bs = new class_aaj(bq, var2, var1, this);
		bs.d = ci;
		bs.a((class_zz) this);
	}

	@Override
	public void a(class_aco var1) {
		class_acm var2 = var1.b();
		if (var2 == class_acq.bS) {
			a.a((new class_gi("MC|BOpen", new PacketDataSerializer(Unpooled.buffer()))));
		}

	}

	@Override
	public void a(class_zu var1, int var2, class_aco var3) {
		if (!(var1.a(var2) instanceof class_aar)) {
			if (!g) {
				a.a((new class_gg(var1.d, var2, var3)));
			}
		}
	}

	public void a(class_zu var1) {
		this.a(var1, var1.a());
	}

	@Override
	public void a(class_zu var1, List var2) {
		a.a((new class_ge(var1.d, var2)));
		a.a((new class_gg(-1, -1, bq.n())));
	}

	@Override
	public void a(class_zu var1, int var2, int var3) {
		a.a((new class_gf(var1.d, var2, var3)));
	}

	@Override
	public void a(class_zu var1, class_pp var2) {
		for (int var3 = 0; var3 < var2.g(); ++var3) {
			a.a((new class_gf(var1.d, var3, var2.c(var3))));
		}

	}

	@Override
	public void o() {
		a.a((new class_gc(bs.d)));
		this.q();
	}

	public void p() {
		if (!g) {
			a.a((new class_gg(-1, -1, bq.n())));
		}
	}

	public void q() {
		bs.b(this);
		bs = br;
	}

	public void a(float var1, float var2, boolean var3, boolean var4) {
		if (m != null) {
			if ((var1 >= -1.0F) && (var1 <= 1.0F)) {
				bd = var1;
			}

			if ((var2 >= -1.0F) && (var2 <= 1.0F)) {
				be = var2;
			}

			bc = var3;
			this.c(var4);
		}

	}

	@Override
	public void a(class_nd var1, int var2) {
		if (var1 != null) {
			bS.b(this, var1, var2);
			Iterator var3 = cx().a(var1.k()).iterator();

			while (var3.hasNext()) {
				class_ayo var4 = (class_ayo) var3.next();
				cx().c(e_(), var4).a(var2);
			}

			if (bS.e()) {
				bS.a(this);
			}

		}
	}

	@Override
	public void a(class_nd var1) {
		if (var1 != null) {
			bS.a(this, var1, 0);
			Iterator var2 = cx().a(var1.k()).iterator();

			while (var2.hasNext()) {
				class_ayo var3 = (class_ayo) var2.next();
				cx().c(e_(), var3).c(0);
			}

			if (bS.e()) {
				bS.a(this);
			}

		}
	}

	public void r() {
		if (l != null) {
			l.a((class_qx) this);
		}

		if (bE) {
			this.a(true, false, false);
		}

	}

	public void s() {
		bZ = -1.0E8F;
	}

	@Override
	public void b(class_eu var1) {
		a.a((new class_fz(var1)));
	}

	@Override
	protected void t() {
		if ((bm != null) && bX()) {
			a.a((new class_gk(this, (byte) 9)));
			super.t();
		}

	}

	@Override
	public void a(class_yu var1, boolean var2) {
		super.a(var1, var2);
		cc = -1;
		bZ = -1.0F;
		ca = -1;
		bR.addAll(((class_lm) var1).bR);
	}

	@Override
	protected void a(class_qr var1) {
		super.a(var1);
		a.a((new class_ic(G(), var1)));
	}

	@Override
	protected void a(class_qr var1, boolean var2) {
		super.a(var1, var2);
		a.a((new class_ic(G(), var1)));
	}

	@Override
	protected void b(class_qr var1) {
		super.b(var1);
		a.a((new class_hd(G(), var1.a())));
	}

	@Override
	public void a(double var1, double var3, double var5) {
		a.a(var1, var3, var5, y, z);
	}

	@Override
	public void b(class_qx var1) {
		v().u().b(this, new class_fq(var1, 4));
	}

	@Override
	public void c(class_qx var1) {
		v().u().b(this, new class_fq(var1, 5));
	}

	@Override
	public void u() {
		if (a != null) {
			a.a((new class_gy(bI)));
			C();
		}
	}

	public class_ll v() {
		return (class_ll) o;
	}

	@Override
	public void a(class_agr.class_a_in_class_agr var1) {
		c.a(var1);
		a.a((new class_gn(3, var1.a())));
		if (var1 == class_agr.class_a_in_class_agr.e) {
			this.a((class_qx) null);
		} else {
			this.e(this);
		}

		u();
		bV();
	}

	@Override
	public boolean w() {
		return c.b() == class_agr.class_a_in_class_agr.e;
	}

	@Override
	public void a(class_eu var1) {
		a.a((new class_fz(var1)));
	}

	@Override
	public boolean a(int var1, String var2) {
		if ("seed".equals(var2) && !b.ag()) {
			return true;
		} else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
			if (b.ar().h(cl())) {
				class_mg var3 = (class_mg) b.ar().m().b((Object) cl());
				return var3 != null ? var3.a() >= var1 : b.p() >= var1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String x() {
		String var1 = a.a.b().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void a(class_ii var1) {
		bQ = var1.a();
		ce = var1.c();
		cf = var1.d();
		J().b(bo, Byte.valueOf((byte) var1.e()));
		J().b(bp, Byte.valueOf((byte) (var1.f() == class_rf.a ? 0 : 1)));
	}

	public class_yu.class_b_in_class_yu z() {
		return ce;
	}

	public void a(String var1, String var2) {
		a.a((new class_he(var1, var2)));
	}

	@Override
	public class_cj c() {
		return new class_cj(s, t + 0.5D, u);
	}

	public void A() {
		cg = MinecraftServer.aB();
	}

	public class_nc B() {
		return bS;
	}

	public void d(class_qx var1) {
		if (var1 instanceof class_yu) {
			a.a((new class_hc(new int[] { var1.G() })));
		} else {
			bR.add(Integer.valueOf(var1.G()));
		}

	}

	@Override
	protected void C() {
		if (w()) {
			bq();
			this.f(true);
		} else {
			super.C();
		}

		v().u().a(this);
	}

	public class_qx D() {
		return ch == null ? this : ch;
	}

	public void e(class_qx var1) {
		class_qx var2 = D();
		ch = var1 == null ? this : var1;
		if (var2 != ch) {
			a.a((new class_hi(ch)));
			this.a(ch.s, ch.t, ch.u);
		}

	}

	@Override
	public void f(class_qx var1) {
		if (c.b() == class_agr.class_a_in_class_agr.e) {
			this.e(var1);
		} else {
			super.f(var1);
		}

	}

	public long E() {
		return cg;
	}

	public class_eu F() {
		return null;
	}

	@Override
	public void a(class_pu var1) {
		super.a(var1);
		cA();
	}
}
