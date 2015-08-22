package net.minecraft.server;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

public class class_rw extends class_rt {
	private final Set e = Sets.newHashSet();
	protected final Map d = new class_ns();

	public class_rv e(class_rp var1) {
		return (class_rv) super.a(var1);
	}

	public class_rv b(String var1) {
		class_rq var2 = super.a(var1);
		if (var2 == null) {
			var2 = (class_rq) d.get(var1);
		}

		return (class_rv) var2;
	}

	@Override
	public class_rq b(class_rp var1) {
		class_rq var2 = super.b(var1);
		if ((var1 instanceof class_rx) && (((class_rx) var1).g() != null)) {
			d.put(((class_rx) var1).g(), var2);
		}

		return var2;
	}

	@Override
	protected class_rq c(class_rp var1) {
		return new class_rv(this, var1);
	}

	@Override
	public void a(class_rq var1) {
		if (var1.a().c()) {
			e.add(var1);
		}

		Iterator var2 = c.get(var1.a()).iterator();

		while (var2.hasNext()) {
			class_rp var3 = (class_rp) var2.next();
			class_rv var4 = e(var3);
			if (var4 != null) {
				var4.f();
			}
		}

	}

	public Set b() {
		return e;
	}

	public Collection c() {
		HashSet var1 = Sets.newHashSet();
		Iterator var2 = this.a().iterator();

		while (var2.hasNext()) {
			class_rq var3 = (class_rq) var2.next();
			if (var3.a().c()) {
				var1.add(var3);
			}
		}

		return var1;
	}

	// $FF: synthetic method
	@Override
	public class_rq a(String var1) {
		return this.b(var1);
	}

	// $FF: synthetic method
	@Override
	public class_rq a(class_rp var1) {
		return e(var1);
	}
}
