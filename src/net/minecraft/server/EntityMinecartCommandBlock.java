package net.minecraft.server;


public class EntityMinecartCommandBlock extends EntityMinecartAbstract {
	private static final class_jz a;
	private static final class_jz b;
	private final class_age c = new class_age() {
		@Override
		public void h() {
			EntityMinecartCommandBlock.this.J().b(EntityMinecartCommandBlock.a, this.l());
			EntityMinecartCommandBlock.this.J().b(EntityMinecartCommandBlock.b, this.k());
		}

		@Override
		public class_cj c() {
			return new class_cj(EntityMinecartCommandBlock.this.s, EntityMinecartCommandBlock.this.t + 0.5D, EntityMinecartCommandBlock.this.u);
		}

		@Override
		public class_aym d() {
			return new class_aym(EntityMinecartCommandBlock.this.s, EntityMinecartCommandBlock.this.t, EntityMinecartCommandBlock.this.u);
		}

		@Override
		public class_ago e() {
			return EntityMinecartCommandBlock.this.o;
		}

		@Override
		public Entity f() {
			return EntityMinecartCommandBlock.this;
		}
	};
	private int d = 0;

	public EntityMinecartCommandBlock(class_ago var1) {
		super(var1);
	}

	public EntityMinecartCommandBlock(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	protected void h() {
		super.h();
		J().a(a, "");
		J().a(b, (new class_fa("")));
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		c.b(var1);
		J().b(a, this.i().l());
		J().b(b, this.i().k());
	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		c.a(var1);
	}

	@Override
	public EntityMinecartAbstract.EnumMinecartType s() {
		return EntityMinecartAbstract.EnumMinecartType.COMMAND_BLOCK;
	}

	@Override
	public class_apn u() {
		return Blocks.COMMAND_BLOCK.getBlockData();
	}

	public class_age i() {
		return c;
	}

	@Override
	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4 && ((W - d) >= 4)) {
			this.i().a(o);
			d = W;
		}

	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		c.a(var1);
		return false;
	}

	@Override
	public void a(class_jz var1) {
		super.a(var1);
		if (var1 == b) {
			try {
				c.b((IChatBaseComponent) J().a(b));
			} catch (Throwable var3) {
				;
			}
		} else if (var1 == a) {
			c.a((String) J().a(a));
		}

	}

	@Override
	public boolean bc() {
		return true;
	}

	static {
		a = DataWatcher.claimId(EntityMinecartCommandBlock.class, class_kb.d);
		b = DataWatcher.claimId(EntityMinecartCommandBlock.class, class_kb.e);
	}
}
