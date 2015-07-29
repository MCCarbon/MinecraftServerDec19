package net.minecraft.server;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_abf;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_adg;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ew;
import net.minecraft.server.class_fa;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_va;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;

public final class class_aas {
   public static final DecimalFormat a = new DecimalFormat("#.###");
   public int b;
   public int c;
   private Item d;
   private class_dn e;
   private int f;
   private class_va g;
   private Block h;
   private boolean i;
   private Block j;
   private boolean k;

   public class_aas(Block var1) {
      this((Block)var1, 1);
   }

   public class_aas(Block var1, int var2) {
      this((Block)var1, var2, 0);
   }

   public class_aas(Block var1, int var2, int var3) {
      this(Item.getByBlock(var1), var2, var3);
   }

   public class_aas(Item var1) {
      this((Item)var1, 1);
   }

   public class_aas(Item var1, int var2) {
      this((Item)var1, var2, 0);
   }

   public class_aas(Item var1, int var2, int var3) {
      this.h = null;
      this.i = false;
      this.j = null;
      this.k = false;
      this.d = var1;
      this.b = var2;
      this.f = var3;
      if(this.f < 0) {
         this.f = 0;
      }

   }

   public static class_aas a(class_dn var0) {
      class_aas var1 = new class_aas();
      var1.c(var0);
      return var1.b() != null?var1:null;
   }

   private class_aas() {
      this.h = null;
      this.i = false;
      this.j = null;
      this.k = false;
   }

   public class_aas a(int var1) {
      class_aas var2 = new class_aas(this.d, var1, this.f);
      if(this.e != null) {
         var2.e = (class_dn)this.e.b();
      }

      this.b -= var1;
      return var2;
   }

   public Item b() {
      return this.d;
   }

   public class_oq a(class_xa var1, World var2, class_cj var3, class_oo var4, class_cq var5, float var6, float var7, float var8) {
      class_oq var9 = this.b().a(this, var1, var2, var3, var4, var5, var6, var7, var8);
      if(var9 == class_oq.a) {
         var1.b(class_nc.ad[Item.getId(this.d)]);
      }

      return var9;
   }

   public float a(Block var1) {
      return this.b().a(this, var1);
   }

   public class_or a(World var1, class_xa var2, class_oo var3) {
      return this.b().a(this, var1, var2, var3);
   }

   public class_aas a(World var1, class_qa var2) {
      return this.b().a(this, var1, var2);
   }

   public class_dn b(class_dn var1) {
      MinecraftKey var2 = (MinecraftKey)Item.ITEM_REGISTRY.getKey(this.d);
      var1.a("id", var2 == null?"minecraft:air":var2.toString());
      var1.a("Count", (byte)this.b);
      var1.a("Damage", (short)this.f);
      if(this.e != null) {
         var1.a((String)"tag", (class_eb)this.e);
      }

      return var1;
   }

   public void c(class_dn var1) {
      if(var1.b("id", 8)) {
         this.d = Item.getByName(var1.k("id"));
      } else {
         this.d = Item.getById(var1.f("id"));
      }

      this.b = var1.e("Count");
      this.f = var1.f("Damage");
      if(this.f < 0) {
         this.f = 0;
      }

      if(var1.b("tag", 10)) {
         this.e = var1.n("tag");
         if(this.d != null) {
            this.d.a(this.e);
         }
      }

   }

   public int c() {
      return this.b().j();
   }

   public boolean d() {
      return this.c() > 1 && (!this.e() || !this.g());
   }

   public boolean e() {
      return this.d == null?false:(this.d.l() <= 0?false:!this.n() || !this.o().o("Unbreakable"));
   }

   public boolean f() {
      return this.d.k();
   }

   public boolean g() {
      return this.e() && this.f > 0;
   }

   public int h() {
      return this.f;
   }

   public int i() {
      return this.f;
   }

   public void b(int var1) {
      this.f = var1;
      if(this.f < 0) {
         this.f = 0;
      }

   }

   public int j() {
      return this.d.l();
   }

   public boolean a(int var1, Random var2) {
      if(!this.e()) {
         return false;
      } else {
         if(var1 > 0) {
            int var3 = class_adk.a(class_adm.r, this);
            int var4 = 0;

            for(int var5 = 0; var3 > 0 && var5 < var1; ++var5) {
               if(class_adg.a(this, var3, var2)) {
                  ++var4;
               }
            }

            var1 -= var4;
            if(var1 <= 0) {
               return false;
            }
         }

         this.f += var1;
         return this.f > this.j();
      }
   }

   public void a(int var1, class_qa var2) {
      if(!(var2 instanceof class_xa) || !((class_xa)var2).bH.d) {
         if(this.e()) {
            if(this.a(var1, var2.bd())) {
               var2.b(this);
               --this.b;
               if(var2 instanceof class_xa) {
                  class_xa var3 = (class_xa)var2;
                  var3.b(class_nc.ae[Item.getId(this.d)]);
               }

               if(this.b < 0) {
                  this.b = 0;
               }

               this.f = 0;
            }

         }
      }
   }

   public void a(class_qa var1, class_xa var2) {
      boolean var3 = this.d.a(this, (class_qa)var1, var2);
      if(var3) {
         var2.b(class_nc.ad[Item.getId(this.d)]);
      }

   }

   public void a(World var1, Block var2, class_cj var3, class_xa var4) {
      boolean var5 = this.d.a(this, var1, var2, var3, var4);
      if(var5) {
         var4.b(class_nc.ad[Item.getId(this.d)]);
      }

   }

   public boolean b(Block var1) {
      return this.d.b(var1);
   }

   public boolean a(class_xa var1, class_qa var2, class_oo var3) {
      return this.d.a(this, var1, var2, var3);
   }

   public class_aas k() {
      class_aas var1 = new class_aas(this.d, this.b, this.f);
      if(this.e != null) {
         var1.e = (class_dn)this.e.b();
      }

      return var1;
   }

   public static boolean a(class_aas var0, class_aas var1) {
      return var0 == null && var1 == null?true:(var0 != null && var1 != null?(var0.e == null && var1.e != null?false:var0.e == null || var0.e.equals(var1.e)):false);
   }

   public static boolean b(class_aas var0, class_aas var1) {
      return var0 == null && var1 == null?true:(var0 != null && var1 != null?var0.d(var1):false);
   }

   private boolean d(class_aas var1) {
      return this.b != var1.b?false:(this.d != var1.d?false:(this.f != var1.f?false:(this.e == null && var1.e != null?false:this.e == null || this.e.equals(var1.e))));
   }

   public static boolean c(class_aas var0, class_aas var1) {
      return var0 == null && var1 == null?true:(var0 != null && var1 != null?var0.a(var1):false);
   }

   public boolean a(class_aas var1) {
      return var1 != null && this.d == var1.d && this.f == var1.f;
   }

   public String a() {
      return this.d.e_(this);
   }

   public static class_aas b(class_aas var0) {
      return var0 == null?null:var0.k();
   }

   public String toString() {
      return this.b + "x" + this.d.a() + "@" + this.f;
   }

   public void a(World var1, class_pr var2, int var3, boolean var4) {
      if(this.c > 0) {
         --this.c;
      }

      this.d.a(this, var1, var2, var3, var4);
   }

   public void a(World var1, class_xa var2, int var3) {
      var2.a(class_nc.ac[Item.getId(this.d)], var3);
      this.d.b(this, var1, var2);
   }

   public int l() {
      return this.b().e(this);
   }

   public class_abz m() {
      return this.b().f(this);
   }

   public void a(World var1, class_qa var2, int var3) {
      this.b().a(this, var1, var2, var3);
   }

   public boolean n() {
      return this.e != null;
   }

   public class_dn o() {
      return this.e;
   }

   public class_dn a(String var1, boolean var2) {
      if(this.e != null && this.e.b(var1, 10)) {
         return this.e.n(var1);
      } else if(var2) {
         class_dn var3 = new class_dn();
         this.a((String)var1, (class_eb)var3);
         return var3;
      } else {
         return null;
      }
   }

   public class_du p() {
      return this.e == null?null:this.e.c("ench", 10);
   }

   public void d(class_dn var1) {
      this.e = var1;
   }

   public String q() {
      String var1 = this.b().a(this);
      if(this.e != null && this.e.b("display", 10)) {
         class_dn var2 = this.e.n("display");
         if(var2.b("Name", 8)) {
            var1 = var2.k("Name");
         }
      }

      return var1;
   }

   public class_aas c(String var1) {
      if(this.e == null) {
         this.e = new class_dn();
      }

      if(!this.e.b("display", 10)) {
         this.e.a((String)"display", (class_eb)(new class_dn()));
      }

      this.e.n("display").a("Name", var1);
      return this;
   }

   public void r() {
      if(this.e != null) {
         if(this.e.b("display", 10)) {
            class_dn var1 = this.e.n("display");
            var1.p("Name");
            if(var1.c_()) {
               this.e.p("display");
               if(this.e.c_()) {
                  this.d((class_dn)null);
               }
            }

         }
      }
   }

   public boolean s() {
      return this.e == null?false:(!this.e.b("display", 10)?false:this.e.n("display").b("Name", 8));
   }

   public class_abf u() {
      return this.b().g(this);
   }

   public boolean v() {
      return !this.b().f_(this)?false:!this.w();
   }

   public void a(class_adi var1, int var2) {
      if(this.e == null) {
         this.d(new class_dn());
      }

      if(!this.e.b("ench", 9)) {
         this.e.a((String)"ench", (class_eb)(new class_du()));
      }

      class_du var3 = this.e.c("ench", 10);
      class_dn var4 = new class_dn();
      var4.a("id", (short)class_adi.b(var1));
      var4.a("lvl", (short)((byte)var2));
      var3.a((class_eb)var4);
   }

   public boolean w() {
      return this.e != null && this.e.b("ench", 9);
   }

   public void a(String var1, class_eb var2) {
      if(this.e == null) {
         this.d(new class_dn());
      }

      this.e.a(var1, var2);
   }

   public boolean x() {
      return this.b().s();
   }

   public boolean y() {
      return this.g != null;
   }

   public void a(class_va var1) {
      this.g = var1;
   }

   public class_va z() {
      return this.g;
   }

   public int A() {
      return this.n() && this.e.b("RepairCost", 3)?this.e.g("RepairCost"):0;
   }

   public void c(int var1) {
      if(!this.n()) {
         this.e = new class_dn();
      }

      this.e.a("RepairCost", var1);
   }

   public Multimap a(class_pw var1) {
      Object var2;
      if(this.n() && this.e.b("AttributeModifiers", 9)) {
         var2 = HashMultimap.create();
         class_du var3 = this.e.c("AttributeModifiers", 10);

         for(int var4 = 0; var4 < var3.c(); ++var4) {
            class_dn var5 = var3.b(var4);
            class_qm var6 = class_wl.a(var5);
            if(var6 != null && var6.a().getLeastSignificantBits() != 0L && var6.a().getMostSignificantBits() != 0L) {
               ((Multimap)var2).put(var5.k("AttributeName"), var6);
            }
         }
      } else {
         var2 = this.b().a(var1);
      }

      return (Multimap)var2;
   }

   public void a(Item var1) {
      this.d = var1;
   }

   public class_eu B() {
      class_fa var1 = new class_fa(this.q());
      if(this.s()) {
         var1.b().b(Boolean.valueOf(true));
      }

      class_eu var2 = (new class_fa("[")).a(var1).a("]");
      if(this.d != null) {
         class_dn var3 = new class_dn();
         this.b(var3);
         var2.b().a(new class_ew(class_ew.class_a_in_class_ew.c, new class_fa(var3.toString())));
         var2.b().a(this.u().e);
      }

      return var2;
   }

   public boolean c(Block var1) {
      if(var1 == this.h) {
         return this.i;
      } else {
         this.h = var1;
         if(this.n() && this.e.b("CanDestroy", 9)) {
            class_du var2 = this.e.c("CanDestroy", 8);

            for(int var3 = 0; var3 < var2.c(); ++var3) {
               Block var4 = Block.getByName(var2.g(var3));
               if(var4 == var1) {
                  this.i = true;
                  return true;
               }
            }
         }

         this.i = false;
         return false;
      }
   }

   public boolean d(Block var1) {
      if(var1 == this.j) {
         return this.k;
      } else {
         this.j = var1;
         if(this.n() && this.e.b("CanPlaceOn", 9)) {
            class_du var2 = this.e.c("CanPlaceOn", 8);

            for(int var3 = 0; var3 < var2.c(); ++var3) {
               Block var4 = Block.getByName(var2.g(var3));
               if(var4 == var1) {
                  this.k = true;
                  return true;
               }
            }
         }

         this.k = false;
         return false;
      }
   }
}
