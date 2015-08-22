package net.minecraft.server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;

public abstract class class_ms implements Runnable {
	private static final AtomicInteger h = new AtomicInteger(0);
	protected boolean a;
	protected class_kp b;
	protected final String c;
	protected Thread d;
	protected int e = 5;
	protected List f = Lists.newArrayList();
	protected List g = Lists.newArrayList();

	protected class_ms(class_kp var1, String var2) {
		b = var1;
		c = var2;
		if (b.O()) {
			this.c("Debugging is enabled, performance maybe reduced!");
		}

	}

	public synchronized void a() {
		d = new Thread(this, c + " #" + h.incrementAndGet());
		d.start();
		a = true;
	}

	public boolean c() {
		return a;
	}

	protected void a(String var1) {
		b.h(var1);
	}

	protected void b(String var1) {
		b.e(var1);
	}

	protected void c(String var1) {
		b.f(var1);
	}

	protected void d(String var1) {
		b.g(var1);
	}

	protected int d() {
		return b.K();
	}

	protected void a(DatagramSocket var1) {
		this.a("registerSocket: " + var1);
		f.add(var1);
	}

	protected boolean a(DatagramSocket var1, boolean var2) {
		this.a("closeSocket: " + var1);
		if (null == var1) {
			return false;
		} else {
			boolean var3 = false;
			if (!var1.isClosed()) {
				var1.close();
				var3 = true;
			}

			if (var2) {
				f.remove(var1);
			}

			return var3;
		}
	}

	protected boolean b(ServerSocket var1) {
		return this.a(var1, true);
	}

	protected boolean a(ServerSocket var1, boolean var2) {
		this.a("closeSocket: " + var1);
		if (null == var1) {
			return false;
		} else {
			boolean var3 = false;

			try {
				if (!var1.isClosed()) {
					var1.close();
					var3 = true;
				}
			} catch (IOException var5) {
				this.c("IO: " + var5.getMessage());
			}

			if (var2) {
				g.remove(var1);
			}

			return var3;
		}
	}

	protected void e() {
		this.a(false);
	}

	protected void a(boolean var1) {
		int var2 = 0;
		Iterator var3 = f.iterator();

		while (var3.hasNext()) {
			DatagramSocket var4 = (DatagramSocket) var3.next();
			if (this.a(var4, false)) {
				++var2;
			}
		}

		f.clear();
		var3 = g.iterator();

		while (var3.hasNext()) {
			ServerSocket var5 = (ServerSocket) var3.next();
			if (this.a(var5, false)) {
				++var2;
			}
		}

		g.clear();
		if (var1 && (0 < var2)) {
			this.c("Force closed " + var2 + " sockets");
		}

	}
}
