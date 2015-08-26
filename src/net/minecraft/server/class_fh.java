package net.minecraft.server;


public class class_fh {
	public static void a(final Packet var0, final PacketListener var1, class_pl var2) throws class_ko {
		if (!var2.aL()) {
			var2.a(new Runnable() {
				@Override
				public void run() {
					var0.handle(var1);
				}
			});
			throw class_ko.a;
		}
	}
}
