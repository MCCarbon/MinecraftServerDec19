package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class EntityEnderman extends EntityMonster {

	private static final UUID a = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final class_qm b;
	private static final Set<Block> c;
	private static final IBlockData bs;
	private static final int CARRIEDID_DW_ID = DataWatcher.claimId(EntityEnderman.class); //value = 11
	private static final int CARRIEDDATA_DW_ID = DataWatcher.claimId(EntityEnderman.class); //value = 12
	private static final int SCREAMING_DW_ID = DataWatcher.claimId(EntityEnderman.class); //value = 13

	private boolean bw;

	public EntityEnderman(World var1) {
		super(var1);
		this.setSize(0.6F, 2.9F);
		this.S = 1.0F;
		this.i.a(0, new class_rj(this));
		this.i.a(2, new class_ru(this, 1.0D, false));
		this.i.a(7, new class_si(this, 1.0D));
		this.i.a(8, new class_rr(this, EntityHuman.class, 8.0F));
		this.i.a(8, new class_sh(this));
		this.i.a(10, new EntityEnderman.class_a_in_class_wb(this));
		this.i.a(11, new EntityEnderman.class_c_in_class_wb(this));
		this.bn.a(1, new class_sw(this, false, new Class[0]));
		this.bn.a(2, new EntityEnderman.class_b_in_class_wb(this));
		this.bn.a(3, new class_sz(this, EntityEndermite.class, 10, true, false, new Predicate<EntityEndermite>() {
			public boolean apply(EntityEndermite var1) {
				return var1.n();
			}
		}));
	}

	private boolean cH() {
		return this.cB() != bs;
	}

	protected void aY() {
		super.aY();
		this.a((class_qk) class_wl.a).a(40.0D);
		this.a((class_qk) class_wl.d).a(0.30000001192092896D);
		this.a((class_qk) class_wl.e).a(7.0D);
		this.a((class_qk) class_wl.b).a(64.0D);
	}

	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(CARRIEDID_DW_ID, new Short((short) 0));
		this.datawatcher.add(CARRIEDDATA_DW_ID, new Byte((byte) 0));
		this.datawatcher.add(SCREAMING_DW_ID, new Byte((byte) 0));
	}

	public void write(NBTTagCompound var1) {
		super.write(var1);
		IBlockData var2 = this.cB();
		var1.put("carried", (short) Block.getId(var2.getBlock()));
		var1.put("carriedData", (short) var2.getBlock().toLegacyData(var2));
	}

	public void read(NBTTagCompound var1) {
		super.read(var1);
		IBlockData var2;
		if (var1.hasOfType("carried", 8)) {
			var2 = Block.getByName(var1.getString("carried")).fromLegacyData(var1.getShort("carriedData") & '\uffff');
		} else {
			var2 = Block.getById(var1.getShort("carried")).fromLegacyData(var1.getShort("carriedData") & '\uffff');
		}

		this.a(var2);
	}

	private boolean a(EntityHuman var1) {
		ItemStack var2 = var1.inventory.b[3];
		if (var2 != null && var2.getItem() == Item.getItemOf(Blocks.PUMPKIN)) {
			return false;
		} else {
			Vec3D var3 = var1.d(1.0F).normalize();
			Vec3D var4 = new Vec3D(this.locX - var1.locX, this.getBoundingBox().yMin + (double) (this.length / 2.0F) - (var1.locY + (double) var1.getHeadHeight()), this.locZ - var1.locZ);
			double var5 = var4.length();
			var4 = var4.normalize();
			double var7 = var3.dotProduct(var4);
			return var7 > 1.0D - 0.025D / var5 ? var1.t(this) : false;
		}
	}

	public float getHeadHeight() {
		return 2.55F;
	}

	public void m() {
		if (this.world.isClientSide) {
			for (int var1 = 0; var1 < 2; ++var1) {
				this.world.addParticle(EnumParticle.PORTAL, this.locX + (this.random.nextDouble() - 0.5D) * (double) this.width, this.locY + this.random.nextDouble() * (double) this.length - 0.25D, this.locZ + (this.random.nextDouble() - 0.5D) * (double) this.width, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		}

		this.bb = false;
		super.m();
	}

	protected void cc() {
		if (this.U()) {
			this.damageEntity(DamageSource.DROWN, 1.0F);
		}

		if (this.cD() && !this.bw && this.random.nextInt(100) == 0) {
			this.a(false);
		}

		if (this.world.x()) {
			float var1 = this.c(1.0F);
			if (var1 > 0.5F && this.world.i(new BlockPosition(this)) && this.random.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
				this.d((EntityLiving) null);
				this.a(false);
				this.bw = false;
				this.n();
			}
		}

		super.cc();
	}

	protected boolean n() {
		double var1 = this.locX + (this.random.nextDouble() - 0.5D) * 64.0D;
		double var3 = this.locY + (double) (this.random.nextInt(64) - 32);
		double var5 = this.locZ + (this.random.nextDouble() - 0.5D) * 64.0D;
		return attemptTeleportTo(this, var1, var3, var5);
	}

	protected boolean b(Entity var1) {
		Vec3D var2 = new Vec3D(this.locX - var1.locX, this.getBoundingBox().yMin + (double) (this.length / 2.0F) - var1.locY + (double) var1.getHeadHeight(), this.locZ - var1.locZ);
		var2 = var2.normalize();
		double var3 = 16.0D;
		double var5 = this.locX + (this.random.nextDouble() - 0.5D) * 8.0D - var2.x * var3;
		double var7 = this.locY + (double) (this.random.nextInt(16) - 8) - var2.y * var3;
		double var9 = this.locZ + (this.random.nextDouble() - 0.5D) * 8.0D - var2.z * var3;
		return attemptTeleportTo(this, var5, var7, var9);
	}

	public static boolean attemptTeleportTo(EntityLiving entity, double x, double y, double z) {
		double prevX = entity.locX;
		double prevY = entity.locY;
		double prevZ = entity.locZ;
		entity.locX = x;
		entity.locY = y;
		entity.locZ = z;
		boolean canteleport = false;
		BlockPosition position = new BlockPosition(entity);
		World world = entity.world;
		Random rnd = entity.getRandom();
		if (world.isLoaded(position)) {
			boolean found = false;

			while (!found && position.getY() > 0) {
				BlockPosition posbelow = position.down();
				Block block = world.getType(posbelow).getBlock();
				if (block.getMaterial().isSolid()) {
					found = true;
				} else {
					--entity.locY;
					position = posbelow;
				}
			}

			if (found) {
				entity.enderTeleportTo(entity.locX, entity.locY, entity.locZ);
				if (world.getCubes(entity, entity.getBoundingBox()).isEmpty() && !world.containsLiquid(entity.getBoundingBox())) {
					canteleport = true;
				}
			}
		}

		if (!canteleport) {
			entity.enderTeleportTo(prevX, prevY, prevZ);
			return false;
		} else {
			short var30 = 128;

			for (int var31 = 0; var31 < var30; ++var31) {
				double var32 = (double) var31 / ((double) var30 - 1.0D);
				float rndSpreadX = (rnd.nextFloat() - 0.5F) * 0.2F;
				float rndSpreadY = (rnd.nextFloat() - 0.5F) * 0.2F;
				float rndSpreadZ = (rnd.nextFloat() - 0.5F) * 0.2F;
				double pX = prevX + (entity.locX - prevX) * var32 + (rnd.nextDouble() - 0.5D) * (double) entity.width * 2.0D;
				double pY = prevY + (entity.locY - prevY) * var32 + rnd.nextDouble() * (double) entity.length;
				double pZ = prevZ + (entity.locZ - prevZ) * var32 + (rnd.nextDouble() - 0.5D) * (double) entity.width * 2.0D;
				world.addParticle(EnumParticle.PORTAL, pX, pY, pZ, rndSpreadX, rndSpreadY, rndSpreadZ);
			}

			world.makeSound(prevX, prevY, prevZ, "mob.endermen.portal", 1.0F, 1.0F);
			entity.makeSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	protected String C() {
		return this.cD() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	protected String bp() {
		return "mob.endermen.hit";
	}

	protected String bq() {
		return "mob.endermen.death";
	}

	protected Item D() {
		return Items.ENDER_PEARL;
	}

	protected void b(boolean var1, int var2) {
		Item var3 = this.D();
		if (var3 != null) {
			int var4 = this.random.nextInt(2 + var2);

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

		IBlockData var6 = this.cB();
		if (var6 != bs) {
			this.a(new ItemStack(var6.getBlock(), 1, var6.getBlock().toLegacyData(var6)), 0.0F);
		}

	}

	public void a(IBlockData var1) {
		this.datawatcher.update(CARRIEDID_DW_ID, Short.valueOf((short) (Block.getCombinedId(var1) & '\uffff')));
	}

	public IBlockData cB() {
		return Block.getByCombinedId(this.datawatcher.getShort(CARRIEDID_DW_ID) & '\uffff');
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b((DamageSource) var1)) {
			return false;
		} else {
			if (var1.getEntity() == null || !(var1.getEntity() instanceof EntityEndermite)) {
				if (!this.world.isClientSide) {
					this.a(true);
				}

				if (var1 instanceof EntityDamageSource && var1.getEntity() instanceof EntityHuman) {
					if (var1.getEntity() instanceof EntityPlayer && ((EntityPlayer) var1.getEntity()).playerInteractManager.d()) {
						this.a(false);
					} else {
						this.bw = true;
					}
				}

				if (var1 instanceof EntityDamageSourceIndirect) {
					this.bw = false;

					for (int var4 = 0; var4 < 64; ++var4) {
						if (this.n()) {
							return true;
						}
					}

					return false;
				}
			}

			boolean var3 = super.damageEntity(var1, var2);
			if (var1.ignoresArmor() && this.random.nextInt(10) != 0) {
				this.n();
			}

			return var3;
		}
	}

	public boolean cD() {
		return this.datawatcher.getByte(SCREAMING_DW_ID) > 0;
	}

	public void a(boolean var1) {
		this.datawatcher.update(SCREAMING_DW_ID, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	static {
		b = (new class_qm(a, "Attacking speed boost", 0.15000000596046448D, 0)).a(false);
		c = Sets.newIdentityHashSet();
		bs = Blocks.AIR.getBlockData();
		c.add(Blocks.GRASS);
		c.add(Blocks.DIRT);
		c.add(Blocks.SAND);
		c.add(Blocks.GRAVEL);
		c.add(Blocks.YELLOW_FLOWER);
		c.add(Blocks.RED_FLOWER);
		c.add(Blocks.BROWN_MUSHROOM);
		c.add(Blocks.RED_MUSHROOM);
		c.add(Blocks.TNT);
		c.add(Blocks.CACTUS);
		c.add(Blocks.CLAY);
		c.add(Blocks.PUMPKIN);
		c.add(Blocks.MELON_BLOCK);
		c.add(Blocks.MYCELIM);
	}

	static class class_c_in_class_wb extends class_rm {
		private EntityEnderman a;

		public class_c_in_class_wb(EntityEnderman var1) {
			this.a = var1;
		}

		public boolean a() {
			return this.a.cH() ? false : (!this.a.world.R().getBooleanValue("mobGriefing") ? false : this.a.getRandom().nextInt(20) == 0);
		}

		public void e() {
			Random var1 = this.a.getRandom();
			World var2 = this.a.world;
			int var3 = MathHelper.floor(this.a.locX - 2.0D + var1.nextDouble() * 4.0D);
			int var4 = MathHelper.floor(this.a.locY + var1.nextDouble() * 3.0D);
			int var5 = MathHelper.floor(this.a.locZ - 2.0D + var1.nextDouble() * 4.0D);
			BlockPosition var6 = new BlockPosition(var3, var4, var5);
			IBlockData var7 = var2.getType(var6);
			Block var8 = var7.getBlock();
			if (EntityEnderman.c.contains(var8)) {
				this.a.a(var7);
				var2.setTypeUpdate(var6, EntityEnderman.bs);
			}

		}
	}

	static class class_a_in_class_wb extends class_rm {
		private EntityEnderman a;

		public class_a_in_class_wb(EntityEnderman var1) {
			this.a = var1;
		}

		public boolean a() {
			return !this.a.cH() ? false : (!this.a.world.R().getBooleanValue("mobGriefing") ? false : this.a.getRandom().nextInt(2000) == 0);
		}

		public void e() {
			Random var1 = this.a.getRandom();
			World var2 = this.a.world;
			int var3 = MathHelper.floor(this.a.locX - 1.0D + var1.nextDouble() * 2.0D);
			int var4 = MathHelper.floor(this.a.locY + var1.nextDouble() * 2.0D);
			int var5 = MathHelper.floor(this.a.locZ - 1.0D + var1.nextDouble() * 2.0D);
			BlockPosition var6 = new BlockPosition(var3, var4, var5);
			Block var7 = var2.getType(var6).getBlock();
			Block var8 = var2.getType(var6.down()).getBlock();
			if (this.a(var2, var6, this.a.cB().getBlock(), var7, var8)) {
				var2.setTypeAndData((BlockPosition) var6, (IBlockData) this.a.cB(), 3);
				this.a.a(EntityEnderman.bs);
			}

		}

		private boolean a(World var1, BlockPosition var2, Block var3, Block var4, Block var5) {
			return !var3.canPlace(var1, var2) ? false : (var4.getMaterial() != Material.AIR ? false : (var5.getMaterial() == Material.AIR ? false : var5.isFullCube()));
		}
	}

	static class class_b_in_class_wb extends class_sz {
		private EntityHuman g;
		private int h;
		private int i;
		private EntityEnderman j;

		public class_b_in_class_wb(EntityEnderman var1) {
			super(var1, EntityHuman.class, true);
			this.j = var1;
		}

		public boolean a() {
			double var1 = this.f();
			List<?> var3 = this.e.world.getEntities(EntityHuman.class, this.e.getBoundingBox().grow(var1, 4.0D, var1), this.c);
			Collections.sort(var3, this.b);
			if (var3.isEmpty()) {
				return false;
			} else {
				this.g = (EntityHuman) var3.get(0);
				return true;
			}
		}

		public void c() {
			this.h = 5;
			this.i = 0;
		}

		public void d() {
			this.g = null;
			this.j.a(false);
			class_ql var1 = this.j.a((class_qk) class_wl.d);
			var1.c(EntityEnderman.b);
			super.d();
		}

		public boolean b() {
			if (this.g != null) {
				if (!this.j.a(this.g)) {
					return false;
				} else {
					this.j.bw = true;
					this.j.a(this.g, 10.0F, 10.0F);
					return true;
				}
			} else {
				return super.b();
			}
		}

		public void e() {
			if (this.g != null) {
				if (--this.h <= 0) {
					this.d = this.g;
					this.g = null;
					super.c();
					this.j.makeSound("mob.endermen.stare", 1.0F, 1.0F);
					this.j.a(true);
					class_ql var1 = this.j.a((class_qk) class_wl.d);
					var1.b(EntityEnderman.b);
				}
			} else {
				if (this.d != null) {
					if (this.d instanceof EntityHuman && this.j.a((EntityHuman) this.d)) {
						if (this.d.h(this.j) < 16.0D) {
							this.j.n();
						}

						this.i = 0;
					} else if (this.d.h(this.j) > 256.0D && this.i++ >= 30 && this.j.b((Entity) this.d)) {
						this.i = 0;
					}
				}

				super.e();
			}

		}
	}
}
