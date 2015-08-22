package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_aye {
	private class_axu b;
	protected Map a = Maps.newHashMap();
	private List c = Lists.newArrayList();
	private Map d = Maps.newHashMap();

	public class_aye(class_axu var1) {
		b = var1;
		b();
	}

	public class_axj a(Class var1, String var2) {
		class_axj var3 = (class_axj) a.get(var2);
		if (var3 != null) {
			return var3;
		} else {
			if (b != null) {
				try {
					File var4 = b.a(var2);
					if ((var4 != null) && var4.exists()) {
						try {
							var3 = (class_axj) var1.getConstructor(new Class[] { String.class }).newInstance(new Object[] { var2 });
						} catch (Exception var7) {
							throw new RuntimeException("Failed to instantiate " + var1.toString(), var7);
						}

						FileInputStream var5 = new FileInputStream(var4);
						class_dn var6 = class_dx.a(var5);
						var5.close();
						var3.a(var6.o("data"));
					}
				} catch (Exception var8) {
					var8.printStackTrace();
				}
			}

			if (var3 != null) {
				a.put(var2, var3);
				c.add(var3);
			}

			return var3;
		}
	}

	public void a(String var1, class_axj var2) {
		if (a.containsKey(var1)) {
			c.remove(a.remove(var1));
		}

		a.put(var1, var2);
		c.add(var2);
	}

	public void a() {
		for (int var1 = 0; var1 < c.size(); ++var1) {
			class_axj var2 = (class_axj) c.get(var1);
			if (var2.d()) {
				this.a(var2);
				var2.a(false);
			}
		}

	}

	private void a(class_axj var1) {
		if (b != null) {
			try {
				File var2 = b.a(var1.a);
				if (var2 != null) {
					class_dn var3 = new class_dn();
					var1.b(var3);
					class_dn var4 = new class_dn();
					var4.a("data", var3);
					FileOutputStream var5 = new FileOutputStream(var2);
					class_dx.a(var4, var5);
					var5.close();
				}
			} catch (Exception var6) {
				var6.printStackTrace();
			}

		}
	}

	private void b() {
		try {
			d.clear();
			if (b == null) {
				return;
			}

			File var1 = b.a("idcounts");
			if ((var1 != null) && var1.exists()) {
				DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
				class_dn var3 = class_dx.a(var2);
				var2.close();
				Iterator var4 = var3.c().iterator();

				while (var4.hasNext()) {
					String var5 = (String) var4.next();
					class_eb var6 = var3.c(var5);
					if (var6 instanceof class_dz) {
						class_dz var7 = (class_dz) var6;
						short var9 = var7.e();
						d.put(var5, Short.valueOf(var9));
					}
				}
			}
		} catch (Exception var10) {
			var10.printStackTrace();
		}

	}

	public int a(String var1) {
		Short var2 = (Short) d.get(var1);
		if (var2 == null) {
			var2 = Short.valueOf((short) 0);
		} else {
			var2 = Short.valueOf((short) (var2.shortValue() + 1));
		}

		d.put(var1, var2);
		if (b == null) {
			return var2.shortValue();
		} else {
			try {
				File var3 = b.a("idcounts");
				if (var3 != null) {
					class_dn var4 = new class_dn();
					Iterator var5 = d.keySet().iterator();

					while (var5.hasNext()) {
						String var6 = (String) var5.next();
						short var7 = ((Short) d.get(var6)).shortValue();
						var4.a(var6, var7);
					}

					DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
					class_dx.a(var4, (DataOutput) var9);
					var9.close();
				}
			} catch (Exception var8) {
				var8.printStackTrace();
			}

			return var2.shortValue();
		}
	}
}
