package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class class_cx extends class_dd implements class_cs {
	protected final class_ct a = new class_ct();
	protected final Map b;

	public class_cx() {
		b = ((BiMap) c).inverse();
	}

	public void a(int var1, Object var2, Object var3) {
		a.a(var3, var1);
		this.a(var2, var3);
	}

	@Override
	protected Map b() {
		return HashBiMap.create();
	}

	@Override
	public Object c(Object var1) {
		return super.c(var1);
	}

	public Object b(Object var1) {
		return b.get(var1);
	}

	@Override
	public boolean d(Object var1) {
		return super.d(var1);
	}

	public int a(Object var1) {
		return a.a(var1);
	}

	public Object a(int var1) {
		return a.a(var1);
	}

	@Override
	public Iterator iterator() {
		return a.iterator();
	}
}
