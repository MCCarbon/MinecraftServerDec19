package net.minecraft.server;


public class class_ala extends class_aif {
	public static final class_apy a = class_apy.a("has_record");

	protected class_ala() {
		super(class_avq.d, class_avr.l);
		this.j(M.b().a(a, Boolean.valueOf(false)));
		this.a(class_abp.c);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			this.f(var1, var2, var3);
			var3 = var3.a(a, Boolean.valueOf(false));
			var1.a(var2, var3, 2);
			return true;
		} else {
			return false;
		}
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_aco var4) {
		if (!var1.D) {
			TileEntity var5 = var1.s(var2);
			if (var5 instanceof class_ala.class_a_in_class_ala) {
				((class_ala.class_a_in_class_ala) var5).a(var4.k());
				var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
			}
		}
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			TileEntity var4 = var1.s(var2);
			if (var4 instanceof class_ala.class_a_in_class_ala) {
				class_ala.class_a_in_class_ala var5 = (class_ala.class_a_in_class_ala) var4;
				class_aco var6 = var5.a();
				if (var6 != null) {
					var1.b(1005, var2, 0);
					var1.a(var2, (String) null);
					var5.a((class_aco) null);
					float var7 = 0.7F;
					double var8 = var1.s.nextFloat() * var7 + ((1.0F - var7) * 0.5D);
					double var10 = var1.s.nextFloat() * var7 + ((1.0F - var7) * 0.2D) + 0.6D;
					double var12 = var1.s.nextFloat() * var7 + ((1.0F - var7) * 0.5D);
					class_aco var14 = var6.k();
					EntityItem var15 = new EntityItem(var1, var2.n() + var8, var2.o() + var10, var2.p() + var12, var14);
					var15.o();
					var1.a(var15);
				}
			}
		}
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3);
		super.c(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (!var1.D) {
			super.a(var1, var2, var3, var4, 0);
		}
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_ala.class_a_in_class_ala();
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		TileEntity var3 = var1.s(var2);
		if (var3 instanceof class_ala.class_a_in_class_ala) {
			class_aco var4 = ((class_ala.class_a_in_class_ala) var3).a();
			if (var4 != null) {
				return (Item.b(var4.b()) + 1) - Item.b(Items.cv);
			}
		}

		return 0;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, Boolean.valueOf(var1 > 0));
	}

	@Override
	public int c(class_apn var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public static class class_a_in_class_ala extends TileEntity {
		private class_aco a;

		@Override
		public void a(class_dn var1) {
			super.a(var1);
			if (var1.b("RecordItem", 10)) {
				this.a(class_aco.a(var1.o("RecordItem")));
			} else if (var1.h("Record") > 0) {
				this.a(new class_aco(Item.c(var1.h("Record"))));
			}

		}

		@Override
		public void b(class_dn var1) {
			super.b(var1);
			if (this.a() != null) {
				var1.a("RecordItem", this.a().b(new class_dn()));
			}

		}

		public class_aco a() {
			return a;
		}

		public void a(class_aco var1) {
			a = var1;
			o_();
		}
	}
}
