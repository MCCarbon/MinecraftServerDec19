package net.minecraft.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_mu extends class_ms {
	private static final Logger h = LogManager.getLogger();
	private boolean i;
	private Socket j;
	private byte[] k = new byte[1460];
	private String l;

	class_mu(class_kp var1, Socket var2) {
		super(var1, "RCON Client");
		j = var2;

		try {
			j.setSoTimeout(0);
		} catch (Exception var4) {
			a = false;
		}

		l = var1.a("rcon.password", "");
		this.b("Rcon connection from: " + var2.getInetAddress());
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (!a) {
					break;
				}

				BufferedInputStream var1 = new BufferedInputStream(j.getInputStream());
				int var2 = var1.read(k, 0, 1460);
				if (10 > var2) {
					return;
				}

				byte var3 = 0;
				int var4 = class_mp.b(k, 0, var2);
				if (var4 == (var2 - 4)) {
					int var21 = var3 + 4;
					int var5 = class_mp.b(k, var21, var2);
					var21 += 4;
					int var6 = class_mp.b(k, var21);
					var21 += 4;
					switch (var6) {
						case 2:
							if (i) {
								String var8 = class_mp.a(k, var21, var2);

								try {
									this.a(var5, b.a_(var8));
								} catch (Exception var16) {
									this.a(var5, "Error executing: " + var8 + " (" + var16.getMessage() + ")");
								}
								continue;
							}

							f();
							continue;
						case 3:
							String var7 = class_mp.a(k, var21, var2);
							int var10000 = var21 + var7.length();
							if (!var7.isEmpty() && var7.equals(l)) {
								i = true;
								this.a(var5, 2, "");
								continue;
							}

							i = false;
							f();
							continue;
						default:
							this.a(var5, String.format("Unknown request %s", new Object[] { Integer.toHexString(var6) }));
							continue;
					}
				}
			} catch (SocketTimeoutException var17) {
				break;
			} catch (IOException var18) {
				break;
			} catch (Exception var19) {
				h.error("Exception whilst parsing RCON input", var19);
				break;
			} finally {
				g();
			}

			return;
		}

	}

	private void a(int var1, int var2, String var3) throws IOException {
		ByteArrayOutputStream var4 = new ByteArrayOutputStream(1248);
		DataOutputStream var5 = new DataOutputStream(var4);
		byte[] var6 = var3.getBytes("UTF-8");
		var5.writeInt(Integer.reverseBytes(var6.length + 10));
		var5.writeInt(Integer.reverseBytes(var1));
		var5.writeInt(Integer.reverseBytes(var2));
		var5.write(var6);
		var5.write(0);
		var5.write(0);
		j.getOutputStream().write(var4.toByteArray());
	}

	private void f() throws IOException {
		this.a(-1, 2, "");
	}

	private void a(int var1, String var2) throws IOException {
		int var3 = var2.length();

		do {
			int var4 = 4096 <= var3 ? 4096 : var3;
			this.a(var1, 0, var2.substring(0, var4));
			var2 = var2.substring(var4);
			var3 = var2.length();
		} while (0 != var3);

	}

	private void g() {
		if (null != j) {
			try {
				j.close();
			} catch (IOException var2) {
				this.c("IO: " + var2.getMessage());
			}

			j = null;
		}
	}
}
