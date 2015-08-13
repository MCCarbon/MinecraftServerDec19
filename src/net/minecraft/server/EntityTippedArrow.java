package net.minecraft.server;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class EntityTippedArrow extends EntityArrow {

	private static final int POTIONTYPE_DW_ID = DataWatcher.claimId(EntityTippedArrow.class); // value = 6

	private final Set<MobEffect> effects;
	private ItemStack item;

	public EntityTippedArrow(World world) {
		super(world);
		this.effects = Sets.newHashSet();
	}

	public EntityTippedArrow(World world, double x, double y, double z) {
		super(world, x, y, z);
		this.effects = Sets.newHashSet();
	}

	public EntityTippedArrow(World world, double x, double y, double z, ItemStack itemstack) {
		this(world, x, y, z);
		this.setItem(itemstack);
	}

	public EntityTippedArrow(World world, EntityLiving entity, ItemStack itemstack) {
		super(world, entity);
		this.effects = Sets.newHashSet();
		this.setItem(itemstack);
	}

	private void setItem(ItemStack itemstack) {
		List<MobEffect> effectlist = ItemPotion.h(itemstack);
		if (!effectlist.isEmpty()) {
			for (MobEffect effect : effectlist) {
				this.effects.add(new MobEffect(effect));
			}

			this.datawatcher.update(POTIONTYPE_DW_ID, Integer.valueOf(ItemPotion.a(this.effects)));
		}

		this.item = itemstack.clone();
		this.item.count = 1;
	}

	@Override
	protected void initDatawatcher() {
		super.initDatawatcher();
		this.datawatcher.add(POTIONTYPE_DW_ID, Integer.valueOf(0));
	}

	@Override
	public void t_() {
		super.t_();
		int var1;
		double var2;
		double var4;
		double var6;
		if (this.inGround) {
			if (this.world.isClientSide) {
				var1 = this.datawatcher.getInt(POTIONTYPE_DW_ID);
				if ((var1 > 0) && ((this.ticksInGround % 5) == 0)) {
					var2 = ((var1 >> 16) & 255) / 255.0D;
					var4 = ((var1 >> 8) & 255) / 255.0D;
					var6 = ((var1 >> 0) & 255) / 255.0D;
					this.world.addParticle(EnumParticle.MOB_SPELL, this.locX + ((this.random.nextDouble() - 0.5D) * this.width), this.locY + (this.random.nextDouble() * this.length), this.locZ + ((this.random.nextDouble() - 0.5D) * this.width), var2, var4, var6, new int[0]);
				}
			} else if (!this.effects.isEmpty() && (this.ticksInGround >= 200)) {
				this.world.a(this, (byte) 0);
				this.effects.clear();
				this.datawatcher.update(POTIONTYPE_DW_ID, Integer.valueOf(0));
			}
		} else if (this.world.isClientSide) {
			var1 = this.datawatcher.getInt(POTIONTYPE_DW_ID);
			if (var1 > 0) {
				var2 = ((var1 >> 16) & 255) / 255.0D;
				var4 = ((var1 >> 8) & 255) / 255.0D;
				var6 = ((var1 >> 0) & 255) / 255.0D;

				for (int var8 = 0; var8 < 2; ++var8) {
					this.world.addParticle(EnumParticle.MOB_SPELL, this.locX + ((this.random.nextDouble() - 0.5D) * this.width), this.locY + (this.random.nextDouble() * this.length), this.locZ + ((this.random.nextDouble() - 0.5D) * this.width), var2, var4, var6, new int[0]);
				}
			}
		}
	}

	@Override
	public void write(NBTTagCompound compound) {
		super.write(compound);
		if (this.item != null) {
			compound.put("Item", this.item.write(new NBTTagCompound()));
		}
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		if (compound.hasOfType("Item", 10)) {
			this.item = ItemStack.a(compound.getCompound("Item"));
		}
	}

	@Override
	protected void onEntityHit(EntityLiving entity) {
		super.onEntityHit(entity);
		if (!this.effects.isEmpty()) {
			for (MobEffect effect : effects) {
				entity.addEffect(effect);
			}
		}
	}

	@Override
	protected ItemStack getItemStack() {
		return this.effects.isEmpty() ? new ItemStack(Items.ARROW) : this.item;
	}

}
