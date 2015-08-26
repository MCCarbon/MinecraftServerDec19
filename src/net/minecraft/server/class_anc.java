package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.collect.Lists;

public class class_anc extends Block {
	public static final class_apy a = class_apy.a("wet");

	protected class_anc() {
		super(class_avq.m);
		this.j(M.b().a(a, Boolean.valueOf(false)));
		this.a(class_abp.b);
	}

	@Override
	public String f() {
		return class_di.a(this.a() + ".dry.name");
	}

	@Override
	public int a(class_apn var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		this.f(var1, var2, var3);
		super.a(var1, var2, var3, var4);
	}

	protected void f(class_ago var1, class_cj var2, class_apn var3) {
		if (!((Boolean) var3.b(a)).booleanValue() && this.d(var1, var2)) {
			var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
			var1.b(2001, var2, Block.a(Blocks.WATER));
		}

	}

	private boolean d(class_ago var1, class_cj var2) {
		LinkedList var3 = Lists.newLinkedList();
		ArrayList var4 = Lists.newArrayList();
		var3.add(new class_oh(var2, Integer.valueOf(0)));
		int var5 = 0;

		class_cj var7;
		while (!var3.isEmpty()) {
			class_oh var6 = (class_oh) var3.poll();
			var7 = (class_cj) var6.a();
			int var8 = ((Integer) var6.b()).intValue();
			class_cq[] var9 = class_cq.values();
			int var10 = var9.length;

			for (int var11 = 0; var11 < var10; ++var11) {
				class_cq var12 = var9[var11];
				class_cj var13 = var7.a(var12);
				if (var1.p(var13).c().v() == class_avq.h) {
					var1.a(var13, Blocks.AIR.S(), 2);
					var4.add(var13);
					++var5;
					if (var8 < 6) {
						var3.add(new class_oh(var13, Integer.valueOf(var8 + 1)));
					}
				}
			}

			if (var5 > 64) {
				break;
			}
		}

		Iterator var14 = var4.iterator();

		while (var14.hasNext()) {
			var7 = (class_cj) var14.next();
			var1.d(var7, Blocks.AIR);
		}

		return var5 > 0;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Boolean.valueOf((var1 & 1) == 1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
