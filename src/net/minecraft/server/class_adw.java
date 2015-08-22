package net.minecraft.server;


public class class_adw extends class_abb {
	private final Block b;
	private String[] c;

	public class_adw(Block var1, boolean var2) {
		super(var1);
		b = var1;
		if (var2) {
			this.e(0);
			this.a(true);
		}

	}

	@Override
	public int a(int var1) {
		return var1;
	}

	public class_adw a(String[] var1) {
		c = var1;
		return this;
	}

	@Override
	public String e_(class_aco var1) {
		if (c == null) {
			return super.e_(var1);
		} else {
			int var2 = var1.i();
			return (var2 >= 0) && (var2 < c.length) ? super.e_(var1) + "." + c[var2] : super.e_(var1);
		}
	}
}
