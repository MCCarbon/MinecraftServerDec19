package net.minecraft.server;

import java.util.List;

import com.google.common.collect.Lists;

public class class_als extends class_aif {
	private static final List a = Lists.newArrayList((Object[]) (new String[] { "harp", "bd", "snare", "hat", "bassattack" }));

	public class_als() {
		super(class_avq.d);
		this.a(class_abp.d);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		boolean var5 = var1.z(var2);
		class_aoi var6 = var1.s(var2);
		if (var6 instanceof class_aoy) {
			class_aoy var7 = (class_aoy) var6;
			if (var7.f != var5) {
				if (var5) {
					var7.a(var1, var2);
				}

				var7.f = var5;
			}
		}

	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			class_aoi var11 = var1.s(var2);
			if (var11 instanceof class_aoy) {
				class_aoy var12 = (class_aoy) var11;
				var12.b();
				var12.a(var1, var2);
				var4.b(class_nh.T);
			}

			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_yu var3) {
		if (!var1.D) {
			class_aoi var4 = var1.s(var2);
			if (var4 instanceof class_aoy) {
				((class_aoy) var4).a(var1, var2);
				var3.b(class_nh.S);
			}

		}
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_aoy();
	}

	private String b(int var1) {
		if ((var1 < 0) || (var1 >= a.size())) {
			var1 = 0;
		}

		return (String) a.get(var1);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, int var4, int var5) {
		float var6 = (float) Math.pow(2.0D, (var5 - 12) / 12.0D);
		var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "note." + this.b(var4), 3.0F, var6);
		var1.a(class_cy.x, var2.n() + 0.5D, var2.o() + 1.2D, var2.p() + 0.5D, var5 / 24.0D, 0.0D, 0.0D, new int[0]);
		return true;
	}

	@Override
	public int b() {
		return 3;
	}
}
