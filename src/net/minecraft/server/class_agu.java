package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oi;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uc;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.CreativeTab;

public class class_agu extends class_agd {
   public static final class_anx a;
   public final int b;

   protected class_agu(int var1) {
      super(class_atk.d);
      this.j(this.M.b().set(a, class_cq.c));
      this.b = var1;
      this.a(CreativeTab.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int b() {
      return 2;
   }

   public void a(class_aer var1, class_cj var2) {
      if(var1.p(var2.c()).getBlock() == this) {
         this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.p(var2.d()).getBlock() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(var1.p(var2.e()).getBlock() == this) {
         this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.p(var2.f()).getBlock() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      this.e(var1, var2, var3);
      Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

      while(var4.hasNext()) {
         class_cq var5 = (class_cq)var4.next();
         class_cj var6 = var2.a(var5);
         IBlockData var7 = var1.p(var6);
         if(var7.getBlock() == this) {
            this.e(var1, var6, var7);
         }
      }

   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().set(a, var8.aR());
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
      class_cq var6 = class_cq.b(class_nu.c((double)(var4.y * 4.0F / 360.0F) + 0.5D) & 3).d();
      var3 = var3.set(a, var6);
      class_cj var7 = var2.c();
      class_cj var8 = var2.d();
      class_cj var9 = var2.e();
      class_cj var10 = var2.f();
      boolean var11 = this == var1.p(var7).getBlock();
      boolean var12 = this == var1.p(var8).getBlock();
      boolean var13 = this == var1.p(var9).getBlock();
      boolean var14 = this == var1.p(var10).getBlock();
      if(!var11 && !var12 && !var13 && !var14) {
         var1.a((class_cj)var2, (IBlockData)var3, 3);
      } else if(var6.k() == class_cq.class_a_in_class_cq.a && (var11 || var12)) {
         if(var11) {
            var1.a((class_cj)var7, (IBlockData)var3, 3);
         } else {
            var1.a((class_cj)var8, (IBlockData)var3, 3);
         }

         var1.a((class_cj)var2, (IBlockData)var3, 3);
      } else if(var6.k() == class_cq.class_a_in_class_cq.c && (var13 || var14)) {
         if(var13) {
            var1.a((class_cj)var9, (IBlockData)var3, 3);
         } else {
            var1.a((class_cj)var10, (IBlockData)var3, 3);
         }

         var1.a((class_cj)var2, (IBlockData)var3, 3);
      }

      if(var5.s()) {
         class_amg var15 = var1.s(var2);
         if(var15 instanceof class_ami) {
            ((class_ami)var15).a(var5.q());
         }
      }

   }

   public IBlockData e(class_aen var1, class_cj var2, IBlockData var3) {
      if(var1.D) {
         return var3;
      } else {
         IBlockData var4 = var1.p(var2.c());
         IBlockData var5 = var1.p(var2.d());
         IBlockData var6 = var1.p(var2.e());
         IBlockData var7 = var1.p(var2.f());
         class_cq var8 = (class_cq)var3.get(a);
         Block var9 = var4.getBlock();
         Block var10 = var5.getBlock();
         Block var11 = var6.getBlock();
         Block var12 = var7.getBlock();
         if(var9 != this && var10 != this) {
            boolean var21 = var9.q();
            boolean var22 = var10.q();
            if(var11 == this || var12 == this) {
               class_cj var23 = var11 == this?var2.e():var2.f();
               IBlockData var24 = var1.p(var23.c());
               IBlockData var25 = var1.p(var23.d());
               var8 = class_cq.d;
               class_cq var26;
               if(var11 == this) {
                  var26 = (class_cq)var6.get(a);
               } else {
                  var26 = (class_cq)var7.get(a);
               }

               if(var26 == class_cq.c) {
                  var8 = class_cq.c;
               }

               Block var19 = var24.getBlock();
               Block var20 = var25.getBlock();
               if((var21 || var19.q()) && !var22 && !var20.q()) {
                  var8 = class_cq.d;
               }

               if((var22 || var20.q()) && !var21 && !var19.q()) {
                  var8 = class_cq.c;
               }
            }
         } else {
            class_cj var13 = var9 == this?var2.c():var2.d();
            IBlockData var14 = var1.p(var13.e());
            IBlockData var15 = var1.p(var13.f());
            var8 = class_cq.f;
            class_cq var16;
            if(var9 == this) {
               var16 = (class_cq)var4.get(a);
            } else {
               var16 = (class_cq)var5.get(a);
            }

            if(var16 == class_cq.e) {
               var8 = class_cq.e;
            }

            Block var17 = var14.getBlock();
            Block var18 = var15.getBlock();
            if((var11.q() || var17.q()) && !var12.q() && !var18.q()) {
               var8 = class_cq.f;
            }

            if((var12.q() || var18.q()) && !var11.q() && !var17.q()) {
               var8 = class_cq.e;
            }
         }

         var3 = var3.set(a, var8);
         var1.a((class_cj)var2, (IBlockData)var3, 3);
         return var3;
      }
   }

   public IBlockData f(class_aen var1, class_cj var2, IBlockData var3) {
      class_cq var4 = null;
      Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

      while(var5.hasNext()) {
         class_cq var6 = (class_cq)var5.next();
         IBlockData var7 = var1.p(var2.a(var6));
         if(var7.getBlock() == this) {
            return var3;
         }

         if(var7.getBlock().q()) {
            if(var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if(var4 != null) {
         return var3.set(a, var4.d());
      } else {
         class_cq var8 = (class_cq)var3.get(a);
         if(var1.p(var2.a(var8)).getBlock().q()) {
            var8 = var8.d();
         }

         if(var1.p(var2.a(var8)).getBlock().q()) {
            var8 = var8.e();
         }

         if(var1.p(var2.a(var8)).getBlock().q()) {
            var8 = var8.d();
         }

         return var3.set(a, var8);
      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      int var3 = 0;
      class_cj var4 = var2.e();
      class_cj var5 = var2.f();
      class_cj var6 = var2.c();
      class_cj var7 = var2.d();
      if(var1.p(var4).getBlock() == this) {
         if(this.m(var1, var4)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var5).getBlock() == this) {
         if(this.m(var1, var5)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var6).getBlock() == this) {
         if(this.m(var1, var6)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var7).getBlock() == this) {
         if(this.m(var1, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   private boolean m(class_aen var1, class_cj var2) {
      if(var1.p(var2).getBlock() != this) {
         return false;
      } else {
         Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (class_cq)var3.next();
         } while(var1.p(var2.a(var4)).getBlock() != this);

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_ami) {
         var5.E();
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_oj) {
         class_ol.a(var1, var2, (class_oj)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_ou var11 = this.f(var1, var2);
         if(var11 != null) {
            var4.a((class_oj)var11);
            if(this.b == 0) {
               var4.b(class_nc.aa);
            } else if(this.b == 1) {
               var4.b(class_nc.U);
            }
         }

         return true;
      }
   }

   public class_ou f(class_aen var1, class_cj var2) {
      class_amg var3 = var1.s(var2);
      if(!(var3 instanceof class_ami)) {
         return null;
      } else {
         Object var4 = (class_ami)var3;
         if(this.n(var1, var2)) {
            return null;
         } else {
            Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

            while(true) {
               while(true) {
                  class_cq var6;
                  class_amg var9;
                  do {
                     class_cj var7;
                     Block var8;
                     do {
                        if(!var5.hasNext()) {
                           return (class_ou)var4;
                        }

                        var6 = (class_cq)var5.next();
                        var7 = var2.a(var6);
                        var8 = var1.p(var7).getBlock();
                     } while(var8 != this);

                     if(this.n(var1, var7)) {
                        return null;
                     }

                     var9 = var1.s(var7);
                  } while(!(var9 instanceof class_ami));

                  if(var6 != class_cq.e && var6 != class_cq.c) {
                     var4 = new class_oi("container.chestDouble", (class_ou)var4, (class_ami)var9);
                  } else {
                     var4 = new class_oi("container.chestDouble", (class_ami)var9, (class_ou)var4);
                  }
               }
            }
         }
      }
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_ami();
   }

   public boolean i() {
      return this.b == 1;
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      if(!this.i()) {
         return 0;
      } else {
         int var5 = 0;
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_ami) {
            var5 = ((class_ami)var6).l;
         }

         return class_nu.a(var5, 0, 15);
      }
   }

   public int b(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return var4 == class_cq.b?this.a(var1, var2, var3, var4):0;
   }

   private boolean n(class_aen var1, class_cj var2) {
      return this.o(var1, var2) || this.p(var1, var2);
   }

   private boolean o(class_aen var1, class_cj var2) {
      return var1.p(var2.a()).getBlock().x();
   }

   private boolean p(class_aen var1, class_cj var2) {
      Iterator var3 = var1.a(class_uc.class, new class_awf((double)var2.n(), (double)(var2.o() + 1), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 2), (double)(var2.p() + 1))).iterator();

      class_uc var5;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         class_pr var4 = (class_pr)var3.next();
         var5 = (class_uc)var4;
      } while(!var5.cC());

      return true;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return class_xz.b((class_oj)this.f(var1, var2));
   }

   public IBlockData a(int var1) {
      class_cq var2 = class_cq.a(var1);
      if(var2.k() == class_cq.class_a_in_class_cq.b) {
         var2 = class_cq.c;
      }

      return this.S().set(a, var2);
   }

   public int c(IBlockData var1) {
      return ((class_cq)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((class_cq)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }

   static {
      a = class_aiv.O;
   }
}
