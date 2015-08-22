package net.minecraft.server;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_oo implements class_on {
	private static final Logger a = LogManager.getLogger();
	private final Map b = Maps.newHashMap();
	private final Map c = Maps.newHashMap();
	private final int d;

	public class_oo(int var1) {
		d = var1;
	}

	public class_dn a(class_ol var1, class_dn var2) {
		int var3 = var2.b("DataVersion", 99) ? var2.h("DataVersion") : -1;
		return var3 >= 117 ? var2 : this.a(var1, var2, var3);
	}

	@Override
	public class_dn a(class_ol var1, class_dn var2, int var3) {
		if (var3 < d) {
			var2 = b(var1, var2, var3);
			var2 = c(var1, var2, var3);
		}

		return var2;
	}

	private class_dn b(class_ol var1, class_dn var2, int var3) {
		List var4 = (List) c.get(var1);
		if (var4 != null) {
			for (int var5 = 0; var5 < var4.size(); ++var5) {
				class_ok var6 = (class_ok) var4.get(var5);
				if (var6.a() > var3) {
					var2 = var6.a(var2);
				}
			}
		}

		return var2;
	}

	private class_dn c(class_ol var1, class_dn var2, int var3) {
		List var4 = (List) b.get(var1);
		if (var4 != null) {
			for (int var5 = 0; var5 < var4.size(); ++var5) {
				var2 = ((class_oq) var4.get(var5)).a(this, var2, var3);
			}
		}

		return var2;
	}

	public void a(class_om var1, class_oq var2) {
		this.a((class_ol) var1, var2);
	}

	public void a(class_ol var1, class_oq var2) {
		this.a(b, var1).add(var2);
	}

	public void a(class_ol var1, class_ok var2) {
		List var3 = this.a(c, var1);
		int var4 = var2.a();
		if (var4 > d) {
			a.warn("Ignored fix registered for version: {} as the DataVersion of the game is: {}", new Object[] { Integer.valueOf(var4), Integer.valueOf(d) });
		} else {
			if (!var3.isEmpty() && (((class_ok) class_g.a(var3)).a() > var4)) {
				for (int var5 = 0; var5 < var3.size(); ++var5) {
					if (((class_ok) var3.get(var5)).a() > var4) {
						var3.add(var5, var2);
						break;
					}
				}
			} else {
				var3.add(var2);
			}

		}
	}

	private List a(Map var1, class_ol var2) {
		Object var3 = var1.get(var2);
		if (var3 == null) {
			var3 = Lists.newArrayList();
			var1.put(var2, var3);
		}

		return (List) var3;
	}
}
