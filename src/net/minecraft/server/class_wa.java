package net.minecraft.server;


public abstract class class_wa extends class_vz {
	public class_wa(class_vx var1) {
		super(var1);
	}

	@Override
	public boolean a() {
		return true;
	}

	@Override
	public float a(class_vv var1, class_qi var2, float var3) {
		if (var2.i() instanceof class_yx) {
			var2.i().e(1);
			return 0.0F;
		} else {
			return super.a(var1, var2, var3);
		}
	}
}
