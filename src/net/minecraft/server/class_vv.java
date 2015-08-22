package net.minecraft.server;


public class class_vv extends Entity {
	public final class_vu a;
	public final String b;

	public class_vv(class_vu var1, String var2, float var3, float var4) {
		super(var1.a());
		this.a(var3, var4);
		a = var1;
		b = var2;
	}

	@Override
	protected void h() {
	}

	@Override
	protected void a(class_dn var1) {
	}

	@Override
	protected void b(class_dn var1) {
	}

	@Override
	public boolean ag() {
		return true;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		return this.b(var1) ? false : a.a(this, var1, var2);
	}

	@Override
	public boolean l(Entity var1) {
		return (this == var1) || (a == var1);
	}
}
