package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_xa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_vm extends class_pr {
   private static final Logger b = LogManager.getLogger();
   private static final int c = class_qi.a(class_vm.class);
   private int d;
   private int e;
   private int f;
   private String g;
   private String h;
   public float a;

   public class_vm(World var1, double var2, double var4, double var6) {
      super(var1);
      this.f = 5;
      this.a = (float)(Math.random() * 3.141592653589793D * 2.0D);
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
      this.y = (float)(Math.random() * 360.0D);
      this.v = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
      this.w = 0.20000000298023224D;
      this.x = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
   }

   public class_vm(World var1, double var2, double var4, double var6, class_aas var8) {
      this(var1, var2, var4, var6);
      this.a(var8);
   }

   protected boolean s_() {
      return false;
   }

   public class_vm(World var1) {
      super(var1);
      this.f = 5;
      this.a = (float)(Math.random() * 3.141592653589793D * 2.0D);
      this.a(0.25F, 0.25F);
      this.a(new class_aas(Blocks.AIR, 0));
   }

   protected void h() {
      this.H().a(c, 5);
   }

   public void t_() {
      if(this.l() == null) {
         this.J();
      } else {
         super.t_();
         if(this.e > 0 && this.e != 32767) {
            --this.e;
         }

         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         this.w -= 0.03999999910593033D;
         this.T = this.j(this.s, (this.aT().b + this.aT().e) / 2.0D, this.u);
         this.d(this.v, this.w, this.x);
         boolean var1 = (int)this.p != (int)this.s || (int)this.q != (int)this.t || (int)this.r != (int)this.u;
         if(var1 || this.W % 25 == 0) {
            if(this.o.p(new BlockPosition(this)).getBlock().getMaterial() == Material.LAVA) {
               this.w = 0.20000000298023224D;
               this.v = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
               this.x = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
               this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
            }

            if(!this.o.D) {
               this.w();
            }
         }

         float var2 = 0.98F;
         if(this.C) {
            var2 = this.o.p(new BlockPosition(MathHelper.floor(this.s), MathHelper.floor(this.aT().b) - 1, MathHelper.floor(this.u))).getBlock().frictionFactor * 0.98F;
         }

         this.v *= (double)var2;
         this.w *= 0.9800000190734863D;
         this.x *= (double)var2;
         if(this.C) {
            this.w *= -0.5D;
         }

         if(this.d != -32768) {
            ++this.d;
         }

         this.W();
         if(!this.o.D && this.d >= 6000) {
            this.J();
         }

      }
   }

   private void w() {
      Iterator var1 = this.o.a(class_vm.class, this.aT().b(0.5D, 0.0D, 0.5D)).iterator();

      while(var1.hasNext()) {
         class_vm var2 = (class_vm)var1.next();
         this.a(var2);
      }

   }

   private boolean a(class_vm var1) {
      if(var1 == this) {
         return false;
      } else if(var1.ai() && this.ai()) {
         class_aas var2 = this.l();
         class_aas var3 = var1.l();
         if(this.e != 32767 && var1.e != 32767) {
            if(this.d != -32768 && var1.d != -32768) {
               if(var3.b() != var2.b()) {
                  return false;
               } else if(var3.n() ^ var2.n()) {
                  return false;
               } else if(var3.n() && !var3.o().equals(var2.o())) {
                  return false;
               } else if(var3.b() == null) {
                  return false;
               } else if(var3.b().k() && var3.i() != var2.i()) {
                  return false;
               } else if(var3.b < var2.b) {
                  return var1.a(this);
               } else if(var3.b + var2.b > var3.c()) {
                  return false;
               } else {
                  var3.b += var2.b;
                  var1.e = Math.max(var1.e, this.e);
                  var1.d = Math.min(var1.d, this.d);
                  var1.a(var3);
                  this.J();
                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void j() {
      this.d = 4800;
   }

   public boolean W() {
      if(this.o.a((class_awf)this.aT(), (Material)Material.WATER, (class_pr)this)) {
         if(!this.Y && !this.aa) {
            this.X();
         }

         this.Y = true;
      } else {
         this.Y = false;
      }

      return this.Y;
   }

   protected void g(int var1) {
      this.a(class_pc.a, (float)var1);
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else if(this.l() != null && this.l().b() == Items.cc && var1.c()) {
         return false;
      } else {
         this.ac();
         this.f = (int)((float)this.f - var2);
         if(this.f <= 0) {
            this.J();
         }

         return false;
      }
   }

   public void b(class_dn var1) {
      var1.a("Health", (short)((byte)this.f));
      var1.a("Age", (short)this.d);
      var1.a("PickupDelay", (short)this.e);
      if(this.n() != null) {
         var1.a("Thrower", this.g);
      }

      if(this.m() != null) {
         var1.a("Owner", this.h);
      }

      if(this.l() != null) {
         var1.a((String)"Item", (class_eb)this.l().b(new class_dn()));
      }

   }

   public void a(class_dn var1) {
      this.f = var1.f("Health") & 255;
      this.d = var1.f("Age");
      if(var1.d("PickupDelay")) {
         this.e = var1.f("PickupDelay");
      }

      if(var1.d("Owner")) {
         this.h = var1.k("Owner");
      }

      if(var1.d("Thrower")) {
         this.g = var1.k("Thrower");
      }

      class_dn var2 = var1.n("Item");
      this.a(class_aas.a(var2));
      if(this.l() == null) {
         this.J();
      }

   }

   public void d(class_xa var1) {
      if(!this.o.D) {
         class_aas var2 = this.l();
         int var3 = var2.b;
         if(this.e == 0 && (this.h == null || 6000 - this.d <= 200 || this.h.equals(var1.e_())) && var1.bp.a(var2)) {
            if(var2.b() == Item.getByBlock(Blocks.LOG)) {
               var1.b((class_my)class_mt.g);
            }

            if(var2.b() == Item.getByBlock(Blocks.LOG2)) {
               var1.b((class_my)class_mt.g);
            }

            if(var2.b() == Items.aH) {
               var1.b((class_my)class_mt.t);
            }

            if(var2.b() == Items.k) {
               var1.b((class_my)class_mt.w);
            }

            if(var2.b() == Items.bx) {
               var1.b((class_my)class_mt.A);
            }

            if(var2.b() == Items.k && this.n() != null) {
               class_xa var4 = this.o.a(this.n());
               if(var4 != null && var4 != var1) {
                  var4.b((class_my)class_mt.x);
               }
            }

            if(!this.R()) {
               this.o.a((class_pr)var1, "random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }

            var1.a(this, var3);
            if(var2.b <= 0) {
               this.J();
            }
         }

      }
   }

   public String e_() {
      return this.l_()?this.aO():LocaleI18n.get("item." + this.l().a());
   }

   public boolean aF() {
      return false;
   }

   public void c(int var1) {
      super.c(var1);
      if(!this.o.D) {
         this.w();
      }

   }

   public class_aas l() {
      class_aas var1 = this.H().f(c);
      if(var1 == null) {
         if(this.o != null) {
            b.error("Item entity " + this.F() + " has no item?!");
         }

         return new class_aas(Blocks.STONE);
      } else {
         return var1;
      }
   }

   public void a(class_aas var1) {
      this.H().b(c, var1);
      this.H().i(c);
   }

   public String m() {
      return this.h;
   }

   public void b(String var1) {
      this.h = var1;
   }

   public String n() {
      return this.g;
   }

   public void c(String var1) {
      this.g = var1;
   }

   public void p() {
      this.e = 10;
   }

   public void q() {
      this.e = 0;
   }

   public void r() {
      this.e = 32767;
   }

   public void a(int var1) {
      this.e = var1;
   }

   public boolean s() {
      return this.e > 0;
   }

   public void u() {
      this.d = -6000;
   }

   public void v() {
      this.r();
      this.d = 5999;
   }
}
