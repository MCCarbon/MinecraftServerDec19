package net.minecraft.server;


public class class_ui extends class_uj {
	class_ro a;
	class_rg b;
	private int c;

	public class_ui(class_ro var1) {
		super(var1, false);
		a = var1;
		this.a(1);
	}

	@Override
	public boolean a() {
		if (!a.cE()) {
			return false;
		} else {
			class_rg var1 = a.cH();
			if (var1 == null) {
				return false;
			} else {
				b = var1.bm();
				int var2 = var1.bn();
				return (var2 != c) && this.a(b, false) && a.a(b, var1);
			}
		}
	}

	@Override
	public void c() {
		e.c(b);
		class_rg var1 = a.cH();
		if (var1 != null) {
			c = var1.bn();
		}

		super.c();
	}
}
