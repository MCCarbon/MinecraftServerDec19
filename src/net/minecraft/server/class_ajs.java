package net.minecraft.server;


public class class_ajs extends class_aif {
	protected class_ajs() {
		super(class_avq.e, class_avr.D);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		this.e(0);
		this.a(class_abp.c);
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aoq();
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			TileEntity var11 = var1.s(var2);
			if (var11 instanceof class_aoq) {
				var4.a(((class_aoq) var11));
			}

			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		super.a(var1, var2, var3, var4, var5);
		if (var5.s()) {
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof class_aoq) {
				((class_aoq) var6).a(var5.q());
			}
		}

	}
}
