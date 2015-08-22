package net.minecraft.server;


public class class_fh {
	public static void a(final class_ff var0, final class_ep var1, class_pl var2) throws class_ko {
		if (!var2.aL()) {
			var2.a(new Runnable() {
				@Override
				public void run() {
					var0.a(var1);
				}
			});
			throw class_ko.a;
		}
	}
}
