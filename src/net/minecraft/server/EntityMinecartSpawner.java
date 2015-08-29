package net.minecraft.server;


public class EntityMinecartSpawner extends EntityMinecartAbstract {
	private final class_agf a = new class_agf() {
		@Override
		public void a(int var1) {
			EntityMinecartSpawner.this.o.a(EntityMinecartSpawner.this, ((byte) var1));
		}

		@Override
		public class_ago a() {
			return EntityMinecartSpawner.this.o;
		}

		@Override
		public class_cj b() {
			return new class_cj(EntityMinecartSpawner.this);
		}
	};

	public EntityMinecartSpawner(class_ago var1) {
		super(var1);
	}

	public EntityMinecartSpawner(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public EntityMinecartAbstract.EnumMinecartType s() {
		return EntityMinecartAbstract.EnumMinecartType.SPAWNER;
	}

	@Override
	public class_apn u() {
		return Blocks.MOB_SPAWNER.getBlockData();
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		a.a(var1);
	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		a.b(var1);
	}

	@Override
	public void r_() {
		super.r_();
		a.c();
	}
}
