package net.minecraft.server;

import java.util.Random;

public class EntitySpider extends EntityMonster {

	private static final int CLIMBING_DW_ID = DataWatcher.claimId(EntitySpider.class); //value = 11

	public EntitySpider(World var1) {
		super(var1);
		this.setSize(1.4F, 0.9F);
		this.i.a(1, new class_rj(this));
		this.i.a(3, new class_rq(this, 0.4F));
		this.i.a(4, new EntitySpider.class_a_in_class_wp(this, EntityHuman.class));
		this.i.a(4, new EntitySpider.class_a_in_class_wp(this, EntityVillagerGolem.class));
		this.i.a(5, new class_si(this, 0.8D));
		this.i.a(6, new class_rr(this, EntityHuman.class, 8.0F));
		this.i.a(6, new class_sh(this));
		this.bn.a(1, new class_sw(this, false, new Class[0]));
		this.bn.a(2, new EntitySpider.class_c_in_class_wp(this, EntityHuman.class));
		this.bn.a(3, new EntitySpider.class_c_in_class_wp(this, EntityVillagerGolem.class));
	}

	public double an() {
		return (double) (this.length * 0.5F);
	}

	protected class_tg b(World var1) {
		return new class_th(this, var1);
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(CLIMBING_DW_ID, new Byte((byte) 0));
	}

	public void t_() {
		super.t_();
		if (!this.world.isClientSide) {
			this.a(this.positionChanged);
		}

	}

	protected void aY() {
		super.aY();
		this.a(class_wl.a).a(16.0D);
		this.a(class_wl.d).a(0.30000001192092896D);
	}

	protected String C() {
		return "mob.spider.say";
	}

	protected String bp() {
		return "mob.spider.say";
	}

	protected String bq() {
		return "mob.spider.death";
	}

	protected void a(BlockPosition var1, Block var2) {
		this.makeSound("mob.spider.step", 0.15F, 1.0F);
	}

	protected Item D() {
		return Items.STRING;
	}

	protected void b(boolean var1, int var2) {
		super.b(var1, var2);
		if (var1 && (this.random.nextInt(3) == 0 || this.random.nextInt(1 + var2) > 0)) {
			this.a(Items.SPIDER_EYE, 1);
		}

	}

	public boolean k_() {
		return this.n();
	}

	public void aC() {
	}

	public class_qf bz() {
		return class_qf.c;
	}

	public boolean d(MobEffect var1) {
		return var1.getEffectType() == MobEffectList.POISON ? false : super.d(var1);
	}

	public boolean n() {
		return (this.datawatcher.getByte(CLIMBING_DW_ID) & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = this.datawatcher.getByte(CLIMBING_DW_ID);
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		this.datawatcher.update(CLIMBING_DW_ID, Byte.valueOf(var2));
	}

	public class_qd a(class_on var1, class_qd var2) {
		Object var4 = super.a(var1, var2);
		if (this.world.random.nextInt(100) == 0) {
			EntitySkeleton var3 = new EntitySkeleton(this.world);
			var3.setPositionRotation(this.locX, this.locY, this.locZ, this.yaw, 0.0F);
			var3.a((class_on) var1, (class_qd) null);
			this.world.addEntity((Entity) var3);
			var3.a((Entity) this);
		}

		if (var4 == null) {
			var4 = new EntitySpider.class_b_in_class_wp();
			if (this.world.ab() == class_om.d && this.world.random.nextFloat() < 0.1F * var1.c()) {
				((EntitySpider.class_b_in_class_wp) var4).a(this.world.random);
			}
		}

		if (var4 instanceof EntitySpider.class_b_in_class_wp) {
			MobEffectType var5 = ((EntitySpider.class_b_in_class_wp) var4).a;
			if (var5 != null) {
				this.addEffect(new MobEffect(var5, Integer.MAX_VALUE));
			}
		}

		return (class_qd) var4;
	}

	public float getHeadHeight() {
		return 0.65F;
	}

	static class class_c_in_class_wp extends class_sz {
		public class_c_in_class_wp(EntitySpider var1, Class var2) {
			super(var1, var2, true);
		}

		public boolean a() {
			float var1 = this.e.c(1.0F);
			return var1 >= 0.5F ? false : super.a();
		}
	}

	static class class_a_in_class_wp extends class_ru {
		public class_a_in_class_wp(EntitySpider var1, Class var2) {
			super(var1, var2, 1.0D, true);
		}

		public boolean b() {
			float var1 = this.b.c(1.0F);
			if (var1 >= 0.5F && this.b.getRandom().nextInt(100) == 0) {
				this.b.d((EntityLiving) null);
				return false;
			} else {
				return super.b();
			}
		}

		protected double a(EntityLiving var1) {
			return (double) (4.0F + var1.width);
		}
	}

	public static class class_b_in_class_wp implements class_qd {
		public MobEffectType a;

		public void a(Random var1) {
			int var2 = var1.nextInt(5);
			if (var2 <= 1) {
				this.a = MobEffectList.FASTER_MOVEMENT;
			} else if (var2 <= 2) {
				this.a = MobEffectList.INCREASE_DAMAGE;
			} else if (var2 <= 3) {
				this.a = MobEffectList.REGENERATION;
			} else if (var2 <= 4) {
				this.a = MobEffectList.INVISIBILITY;
			}

		}
	}
}
