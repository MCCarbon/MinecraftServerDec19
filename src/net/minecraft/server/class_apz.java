package net.minecraft.server;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class class_apz extends class_aqa {
	protected class_apz(String var1, Collection var2) {
		super(var1, class_cq.class, var2);
	}

	public static class_apz a(String var0) {
		return a(var0, Predicates.alwaysTrue());
	}

	public static class_apz a(String var0, Predicate var1) {
		return a(var0, Collections2.filter(Lists.newArrayList((Object[]) class_cq.values()), var1));
	}

	public static class_apz a(String var0, Collection var1) {
		return new class_apz(var0, var1);
	}
}
