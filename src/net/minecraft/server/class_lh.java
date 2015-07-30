package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aeb;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aez;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_aia;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amx;
import net.minecraft.server.class_aok;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_e;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fb;
import net.minecraft.server.Packet;
import net.minecraft.server.class_fq;
import net.minecraft.server.PacketPlayOutChat;
import net.minecraft.server.class_gc;
import net.minecraft.server.class_gd;
import net.minecraft.server.class_ge;
import net.minecraft.server.class_gf;
import net.minecraft.server.class_gg;
import net.minecraft.server.class_gh;
import net.minecraft.server.class_gj;
import net.minecraft.server.class_gm;
import net.minecraft.server.class_go;
import net.minecraft.server.class_gp;
import net.minecraft.server.class_gs;
import net.minecraft.server.class_gw;
import net.minecraft.server.class_gx;
import net.minecraft.server.class_gy;
import net.minecraft.server.class_ha;
import net.minecraft.server.class_hb;
import net.minecraft.server.class_hc;
import net.minecraft.server.class_hd;
import net.minecraft.server.class_hh;
import net.minecraft.server.class_hl;
import net.minecraft.server.class_ho;
import net.minecraft.server.class_hp;
import net.minecraft.server.class_ib;
import net.minecraft.server.class_ih;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_li;
import net.minecraft.server.class_lo;
import net.minecraft.server.class_mb;
import net.minecraft.server.class_ms;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_mx;
import net.minecraft.server.class_my;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_ne;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_op;
import net.minecraft.server.class_ot;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pd;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_pz;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_tz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yf;
import net.minecraft.server.class_yo;
import net.minecraft.server.class_yr;
import net.minecraft.server.class_ys;
import net.minecraft.server.class_yw;
import net.minecraft.server.class_zt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lh extends class_xa implements class_ye {
	private static final Logger bO = LogManager.getLogger();
	private String bP = "en_US";
	public class_lo a;
	public final MinecraftServer b;
	public final class_li c;
	public double d;
	public double e;
	public final List f = Lists.newLinkedList();
	private final List bQ = Lists.newLinkedList();
	private final class_mx bR;
	private float bS = Float.MIN_VALUE;
	private float bT = -1.0E8F;
	private int bU = -99999999;
	private boolean bV = true;
	private int bW = -99999999;
	private int bX = 60;
	private class_xa.class_b_in_class_xa bY;
	private boolean bZ = true;
	private long ca = System.currentTimeMillis();
	private class_pr cb = null;
	private int cc;
	public boolean g;
	public int h;
	public boolean i;

	public class_lh(MinecraftServer var1, class_lg var2, GameProfile var3, class_li var4) {
		super(var2, var3);
		var4.b = this;
		this.c = var4;
		BlockPosition var5 = var2.N();
		if (!var2.t.m() && var2.Q().r() != class_aeq.class_a_in_class_aeq.d) {
			int var6 = Math.max(5, var1.aw() - 6);
			int var7 = MathHelper.floor(var2.ag().b((double) var5.getX(), (double) var5.getZ()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.add(this.V.nextInt(var6 * 2) - var6, 0, this.V.nextInt(var6 * 2) - var6));
		}

		this.b = var1;
		this.bR = var1.ap().a((class_xa) this);
		this.S = 0.0F;
		this.a(var5, 0.0F, 0.0F);

		while (!var2.a((class_pr) this, (class_awf) this.aT()).isEmpty() && this.t < 255.0D) {
			this.b(this.s, this.t + 1.0D, this.u);
		}

	}

	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("playerGameType", 99)) {
			if (MinecraftServer.N().ax()) {
				this.c.a(MinecraftServer.N().m());
			} else {
				this.c.a(class_aeq.class_a_in_class_aeq.a(var1.g("playerGameType")));
			}
		}

	}

	public void b(class_dn var1) {
		super.b(var1);
		var1.a("playerGameType", this.c.b().a());
	}

	public void a(int var1) {
		super.a(var1);
		this.bW = -1;
	}

	public void b(int var1) {
		super.b(var1);
		this.bW = -1;
	}

	public void g_() {
		this.br.a((class_ye) this);
	}

	public void h_() {
		super.h_();
		this.a.a((Packet) (new class_gy(this.bt(), class_gy.class_a_in_class_gy.a)));
	}

	public void j() {
		super.j();
		this.a.a((Packet) (new class_gy(this.bt(), class_gy.class_a_in_class_gy.b)));
	}

	public void t_() {
		this.c.a();
		--this.bX;
		if (this.Z > 0) {
			--this.Z;
		}

		this.br.b();
		if (!this.o.D && !this.br.a((class_xa) this)) {
			this.n();
			this.br = this.bq;
		}

		while (!this.bQ.isEmpty()) {
			int var1 = Math.min(this.bQ.size(), Integer.MAX_VALUE);
			int[] var2 = new int[var1];
			Iterator var3 = this.bQ.iterator();
			int var4 = 0;

			while (var3.hasNext() && var4 < var1) {
				var2[var4++] = ((Integer) var3.next()).intValue();
				var3.remove();
			}

			this.a.a((Packet) (new class_hb(var2)));
		}

		if (!this.f.isEmpty()) {
			ArrayList var6 = Lists.newArrayList();
			Iterator var8 = this.f.iterator();
			ArrayList var9 = Lists.newArrayList();

			class_aok var5;
			while (var8.hasNext() && var6.size() < 10) {
				class_aeh var10 = (class_aeh) var8.next();
				if (var10 != null) {
					if (this.o.e(new BlockPosition(var10.a << 4, 0, var10.b << 4))) {
						var5 = this.o.a(var10.a, var10.b);
						if (var5.i()) {
							var6.add(var5);
							var9.addAll(((class_lg) this.o).a(var10.a * 16, 0, var10.b * 16, var10.a * 16 + 16, 256, var10.b * 16 + 16));
							var8.remove();
						}
					}
				} else {
					var8.remove();
				}
			}

			if (!var6.isEmpty()) {
				if (var6.size() == 1) {
					this.a.a((Packet) (new class_go((class_aok) var6.get(0), true, '\uffff')));
				} else {
					this.a.a((Packet) (new class_gp(var6)));
				}

				Iterator var11 = var9.iterator();

				while (var11.hasNext()) {
					class_amg var12 = (class_amg) var11.next();
					this.a(var12);
				}

				var11 = var6.iterator();

				while (var11.hasNext()) {
					var5 = (class_aok) var11.next();
					this.u().t().a(this, var5);
				}
			}
		}

		class_pr var7 = this.C();
		if (var7 != this) {
			if (!var7.ai()) {
				this.e(this);
			} else {
				this.a(var7.s, var7.t, var7.u, var7.y, var7.z);
				this.b.ap().d(this);
				if (this.ax()) {
					this.e(this);
				}
			}
		}

	}

	public void l() {
		try {
			super.t_();

			for (int var1 = 0; var1 < this.bp.o_(); ++var1) {
				class_aas var6 = this.bp.a(var1);
				if (var6 != null && var6.b().f()) {
					Packet var8 = ((class_zt) var6.b()).a(var6, this.o, this);
					if (var8 != null) {
						this.a.a(var8);
					}
				}
			}

			if (this.bo() != this.bT || this.bU != this.bs.a() || this.bs.e() == 0.0F != this.bV) {
				this.a.a((Packet) (new class_hp(this.bo(), this.bs.a(), this.bs.e())));
				this.bT = this.bo();
				this.bU = this.bs.a();
				this.bV = this.bs.e() == 0.0F;
			}

			if (this.bo() + this.bO() != this.bS) {
				this.bS = this.bo() + this.bO();
				Collection var5 = this.cr().a(class_awt.g);
				Iterator var7 = var5.iterator();

				while (var7.hasNext()) {
					class_awj var9 = (class_awj) var7.next();
					this.cr().c(this.e_(), var9).a(Arrays.asList(new class_xa[] { this }));
				}
			}

			if (this.bJ != this.bW) {
				this.bW = this.bJ;
				this.a.a((Packet) (new class_ho(this.bK, this.bJ, this.bI)));
			}

			if (this.W % 20 * 5 == 0 && !this.A().a((class_ms) class_mt.L)) {
				this.i_();
			}

		} catch (Throwable var4) {
			class_b var2 = class_b.a(var4, "Ticking player");
			class_c var3 = var2.a("Player being ticked");
			this.a((class_c) var3);
			throw new class_e(var2);
		}
	}

	protected void i_() {
		class_aez var1 = this.o.b(new BlockPosition(MathHelper.floor(this.s), 0, MathHelper.floor(this.u)));
		String var2 = var1.ah;
		class_ne var3 = (class_ne) this.A().b((class_my) class_mt.L);
		if (var3 == null) {
			var3 = (class_ne) this.A().a(class_mt.L, new class_ne());
		}

		var3.add(var2);
		if (this.A().b(class_mt.L) && var3.size() >= class_aez.n.size()) {
			HashSet var4 = Sets.newHashSet((Iterable) class_aez.n);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				Iterator var7 = var4.iterator();

				while (var7.hasNext()) {
					class_aez var8 = (class_aez) var7.next();
					if (var8.ah.equals(var6)) {
						var7.remove();
					}
				}

				if (var4.isEmpty()) {
					break;
				}
			}

			if (var4.isEmpty()) {
				this.b((class_my) class_mt.L);
			}
		}

	}

	public void a(class_pc var1) {
		this.a.a((Packet) (new class_gy(this.bt(), class_gy.class_a_in_class_gy.c)));
		if (this.o.R().b("showDeathMessages")) {
			class_awp var2 = this.bP();
			if (var2 != null && var2.j() != class_awp.class_a_in_class_awp.a) {
				if (var2.j() == class_awp.class_a_in_class_awp.c) {
					this.b.ap().a((class_xa) this, (IChatBaseComponent) this.bt().b());
				} else if (var2.j() == class_awp.class_a_in_class_awp.d) {
					this.b.ap().b((class_xa) this, (IChatBaseComponent) this.bt().b());
				}
			} else {
				this.b.ap().a(this.bt().b());
			}
		}

		if (!this.o.R().b("keepInventory")) {
			this.bp.n();
		}

		Collection var6 = this.o.aa().a(class_awt.d);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			class_awj var4 = (class_awj) var3.next();
			class_awl var5 = this.cr().c(this.e_(), var4);
			var5.a();
		}

		class_qa var7 = this.bu();
		if (var7 != null) {
			class_pt.class_a_in_class_pt var8 = (class_pt.class_a_in_class_pt) class_pt.a.get(Integer.valueOf(class_pt.a(var7)));
			if (var8 != null) {
				this.b((class_my) var8.e);
			}

			var7.b(this, this.aZ);
		}

		this.b((class_my) class_nc.y);
		this.a(class_nc.h);
		this.bt().g();
	}

	public boolean a(class_pc var1, float var2) {
		if (this.b((class_pc) var1)) {
			return false;
		} else {
			boolean var3 = this.b.ae() && this.ct() && "fall".equals(var1.p);
			if (!var3 && this.bX > 0 && var1 != class_pc.j) {
				return false;
			} else {
				if (var1 instanceof class_pd) {
					class_pr var4 = var1.j();
					if (var4 instanceof class_xa && !this.a((class_xa) var4)) {
						return false;
					}

					if (var4 instanceof class_xd) {
						class_xd var5 = (class_xd) var4;
						if (var5.e instanceof class_xa && !this.a((class_xa) var5.e)) {
							return false;
						}
					}
				}

				return super.a(var1, var2);
			}
		}
	}

	public boolean a(class_xa var1) {
		return !this.ct() ? false : super.a(var1);
	}

	private boolean ct() {
		return this.b.aj();
	}

	public void c(int var1) {
		if (this.am == 1 && var1 == 1) {
			this.b((class_my) class_mt.D);
			this.o.e((class_pr) this);
			this.i = true;
			this.a.a((Packet) (new class_gm(4, 0.0F)));
		} else {
			if (this.am == 0 && var1 == 1) {
				this.b((class_my) class_mt.C);
				BlockPosition var2 = this.b.a(var1).n();
				if (var2 != null) {
					this.a.a((double) var2.getX(), (double) var2.getY(), (double) var2.getZ(), 0.0F, 0.0F);
				}

				var1 = 1;
			} else {
				this.b((class_my) class_mt.y);
			}

			this.b.ap().a(this, var1);
			this.bW = -1;
			this.bT = -1.0F;
			this.bU = -1;
		}

	}

	public boolean a(class_lh var1) {
		return var1.v() ? this.C() == this : (this.v() ? false : super.a((class_lh) var1));
	}

	private void a(class_amg var1) {
		if (var1 != null) {
			Packet var2 = var1.z_();
			if (var2 != null) {
				this.a.a(var2);
			}
		}

	}

	public void a(class_pr var1, int var2) {
		super.a(var1, var2);
		this.br.b();
	}

	public class_xa.class_a_in_class_xa a(BlockPosition var1) {
		class_xa.class_a_in_class_xa var2 = super.a(var1);
		if (var2 == class_xa.class_a_in_class_xa.a) {
			class_ha var3 = new class_ha(this, var1);
			this.u().t().a((class_pr) this, (Packet) var3);
			this.a.a(this.s, this.t, this.u, this.y, this.z);
			this.a.a((Packet) var3);
		}

		return var2;
	}

	public void a(boolean var1, boolean var2, boolean var3) {
		if (this.bK()) {
			this.u().t().b(this, new class_fq(this, 2));
		}

		super.a(var1, var2, var3);
		if (this.a != null) {
			this.a.a(this.s, this.t, this.u, this.y, this.z);
		}

	}

	public void a(class_pr var1) {
		class_pr var2 = this.m;
		super.a((class_pr) var1);
		if (var1 != var2) {
			this.a.a((Packet) (new class_hl(0, this, this.m)));
			this.a.a(this.s, this.t, this.u, this.y, this.z);
		}

	}

	protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = MathHelper.floor(this.s);
		int var5 = MathHelper.floor(this.t - 0.20000000298023224D);
		int var6 = MathHelper.floor(this.u);
		BlockPosition var7 = new BlockPosition(var4, var5, var6);
		Block var8 = this.o.p(var7).getBlock();
		if (var8.getMaterial() == Material.AIR) {
			Block var9 = this.o.p(var7.shiftDown()).getBlock();
			if (var9 instanceof class_ahz || var9 instanceof class_alv || var9 instanceof class_aia) {
				var7 = var7.shiftDown();
				var8 = this.o.p(var7).getBlock();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	public void a(class_amx var1) {
		var1.a((class_xa) this);
		this.a.a((Packet) (new class_gw(var1.v())));
	}

	private void cu() {
		this.cc = this.cc % 100 + 1;
	}

	public void a(class_op var1) {
		this.cu();
		this.a.a((Packet) (new class_gd(this.cc, var1.k(), var1.f_())));
		this.br = var1.a(this.bp, this);
		this.br.d = this.cc;
		this.br.a((class_ye) this);
	}

	public void a(class_oj var1) {
		if (this.br != this.bq) {
			this.n();
		}

		if (var1 instanceof class_ou) {
			class_ou var2 = (class_ou) var1;
			if (var2.r_() && !this.a((class_ot) var2.i()) && !this.v()) {
				this.a.a((Packet) (new PacketPlayOutChat(new class_fb("container.isLocked", new Object[] { var1.f_() }), (byte) 2)));
				this.a.a((Packet) (new class_gs("random.door_close", this.s, this.t, this.u, 1.0F, 1.0F)));
				return;
			}
		}

		this.cu();
		if (var1 instanceof class_op) {
			this.a.a((Packet) (new class_gd(this.cc, ((class_op) var1).k(), var1.f_(), var1.o_())));
			this.br = ((class_op) var1).a(this.bp, this);
		} else {
			this.a.a((Packet) (new class_gd(this.cc, "minecraft:container", var1.f_(), var1.o_())));
			this.br = new class_yf(this.bp, var1, this);
		}

		this.br.d = this.cc;
		this.br.a((class_ye) this);
	}

	public void a(class_adz var1) {
		this.cu();
		this.br = new class_ys(this.bp, var1, this.o);
		this.br.d = this.cc;
		this.br.a((class_ye) this);
		class_yr var2 = ((class_ys) this.br).e();
		IChatBaseComponent var3 = var1.f_();
		this.a.a((Packet) (new class_gd(this.cc, "minecraft:villager", var3, var2.o_())));
		class_aeb var4 = var1.a_((class_xa) this);
		if (var4 != null) {
			PacketDataSerializer var5 = new PacketDataSerializer(Unpooled.buffer());
			var5.writeInt(this.cc);
			var4.a(var5);
			this.a.a((Packet) (new class_gh("MC|TrList", var5)));
		}

	}

	public void a(class_tz var1, class_oj var2) {
		if (this.br != this.bq) {
			this.n();
		}

		this.cu();
		this.a.a((Packet) (new class_gd(this.cc, "EntityHorse", var2.f_(), var2.o_(), var1.getId())));
		this.br = new class_yo(this.bp, var2, var1, this);
		this.br.d = this.cc;
		this.br.a((class_ye) this);
	}

	public void a(class_aas var1) {
		Item var2 = var1.b();
		if (var2 == Items.bQ) {
			this.a.a((Packet) (new class_gh("MC|BOpen", new PacketDataSerializer(Unpooled.buffer()))));
		}

	}

	public void a(class_xz var1, int var2, class_aas var3) {
		if (!(var1.a(var2) instanceof class_yw)) {
			if (!this.g) {
				this.a.a((Packet) (new class_gg(var1.d, var2, var3)));
			}
		}
	}

	public void a(class_xz var1) {
		this.a(var1, var1.a());
	}

	public void a(class_xz var1, List var2) {
		this.a.a((Packet) (new class_ge(var1.d, var2)));
		this.a.a((Packet) (new class_gg(-1, -1, this.bp.o())));
	}

	public void a(class_xz var1, int var2, int var3) {
		this.a.a((Packet) (new class_gf(var1.d, var2, var3)));
	}

	public void a(class_xz var1, class_oj var2) {
		for (int var3 = 0; var3 < var2.g(); ++var3) {
			this.a.a((Packet) (new class_gf(var1.d, var3, var2.a_(var3))));
		}

	}

	public void n() {
		this.a.a((Packet) (new class_gc(this.br.d)));
		this.p();
	}

	public void o() {
		if (!this.g) {
			this.a.a((Packet) (new class_gg(-1, -1, this.bp.o())));
		}
	}

	public void p() {
		this.br.b((class_xa) this);
		this.br = this.bq;
	}

	public void a(float var1, float var2, boolean var3, boolean var4) {
		if (this.m != null) {
			if (var1 >= -1.0F && var1 <= 1.0F) {
				this.bc = var1;
			}

			if (var2 >= -1.0F && var2 <= 1.0F) {
				this.bd = var2;
			}

			this.bb = var3;
			this.c(var4);
		}

	}

	public void a(class_my var1, int var2) {
		if (var1 != null) {
			this.bR.b(this, var1, var2);
			Iterator var3 = this.cr().a(var1.k()).iterator();

			while (var3.hasNext()) {
				class_awj var4 = (class_awj) var3.next();
				this.cr().c(this.e_(), var4).a(var2);
			}

			if (this.bR.e()) {
				this.bR.a(this);
			}

		}
	}

	public void a(class_my var1) {
		if (var1 != null) {
			this.bR.a(this, var1, 0);
			Iterator var2 = this.cr().a(var1.k()).iterator();

			while (var2.hasNext()) {
				class_awj var3 = (class_awj) var2.next();
				this.cr().c(this.e_(), var3).c(0);
			}

			if (this.bR.e()) {
				this.bR.a(this);
			}

		}
	}

	public void q() {
		if (this.l != null) {
			this.l.a((class_pr) this);
		}

		if (this.bD) {
			this.a(true, false, false);
		}

	}

	public void r() {
		this.bT = -1.0E8F;
	}

	public void b(IChatBaseComponent var1) {
		this.a.a((Packet) (new PacketPlayOutChat(var1)));
	}

	protected void s() {
		if (this.bl != null && this.bS()) {
			this.a.a((Packet) (new class_gj(this, (byte) 9)));
			super.s();
		}

	}

	public void a(class_xa var1, boolean var2) {
		super.a(var1, var2);
		this.bW = -1;
		this.bT = -1.0F;
		this.bU = -1;
		this.bQ.addAll(((class_lh) var1).bQ);
	}

	protected void a(class_pl var1) {
		super.a((class_pl) var1);
		this.a.a((Packet) (new class_ib(this.getId(), var1)));
	}

	protected void a(class_pl var1, boolean var2) {
		super.a((class_pl) var1, var2);
		this.a.a((Packet) (new class_ib(this.getId(), var1)));
	}

	protected void b(class_pl var1) {
		super.b((class_pl) var1);
		this.a.a((Packet) (new class_hc(this.getId(), var1.a())));
	}

	public void a(double var1, double var3, double var5) {
		this.a.a(var1, var3, var5, this.y, this.z);
	}

	public void b(class_pr var1) {
		this.u().t().b(this, new class_fq(var1, 4));
	}

	public void c(class_pr var1) {
		this.u().t().b(this, new class_fq(var1, 5));
	}

	public void t() {
		if (this.a != null) {
			this.a.a((Packet) (new class_gx(this.bH)));
			this.B();
		}
	}

	public class_lg u() {
		return (class_lg) this.o;
	}

	public void a(class_aeq.class_a_in_class_aeq var1) {
		this.c.a(var1);
		this.a.a((Packet) (new class_gm(3, (float) var1.a())));
		if (var1 == class_aeq.class_a_in_class_aeq.e) {
			this.a((class_pr) null);
		} else {
			this.e(this);
		}

		this.t();
		this.bQ();
	}

	public boolean v() {
		return this.c.b() == class_aeq.class_a_in_class_aeq.e;
	}

	public void a(IChatBaseComponent var1) {
		this.a.a((Packet) (new PacketPlayOutChat(var1)));
	}

	public boolean a(int var1, String var2) {
		if ("seed".equals(var2) && !this.b.ae()) {
			return true;
		} else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
			if (this.b.ap().h(this.cf())) {
				class_mb var3 = (class_mb) this.b.ap().m().b((Object) this.cf());
				return var3 != null ? var3.a() >= var1 : this.b.p() >= var1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String w() {
		String var1 = this.a.a.getAddress().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void a(class_ih var1) {
		this.bP = var1.a();
		this.bY = var1.c();
		this.bZ = var1.d();
		this.H().b(bn, Byte.valueOf((byte) var1.e()));
		this.H().b(bo, Byte.valueOf((byte) (var1.f() == class_pz.a ? 0 : 1)));
	}

	public class_xa.class_b_in_class_xa y() {
		return this.bY;
	}

	public void a(String var1, String var2) {
		this.a.a((Packet) (new class_hd(var1, var2)));
	}

	public BlockPosition c() {
		return new BlockPosition(this.s, this.t + 0.5D, this.u);
	}

	public void z() {
		this.ca = MinecraftServer.az();
	}

	public class_mx A() {
		return this.bR;
	}

	public void d(class_pr var1) {
		if (var1 instanceof class_xa) {
			this.a.a((Packet) (new class_hb(new int[] { var1.getId() })));
		} else {
			this.bQ.add(Integer.valueOf(var1.getId()));
		}

	}

	protected void B() {
		if (this.v()) {
			this.bk();
			this.f(true);
		} else {
			super.B();
		}

		this.u().t().a(this);
	}

	public class_pr C() {
		return (class_pr) (this.cb == null ? this : this.cb);
	}

	public void e(class_pr var1) {
		class_pr var2 = this.C();
		this.cb = (class_pr) (var1 == null ? this : var1);
		if (var2 != this.cb) {
			this.a.a((Packet) (new class_hh(this.cb)));
			this.a(this.cb.s, this.cb.t, this.cb.u);
		}

	}

	public void f(class_pr var1) {
		if (this.c.b() == class_aeq.class_a_in_class_aeq.e) {
			this.e(var1);
		} else {
			super.f(var1);
		}

	}

	public long D() {
		return this.ca;
	}

	public IChatBaseComponent E() {
		return null;
	}
}
