package net.minecraft.server;


public class class_qj extends class_qi {
	protected Entity r;
	private boolean s = false;

	public class_qj(String var1, Entity var2) {
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
	public Entity j() {
		return r;
	}

	@Override
	public IChatBaseComponent c(EntityLiving var1) {
		class_aco var2 = r instanceof EntityLiving ? ((EntityLiving) r).bG() : null;
		String var3 = "death.attack." + q;
		String var4 = var3 + ".item";
		return (var2 != null) && var2.s() && class_di.c(var4) ? new class_fb(var4, new Object[] { var1.f_(), r.f_(), var2.B() }) : new class_fb(var3, new Object[] { var1.f_(), r.f_() });
	}

	@Override
	public boolean r() {
		return (r != null) && (r instanceof EntityLiving) && !(r instanceof class_yu);
	}

	@Override
	public class_aym v() {
		return new class_aym(r.s, r.t, r.u);
	}
}
