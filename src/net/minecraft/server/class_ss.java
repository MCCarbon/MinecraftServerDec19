package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Sets;

public class class_ss {
	private static final Logger a = LogManager.getLogger();
	private final Set b = Sets.newLinkedHashSet();
	private final Set c = Sets.newLinkedHashSet();
	private final class_ob d;
	private int e;
	private int f = 3;

	public class_ss(class_ob var1) {
		d = var1;
	}

	public void a(int var1, class_sr var2) {
		b.add(new class_ss.class_a_in_class_ss(var1, var2));
	}

	public void a(class_sr var1) {
		Iterator var2 = b.iterator();

		class_ss.class_a_in_class_ss var3;
		class_sr var4;
		do {
			if (!var2.hasNext()) {
				return;
			}

			var3 = (class_ss.class_a_in_class_ss) var2.next();
			var4 = var3.a;
		} while (var4 != var1);

		if (var3.c) {
			var3.c = false;
			var3.a.d();
			c.remove(var3);
		}

		var2.remove();
	}

	public void a() {
		d.a("goalSetup");
		Iterator var1;
		class_ss.class_a_in_class_ss var2;
		if ((e++ % f) == 0) {
			var1 = b.iterator();

			label57: while (true) {
				do {
					while (true) {
						if (!var1.hasNext()) {
							break label57;
						}

						var2 = (class_ss.class_a_in_class_ss) var1.next();
						if (var2.c) {
							break;
						}

						if (b(var2) && var2.a.a()) {
							var2.c = true;
							var2.a.c();
							c.add(var2);
						}
					}
				} while (b(var2) && this.a(var2));

				var2.c = false;
				var2.a.d();
				c.remove(var2);
			}
		} else {
			var1 = c.iterator();

			while (var1.hasNext()) {
				var2 = (class_ss.class_a_in_class_ss) var1.next();
				if (!this.a(var2)) {
					var2.c = false;
					var2.a.d();
					var1.remove();
				}
			}
		}

		d.b();
		if (!c.isEmpty()) {
			d.a("goalTick");
			var1 = c.iterator();

			while (var1.hasNext()) {
				var2 = (class_ss.class_a_in_class_ss) var1.next();
				var2.a.e();
			}

			d.b();
		}

	}

	private boolean a(class_ss.class_a_in_class_ss var1) {
		return var1.a.b();
	}

	private boolean b(class_ss.class_a_in_class_ss var1) {
		Iterator var2 = b.iterator();

		while (var2.hasNext()) {
			class_ss.class_a_in_class_ss var3 = (class_ss.class_a_in_class_ss) var2.next();
			if (var3 != var1) {
				if (var1.b >= var3.b) {
					if (!this.a(var1, var3) && var3.c) {
						return false;
					}
				} else if (!var3.a.i() && var3.c) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean a(class_ss.class_a_in_class_ss var1, class_ss.class_a_in_class_ss var2) {
		return (var1.a.j() & var2.a.j()) == 0;
	}

	class class_a_in_class_ss {
		public final class_sr a;
		public final int b;
		public boolean c;

		public class_a_in_class_ss(int var2, class_sr var3) {
			b = var2;
			a = var3;
		}

		@Override
		public boolean equals(Object var1) {
			return this == var1 ? true : ((var1 != null) && (this.getClass() == var1.getClass()) ? a.equals(((class_ss.class_a_in_class_ss) var1).a) : false);
		}

		@Override
		public int hashCode() {
			return a.hashCode();
		}
	}
}
