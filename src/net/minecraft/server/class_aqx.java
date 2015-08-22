package net.minecraft.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import com.google.common.collect.Lists;

public class class_aqx {
	private static final byte[] a = new byte[4096];
	private final File b;
	private RandomAccessFile c;
	private final int[] d = new int[1024];
	private final int[] e = new int[1024];
	private List f;
	private int g;
	private long h;

	public class_aqx(File var1) {
		b = var1;
		g = 0;

		try {
			if (var1.exists()) {
				h = var1.lastModified();
			}

			c = new RandomAccessFile(var1, "rw");
			int var2;
			if (c.length() < 4096L) {
				for (var2 = 0; var2 < 1024; ++var2) {
					c.writeInt(0);
				}

				for (var2 = 0; var2 < 1024; ++var2) {
					c.writeInt(0);
				}

				g += 8192;
			}

			if ((c.length() & 4095L) != 0L) {
				for (var2 = 0; var2 < (c.length() & 4095L); ++var2) {
					c.write(0);
				}
			}

			var2 = (int) c.length() / 4096;
			f = Lists.newArrayListWithCapacity(var2);

			int var3;
			for (var3 = 0; var3 < var2; ++var3) {
				f.add(Boolean.valueOf(true));
			}

			f.set(0, Boolean.valueOf(false));
			f.set(1, Boolean.valueOf(false));
			c.seek(0L);

			int var4;
			for (var3 = 0; var3 < 1024; ++var3) {
				var4 = c.readInt();
				d[var3] = var4;
				if ((var4 != 0) && (((var4 >> 8) + (var4 & 255)) <= f.size())) {
					for (int var5 = 0; var5 < (var4 & 255); ++var5) {
						f.set((var4 >> 8) + var5, Boolean.valueOf(false));
					}
				}
			}

			for (var3 = 0; var3 < 1024; ++var3) {
				var4 = c.readInt();
				e[var3] = var4;
			}
		} catch (IOException var6) {
			var6.printStackTrace();
		}

	}

	public synchronized DataInputStream a(int var1, int var2) {
		if (d(var1, var2)) {
			return null;
		} else {
			try {
				int var3 = e(var1, var2);
				if (var3 == 0) {
					return null;
				} else {
					int var4 = var3 >> 8;
			int var5 = var3 & 255;
			if ((var4 + var5) > f.size()) {
				return null;
			} else {
				c.seek(var4 * 4096);
				int var6 = c.readInt();
				if (var6 > (4096 * var5)) {
					return null;
				} else if (var6 <= 0) {
					return null;
				} else {
					byte var7 = c.readByte();
					byte[] var8;
					if (var7 == 1) {
						var8 = new byte[var6 - 1];
						c.read(var8);
						return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(var8))));
					} else if (var7 == 2) {
						var8 = new byte[var6 - 1];
						c.read(var8);
						return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(var8))));
					} else {
						return null;
					}
				}
			}
				}
			} catch (IOException var9) {
				return null;
			}
		}
	}

	public DataOutputStream b(int var1, int var2) {
		return d(var1, var2) ? null : new DataOutputStream(new DeflaterOutputStream(new class_aqx.class_a_in_class_aqx(var1, var2)));
	}

	protected synchronized void a(int var1, int var2, byte[] var3, int var4) {
		try {
			int var5 = e(var1, var2);
			int var6 = var5 >> 8;
				int var7 = var5 & 255;
				int var8 = ((var4 + 5) / 4096) + 1;
				if (var8 >= 256) {
					return;
				}

				if ((var6 != 0) && (var7 == var8)) {
					this.a(var6, var3, var4);
				} else {
					int var9;
					for (var9 = 0; var9 < var7; ++var9) {
						f.set(var6 + var9, Boolean.valueOf(true));
					}

					var9 = f.indexOf(Boolean.valueOf(true));
					int var10 = 0;
					int var11;
					if (var9 != -1) {
						for (var11 = var9; var11 < f.size(); ++var11) {
							if (var10 != 0) {
								if (((Boolean) f.get(var11)).booleanValue()) {
									++var10;
								} else {
									var10 = 0;
								}
							} else if (((Boolean) f.get(var11)).booleanValue()) {
								var9 = var11;
								var10 = 1;
							}

							if (var10 >= var8) {
								break;
							}
						}
					}

					if (var10 >= var8) {
						var6 = var9;
						this.a(var1, var2, (var9 << 8) | var8);

						for (var11 = 0; var11 < var8; ++var11) {
							f.set(var6 + var11, Boolean.valueOf(false));
						}

						this.a(var6, var3, var4);
					} else {
						c.seek(c.length());
						var6 = f.size();

						for (var11 = 0; var11 < var8; ++var11) {
							c.write(a);
							f.add(Boolean.valueOf(false));
						}

						g += 4096 * var8;
						this.a(var6, var3, var4);
						this.a(var1, var2, (var6 << 8) | var8);
					}
				}

				this.b(var1, var2, (int) (MinecraftServer.aB() / 1000L));
		} catch (IOException var12) {
			var12.printStackTrace();
		}

	}

	private void a(int var1, byte[] var2, int var3) throws IOException {
		c.seek(var1 * 4096);
		c.writeInt(var3 + 1);
		c.writeByte(2);
		c.write(var2, 0, var3);
	}

	private boolean d(int var1, int var2) {
		return (var1 < 0) || (var1 >= 32) || (var2 < 0) || (var2 >= 32);
	}

	private int e(int var1, int var2) {
		return d[var1 + (var2 * 32)];
	}

	public boolean c(int var1, int var2) {
		return e(var1, var2) != 0;
	}

	private void a(int var1, int var2, int var3) throws IOException {
		d[var1 + (var2 * 32)] = var3;
		c.seek((var1 + (var2 * 32)) * 4);
		c.writeInt(var3);
	}

	private void b(int var1, int var2, int var3) throws IOException {
		e[var1 + (var2 * 32)] = var3;
		c.seek(4096 + ((var1 + (var2 * 32)) * 4));
		c.writeInt(var3);
	}

	public void c() throws IOException {
		if (c != null) {
			c.close();
		}

	}

	class class_a_in_class_aqx extends ByteArrayOutputStream {
		private int b;
		private int c;

		public class_a_in_class_aqx(int var2, int var3) {
			super(8096);
			b = var2;
			c = var3;
		}

		@Override
		public void close() {
			class_aqx.this.a(b, c, buf, count);
		}
	}
}
