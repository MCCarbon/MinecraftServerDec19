package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_oj extends class_oi.class_a_in_class_oi {
	private class_aco b;
	private int c;
	private int d;

	public class_oj(Item var1, int var2, int var3, int var4, int var5) {
		super(var5);
		b = new class_aco(var1, 1, var2);
		c = var3;
		d = var4;
	}

	public class_oj(class_aco var1, int var2, int var3, int var4) {
		super(var4);
		b = var1;
		c = var2;
		d = var3;
	}

	public static void a(Random var0, List var1, class_pp var2, int var3) {
		for (int var4 = 0; var4 < var3; ++var4) {
			class_oj var5 = (class_oj) class_oi.a(var0, var1);
			int var6 = var5.c + var0.nextInt((var5.d - var5.c) + 1);
			if (var5.b.c() >= var6) {
				class_aco var9 = var5.b.k();
				var9.b = var6;
				var2.a(var0.nextInt(var2.n_()), var9);
			} else {
				for (int var7 = 0; var7 < var6; ++var7) {
					class_aco var8 = var5.b.k();
					var8.b = 1;
					var2.a(var0.nextInt(var2.n_()), var8);
				}
			}
		}

	}

	public static void a(Random var0, List var1, class_aoo var2, int var3) {
		for (int var4 = 0; var4 < var3; ++var4) {
			class_oj var5 = (class_oj) class_oi.a(var0, var1);
			int var6 = var5.c + var0.nextInt((var5.d - var5.c) + 1);
			if (var5.b.c() >= var6) {
				class_aco var9 = var5.b.k();
				var9.b = var6;
				var2.a(var0.nextInt(var2.n_()), var9);
			} else {
				for (int var7 = 0; var7 < var6; ++var7) {
					class_aco var8 = var5.b.k();
					var8.b = 1;
					var2.a(var0.nextInt(var2.n_()), var8);
				}
			}
		}

	}

	public static List a(List var0, class_oj... var1) {
		ArrayList var2 = Lists.newArrayList((Iterable) var0);
		Collections.addAll(var2, var1);
		return var2;
	}
}
