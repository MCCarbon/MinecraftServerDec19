package net.minecraft.server;

import com.google.common.base.Optional;

public class class_wu extends class_wt {
	private static final class_jz c;
	private static final class_jz d;
	private float e = 1.0F;

	public class_wu(class_ago var1) {
		super(var1);
	}

	public class_wu(class_ago var1, class_cj var2, class_cq var3) {
		super(var1, var2);
		this.a(var3);
	}

	@Override
	protected void h() {
		J().a(c, Optional.absent());
		J().a(d, Integer.valueOf(0));
	}

	@Override
	public float ar() {
		return 0.0F;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!var1.c() && (this.n() != null)) {
			if (!o.D) {
				this.a(var1.j(), false);
				this.a((class_aco) null);
			}

			return true;
		} else {
			return super.a(var1, var2);
		}
	}

	@Override
	public int j() {
		return 12;
	}

	@Override
	public int k() {
		return 12;
	}

	@Override
	public void b(class_qx var1) {
		this.a(var1, true);
	}

	public void a(class_qx var1, boolean var2) {
		if (o.S().b("doEntityDrops")) {
			class_aco var3 = this.n();
			if (var1 instanceof class_yu) {
				class_yu var4 = (class_yu) var1;
				if (var4.bI.d) {
					this.b(var3);
					return;
				}
			}

			if (var2) {
				this.a(new class_aco(class_acq.bU), 0.0F);
			}

			if ((var3 != null) && (V.nextFloat() < e)) {
				var3 = var3.k();
				this.b(var3);
				this.a(var3, 0.0F);
			}

		}
	}

	private void b(class_aco var1) {
		if (var1 != null) {
			if (var1.b() == class_acq.bf) {
				class_axl var2 = ((class_acu) var1.b()).a(var1, o);
				var2.i.remove("frame-" + G());
			}

			var1.a((class_wu) null);
		}
	}

	public class_aco n() {
		return (class_aco) ((Optional) J().a(c)).orNull();
	}

	public void a(class_aco var1) {
		this.a(var1, true);
	}

	private void a(class_aco var1, boolean var2) {
		if (var1 != null) {
			var1 = var1.k();
			var1.b = 1;
			var1.a(this);
		}

		J().b(c, Optional.fromNullable(var1));
		J().b(c);
		if (var2 && (a != null)) {
			o.f(a, class_aim.a);
		}

	}

	public int o() {
		return ((Integer) J().a(d)).intValue();
	}

	public void a(int var1) {
		this.a(var1, true);
	}

	private void a(int var1, boolean var2) {
		J().b(d, Integer.valueOf(var1 % 8));
		if (var2 && (a != null)) {
			o.f(a, class_aim.a);
		}

	}

	@Override
	public void b(class_dn var1) {
		if (this.n() != null) {
			var1.a("Item", this.n().b(new class_dn()));
			var1.a("ItemRotation", (byte) this.o());
			var1.a("ItemDropChance", e);
		}

		super.b(var1);
	}

	@Override
	public void a(class_dn var1) {
		class_dn var2 = var1.o("Item");
		if ((var2 != null) && !var2.c_()) {
			this.a(class_aco.a(var2), false);
			this.a(var1.f("ItemRotation"), false);
			if (var1.b("ItemDropChance", 99)) {
				e = var1.j("ItemDropChance");
			}
		}

		super.a(var1);
	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if (this.n() == null) {
			if ((var2 != null) && !o.D) {
				this.a(var2);
				if (!var1.bI.d) {
					--var2.b;
				}
			}
		} else if (!o.D) {
			this.a(this.o() + 1);
		}

		return true;
	}

	public int p() {
		return this.n() == null ? 0 : (this.o() % 8) + 1;
	}

	static {
		c = class_kc.a(class_wu.class, class_kb.f);
		d = class_kc.a(class_wu.class, class_kb.b);
	}
}
