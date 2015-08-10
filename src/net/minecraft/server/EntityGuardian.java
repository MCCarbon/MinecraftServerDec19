package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class EntityGuardian extends EntityMonster {

	private static final int INFOFLAGS_DW_ID = DataWathcer.claimId(EntityGuardian.class); //value = 11
	private static final int TARGET_DW_ID = DataWathcer.claimId(EntityGuardian.class); //value = 12

	private float c;
	private float bs;
	private float bt;
	private float bu;
	private float bv;
	private EntityLiving bw;
	private int bx;
	private boolean by;
	private class_si bz;

	public EntityGuardian(World var1) {
		super(var1);
		this.b_ = 10;
		this.setSize(0.85F, 0.85F);
		this.i.a(4, new EntityGuardian.class_a_in_class_wg(this));
		class_ry var2;
		this.i.a(5, var2 = new class_ry(this, 1.0D));
		this.i.a(7, this.bz = new class_si(this, 1.0D, 80));
		this.i.a(8, new class_rr(this, EntityHuman.class, 8.0F));
		this.i.a(8, new class_rr(this, EntityGuardian.class, 12.0F, 0.01F));
		this.i.a(9, new class_sh(this));
		this.bz.a(3);
		var2.a(3);
		this.bn.a(1, new class_sz(this, EntityLiving.class, 10, true, false, new EntityGuardian.class_b_in_class_wg(this)));
		this.f = new EntityGuardian.class_c_in_class_wg(this);
		this.bs = this.c = this.random.nextFloat();
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.e).a(6.0D);
		this.a((class_qk) class_wl.d).a(0.5D);
		this.a((class_qk) class_wl.b).a(16.0D);
		this.a((class_qk) class_wl.a).a(30.0D);
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		this.a(var1.getBoolean("Elder"));
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Elder", this.cC());
	}

	protected class_tg b(World var1) {
		return new class_ti(this, var1);
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(INFOFLAGS_DW_ID, Integer.valueOf(0));
		this.datawatcher.add(TARGET_DW_ID, Integer.valueOf(0));
	}

	private boolean a(int var1) {
		return (this.datawatcher.getInt(INFOFLAGS_DW_ID) & var1) != 0;
	}

	private void a(int var1, boolean var2) {
		int var3 = this.datawatcher.getInt(INFOFLAGS_DW_ID);
		if (var2) {
			this.datawatcher.update(INFOFLAGS_DW_ID, Integer.valueOf(var3 | var1));
		} else {
			this.datawatcher.update(INFOFLAGS_DW_ID, Integer.valueOf(var3 & ~var1));
		}

	}

	public boolean n() {
		return this.a(2);
	}

	private void m(boolean var1) {
		this.a(2, var1);
	}

	public int cB() {
		return this.cC() ? 60 : 80;
	}

	public boolean cC() {
		return this.a(4);
	}

	public void a(boolean var1) {
		this.a(4, var1);
		if (var1) {
			this.setSize(1.9975F, 1.9975F);
			this.a((class_qk) class_wl.d).a(0.30000001192092896D);
			this.a((class_qk) class_wl.e).a(8.0D);
			this.a((class_qk) class_wl.a).a(80.0D);
			this.cl();
			this.bz.b(400);
		}

	}

	private void b(int var1) {
		this.datawatcher.update(TARGET_DW_ID, Integer.valueOf(var1));
	}

	public boolean cE() {
		return this.datawatcher.getInt(TARGET_DW_ID) != 0;
	}

	public EntityLiving cF() {
		if (!this.cE()) {
			return null;
		} else if (this.world.isClientSide) {
			if (this.bw != null) {
				return this.bw;
			} else {
				Entity var1 = this.world.getEntityById(this.datawatcher.getInt(TARGET_DW_ID));
				if (var1 instanceof EntityLiving) {
					this.bw = (EntityLiving) var1;
					return this.bw;
				} else {
					return null;
				}
			}
		} else {
			return this.w();
		}
	}

	public void d(int var1) {
		super.d(var1);
		if (var1 == INFOFLAGS_DW_ID) {
			if (this.cC() && this.width < 1.0F) {
				this.setSize(1.9975F, 1.9975F);
			}
		} else if (var1 == TARGET_DW_ID) {
			this.bx = 0;
			this.bw = null;
		}

	}

	public int y() {
		return 160;
	}

	protected String C() {
		return !this.V() ? "mob.guardian.land.idle" : (this.cC() ? "mob.guardian.elder.idle" : "mob.guardian.idle");
	}

	protected String bp() {
		return !this.V() ? "mob.guardian.land.hit" : (this.cC() ? "mob.guardian.elder.hit" : "mob.guardian.hit");
	}

	protected String bq() {
		return !this.V() ? "mob.guardian.land.death" : (this.cC() ? "mob.guardian.elder.death" : "mob.guardian.death");
	}

	protected boolean s_() {
		return false;
	}

	public float getHeadHeight() {
		return this.length * 0.5F;
	}

	public float a(BlockPosition var1) {
		return this.world.getType(var1).getBlock().getMaterial() == Material.WATER ? 10.0F + this.world.o(var1) - 0.5F : super.a(var1);
	}

	public void m() {
		if (this.world.isClientSide) {
			this.bs = this.c;
			if (!this.V()) {
				this.bt = 2.0F;
				if (this.motY > 0.0D && this.by && !this.isSilent()) {
					this.world.a(this.locX, this.locY, this.locZ, "mob.guardian.flop", 1.0F, 1.0F, false);
				}

				this.by = this.motY < 0.0D && this.world.d((new BlockPosition(this)).down(), false);
			} else if (this.n()) {
				if (this.bt < 0.5F) {
					this.bt = 4.0F;
				} else {
					this.bt += (0.5F - this.bt) * 0.1F;
				}
			} else {
				this.bt += (0.125F - this.bt) * 0.2F;
			}

			this.c += this.bt;
			this.bv = this.bu;
			if (!this.V()) {
				this.bu = this.random.nextFloat();
			} else if (this.n()) {
				this.bu += (0.0F - this.bu) * 0.25F;
			} else {
				this.bu += (1.0F - this.bu) * 0.06F;
			}

			if (this.n() && this.V()) {
				Vec3D var1 = this.d(0.0F);

				for (int var2 = 0; var2 < 2; ++var2) {
					this.world.addParticle(EnumParticle.e, this.locX + (this.random.nextDouble() - 0.5D) * (double) this.width - var1.x * 1.5D, this.locY + this.random.nextDouble() * (double) this.length - var1.y * 1.5D, this.locZ + (this.random.nextDouble() - 0.5D) * (double) this.width - var1.z * 1.5D, 0.0D, 0.0D, 0.0D, new int[0]);
				}
			}

			if (this.cE()) {
				if (this.bx < this.cB()) {
					++this.bx;
				}

				EntityLiving var14 = this.cF();
				if (var14 != null) {
					this.q().a(var14, 90.0F, 90.0F);
					this.q().a();
					double var15 = (double) this.q(0.0F);
					double var4 = var14.locX - this.locX;
					double var6 = var14.locY + (double) (var14.length * 0.5F) - (this.locY + (double) this.getHeadHeight());
					double var8 = var14.locZ - this.locZ;
					double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
					var4 /= var10;
					var6 /= var10;
					var8 /= var10;
					double var12 = this.random.nextDouble();

					while (var12 < var10) {
						var12 += 1.8D - var15 + this.random.nextDouble() * (1.7D - var15);
						this.world.addParticle(EnumParticle.e, this.locX + var4 * var12, this.locY + var6 * var12 + (double) this.getHeadHeight(), this.locZ + var8 * var12, 0.0D, 0.0D, 0.0D, new int[0]);
					}
				}
			}
		}

		if (this.inWater) {
			this.i(300);
		} else if (this.onGround) {
			this.motY += 0.5D;
			this.motX += (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F);
			this.motZ += (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F);
			this.yaw = this.random.nextFloat() * 360.0F;
			this.onGround = false;
			this.ai = true;
		}

		if (this.cE()) {
			this.yaw = this.aN;
		}

		super.m();
	}

	public float q(float var1) {
		return ((float) this.bx + var1) / (float) this.cB();
	}

	protected void cc() {
		super.cc();
		if (this.cC()) {
			boolean var1 = true;
			boolean var2 = true;
			boolean var3 = true;
			boolean var4 = true;
			if ((this.ticksLived + this.getId()) % 1200 == 0) {
				MobEffectType var5 = MobEffectList.SLOWER_DIG;
				List var6 = this.world.getPlayers(EntityPlayer.class, new Predicate() {
					public boolean a(EntityPlayer var1) {
						return EntityGuardian.this.h(var1) < 2500.0D && var1.playerInteractManager.c();
					}

					// $FF: synthetic method
					public boolean apply(Object var1) {
						return this.a((EntityPlayer) var1);
					}
				});
				Iterator var7 = var6.iterator();

				label30: while (true) {
					EntityPlayer var8;
					do {
						if (!var7.hasNext()) {
							break label30;
						}

						var8 = (EntityPlayer) var7.next();
					} while (var8.hasEffect((MobEffectType) var5) && var8.getEffect((MobEffectType) var5).getAmplifier() >= 2 && var8.getEffect((MobEffectType) var5).getDuration() >= 1200);

					var8.playerConnection.sendPacket((Packet) (new PacketPlayOutGameStateChange(10, 0.0F)));
					var8.addEffect(new MobEffect(var5, 6000, 2));
				}
			}

			if (!this.cz()) {
				this.a(new BlockPosition(this), 16);
			}
		}

	}

	protected void b(boolean var1, int var2) {
		int var3 = this.random.nextInt(3) + this.random.nextInt(var2 + 1);
		if (var3 > 0) {
			this.a(new ItemStack(Items.PRISMARINE_SHARD, var3, 0), 1.0F);
		}

		if (this.random.nextInt(3 + var2) > 1) {
			this.a(new ItemStack(Items.FISH, 1, ItemFish.class_a_in_class_aak.a.a()), 1.0F);
		} else if (this.random.nextInt(3 + var2) > 1) {
			this.a(new ItemStack(Items.PRISMARINE_CRYSTALS), 1.0F);
		}

		if (var1 && this.cC()) {
			this.a(new ItemStack(Blocks.SPONGE, 1, 1), 1.0F);
		}

	}

	protected void br() {
		ItemStack var1 = ((class_vf) class_oc.a(this.random, class_ve.j())).a(this.random);
		this.a(var1, 1.0F);
	}

	protected boolean n_() {
		return true;
	}

	public boolean cg() {
		return this.world.a((AxisAlignedBB) this.getBoundingBox(), (Entity) this) && this.world.getCubes((Entity) this, (AxisAlignedBB) this.getBoundingBox()).isEmpty();
	}

	public boolean cf() {
		return (this.random.nextInt(20) == 0 || !this.world.j(new BlockPosition(this))) && super.cf();
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (!this.n() && !var1.isMagic() && var1.i() instanceof EntityLiving) {
			EntityLiving var3 = (EntityLiving) var1.i();
			if (!var1.isExplosion()) {
				var3.damageEntity(DamageSource.a((Entity) this), 2.0F);
				var3.makeSound("damage.thorns", 0.5F, 1.0F);
			}
		}

		this.bz.f();
		return super.damageEntity(var1, var2);
	}

	public int cd() {
		return 180;
	}

	public void g(float var1, float var2) {
		if (this.bN()) {
			if (this.V()) {
				this.a(var1, var2, 0.1F);
				this.d(this.motX, this.motY, this.motZ);
				this.motX *= 0.8999999761581421D;
				this.motY *= 0.8999999761581421D;
				this.motZ *= 0.8999999761581421D;
				if (!this.n() && this.w() == null) {
					this.motY -= 0.005D;
				}
			} else {
				super.g(var1, var2);
			}
		} else {
			super.g(var1, var2);
		}

	}

	static class class_c_in_class_wg extends class_qz {
		private EntityGuardian g;

		public class_c_in_class_wg(EntityGuardian var1) {
			super(var1);
			this.g = var1;
		}

		public void c() {
			if (this.f && !this.g.u().m()) {
				double var1 = this.b - this.g.locX;
				double var3 = this.c - this.g.locY;
				double var5 = this.d - this.g.locZ;
				double var7 = var1 * var1 + var3 * var3 + var5 * var5;
				var7 = (double) MathHelper.sqrt(var7);
				var3 /= var7;
				float var9 = (float) (MathHelper.b(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
				this.g.yaw = this.a(this.g.yaw, var9, 30.0F);
				this.g.aL = this.g.yaw;
				float var10 = (float) (this.e * this.g.a((class_qk) class_wl.d).e());
				this.g.k(this.g.bJ() + (var10 - this.g.bJ()) * 0.125F);
				double var11 = Math.sin((double) (this.g.ticksLived + this.g.getId()) * 0.5D) * 0.05D;
				double var13 = Math.cos((double) (this.g.yaw * 3.1415927F / 180.0F));
				double var15 = Math.sin((double) (this.g.yaw * 3.1415927F / 180.0F));
				this.g.motX += var11 * var13;
				this.g.motZ += var11 * var15;
				var11 = Math.sin((double) (this.g.ticksLived + this.g.getId()) * 0.75D) * 0.05D;
				this.g.motY += var11 * (var15 + var13) * 0.25D;
				this.g.motY += (double) this.g.bJ() * var3 * 0.1D;
				class_qy var17 = this.g.q();
				double var18 = this.g.locX + var1 / var7 * 2.0D;
				double var20 = (double) this.g.getHeadHeight() + this.g.locY + var3 / var7 * 1.0D;
				double var22 = this.g.locZ + var5 / var7 * 2.0D;
				double var24 = var17.e();
				double var26 = var17.f();
				double var28 = var17.g();
				if (!var17.b()) {
					var24 = var18;
					var26 = var20;
					var28 = var22;
				}

				this.g.q().a(var24 + (var18 - var24) * 0.125D, var26 + (var20 - var26) * 0.125D, var28 + (var22 - var28) * 0.125D, 10.0F, 40.0F);
				this.g.m(true);
			} else {
				this.g.k(0.0F);
				this.g.m(false);
			}
		}
	}

	static class class_a_in_class_wg extends class_rm {
		private EntityGuardian a;
		private int b;

		public class_a_in_class_wg(EntityGuardian var1) {
			this.a = var1;
			this.a(3);
		}

		public boolean a() {
			EntityLiving var1 = this.a.w();
			return var1 != null && var1.isAlive();
		}

		public boolean b() {
			return super.b() && (this.a.cC() || this.a.h(this.a.w()) > 9.0D);
		}

		public void c() {
			this.b = -10;
			this.a.u().n();
			this.a.q().a(this.a.w(), 90.0F, 90.0F);
			this.a.ai = true;
		}

		public void d() {
			this.a.b(0);
			this.a.d((EntityLiving) null);
			this.a.bz.f();
		}

		public void e() {
			EntityLiving var1 = this.a.w();
			this.a.u().n();
			this.a.q().a(var1, 90.0F, 90.0F);
			if (!this.a.t(var1)) {
				this.a.d((EntityLiving) null);
			} else {
				++this.b;
				if (this.b == 0) {
					this.a.b(this.a.w().getId());
					this.a.world.a((Entity) this.a, (byte) 21);
				} else if (this.b >= this.a.cB()) {
					float var2 = 1.0F;
					if (this.a.world.ab() == class_om.d) {
						var2 += 2.0F;
					}

					if (this.a.cC()) {
						var2 += 2.0F;
					}

					var1.damageEntity(DamageSource.b(this.a, this.a), var2);
					var1.damageEntity(DamageSource.mobAttack((EntityLiving) this.a), (float) this.a.a((class_qk) class_wl.e).e());
					this.a.d((EntityLiving) null);
				} else if (this.b >= 60 && this.b % 20 == 0) {
					;
				}

				super.e();
			}
		}
	}

	static class class_b_in_class_wg implements Predicate {
		private EntityGuardian a;

		public class_b_in_class_wg(EntityGuardian var1) {
			this.a = var1;
		}

		public boolean a(EntityLiving var1) {
			return (var1 instanceof EntityHuman || var1 instanceof EntitySquid) && var1.h(this.a) > 9.0D;
		}

		// $FF: synthetic method
		public boolean apply(Object var1) {
			return this.a((EntityLiving) var1);
		}
	}
}
