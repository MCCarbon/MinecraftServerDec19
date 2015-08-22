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
		this.a(class_aim.p, new class_aco(class_acq.l), 0.7F);
		this.a(class_aim.o, new class_aco(class_acq.m), 1.0F);
		this.a(class_aim.ag, new class_aco(class_acq.k), 1.0F);
		this.a(class_aim.m, new class_aco(class_aim.w), 0.1F);
		this.a(class_acq.an, new class_aco(class_acq.ao), 0.35F);
		this.a(class_acq.bk, new class_aco(class_acq.bl), 0.35F);
		this.a(class_acq.bm, new class_aco(class_acq.bn), 0.35F);
		this.a(class_acq.bq, new class_aco(class_acq.br), 0.35F);
		this.a(class_acq.bo, new class_aco(class_acq.bp), 0.35F);
		this.a(class_aim.e, new class_aco(class_aim.b), 0.1F);
		this.a(new class_aco(class_aim.bf, 1, class_ank.b), new class_aco(class_aim.bf, 1, class_ank.O), 0.1F);
		this.a(class_acq.aK, new class_aco(class_acq.aJ), 0.3F);
		this.a(class_aim.aL, new class_aco(class_aim.cz), 0.35F);
		this.a(class_aim.aK, new class_aco(class_acq.aY, 1, class_abt.n.b()), 0.2F);
		this.a(class_aim.r, new class_aco(class_acq.j, 1, 1), 0.15F);
		this.a(class_aim.s, new class_aco(class_acq.j, 1, 1), 0.15F);
		this.a(class_aim.bP, new class_aco(class_acq.bT), 1.0F);
		this.a(class_acq.bX, new class_aco(class_acq.bY), 0.35F);
		this.a(class_aim.aV, new class_aco(class_acq.ck), 0.1F);
		this.a(new class_aco(class_aim.v, 1, 1), new class_aco(class_aim.v, 1, 0), 0.15F);
		this.a(class_acq.cL, new class_aco(class_acq.cM), 0.1F);
		class_acf.class_a_in_class_acf[] var1 = class_acf.class_a_in_class_acf.values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_acf.class_a_in_class_acf var4 = var1[var3];
			if (var4.g()) {
				this.a(new class_aco(class_acq.aW, 1, var4.a()), new class_aco(class_acq.aX, 1, var4.a()), 0.35F);
			}
		}

		this.a(class_aim.q, new class_aco(class_acq.j), 0.1F);
		this.a(class_aim.aC, new class_aco(class_acq.aE), 0.7F);
		this.a(class_aim.x, new class_aco(class_acq.aY, 1, class_abt.l.b()), 0.2F);
		this.a(class_aim.co, new class_aco(class_acq.cl), 0.2F);
	}

	public void a(class_ail var1, class_aco var2, float var3) {
		this.a(class_acm.a(var1), var2, var3);
	}

	public void a(class_acm var1, class_aco var2, float var3) {
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
