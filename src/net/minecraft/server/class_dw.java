package net.minecraft.server;

public class class_dw {
	public static final class_dw a = new class_dw(0L) {
		@Override
		public void a(long var1) {
		}
	};
	private final long b;
	private long c;

	public class_dw(long var1) {
		b = var1;
	}

	public void a(long var1) {
		c += var1 / 8L;
		if (c > b) {
			throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + c + "bytes where max allowed: " + b);
		}
	}
}
