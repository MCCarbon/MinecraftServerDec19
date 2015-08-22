package net.minecraft.server;

import java.util.Random;

public abstract class class_amg extends class_akq {
	public static final class_aqa b = class_aqa.a("variant", class_amg.class_c_in_class_amg.class);

	public class_amg() {
		super(class_avq.e);
		class_apn var1 = M.b();
		if (!l()) {
			var1 = var1.a(a, class_akq.class_a_in_class_akq.b);
		}

		this.j(var1.a(b, class_amg.class_c_in_class_amg.a));
		this.a(class_abp.b);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.cX);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Blocks.cX);
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S().a(b, class_amg.class_c_in_class_amg.a);
		if (!l()) {
			var2 = var2.a(a, (var1 & 8) == 0 ? class_akq.class_a_in_class_akq.b : class_akq.class_a_in_class_akq.a);
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		int var2 = 0;
		if (!l() && (var1.b(a) == class_akq.class_a_in_class_akq.a)) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	protected class_apo e() {
		return l() ? new class_apo(this, new class_aqc[] { b }) : new class_apo(this, new class_aqc[] { a, b });
	}

	@Override
	public String b(int var1) {
		return super.a();
	}

	@Override
	public class_aqc n() {
		return b;
	}

	@Override
	public Object a(class_aco var1) {
		return class_amg.class_c_in_class_amg.a;
	}

	public static enum class_c_in_class_amg implements class_oe {
		a;

		@Override
		public String l() {
			return "default";
		}
	}

	public static class class_a_in_class_amg extends class_amg {
		@Override
		public boolean l() {
			return true;
		}
	}

	public static class class_b_in_class_amg extends class_amg {
		@Override
		public boolean l() {
			return false;
		}
	}
}
