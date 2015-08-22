package net.minecraft.server;


public abstract class class_vz implements class_wg {
	protected final class_vx a;

	public class_vz(class_vx var1) {
		a = var1;
	}

	@Override
	public boolean a() {
		return false;
	}

	@Override
	public void b() {
	}

	@Override
	public void c() {
	}

	@Override
	public void a(class_vw var1, class_cj var2, class_qi var3, class_yu var4) {
	}

	@Override
	public void d() {
	}

	@Override
	public void e() {
	}

	@Override
	public float f() {
		return 0.6F;
	}

	@Override
	public class_aym g() {
		return null;
	}

	@Override
	public float a(class_vv var1, class_qi var2, float var3) {
		return var3;
	}

	@Override
	public float h() {
		float var1 = (class_oa.a((a.v * a.v) + (a.x * a.x)) * 1.0F) + 1.0F;
		float var2 = Math.min(var1, 40.0F);
		return 0.7F / var2 / var1;
	}
}
