package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public abstract class class_es implements IChatBaseComponent {
	protected List a = Lists.newArrayList();
	private class_ez b;

	@Override
	public IChatBaseComponent a(IChatBaseComponent var1) {
		var1.b().a(b());
		a.add(var1);
		return this;
	}

	@Override
	public List a() {
		return a;
	}

	@Override
	public IChatBaseComponent a(String var1) {
		return this.a((new class_fa(var1)));
	}

	@Override
	public IChatBaseComponent a(class_ez var1) {
		b = var1;
		Iterator var2 = a.iterator();

		while (var2.hasNext()) {
			IChatBaseComponent var3 = (IChatBaseComponent) var2.next();
			var3.b().a(b());
		}

		return this;
	}

	@Override
	public class_ez b() {
		if (b == null) {
			b = new class_ez();
			Iterator var1 = a.iterator();

			while (var1.hasNext()) {
				IChatBaseComponent var2 = (IChatBaseComponent) var1.next();
				var2.b().a(b);
			}
		}

		return b;
	}

	@Override
	public Iterator iterator() {
		return Iterators.concat(Iterators.forArray(new class_es[] { this }), a(a));
	}

	@Override
	public final String c() {
		StringBuilder var1 = new StringBuilder();
		Iterator var2 = iterator();

		while (var2.hasNext()) {
			IChatBaseComponent var3 = (IChatBaseComponent) var2.next();
			var1.append(var3.e());
		}

		return var1.toString();
	}

	public static Iterator a(Iterable var0) {
		Iterator var1 = Iterators.concat(Iterators.transform(var0.iterator(), new Function() {
			public Iterator a(IChatBaseComponent var1) {
				return var1.iterator();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((IChatBaseComponent) var1);
			}
		}));
		var1 = Iterators.transform(var1, new Function() {
			public IChatBaseComponent a(IChatBaseComponent var1) {
				IChatBaseComponent var2 = var1.f();
				var2.a(var2.b().n());
				return var2;
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((IChatBaseComponent) var1);
			}
		});
		return var1;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_es)) {
			return false;
		} else {
			class_es var2 = (class_es) var1;
			return a.equals(var2.a) && b().equals(var2.b());
		}
	}

	@Override
	public int hashCode() {
		return (31 * b.hashCode()) + a.hashCode();
	}

	@Override
	public String toString() {
		return "BaseComponent{style=" + b + ", siblings=" + a + '}';
	}
}
