package net.minecraft.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum class_ard {
	a(0, "Overworld", "", class_arf.class),
	b(-1, "Nether", "_nether", class_are.class),
	c(1, "The End", "_end", class_arh.class);

	private final int d;
	private final String e;
	private final String f;
	private final Class g;

	private class_ard(int var3, String var4, String var5, Class var6) {
		d = var3;
		e = var4;
		f = var5;
		g = var6;
	}

	public int a() {
		return d;
	}

	public String b() {
		return e;
	}

	public String c() {
		return f;
	}

	public class_arc d() {
		try {
			Constructor var1 = g.getConstructor(new Class[0]);
			return (class_arc) var1.newInstance(new Object[0]);
		} catch (NoSuchMethodException var2) {
			throw new Error("Could not create new dimension", var2);
		} catch (InvocationTargetException var3) {
			throw new Error("Could not create new dimension", var3);
		} catch (InstantiationException var4) {
			throw new Error("Could not create new dimension", var4);
		} catch (IllegalAccessException var5) {
			throw new Error("Could not create new dimension", var5);
		}
	}

	public static class_ard a(int var0) {
		class_ard[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_ard var4 = var1[var3];
			if (var4.a() == var0) {
				return var4;
			}
		}

		throw new IllegalArgumentException("Invalid dimension id " + var0);
	}
}
