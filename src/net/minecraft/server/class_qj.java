package net.minecraft.server;


public class class_qj extends class_qi {
	protected class_qx r;
	private boolean s = false;

	public class_qj(String var1, class_qx var2) {
		super(var1);
		r = var2;
	}

	public class_qj w() {
		s = true;
		return this;
	}

	public boolean x() {
		return s;
	}

	@Override
	public class_qx j() {
		return r;
	}

	@Override
	public class_eu c(class_rg var1) {
		class_aco var2 = r instanceof class_rg ? ((class_rg) r).bG() : null;
		String var3 = "death.attack." + q;
		String var4 = var3 + ".item";
		return (var2 != null) && var2.s() && class_di.c(var4) ? new class_fb(var4, new Object[] { var1.f_(), r.f_(), var2.B() }) : new class_fb(var3, new Object[] { var1.f_(), r.f_() });
	}

	@Override
	public boolean r() {
		return (r != null) && (r instanceof class_rg) && !(r instanceof class_yu);
	}

	@Override
	public class_aym v() {
		return new class_aym(r.s, r.t, r.u);
	}
}
