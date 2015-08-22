package net.minecraft.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.collect.Maps;

public class class_mt extends class_ms {
	private long h;
	private int i;
	private int j;
	private int k;
	private String l;
	private String m;
	private DatagramSocket n;
	private byte[] o = new byte[1460];
	private DatagramPacket p;
	private Map q;
	private String r;
	private String s;
	private Map t;
	private long u;
	private class_mo v;
	private long w;

	public class_mt(class_kp var1) {
		super(var1, "Query Listener");
		i = var1.a("query.port", 0);
		s = var1.G();
		j = var1.H();
		l = var1.I();
		k = var1.L();
		m = var1.W();
		w = 0L;
		r = "0.0.0.0";
		if (!s.isEmpty() && !r.equals(s)) {
			r = s;
		} else {
			s = "0.0.0.0";

			try {
				InetAddress var2 = InetAddress.getLocalHost();
				r = var2.getHostAddress();
			} catch (UnknownHostException var3) {
				this.c("Unable to determine local host IP, please set server-ip in \'" + var1.b() + "\' : " + var3.getMessage());
			}
		}

		if (0 == i) {
			i = j;
			this.b("Setting default query port to " + i);
			var1.a("query.port", Integer.valueOf(i));
			var1.a("debug", Boolean.valueOf(false));
			var1.a();
		}

		q = Maps.newHashMap();
		v = new class_mo(1460);
		t = Maps.newHashMap();
		u = (new Date()).getTime();
	}

	private void a(byte[] var1, DatagramPacket var2) throws IOException {
		n.send(new DatagramPacket(var1, var1.length, var2.getSocketAddress()));
	}

	private boolean a(DatagramPacket var1) throws IOException {
		byte[] var2 = var1.getData();
		int var3 = var1.getLength();
		SocketAddress var4 = var1.getSocketAddress();
		this.a("Packet len " + var3 + " [" + var4 + "]");
		if ((3 <= var3) && (-2 == var2[0]) && (-3 == var2[1])) {
			this.a("Packet \'" + class_mp.a(var2[2]) + "\' [" + var4 + "]");
			switch (var2[2]) {
				case 0:
					if (!this.c(var1).booleanValue()) {
						this.a("Invalid challenge [" + var4 + "]");
						return false;
					} else if (15 == var3) {
						this.a(this.b(var1), var1);
						this.a("Rules [" + var4 + "]");
					} else {
						class_mo var5 = new class_mo(1460);
						var5.a(0);
						var5.a(this.a(var1.getSocketAddress()));
						var5.a(l);
						var5.a("SMP");
						var5.a(m);
						var5.a(Integer.toString(this.d()));
						var5.a(Integer.toString(k));
						var5.a((short) j);
						var5.a(r);
						this.a(var5.a(), var1);
						this.a("Status [" + var4 + "]");
					}
				default:
					return true;
				case 9:
					this.d(var1);
					this.a("Challenge [" + var4 + "]");
					return true;
			}
		} else {
			this.a("Invalid packet [" + var4 + "]");
			return false;
		}
	}

	private byte[] b(DatagramPacket var1) throws IOException {
		long var2 = MinecraftServer.aB();
		if (var2 < (w + 5000L)) {
			byte[] var9 = v.a();
			byte[] var10 = this.a(var1.getSocketAddress());
			var9[1] = var10[0];
			var9[2] = var10[1];
			var9[3] = var10[2];
			var9[4] = var10[3];
			return var9;
		} else {
			w = var2;
			v.b();
			v.a(0);
			v.a(this.a(var1.getSocketAddress()));
			v.a("splitnum");
			v.a(128);
			v.a(0);
			v.a("hostname");
			v.a(l);
			v.a("gametype");
			v.a("SMP");
			v.a("game_id");
			v.a("MINECRAFT");
			v.a("version");
			v.a(b.J());
			v.a("plugins");
			v.a(b.d_());
			v.a("map");
			v.a(m);
			v.a("numplayers");
			v.a("" + this.d());
			v.a("maxplayers");
			v.a("" + k);
			v.a("hostport");
			v.a("" + j);
			v.a("hostip");
			v.a(r);
			v.a(0);
			v.a(1);
			v.a("player_");
			v.a(0);
			String[] var4 = b.M();
			String[] var5 = var4;
			int var6 = var4.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				String var8 = var5[var7];
				v.a(var8);
			}

			v.a(0);
			return v.a();
		}
	}

	private byte[] a(SocketAddress var1) {
		return ((class_mt.class_a_in_class_mt) t.get(var1)).c();
	}

	private Boolean c(DatagramPacket var1) {
		SocketAddress var2 = var1.getSocketAddress();
		if (!t.containsKey(var2)) {
			return Boolean.valueOf(false);
		} else {
			byte[] var3 = var1.getData();
			return ((class_mt.class_a_in_class_mt) t.get(var2)).a() != class_mp.c(var3, 7, var1.getLength()) ? Boolean.valueOf(false) : Boolean.valueOf(true);
		}
	}

	private void d(DatagramPacket var1) throws IOException {
		class_mt.class_a_in_class_mt var2 = new class_mt.class_a_in_class_mt(var1);
		t.put(var1.getSocketAddress(), var2);
		this.a(var2.b(), var1);
	}

	private void f() {
		if (a) {
			long var1 = MinecraftServer.aB();
			if (var1 >= (h + 30000L)) {
				h = var1;
				Iterator var3 = t.entrySet().iterator();

				while (var3.hasNext()) {
					Entry var4 = (Entry) var3.next();
					if (((class_mt.class_a_in_class_mt) var4.getValue()).a(var1).booleanValue()) {
						var3.remove();
					}
				}

			}
		}
	}

	@Override
	public void run() {
		this.b("Query running on " + s + ":" + i);
		h = MinecraftServer.aB();
		p = new DatagramPacket(o, o.length);

		try {
			while (a) {
				try {
					n.receive(p);
					f();
					this.a(p);
				} catch (SocketTimeoutException var7) {
					f();
				} catch (PortUnreachableException var8) {
					;
				} catch (IOException var9) {
					this.a(var9);
				}
			}
		} finally {
			e();
		}

	}

	@Override
	public void a() {
		if (!a) {
			if ((0 < i) && ('\uffff' >= i)) {
				if (g()) {
					super.a();
				}

			} else {
				this.c("Invalid query port " + i + " found in \'" + b.b() + "\' (queries disabled)");
			}
		}
	}

	private void a(Exception var1) {
		if (a) {
			this.c("Unexpected exception, buggy JRE? (" + var1.toString() + ")");
			if (!g()) {
				this.d("Failed to recover from buggy JRE, shutting down!");
				a = false;
			}

		}
	}

	private boolean g() {
		try {
			n = new DatagramSocket(i, InetAddress.getByName(s));
			this.a(n);
			n.setSoTimeout(500);
			return true;
		} catch (SocketException var2) {
			this.c("Unable to initialise query system on " + s + ":" + i + " (Socket): " + var2.getMessage());
		} catch (UnknownHostException var3) {
			this.c("Unable to initialise query system on " + s + ":" + i + " (Unknown Host): " + var3.getMessage());
		} catch (Exception var4) {
			this.c("Unable to initialise query system on " + s + ":" + i + " (E): " + var4.getMessage());
		}

		return false;
	}

	class class_a_in_class_mt {
		private long b = (new Date()).getTime();
		private int c;
		private byte[] d;
		private byte[] e;
		private String f;

		public class_a_in_class_mt(DatagramPacket var2) {
			byte[] var3 = var2.getData();
			d = new byte[4];
			d[0] = var3[3];
			d[1] = var3[4];
			d[2] = var3[5];
			d[3] = var3[6];
			f = new String(d);
			c = (new Random()).nextInt(16777216);
			e = String.format("\t%s%d\u0000", new Object[] { f, Integer.valueOf(c) }).getBytes();
		}

		public Boolean a(long var1) {
			return Boolean.valueOf(b < var1);
		}

		public int a() {
			return c;
		}

		public byte[] b() {
			return e;
		}

		public byte[] c() {
			return d;
		}
	}
}
