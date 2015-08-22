package net.minecraft.server;

import java.util.UUID;

import com.google.common.base.Optional;

public abstract class class_ro extends class_vc implements class_rm {
	protected static final class_jz bt;
	protected static final class_jz bu;
	protected class_tt bv = new class_tt(this);

	public class_ro(class_ago var1) {
		super(var1);
		cF();
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bt, Byte.valueOf((byte) 0));
		ac.a(bu, Optional.absent());
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (this.b() == null) {
			var1.a("OwnerUUID", "");
		} else {
			var1.a("OwnerUUID", this.b().toString());
		}

		var1.a("Sitting", cG());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		String var2 = "";
		if (var1.b("OwnerUUID", 8)) {
			var2 = var1.l("OwnerUUID");
		} else {
			String var3 = var1.l("Owner");
			var2 = class_md.a(var3);
		}

		if (!var2.isEmpty()) {
			this.b(UUID.fromString(var2));
			this.n(true);
		}

		bv.a(var1.p("Sitting"));
		this.o(var1.p("Sitting"));
	}

	protected void m(boolean var1) {
		class_cy var2 = class_cy.I;
		if (!var1) {
			var2 = class_cy.l;
		}

		for (int var3 = 0; var3 < 7; ++var3) {
			double var4 = V.nextGaussian() * 0.02D;
			double var6 = V.nextGaussian() * 0.02D;
			double var8 = V.nextGaussian() * 0.02D;
			o.a(var2, (s + V.nextFloat() * J * 2.0F) - J, t + 0.5D + V.nextFloat() * K, (u + V.nextFloat() * J * 2.0F) - J, var4, var6, var8, new int[0]);
		}

	}

	public boolean cE() {
		return (((Byte) ac.a(bt)).byteValue() & 4) != 0;
	}

	public void n(boolean var1) {
		byte var2 = ((Byte) ac.a(bt)).byteValue();
		if (var1) {
			ac.b(bt, Byte.valueOf((byte) (var2 | 4)));
		} else {
			ac.b(bt, Byte.valueOf((byte) (var2 & -5)));
		}

		cF();
	}

	protected void cF() {
	}

	public boolean cG() {
		return (((Byte) ac.a(bt)).byteValue() & 1) != 0;
	}

	public void o(boolean var1) {
		byte var2 = ((Byte) ac.a(bt)).byteValue();
		if (var1) {
			ac.b(bt, Byte.valueOf((byte) (var2 | 1)));
		} else {
			ac.b(bt, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	@Override
	public UUID b() {
		return (UUID) ((Optional) ac.a(bu)).orNull();
	}

	public void b(UUID var1) {
		ac.b(bu, Optional.fromNullable(var1));
	}

	public class_rg cH() {
		try {
			UUID var1 = this.b();
			return var1 == null ? null : o.b(var1);
		} catch (IllegalArgumentException var2) {
			return null;
		}
	}

	public boolean d(class_rg var1) {
		return var1 == cH();
	}

	public class_tt cI() {
		return bv;
	}

	public boolean a(class_rg var1, class_rg var2) {
		return true;
	}

	@Override
	public class_ayu aE() {
		if (cE()) {
			class_rg var1 = cH();
			if (var1 != null) {
				return var1.aE();
			}
		}

		return super.aE();
	}

	@Override
	public boolean k(class_qx var1) {
		if (cE()) {
			class_rg var2 = cH();
			if (var1 == var2) {
				return true;
			}

			if (var2 != null) {
				return var2.k(var1);
			}
		}

		return super.k(var1);
	}

	@Override
	public void a(class_qi var1) {
		if (!o.D && o.S().b("showDeathMessages") && k_() && (cH() instanceof class_lm)) {
			((class_lm) cH()).a(bz().b());
		}

		super.a(var1);
	}

	// $FF: synthetic method
	@Override
	public class_qx l_() {
		return cH();
	}

	static {
		bt = class_kc.a(class_ro.class, class_kb.a);
		bu = class_kc.a(class_ro.class, class_kb.l);
	}
}
