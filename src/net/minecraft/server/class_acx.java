package net.minecraft.server;

import com.google.common.base.Function;

public class class_acx extends class_abb {
	protected final Block b;
	protected final Function c;

	public class_acx(Block var1, Block var2, Function var3) {
		super(var1);
		b = var2;
		c = var3;
		this.e(0);
		this.a(true);
	}

	public class_acx(Block var1, Block var2, final String[] var3) {
		this(var1, var2, new Function() {
			public String a(class_aco var1) {
				int var2 = var1.i();
				if ((var2 < 0) || (var2 >= var3.length)) {
					var2 = 0;
				}

				return var3[var2];
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		});
	}

	@Override
	public int a(int var1) {
		return var1;
	}

	@Override
	public String e_(class_aco var1) {
		return super.a() + "." + (String) c.apply(var1);
	}
}
