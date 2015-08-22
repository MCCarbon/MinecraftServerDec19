package net.minecraft.server;

import java.util.UUID;

public abstract class class_rn extends class_rh {
	public static final UUID br = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
	public static final class_rr bs;
	private class_cj a;
	private float b;
	private class_sr c;
	private boolean bt;

	public class_rn(class_ago var1) {
		super(var1);
		a = class_cj.a;
		b = -1.0F;
		c = new class_td(this, 1.0D);
	}

	public float a(class_cj var1) {
		return 0.0F;
	}

	@Override
	public boolean cj() {
		return super.cj() && (this.a(new class_cj(s, aX().b, u)) >= 0.0F);
	}

	public boolean cy() {
		return !h.m();
	}

	public boolean cz() {
		return this.e(new class_cj(this));
	}

	public boolean e(class_cj var1) {
		return b == -1.0F ? true : a.i(var1) < b * b;
	}

	public void a(class_cj var1, int var2) {
		a = var1;
		b = var2;
	}

	public class_cj cA() {
		return a;
	}

	public float cB() {
		return b;
	}

	public void cC() {
		b = -1.0F;
	}

	public boolean cD() {
		return b != -1.0F;
	}

	@Override
	protected void cs() {
		super.cs();
		if (cu() && (cv() != null) && (cv().o == o)) {
			Entity var1 = cv();
			this.a(new class_cj((int) var1.s, (int) var1.t, (int) var1.u), 5);
			float var2 = this.g(var1);
			if ((this instanceof class_ro) && ((class_ro) this).cG()) {
				if (var2 > 10.0F) {
					this.a(true, true);
				}

				return;
			}

			if (!bt) {
				i.a(2, c);
				if (u() instanceof class_ul) {
					((class_ul) u()).a(false);
				}

				bt = true;
			}

			this.p(var2);
			if (var2 > 4.0F) {
				u().a(var1, 1.0D);
			}

			if (var2 > 6.0F) {
				double var3 = (var1.s - s) / var2;
				double var5 = (var1.t - t) / var2;
				double var7 = (var1.u - u) / var2;
				v += var3 * Math.abs(var3) * 0.4D;
				w += var5 * Math.abs(var5) * 0.4D;
				x += var7 * Math.abs(var7) * 0.4D;
			}

			if (var2 > 10.0F) {
				this.a(true, true);
			}
		} else if (!cu() && bt) {
			bt = false;
			i.a(c);
			if (u() instanceof class_ul) {
				((class_ul) u()).a(true);
			}

			cC();
		}

	}

	protected void p(float var1) {
	}

	static {
		bs = (new class_rr(br, "Fleeing speed bonus", 2.0D, 2)).a(false);
	}
}
