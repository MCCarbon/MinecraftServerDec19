package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.ItemStack;
import net.minecraft.server.IInventory;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_uy;
import net.minecraft.server.EntityHuman;

public final class IEntitySelector {
	public static final Predicate<Entity> IS_ALIVE = new Predicate<Entity>() {
		public boolean apply(Entity var1) {
			return var1.isAlive();
		}
	};
	public static final Predicate<Entity> IS_ALIVE_AND_NOT_MOUNTED = new Predicate<Entity>() {
		public boolean apply(Entity var1) {
			return var1.isAlive() && var1.passenger == null && var1.vehicle == null;
		}
	};
	public static final Predicate<Entity> IS_ALIVE_AND_HAS_INVENTORY = new Predicate<Entity>() {
		public boolean apply(Entity var1) {
			return var1 instanceof IInventory && var1.isAlive();
		}
	};
	public static final Predicate<Entity> NOT_PLAYER_SPECTATOR = new Predicate<Entity>() {
		public boolean apply(Entity entity) {
			return !(entity instanceof EntityHuman) || !((EntityHuman) entity).isSpectator();
		}
	};

	public static Predicate<Entity> a(final double var0, final double var2, final double var4, double var6) {
		final double var8 = var6 * var6;
		return new Predicate<Entity>() {
			public boolean apply(Entity var1) {
				return var1 != null && var1.e(var0, var2, var4) <= var8;
			}
		};
	}

	public static class class_a_in_class_pv implements Predicate<Entity> {
		private final ItemStack a;

		public class_a_in_class_pv(ItemStack var1) {
			this.a = var1;
		}

		public boolean apply(Entity var1) {
			if (!var1.isAlive()) {
				return false;
			} else if (!(var1 instanceof EntityLiving)) {
				return false;
			} else {
				EntityLiving var2 = (EntityLiving) var1;
				return var2.a(class_qb.c(this.a)) != null ? false : (var2 instanceof class_qb ? ((class_qb) var2).cm() : (var2 instanceof class_uy ? true : var2 instanceof EntityHuman));
			}
		}
	}

}
