package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aax;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_acd;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_avf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fk;
import net.minecraft.server.class_fl;
import net.minecraft.server.class_fn;
import net.minecraft.server.class_fo;
import net.minecraft.server.class_fp;
import net.minecraft.server.class_gv;
import net.minecraft.server.class_ha;
import net.minecraft.server.class_hf;
import net.minecraft.server.class_hk;
import net.minecraft.server.class_hl;
import net.minecraft.server.class_hm;
import net.minecraft.server.class_hn;
import net.minecraft.server.class_hz;
import net.minecraft.server.class_ia;
import net.minecraft.server.class_ib;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pp;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_px;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qr;
import net.minecraft.server.class_uq;
import net.minecraft.server.class_uy;
import net.minecraft.server.class_va;
import net.minecraft.server.class_vb;
import net.minecraft.server.class_vc;
import net.minecraft.server.class_ve;
import net.minecraft.server.class_vk;
import net.minecraft.server.class_vl;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_vw;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xe;
import net.minecraft.server.class_xf;
import net.minecraft.server.class_xg;
import net.minecraft.server.class_xk;
import net.minecraft.server.class_xl;
import net.minecraft.server.class_xm;
import net.minecraft.server.class_xn;
import net.minecraft.server.class_xp;
import net.minecraft.server.class_xq;
import net.minecraft.server.class_xr;
import net.minecraft.server.class_xs;
import net.minecraft.server.class_xt;
import net.minecraft.server.class_xu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lj {
   private static final Logger p = LogManager.getLogger();
   public class_pr a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public double j;
   public double k;
   public double l;
   public int m;
   private double q;
   private double r;
   private double s;
   private boolean t;
   private boolean u;
   private int v;
   private class_pr w;
   private boolean x;
   private boolean y;
   public boolean n;
   public Set o = Sets.newHashSet();

   public class_lj(class_pr var1, int var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.u = var4;
      this.d = class_nu.c(var1.s * 32.0D);
      this.e = class_nu.c(var1.t * 32.0D);
      this.f = class_nu.c(var1.u * 32.0D);
      this.g = class_nu.d(var1.y * 256.0F / 360.0F);
      this.h = class_nu.d(var1.z * 256.0F / 360.0F);
      this.i = class_nu.d(var1.aE() * 256.0F / 360.0F);
      this.y = var1.C;
   }

   public boolean equals(Object var1) {
      return var1 instanceof class_lj?((class_lj)var1).a.F() == this.a.F():false;
   }

   public int hashCode() {
      return this.a.F();
   }

   public void a(List var1) {
      this.n = false;
      if(!this.t || this.a.e(this.q, this.r, this.s) > 16.0D) {
         this.q = this.a.s;
         this.r = this.a.t;
         this.s = this.a.u;
         this.t = true;
         this.n = true;
         this.b(var1);
      }

      if(this.w != this.a.m || this.a.m != null && this.m % 60 == 0) {
         this.w = this.a.m;
         this.a((class_ff)(new class_hl(0, this.a, this.a.m)));
      }

      if(this.a instanceof class_va && this.m % 10 == 0) {
         class_va var2 = (class_va)this.a;
         class_aas var3 = var2.o();
         if(var3 != null && var3.b() instanceof class_aax) {
            class_avf var4 = class_aau.bf.a(var3, this.a.o);
            Iterator var5 = var1.iterator();

            while(var5.hasNext()) {
               class_xa var6 = (class_xa)var5.next();
               class_lh var7 = (class_lh)var6;
               var4.a(var7, var3);
               class_ff var8 = class_aau.bf.a((class_aas)var3, (class_aen)this.a.o, (class_xa)var7);
               if(var8 != null) {
                  var7.a.a(var8);
               }
            }
         }

         this.b();
      }

      if(this.m % this.c == 0 || this.a.ai || this.a.H().a()) {
         int var23;
         int var24;
         if(this.a.m == null) {
            ++this.v;
            var23 = class_nu.c(this.a.s * 32.0D);
            var24 = class_nu.c(this.a.t * 32.0D);
            int var26 = class_nu.c(this.a.u * 32.0D);
            int var27 = class_nu.d(this.a.y * 256.0F / 360.0F);
            int var28 = class_nu.d(this.a.z * 256.0F / 360.0F);
            int var29 = var23 - this.d;
            int var30 = var24 - this.e;
            int var9 = var26 - this.f;
            Object var10 = null;
            boolean var11 = Math.abs(var29) >= 4 || Math.abs(var30) >= 4 || Math.abs(var9) >= 4 || this.m % 60 == 0;
            boolean var12 = Math.abs(var27 - this.g) >= 4 || Math.abs(var28 - this.h) >= 4;
            if(this.m > 0 || this.a instanceof class_xd) {
               if(var29 >= -128 && var29 < 128 && var30 >= -128 && var30 < 128 && var9 >= -128 && var9 < 128 && this.v <= 400 && !this.x && this.y == this.a.C) {
                  if((!var11 || !var12) && !(this.a instanceof class_xd)) {
                     if(var11) {
                        var10 = new class_gv.class_a_in_class_gv(this.a.F(), (byte)var29, (byte)var30, (byte)var9, this.a.C);
                     } else if(var12) {
                        var10 = new class_gv.class_c_in_class_gv(this.a.F(), (byte)var27, (byte)var28, this.a.C);
                     }
                  } else {
                     var10 = new class_gv.class_b_in_class_gv(this.a.F(), (byte)var29, (byte)var30, (byte)var9, (byte)var27, (byte)var28, this.a.C);
                  }
               } else {
                  this.y = this.a.C;
                  this.v = 0;
                  var10 = new class_hz(this.a.F(), var23, var24, var26, (byte)var27, (byte)var28, this.a.C);
               }
            }

            if(this.u) {
               double var13 = this.a.v - this.j;
               double var15 = this.a.w - this.k;
               double var17 = this.a.x - this.l;
               double var19 = 0.02D;
               double var21 = var13 * var13 + var15 * var15 + var17 * var17;
               if(var21 > var19 * var19 || var21 > 0.0D && this.a.v == 0.0D && this.a.w == 0.0D && this.a.x == 0.0D) {
                  this.j = this.a.v;
                  this.k = this.a.w;
                  this.l = this.a.x;
                  this.a((class_ff)(new class_hm(this.a.F(), this.j, this.k, this.l)));
               }
            }

            if(var10 != null) {
               this.a((class_ff)var10);
            }

            this.b();
            if(var11) {
               this.d = var23;
               this.e = var24;
               this.f = var26;
            }

            if(var12) {
               this.g = var27;
               this.h = var28;
            }

            this.x = false;
         } else {
            var23 = class_nu.d(this.a.y * 256.0F / 360.0F);
            var24 = class_nu.d(this.a.z * 256.0F / 360.0F);
            boolean var25 = Math.abs(var23 - this.g) >= 4 || Math.abs(var24 - this.h) >= 4;
            if(var25) {
               this.a((class_ff)(new class_gv.class_c_in_class_gv(this.a.F(), (byte)var23, (byte)var24, this.a.C)));
               this.g = var23;
               this.h = var24;
            }

            this.d = class_nu.c(this.a.s * 32.0D);
            this.e = class_nu.c(this.a.t * 32.0D);
            this.f = class_nu.c(this.a.u * 32.0D);
            this.b();
            this.x = true;
         }

         var23 = class_nu.d(this.a.aE() * 256.0F / 360.0F);
         if(Math.abs(var23 - this.i) >= 4) {
            this.a((class_ff)(new class_hf(this.a, (byte)var23)));
            this.i = var23;
         }

         this.a.ai = false;
      }

      ++this.m;
      if(this.a.G) {
         this.b((class_ff)(new class_hm(this.a)));
         this.a.G = false;
      }

   }

   private void b() {
      class_qi var1 = this.a.H();
      if(var1.a()) {
         this.b((class_ff)(new class_hk(this.a.F(), var1, false)));
      }

      if(this.a instanceof class_qa) {
         class_qr var2 = (class_qr)((class_qa)this.a).by();
         Set var3 = var2.b();
         if(!var3.isEmpty()) {
            this.b((class_ff)(new class_ia(this.a.F(), var3)));
         }

         var3.clear();
      }

   }

   public void a(class_ff var1) {
      Iterator var2 = this.o.iterator();

      while(var2.hasNext()) {
         class_lh var3 = (class_lh)var2.next();
         var3.a.a(var1);
      }

   }

   public void b(class_ff var1) {
      this.a(var1);
      if(this.a instanceof class_lh) {
         ((class_lh)this.a).a.a(var1);
      }

   }

   public void a() {
      Iterator var1 = this.o.iterator();

      while(var1.hasNext()) {
         class_lh var2 = (class_lh)var1.next();
         this.a.c(var2);
         var2.d(this.a);
      }

   }

   public void a(class_lh var1) {
      if(this.o.contains(var1)) {
         this.a.c(var1);
         var1.d(this.a);
         this.o.remove(var1);
      }

   }

   public void b(class_lh var1) {
      if(var1 != this.a) {
         if(this.c(var1)) {
            if(!this.o.contains(var1) && (this.e(var1) || this.a.n)) {
               this.o.add(var1);
               class_ff var2 = this.c();
               var1.a.a(var2);
               if(!this.a.H().d()) {
                  var1.a.a((class_ff)(new class_hk(this.a.F(), this.a.H(), true)));
               }

               if(this.a instanceof class_qa) {
                  class_qr var3 = (class_qr)((class_qa)this.a).by();
                  Collection var4 = var3.c();
                  if(!var4.isEmpty()) {
                     var1.a.a((class_ff)(new class_ia(this.a.F(), var4)));
                  }
               }

               this.j = this.a.v;
               this.k = this.a.w;
               this.l = this.a.x;
               if(this.u && !(var2 instanceof class_fn)) {
                  var1.a.a((class_ff)(new class_hm(this.a.F(), this.a.v, this.a.w, this.a.x)));
               }

               if(this.a.m != null) {
                  var1.a.a((class_ff)(new class_hl(0, this.a, this.a.m)));
               }

               if(this.a instanceof class_qb && ((class_qb)this.a).cr() != null) {
                  var1.a.a((class_ff)(new class_hl(1, this.a, ((class_qb)this.a).cr())));
               }

               if(this.a instanceof class_qa) {
                  class_pw[] var8 = class_pw.values();
                  int var11 = var8.length;

                  for(int var5 = 0; var5 < var11; ++var5) {
                     class_pw var6 = var8[var5];
                     class_aas var7 = ((class_qa)this.a).a(var6);
                     if(var7 != null) {
                        var1.a.a((class_ff)(new class_hn(this.a.F(), var6, var7)));
                     }
                  }
               }

               if(this.a instanceof class_xa) {
                  class_xa var9 = (class_xa)this.a;
                  if(var9.bK()) {
                     var1.a.a((class_ff)(new class_ha(var9, new class_cj(this.a))));
                  }
               }

               if(this.a instanceof class_qa) {
                  class_qa var10 = (class_qa)this.a;
                  Iterator var12 = var10.bm().iterator();

                  while(var12.hasNext()) {
                     class_pl var13 = (class_pl)var12.next();
                     var1.a.a((class_ff)(new class_ib(this.a.F(), var13)));
                  }
               }

               this.a.b(var1);
            }
         } else if(this.o.contains(var1)) {
            this.o.remove(var1);
            this.a.c(var1);
            var1.d(this.a);
         }

      }
   }

   public boolean c(class_lh var1) {
      double var2 = var1.s - (double)(this.d / 32);
      double var4 = var1.u - (double)(this.f / 32);
      return var2 >= (double)(-this.b) && var2 <= (double)this.b && var4 >= (double)(-this.b) && var4 <= (double)this.b && this.a.a(var1);
   }

   private boolean e(class_lh var1) {
      return var1.u().u().a(var1, this.a.ae, this.a.ag);
   }

   public void b(List var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         this.b((class_lh)var1.get(var2));
      }

   }

   private class_ff c() {
      if(this.a.I) {
         p.warn("Fetching addPacket for removed entity");
      }

      if(this.a instanceof class_vm) {
         return new class_fk(this.a, 2, 1);
      } else if(this.a instanceof class_lh) {
         return new class_fp((class_xa)this.a);
      } else if(this.a instanceof class_vn) {
         class_vn var11 = (class_vn)this.a;
         return new class_fk(this.a, 10, var11.s().a());
      } else if(this.a instanceof class_vk) {
         return new class_fk(this.a, 1);
      } else if(this.a instanceof class_pp) {
         this.i = class_nu.d(this.a.aE() * 256.0F / 360.0F);
         return new class_fn((class_qa)this.a);
      } else if(this.a instanceof class_ve) {
         class_xa var9 = ((class_ve)this.a).b;
         return new class_fk(this.a, 90, var9 != null?var9.F():this.a.F());
      } else {
         class_pr var8;
         if(this.a instanceof class_xn) {
            var8 = ((class_xn)this.a).e;
            return new class_fk(this.a, 91, var8 != null?var8.F():this.a.F());
         } else if(this.a instanceof class_xt) {
            var8 = ((class_xt)this.a).e;
            return new class_fk(this.a, 92, var8 != null?var8.F():this.a.F());
         } else if(this.a instanceof class_xd) {
            var8 = ((class_xd)this.a).e;
            return new class_fk(this.a, 60, var8 != null?var8.F():this.a.F());
         } else if(this.a instanceof class_xm) {
            return new class_fk(this.a, 61);
         } else if(this.a instanceof class_xs) {
            return new class_fk(this.a, 73, class_acd.a(class_abe.i(((class_xs)this.a).m())));
         } else if(this.a instanceof class_xr) {
            return new class_fk(this.a, 75);
         } else if(this.a instanceof class_xq) {
            return new class_fk(this.a, 65);
         } else if(this.a instanceof class_xe) {
            return new class_fk(this.a, 72);
         } else if(this.a instanceof class_xg) {
            return new class_fk(this.a, 76);
         } else {
            class_fk var2;
            if(this.a instanceof class_xf) {
               class_xf var7 = (class_xf)this.a;
               var2 = null;
               byte var10 = 63;
               if(this.a instanceof class_xl) {
                  var10 = 64;
               } else if(this.a instanceof class_xu) {
                  var10 = 66;
               }

               if(var7.a != null) {
                  var2 = new class_fk(this.a, var10, ((class_xf)this.a).a.F());
               } else {
                  var2 = new class_fk(this.a, var10, 0);
               }

               var2.d((int)(var7.b * 8000.0D));
               var2.e((int)(var7.c * 8000.0D));
               var2.f((int)(var7.d * 8000.0D));
               return var2;
            } else if(this.a instanceof class_xk) {
               class_fk var6 = new class_fk(this.a, 67, 0);
               var6.d((int)(this.a.v * 8000.0D));
               var6.e((int)(this.a.w * 8000.0D));
               var6.f((int)(this.a.x * 8000.0D));
               return var6;
            } else if(this.a instanceof class_xp) {
               return new class_fk(this.a, 62);
            } else if(this.a instanceof class_vw) {
               return new class_fk(this.a, 50);
            } else if(this.a instanceof class_uq) {
               return new class_fk(this.a, 51);
            } else if(this.a instanceof class_vl) {
               class_vl var5 = (class_vl)this.a;
               return new class_fk(this.a, 70, Block.f(var5.l()));
            } else if(this.a instanceof class_uy) {
               return new class_fk(this.a, 78);
            } else if(this.a instanceof class_vc) {
               return new class_fo((class_vc)this.a);
            } else {
               class_cj var3;
               if(this.a instanceof class_va) {
                  class_va var4 = (class_va)this.a;
                  var2 = new class_fk(this.a, 71, var4.b.b());
                  var3 = var4.n();
                  var2.a(class_nu.d((float)(var3.n() * 32)));
                  var2.b(class_nu.d((float)(var3.o() * 32)));
                  var2.c(class_nu.d((float)(var3.p() * 32)));
                  return var2;
               } else if(this.a instanceof class_vb) {
                  class_vb var1 = (class_vb)this.a;
                  var2 = new class_fk(this.a, 77);
                  var3 = var1.n();
                  var2.a(class_nu.d((float)(var3.n() * 32)));
                  var2.b(class_nu.d((float)(var3.o() * 32)));
                  var2.c(class_nu.d((float)(var3.p() * 32)));
                  return var2;
               } else if(this.a instanceof class_px) {
                  return new class_fl((class_px)this.a);
               } else {
                  throw new IllegalArgumentException("Don\'t know how to add " + this.a.getClass() + "!");
               }
            }
         }
      }
   }

   public void d(class_lh var1) {
      if(this.o.contains(var1)) {
         this.o.remove(var1);
         this.a.c(var1);
         var1.d(this.a);
      }

   }
}
