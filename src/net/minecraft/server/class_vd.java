package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_vd extends class_vc {
	private static final Set bB;
	public float bt;
	public float bu;
	public float bv;
	public float bx;
	public float by = 1.0F;
	public int bz;
	public boolean bA;

	public class_vd(class_ago var1) {
		super(var1);
		this.a(0.4F, 0.7F);
		bz = V.nextInt(6000) + 6000;
		i.a(0, new class_so(this));
		i.a(1, new class_tj(this, 1.4D));
		i.a(2, new class_sj(this, 1.0D));
		i.a(3, new class_tw(this, 1.0D, false, bB));
		i.a(4, new class_sq(this, 1.1D));
		i.a(5, new class_tn(this, 1.0D));
		i.a(6, new class_sw(this, class_yu.class, 6.0F));
		i.a(7, new class_tm(this));
	}

	@Override
	public float aY() {
		return K;
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(4.0D);
		this.a(class_yf.d).a(0.25D);
	}

	@Override
	public void m() {
		super.m();
		bx = bt;
		bv = bu;
		bu = (float) (bu + ((C ? -1 : 4) * 0.3D));
		bu = MathHelper.a(bu, 0.0F, 1.0F);
		if (!C && (by < 1.0F)) {
			by = 1.0F;
		}

		by = (float) (by * 0.9D);
		if (!C && (w < 0.0D)) {
			w *= 0.6D;
		}

		bt += by * 2.0F;
		if (!o.D && !i_() && !cE() && (--bz <= 0)) {
			this.a("mob.chicken.plop", 1.0F, ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F);
			this.a(Items.aR, 1);
			bz = V.nextInt(6000) + 6000;
		}

	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	protected String B() {
		return "mob.chicken.say";
	}

	@Override
	protected String bv() {
		return "mob.chicken.hurt";
	}

	@Override
	protected String bw() {
		return "mob.chicken.hurt";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.chicken.step", 0.15F, 1.0F);
	}

	@Override
	protected Item D() {
		return Items.I;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3) + V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(Items.I, 1);
		}

		if (ay()) {
			this.a(Items.bn, 1);
		} else {
			this.a(Items.bm, 1);
		}

	}

	public class_vd b(class_qu var1) {
		return new class_vd(o);
	}

	@Override
	public boolean d(class_aco var1) {
		return (var1 != null) && bB.contains(var1.b());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		bA = var1.p("IsChickenJockey");
		if (var1.e("EggLayTime")) {
			bz = var1.h("EggLayTime");
		}

	}

	@Override
	protected int b(class_yu var1) {
		return cE() ? 10 : super.b(var1);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("IsChickenJockey", bA);
		var1.a("EggLayTime", bz);
	}

	@Override
	protected boolean E() {
		return cE() && (l == null);
	}

	@Override
	public void ao() {
		super.ao();
		float var1 = MathHelper.a((aM * 3.1415927F) / 180.0F);
		float var2 = MathHelper.b((aM * 3.1415927F) / 180.0F);
		float var3 = 0.1F;
		float var4 = 0.0F;
		l.b(s + var3 * var1, t + K * 0.5F + l.ap() + var4, u - var3 * var2);
		if (l instanceof class_rg) {
			((class_rg) l).aM = aM;
		}

	}

	public boolean cE() {
		return bA;
	}

	public void m(boolean var1) {
		bA = var1;
	}

	// $FF: synthetic method
	@Override
	public class_qu a(class_qu var1) {
		return this.b(var1);
	}

	static {
		bB = Sets.newHashSet((Object[]) (new Item[] { Items.P, Items.bj, Items.bi, Items.cN }));
	}
}
