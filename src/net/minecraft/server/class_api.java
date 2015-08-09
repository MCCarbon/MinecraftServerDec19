package net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.JsonHelper;

public class class_api {
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

   private class_api(class_api.class_a_in_class_api var1) {
      this.a = var1.b;
      this.b = var1.c;
      this.c = var1.d;
      this.d = var1.e;
      this.e = var1.f;
      this.f = var1.g;
      this.g = var1.h;
      this.h = var1.i;
      this.i = var1.j;
      this.j = var1.k;
      this.k = var1.l;
      this.l = var1.m;
      this.m = var1.n;
      this.n = var1.o;
      this.o = var1.p;
      this.p = var1.q;
      this.q = var1.r;
      this.r = var1.s;
      this.s = var1.t;
      this.t = var1.u;
      this.u = var1.v;
      this.v = var1.w;
      this.w = var1.x;
      this.x = var1.y;
      this.y = var1.z;
      this.z = var1.A;
      this.A = var1.B;
      this.B = var1.C;
      this.C = var1.D;
      this.D = var1.E;
      this.E = var1.F;
      this.F = var1.G;
      this.G = var1.H;
      this.H = var1.I;
      this.I = var1.J;
      this.J = var1.K;
      this.K = var1.L;
      this.L = var1.M;
      this.M = var1.N;
      this.N = var1.O;
      this.O = var1.P;
      this.P = var1.Q;
      this.Q = var1.R;
      this.R = var1.S;
      this.S = var1.T;
      this.T = var1.U;
      this.U = var1.V;
      this.V = var1.W;
      this.W = var1.X;
      this.X = var1.Y;
      this.Y = var1.Z;
      this.Z = var1.aa;
      this.aa = var1.ab;
      this.ab = var1.ac;
      this.ac = var1.ad;
      this.ad = var1.ae;
      this.ae = var1.af;
      this.af = var1.ag;
      this.ag = var1.ah;
      this.ah = var1.ai;
      this.ai = var1.aj;
      this.aj = var1.ak;
      this.ak = var1.al;
      this.al = var1.am;
      this.am = var1.an;
      this.an = var1.ao;
      this.ao = var1.ap;
      this.ap = var1.aq;
      this.aq = var1.ar;
      this.ar = var1.as;
      this.as = var1.at;
      this.at = var1.au;
      this.au = var1.av;
      this.av = var1.aw;
      this.aw = var1.ax;
      this.ax = var1.ay;
      this.ay = var1.az;
      this.az = var1.aA;
   }

   // $FF: synthetic method
   class_api(class_api.class_a_in_class_api var1, class_api.SyntheticClass_1 var2) {
      this(var1);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   public static class class_b_in_class_api implements JsonDeserializer, JsonSerializer {
      public class_api.class_a_in_class_api a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         class_api.class_a_in_class_api var5 = new class_api.class_a_in_class_api();

         try {
            var5.b = JsonHelper.getFloat(var4, "coordinateScale", var5.b);
            var5.c = JsonHelper.getFloat(var4, "heightScale", var5.c);
            var5.e = JsonHelper.getFloat(var4, "lowerLimitScale", var5.e);
            var5.d = JsonHelper.getFloat(var4, "upperLimitScale", var5.d);
            var5.f = JsonHelper.getFloat(var4, "depthNoiseScaleX", var5.f);
            var5.g = JsonHelper.getFloat(var4, "depthNoiseScaleZ", var5.g);
            var5.h = JsonHelper.getFloat(var4, "depthNoiseScaleExponent", var5.h);
            var5.i = JsonHelper.getFloat(var4, "mainNoiseScaleX", var5.i);
            var5.j = JsonHelper.getFloat(var4, "mainNoiseScaleY", var5.j);
            var5.k = JsonHelper.getFloat(var4, "mainNoiseScaleZ", var5.k);
            var5.l = JsonHelper.getFloat(var4, "baseSize", var5.l);
            var5.m = JsonHelper.getFloat(var4, "stretchY", var5.m);
            var5.n = JsonHelper.getFloat(var4, "biomeDepthWeight", var5.n);
            var5.o = JsonHelper.getFloat(var4, "biomeDepthOffset", var5.o);
            var5.p = JsonHelper.getFloat(var4, "biomeScaleWeight", var5.p);
            var5.q = JsonHelper.getFloat(var4, "biomeScaleOffset", var5.q);
            var5.r = JsonHelper.getInt(var4, "seaLevel", var5.r);
            var5.s = JsonHelper.getBoolean(var4, "useCaves", var5.s);
            var5.t = JsonHelper.getBoolean(var4, "useDungeons", var5.t);
            var5.u = JsonHelper.getInt(var4, "dungeonChance", var5.u);
            var5.v = JsonHelper.getBoolean(var4, "useStrongholds", var5.v);
            var5.w = JsonHelper.getBoolean(var4, "useVillages", var5.w);
            var5.x = JsonHelper.getBoolean(var4, "useMineShafts", var5.x);
            var5.y = JsonHelper.getBoolean(var4, "useTemples", var5.y);
            var5.z = JsonHelper.getBoolean(var4, "useMonuments", var5.z);
            var5.A = JsonHelper.getBoolean(var4, "useRavines", var5.A);
            var5.B = JsonHelper.getBoolean(var4, "useWaterLakes", var5.B);
            var5.C = JsonHelper.getInt(var4, "waterLakeChance", var5.C);
            var5.D = JsonHelper.getBoolean(var4, "useLavaLakes", var5.D);
            var5.E = JsonHelper.getInt(var4, "lavaLakeChance", var5.E);
            var5.F = JsonHelper.getBoolean(var4, "useLavaOceans", var5.F);
            var5.G = JsonHelper.getInt(var4, "fixedBiome", var5.G);
            if(var5.G < 38 && var5.G >= -1) {
               if(var5.G >= BiomeBase.HELL.az) {
                  var5.G += 2;
               }
            } else {
               var5.G = -1;
            }

            var5.H = JsonHelper.getInt(var4, "biomeSize", var5.H);
            var5.I = JsonHelper.getInt(var4, "riverSize", var5.I);
            var5.J = JsonHelper.getInt(var4, "dirtSize", var5.J);
            var5.K = JsonHelper.getInt(var4, "dirtCount", var5.K);
            var5.L = JsonHelper.getInt(var4, "dirtMinHeight", var5.L);
            var5.M = JsonHelper.getInt(var4, "dirtMaxHeight", var5.M);
            var5.N = JsonHelper.getInt(var4, "gravelSize", var5.N);
            var5.O = JsonHelper.getInt(var4, "gravelCount", var5.O);
            var5.P = JsonHelper.getInt(var4, "gravelMinHeight", var5.P);
            var5.Q = JsonHelper.getInt(var4, "gravelMaxHeight", var5.Q);
            var5.R = JsonHelper.getInt(var4, "graniteSize", var5.R);
            var5.S = JsonHelper.getInt(var4, "graniteCount", var5.S);
            var5.T = JsonHelper.getInt(var4, "graniteMinHeight", var5.T);
            var5.U = JsonHelper.getInt(var4, "graniteMaxHeight", var5.U);
            var5.V = JsonHelper.getInt(var4, "dioriteSize", var5.V);
            var5.W = JsonHelper.getInt(var4, "dioriteCount", var5.W);
            var5.X = JsonHelper.getInt(var4, "dioriteMinHeight", var5.X);
            var5.Y = JsonHelper.getInt(var4, "dioriteMaxHeight", var5.Y);
            var5.Z = JsonHelper.getInt(var4, "andesiteSize", var5.Z);
            var5.aa = JsonHelper.getInt(var4, "andesiteCount", var5.aa);
            var5.ab = JsonHelper.getInt(var4, "andesiteMinHeight", var5.ab);
            var5.ac = JsonHelper.getInt(var4, "andesiteMaxHeight", var5.ac);
            var5.ad = JsonHelper.getInt(var4, "coalSize", var5.ad);
            var5.ae = JsonHelper.getInt(var4, "coalCount", var5.ae);
            var5.af = JsonHelper.getInt(var4, "coalMinHeight", var5.af);
            var5.ag = JsonHelper.getInt(var4, "coalMaxHeight", var5.ag);
            var5.ah = JsonHelper.getInt(var4, "ironSize", var5.ah);
            var5.ai = JsonHelper.getInt(var4, "ironCount", var5.ai);
            var5.aj = JsonHelper.getInt(var4, "ironMinHeight", var5.aj);
            var5.ak = JsonHelper.getInt(var4, "ironMaxHeight", var5.ak);
            var5.al = JsonHelper.getInt(var4, "goldSize", var5.al);
            var5.am = JsonHelper.getInt(var4, "goldCount", var5.am);
            var5.an = JsonHelper.getInt(var4, "goldMinHeight", var5.an);
            var5.ao = JsonHelper.getInt(var4, "goldMaxHeight", var5.ao);
            var5.ap = JsonHelper.getInt(var4, "redstoneSize", var5.ap);
            var5.aq = JsonHelper.getInt(var4, "redstoneCount", var5.aq);
            var5.ar = JsonHelper.getInt(var4, "redstoneMinHeight", var5.ar);
            var5.as = JsonHelper.getInt(var4, "redstoneMaxHeight", var5.as);
            var5.at = JsonHelper.getInt(var4, "diamondSize", var5.at);
            var5.au = JsonHelper.getInt(var4, "diamondCount", var5.au);
            var5.av = JsonHelper.getInt(var4, "diamondMinHeight", var5.av);
            var5.aw = JsonHelper.getInt(var4, "diamondMaxHeight", var5.aw);
            var5.ax = JsonHelper.getInt(var4, "lapisSize", var5.ax);
            var5.ay = JsonHelper.getInt(var4, "lapisCount", var5.ay);
            var5.az = JsonHelper.getInt(var4, "lapisCenterHeight", var5.az);
            var5.aA = JsonHelper.getInt(var4, "lapisSpread", var5.aA);
         } catch (Exception var7) {
            ;
         }

         return var5;
      }

      public JsonElement a(class_api.class_a_in_class_api var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         var4.addProperty("coordinateScale", (Number)Float.valueOf(var1.b));
         var4.addProperty("heightScale", (Number)Float.valueOf(var1.c));
         var4.addProperty("lowerLimitScale", (Number)Float.valueOf(var1.e));
         var4.addProperty("upperLimitScale", (Number)Float.valueOf(var1.d));
         var4.addProperty("depthNoiseScaleX", (Number)Float.valueOf(var1.f));
         var4.addProperty("depthNoiseScaleZ", (Number)Float.valueOf(var1.g));
         var4.addProperty("depthNoiseScaleExponent", (Number)Float.valueOf(var1.h));
         var4.addProperty("mainNoiseScaleX", (Number)Float.valueOf(var1.i));
         var4.addProperty("mainNoiseScaleY", (Number)Float.valueOf(var1.j));
         var4.addProperty("mainNoiseScaleZ", (Number)Float.valueOf(var1.k));
         var4.addProperty("baseSize", (Number)Float.valueOf(var1.l));
         var4.addProperty("stretchY", (Number)Float.valueOf(var1.m));
         var4.addProperty("biomeDepthWeight", (Number)Float.valueOf(var1.n));
         var4.addProperty("biomeDepthOffset", (Number)Float.valueOf(var1.o));
         var4.addProperty("biomeScaleWeight", (Number)Float.valueOf(var1.p));
         var4.addProperty("biomeScaleOffset", (Number)Float.valueOf(var1.q));
         var4.addProperty("seaLevel", (Number)Integer.valueOf(var1.r));
         var4.addProperty("useCaves", Boolean.valueOf(var1.s));
         var4.addProperty("useDungeons", Boolean.valueOf(var1.t));
         var4.addProperty("dungeonChance", (Number)Integer.valueOf(var1.u));
         var4.addProperty("useStrongholds", Boolean.valueOf(var1.v));
         var4.addProperty("useVillages", Boolean.valueOf(var1.w));
         var4.addProperty("useMineShafts", Boolean.valueOf(var1.x));
         var4.addProperty("useTemples", Boolean.valueOf(var1.y));
         var4.addProperty("useMonuments", Boolean.valueOf(var1.z));
         var4.addProperty("useRavines", Boolean.valueOf(var1.A));
         var4.addProperty("useWaterLakes", Boolean.valueOf(var1.B));
         var4.addProperty("waterLakeChance", (Number)Integer.valueOf(var1.C));
         var4.addProperty("useLavaLakes", Boolean.valueOf(var1.D));
         var4.addProperty("lavaLakeChance", (Number)Integer.valueOf(var1.E));
         var4.addProperty("useLavaOceans", Boolean.valueOf(var1.F));
         var4.addProperty("fixedBiome", (Number)Integer.valueOf(var1.G));
         var4.addProperty("biomeSize", (Number)Integer.valueOf(var1.H));
         var4.addProperty("riverSize", (Number)Integer.valueOf(var1.I));
         var4.addProperty("dirtSize", (Number)Integer.valueOf(var1.J));
         var4.addProperty("dirtCount", (Number)Integer.valueOf(var1.K));
         var4.addProperty("dirtMinHeight", (Number)Integer.valueOf(var1.L));
         var4.addProperty("dirtMaxHeight", (Number)Integer.valueOf(var1.M));
         var4.addProperty("gravelSize", (Number)Integer.valueOf(var1.N));
         var4.addProperty("gravelCount", (Number)Integer.valueOf(var1.O));
         var4.addProperty("gravelMinHeight", (Number)Integer.valueOf(var1.P));
         var4.addProperty("gravelMaxHeight", (Number)Integer.valueOf(var1.Q));
         var4.addProperty("graniteSize", (Number)Integer.valueOf(var1.R));
         var4.addProperty("graniteCount", (Number)Integer.valueOf(var1.S));
         var4.addProperty("graniteMinHeight", (Number)Integer.valueOf(var1.T));
         var4.addProperty("graniteMaxHeight", (Number)Integer.valueOf(var1.U));
         var4.addProperty("dioriteSize", (Number)Integer.valueOf(var1.V));
         var4.addProperty("dioriteCount", (Number)Integer.valueOf(var1.W));
         var4.addProperty("dioriteMinHeight", (Number)Integer.valueOf(var1.X));
         var4.addProperty("dioriteMaxHeight", (Number)Integer.valueOf(var1.Y));
         var4.addProperty("andesiteSize", (Number)Integer.valueOf(var1.Z));
         var4.addProperty("andesiteCount", (Number)Integer.valueOf(var1.aa));
         var4.addProperty("andesiteMinHeight", (Number)Integer.valueOf(var1.ab));
         var4.addProperty("andesiteMaxHeight", (Number)Integer.valueOf(var1.ac));
         var4.addProperty("coalSize", (Number)Integer.valueOf(var1.ad));
         var4.addProperty("coalCount", (Number)Integer.valueOf(var1.ae));
         var4.addProperty("coalMinHeight", (Number)Integer.valueOf(var1.af));
         var4.addProperty("coalMaxHeight", (Number)Integer.valueOf(var1.ag));
         var4.addProperty("ironSize", (Number)Integer.valueOf(var1.ah));
         var4.addProperty("ironCount", (Number)Integer.valueOf(var1.ai));
         var4.addProperty("ironMinHeight", (Number)Integer.valueOf(var1.aj));
         var4.addProperty("ironMaxHeight", (Number)Integer.valueOf(var1.ak));
         var4.addProperty("goldSize", (Number)Integer.valueOf(var1.al));
         var4.addProperty("goldCount", (Number)Integer.valueOf(var1.am));
         var4.addProperty("goldMinHeight", (Number)Integer.valueOf(var1.an));
         var4.addProperty("goldMaxHeight", (Number)Integer.valueOf(var1.ao));
         var4.addProperty("redstoneSize", (Number)Integer.valueOf(var1.ap));
         var4.addProperty("redstoneCount", (Number)Integer.valueOf(var1.aq));
         var4.addProperty("redstoneMinHeight", (Number)Integer.valueOf(var1.ar));
         var4.addProperty("redstoneMaxHeight", (Number)Integer.valueOf(var1.as));
         var4.addProperty("diamondSize", (Number)Integer.valueOf(var1.at));
         var4.addProperty("diamondCount", (Number)Integer.valueOf(var1.au));
         var4.addProperty("diamondMinHeight", (Number)Integer.valueOf(var1.av));
         var4.addProperty("diamondMaxHeight", (Number)Integer.valueOf(var1.aw));
         var4.addProperty("lapisSize", (Number)Integer.valueOf(var1.ax));
         var4.addProperty("lapisCount", (Number)Integer.valueOf(var1.ay));
         var4.addProperty("lapisCenterHeight", (Number)Integer.valueOf(var1.az));
         var4.addProperty("lapisSpread", (Number)Integer.valueOf(var1.aA));
         return var4;
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((class_api.class_a_in_class_api)var1, var2, var3);
      }
   }

   public static class class_a_in_class_api {
      static final Gson a = (new GsonBuilder()).registerTypeAdapter(class_api.class_a_in_class_api.class, new class_api.class_b_in_class_api()).create();
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

      public static class_api.class_a_in_class_api a(String var0) {
         if(var0.isEmpty()) {
            return new class_api.class_a_in_class_api();
         } else {
            try {
               return (class_api.class_a_in_class_api)JsonHelper.fromJson(a, var0, class_api.class_a_in_class_api.class);
            } catch (Exception var2) {
               return new class_api.class_a_in_class_api();
            }
         }
      }

      public String toString() {
         return a.toJson((Object)this);
      }

      public class_a_in_class_api() {
         this.a();
      }

      public void a() {
         this.b = 684.412F;
         this.c = 684.412F;
         this.d = 512.0F;
         this.e = 512.0F;
         this.f = 200.0F;
         this.g = 200.0F;
         this.h = 0.5F;
         this.i = 80.0F;
         this.j = 160.0F;
         this.k = 80.0F;
         this.l = 8.5F;
         this.m = 12.0F;
         this.n = 1.0F;
         this.o = 0.0F;
         this.p = 1.0F;
         this.q = 0.0F;
         this.r = 63;
         this.s = true;
         this.t = true;
         this.u = 8;
         this.v = true;
         this.w = true;
         this.x = true;
         this.y = true;
         this.z = true;
         this.A = true;
         this.B = true;
         this.C = 4;
         this.D = true;
         this.E = 80;
         this.F = false;
         this.G = -1;
         this.H = 4;
         this.I = 4;
         this.J = 33;
         this.K = 10;
         this.L = 0;
         this.M = 256;
         this.N = 33;
         this.O = 8;
         this.P = 0;
         this.Q = 256;
         this.R = 33;
         this.S = 10;
         this.T = 0;
         this.U = 80;
         this.V = 33;
         this.W = 10;
         this.X = 0;
         this.Y = 80;
         this.Z = 33;
         this.aa = 10;
         this.ab = 0;
         this.ac = 80;
         this.ad = 17;
         this.ae = 20;
         this.af = 0;
         this.ag = 128;
         this.ah = 9;
         this.ai = 20;
         this.aj = 0;
         this.ak = 64;
         this.al = 9;
         this.am = 2;
         this.an = 0;
         this.ao = 32;
         this.ap = 8;
         this.aq = 8;
         this.ar = 0;
         this.as = 16;
         this.at = 8;
         this.au = 1;
         this.av = 0;
         this.aw = 16;
         this.ax = 7;
         this.ay = 1;
         this.az = 16;
         this.aA = 16;
      }

      public boolean equals(Object var1) {
         if(this == var1) {
            return true;
         } else if(var1 != null && this.getClass() == var1.getClass()) {
            class_api.class_a_in_class_api var2 = (class_api.class_a_in_class_api)var1;
            return this.aa != var2.aa?false:(this.ac != var2.ac?false:(this.ab != var2.ab?false:(this.Z != var2.Z?false:(Float.compare(var2.l, this.l) != 0?false:(Float.compare(var2.o, this.o) != 0?false:(Float.compare(var2.n, this.n) != 0?false:(Float.compare(var2.q, this.q) != 0?false:(Float.compare(var2.p, this.p) != 0?false:(this.H != var2.H?false:(this.ae != var2.ae?false:(this.ag != var2.ag?false:(this.af != var2.af?false:(this.ad != var2.ad?false:(Float.compare(var2.b, this.b) != 0?false:(Float.compare(var2.h, this.h) != 0?false:(Float.compare(var2.f, this.f) != 0?false:(Float.compare(var2.g, this.g) != 0?false:(this.au != var2.au?false:(this.aw != var2.aw?false:(this.av != var2.av?false:(this.at != var2.at?false:(this.W != var2.W?false:(this.Y != var2.Y?false:(this.X != var2.X?false:(this.V != var2.V?false:(this.K != var2.K?false:(this.M != var2.M?false:(this.L != var2.L?false:(this.J != var2.J?false:(this.u != var2.u?false:(this.G != var2.G?false:(this.am != var2.am?false:(this.ao != var2.ao?false:(this.an != var2.an?false:(this.al != var2.al?false:(this.S != var2.S?false:(this.U != var2.U?false:(this.T != var2.T?false:(this.R != var2.R?false:(this.O != var2.O?false:(this.Q != var2.Q?false:(this.P != var2.P?false:(this.N != var2.N?false:(Float.compare(var2.c, this.c) != 0?false:(this.ai != var2.ai?false:(this.ak != var2.ak?false:(this.aj != var2.aj?false:(this.ah != var2.ah?false:(this.az != var2.az?false:(this.ay != var2.ay?false:(this.ax != var2.ax?false:(this.aA != var2.aA?false:(this.E != var2.E?false:(Float.compare(var2.e, this.e) != 0?false:(Float.compare(var2.i, this.i) != 0?false:(Float.compare(var2.j, this.j) != 0?false:(Float.compare(var2.k, this.k) != 0?false:(this.aq != var2.aq?false:(this.as != var2.as?false:(this.ar != var2.ar?false:(this.ap != var2.ap?false:(this.I != var2.I?false:(this.r != var2.r?false:(Float.compare(var2.m, this.m) != 0?false:(Float.compare(var2.d, this.d) != 0?false:(this.s != var2.s?false:(this.t != var2.t?false:(this.D != var2.D?false:(this.F != var2.F?false:(this.x != var2.x?false:(this.A != var2.A?false:(this.v != var2.v?false:(this.y != var2.y?false:(this.z != var2.z?false:(this.w != var2.w?false:(this.B != var2.B?false:this.C == var2.C))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
         } else {
            return false;
         }
      }

      public int hashCode() {
         int var1 = this.b != 0.0F?Float.floatToIntBits(this.b):0;
         var1 = 31 * var1 + (this.c != 0.0F?Float.floatToIntBits(this.c):0);
         var1 = 31 * var1 + (this.d != 0.0F?Float.floatToIntBits(this.d):0);
         var1 = 31 * var1 + (this.e != 0.0F?Float.floatToIntBits(this.e):0);
         var1 = 31 * var1 + (this.f != 0.0F?Float.floatToIntBits(this.f):0);
         var1 = 31 * var1 + (this.g != 0.0F?Float.floatToIntBits(this.g):0);
         var1 = 31 * var1 + (this.h != 0.0F?Float.floatToIntBits(this.h):0);
         var1 = 31 * var1 + (this.i != 0.0F?Float.floatToIntBits(this.i):0);
         var1 = 31 * var1 + (this.j != 0.0F?Float.floatToIntBits(this.j):0);
         var1 = 31 * var1 + (this.k != 0.0F?Float.floatToIntBits(this.k):0);
         var1 = 31 * var1 + (this.l != 0.0F?Float.floatToIntBits(this.l):0);
         var1 = 31 * var1 + (this.m != 0.0F?Float.floatToIntBits(this.m):0);
         var1 = 31 * var1 + (this.n != 0.0F?Float.floatToIntBits(this.n):0);
         var1 = 31 * var1 + (this.o != 0.0F?Float.floatToIntBits(this.o):0);
         var1 = 31 * var1 + (this.p != 0.0F?Float.floatToIntBits(this.p):0);
         var1 = 31 * var1 + (this.q != 0.0F?Float.floatToIntBits(this.q):0);
         var1 = 31 * var1 + this.r;
         var1 = 31 * var1 + (this.s?1:0);
         var1 = 31 * var1 + (this.t?1:0);
         var1 = 31 * var1 + this.u;
         var1 = 31 * var1 + (this.v?1:0);
         var1 = 31 * var1 + (this.w?1:0);
         var1 = 31 * var1 + (this.x?1:0);
         var1 = 31 * var1 + (this.y?1:0);
         var1 = 31 * var1 + (this.z?1:0);
         var1 = 31 * var1 + (this.A?1:0);
         var1 = 31 * var1 + (this.B?1:0);
         var1 = 31 * var1 + this.C;
         var1 = 31 * var1 + (this.D?1:0);
         var1 = 31 * var1 + this.E;
         var1 = 31 * var1 + (this.F?1:0);
         var1 = 31 * var1 + this.G;
         var1 = 31 * var1 + this.H;
         var1 = 31 * var1 + this.I;
         var1 = 31 * var1 + this.J;
         var1 = 31 * var1 + this.K;
         var1 = 31 * var1 + this.L;
         var1 = 31 * var1 + this.M;
         var1 = 31 * var1 + this.N;
         var1 = 31 * var1 + this.O;
         var1 = 31 * var1 + this.P;
         var1 = 31 * var1 + this.Q;
         var1 = 31 * var1 + this.R;
         var1 = 31 * var1 + this.S;
         var1 = 31 * var1 + this.T;
         var1 = 31 * var1 + this.U;
         var1 = 31 * var1 + this.V;
         var1 = 31 * var1 + this.W;
         var1 = 31 * var1 + this.X;
         var1 = 31 * var1 + this.Y;
         var1 = 31 * var1 + this.Z;
         var1 = 31 * var1 + this.aa;
         var1 = 31 * var1 + this.ab;
         var1 = 31 * var1 + this.ac;
         var1 = 31 * var1 + this.ad;
         var1 = 31 * var1 + this.ae;
         var1 = 31 * var1 + this.af;
         var1 = 31 * var1 + this.ag;
         var1 = 31 * var1 + this.ah;
         var1 = 31 * var1 + this.ai;
         var1 = 31 * var1 + this.aj;
         var1 = 31 * var1 + this.ak;
         var1 = 31 * var1 + this.al;
         var1 = 31 * var1 + this.am;
         var1 = 31 * var1 + this.an;
         var1 = 31 * var1 + this.ao;
         var1 = 31 * var1 + this.ap;
         var1 = 31 * var1 + this.aq;
         var1 = 31 * var1 + this.ar;
         var1 = 31 * var1 + this.as;
         var1 = 31 * var1 + this.at;
         var1 = 31 * var1 + this.au;
         var1 = 31 * var1 + this.av;
         var1 = 31 * var1 + this.aw;
         var1 = 31 * var1 + this.ax;
         var1 = 31 * var1 + this.ay;
         var1 = 31 * var1 + this.az;
         var1 = 31 * var1 + this.aA;
         return var1;
      }

      public class_api b() {
         return new class_api(this);
      }
   }
}
