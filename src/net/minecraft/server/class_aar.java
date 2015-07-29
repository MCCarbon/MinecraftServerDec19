package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import net.minecraft.server.class_aaa;
import net.minecraft.server.class_aab;
import net.minecraft.server.class_aac;
import net.minecraft.server.class_aad;
import net.minecraft.server.class_aae;
import net.minecraft.server.class_aaf;
import net.minecraft.server.class_aag;
import net.minecraft.server.class_aah;
import net.minecraft.server.class_aai;
import net.minecraft.server.class_aaj;
import net.minecraft.server.class_aak;
import net.minecraft.server.class_aal;
import net.minecraft.server.class_aam;
import net.minecraft.server.class_aan;
import net.minecraft.server.class_aao;
import net.minecraft.server.class_aap;
import net.minecraft.server.class_aaq;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aat;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aav;
import net.minecraft.server.class_aaw;
import net.minecraft.server.class_aax;
import net.minecraft.server.class_aay;
import net.minecraft.server.class_aaz;
import net.minecraft.server.class_aba;
import net.minecraft.server.class_abb;
import net.minecraft.server.class_abc;
import net.minecraft.server.class_abd;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_abf;
import net.minecraft.server.class_abg;
import net.minecraft.server.class_abh;
import net.minecraft.server.class_abi;
import net.minecraft.server.class_abj;
import net.minecraft.server.class_abk;
import net.minecraft.server.class_abl;
import net.minecraft.server.class_abm;
import net.minecraft.server.class_abn;
import net.minecraft.server.class_abo;
import net.minecraft.server.class_abp;
import net.minecraft.server.class_abq;
import net.minecraft.server.class_abr;
import net.minecraft.server.class_abs;
import net.minecraft.server.class_abt;
import net.minecraft.server.class_abu;
import net.minecraft.server.class_abv;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_abx;
import net.minecraft.server.class_aby;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_aca;
import net.minecraft.server.class_acb;
import net.minecraft.server.class_acc;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_ajh;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_akc;
import net.minecraft.server.class_aki;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_akr;
import net.minecraft.server.class_alh;
import net.minecraft.server.class_ali;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cx;
import net.minecraft.server.class_db;
import net.minecraft.server.class_dd;
import net.minecraft.server.class_di;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_jz;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_va;
import net.minecraft.server.class_vc;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yz;
import net.minecraft.server.class_za;
import net.minecraft.server.class_zb;
import net.minecraft.server.class_zc;
import net.minecraft.server.class_zd;
import net.minecraft.server.class_ze;
import net.minecraft.server.class_zf;
import net.minecraft.server.class_zg;
import net.minecraft.server.class_zh;
import net.minecraft.server.class_zi;
import net.minecraft.server.class_zj;
import net.minecraft.server.class_zk;
import net.minecraft.server.class_zl;
import net.minecraft.server.class_zm;
import net.minecraft.server.class_zn;
import net.minecraft.server.class_zo;
import net.minecraft.server.class_zp;
import net.minecraft.server.class_zq;
import net.minecraft.server.class_zr;
import net.minecraft.server.class_zs;
import net.minecraft.server.class_zu;
import net.minecraft.server.class_zw;
import net.minecraft.server.class_zx;
import net.minecraft.server.class_zz;

public class class_aar {
   public static final class_cx e = new class_cx();
   private static final Map a = Maps.newHashMap();
   private static final class_aat b = new class_aat() {
   };
   private static final class_aat c = new class_aat() {
   };
   private static final class_aat d = new class_aat() {
   };
   private class_db k = new class_dd();
   protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
   private class_zu l;
   protected static Random g = new Random();
   protected int h = 64;
   private int m;
   protected boolean i;
   protected boolean j;
   private class_aar n;
   private String o;

   public static int b(class_aar var0) {
      return var0 == null?0:e.a(var0);
   }

   public static class_aar c(int var0) {
      return (class_aar)e.a(var0);
   }

   public static class_aar a(class_agj var0) {
      return (class_aar)a.get(var0);
   }

   public static class_aar d(String var0) {
      class_aar var1 = (class_aar)e.c(new class_jz(var0));
      if(var1 == null) {
         try {
            return c(Integer.parseInt(var0));
         } catch (NumberFormatException var3) {
            ;
         }
      }

      return var1;
   }

   public final void a(class_jz var1, class_aat var2) {
      this.k.a(var1, var2);
   }

   public boolean a(class_dn var1) {
      return false;
   }

   public class_aar() {
      this.a(new class_jz("lefthanded"), d);
   }

   public class_aar d(int var1) {
      this.h = var1;
      return this;
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      return class_oq.b;
   }

   public float a(class_aas var1, class_agj var2) {
      return 1.0F;
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      return new class_or(class_oq.b, var1);
   }

   public class_aas a(class_aas var1, class_aen var2, class_qa var3) {
      return var1;
   }

   public int j() {
      return this.h;
   }

   public int a(int var1) {
      return 0;
   }

   public boolean k() {
      return this.j;
   }

   protected class_aar a(boolean var1) {
      this.j = var1;
      return this;
   }

   public int l() {
      return this.m;
   }

   protected class_aar e(int var1) {
      this.m = var1;
      if(var1 > 0) {
         this.a(new class_jz("damaged"), b);
         this.a(new class_jz("damage"), c);
      }

      return this;
   }

   public boolean m() {
      return this.m > 0 && !this.j;
   }

   public boolean a(class_aas var1, class_qa var2, class_qa var3) {
      return false;
   }

   public boolean a(class_aas var1, class_aen var2, class_agj var3, class_cj var4, class_qa var5) {
      return false;
   }

   public boolean b(class_agj var1) {
      return false;
   }

   public boolean a(class_aas var1, class_xa var2, class_qa var3, class_oo var4) {
      return false;
   }

   public class_aar n() {
      this.i = true;
      return this;
   }

   public class_aar c(String var1) {
      this.o = var1;
      return this;
   }

   public String j(class_aas var1) {
      String var2 = this.e_(var1);
      return var2 == null?"":class_di.a(var2);
   }

   public String a() {
      return "item." + this.o;
   }

   public String e_(class_aas var1) {
      return "item." + this.o;
   }

   public class_aar c(class_aar var1) {
      this.n = var1;
      return this;
   }

   public boolean p() {
      return true;
   }

   public class_aar q() {
      return this.n;
   }

   public boolean r() {
      return this.n != null;
   }

   public void a(class_aas var1, class_aen var2, class_pr var3, int var4, boolean var5) {
   }

   public void b(class_aas var1, class_aen var2, class_xa var3) {
   }

   public boolean f() {
      return false;
   }

   public class_abz f(class_aas var1) {
      return class_abz.a;
   }

   public int e(class_aas var1) {
      return 0;
   }

   public void a(class_aas var1, class_aen var2, class_qa var3, int var4) {
   }

   public String a(class_aas var1) {
      return ("" + class_di.a(this.j(var1) + ".name")).trim();
   }

   public class_abf g(class_aas var1) {
      return var1.w()?class_abf.c:class_abf.a;
   }

   public boolean f_(class_aas var1) {
      return this.j() == 1 && this.m();
   }

   protected class_awg a(class_aen var1, class_xa var2, boolean var3) {
      float var4 = var2.z;
      float var5 = var2.y;
      double var6 = var2.s;
      double var8 = var2.t + (double)var2.aU();
      double var10 = var2.u;
      class_awh var12 = new class_awh(var6, var8, var10);
      float var13 = class_nu.b(-var5 * 0.017453292F - 3.1415927F);
      float var14 = class_nu.a(-var5 * 0.017453292F - 3.1415927F);
      float var15 = -class_nu.b(-var4 * 0.017453292F);
      float var16 = class_nu.a(-var4 * 0.017453292F);
      float var17 = var14 * var15;
      float var19 = var13 * var15;
      double var20 = 5.0D;
      class_awh var22 = var12.b((double)var17 * var20, (double)var16 * var20, (double)var19 * var20);
      return var1.a(var12, var22, var3, !var3, false);
   }

   public int c() {
      return 0;
   }

   public class_aar a(class_zu var1) {
      this.l = var1;
      return this;
   }

   public boolean s() {
      return false;
   }

   public boolean a(class_aas var1, class_aas var2) {
      return false;
   }

   public Multimap a(class_pw var1) {
      return HashMultimap.create();
   }

   public static void t() {
      a((class_agj)class_agk.b, (class_aar)(new class_aba(class_agk.b, class_agk.b, new Function() {
         public String a(class_aas var1) {
            return class_alh.class_a_in_class_alh.a(var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("stone"));
      a((class_agj)class_agk.c, (class_aar)(new class_abx(class_agk.c, false)));
      a((class_agj)class_agk.d, (class_aar)(new class_aba(class_agk.d, class_agk.d, new Function() {
         public String a(class_aas var1) {
            return class_ahj.class_a_in_class_ahj.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("dirt"));
      c(class_agk.e);
      a((class_agj)class_agk.f, (class_aar)(new class_aba(class_agk.f, class_agk.f, new Function() {
         public String a(class_aas var1) {
            return class_ajw.class_a_in_class_ajw.a(var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("wood"));
      a((class_agj)class_agk.g, (class_aar)(new class_aba(class_agk.g, class_agk.g, new Function() {
         public String a(class_aas var1) {
            return class_ajw.class_a_in_class_ajw.a(var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("sapling"));
      c(class_agk.h);
      a((class_agj)class_agk.m, (class_aar)(new class_aba(class_agk.m, class_agk.m, new Function() {
         public String a(class_aas var1) {
            return class_akq.class_a_in_class_akq.a(var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("sand"));
      c(class_agk.n);
      c(class_agk.o);
      c(class_agk.p);
      c(class_agk.q);
      a((class_agj)class_agk.r, (class_aar)(new class_aba(class_agk.r, class_agk.r, new Function() {
         public String a(class_aas var1) {
            return class_ajw.class_a_in_class_ajw.a(var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("log"));
      a((class_agj)class_agk.s, (class_aar)(new class_aba(class_agk.s, class_agk.s, new Function() {
         public String a(class_aas var1) {
            return class_ajw.class_a_in_class_ajw.a(var1.i() + 4).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("log"));
      a((class_agj)class_agk.t, (class_aar)(new class_aaw(class_agk.t)).b("leaves"));
      a((class_agj)class_agk.u, (class_aar)(new class_aaw(class_agk.u)).b("leaves"));
      a((class_agj)class_agk.v, (class_aar)(new class_aba(class_agk.v, class_agk.v, new Function() {
         public String a(class_aas var1) {
            return (var1.i() & 1) == 1?"wet":"dry";
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("sponge"));
      c(class_agk.w);
      c(class_agk.x);
      c(class_agk.y);
      c(class_agk.z);
      a((class_agj)class_agk.A, (class_aar)(new class_aba(class_agk.A, class_agk.A, new Function() {
         public String a(class_aas var1) {
            return class_akr.class_a_in_class_akr.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("sandStone"));
      c(class_agk.B);
      c(class_agk.D);
      c(class_agk.E);
      a((class_agj)class_agk.F, (class_aar)(new class_abd(class_agk.F)));
      c(class_agk.G);
      a((class_agj)class_agk.H, (class_aar)(new class_abx(class_agk.H, true)).a(new String[]{"shrub", "grass", "fern"}));
      c((class_agj)class_agk.I);
      a((class_agj)class_agk.J, (class_aar)(new class_abd(class_agk.J)));
      a((class_agj)class_agk.L, (class_aar)(new class_aaa(class_agk.L)).b("cloth"));
      a((class_agj)class_agk.N, (class_aar)(new class_aba(class_agk.N, class_agk.N, new Function() {
         public String a(class_aas var1) {
            return class_aic.class_a_in_class_aic.a(class_aic.class_b_in_class_aic.a, var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("flower"));
      a((class_agj)class_agk.O, (class_aar)(new class_aba(class_agk.O, class_agk.O, new Function() {
         public String a(class_aas var1) {
            return class_aic.class_a_in_class_aic.a(class_aic.class_b_in_class_aic.b, var1.i()).d();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("rose"));
      c((class_agj)class_agk.P);
      c((class_agj)class_agk.Q);
      c(class_agk.R);
      c(class_agk.S);
      a((class_agj)class_agk.U, (class_aar)(new class_abq(class_agk.U, class_agk.U, class_agk.T)).b("stoneSlab"));
      c(class_agk.V);
      c(class_agk.W);
      c(class_agk.X);
      c(class_agk.Y);
      c(class_agk.Z);
      c(class_agk.aa);
      c(class_agk.cQ);
      c(class_agk.cR);
      c(class_agk.cS);
      c(class_agk.cT);
      c(class_agk.cU);
      c(class_agk.cV);
      a((class_agj)class_agk.cX, (class_aar)(new class_abq(class_agk.cX, class_agk.cX, class_agk.cW)).b("purpurSlab"));
      c(class_agk.ac);
      c(class_agk.ad);
      c((class_agj)class_agk.ae);
      c(class_agk.ag);
      c(class_agk.ah);
      c(class_agk.ai);
      c(class_agk.ak);
      c(class_agk.al);
      c(class_agk.am);
      c(class_agk.au);
      c(class_agk.av);
      c(class_agk.aw);
      c(class_agk.ay);
      c(class_agk.az);
      c(class_agk.aB);
      c(class_agk.aC);
      c(class_agk.aF);
      c(class_agk.aG);
      a((class_agj)class_agk.aH, (class_aar)(new class_abr(class_agk.aH)));
      c(class_agk.aI);
      c(class_agk.aJ);
      c((class_agj)class_agk.aK);
      c(class_agk.aL);
      c(class_agk.aN);
      c(class_agk.aO);
      c(class_agk.aP);
      c(class_agk.aQ);
      c(class_agk.aR);
      c(class_agk.aS);
      c(class_agk.aT);
      c(class_agk.aU);
      c(class_agk.aV);
      c(class_agk.aW);
      c(class_agk.aX);
      c(class_agk.aZ);
      c(class_agk.bd);
      a((class_agj)class_agk.be, (class_aar)(new class_aba(class_agk.be, class_agk.be, new Function() {
         public String a(class_aas var1) {
            return class_ajh.class_a_in_class_ajh.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("monsterStoneEgg"));
      a((class_agj)class_agk.bf, (class_aar)(new class_aba(class_agk.bf, class_agk.bf, new Function() {
         public String a(class_aas var1) {
            return class_ali.class_a_in_class_ali.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("stonebricksmooth"));
      c(class_agk.bg);
      c(class_agk.bh);
      c(class_agk.bi);
      c(class_agk.bj);
      c(class_agk.bk);
      a((class_agj)class_agk.bn, (class_aar)(new class_abx(class_agk.bn, false)));
      c(class_agk.bo);
      c(class_agk.bp);
      c(class_agk.bq);
      c(class_agk.br);
      c(class_agk.bs);
      c(class_agk.bt);
      c(class_agk.bu);
      c(class_agk.bv);
      c((class_agj)class_agk.bw);
      a((class_agj)class_agk.bx, (class_aar)(new class_aca(class_agk.bx)));
      c(class_agk.by);
      c(class_agk.bz);
      c(class_agk.bA);
      c(class_agk.bC);
      c(class_agk.bG);
      c(class_agk.bH);
      c(class_agk.cY);
      c(class_agk.bI);
      c(class_agk.bJ);
      a((class_agj)class_agk.bM, (class_aar)(new class_abq(class_agk.bM, class_agk.bM, class_agk.bL)).b("woodSlab"));
      c(class_agk.bO);
      c(class_agk.bP);
      c(class_agk.bQ);
      c((class_agj)class_agk.bR);
      c(class_agk.bT);
      c(class_agk.bU);
      c(class_agk.bV);
      c(class_agk.bW);
      c(class_agk.bX);
      c((class_agj)class_agk.bY);
      a((class_agj)class_agk.bZ, (class_aar)(new class_aba(class_agk.bZ, class_agk.bZ, new Function() {
         public String a(class_aas var1) {
            return class_alv.class_a_in_class_alv.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("cobbleWall"));
      c(class_agk.cd);
      a((class_agj)class_agk.cf, (class_aar)(new class_yz(class_agk.cf)).b("anvil"));
      c(class_agk.cg);
      c(class_agk.ch);
      c(class_agk.ci);
      c((class_agj)class_agk.cl);
      c(class_agk.cn);
      c(class_agk.co);
      c((class_agj)class_agk.cp);
      a((class_agj)class_agk.cq, (class_aar)(new class_aba(class_agk.cq, class_agk.cq, new String[]{"default", "chiseled", "lines"})).b("quartzBlock"));
      c(class_agk.cr);
      c(class_agk.cs);
      c(class_agk.ct);
      a((class_agj)class_agk.cu, (class_aar)(new class_aaa(class_agk.cu)).b("clayHardenedStained"));
      c(class_agk.cv);
      c(class_agk.cw);
      c(class_agk.cx);
      a((class_agj)class_agk.cy, (class_aar)(new class_aaa(class_agk.cy)).b("woolCarpet"));
      c(class_agk.cz);
      c(class_agk.cA);
      c(class_agk.cB);
      c(class_agk.cC);
      c(class_agk.cD);
      c(class_agk.cE);
      c(class_agk.da);
      a((class_agj)class_agk.cF, (class_aar)(new class_zx(class_agk.cF, class_agk.cF, new Function() {
         public String a(class_aas var1) {
            return class_ahm.class_b_in_class_ahm.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("doublePlant"));
      a((class_agj)class_agk.cG, (class_aar)(new class_aaa(class_agk.cG)).b("stainedGlass"));
      a((class_agj)class_agk.cH, (class_aar)(new class_aaa(class_agk.cH)).b("stainedGlassPane"));
      a((class_agj)class_agk.cI, (class_aar)(new class_aba(class_agk.cI, class_agk.cI, new Function() {
         public String a(class_aas var1) {
            return class_akc.class_a_in_class_akc.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("prismarine"));
      c(class_agk.cJ);
      a((class_agj)class_agk.cM, (class_aar)(new class_aba(class_agk.cM, class_agk.cM, new Function() {
         public String a(class_aas var1) {
            return class_aki.class_a_in_class_aki.a(var1.i()).c();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_aas)var1);
         }
      })).b("redSandStone"));
      c(class_agk.cN);
      a((class_agj)class_agk.cP, (class_aar)(new class_abq(class_agk.cP, class_agk.cP, class_agk.cO)).b("stoneSlab2"));
      a(256, (String)"iron_shovel", (new class_abm(class_aar.class_a_in_class_aar.c)).c("shovelIron"));
      a(257, (String)"iron_pickaxe", (new class_abc(class_aar.class_a_in_class_aar.c)).c("pickaxeIron"));
      a(258, (String)"iron_axe", (new class_zd(class_aar.class_a_in_class_aar.c)).c("hatchetIron"));
      a(259, (String)"flint_and_steel", (new class_aam()).c("flintAndSteel"));
      a(260, (String)"apple", (new class_aan(4, 0.3F, false)).c("apple"));
      a(261, (String)"bow", (new class_zl()).c("bow"));
      a(262, (String)"arrow", (new class_zc()).c("arrow"));
      a(263, (String)"coal", (new class_zr()).c("coal"));
      a(264, (String)"diamond", (new class_aar()).c("diamond").a(class_zu.l));
      a(265, (String)"iron_ingot", (new class_aar()).c("ingotIron").a(class_zu.l));
      a(266, (String)"gold_ingot", (new class_aar()).c("ingotGold").a(class_zu.l));
      a(267, (String)"iron_sword", (new class_abw(class_aar.class_a_in_class_aar.c)).c("swordIron"));
      a(268, (String)"wooden_sword", (new class_abw(class_aar.class_a_in_class_aar.a)).c("swordWood"));
      a(269, (String)"wooden_shovel", (new class_abm(class_aar.class_a_in_class_aar.a)).c("shovelWood"));
      a(270, (String)"wooden_pickaxe", (new class_abc(class_aar.class_a_in_class_aar.a)).c("pickaxeWood"));
      a(271, (String)"wooden_axe", (new class_zd(class_aar.class_a_in_class_aar.a)).c("hatchetWood"));
      a(272, (String)"stone_sword", (new class_abw(class_aar.class_a_in_class_aar.b)).c("swordStone"));
      a(273, (String)"stone_shovel", (new class_abm(class_aar.class_a_in_class_aar.b)).c("shovelStone"));
      a(274, (String)"stone_pickaxe", (new class_abc(class_aar.class_a_in_class_aar.b)).c("pickaxeStone"));
      a(275, (String)"stone_axe", (new class_zd(class_aar.class_a_in_class_aar.b)).c("hatchetStone"));
      a(276, (String)"diamond_sword", (new class_abw(class_aar.class_a_in_class_aar.d)).c("swordDiamond"));
      a(277, (String)"diamond_shovel", (new class_abm(class_aar.class_a_in_class_aar.d)).c("shovelDiamond"));
      a(278, (String)"diamond_pickaxe", (new class_abc(class_aar.class_a_in_class_aar.d)).c("pickaxeDiamond"));
      a(279, (String)"diamond_axe", (new class_zd(class_aar.class_a_in_class_aar.d)).c("hatchetDiamond"));
      a(280, (String)"stick", (new class_aar()).n().c("stick").a(class_zu.l));
      a(281, (String)"bowl", (new class_aar()).c("bowl").a(class_zu.l));
      a(282, (String)"mushroom_stew", (new class_zm(6)).c("mushroomStew"));
      a(283, (String)"golden_sword", (new class_abw(class_aar.class_a_in_class_aar.e)).c("swordGold"));
      a(284, (String)"golden_shovel", (new class_abm(class_aar.class_a_in_class_aar.e)).c("shovelGold"));
      a(285, (String)"golden_pickaxe", (new class_abc(class_aar.class_a_in_class_aar.e)).c("pickaxeGold"));
      a(286, (String)"golden_axe", (new class_zd(class_aar.class_a_in_class_aar.e)).c("hatchetGold"));
      a(287, (String)"string", (new class_zh(class_agk.bS)).c("string").a(class_zu.l));
      a(288, (String)"feather", (new class_aar()).c("feather").a(class_zu.l));
      a(289, (String)"gunpowder", (new class_aar()).c("sulphur").a(class_zu.l));
      a(290, (String)"wooden_hoe", (new class_aaq(class_aar.class_a_in_class_aar.a)).c("hoeWood"));
      a(291, (String)"stone_hoe", (new class_aaq(class_aar.class_a_in_class_aar.b)).c("hoeStone"));
      a(292, (String)"iron_hoe", (new class_aaq(class_aar.class_a_in_class_aar.c)).c("hoeIron"));
      a(293, (String)"diamond_hoe", (new class_aaq(class_aar.class_a_in_class_aar.d)).c("hoeDiamond"));
      a(294, (String)"golden_hoe", (new class_aaq(class_aar.class_a_in_class_aar.e)).c("hoeGold"));
      a(295, (String)"wheat_seeds", (new class_abk(class_agk.aj, class_agk.ak)).c("seeds"));
      a(296, (String)"wheat", (new class_aar()).c("wheat").a(class_zu.l));
      a(297, (String)"bread", (new class_aan(5, 0.6F, false)).c("bread"));
      a(298, (String)"leather_helmet", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.f)).c("helmetCloth"));
      a(299, (String)"leather_chestplate", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.e)).c("chestplateCloth"));
      a(300, (String)"leather_leggings", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.d)).c("leggingsCloth"));
      a(301, (String)"leather_boots", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.c)).c("bootsCloth"));
      a(302, (String)"chainmail_helmet", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.f)).c("helmetChain"));
      a(303, (String)"chainmail_chestplate", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.e)).c("chestplateChain"));
      a(304, (String)"chainmail_leggings", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.d)).c("leggingsChain"));
      a(305, (String)"chainmail_boots", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.c)).c("bootsChain"));
      a(306, (String)"iron_helmet", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.f)).c("helmetIron"));
      a(307, (String)"iron_chestplate", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.e)).c("chestplateIron"));
      a(308, (String)"iron_leggings", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.d)).c("leggingsIron"));
      a(309, (String)"iron_boots", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.c)).c("bootsIron"));
      a(310, (String)"diamond_helmet", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.f)).c("helmetDiamond"));
      a(311, (String)"diamond_chestplate", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.e)).c("chestplateDiamond"));
      a(312, (String)"diamond_leggings", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.d)).c("leggingsDiamond"));
      a(313, (String)"diamond_boots", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.c)).c("bootsDiamond"));
      a(314, (String)"golden_helmet", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.f)).c("helmetGold"));
      a(315, (String)"golden_chestplate", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.e)).c("chestplateGold"));
      a(316, (String)"golden_leggings", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.d)).c("leggingsGold"));
      a(317, (String)"golden_boots", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.c)).c("bootsGold"));
      a(318, (String)"flint", (new class_aar()).c("flint").a(class_zu.l));
      a(319, (String)"porkchop", (new class_aan(3, 0.3F, true)).c("porkchopRaw"));
      a(320, (String)"cooked_porkchop", (new class_aan(8, 0.8F, true)).c("porkchopCooked"));
      a(321, (String)"painting", (new class_aap(class_vc.class)).c("painting"));
      a(322, (String)"golden_apple", (new class_aao(4, 1.2F, false)).h().a(new class_pl(class_pm.j, 100, 1), 1.0F).c("appleGold"));
      a(323, (String)"sign", (new class_abn()).c("sign"));
      a(324, (String)"wooden_door", (new class_zw(class_agk.ao)).c("doorOak"));
      class_aar var0 = (new class_zn(class_agk.a)).c("bucket").d(16);
      a(325, (String)"bucket", var0);
      a(326, (String)"water_bucket", (new class_zn(class_agk.i)).c("bucketWater").c(var0));
      a(327, (String)"lava_bucket", (new class_zn(class_agk.k)).c("bucketLava").c(var0));
      a(328, (String)"minecart", (new class_aaz(class_vn.class_a_in_class_vn.a)).c("minecart"));
      a(329, (String)"saddle", (new class_abi()).c("saddle"));
      a(330, (String)"iron_door", (new class_zw(class_agk.aA)).c("doorIron"));
      a(331, (String)"redstone", (new class_abh()).c("redstone"));
      a(332, (String)"snowball", (new class_abs()).c("snowball"));
      a(333, (String)"boat", (new class_zi()).c("boat"));
      a(334, (String)"leather", (new class_aar()).c("leather").a(class_zu.l));
      a(335, (String)"milk_bucket", (new class_aay()).c("milk").c(var0));
      a(336, (String)"brick", (new class_aar()).c("brick").a(class_zu.l));
      a(337, (String)"clay_ball", (new class_aar()).c("clay").a(class_zu.l));
      a(338, (String)"reeds", (new class_zh(class_agk.aM)).c("reeds").a(class_zu.l));
      a(339, (String)"paper", (new class_aar()).c("paper").a(class_zu.f));
      a(340, (String)"book", (new class_zj()).c("book").a(class_zu.f));
      a(341, (String)"slime_ball", (new class_aar()).c("slimeball").a(class_zu.f));
      a(342, (String)"chest_minecart", (new class_aaz(class_vn.class_a_in_class_vn.b)).c("minecartChest"));
      a(343, (String)"furnace_minecart", (new class_aaz(class_vn.class_a_in_class_vn.c)).c("minecartFurnace"));
      a(344, (String)"egg", (new class_aab()).c("egg"));
      a(345, (String)"compass", (new class_zs()).c("compass").a(class_zu.i));
      a(346, (String)"fishing_rod", (new class_aal()).c("fishingRod"));
      a(347, (String)"clock", (new class_zq()).c("clock").a(class_zu.i));
      a(348, (String)"glowstone_dust", (new class_aar()).c("yellowDust").a(class_zu.l));
      a(349, (String)"fish", (new class_aak(false)).c("fish").a(true));
      a(350, (String)"cooked_fish", (new class_aak(true)).c("fish").a(true));
      a(351, (String)"dye", (new class_zz()).c("dyePowder"));
      a(352, (String)"bone", (new class_aar()).c("bone").n().a(class_zu.f));
      a(353, (String)"sugar", (new class_aar()).c("sugar").a(class_zu.l));
      a(354, (String)"cake", (new class_zh(class_agk.ba)).d(1).c("cake").a(class_zu.h));
      a(355, (String)"bed", (new class_zf()).d(1).c("bed"));
      a(356, (String)"repeater", (new class_zh(class_agk.bb)).c("diode").a(class_zu.d));
      a(357, (String)"cookie", (new class_aan(2, 0.1F, false)).c("cookie"));
      a(358, (String)"filled_map", (new class_aax()).c("map"));
      a(359, (String)"shears", (new class_abl()).c("shears"));
      a(360, (String)"melon", (new class_aan(2, 0.3F, false)).c("melon"));
      a(361, (String)"pumpkin_seeds", (new class_abk(class_agk.bl, class_agk.ak)).c("seeds_pumpkin"));
      a(362, (String)"melon_seeds", (new class_abk(class_agk.bm, class_agk.ak)).c("seeds_melon"));
      a(363, (String)"beef", (new class_aan(3, 0.3F, true)).c("beefRaw"));
      a(364, (String)"cooked_beef", (new class_aan(8, 0.8F, true)).c("beefCooked"));
      a(365, (String)"chicken", (new class_aan(2, 0.3F, true)).a(new class_pl(class_pm.q, 600, 0), 0.3F).c("chickenRaw"));
      a(366, (String)"cooked_chicken", (new class_aan(6, 0.6F, true)).c("chickenCooked"));
      a(367, (String)"rotten_flesh", (new class_aan(4, 0.1F, true)).a(new class_pl(class_pm.q, 600, 0), 0.8F).c("rottenFlesh"));
      a(368, (String)"ender_pearl", (new class_aaf()).c("enderPearl"));
      a(369, (String)"blaze_rod", (new class_aar()).c("blazeRod").a(class_zu.l).n());
      a(370, (String)"ghast_tear", (new class_aar()).c("ghastTear").a(class_zu.k));
      a(371, (String)"gold_nugget", (new class_aar()).c("goldNugget").a(class_zu.l));
      a(372, (String)"nether_wart", (new class_abk(class_agk.bB, class_agk.aW)).c("netherStalkSeeds"));
      a(373, (String)"potion", (new class_abe()).c("potion"));
      a(374, (String)"glass_bottle", (new class_zk()).c("glassBottle"));
      a(375, (String)"spider_eye", (new class_aan(2, 0.8F, false)).a(new class_pl(class_pm.s, 100, 0), 1.0F).c("spiderEye"));
      a(376, (String)"fermented_spider_eye", (new class_aar()).c("fermentedSpiderEye").a(class_zu.k));
      a(377, (String)"blaze_powder", (new class_aar()).c("blazePowder").a(class_zu.k));
      a(378, (String)"magma_cream", (new class_aar()).c("magmaCream").a(class_zu.k));
      a(379, (String)"brewing_stand", (new class_zh(class_agk.bD)).c("brewingStand").a(class_zu.k));
      a(380, (String)"cauldron", (new class_zh(class_agk.bE)).c("cauldron").a(class_zu.k));
      a(381, (String)"ender_eye", (new class_aae()).c("eyeOfEnder"));
      a(382, (String)"speckled_melon", (new class_aar()).c("speckledMelon").a(class_zu.k));
      a(383, (String)"spawn_egg", (new class_abt()).c("monsterPlacer"));
      a(384, (String)"experience_bottle", (new class_aag()).c("expBottle"));
      a(385, (String)"fire_charge", (new class_aah()).c("fireball"));
      a(386, (String)"writable_book", (new class_acb()).c("writingBook").a(class_zu.f));
      a(387, (String)"written_book", (new class_acc()).c("writtenBook").d(16));
      a(388, (String)"emerald", (new class_aar()).c("emerald").a(class_zu.l));
      a(389, (String)"item_frame", (new class_aap(class_va.class)).c("frame"));
      a(390, (String)"flower_pot", (new class_zh(class_agk.ca)).c("flowerPot").a(class_zu.c));
      a(391, (String)"carrot", (new class_abj(3, 0.6F, class_agk.cb, class_agk.ak)).c("carrots"));
      a(392, (String)"potato", (new class_abj(1, 0.3F, class_agk.cc, class_agk.ak)).c("potato"));
      a(393, (String)"baked_potato", (new class_aan(5, 0.6F, false)).c("potatoBaked"));
      a(394, (String)"poisonous_potato", (new class_aan(2, 0.3F, false)).a(new class_pl(class_pm.s, 100, 0), 0.6F).c("potatoPoisonous"));
      a(395, (String)"map", (new class_aac()).c("emptyMap"));
      a(396, (String)"golden_carrot", (new class_aan(6, 1.2F, false)).c("carrotGolden").a(class_zu.k));
      a(397, (String)"skull", (new class_abp()).c("skull"));
      a(398, (String)"carrot_on_a_stick", (new class_zo()).c("carrotOnAStick"));
      a(399, (String)"nether_star", (new class_abo()).c("netherStar").a(class_zu.l));
      a(400, (String)"pumpkin_pie", (new class_aan(8, 0.3F, false)).c("pumpkinPie").a(class_zu.h));
      a(401, (String)"fireworks", (new class_aaj()).c("fireworks"));
      a(402, (String)"firework_charge", (new class_aai()).c("fireworksCharge").a(class_zu.f));
      a(403, (String)"enchanted_book", (new class_aad()).d(1).c("enchantedBook"));
      a(404, (String)"comparator", (new class_zh(class_agk.cj)).c("comparator").a(class_zu.d));
      a(405, (String)"netherbrick", (new class_aar()).c("netherbrick").a(class_zu.l));
      a(406, (String)"quartz", (new class_aar()).c("netherquartz").a(class_zu.l));
      a(407, (String)"tnt_minecart", (new class_aaz(class_vn.class_a_in_class_vn.d)).c("minecartTnt"));
      a(408, (String)"hopper_minecart", (new class_aaz(class_vn.class_a_in_class_vn.f)).c("minecartHopper"));
      a(409, (String)"prismarine_shard", (new class_aar()).c("prismarineShard").a(class_zu.l));
      a(410, (String)"prismarine_crystals", (new class_aar()).c("prismarineCrystals").a(class_zu.l));
      a(411, (String)"rabbit", (new class_aan(3, 0.3F, true)).c("rabbitRaw"));
      a(412, (String)"cooked_rabbit", (new class_aan(5, 0.6F, true)).c("rabbitCooked"));
      a(413, (String)"rabbit_stew", (new class_zm(10)).c("rabbitStew"));
      a(414, (String)"rabbit_foot", (new class_aar()).c("rabbitFoot").a(class_zu.k));
      a(415, (String)"rabbit_hide", (new class_aar()).c("rabbitHide").a(class_zu.l));
      a(416, (String)"armor_stand", (new class_zb()).c("armorStand").d(16));
      a(417, (String)"iron_horse_armor", (new class_aar()).c("horsearmormetal").d(1).a(class_zu.f));
      a(418, (String)"golden_horse_armor", (new class_aar()).c("horsearmorgold").d(1).a(class_zu.f));
      a(419, (String)"diamond_horse_armor", (new class_aar()).c("horsearmordiamond").d(1).a(class_zu.f));
      a(420, (String)"lead", (new class_aav()).c("leash"));
      a(421, (String)"name_tag", (new class_abb()).c("nameTag"));
      a(422, (String)"command_block_minecart", (new class_aaz(class_vn.class_a_in_class_vn.g)).c("minecartCommandBlock").a((class_zu)null));
      a(423, (String)"mutton", (new class_aan(2, 0.3F, true)).c("muttonRaw"));
      a(424, (String)"cooked_mutton", (new class_aan(6, 0.8F, true)).c("muttonCooked"));
      a(425, (String)"banner", (new class_ze()).b("banner"));
      a(427, (String)"spruce_door", (new class_zw(class_agk.ap)).c("doorSpruce"));
      a(428, (String)"birch_door", (new class_zw(class_agk.aq)).c("doorBirch"));
      a(429, (String)"jungle_door", (new class_zw(class_agk.ar)).c("doorJungle"));
      a(430, (String)"acacia_door", (new class_zw(class_agk.as)).c("doorAcacia"));
      a(431, (String)"dark_oak_door", (new class_zw(class_agk.at)).c("doorDarkOak"));
      a(432, (String)"chorus_fruit", (new class_zp(4, 0.3F)).h().c("chorusFruit").a(class_zu.l));
      a(433, (String)"chorus_fruit_popped", (new class_aar()).c("chorusFruitPopped").a(class_zu.l));
      a(434, (String)"beetroot", (new class_aan(1, 0.6F, false)).c("beetroot"));
      a(435, (String)"beetroot_seeds", (new class_abk(class_agk.cZ, class_agk.ak)).c("beetroot_seeds"));
      a(436, (String)"beetroot_soup", (new class_zm(6)).c("beetroot_soup"));
      a(438, (String)"splash_potion", (new class_abv()).c("splash_potion"));
      a(439, (String)"spectral_arrow", (new class_abu()).c("spectral_arrow"));
      a(440, (String)"tipped_arrow", (new class_aby()).c("tipped_arrow"));
      a(2256, (String)"record_13", (new class_abg("13")).c("record"));
      a(2257, (String)"record_cat", (new class_abg("cat")).c("record"));
      a(2258, (String)"record_blocks", (new class_abg("blocks")).c("record"));
      a(2259, (String)"record_chirp", (new class_abg("chirp")).c("record"));
      a(2260, (String)"record_far", (new class_abg("far")).c("record"));
      a(2261, (String)"record_mall", (new class_abg("mall")).c("record"));
      a(2262, (String)"record_mellohi", (new class_abg("mellohi")).c("record"));
      a(2263, (String)"record_stal", (new class_abg("stal")).c("record"));
      a(2264, (String)"record_strad", (new class_abg("strad")).c("record"));
      a(2265, (String)"record_ward", (new class_abg("ward")).c("record"));
      a(2266, (String)"record_11", (new class_abg("11")).c("record"));
      a(2267, (String)"record_wait", (new class_abg("wait")).c("record"));
   }

   private static void c(class_agj var0) {
      a((class_agj)var0, (class_aar)(new class_zg(var0)));
   }

   protected static void a(class_agj var0, class_aar var1) {
      a(class_agj.a(var0), (class_jz)class_agj.c.b(var0), var1);
      a.put(var0, var1);
   }

   private static void a(int var0, String var1, class_aar var2) {
      a(var0, new class_jz(var1), var2);
   }

   private static void a(int var0, class_jz var1, class_aar var2) {
      e.a(var0, var1, var2);
   }

   public static enum class_a_in_class_aar {
      a(0, 59, 2.0F, 0.0F, 15),
      b(1, 131, 4.0F, 1.0F, 5),
      c(2, 250, 6.0F, 2.0F, 14),
      d(3, 1561, 8.0F, 3.0F, 10),
      e(0, 32, 12.0F, 0.0F, 22);

      private final int f;
      private final int g;
      private final float h;
      private final float i;
      private final int j;

      private class_a_in_class_aar(int var3, int var4, float var5, float var6, int var7) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = var7;
      }

      public int a() {
         return this.g;
      }

      public float b() {
         return this.h;
      }

      public float c() {
         return this.i;
      }

      public int d() {
         return this.f;
      }

      public int e() {
         return this.j;
      }

      public class_aar f() {
         return this == a?class_aar.a(class_agk.f):(this == b?class_aar.a(class_agk.e):(this == e?class_aau.m:(this == c?class_aau.l:(this == d?class_aau.k:null))));
      }
   }
}
