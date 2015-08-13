package net.minecraft.server;

public class EntityItemFrame extends class_uz {

	private static final int ITEM_DW_ID = DataWatcher.claimId(EntityItemFrame.class); //value = 5
	private static final int ROTATION_DW_ID = DataWatcher.claimId(EntityItemFrame.class); //value = 6
	private float e = 1.0F;

	public EntityItemFrame(World var1) {
		super(var1);
	}

	public EntityItemFrame(World var1, BlockPosition var2, EnumDirection var3) {
		super(var1, var2);
		this.a((EnumDirection) var3);
	}

	protected void initDatawatcher() {
		this.H().addNull(ITEM_DW_ID, 5);
		this.H().add(ROTATION_DW_ID, Byte.valueOf((byte) 0));
	}

	public float ao() {
		return 0.0F;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b((DamageSource) var1)) {
			return false;
		} else if (!var1.isExplosion() && this.o() != null) {
			if (!this.world.isClientSide) {
				this.a(var1.getEntity(), false);
				this.a((ItemStack) null);
			}

			return true;
		} else {
			return super.damageEntity(var1, var2);
		}
	}

	public int l() {
		return 12;
	}

	public int m() {
		return 12;
	}

	public void b(Entity var1) {
		this.a(var1, true);
	}

	public void a(Entity var1, boolean var2) {
		if (this.world.R().getBooleanValue("doEntityDrops")) {
			ItemStack var3 = this.o();
			if (var1 instanceof EntityHuman) {
				EntityHuman var4 = (EntityHuman) var1;
				if (var4.abilities.instabuild) {
					this.b(var3);
					return;
				}
			}

			if (var2) {
				this.a(new ItemStack(Items.ITEM_FRAME), 0.0F);
			}

			if (var3 != null && this.random.nextFloat() < this.e) {
				var3 = var3.clone();
				this.b(var3);
				this.a(var3, 0.0F);
			}

		}
	}

	private void b(ItemStack var1) {
		if (var1 != null) {
			if (var1.getItem() == Items.FILLED_MAP) {
				class_avf var2 = ((ItemWorldMap) var1.getItem()).a(var1, this.world);
				var2.h.remove("frame-" + this.getId());
			}

			var1.setItemFrame((EntityItemFrame) null);
		}
	}

	public ItemStack o() {
		return this.H().getItemStack(ITEM_DW_ID);
	}

	public void a(ItemStack var1) {
		this.a(var1, true);
	}

	private void a(ItemStack var1, boolean var2) {
		if (var1 != null) {
			var1 = var1.clone();
			var1.count = 1;
			var1.setItemFrame(this);
		}

		this.H().update(ITEM_DW_ID, var1);
		this.H().i(ITEM_DW_ID);
		if (var2 && this.a != null) {
			this.world.updateAdjacentComparators(this.a, Blocks.AIR);
		}

	}

	public int p() {
		return this.H().getByte(ROTATION_DW_ID);
	}

	public void a(int var1) {
		this.a(var1, true);
	}

	private void a(int var1, boolean var2) {
		this.H().update(ROTATION_DW_ID, Byte.valueOf((byte) (var1 % 8)));
		if (var2 && this.a != null) {
			this.world.updateAdjacentComparators(this.a, Blocks.AIR);
		}

	}

	public void write(NBTTagCompound var1) {
		if (this.o() != null) {
			var1.put((String) "Item", (NBTTag) this.o().write(new NBTTagCompound()));
			var1.put("ItemRotation", (byte) this.p());
			var1.put("ItemDropChance", this.e);
		}

		super.write(var1);
	}

	public void read(NBTTagCompound var1) {
		NBTTagCompound var2 = var1.getCompound("Item");
		if (var2 != null && !var2.isEmpty()) {
			this.a(ItemStack.a(var2), false);
			this.a(var1.getByte("ItemRotation"), false);
			if (var1.hasOfType("ItemDropChance", 99)) {
				this.e = var1.getFloat("ItemDropChance");
			}

			if (var1.has("Direction")) {
				this.a(this.p() * 2, false);
			}
		}

		super.read(var1);
	}

	public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
		if (this.o() == null) {
			if (var2 != null && !this.world.isClientSide) {
				this.a(var2);
				if (!var1.abilities.instabuild) {
					--var2.count;
				}
			}
		} else if (!this.world.isClientSide) {
			this.a(this.p() + 1);
		}

		return true;
	}

	public int q() {
		return this.o() == null ? 0 : this.p() % 8 + 1;
	}
}
