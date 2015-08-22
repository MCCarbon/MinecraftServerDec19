package net.minecraft.server;


public abstract class class_sl extends class_sr {
	protected class_rh a;
	protected class_cj b;
	protected class_ajn c;
	boolean d;
	float e;
	float f;

	public class_sl(class_rh var1) {
		b = class_cj.a;
		a = var1;
		if (!(var1.u() instanceof class_ul)) {
			throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
		}
	}

	@Override
	public boolean a() {
		if (!a.D) {
			return false;
		} else {
			class_ul var1 = (class_ul) a.u();
			class_axc var2 = var1.j();
			if ((var2 != null) && !var2.b() && var1.g()) {
				for (int var3 = 0; var3 < Math.min(var2.e() + 2, var2.d()); ++var3) {
					class_axa var4 = var2.a(var3);
					b = new class_cj(var4.a, var4.b + 1, var4.c);
					if (a.e(b.n(), a.t, b.p()) <= 2.25D) {
						c = this.a(b);
						if (c != null) {
							return true;
						}
					}
				}

				b = (new class_cj(a)).a();
				c = this.a(b);
				return c != null;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean b() {
		return !d;
	}

	@Override
	public void c() {
		d = false;
		e = (float) (b.n() + 0.5F - a.s);
		f = (float) (b.p() + 0.5F - a.u);
	}

	@Override
	public void e() {
		float var1 = (float) (b.n() + 0.5F - a.s);
		float var2 = (float) (b.p() + 0.5F - a.u);
		float var3 = (e * var1) + (f * var2);
		if (var3 < 0.0F) {
			d = true;
		}

	}

	private class_ajn a(class_cj var1) {
		class_ail var2 = a.o.p(var1).c();
		return (var2 instanceof class_ajn) && (var2.v() == class_avq.d) ? (class_ajn) var2 : null;
	}
}
