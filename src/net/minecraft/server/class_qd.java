package net.minecraft.server;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import com.google.common.collect.Maps;

public class class_qd {
	private final Map a = Maps.newHashMap();
	private final Map b = Maps.newHashMap();
	private final String c = UUID.randomUUID().toString();
	private final URL d;
	private final class_qe e;
	private final Timer f = new Timer("Snooper Timer", true);
	private final Object g = new Object();
	private final long h;
	private boolean i;
	private int j;

	public class_qd(String var1, class_qe var2, long var3) {
		try {
			d = new URL("http://snoop.minecraft.net/" + var1 + "?version=" + 2);
		} catch (MalformedURLException var6) {
			throw new IllegalArgumentException();
		}

		e = var2;
		h = var3;
	}

	public void a() {
		if (!i) {
			i = true;
			h();
			f.schedule(new TimerTask() {
				@Override
				public void run() {
					if (e.af()) {
						HashMap var1;
						synchronized (g) {
							var1 = Maps.newHashMap(b);
							if (j == 0) {
								var1.putAll(a);
							}

							var1.put("snooper_count", Integer.valueOf(class_qd.f(class_qd.this)));
							var1.put("snooper_token", c);
						}

						class_nr.a(d, var1, true);
					}
				}
			}, 0L, 900000L);
		}
	}

	private void h() {
		i();
		this.a("snooper_token", c);
		this.b("snooper_token", c);
		this.b("os_name", System.getProperty("os.name"));
		this.b("os_version", System.getProperty("os.version"));
		this.b("os_architecture", System.getProperty("os.arch"));
		this.b("java_version", System.getProperty("java.version"));
		this.a("version", "15w34d");
		e.b(this);
	}

	private void i() {
		RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
		List var2 = var1.getInputArguments();
		int var3 = 0;
		Iterator var4 = var2.iterator();

		while (var4.hasNext()) {
			String var5 = (String) var4.next();
			if (var5.startsWith("-X")) {
				this.a("jvm_arg[" + var3++ + "]", var5);
			}
		}

		this.a("jvm_args", Integer.valueOf(var3));
	}

	public void b() {
		this.b("memory_total", Long.valueOf(Runtime.getRuntime().totalMemory()));
		this.b("memory_max", Long.valueOf(Runtime.getRuntime().maxMemory()));
		this.b("memory_free", Long.valueOf(Runtime.getRuntime().freeMemory()));
		this.b("cpu_cores", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
		e.a(this);
	}

	public void a(String var1, Object var2) {
		Object var3 = g;
		synchronized (g) {
			b.put(var1, var2);
		}
	}

	public void b(String var1, Object var2) {
		Object var3 = g;
		synchronized (g) {
			a.put(var1, var2);
		}
	}

	public boolean d() {
		return i;
	}

	public void e() {
		f.cancel();
	}

	public long g() {
		return h;
	}

	// $FF: synthetic method
	static int f(class_qd var0) {
		return var0.j++;
	}
}
