package net.minecraft.server;


public abstract class class_kg extends class_cn {
	@Override
	public class_aco b(class_ck var1, class_aco var2) {
		class_ago var3 = var1.i();
		class_cz var4 = class_ajm.a(var1);
		class_cq var5 = class_ajm.b(var1.f());
		class_zd var6 = this.a(var3, var4, var2);
		var6.c(var5.g(), var5.h() + 0.1F, var5.i(), this.b(), this.a());
		var3.a((Entity) var6);
		var2.a(1);
		return var2;
	}

	@Override
	protected void a(class_ck var1) {
		var1.i().b(1002, var1.d(), 0);
	}

	protected abstract class_zd a(class_ago var1, class_cz var2, class_aco var3);

	protected float a() {
		return 6.0F;
	}

	protected float b() {
		return 1.1F;
	}
}
