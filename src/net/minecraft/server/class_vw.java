package net.minecraft.server;

import com.google.common.base.Optional;

public class class_vw extends Entity {
	private static final class_jz b;
	public int a;

	public class_vw(class_ago var1) {
		super(var1);
		k = true;
		this.a(2.0F, 2.0F);
		a = V.nextInt(100000);
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected void h() {
		J().a(b, Optional.absent());
	}

	@Override
	public void r_() {
		p = s;
		q = t;
		r = u;
		++a;
		if (!o.D) {
			class_cj var1 = new class_cj(this);
			if ((o.t instanceof class_arh) && (o.p(var1).c() != Blocks.ab)) {
				o.a(var1, Blocks.ab.S());
			}
		}

	}

	@Override
	protected void b(class_dn var1) {
		if (this.i() != null) {
			var1.a("BeamTarget", class_dy.a(this.i()));
		}

	}

	@Override
	protected void a(class_dn var1) {
		if (var1.b("BeamTarget", 10)) {
			this.a(class_dy.c(var1.o("BeamTarget")));
		}

	}

	@Override
	public boolean ag() {
		return true;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (var1.j() instanceof class_vx) {
			return false;
		} else {
			if (!I && !o.D) {
				L();
				if (!o.D) {
					o.a((Entity) null, s, t, u, 6.0F, true);
					if (o.t instanceof class_arh) {
						class_arh var3 = (class_arh) o.t;
						class_arg var4 = var3.s();
						if (var4 != null) {
							var4.a(this, var1);
						}
					}
				}
			}

			return true;
		}
	}

	public void a(class_cj var1) {
		J().b(b, Optional.fromNullable(var1));
	}

	public class_cj i() {
		return (class_cj) ((Optional) J().a(b)).orNull();
	}

	static {
		b = class_kc.a(class_vw.class, class_kb.j);
	}
}
