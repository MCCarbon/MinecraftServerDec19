package net.minecraft.server;

import java.util.UUID;

import com.google.common.base.Predicate;

public class EntityWolf extends class_ro {
	private static final class_jz bx;
	private static final class_jz by;
	private static final class_jz bz;
	private float bA;
	private float bB;
	private boolean bC;
	private boolean bD;
	private float bE;
	private float bF;

	public EntityWolf(class_ago var1) {
		super(var1);
		this.a(0.6F, 0.8F);
		((class_ul) u()).a(true);
		i.a(1, new class_so(this));
		i.a(2, bv);
		i.a(3, new class_sv(this, 0.4F));
		i.a(4, new class_sz(this, 1.0D, true));
		i.a(5, new class_sp(this, 1.0D, 10.0F, 2.0F));
		i.a(6, new class_sj(this, 1.0D));
		i.a(7, new class_tn(this, 1.0D));
		i.a(8, new class_sh(this, 8.0F));
		i.a(9, new class_sw(this, class_yu.class, 8.0F));
		i.a(9, new class_tm(this));
		bo.a(1, new class_uh(this));
		bo.a(2, new class_ui(this));
		bo.a(3, new class_uc(this, true, new Class[0]));
		bo.a(4, new class_ug(this, EntityAnimal.class, false, new Predicate() {
			public boolean a(Entity var1) {
				return (var1 instanceof EntitySheep) || (var1 instanceof EntityRabbit);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		}));
		bo.a(5, new class_uf(this, EntitySkeleton.class, false));
		this.n(false);
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.d).a(0.30000001192092896D);
		if (cE()) {
			this.a(class_yf.a).a(20.0D);
		} else {
			this.a(class_yf.a).a(8.0D);
		}

		bE().b(class_yf.e).a(2.0D);
	}

	@Override
	public void c(EntityLiving var1) {
		super.c(var1);
		if (var1 == null) {
			this.p(false);
		} else if (!cE()) {
			this.p(true);
		}

	}

	@Override
	protected void cg() {
		ac.b(bx, Float.valueOf(bu()));
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bx, Float.valueOf(bu()));
		ac.a(by, Boolean.valueOf(false));
		ac.a(bz, Integer.valueOf(class_abt.o.a()));
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.wolf.step", 0.15F, 1.0F);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Angry", cO());
		var1.a("CollarColor", (byte) cP().b());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.p(var1.p("Angry"));
		if (var1.b("CollarColor", 99)) {
			this.a(class_abt.a(var1.f("CollarColor")));
		}

	}

	@Override
	protected String B() {
		return cO() ? "mob.wolf.growl" : (V.nextInt(3) == 0 ? (cE() && (((Float) ac.a(bx)).floatValue() < 10.0F) ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
	}

	@Override
	protected String bv() {
		return "mob.wolf.hurt";
	}

	@Override
	protected String bw() {
		return "mob.wolf.death";
	}

	@Override
	protected float bI() {
		return 0.4F;
	}

	@Override
	protected Item D() {
		return Item.c(-1);
	}

	@Override
	public void m() {
		super.m();
		if (!o.D && bC && !bD && !cy() && C) {
			bD = true;
			bE = 0.0F;
			bF = 0.0F;
			o.a(this, (byte) 8);
		}

		if (!o.D && (w() == null) && cO()) {
			this.p(false);
		}

	}

	@Override
	public void r_() {
		super.r_();
		bB = bA;
		if (cQ()) {
			bA += (1.0F - bA) * 0.4F;
		} else {
			bA += (0.0F - bA) * 0.4F;
		}

		if (X()) {
			bC = true;
			bD = false;
			bE = 0.0F;
			bF = 0.0F;
		} else if ((bC || bD) && bD) {
			if (bE == 0.0F) {
				this.a("mob.wolf.shake", bI(), ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F);
			}

			bF = bE;
			bE += 0.05F;
			if (bF >= 2.0F) {
				bC = false;
				bD = false;
				bF = 0.0F;
				bE = 0.0F;
			}

			if (bE > 0.4F) {
				float var1 = (float) aX().b;
				int var2 = (int) (MathHelper.a((bE - 0.4F) * 3.1415927F) * 7.0F);

				for (int var3 = 0; var3 < var2; ++var3) {
					float var4 = ((V.nextFloat() * 2.0F) - 1.0F) * J * 0.5F;
					float var5 = ((V.nextFloat() * 2.0F) - 1.0F) * J * 0.5F;
					o.a(class_cy.f, s + var4, var1 + 0.8F, u + var5, v, w, x, new int[0]);
				}
			}
		}

	}

	@Override
	public float aY() {
		return K * 0.8F;
	}

	@Override
	public int ch() {
		return cG() ? 20 : super.ch();
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			Entity var3 = var1.j();
			bv.a(false);
			if ((var3 != null) && !(var3 instanceof class_yu) && !(var3 instanceof EntityArrow)) {
				var2 = (var2 + 1.0F) / 2.0F;
			}

			return super.a(var1, var2);
		}
	}

	@Override
	public boolean r(Entity var1) {
		boolean var2 = var1.a(class_qi.a(this), ((int) this.a(class_yf.e).e()));
		if (var2) {
			this.a(this, var1);
		}

		return var2;
	}

	@Override
	public void n(boolean var1) {
		super.n(var1);
		if (var1) {
			this.a(class_yf.a).a(20.0D);
		} else {
			this.a(class_yf.a).a(8.0D);
		}

		this.a(class_yf.e).a(4.0D);
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if (cE()) {
			if (var3 != null) {
				if (var3.b() instanceof class_aci) {
					class_aci var4 = (class_aci) var3.b();
					if (var4.g() && (((Float) ac.a(bx)).floatValue() < 20.0F)) {
						if (!var1.bI.d) {
							--var3.b;
						}

						this.b((float) var4.h(var3));
						return true;
					}
				} else if (var3.b() == Items.aY) {
					class_abt var5 = class_abt.a(var3.i());
					if (var5 != cP()) {
						this.a(var5);
						if (!var1.bI.d) {
							--var3.b;
						}

						return true;
					}
				}
			}

			if (this.d((EntityLiving) var1) && !o.D && !this.d(var3)) {
				bv.a(!cG());
				bc = false;
				h.n();
				this.c((EntityLiving) null);
			}
		} else if ((var3 != null) && (var3.b() == Items.aZ) && !cO()) {
			if (!var1.bI.d) {
				--var3.b;
			}

			if (!o.D) {
				if (V.nextInt(3) == 0) {
					this.n(true);
					h.n();
					this.c((EntityLiving) null);
					bv.a(true);
					this.c(20.0F);
					this.b(var1.aQ());
					this.m(true);
					o.a(this, (byte) 7);
				} else {
					this.m(false);
					o.a(this, (byte) 6);
				}
			}

			return true;
		}

		return super.a(var1, var2, var3);
	}

	@Override
	public boolean d(class_aco var1) {
		return var1 == null ? false : (!(var1.b() instanceof class_aci) ? false : ((class_aci) var1.b()).g());
	}

	@Override
	public int cn() {
		return 8;
	}

	public boolean cO() {
		return (((Byte) ac.a(bt)).byteValue() & 2) != 0;
	}

	public void p(boolean var1) {
		byte var2 = ((Byte) ac.a(bt)).byteValue();
		if (var1) {
			ac.b(bt, Byte.valueOf((byte) (var2 | 2)));
		} else {
			ac.b(bt, Byte.valueOf((byte) (var2 & -3)));
		}

	}

	public class_abt cP() {
		return class_abt.a(((Integer) ac.a(bz)).intValue() & 15);
	}

	public void a(class_abt var1) {
		ac.b(bz, Integer.valueOf(var1.b()));
	}

	public EntityWolf b(EntityAgeable var1) {
		EntityWolf var2 = new EntityWolf(o);
		UUID var3 = this.b();
		if (var3 != null) {
			var2.b(var3);
			var2.n(true);
		}

		return var2;
	}

	public void q(boolean var1) {
		ac.b(by, Boolean.valueOf(var1));
	}

	@Override
	public boolean a(EntityAnimal var1) {
		if (var1 == this) {
			return false;
		} else if (!cE()) {
			return false;
		} else if (!(var1 instanceof EntityWolf)) {
			return false;
		} else {
			EntityWolf var2 = (EntityWolf) var1;
			return !var2.cE() ? false : (var2.cG() ? false : cK() && var2.cK());
		}
	}

	public boolean cQ() {
		return ((Boolean) ac.a(by)).booleanValue();
	}

	@Override
	protected boolean E() {
		return !cE() && (W > 2400);
	}

	@Override
	public boolean a(EntityLiving var1, EntityLiving var2) {
		if (!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
			if (var1 instanceof EntityWolf) {
				EntityWolf var3 = (EntityWolf) var1;
				if (var3.cE() && (var3.cH() == var2)) {
					return false;
				}
			}

			return (var1 instanceof class_yu) && (var2 instanceof class_yu) && !((class_yu) var2).a((class_yu) var1) ? false : !(var1 instanceof EntityHorse) || !((EntityHorse) var1).cH();
		} else {
			return false;
		}
	}

	@Override
	public boolean ct() {
		return !cO() && super.ct();
	}

	// $FF: synthetic method
	@Override
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}

	static {
		bx = DataWatcher.claimId(EntityWolf.class, class_kb.c);
		by = DataWatcher.claimId(EntityWolf.class, class_kb.g);
		bz = DataWatcher.claimId(EntityWolf.class, class_kb.b);
	}
}
