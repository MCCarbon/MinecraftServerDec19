package net.minecraft.server;


public class EntityCreeper extends EntityMonster {
	private static final class_jz a;
	private static final class_jz b;
	private static final class_jz c;
	private int bt;
	private int bu;
	private int bv = 30;
	private int bw = 3;
	private int bx = 0;

	public EntityCreeper(class_ago var1) {
		super(var1);
		i.a(1, new class_so(this));
		i.a(2, new class_tu(this));
		i.a(3, new class_sg(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
		i.a(4, new class_sz(this, 1.0D, false));
		i.a(5, new class_tn(this, 0.8D));
		i.a(6, new class_sw(this, class_yu.class, 8.0F));
		i.a(6, new class_tm(this));
		bo.a(1, new class_uf(this, class_yu.class, true));
		bo.a(2, new class_uc(this, false, new Class[0]));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.d).a(0.25D);
	}

	@Override
	public int aK() {
		return w() == null ? 3 : 3 + (int) (bu() - 1.0F);
	}

	@Override
	public void e(float var1, float var2) {
		super.e(var1, var2);
		bu = (int) (bu + (var1 * 1.5F));
		if (bu > (bv - 5)) {
			bu = bv - 5;
		}

	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Integer.valueOf(-1));
		ac.a(b, Boolean.valueOf(false));
		ac.a(c, Boolean.valueOf(false));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (((Boolean) ac.a(b)).booleanValue()) {
			var1.a("powered", true);
		}

		var1.a("Fuse", (short) bv);
		var1.a("ExplosionRadius", (byte) bw);
		var1.a("ignited", cG());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		ac.b(b, Boolean.valueOf(var1.p("powered")));
		if (var1.b("Fuse", 99)) {
			bv = var1.g("Fuse");
		}

		if (var1.b("ExplosionRadius", 99)) {
			bw = var1.f("ExplosionRadius");
		}

		if (var1.p("ignited")) {
			cH();
		}

	}

	@Override
	public void r_() {
		if (al()) {
			bt = bu;
			if (cG()) {
				this.a(1);
			}

			int var1 = cF();
			if ((var1 > 0) && (bu == 0)) {
				this.a("creeper.primed", 1.0F, 0.5F);
			}

			bu += var1;
			if (bu < 0) {
				bu = 0;
			}

			if (bu >= bv) {
				bu = bv;
				cK();
			}
		}

		super.r_();
	}

	@Override
	protected String bv() {
		return "mob.creeper.say";
	}

	@Override
	protected String bw() {
		return "mob.creeper.death";
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (var1.j() instanceof EntitySkeleton) {
			int var2 = Item.b(Items.cv);
			int var3 = Item.b(Items.cG);
			int var4 = var2 + V.nextInt((var3 - var2) + 1);
			this.a(Item.c(var4), 1);
		} else if ((var1.j() instanceof EntityCreeper) && (var1.j() != this) && ((EntityCreeper) var1.j()).n() && ((EntityCreeper) var1.j()).cI()) {
			((EntityCreeper) var1.j()).cJ();
			this.a(new class_aco(Items.cc, 1, 4), 0.0F);
		}

	}

	@Override
	public boolean r(Entity var1) {
		return true;
	}

	public boolean n() {
		return ((Boolean) ac.a(b)).booleanValue();
	}

	@Override
	protected Item D() {
		return Items.J;
	}

	public int cF() {
		return ((Integer) ac.a(a)).intValue();
	}

	public void a(int var1) {
		ac.b(a, Integer.valueOf(var1));
	}

	@Override
	public void a(class_xc var1) {
		super.a(var1);
		ac.b(b, Boolean.valueOf(true));
	}

	@Override
	protected boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == Items.d)) {
			o.a(s + 0.5D, t + 0.5D, u + 0.5D, "fire.ignite", 1.0F, (V.nextFloat() * 0.4F) + 0.8F);
			var1.a(var2);
			if (!o.D) {
				cH();
				var3.a(1, var1);
				return true;
			}
		}

		return super.a(var1, var2, var3);
	}

	private void cK() {
		if (!o.D) {
			boolean var1 = o.S().b("mobGriefing");
			float var2 = this.n() ? 2.0F : 1.0F;
			o.a(this, s, t, u, bw * var2, var1);
			L();
		}

	}

	public boolean cG() {
		return ((Boolean) ac.a(c)).booleanValue();
	}

	public void cH() {
		ac.b(c, Boolean.valueOf(true));
	}

	public boolean cI() {
		return (bx < 1) && o.S().b("doMobLoot");
	}

	public void cJ() {
		++bx;
	}

	static {
		a = DataWatcher.claimId(EntityCreeper.class, class_kb.b);
		b = DataWatcher.claimId(EntityCreeper.class, class_kb.g);
		c = DataWatcher.claimId(EntityCreeper.class, class_kb.g);
	}
}
