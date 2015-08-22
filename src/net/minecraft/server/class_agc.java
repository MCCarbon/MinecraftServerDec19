package net.minecraft.server;

import java.util.ArrayList;

public class class_agc extends ArrayList {
	public class_agc() {
	}

	public class_agc(class_dn var1) {
		this.a(var1);
	}

	public class_agb a(class_aco var1, class_aco var2, int var3) {
		if ((var3 > 0) && (var3 < size())) {
			class_agb var6 = (class_agb) get(var3);
			return !this.a(var1, var6.a()) || (((var2 != null) || var6.c()) && (!var6.c() || !this.a(var2, var6.b()))) || (var1.b < var6.a().b) || (var6.c() && (var2.b < var6.b().b)) ? null : var6;
		} else {
			for (int var4 = 0; var4 < size(); ++var4) {
				class_agb var5 = (class_agb) get(var4);
				if (this.a(var1, var5.a()) && (var1.b >= var5.a().b) && ((!var5.c() && (var2 == null)) || (var5.c() && this.a(var2, var5.b()) && (var2.b >= var5.b().b)))) {
					return var5;
				}
			}

			return null;
		}
	}

	private boolean a(class_aco var1, class_aco var2) {
		return class_aco.c(var1, var2) && (!var2.n() || (var1.n() && class_dy.a(var2.o(), var1.o(), false)));
	}

	public void a(PacketDataSerializer var1) {
		var1.writeByte((byte) (size() & 255));

		for (int var2 = 0; var2 < size(); ++var2) {
			class_agb var3 = (class_agb) get(var2);
			var1.a(var3.a());
			var1.a(var3.d());
			class_aco var4 = var3.b();
			var1.writeBoolean(var4 != null);
			if (var4 != null) {
				var1.a(var4);
			}

			var1.writeBoolean(var3.h());
			var1.writeInt(var3.e());
			var1.writeInt(var3.f());
		}

	}

	public void a(class_dn var1) {
		class_du var2 = var1.c("Recipes", 10);

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			this.add(new class_agb(var4));
		}

	}

	public class_dn a() {
		class_dn var1 = new class_dn();
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < size(); ++var3) {
			class_agb var4 = (class_agb) get(var3);
			var2.a(var4.k());
		}

		var1.a("Recipes", var2);
		return var1;
	}
}
