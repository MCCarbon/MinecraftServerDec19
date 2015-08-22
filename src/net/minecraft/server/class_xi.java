package net.minecraft.server;


public class class_xi extends class_xk {
	public class_xi(class_ago var1) {
		super(var1);
	}

	public class_xi(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (o.S().b("doEntityDrops")) {
			this.a(Item.a(Blocks.ae), 1, 0.0F);
		}

	}

	@Override
	public int n_() {
		return 27;
	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.b;
	}

	@Override
	public class_apn u() {
		return Blocks.ae.S().a(class_aiw.a, class_cq.c);
	}

	@Override
	public int w() {
		return 8;
	}

	@Override
	public String k() {
		return "minecraft:chest";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aaa(var1, this, var2);
	}
}
