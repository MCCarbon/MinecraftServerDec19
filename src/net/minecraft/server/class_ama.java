package net.minecraft.server;


public class class_ama extends class_ajf {
	@Override
	protected Item o() {
		return Items.bX;
	}

	@Override
	protected Item p() {
		return Items.bX;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (!var1.D) {
			if (this.e(var3) && (var1.s.nextInt(50) == 0)) {
				a(var1, var2, new class_aco(Items.bZ));
			}

		}
	}
}
