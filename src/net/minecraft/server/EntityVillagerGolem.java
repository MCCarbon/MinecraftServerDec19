package net.minecraft.server;

import com.google.common.base.Predicate;

public class EntityVillagerGolem extends EntityGolem {

	protected static final int PLAYERCREATED_DW_ID = DataWatcher.claimId(EntityVillagerGolem.class); //value = 11

	private int c;
	class_tp b;
	private int bs;
	private int bt;

	public EntityVillagerGolem(World var1) {
		super(var1);
		this.setSize(1.4F, 2.9F);
		((class_tf) this.u()).a(true);
		this.i.a(1, new class_ru(this, 1.0D, true));
		this.i.a(2, new class_rz(this, 0.9D, 32.0F));
		this.i.a(3, new class_rw(this, 0.6D, true));
		this.i.a(4, new class_ry(this, 1.0D));
		this.i.a(5, new class_sc(this));
		this.i.a(6, new class_si(this, 0.6D));
		this.i.a(7, new class_rr(this, EntityHuman.class, 6.0F));
		this.i.a(8, new class_sh(this));
		this.bn.a(1, new class_sv(this));
		this.bn.a(2, new class_sw(this, false, new Class[0]));
		this.bn.a(3, new EntityVillagerGolem.class_a_in_class_uj(this, EntityInsentient.class, 10, false, true, IMonster.e));
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(PLAYERCREATED_DW_ID, Byte.valueOf((byte) 0));
	}

	protected void cc() {
		if (--this.c <= 0) {
			this.c = 70 + this.random.nextInt(50);
			this.b = this.world.af().a(new BlockPosition(this), 32);
			if (this.b == null) {
				this.cy();
			} else {
				BlockPosition var1 = this.b.a();
				this.a(var1, (int) ((float) this.b.b() * 0.6F));
			}
		}

		super.cc();
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.a).a(100.0D);
		this.a((class_qk) class_wl.d).a(0.25D);
	}

	protected int j(int var1) {
		return var1;
	}

	protected void s(Entity var1) {
		if (var1 instanceof IMonster && !(var1 instanceof EntityCreeper) && this.getRandom().nextInt(20) == 0) {
			this.d((EntityLiving) var1);
		}

		super.s(var1);
	}

	public void m() {
		super.m();
		if (this.bs > 0) {
			--this.bs;
		}

		if (this.bt > 0) {
			--this.bt;
		}

		if (this.motX * this.motX + this.motZ * this.motZ > 2.500000277905201E-7D && this.random.nextInt(5) == 0) {
			int var1 = MathHelper.floor(this.locX);
			int var2 = MathHelper.floor(this.locY - 0.20000000298023224D);
			int var3 = MathHelper.floor(this.locZ);
			IBlockData var4 = this.world.getType(new BlockPosition(var1, var2, var3));
			Block var5 = var4.getBlock();
			if (var5.getMaterial() != Material.AIR) {
				this.world.addParticle(EnumParticle.BLOCK_CRACK, this.locX + ((double) this.random.nextFloat() - 0.5D) * (double) this.width, this.getBoundingBox().yMin + 0.1D, this.locZ + ((double) this.random.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.random.nextFloat() - 0.5D), 0.5D, ((double) this.random.nextFloat() - 0.5D) * 4.0D, new int[] { Block.getCombinedId(var4) });
			}
		}

	}

	public boolean a(Class var1) {
		return this.cC() && EntityHuman.class.isAssignableFrom(var1) ? false : (var1 == EntityCreeper.class ? false : super.a(var1));
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("PlayerCreated", this.cC());
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		this.m(var1.getBoolean("PlayerCreated"));
	}

	public boolean r(Entity var1) {
		this.bs = 10;
		this.world.a((Entity) this, (byte) 4);
		boolean var2 = var1.damageEntity(DamageSource.mobAttack((EntityLiving) this), (float) (7 + this.random.nextInt(15)));
		if (var2) {
			var1.motY += 0.4000000059604645D;
			this.a(this, var1);
		}

		this.makeSound("mob.irongolem.throw", 1.0F, 1.0F);
		return var2;
	}

	public class_tp n() {
		return this.b;
	}

	public void a(boolean var1) {
		this.bt = var1 ? 400 : 0;
		this.world.a((Entity) this, (byte) 11);
	}

	protected String bp() {
		return "mob.irongolem.hit";
	}

	protected String bq() {
		return "mob.irongolem.death";
	}

	protected void a(BlockPosition var1, Block var2) {
		this.makeSound("mob.irongolem.walk", 1.0F, 1.0F);
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.random.nextInt(3);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Item.getItemOf((Block) Blocks.RED_FLOWER), 1, (float) BlockFlowers.EnumFlowerVarient.POPPY.getId());
		}

		var4 = 3 + this.random.nextInt(3);

		for (int var5 = 0; var5 < var4; ++var5) {
			this.a(Items.IRON_INGOT, 1);
		}

	}

	public int cB() {
		return this.bt;
	}

	public boolean cC() {
		return (this.datawatcher.getByte(PLAYERCREATED_DW_ID) & 1) != 0;
	}

	public void m(boolean var1) {
		byte var2 = this.datawatcher.getByte(PLAYERCREATED_DW_ID);
		if (var1) {
			this.datawatcher.update(PLAYERCREATED_DW_ID, Byte.valueOf((byte) (var2 | 1)));
		} else {
			this.datawatcher.update(PLAYERCREATED_DW_ID, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public void a(DamageSource var1) {
		if (!this.cC() && this.aQ != null && this.b != null) {
			this.b.a(this.aQ.getName(), -5);
		}

		super.a(var1);
	}

	static class class_a_in_class_uj extends class_sz {
		public class_a_in_class_uj(final EntityCreature var1, Class var2, int var3, boolean var4, boolean var5, final Predicate var6) {
			super(var1, var2, var3, var4, var5, var6);
			this.c = new Predicate() {
				public boolean a(EntityLiving var1x) {
					if (var6 != null && !var6.apply(var1x)) {
						return false;
					} else if (var1x instanceof EntityCreeper) {
						return false;
					} else {
						if (var1x instanceof EntityHuman) {
							double var2 = class_a_in_class_uj.this.f();
							if (var1x.ax()) {
								var2 *= 0.800000011920929D;
							}

							if (var1x.aA()) {
								float var4 = ((EntityHuman) var1x).cc();
								if (var4 < 0.1F) {
									var4 = 0.1F;
								}

								var2 *= (double) (0.7F * var4);
							}

							if ((double) var1x.g(var1) > var2) {
								return false;
							}
						}

						return class_a_in_class_uj.this.a(var1x, false);
					}
				}

				// $FF: synthetic method
				public boolean apply(Object var1x) {
					return this.a((EntityLiving) var1x);
				}
			};
		}
	}
}
