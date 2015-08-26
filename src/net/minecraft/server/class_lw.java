package net.minecraft.server;


public class class_lw implements class_jv {
	private static final IChatBaseComponent a = new class_fa("Status request has been handled.");
	private final MinecraftServer b;
	private final class_ek c;
	private boolean d;

	public class_lw(MinecraftServer var1, class_ek var2) {
		b = var1;
		c = var2;
	}

	@Override
	public void a(IChatBaseComponent var1) {
	}

	@Override
	public void a(class_jx var1) {
		if (d) {
			c.a(a);
		} else {
			d = true;
			c.a((new class_jt(b.aI())));
		}
	}

	@Override
	public void a(class_jw var1) {
		c.a((new class_js(var1.a())));
		c.a(a);
	}
}
