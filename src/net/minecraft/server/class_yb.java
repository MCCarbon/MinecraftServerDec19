package net.minecraft.server;


public class class_yb extends class_yi {
	public class_yb(class_ago var1) {
		super(var1);
		ab = true;
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.d).a(0.20000000298023224D);
	}

	@Override
	public boolean cj() {
		return o.ac() != class_ps.a;
	}

	@Override
	public boolean ck() {
		return o.a(aX(), this) && o.a(this, aX()).isEmpty() && !o.d(aX());
	}

	@Override
	public int by() {
		return cF() * 3;
	}

	@Override
	public float f(float var1) {
		return 1.0F;
	}

	@Override
	protected class_cy n() {
		return class_cy.A;
	}

	@Override
	protected class_yi cy() {
		return new class_yb(o);
	}

	@Override
	protected Item D() {
		return Items.bJ;
	}

	@Override
	protected void b(boolean var1, int var2) {
		Item var3 = D();
		if ((var3 != null) && (cF() > 1)) {
			int var4 = V.nextInt(4) - 2;
			if (var2 > 0) {
				var4 += V.nextInt(var2 + 1);
			}

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	@Override
	public boolean ay() {
		return false;
	}

	@Override
	protected int cz() {
		return super.cz() * 4;
	}

	@Override
	protected void cA() {
		a *= 0.9F;
	}

	@Override
	protected void bM() {
		w = 0.42F + (cF() * 0.1F);
		ai = true;
	}

	@Override
	protected void bO() {
		w = 0.22F + (cF() * 0.05F);
		ai = true;
	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	protected boolean cB() {
		return true;
	}

	@Override
	protected int cC() {
		return super.cC() + 2;
	}

	@Override
	protected String cD() {
		return cF() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
	}

	@Override
	protected boolean cE() {
		return true;
	}
}
