package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

public abstract class class_apm implements class_apn {
	private static final Joiner a = Joiner.on(',');
	private static final Function b = new Function() {
		public String a(Entry var1) {
			if (var1 == null) {
				return "<NULL>";
			} else {
				class_aqc var2 = (class_aqc) var1.getKey();
				return var2.a() + "=" + var2.a((Comparable) var1.getValue());
			}
		}

		// $FF: synthetic method
		@Override
		public Object apply(Object var1) {
			return this.a((Entry) var1);
		}
	};

	@Override
	public class_apn a(class_aqc var1) {
		return this.a(var1, (Comparable) a(var1.c(), this.b(var1)));
	}

	protected static Object a(Collection var0, Object var1) {
		Iterator var2 = var0.iterator();

		do {
			if (!var2.hasNext()) {
				return var2.next();
			}
		} while (!var2.next().equals(var1));

		if (var2.hasNext()) {
			return var2.next();
		} else {
			return var0.iterator().next();
		}
	}

	@Override
	public String toString() {
		StringBuilder var1 = new StringBuilder();
		var1.append(Block.c.b(c()));
		if (!this.b().isEmpty()) {
			var1.append("[");
			a.appendTo(var1, Iterables.transform(this.b().entrySet(), b));
			var1.append("]");
		}

		return var1.toString();
	}
}
