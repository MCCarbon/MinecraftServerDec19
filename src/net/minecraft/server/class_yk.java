package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class class_yk extends class_yc implements class_ye {
	private static final UUID a = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	private static final class_rr b;
	private static final class_jz c;
	private static final Item[] bt;
	private int bu;

	public class_yk(class_ago var1) {
		super(var1);
		this.a(0.6F, 1.95F);
		i.a(1, new class_so(this));
		i.a(2, new class_to(this, 1.0D, 60, 10.0F));
		i.a(2, new class_tn(this, 1.0D));
		i.a(3, new class_sw(this, class_yu.class, 8.0F));
		i.a(3, new class_tm(this));
		bo.a(1, new class_uc(this, false, new Class[0]));
		bo.a(2, new class_uf(this, class_yu.class, true));
	}

	@Override
	protected void h() {
		super.h();
		J().a(c, Boolean.valueOf(false));
	}

	@Override
	protected String B() {
		return null;
	}

	@Override
	protected String bv() {
		return null;
	}

	@Override
	protected String bw() {
		return null;
	}

	public void a(boolean var1) {
		J().b(c, Boolean.valueOf(var1));
	}

	public boolean n() {
		return ((Boolean) J().a(c)).booleanValue();
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(26.0D);
		this.a(class_yf.d).a(0.25D);
	}

	@Override
	public void m() {
		if (!o.D) {
			if (this.n()) {
				if (bu-- <= 0) {
					this.a(false);
					class_aco var6 = bG();
					this.a(class_rc.a, (class_aco) null);
					if ((var6 != null) && (var6.b() == Items.bB)) {
						List var5 = class_adb.h(var6);
						if (var5 != null) {
							Iterator var3 = var5.iterator();

							while (var3.hasNext()) {
								class_qr var4 = (class_qr) var3.next();
								this.c(new class_qr(var4));
							}
						}
					}

					this.a(class_yf.d).c(b);
				}
			} else {
				PotionRegistry var1 = null;
				if ((V.nextFloat() < 0.15F) && this.a(class_avq.h) && !this.a(class_qs.m)) {
					var1 = class_aee.s;
				} else if ((V.nextFloat() < 0.15F) && ay() && !this.a(class_qs.l)) {
					var1 = class_aee.l;
				} else if ((V.nextFloat() < 0.05F) && (bu() < bB())) {
					var1 = class_aee.u;
				} else if ((V.nextFloat() < 0.5F) && (w() != null) && !this.a(class_qs.a) && (w().h(this) > 121.0D)) {
					var1 = class_aee.n;
				}

				if (var1 != null) {
					this.a(class_rc.a, class_adb.a(new class_aco(Items.bB), var1));
					bu = bG().l();
					this.a(true);
					class_rq var2 = this.a(class_yf.d);
					var2.c(b);
					var2.b(b);
				}
			}

			if (V.nextFloat() < 7.5E-4F) {
				o.a(this, (byte) 15);
			}
		}

		super.m();
	}

	@Override
	protected float c(class_qi var1, float var2) {
		var2 = super.c(var1, var2);
		if (var1.j() == this) {
			var2 = 0.0F;
		}

		if (var1.s()) {
			var2 = (float) (var2 * 0.15D);
		}

		return var2;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3) + 1;

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = V.nextInt(3);
			Item var6 = bt[V.nextInt(bt.length)];
			if (var2 > 0) {
				var5 += V.nextInt(var2 + 1);
			}

			for (int var7 = 0; var7 < var5; ++var7) {
				this.a(var6, 1);
			}
		}

	}

	@Override
	public void a(class_rg var1, float var2) {
		if (!this.n()) {
			double var3 = (var1.t + var1.aY()) - 1.100000023841858D;
			double var5 = (var1.s + var1.v) - s;
			double var7 = var3 - t;
			double var9 = (var1.u + var1.x) - u;
			float var11 = MathHelper.a((var5 * var5) + (var9 * var9));
			PotionRegistry var12 = class_aee.w;
			if ((var11 >= 8.0F) && !var1.a(class_qs.b)) {
				var12 = class_aee.q;
			} else if ((var1.bu() >= 8.0F) && !var1.a(class_qs.s)) {
				var12 = class_aee.y;
			} else if ((var11 <= 3.0F) && !var1.a(class_qs.r) && (V.nextFloat() < 0.25F)) {
				var12 = class_aee.H;
			}

			class_zn var13 = new class_zn(o, this, class_adb.a(new class_aco(Items.bC), var12), false);
			var13.z -= -20.0F;
			var13.c(var5, var7 + var11 * 0.2F, var9, 0.75F, 8.0F);
			o.a(var13);
		}
	}

	@Override
	public float aY() {
		return 1.62F;
	}

	static {
		b = (new class_rr(a, "Drinking speed penalty", -0.25D, 0)).a(false);
		c = class_kc.a(class_yk.class, class_kb.g);
		bt = new Item[] { Items.aV, Items.ba, Items.aE, Items.bG, Items.bE, Items.J, Items.A, Items.A };
	}
}
