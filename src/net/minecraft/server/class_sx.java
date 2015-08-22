package net.minecraft.server;


public class class_sx extends class_sw {
	private final class_yp e;

	public class_sx(class_yp var1) {
		super(var1, class_yu.class, 8.0F);
		e = var1;
	}

	@Override
	public boolean a() {
		if (e.cH()) {
			b = e.t_();
			return true;
		} else {
			return false;
		}
	}
}
