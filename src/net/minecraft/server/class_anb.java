package net.minecraft.server;


public class class_anb extends Block {
	public class_anb() {
		super(class_avq.p, class_avr.B);
		this.a(class_abp.b);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		float var4 = 0.125F;
		return new class_ayk(var2.n(), var2.o(), var2.p(), var2.n() + 1, var2.o() + 1 - var4, var2.p() + 1);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Entity var4) {
		var4.v *= 0.4D;
		var4.x *= 0.4D;
	}
}
