package net.minecraft.server;


public class class_adk extends class_acm {
	public class_adk() {
		i = 1;
		this.a(class_abp.j);
		this.a(true);
		this.e(180);
		this.a(new class_ke("blocking"), new class_acp() {
		});
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9);
	}

	@Override
	public String a(class_aco var1) {
		String var2 = "item.shield.";
		class_abt var3 = class_aaz.b(var1);
		var2 = var2 + var3.d() + ".name";
		return class_di.a(var2);
	}

	@Override
	public class_ady f(class_aco var1) {
		return class_ady.d;
	}

	@Override
	public int e(class_aco var1) {
		return 72000;
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		var3.c(var4);
		return new class_px(class_pw.a, var1);
	}

	@Override
	public boolean a(class_aco var1, class_aco var2) {
		return var2.b() == class_acm.a(class_aim.f) ? true : super.a(var1, var2);
	}
}
