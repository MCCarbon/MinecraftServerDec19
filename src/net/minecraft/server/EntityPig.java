package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;

public class EntityPig extends EntityAnimal {

	private static final int HASSADDLE_DW_ID = Datawathcer.claimId(EntityPig.class); //value = 12

	private static final Set bt;
	private final class_rf bu;

	public EntityPig(World var1) {
		super(var1);
		this.a(0.9F, 0.9F);
		((class_tf) this.u()).a(true);
		this.i.a(0, new class_rj(this));
		this.i.a(1, new class_se(this, 1.25D));
		this.i.a(2, this.bu = new class_rf(this, 0.3F));
		this.i.a(3, new class_re(this, 1.0D));
		this.i.a(4, new class_sr(this, 1.2D, Items.CARROT_ON_A_STICK, false));
		this.i.a(4, new class_sr(this, 1.2D, false, bt));
		this.i.a(5, new class_rl(this, 1.1D));
		this.i.a(6, new class_si(this, 1.0D));
		this.i.a(7, new class_rr(this, EntityHuman.class, 6.0F));
		this.i.a(8, new class_sh(this));
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.a).a(10.0D);
		this.a((class_qk) class_wl.d).a(0.25D);
	}

	public boolean ck() {
		ItemStack var1 = ((EntityHuman) this.passenger).bA();
		if (var1 != null && var1.getItem() == Items.CARROT_ON_A_STICK) {
			return true;
		} else {
			var1 = ((EntityHuman) this.passenger).bB();
			return var1 != null && var1.getItem() == Items.CARROT_ON_A_STICK;
		}
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(HASSADDLE_DW_ID, Byte.valueOf((byte) 0));
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Saddle", this.cA());
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		this.m(var1.getBoolean("Saddle"));
	}

	protected String C() {
		return "mob.pig.say";
	}

	protected String bp() {
		return "mob.pig.say";
	}

	protected String bq() {
		return "mob.pig.death";
	}

	protected void a(BlockPosition var1, Block var2) {
		this.a("mob.pig.step", 0.15F, 1.0F);
	}

	public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
		if (super.a(var1, var2, var3)) {
			return true;
		} else if (!this.cA() || this.o.isClientSide || this.passenger != null && this.passenger != var1) {
			return false;
		} else {
			var1.a((Entity) this);
			return true;
		}
	}

	protected Item D() {
		return this.av() ? Items.COOKED_PORKCHOP : Items.PORKCHOP;
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.random.nextInt(3) + 1 + this.random.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			if (this.av()) {
				this.a(Items.COOKED_PORKCHOP, 1);
			} else {
				this.a(Items.PORKCHOP, 1);
			}
		}

		if (this.cA()) {
			this.a(Items.SADDLE, 1);
		}

	}

	public boolean cA() {
		return (this.datawatcher.getByte(HASSADDLE_DW_ID) & 1) != 0;
	}

	public void m(boolean var1) {
		if (var1) {
			this.datawatcher.update(HASSADDLE_DW_ID, Byte.valueOf((byte) 1));
		} else {
			this.datawatcher.update(HASSADDLE_DW_ID, Byte.valueOf((byte) 0));
		}

	}

	public void a(class_vi var1) {
		if (!this.o.isClientSide && !this.I) {
			EntityPigZombie var2 = new EntityPigZombie(this.o);
			var2.a((EnumWearable) EnumWearable.MAINHAND, (ItemStack) (new ItemStack(Items.GOLDEN_SWORD)));
			var2.b(this.s, this.t, this.u, this.y, this.z);
			var2.k(this.cs());
			if (this.hasCustomName()) {
				var2.a((String) this.aO());
				var2.g(this.aP());
			}

			this.o.addEntity((Entity) var2);
			this.J();
		}
	}

	public void e(float var1, float var2) {
		super.e(var1, var2);
		if (var1 > 5.0F && this.passenger instanceof EntityHuman) {
			((EntityHuman) this.passenger).b((class_my) class_mt.u);
		}

	}

	public EntityPig b(EntityAgeable var1) {
		return new EntityPig(this.o);
	}

	public boolean d(ItemStack var1) {
		return var1 != null && bt.contains(var1.getItem());
	}

	public class_rf cB() {
		return this.bu;
	}

	// $FF: synthetic method
	public EntityAgeable createChild(EntityAgeable var1) {
		return this.b(var1);
	}

	static {
		bt = Sets.newHashSet((Object[]) (new Item[] { Items.CARROT, Items.POTATO, Items.BEETROOT }));
	}
}
