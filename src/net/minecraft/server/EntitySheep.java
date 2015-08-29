package net.minecraft.server;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

public class EntitySheep extends EntityAnimal {
	private static final class_jz bt;
	private final class_aab bu = new class_aab(new class_zu() {
		@Override
		public boolean a(class_yu var1) {
			return false;
		}
	}, 2, 1);
	private static final Map bv;
	private int bx;
	private class_sm by = new class_sm(this);

	public static float[] a(class_abt var0) {
		return (float[]) bv.get(var0);
	}

	public EntitySheep(class_ago var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		((class_ul) u()).a(true);
		i.a(0, new class_so(this));
		i.a(1, new class_tj(this, 1.25D));
		i.a(2, new class_sj(this, 1.0D));
		i.a(3, new class_tw(this, 1.1D, Items.Q, false));
		i.a(4, new class_sq(this, 1.1D));
		i.a(5, by);
		i.a(6, new class_tn(this, 1.0D));
		i.a(7, new class_sw(this, class_yu.class, 6.0F));
		i.a(8, new class_tm(this));
		bu.a(0, new class_aco(Items.aY));
		bu.a(1, new class_aco(Items.aY));
	}

	@Override
	protected void cg() {
		bx = by.f();
		super.cg();
	}

	@Override
	public void m() {
		if (o.D) {
			bx = Math.max(0, bx - 1);
		}

		super.m();
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(8.0D);
		this.a(class_yf.d).a(0.23000000417232513D);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bt, Byte.valueOf((byte) 0));
	}

	@Override
	protected void b(boolean var1, int var2) {
		if (!cF()) {
			this.a(new class_aco(Item.a(Blocks.WOOL), 1, cE().a()), 0.0F);
		}

		int var3 = V.nextInt(2) + 1 + V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			if (ay()) {
				this.a(Items.bp, 1);
			} else {
				this.a(Items.bo, 1);
			}
		}

	}

	@Override
	protected Item D() {
		return Item.a(Blocks.WOOL);
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == Items.bg) && !cF() && !i_()) {
			if (!o.D) {
				this.m(true);
				int var4 = 1 + V.nextInt(3);

				for (int var5 = 0; var5 < var4; ++var5) {
					EntityItem var6 = this.a(new class_aco(Item.a(Blocks.WOOL), 1, cE().a()), 1.0F);
					var6.w += V.nextFloat() * 0.05F;
					var6.v += (V.nextFloat() - V.nextFloat()) * 0.1F;
					var6.x += (V.nextFloat() - V.nextFloat()) * 0.1F;
				}
			}

			var3.a(1, var1);
			this.a("mob.sheep.shear", 1.0F, 1.0F);
		}

		return super.a(var1, var2, var3);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Sheared", cF());
		var1.a("Color", (byte) cE().a());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.m(var1.p("Sheared"));
		this.b(class_abt.b(var1.f("Color")));
	}

	@Override
	protected String B() {
		return "mob.sheep.say";
	}

	@Override
	protected String bv() {
		return "mob.sheep.say";
	}

	@Override
	protected String bw() {
		return "mob.sheep.say";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.sheep.step", 0.15F, 1.0F);
	}

	public class_abt cE() {
		return class_abt.b(((Byte) ac.a(bt)).byteValue() & 15);
	}

	public void b(class_abt var1) {
		byte var2 = ((Byte) ac.a(bt)).byteValue();
		ac.b(bt, Byte.valueOf((byte) ((var2 & 240) | (var1.a() & 15))));
	}

	public boolean cF() {
		return (((Byte) ac.a(bt)).byteValue() & 16) != 0;
	}

	public void m(boolean var1) {
		byte var2 = ((Byte) ac.a(bt)).byteValue();
		if (var1) {
			ac.b(bt, Byte.valueOf((byte) (var2 | 16)));
		} else {
			ac.b(bt, Byte.valueOf((byte) (var2 & -17)));
		}

	}

	public static class_abt a(Random var0) {
		int var1 = var0.nextInt(100);
		return var1 < 5 ? class_abt.p : (var1 < 10 ? class_abt.h : (var1 < 15 ? class_abt.i : (var1 < 18 ? class_abt.m : (var0.nextInt(500) == 0 ? class_abt.g : class_abt.a))));
	}

	public EntitySheep b(EntityAgeable var1) {
		EntitySheep var2 = (EntitySheep) var1;
		EntitySheep var3 = new EntitySheep(o);
		var3.b(this.a(this, var2));
		return var3;
	}

	@Override
	public void x() {
		this.m(false);
		if (i_()) {
			this.a(60);
		}

	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		var2 = super.a(var1, var2);
		this.b(a(o.s));
		return var2;
	}

	private class_abt a(EntityAnimal var1, EntityAnimal var2) {
		int var3 = ((EntitySheep) var1).cE().b();
		int var4 = ((EntitySheep) var2).cE().b();
		bu.a(0).b(var3);
		bu.a(1).b(var4);
		class_aco var5 = class_aet.a().a(bu, ((EntitySheep) var1).o);
		int var6;
		if ((var5 != null) && (var5.b() == Items.aY)) {
			var6 = var5.i();
		} else {
			var6 = o.s.nextBoolean() ? var3 : var4;
		}

		return class_abt.a(var6);
	}

	@Override
	public float aY() {
		return 0.95F * K;
	}

	// $FF: synthetic method
	@Override
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}

	static {
		bt = DataWatcher.claimId(EntitySheep.class, class_kb.a);
		bv = Maps.newEnumMap(class_abt.class);
		bv.put(class_abt.a, new float[] { 1.0F, 1.0F, 1.0F });
		bv.put(class_abt.b, new float[] { 0.85F, 0.5F, 0.2F });
		bv.put(class_abt.c, new float[] { 0.7F, 0.3F, 0.85F });
		bv.put(class_abt.d, new float[] { 0.4F, 0.6F, 0.85F });
		bv.put(class_abt.e, new float[] { 0.9F, 0.9F, 0.2F });
		bv.put(class_abt.f, new float[] { 0.5F, 0.8F, 0.1F });
		bv.put(class_abt.g, new float[] { 0.95F, 0.5F, 0.65F });
		bv.put(class_abt.h, new float[] { 0.3F, 0.3F, 0.3F });
		bv.put(class_abt.i, new float[] { 0.6F, 0.6F, 0.6F });
		bv.put(class_abt.j, new float[] { 0.3F, 0.5F, 0.6F });
		bv.put(class_abt.k, new float[] { 0.5F, 0.25F, 0.7F });
		bv.put(class_abt.l, new float[] { 0.2F, 0.3F, 0.7F });
		bv.put(class_abt.m, new float[] { 0.4F, 0.3F, 0.2F });
		bv.put(class_abt.n, new float[] { 0.4F, 0.5F, 0.2F });
		bv.put(class_abt.o, new float[] { 0.6F, 0.2F, 0.2F });
		bv.put(class_abt.p, new float[] { 0.1F, 0.1F, 0.1F });
	}
}
