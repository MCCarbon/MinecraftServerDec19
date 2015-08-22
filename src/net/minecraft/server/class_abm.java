package net.minecraft.server;


public class class_abm extends class_acm {
	public class_abm() {
		this.a(true);
		this.e(0);
		this.a(class_abp.l);
	}

	@Override
	public String e_(class_aco var1) {
		return var1.i() == 1 ? "item.charcoal" : "item.coal";
	}
}
