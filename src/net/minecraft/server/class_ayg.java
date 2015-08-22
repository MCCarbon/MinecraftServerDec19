package net.minecraft.server;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class class_ayg implements Runnable {
	private static final class_ayg a = new class_ayg();
	private List b = Collections.synchronizedList(Lists.newArrayList());
	private volatile long c;
	private volatile long d;
	private volatile boolean e;

	private class_ayg() {
		Thread var1 = new Thread(this, "File IO Thread");
		var1.setPriority(1);
		var1.start();
	}

	public static class_ayg a() {
		return a;
	}

	@Override
	public void run() {
		while (true) {
			c();
		}
	}

	private void c() {
		for (int var1 = 0; var1 < b.size(); ++var1) {
			class_ayh var2 = (class_ayh) b.get(var1);
			boolean var3 = var2.c();
			if (!var3) {
				b.remove(var1--);
				++d;
			}

			try {
				Thread.sleep(e ? 0L : 10L);
			} catch (InterruptedException var6) {
				var6.printStackTrace();
			}
		}

		if (b.isEmpty()) {
			try {
				Thread.sleep(25L);
			} catch (InterruptedException var5) {
				var5.printStackTrace();
			}
		}

	}

	public void a(class_ayh var1) {
		if (!b.contains(var1)) {
			++c;
			b.add(var1);
		}
	}

	public void b() throws InterruptedException {
		e = true;

		while (c != d) {
			Thread.sleep(10L);
		}

		e = false;
	}
}
