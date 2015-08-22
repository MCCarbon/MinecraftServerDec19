package net.minecraft.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class class_mv extends class_ms {
	private int h;
	private int i;
	private String j;
	private ServerSocket k;
	private String l;
	private Map m;

	public class_mv(class_kp var1) {
		super(var1, "RCON Listener");
		h = var1.a("rcon.port", 0);
		l = var1.a("rcon.password", "");
		j = var1.G();
		i = var1.H();
		if (0 == h) {
			h = i + 10;
			this.b("Setting default rcon port to " + h);
			var1.a("rcon.port", Integer.valueOf(h));
			if (l.isEmpty()) {
				var1.a("rcon.password", (Object) "");
			}

			var1.a();
		}

		if (j.isEmpty()) {
			j = "0.0.0.0";
		}

		f();
		k = null;
	}

	private void f() {
		m = Maps.newHashMap();
	}

	private void g() {
		Iterator var1 = m.entrySet().iterator();

		while (var1.hasNext()) {
			Entry var2 = (Entry) var1.next();
			if (!((class_mu) var2.getValue()).c()) {
				var1.remove();
			}
		}

	}

	@Override
	public void run() {
		this.b("RCON running on " + j + ":" + h);

		try {
			while (a) {
				try {
					Socket var1 = k.accept();
					var1.setSoTimeout(500);
					class_mu var2 = new class_mu(b, var1);
					var2.a();
					m.put(var1.getRemoteSocketAddress(), var2);
					g();
				} catch (SocketTimeoutException var7) {
					g();
				} catch (IOException var8) {
					if (a) {
						this.b("IO: " + var8.getMessage());
					}
				}
			}
		} finally {
			this.b(k);
		}

	}

	@Override
	public void a() {
		if (l.isEmpty()) {
			this.c("No rcon password set in \'" + b.b() + "\', rcon disabled!");
		} else if ((0 < h) && ('\uffff' >= h)) {
			if (!a) {
				try {
					k = new ServerSocket(h, 0, InetAddress.getByName(j));
					k.setSoTimeout(500);
					super.a();
				} catch (IOException var2) {
					this.c("Unable to initialise rcon on " + j + ":" + h + " : " + var2.getMessage());
				}

			}
		} else {
			this.c("Invalid rcon port " + h + " found in \'" + b.b() + "\', rcon disabled!");
		}
	}
}
