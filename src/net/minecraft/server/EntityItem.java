package net.minecraft.server;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityItem extends Entity {

	private static final Logger b = LogManager.getLogger();
	private static final int ITEM_DW_ID = Datawatcher.claimId(EntityItem.class); //value = 5

	private int d;
	private int pickupDelay;
	private int f;
	private String g;
	private String h;
	public float a;

	public EntityItem(World var1, double var2, double var4, double var6) {
		super(var1);
		this.f = 5;
		this.a = (float) (Math.random() * 3.141592653589793D * 2.0D);
		this.setSize(0.25F, 0.25F);
		this.setPosition(var2, var4, var6);
		this.yaw = (float) (Math.random() * 360.0D);
		this.motX = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
		this.motY = 0.20000000298023224D;
		this.motZ = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
	}

	public EntityItem(World var1, double var2, double var4, double var6, ItemStack var8) {
		this(var1, var2, var4, var6);
		this.a(var8);
	}

	protected boolean s_() {
		return false;
	}

	public EntityItem(World var1) {
		super(var1);
		this.f = 5;
		this.a = (float) (Math.random() * 3.141592653589793D * 2.0D);
		this.setSize(0.25F, 0.25F);
		this.a(new ItemStack(Blocks.AIR, 0));
	}

	protected void initDatawatcher() {
		this.H().addNull(ITEM_DW_ID, 5);
	}

	public void t_() {
		if (this.l() == null) {
			this.die();
		} else {
			super.t_();
			if (this.pickupDelay > 0 && this.pickupDelay != 32767) {
				--this.pickupDelay;
			}

			this.lastX = this.locX;
			this.lastY = this.locY;
			this.lastZ = this.locZ;
			this.motY -= 0.03999999910593033D;
			this.noclip = this.j(this.locX, (this.getBoundingBox().yMin + this.getBoundingBox().yMax) / 2.0D, this.locZ);
			this.d(this.motX, this.motY, this.motZ);
			boolean var1 = (int) this.lastX != (int) this.locX || (int) this.lastY != (int) this.locY || (int) this.lastZ != (int) this.locZ;
			if (var1 || this.ticksLived % 25 == 0) {
				if (this.world.getType(new BlockPosition(this)).getBlock().getMaterial() == Material.LAVA) {
					this.motY = 0.20000000298023224D;
					this.motX = (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
					this.motZ = (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
					this.makeSound("random.fizz", 0.4F, 2.0F + this.random.nextFloat() * 0.4F);
				}

				if (!this.world.isClientSide) {
					this.w();
				}
			}

			float var2 = 0.98F;
			if (this.onGround) {
				var2 = this.world.getType(new BlockPosition(MathHelper.floor(this.locX), MathHelper.floor(this.getBoundingBox().yMin) - 1, MathHelper.floor(this.locZ))).getBlock().frictionFactor * 0.98F;
			}

			this.motX *= (double) var2;
			this.motY *= 0.9800000190734863D;
			this.motZ *= (double) var2;
			if (this.onGround) {
				this.motY *= -0.5D;
			}

			if (this.d != -32768) {
				++this.d;
			}

			this.W();
			if (!this.world.isClientSide && this.d >= 6000) {
				this.die();
			}

		}
	}

	private void w() {
		Iterator var1 = this.world.getEntities(EntityItem.class, this.getBoundingBox().grow(0.5D, 0.0D, 0.5D)).iterator();

		while (var1.hasNext()) {
			EntityItem var2 = (EntityItem) var1.next();
			this.a(var2);
		}

	}

	private boolean a(EntityItem var1) {
		if (var1 == this) {
			return false;
		} else if (var1.isAlive() && this.isAlive()) {
			ItemStack var2 = this.l();
			ItemStack var3 = var1.l();
			if (this.pickupDelay != 32767 && var1.pickupDelay != 32767) {
				if (this.d != -32768 && var1.d != -32768) {
					if (var3.getItem() != var2.getItem()) {
						return false;
					} else if (var3.hasTag() ^ var2.hasTag()) {
						return false;
					} else if (var3.hasTag() && !var3.getTag().equals(var2.getTag())) {
						return false;
					} else if (var3.getItem() == null) {
						return false;
					} else if (var3.getItem().usesData() && var3.i() != var2.i()) {
						return false;
					} else if (var3.count < var2.count) {
						return var1.a(this);
					} else if (var3.count + var2.count > var3.c()) {
						return false;
					} else {
						var3.count += var2.count;
						var1.pickupDelay = Math.max(var1.pickupDelay, this.pickupDelay);
						var1.d = Math.min(var1.d, this.d);
						var1.a(var3);
						this.die();
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void j() {
		this.d = 4800;
	}

	public boolean W() {
		if (this.world.a((AxisAlignedBB) this.getBoundingBox(), (Material) Material.WATER, (Entity) this)) {
			if (!this.inWater && !this.justCreated) {
				this.X();
			}

			this.inWater = true;
		} else {
			this.inWater = false;
		}

		return this.inWater;
	}

	protected void g(int var1) {
		this.damageEntity(DamageSource.FIRE, (float) var1);
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b((DamageSource) var1)) {
			return false;
		} else if (this.l() != null && this.l().getItem() == Items.NETHER_STAR && var1.isExplosion()) {
			return false;
		} else {
			this.ac();
			this.f = (int) ((float) this.f - var2);
			if (this.f <= 0) {
				this.die();
			}

			return false;
		}
	}

	public void write(NBTTagCompound var1) {
		var1.put("Health", (short) ((byte) this.f));
		var1.put("Age", (short) this.d);
		var1.put("PickupDelay", (short) this.pickupDelay);
		if (this.n() != null) {
			var1.put("Thrower", this.g);
		}

		if (this.m() != null) {
			var1.put("Owner", this.h);
		}

		if (this.l() != null) {
			var1.put((String) "Item", (NBTTag) this.l().write(new NBTTagCompound()));
		}

	}

	public void read(NBTTagCompound var1) {
		this.f = var1.getShort("Health") & 255;
		this.d = var1.getShort("Age");
		if (var1.has("PickupDelay")) {
			this.pickupDelay = var1.getShort("PickupDelay");
		}

		if (var1.has("Owner")) {
			this.h = var1.getString("Owner");
		}

		if (var1.has("Thrower")) {
			this.g = var1.getString("Thrower");
		}

		NBTTagCompound var2 = var1.getCompound("Item");
		this.a(ItemStack.a(var2));
		if (this.l() == null) {
			this.die();
		}

	}

	public void d(EntityHuman var1) {
		if (!this.world.isClientSide) {
			ItemStack var2 = this.l();
			int var3 = var2.count;
			if (this.pickupDelay == 0 && (this.h == null || 6000 - this.d <= 200 || this.h.equals(var1.getName())) && var1.inventory.pickup(var2)) {
				if (var2.getItem() == Item.getItemOf(Blocks.LOG)) {
					var1.b((class_my) class_mt.g);
				}

				if (var2.getItem() == Item.getItemOf(Blocks.LOG2)) {
					var1.b((class_my) class_mt.g);
				}

				if (var2.getItem() == Items.LEATHER) {
					var1.b((class_my) class_mt.t);
				}

				if (var2.getItem() == Items.DIAMOND) {
					var1.b((class_my) class_mt.w);
				}

				if (var2.getItem() == Items.BLAZE_ROD) {
					var1.b((class_my) class_mt.A);
				}

				if (var2.getItem() == Items.DIAMOND && this.n() != null) {
					EntityHuman var4 = this.world.a(this.n());
					if (var4 != null && var4 != var1) {
						var4.b((class_my) class_mt.x);
					}
				}

				if (!this.isSilent()) {
					this.world.a((Entity) var1, "random.pop", 0.2F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				}

				var1.receive(this, var3);
				if (var2.count <= 0) {
					this.die();
				}
			}

		}
	}

	public String getName() {
		return this.hasCustomName() ? this.getCustomName() : LocaleI18n.get("item." + this.l().a());
	}

	public boolean aF() {
		return false;
	}

	public void c(int var1) {
		super.c(var1);
		if (!this.world.isClientSide) {
			this.w();
		}

	}

	public ItemStack l() {
		ItemStack var1 = this.H().getItemStack(ITEM_DW_ID);
		if (var1 == null) {
			if (this.world != null) {
				b.error("Item entity " + this.getId() + " has no item?!");
			}

			return new ItemStack(Blocks.STONE);
		} else {
			return var1;
		}
	}

	public void a(ItemStack var1) {
		this.H().update(ITEM_DW_ID, var1);
		this.H().i(ITEM_DW_ID);
	}

	public String m() {
		return this.h;
	}

	public void b(String var1) {
		this.h = var1;
	}

	public String n() {
		return this.g;
	}

	public void c(String var1) {
		this.g = var1;
	}

	public void setPickupDelay() {
		this.pickupDelay = 10;
	}

	public void removePickupDelay() {
		this.pickupDelay = 0;
	}

	public void setUnpickable() {
		this.pickupDelay = 32767;
	}

	public void setPickupDelay(int pickupDelay) {
		this.pickupDelay = pickupDelay;
	}

	public boolean isNotPickable() {
		return this.pickupDelay > 0;
	}

	public void u() {
		this.d = -6000;
	}

	public void v() {
		this.setUnpickable();
		this.d = 5999;
	}

}
