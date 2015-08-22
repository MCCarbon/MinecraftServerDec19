package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public abstract class class_aus {
	protected List a = Lists.newLinkedList();
	protected class_aua b;
	private int c;
	private int d;

	public class_aus() {
	}

	public class_aus(int var1, int var2) {
		c = var1;
		d = var2;
	}

	public class_aua b() {
		return b;
	}

	public List c() {
		return a;
	}

	public void a(class_ago var1, Random var2, class_aua var3) {
		Iterator var4 = a.iterator();

		while (var4.hasNext()) {
			class_aur var5 = (class_aur) var4.next();
			if (var5.c().a(var3) && !var5.a(var1, var2, var3)) {
				var4.remove();
			}
		}

	}

	protected void d() {
		b = class_aua.a();
		Iterator var1 = a.iterator();

		while (var1.hasNext()) {
			class_aur var2 = (class_aur) var1.next();
			b.b(var2.c());
		}

	}

	public class_dn a(int var1, int var2) {
		class_dn var3 = new class_dn();
		var3.a("id", class_aup.a(this));
		var3.a("ChunkX", var1);
		var3.a("ChunkZ", var2);
		var3.a("BB", b.g());
		class_du var4 = new class_du();
		Iterator var5 = a.iterator();

		while (var5.hasNext()) {
			class_aur var6 = (class_aur) var5.next();
			var4.a(var6.b());
		}

		var3.a("Children", var4);
		this.a(var3);
		return var3;
	}

	public void a(class_dn var1) {
	}

	public void a(class_ago var1, class_dn var2) {
		c = var2.h("ChunkX");
		d = var2.h("ChunkZ");
		if (var2.e("BB")) {
			b = new class_aua(var2.n("BB"));
		}

		class_du var3 = var2.c("Children", 10);

		for (int var4 = 0; var4 < var3.c(); ++var4) {
			a.add(class_aup.b(var3.b(var4), var1));
		}

		this.b(var2);
	}

	public void b(class_dn var1) {
	}

	protected void a(class_ago var1, Random var2, int var3) {
		int var4 = var1.H() - var3;
		int var5 = b.d() + 1;
		if (var5 < var4) {
			var5 += var2.nextInt(var4 - var5);
		}

		int var6 = var5 - b.e;
		b.a(0, var6, 0);
		Iterator var7 = a.iterator();

		while (var7.hasNext()) {
			class_aur var8 = (class_aur) var7.next();
			var8.a(0, var6, 0);
		}

	}

	protected void a(class_ago var1, Random var2, int var3, int var4) {
		int var5 = ((var4 - var3) + 1) - b.d();
		boolean var6 = true;
		int var10;
		if (var5 > 1) {
			var10 = var3 + var2.nextInt(var5);
		} else {
			var10 = var3;
		}

		int var7 = var10 - b.b;
		b.a(0, var7, 0);
		Iterator var8 = a.iterator();

		while (var8.hasNext()) {
			class_aur var9 = (class_aur) var8.next();
			var9.a(0, var7, 0);
		}

	}

	public boolean a() {
		return true;
	}

	public boolean a(class_agi var1) {
		return true;
	}

	public void b(class_agi var1) {
	}

	public int e() {
		return c;
	}

	public int f() {
		return d;
	}
}
