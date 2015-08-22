package net.minecraft.server;

import java.util.Random;

public class class_akn extends Block {
	protected class_akn() {
		super(class_avq.c);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
		this.e(255);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return new class_ayk(var2.n(), var2.o(), var2.p(), var2.n() + 1, var2.o() + 0.9375F, var2.p() + 1);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Blocks.d.a(Blocks.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a), var2, var3);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		super.a(var1, var2, var3, var4);
		if (var1.p(var2.a()).c().v().a()) {
			var1.a(var2, Blocks.d.S());
		}

	}
}
