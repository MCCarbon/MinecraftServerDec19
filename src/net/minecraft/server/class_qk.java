package net.minecraft.server;


public class class_qk extends class_qj {
	private final Entity s;

	public class_qk(String var1, Entity var2, Entity var3) {
		super(var1, var2);
		s = var3;
	}

	@Override
	public Entity i() {
		return r;
	}

	@Override
	public Entity j() {
		return s;
	}

	@Override
	public class_eu c(class_rg var1) {
		class_eu var2 = s == null ? r.f_() : s.f_();
		class_aco var3 = s instanceof class_rg ? ((class_rg) s).bG() : null;
		String var4 = "death.attack." + q;
		String var5 = var4 + ".item";
		return (var3 != null) && var3.s() && class_di.c(var5) ? new class_fb(var5, new Object[] { var1.f_(), var2, var3.B() }) : new class_fb(var4, new Object[] { var1.f_(), var2 });
	}
}
