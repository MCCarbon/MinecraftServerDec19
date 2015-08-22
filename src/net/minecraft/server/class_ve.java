package net.minecraft.server;


public class class_ve extends class_vc {
	public class_ve(class_ago var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		((class_ul) u()).a(true);
		i.a(0, new class_so(this));
		i.a(1, new class_tj(this, 2.0D));
		i.a(2, new class_sj(this, 1.0D));
		i.a(3, new class_tw(this, 1.25D, Items.Q, false));
		i.a(4, new class_sq(this, 1.25D));
		i.a(5, new class_tn(this, 1.0D));
		i.a(6, new class_sw(this, class_yu.class, 6.0F));
		i.a(7, new class_tm(this));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(10.0D);
		this.a(class_yf.d).a(0.20000000298023224D);
	}

	@Override
	protected String B() {
		return "mob.cow.say";
	}

	@Override
	protected String bv() {
		return "mob.cow.hurt";
	}

	@Override
	protected String bw() {
		return "mob.cow.hurt";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.cow.step", 0.15F, 1.0F);
	}

	@Override
	protected float bI() {
		return 0.4F;
	}

	@Override
	protected Item D() {
		return Items.aH;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3) + V.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.aH, 1);
		}

		var3 = V.nextInt(3) + 1 + V.nextInt(1 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			if (ay()) {
				this.a(Items.bl, 1);
			} else {
				this.a(Items.bk, 1);
			}
		}

	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == Items.ay) && !var1.bI.d && !i_()) {
			if (--var3.b == 0) {
				var1.a(var2, (new class_aco(Items.aI)));
			} else if (!var1.bq.a(new class_aco(Items.aI))) {
				var1.a(new class_aco(Items.aI), false);
			}

			return true;
		} else {
			return super.a(var1, var2, var3);
		}
	}

	public class_ve b(class_qu var1) {
		return new class_ve(o);
	}

	@Override
	public float aY() {
		return K;
	}

	// $FF: synthetic method
	@Override
	public class_qu a(class_qu var1) {
		return this.b(var1);
	}
}
