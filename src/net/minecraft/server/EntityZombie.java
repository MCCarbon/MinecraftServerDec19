package net.minecraft.server;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class EntityZombie extends EntityMonster {
	protected static final class_rp a = (new class_rx((class_rp) null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
	private static final UUID b = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final class_rr c;
	private static final class_jz bt;
	private static final class_jz bu;
	private static final class_jz bv;
	private static final class_jz bw;
	private final class_si bx = new class_si(this);
	private int by;
	private boolean bz = false;
	private float bA = -1.0F;
	private float bB;

	public EntityZombie(class_ago var1) {
		super(var1);
		i.a(0, new class_so(this));
		i.a(2, new class_tz(this, class_yu.class, 1.0D, false));
		i.a(5, new class_td(this, 1.0D));
		i.a(7, new class_tn(this, 1.0D));
		i.a(8, new class_sw(this, class_yu.class, 8.0F));
		i.a(8, new class_tm(this));
		this.n();
		this.a(0.6F, 1.95F);
	}

	protected void n() {
		i.a(4, new class_tz(this, EntityVillager.class, 1.0D, true));
		i.a(4, new class_tz(this, EntityVillagerGolem.class, 1.0D, true));
		i.a(6, new class_tb(this, 1.0D, false));
		bo.a(1, new class_uc(this, true, new Class[] { EntityPigZombie.class }));
		bo.a(2, new class_uf(this, class_yu.class, true));
		bo.a(2, new class_uf(this, EntityVillager.class, false));
		bo.a(2, new class_uf(this, EntityVillagerGolem.class, true));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.b).a(35.0D);
		this.a(class_yf.d).a(0.23000000417232513D);
		this.a(class_yf.e).a(3.0D);
		bE().b(a).a(V.nextDouble() * 0.10000000149011612D);
	}

	@Override
	protected void h() {
		super.h();
		J().a(bt, Boolean.valueOf(false));
		J().a(bu, Boolean.valueOf(false));
		J().a(bv, Boolean.valueOf(false));
		J().a(bw, Boolean.valueOf(false));
	}

	public void a(boolean var1) {
		J().b(bw, Boolean.valueOf(var1));
	}

	@Override
	public int by() {
		int var1 = super.by() + 2;
		if (var1 > 20) {
			var1 = 20;
		}

		return var1;
	}

	public boolean cH() {
		return bz;
	}

	public void m(boolean var1) {
		if (bz != var1) {
			bz = var1;
			((class_ul) u()).b(var1);
			if (var1) {
				i.a(1, bx);
			} else {
				i.a(bx);
			}
		}

	}

	@Override
	public boolean i_() {
		return ((Boolean) J().a(bt)).booleanValue();
	}

	@Override
	protected int b(class_yu var1) {
		if (i_()) {
			b_ = (int) (b_ * 2.5F);
		}

		return super.b(var1);
	}

	public void n(boolean var1) {
		J().b(bt, Boolean.valueOf(var1));
		if ((o != null) && !o.D) {
			class_rq var2 = this.a(class_yf.d);
			var2.c(c);
			if (var1) {
				var2.b(c);
			}
		}

		this.p(var1);
	}

	public boolean cI() {
		return ((Boolean) J().a(bu)).booleanValue();
	}

	public void o(boolean var1) {
		J().b(bu, Boolean.valueOf(var1));
	}

	@Override
	public void a(class_jz var1) {
		if (var1 == bt) {
			this.p(i_());
		}

		super.a(var1);
	}

	@Override
	public void m() {
		if (o.z() && !o.D && !i_()) {
			float var1 = this.f(1.0F);
			class_cj var2 = new class_cj(s, Math.round(t), u);
			if ((var1 > 0.5F) && ((V.nextFloat() * 30.0F) < ((var1 - 0.4F) * 2.0F)) && o.i(var2)) {
				boolean var3 = true;
				class_aco var4 = this.a(class_rc.f);
				if (var4 != null) {
					if (var4.e()) {
						var4.b(var4.h() + V.nextInt(2));
						if (var4.h() >= var4.j()) {
							this.b(var4);
							this.a(class_rc.f, (class_aco) null);
						}
					}

					var3 = false;
				}

				if (var3) {
					this.e(8);
				}
			}
		}

		if (az() && (w() != null) && (m instanceof EntityChicken)) {
			((EntityInsentient) m).u().a(u().j(), 1.5D);
		}

		super.m();
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (super.a(var1, var2)) {
			EntityLiving var3 = w();
			if ((var3 == null) && (var1.j() instanceof EntityLiving)) {
				var3 = (EntityLiving) var1.j();
			}

			if ((var3 != null) && (o.ac() == class_ps.d) && (V.nextFloat() < this.a(a).e())) {
				int var4 = MathHelper.c(s);
				int var5 = MathHelper.c(t);
				int var6 = MathHelper.c(u);
				EntityZombie var7 = new EntityZombie(o);

				for (int var8 = 0; var8 < 50; ++var8) {
					int var9 = var4 + (MathHelper.a(V, 7, 40) * MathHelper.a(V, -1, 1));
					int var10 = var5 + (MathHelper.a(V, 7, 40) * MathHelper.a(V, -1, 1));
					int var11 = var6 + (MathHelper.a(V, 7, 40) * MathHelper.a(V, -1, 1));
					if (class_ago.a(o, (new class_cj(var9, var10 - 1, var11))) && (o.l(new class_cj(var9, var10, var11)) < 10)) {
						var7.b(var9, var10, var11);
						if (!o.b(var9, var10, var11, 7.0D) && o.a(var7.aX(), var7) && o.a(var7, var7.aX()).isEmpty() && !o.d(var7.aX())) {
							o.a(var7);
							var7.c(var3);
							var7.a(o.E(new class_cj(var7)), (class_rj) null);
							this.a(a).b(new class_rr("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
							var7.a(a).b(new class_rr("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
							break;
						}
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void r_() {
		if (!o.D && cJ()) {
			int var1 = cL();
			by -= var1;
			if (by <= 0) {
				cK();
			}
		}

		super.r_();
	}

	@Override
	public boolean r(Entity var1) {
		boolean var2 = super.r(var1);
		if (var2) {
			int var3 = o.ac().a();
			if ((bG() == null) && ay() && (V.nextFloat() < (var3 * 0.3F))) {
				var1.e(2 * var3);
			}
		}

		return var2;
	}

	@Override
	protected String B() {
		return "mob.zombie.say";
	}

	@Override
	protected String bv() {
		return "mob.zombie.hurt";
	}

	@Override
	protected String bw() {
		return "mob.zombie.death";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.zombie.step", 0.15F, 1.0F);
	}

	@Override
	protected Item D() {
		return Items.bv;
	}

	@Override
	public class_rl bF() {
		return class_rl.b;
	}

	@Override
	protected void bx() {
		switch (V.nextInt(3)) {
			case 0:
				this.a(Items.l, 1);
				break;
			case 1:
				this.a(Items.bW, 1);
				break;
			case 2:
				this.a(Items.bX, 1);
		}

	}

	@Override
	protected void a(class_pt var1) {
		super.a(var1);
		if (V.nextFloat() < (o.ac() == class_ps.d ? 0.05F : 0.01F)) {
			int var2 = V.nextInt(3);
			if (var2 == 0) {
				this.a(class_rc.a, (new class_aco(Items.n)));
			} else {
				this.a(class_rc.a, (new class_aco(Items.a)));
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (i_()) {
			var1.a("IsBaby", true);
		}

		if (cI()) {
			var1.a("IsVillager", true);
		}

		var1.a("ConversionTime", cJ() ? by : -1);
		var1.a("CanBreakDoors", cH());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.p("IsBaby")) {
			this.n(true);
		}

		if (var1.p("IsVillager")) {
			this.o(true);
		}

		if (var1.b("ConversionTime", 99) && (var1.h("ConversionTime") > -1)) {
			this.a(var1.h("ConversionTime"));
		}

		this.m(var1.p("CanBreakDoors"));
	}

	@Override
	public void b(EntityLiving var1) {
		super.b(var1);
		if (((o.ac() == class_ps.c) || (o.ac() == class_ps.d)) && (var1 instanceof EntityVillager)) {
			if ((o.ac() != class_ps.d) && V.nextBoolean()) {
				return;
			}

			EntityInsentient var2 = (EntityInsentient) var1;
			EntityZombie var3 = new EntityZombie(o);
			var3.n(var1);
			o.e(var1);
			var3.a(o.E(new class_cj(var3)), (class_rj) null);
			var3.o(true);
			if (var1.i_()) {
				var3.n(true);
			}

			var3.k(var2.cw());
			if (var2.k_()) {
				var3.c(var2.aS());
				var3.g(var2.aT());
			}

			o.a(var3);
			o.a((class_yu) null, 1016, new class_cj((int) s, (int) t, (int) u), 0);
		}

	}

	@Override
	public float aY() {
		float var1 = 1.74F;
		if (i_()) {
			var1 = (float) (var1 - 0.81D);
		}

		return var1;
	}

	@Override
	protected boolean a(class_aco var1) {
		return (var1.b() == Items.aR) && i_() && az() ? false : super.a(var1);
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		Object var7 = super.a(var1, var2);
		float var3 = var1.c();
		this.j(V.nextFloat() < (0.55F * var3));
		if (var7 == null) {
			var7 = new EntityZombie.class_a_in_class_yl(o.s.nextFloat() < 0.05F, o.s.nextFloat() < 0.05F);
		}

		if (var7 instanceof EntityZombie.class_a_in_class_yl) {
			EntityZombie.class_a_in_class_yl var4 = (EntityZombie.class_a_in_class_yl) var7;
			if (var4.b) {
				this.o(true);
			}

			if (var4.a) {
				this.n(true);
				if (o.s.nextFloat() < 0.05D) {
					List var5 = o.a(EntityChicken.class, aX().b(5.0D, 3.0D, 5.0D), class_rb.b);
					if (!var5.isEmpty()) {
						EntityChicken var6 = (EntityChicken) var5.get(0);
						var6.m(true);
						this.a((Entity) var6);
					}
				} else if (o.s.nextFloat() < 0.05D) {
					EntityChicken var10 = new EntityChicken(o);
					var10.b(s, t, u, y, 0.0F);
					var10.a(var1, (class_rj) null);
					var10.m(true);
					o.a(var10);
					this.a((Entity) var10);
				}
			}
		}

		this.m(V.nextFloat() < (var3 * 0.1F));
		this.a(var1);
		this.b(var1);
		if (this.a(class_rc.f) == null) {
			Calendar var8 = o.aa();
			if (((var8.get(2) + 1) == 10) && (var8.get(5) == 31) && (V.nextFloat() < 0.25F)) {
				this.a(class_rc.f, (new class_aco(V.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN)));
				bq[class_rc.f.b()] = 0.0F;
			}
		}

		this.a(class_yf.c).b(new class_rr("Random spawn bonus", V.nextDouble() * 0.05000000074505806D, 0));
		double var9 = V.nextDouble() * 1.5D * var3;
		if (var9 > 1.0D) {
			this.a(class_yf.b).b(new class_rr("Random zombie-spawn bonus", var9, 2));
		}

		if (V.nextFloat() < (var3 * 0.05F)) {
			this.a(a).b(new class_rr("Leader zombie bonus", (V.nextDouble() * 0.25D) + 0.5D, 0));
			this.a(class_yf.a).b(new class_rr("Leader zombie bonus", (V.nextDouble() * 3.0D) + 1.0D, 2));
			this.m(true);
		}

		return (class_rj) var7;
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == Items.aq) && (var3.i() == 0) && cI() && this.a(class_qs.r)) {
			if (!var1.bI.d) {
				--var3.b;
			}

			if (!o.D) {
				this.a(V.nextInt(2401) + 3600);
			}

			return true;
		} else {
			return false;
		}
	}

	protected void a(int var1) {
		by = var1;
		J().b(bv, Boolean.valueOf(true));
		this.d(class_qs.r);
		this.c(new class_qr(class_qs.e, var1, Math.min(o.ac().a() - 1, 0)));
		o.a(this, (byte) 16);
	}

	@Override
	protected boolean E() {
		return !cJ();
	}

	public boolean cJ() {
		return ((Boolean) J().a(bv)).booleanValue();
	}

	protected void cK() {
		EntityVillager var1 = new EntityVillager(o);
		var1.n(this);
		var1.a(o.E(new class_cj(var1)), (class_rj) null);
		var1.cI();
		if (i_()) {
			var1.b(-24000);
		}

		o.e(this);
		var1.k(cw());
		if (k_()) {
			var1.c(aS());
			var1.g(aT());
		}

		o.a(var1);
		var1.c(new class_qr(class_qs.i, 200, 0));
		o.a((class_yu) null, 1017, new class_cj((int) s, (int) t, (int) u), 0);
	}

	protected int cL() {
		int var1 = 1;
		if (V.nextFloat() < 0.01F) {
			int var2 = 0;
			class_cj.class_a_in_class_cj var3 = new class_cj.class_a_in_class_cj();

			for (int var4 = (int) s - 4; (var4 < ((int) s + 4)) && (var2 < 14); ++var4) {
				for (int var5 = (int) t - 4; (var5 < ((int) t + 4)) && (var2 < 14); ++var5) {
					for (int var6 = (int) u - 4; (var6 < ((int) u + 4)) && (var2 < 14); ++var6) {
						Block var7 = o.p(var3.c(var4, var5, var6)).c();
						if ((var7 == Blocks.IRON_BARS) || (var7 == Blocks.BED)) {
							if (V.nextFloat() < 0.3F) {
								++var1;
							}

							++var2;
						}
					}
				}
			}
		}

		return var1;
	}

	public void p(boolean var1) {
		this.a(var1 ? 0.5F : 1.0F);
	}

	@Override
	protected final void a(float var1, float var2) {
		boolean var3 = (bA > 0.0F) && (bB > 0.0F);
		bA = var1;
		bB = var2;
		if (!var3) {
			this.a(1.0F);
		}

	}

	protected final void a(float var1) {
		super.a(bA * var1, bB * var1);
	}

	@Override
	public double ap() {
		return i_() ? 0.0D : -0.35D;
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if ((var1.j() instanceof EntityCreeper) && !(this instanceof EntityPigZombie) && ((EntityCreeper) var1.j()).n() && ((EntityCreeper) var1.j()).cI()) {
			((EntityCreeper) var1.j()).cJ();
			this.a(new class_aco(Items.cc, 1, 2), 0.0F);
		}

	}

	static {
		c = new class_rr(b, "Baby speed boost", 0.5D, 1);
		bt = DataWatcher.claimId(EntityZombie.class, class_kb.g);
		bu = DataWatcher.claimId(EntityZombie.class, class_kb.g);
		bv = DataWatcher.claimId(EntityZombie.class, class_kb.g);
		bw = DataWatcher.claimId(EntityZombie.class, class_kb.g);
	}

	class class_a_in_class_yl implements class_rj {
		public boolean a;
		public boolean b;

		private class_a_in_class_yl(boolean var2, boolean var3) {
			a = false;
			b = false;
			a = var2;
			b = var3;
		}

	}
}
