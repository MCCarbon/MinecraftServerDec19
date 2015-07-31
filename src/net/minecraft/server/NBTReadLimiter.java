package net.minecraft.server;

public class NBTReadLimiter {

	public static final NBTReadLimiter UNLIMITED = new NBTReadLimiter(0L) {
		public void read(long var1) {
		}
	};

	private final long limit;
	private long current;

	public NBTReadLimiter(long limit) {
		this.limit = limit;
	}

	public void read(long var1) {
		this.current += var1 / 8L;
		if (this.current > this.limit) {
			throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.current + "bytes where max allowed: " + this.limit);
		}
	}

}
