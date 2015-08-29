package net.minecraft.server;


public class EntityMushroomCow extends EntityCow {
	public EntityMushroomCow(class_ago var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		bw = Blocks.MYCELIUM;
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == Items.B) && (this.k() >= 0) && !var1.bI.d) {
			if (--var3.b == 0) {
				var1.a(var2, (new class_aco(Items.C)));
			} else if (!var1.bq.a(new class_aco(Items.C))) {
				var1.a(new class_aco(Items.C), false);
			}

			return true;
		} else if ((var3 != null) && (var3.b() == Items.bg) && (this.k() >= 0)) {
			L();
			o.a(class_cy.b, s, t + K / 2.0F, u, 0.0D, 0.0D, 0.0D, new int[0]);
			if (!o.D) {
				EntityCow var4 = new EntityCow(o);
				var4.b(s, t, u, y, z);
				var4.c(bu());
				var4.aM = aM;
				if (k_()) {
					var4.c(aS());
				}

				o.a(var4);

				for (int var5 = 0; var5 < 5; ++var5) {
					o.a((new EntityItem(o, s, t + K, u, new class_aco(Blocks.RED_MUSHROOM))));
				}

				var3.a(1, var1);
				this.a("mob.sheep.shear", 1.0F, 1.0F);
			}

			return true;
		} else {
			return super.a(var1, var2, var3);
		}
	}

	public EntityMushroomCow c(EntityAgeable var1) {
		return new EntityMushroomCow(o);
	}

	// $FF: synthetic method
	@Override
	public EntityCow b(EntityAgeable var1) {
		return this.c(var1);
	}

	// $FF: synthetic method
	@Override
	public EntityAgeable a(EntityAgeable var1) {
		return this.c(var1);
	}
}
