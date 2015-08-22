package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class class_aen {
	private static final class_aen a = new class_aen();
	private Map b = Maps.newHashMap();
	private Map c = Maps.newHashMap();

	public static class_aen a() {
		return a;
	}

	private class_aen() {
		this.a(Blocks.p, new class_aco(Items.l), 0.7F);
		this.a(Blocks.o, new class_aco(Items.m), 1.0F);
		this.a(Blocks.ag, new class_aco(Items.k), 1.0F);
		this.a(Blocks.m, new class_aco(Blocks.w), 0.1F);
		this.a(Items.an, new class_aco(Items.ao), 0.35F);
		this.a(Items.bk, new class_aco(Items.bl), 0.35F);
		this.a(Items.bm, new class_aco(Items.bn), 0.35F);
		this.a(Items.bq, new class_aco(Items.br), 0.35F);
		this.a(Items.bo, new class_aco(Items.bp), 0.35F);
		this.a(Blocks.e, new class_aco(Blocks.b), 0.1F);
		this.a(new class_aco(Blocks.bf, 1, class_ank.b), new class_aco(Blocks.bf, 1, class_ank.O), 0.1F);
		this.a(Items.aK, new class_aco(Items.aJ), 0.3F);
		this.a(Blocks.aL, new class_aco(Blocks.cz), 0.35F);
		this.a(Blocks.aK, new class_aco(Items.aY, 1, class_abt.n.b()), 0.2F);
		this.a(Blocks.r, new class_aco(Items.j, 1, 1), 0.15F);
		this.a(Blocks.s, new class_aco(Items.j, 1, 1), 0.15F);
		this.a(Blocks.bP, new class_aco(Items.bT), 1.0F);
		this.a(Items.bX, new class_aco(Items.bY), 0.35F);
		this.a(Blocks.aV, new class_aco(Items.ck), 0.1F);
		this.a(new class_aco(Blocks.v, 1, 1), new class_aco(Blocks.v, 1, 0), 0.15F);
		this.a(Items.cL, new class_aco(Items.cM), 0.1F);
		class_acf.class_a_in_class_acf[] var1 = class_acf.class_a_in_class_acf.values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_acf.class_a_in_class_acf var4 = var1[var3];
			if (var4.g()) {
				this.a(new class_aco(Items.aW, 1, var4.a()), new class_aco(Items.aX, 1, var4.a()), 0.35F);
			}
		}

		this.a(Blocks.q, new class_aco(Items.j), 0.1F);
		this.a(Blocks.aC, new class_aco(Items.aE), 0.7F);
		this.a(Blocks.x, new class_aco(Items.aY, 1, class_abt.l.b()), 0.2F);
		this.a(Blocks.co, new class_aco(Items.cl), 0.2F);
	}

	public void a(Block var1, class_aco var2, float var3) {
		this.a(Item.a(var1), var2, var3);
	}

	public void a(Item var1, class_aco var2, float var3) {
		this.a(new class_aco(var1, 1, 32767), var2, var3);
	}

	public void a(class_aco var1, class_aco var2, float var3) {
		b.put(var1, var2);
		c.put(var2, Float.valueOf(var3));
	}

	public class_aco a(class_aco var1) {
		Iterator var2 = b.entrySet().iterator();

		Entry var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (Entry) var2.next();
		} while (!this.a(var1, (class_aco) var3.getKey()));

		return (class_aco) var3.getValue();
	}

	private boolean a(class_aco var1, class_aco var2) {
		return (var2.b() == var1.b()) && ((var2.i() == 32767) || (var2.i() == var1.i()));
	}

	public Map b() {
		return b;
	}

	public float b(class_aco var1) {
		Iterator var2 = c.entrySet().iterator();

		Entry var3;
		do {
			if (!var2.hasNext()) {
				return 0.0F;
			}

			var3 = (Entry) var2.next();
		} while (!this.a(var1, (class_aco) var3.getKey()));

		return ((Float) var3.getValue()).floatValue();
	}
}
