package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.Datawathcer;
import net.minecraft.server.EntityHuman;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityItem extends Entity {
	private static final Logger b = LogManager.getLogger();
	private static final int c = Datawathcer.claimId(EntityItem.class);
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
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		this.y = (float) (Math.random() * 360.0D);
		this.v = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
		this.motY = 0.20000000298023224D;
		this.x = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
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
		this.a(0.25F, 0.25F);
		this.a(new ItemStack(Blocks.AIR, 0));
	}

	protected void h() {
		this.H().addNull(c, 5);
	}

	public void t_() {
		if (this.l() == null) {
			this.J();
		} else {
			super.t_();
			if (this.pickupDelay > 0 && this.pickupDelay != 32767) {
				--this.pickupDelay;
			}

			this.p = this.s;
			this.q = this.t;
			this.r = this.u;
			this.motY -= 0.03999999910593033D;
			this.T = this.j(this.s, (this.aT().yMin + this.aT().yMax) / 2.0D, this.u);
			this.d(this.v, this.motY, this.x);
			boolean var1 = (int) this.p != (int) this.s || (int) this.q != (int) this.t || (int) this.r != (int) this.u;
			if (var1 || this.W % 25 == 0) {
				if (this.o.getType(new BlockPosition(this)).getBlock().getMaterial() == Material.LAVA) {
					this.motY = 0.20000000298023224D;
					this.v = (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
					this.x = (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
					this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
				}

				if (!this.o.isClientSide) {
					this.w();
				}
			}

			float var2 = 0.98F;
			if (this.C) {
				var2 = this.o.getType(new BlockPosition(MathHelper.floor(this.s), MathHelper.floor(this.aT().yMin) - 1, MathHelper.floor(this.u))).getBlock().frictionFactor * 0.98F;
			}

			this.v *= (double) var2;
			this.motY *= 0.9800000190734863D;
			this.x *= (double) var2;
			if (this.C) {
				this.motY *= -0.5D;
			}

			if (this.d != -32768) {
				++this.d;
			}

			this.W();
			if (!this.o.isClientSide && this.d >= 6000) {
				this.J();
			}

		}
	}

	private void w() {
		Iterator var1 = this.o.getEntities(EntityItem.class, this.aT().grow(0.5D, 0.0D, 0.5D)).iterator();

		while (var1.hasNext()) {
			EntityItem var2 = (EntityItem) var1.next();
			this.a(var2);
		}

	}

	private boolean a(EntityItem var1) {
		if (var1 == this) {
			return false;
		} else if (var1.ai() && this.ai()) {
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
					} else if (var3.getItem().k() && var3.i() != var2.i()) {
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
						this.J();
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
		if (this.o.a((AxisAlignedBB) this.aT(), (Material) Material.WATER, (Entity) this)) {
			if (!this.Y && !this.aa) {
				this.X();
			}

			this.Y = true;
		} else {
			this.Y = false;
		}

		return this.Y;
	}

	protected void g(int var1) {
		this.a(class_pc.a, (float) var1);
	}

	public boolean a(class_pc var1, float var2) {
		if (this.b((class_pc) var1)) {
			return false;
		} else if (this.l() != null && this.l().getItem() == Items.cc && var1.c()) {
			return false;
		} else {
			this.ac();
			this.f = (int) ((float) this.f - var2);
			if (this.f <= 0) {
				this.J();
			}

			return false;
		}
	}

	public void b(NBTTagCompound var1) {
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

	public void a(NBTTagCompound var1) {
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
			this.J();
		}

	}

	public void d(EntityHuman var1) {
		if (!this.o.isClientSide) {
			ItemStack var2 = this.l();
			int var3 = var2.count;
			if (this.pickupDelay == 0 && (this.h == null || 6000 - this.d <= 200 || this.h.equals(var1.getName())) && var1.bp.a(var2)) {
				if (var2.getItem() == Item.getItemOf(Blocks.LOG)) {
					var1.b((class_my) class_mt.g);
				}

				if (var2.getItem() == Item.getItemOf(Blocks.LOG2)) {
					var1.b((class_my) class_mt.g);
				}

				if (var2.getItem() == Items.aH) {
					var1.b((class_my) class_mt.t);
				}

				if (var2.getItem() == Items.k) {
					var1.b((class_my) class_mt.w);
				}

				if (var2.getItem() == Items.bx) {
					var1.b((class_my) class_mt.A);
				}

				if (var2.getItem() == Items.k && this.n() != null) {
					EntityHuman var4 = this.o.a(this.n());
					if (var4 != null && var4 != var1) {
						var4.b((class_my) class_mt.x);
					}
				}

				if (!this.R()) {
					this.o.a((Entity) var1, "random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				}

				var1.a(this, var3);
				if (var2.count <= 0) {
					this.J();
				}
			}

		}
	}

	public String getName() {
		return this.hasCustomName() ? this.aO() : LocaleI18n.get("item." + this.l().a());
	}

	public boolean aF() {
		return false;
	}

	public void c(int var1) {
		super.c(var1);
		if (!this.o.isClientSide) {
			this.w();
		}

	}

	public ItemStack l() {
		ItemStack var1 = this.H().getItemStack(c);
		if (var1 == null) {
			if (this.o != null) {
				b.error("Item entity " + this.getId() + " has no item?!");
			}

			return new ItemStack(Blocks.STONE);
		} else {
			return var1;
		}
	}

	public void a(ItemStack var1) {
		this.H().b(c, var1);
		this.H().i(c);
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
