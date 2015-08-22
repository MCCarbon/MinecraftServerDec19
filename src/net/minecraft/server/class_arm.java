package net.minecraft.server;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class class_arm {
	public final float a;
	public final float b;
	public final float c;
	public final float d;
	public final float e;
	public final float f;
	public final float g;
	public final float h;
	public final float i;
	public final float j;
	public final float k;
	public final float l;
	public final float m;
	public final float n;
	public final float o;
	public final float p;
	public final int q;
	public final boolean r;
	public final boolean s;
	public final int t;
	public final boolean u;
	public final boolean v;
	public final boolean w;
	public final boolean x;
	public final boolean y;
	public final boolean z;
	public final boolean A;
	public final int B;
	public final boolean C;
	public final int D;
	public final boolean E;
	public final int F;
	public final int G;
	public final int H;
	public final int I;
	public final int J;
	public final int K;
	public final int L;
	public final int M;
	public final int N;
	public final int O;
	public final int P;
	public final int Q;
	public final int R;
	public final int S;
	public final int T;
	public final int U;
	public final int V;
	public final int W;
	public final int X;
	public final int Y;
	public final int Z;
	public final int aa;
	public final int ab;
	public final int ac;
	public final int ad;
	public final int ae;
	public final int af;
	public final int ag;
	public final int ah;
	public final int ai;
	public final int aj;
	public final int ak;
	public final int al;
	public final int am;
	public final int an;
	public final int ao;
	public final int ap;
	public final int aq;
	public final int ar;
	public final int as;
	public final int at;
	public final int au;
	public final int av;
	public final int aw;
	public final int ax;
	public final int ay;
	public final int az;

	private class_arm(class_arm.class_a_in_class_arm var1) {
		a = var1.b;
		b = var1.c;
		c = var1.d;
		d = var1.e;
		e = var1.f;
		f = var1.g;
		g = var1.h;
		h = var1.i;
		i = var1.j;
		j = var1.k;
		k = var1.l;
		l = var1.m;
		m = var1.n;
		n = var1.o;
		o = var1.p;
		p = var1.q;
		q = var1.r;
		r = var1.s;
		s = var1.t;
		t = var1.u;
		u = var1.v;
		v = var1.w;
		w = var1.x;
		x = var1.y;
		y = var1.z;
		z = var1.A;
		A = var1.B;
		B = var1.C;
		C = var1.D;
		D = var1.E;
		E = var1.F;
		F = var1.G;
		G = var1.H;
		H = var1.I;
		I = var1.J;
		J = var1.K;
		K = var1.L;
		L = var1.M;
		M = var1.N;
		N = var1.O;
		O = var1.P;
		P = var1.Q;
		Q = var1.R;
		R = var1.S;
		S = var1.T;
		T = var1.U;
		U = var1.V;
		V = var1.W;
		W = var1.X;
		X = var1.Y;
		Y = var1.Z;
		Z = var1.aa;
		aa = var1.ab;
		ab = var1.ac;
		ac = var1.ad;
		ad = var1.ae;
		ae = var1.af;
		af = var1.ag;
		ag = var1.ah;
		ah = var1.ai;
		ai = var1.aj;
		aj = var1.ak;
		ak = var1.al;
		al = var1.am;
		am = var1.an;
		an = var1.ao;
		ao = var1.ap;
		ap = var1.aq;
		aq = var1.ar;
		ar = var1.as;
		as = var1.at;
		at = var1.au;
		au = var1.av;
		av = var1.aw;
		aw = var1.ax;
		ax = var1.ay;
		ay = var1.az;
		az = var1.aA;
	}

	// $FF: synthetic method
	class_arm(class_arm.class_a_in_class_arm var1, class_arm.SyntheticClass_1 var2) {
		this(var1);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	public static class class_b_in_class_arm implements JsonDeserializer, JsonSerializer {
		public class_arm.class_a_in_class_arm a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			JsonObject var4 = var1.getAsJsonObject();
			class_arm.class_a_in_class_arm var5 = new class_arm.class_a_in_class_arm();

			try {
				var5.b = class_nq.a(var4, "coordinateScale", var5.b);
				var5.c = class_nq.a(var4, "heightScale", var5.c);
				var5.e = class_nq.a(var4, "lowerLimitScale", var5.e);
				var5.d = class_nq.a(var4, "upperLimitScale", var5.d);
				var5.f = class_nq.a(var4, "depthNoiseScaleX", var5.f);
				var5.g = class_nq.a(var4, "depthNoiseScaleZ", var5.g);
				var5.h = class_nq.a(var4, "depthNoiseScaleExponent", var5.h);
				var5.i = class_nq.a(var4, "mainNoiseScaleX", var5.i);
				var5.j = class_nq.a(var4, "mainNoiseScaleY", var5.j);
				var5.k = class_nq.a(var4, "mainNoiseScaleZ", var5.k);
				var5.l = class_nq.a(var4, "baseSize", var5.l);
				var5.m = class_nq.a(var4, "stretchY", var5.m);
				var5.n = class_nq.a(var4, "biomeDepthWeight", var5.n);
				var5.o = class_nq.a(var4, "biomeDepthOffset", var5.o);
				var5.p = class_nq.a(var4, "biomeScaleWeight", var5.p);
				var5.q = class_nq.a(var4, "biomeScaleOffset", var5.q);
				var5.r = class_nq.a(var4, "seaLevel", var5.r);
				var5.s = class_nq.a(var4, "useCaves", var5.s);
				var5.t = class_nq.a(var4, "useDungeons", var5.t);
				var5.u = class_nq.a(var4, "dungeonChance", var5.u);
				var5.v = class_nq.a(var4, "useStrongholds", var5.v);
				var5.w = class_nq.a(var4, "useVillages", var5.w);
				var5.x = class_nq.a(var4, "useMineShafts", var5.x);
				var5.y = class_nq.a(var4, "useTemples", var5.y);
				var5.z = class_nq.a(var4, "useMonuments", var5.z);
				var5.A = class_nq.a(var4, "useRavines", var5.A);
				var5.B = class_nq.a(var4, "useWaterLakes", var5.B);
				var5.C = class_nq.a(var4, "waterLakeChance", var5.C);
				var5.D = class_nq.a(var4, "useLavaLakes", var5.D);
				var5.E = class_nq.a(var4, "lavaLakeChance", var5.E);
				var5.F = class_nq.a(var4, "useLavaOceans", var5.F);
				var5.G = class_nq.a(var4, "fixedBiome", var5.G);
				if ((var5.G < 38) && (var5.G >= -1)) {
					if (var5.G >= class_ahb.x.az) {
						var5.G += 2;
					}
				} else {
					var5.G = -1;
				}

				var5.H = class_nq.a(var4, "biomeSize", var5.H);
				var5.I = class_nq.a(var4, "riverSize", var5.I);
				var5.J = class_nq.a(var4, "dirtSize", var5.J);
				var5.K = class_nq.a(var4, "dirtCount", var5.K);
				var5.L = class_nq.a(var4, "dirtMinHeight", var5.L);
				var5.M = class_nq.a(var4, "dirtMaxHeight", var5.M);
				var5.N = class_nq.a(var4, "gravelSize", var5.N);
				var5.O = class_nq.a(var4, "gravelCount", var5.O);
				var5.P = class_nq.a(var4, "gravelMinHeight", var5.P);
				var5.Q = class_nq.a(var4, "gravelMaxHeight", var5.Q);
				var5.R = class_nq.a(var4, "graniteSize", var5.R);
				var5.S = class_nq.a(var4, "graniteCount", var5.S);
				var5.T = class_nq.a(var4, "graniteMinHeight", var5.T);
				var5.U = class_nq.a(var4, "graniteMaxHeight", var5.U);
				var5.V = class_nq.a(var4, "dioriteSize", var5.V);
				var5.W = class_nq.a(var4, "dioriteCount", var5.W);
				var5.X = class_nq.a(var4, "dioriteMinHeight", var5.X);
				var5.Y = class_nq.a(var4, "dioriteMaxHeight", var5.Y);
				var5.Z = class_nq.a(var4, "andesiteSize", var5.Z);
				var5.aa = class_nq.a(var4, "andesiteCount", var5.aa);
				var5.ab = class_nq.a(var4, "andesiteMinHeight", var5.ab);
				var5.ac = class_nq.a(var4, "andesiteMaxHeight", var5.ac);
				var5.ad = class_nq.a(var4, "coalSize", var5.ad);
				var5.ae = class_nq.a(var4, "coalCount", var5.ae);
				var5.af = class_nq.a(var4, "coalMinHeight", var5.af);
				var5.ag = class_nq.a(var4, "coalMaxHeight", var5.ag);
				var5.ah = class_nq.a(var4, "ironSize", var5.ah);
				var5.ai = class_nq.a(var4, "ironCount", var5.ai);
				var5.aj = class_nq.a(var4, "ironMinHeight", var5.aj);
				var5.ak = class_nq.a(var4, "ironMaxHeight", var5.ak);
				var5.al = class_nq.a(var4, "goldSize", var5.al);
				var5.am = class_nq.a(var4, "goldCount", var5.am);
				var5.an = class_nq.a(var4, "goldMinHeight", var5.an);
				var5.ao = class_nq.a(var4, "goldMaxHeight", var5.ao);
				var5.ap = class_nq.a(var4, "redstoneSize", var5.ap);
				var5.aq = class_nq.a(var4, "redstoneCount", var5.aq);
				var5.ar = class_nq.a(var4, "redstoneMinHeight", var5.ar);
				var5.as = class_nq.a(var4, "redstoneMaxHeight", var5.as);
				var5.at = class_nq.a(var4, "diamondSize", var5.at);
				var5.au = class_nq.a(var4, "diamondCount", var5.au);
				var5.av = class_nq.a(var4, "diamondMinHeight", var5.av);
				var5.aw = class_nq.a(var4, "diamondMaxHeight", var5.aw);
				var5.ax = class_nq.a(var4, "lapisSize", var5.ax);
				var5.ay = class_nq.a(var4, "lapisCount", var5.ay);
				var5.az = class_nq.a(var4, "lapisCenterHeight", var5.az);
				var5.aA = class_nq.a(var4, "lapisSpread", var5.aA);
			} catch (Exception var7) {
				;
			}

			return var5;
		}

		public JsonElement a(class_arm.class_a_in_class_arm var1, Type var2, JsonSerializationContext var3) {
			JsonObject var4 = new JsonObject();
			var4.addProperty("coordinateScale", Float.valueOf(var1.b));
			var4.addProperty("heightScale", Float.valueOf(var1.c));
			var4.addProperty("lowerLimitScale", Float.valueOf(var1.e));
			var4.addProperty("upperLimitScale", Float.valueOf(var1.d));
			var4.addProperty("depthNoiseScaleX", Float.valueOf(var1.f));
			var4.addProperty("depthNoiseScaleZ", Float.valueOf(var1.g));
			var4.addProperty("depthNoiseScaleExponent", Float.valueOf(var1.h));
			var4.addProperty("mainNoiseScaleX", Float.valueOf(var1.i));
			var4.addProperty("mainNoiseScaleY", Float.valueOf(var1.j));
			var4.addProperty("mainNoiseScaleZ", Float.valueOf(var1.k));
			var4.addProperty("baseSize", Float.valueOf(var1.l));
			var4.addProperty("stretchY", Float.valueOf(var1.m));
			var4.addProperty("biomeDepthWeight", Float.valueOf(var1.n));
			var4.addProperty("biomeDepthOffset", Float.valueOf(var1.o));
			var4.addProperty("biomeScaleWeight", Float.valueOf(var1.p));
			var4.addProperty("biomeScaleOffset", Float.valueOf(var1.q));
			var4.addProperty("seaLevel", Integer.valueOf(var1.r));
			var4.addProperty("useCaves", Boolean.valueOf(var1.s));
			var4.addProperty("useDungeons", Boolean.valueOf(var1.t));
			var4.addProperty("dungeonChance", Integer.valueOf(var1.u));
			var4.addProperty("useStrongholds", Boolean.valueOf(var1.v));
			var4.addProperty("useVillages", Boolean.valueOf(var1.w));
			var4.addProperty("useMineShafts", Boolean.valueOf(var1.x));
			var4.addProperty("useTemples", Boolean.valueOf(var1.y));
			var4.addProperty("useMonuments", Boolean.valueOf(var1.z));
			var4.addProperty("useRavines", Boolean.valueOf(var1.A));
			var4.addProperty("useWaterLakes", Boolean.valueOf(var1.B));
			var4.addProperty("waterLakeChance", Integer.valueOf(var1.C));
			var4.addProperty("useLavaLakes", Boolean.valueOf(var1.D));
			var4.addProperty("lavaLakeChance", Integer.valueOf(var1.E));
			var4.addProperty("useLavaOceans", Boolean.valueOf(var1.F));
			var4.addProperty("fixedBiome", Integer.valueOf(var1.G));
			var4.addProperty("biomeSize", Integer.valueOf(var1.H));
			var4.addProperty("riverSize", Integer.valueOf(var1.I));
			var4.addProperty("dirtSize", Integer.valueOf(var1.J));
			var4.addProperty("dirtCount", Integer.valueOf(var1.K));
			var4.addProperty("dirtMinHeight", Integer.valueOf(var1.L));
			var4.addProperty("dirtMaxHeight", Integer.valueOf(var1.M));
			var4.addProperty("gravelSize", Integer.valueOf(var1.N));
			var4.addProperty("gravelCount", Integer.valueOf(var1.O));
			var4.addProperty("gravelMinHeight", Integer.valueOf(var1.P));
			var4.addProperty("gravelMaxHeight", Integer.valueOf(var1.Q));
			var4.addProperty("graniteSize", Integer.valueOf(var1.R));
			var4.addProperty("graniteCount", Integer.valueOf(var1.S));
			var4.addProperty("graniteMinHeight", Integer.valueOf(var1.T));
			var4.addProperty("graniteMaxHeight", Integer.valueOf(var1.U));
			var4.addProperty("dioriteSize", Integer.valueOf(var1.V));
			var4.addProperty("dioriteCount", Integer.valueOf(var1.W));
			var4.addProperty("dioriteMinHeight", Integer.valueOf(var1.X));
			var4.addProperty("dioriteMaxHeight", Integer.valueOf(var1.Y));
			var4.addProperty("andesiteSize", Integer.valueOf(var1.Z));
			var4.addProperty("andesiteCount", Integer.valueOf(var1.aa));
			var4.addProperty("andesiteMinHeight", Integer.valueOf(var1.ab));
			var4.addProperty("andesiteMaxHeight", Integer.valueOf(var1.ac));
			var4.addProperty("coalSize", Integer.valueOf(var1.ad));
			var4.addProperty("coalCount", Integer.valueOf(var1.ae));
			var4.addProperty("coalMinHeight", Integer.valueOf(var1.af));
			var4.addProperty("coalMaxHeight", Integer.valueOf(var1.ag));
			var4.addProperty("ironSize", Integer.valueOf(var1.ah));
			var4.addProperty("ironCount", Integer.valueOf(var1.ai));
			var4.addProperty("ironMinHeight", Integer.valueOf(var1.aj));
			var4.addProperty("ironMaxHeight", Integer.valueOf(var1.ak));
			var4.addProperty("goldSize", Integer.valueOf(var1.al));
			var4.addProperty("goldCount", Integer.valueOf(var1.am));
			var4.addProperty("goldMinHeight", Integer.valueOf(var1.an));
			var4.addProperty("goldMaxHeight", Integer.valueOf(var1.ao));
			var4.addProperty("redstoneSize", Integer.valueOf(var1.ap));
			var4.addProperty("redstoneCount", Integer.valueOf(var1.aq));
			var4.addProperty("redstoneMinHeight", Integer.valueOf(var1.ar));
			var4.addProperty("redstoneMaxHeight", Integer.valueOf(var1.as));
			var4.addProperty("diamondSize", Integer.valueOf(var1.at));
			var4.addProperty("diamondCount", Integer.valueOf(var1.au));
			var4.addProperty("diamondMinHeight", Integer.valueOf(var1.av));
			var4.addProperty("diamondMaxHeight", Integer.valueOf(var1.aw));
			var4.addProperty("lapisSize", Integer.valueOf(var1.ax));
			var4.addProperty("lapisCount", Integer.valueOf(var1.ay));
			var4.addProperty("lapisCenterHeight", Integer.valueOf(var1.az));
			var4.addProperty("lapisSpread", Integer.valueOf(var1.aA));
			return var4;
		}

		// $FF: synthetic method
		@Override
		public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
			return this.a(var1, var2, var3);
		}

		// $FF: synthetic method
		@Override
		public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
			return this.a((class_arm.class_a_in_class_arm) var1, var2, var3);
		}
	}

	public static class class_a_in_class_arm {
		static final Gson a = (new GsonBuilder()).registerTypeAdapter(class_arm.class_a_in_class_arm.class, new class_arm.class_b_in_class_arm()).create();
		public float b = 684.412F;
		public float c = 684.412F;
		public float d = 512.0F;
		public float e = 512.0F;
		public float f = 200.0F;
		public float g = 200.0F;
		public float h = 0.5F;
		public float i = 80.0F;
		public float j = 160.0F;
		public float k = 80.0F;
		public float l = 8.5F;
		public float m = 12.0F;
		public float n = 1.0F;
		public float o = 0.0F;
		public float p = 1.0F;
		public float q = 0.0F;
		public int r = 63;
		public boolean s = true;
		public boolean t = true;
		public int u = 8;
		public boolean v = true;
		public boolean w = true;
		public boolean x = true;
		public boolean y = true;
		public boolean z = true;
		public boolean A = true;
		public boolean B = true;
		public int C = 4;
		public boolean D = true;
		public int E = 80;
		public boolean F = false;
		public int G = -1;
		public int H = 4;
		public int I = 4;
		public int J = 33;
		public int K = 10;
		public int L = 0;
		public int M = 256;
		public int N = 33;
		public int O = 8;
		public int P = 0;
		public int Q = 256;
		public int R = 33;
		public int S = 10;
		public int T = 0;
		public int U = 80;
		public int V = 33;
		public int W = 10;
		public int X = 0;
		public int Y = 80;
		public int Z = 33;
		public int aa = 10;
		public int ab = 0;
		public int ac = 80;
		public int ad = 17;
		public int ae = 20;
		public int af = 0;
		public int ag = 128;
		public int ah = 9;
		public int ai = 20;
		public int aj = 0;
		public int ak = 64;
		public int al = 9;
		public int am = 2;
		public int an = 0;
		public int ao = 32;
		public int ap = 8;
		public int aq = 8;
		public int ar = 0;
		public int as = 16;
		public int at = 8;
		public int au = 1;
		public int av = 0;
		public int aw = 16;
		public int ax = 7;
		public int ay = 1;
		public int az = 16;
		public int aA = 16;

		public static class_arm.class_a_in_class_arm a(String var0) {
			if (var0.isEmpty()) {
				return new class_arm.class_a_in_class_arm();
			} else {
				try {
					return (class_arm.class_a_in_class_arm) class_nq.a(a, var0, class_arm.class_a_in_class_arm.class);
				} catch (Exception var2) {
					return new class_arm.class_a_in_class_arm();
				}
			}
		}

		@Override
		public String toString() {
			return a.toJson(this);
		}

		public class_a_in_class_arm() {
			this.a();
		}

		public void a() {
			b = 684.412F;
			c = 684.412F;
			d = 512.0F;
			e = 512.0F;
			f = 200.0F;
			g = 200.0F;
			h = 0.5F;
			i = 80.0F;
			j = 160.0F;
			k = 80.0F;
			l = 8.5F;
			m = 12.0F;
			n = 1.0F;
			o = 0.0F;
			p = 1.0F;
			q = 0.0F;
			r = 63;
			s = true;
			t = true;
			u = 8;
			v = true;
			w = true;
			x = true;
			y = true;
			z = true;
			A = true;
			B = true;
			C = 4;
			D = true;
			E = 80;
			F = false;
			G = -1;
			H = 4;
			I = 4;
			J = 33;
			K = 10;
			L = 0;
			M = 256;
			N = 33;
			O = 8;
			P = 0;
			Q = 256;
			R = 33;
			S = 10;
			T = 0;
			U = 80;
			V = 33;
			W = 10;
			X = 0;
			Y = 80;
			Z = 33;
			aa = 10;
			ab = 0;
			ac = 80;
			ad = 17;
			ae = 20;
			af = 0;
			ag = 128;
			ah = 9;
			ai = 20;
			aj = 0;
			ak = 64;
			al = 9;
			am = 2;
			an = 0;
			ao = 32;
			ap = 8;
			aq = 8;
			ar = 0;
			as = 16;
			at = 8;
			au = 1;
			av = 0;
			aw = 16;
			ax = 7;
			ay = 1;
			az = 16;
			aA = 16;
		}

		@Override
		public boolean equals(Object var1) {
			if (this == var1) {
				return true;
			} else if ((var1 != null) && (this.getClass() == var1.getClass())) {
				class_arm.class_a_in_class_arm var2 = (class_arm.class_a_in_class_arm) var1;
				return aa != var2.aa ? false : (ac != var2.ac ? false : (ab != var2.ab ? false : (Z != var2.Z ? false : (Float.compare(var2.l, l) != 0 ? false : (Float.compare(var2.o, o) != 0 ? false : (Float.compare(var2.n, n) != 0 ? false : (Float.compare(var2.q, q) != 0 ? false : (Float.compare(var2.p, p) != 0 ? false : (H != var2.H ? false : (ae != var2.ae ? false : (ag != var2.ag ? false : (af != var2.af ? false
						: (ad != var2.ad ? false : (Float.compare(var2.b, b) != 0 ? false : (Float.compare(var2.h, h) != 0 ? false : (Float.compare(var2.f, f) != 0 ? false : (Float.compare(var2.g, g) != 0 ? false : (au != var2.au ? false : (aw != var2.aw ? false : (av != var2.av ? false : (at != var2.at ? false : (W != var2.W ? false : (Y != var2.Y ? false : (X != var2.X ? false : (V != var2.V ? false : (K != var2.K ? false
								: (M != var2.M ? false : (L != var2.L ? false : (J != var2.J ? false : (u != var2.u ? false : (G != var2.G ? false : (am != var2.am ? false : (ao != var2.ao ? false : (an != var2.an ? false : (al != var2.al ? false : (S != var2.S ? false : (U != var2.U ? false : (T != var2.T ? false : (R != var2.R ? false : (O != var2.O ? false : (Q != var2.Q ? false : (P != var2.P ? false
										: (N != var2.N ? false : (Float.compare(var2.c, c) != 0 ? false : (ai != var2.ai ? false : (ak != var2.ak ? false : (aj != var2.aj ? false : (ah != var2.ah ? false : (az != var2.az ? false : (ay != var2.ay ? false : (ax != var2.ax ? false : (aA != var2.aA ? false : (E != var2.E ? false : (Float.compare(var2.e, e) != 0 ? false : (Float.compare(var2.i, i) != 0 ? false : (Float.compare(var2.j,
												j) != 0 ? false : (Float.compare(var2.k, k) != 0 ? false : (aq != var2.aq ? false : (as != var2.as ? false : (ar != var2.ar ? false : (ap != var2.ap ? false : (I != var2.I ? false : (r != var2.r ? false : (Float.compare(var2.m, m) != 0 ? false : (Float.compare(var2.d, d) != 0 ? false : (s != var2.s ? false : (t != var2.t ? false : (D != var2.D ? false : (F != var2.F ? false
														: (x != var2.x ? false : (A != var2.A ? false : (v != var2.v ? false : (y != var2.y ? false : (z != var2.z ? false : (w != var2.w ? false : (B != var2.B ? false : C == var2.C))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			int var1 = b != 0.0F ? Float.floatToIntBits(b) : 0;
			var1 = (31 * var1) + (c != 0.0F ? Float.floatToIntBits(c) : 0);
			var1 = (31 * var1) + (d != 0.0F ? Float.floatToIntBits(d) : 0);
			var1 = (31 * var1) + (e != 0.0F ? Float.floatToIntBits(e) : 0);
			var1 = (31 * var1) + (f != 0.0F ? Float.floatToIntBits(f) : 0);
			var1 = (31 * var1) + (g != 0.0F ? Float.floatToIntBits(g) : 0);
			var1 = (31 * var1) + (h != 0.0F ? Float.floatToIntBits(h) : 0);
			var1 = (31 * var1) + (i != 0.0F ? Float.floatToIntBits(i) : 0);
			var1 = (31 * var1) + (j != 0.0F ? Float.floatToIntBits(j) : 0);
			var1 = (31 * var1) + (k != 0.0F ? Float.floatToIntBits(k) : 0);
			var1 = (31 * var1) + (l != 0.0F ? Float.floatToIntBits(l) : 0);
			var1 = (31 * var1) + (m != 0.0F ? Float.floatToIntBits(m) : 0);
			var1 = (31 * var1) + (n != 0.0F ? Float.floatToIntBits(n) : 0);
			var1 = (31 * var1) + (o != 0.0F ? Float.floatToIntBits(o) : 0);
			var1 = (31 * var1) + (p != 0.0F ? Float.floatToIntBits(p) : 0);
			var1 = (31 * var1) + (q != 0.0F ? Float.floatToIntBits(q) : 0);
			var1 = (31 * var1) + r;
			var1 = (31 * var1) + (s ? 1 : 0);
			var1 = (31 * var1) + (t ? 1 : 0);
			var1 = (31 * var1) + u;
			var1 = (31 * var1) + (v ? 1 : 0);
			var1 = (31 * var1) + (w ? 1 : 0);
			var1 = (31 * var1) + (x ? 1 : 0);
			var1 = (31 * var1) + (y ? 1 : 0);
			var1 = (31 * var1) + (z ? 1 : 0);
			var1 = (31 * var1) + (A ? 1 : 0);
			var1 = (31 * var1) + (B ? 1 : 0);
			var1 = (31 * var1) + C;
			var1 = (31 * var1) + (D ? 1 : 0);
			var1 = (31 * var1) + E;
			var1 = (31 * var1) + (F ? 1 : 0);
			var1 = (31 * var1) + G;
			var1 = (31 * var1) + H;
			var1 = (31 * var1) + I;
			var1 = (31 * var1) + J;
			var1 = (31 * var1) + K;
			var1 = (31 * var1) + L;
			var1 = (31 * var1) + M;
			var1 = (31 * var1) + N;
			var1 = (31 * var1) + O;
			var1 = (31 * var1) + P;
			var1 = (31 * var1) + Q;
			var1 = (31 * var1) + R;
			var1 = (31 * var1) + S;
			var1 = (31 * var1) + T;
			var1 = (31 * var1) + U;
			var1 = (31 * var1) + V;
			var1 = (31 * var1) + W;
			var1 = (31 * var1) + X;
			var1 = (31 * var1) + Y;
			var1 = (31 * var1) + Z;
			var1 = (31 * var1) + aa;
			var1 = (31 * var1) + ab;
			var1 = (31 * var1) + ac;
			var1 = (31 * var1) + ad;
			var1 = (31 * var1) + ae;
			var1 = (31 * var1) + af;
			var1 = (31 * var1) + ag;
			var1 = (31 * var1) + ah;
			var1 = (31 * var1) + ai;
			var1 = (31 * var1) + aj;
			var1 = (31 * var1) + ak;
			var1 = (31 * var1) + al;
			var1 = (31 * var1) + am;
			var1 = (31 * var1) + an;
			var1 = (31 * var1) + ao;
			var1 = (31 * var1) + ap;
			var1 = (31 * var1) + aq;
			var1 = (31 * var1) + ar;
			var1 = (31 * var1) + as;
			var1 = (31 * var1) + at;
			var1 = (31 * var1) + au;
			var1 = (31 * var1) + av;
			var1 = (31 * var1) + aw;
			var1 = (31 * var1) + ax;
			var1 = (31 * var1) + ay;
			var1 = (31 * var1) + az;
			var1 = (31 * var1) + aA;
			return var1;
		}

		public class_arm b() {
			return new class_arm(this);
		}
	}
}
