package net.minecraft.server;

import net.minecraft.server.class_aaq;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abc;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_act;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yg;
import net.minecraft.server.class_yx;

public class class_yw extends class_yx {
   private final class_yg a;
   private final class_xa b;
   private int c;

   public class_yw(class_xa var1, class_yg var2, class_oj var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.b = var1;
      this.a = var2;
   }

   public boolean a(class_aas var1) {
      return false;
   }

   public class_aas a(int var1) {
      if(this.e()) {
         this.c += Math.min(var1, this.d().b);
      }

      return super.a(var1);
   }

   protected void a(class_aas var1, int var2) {
      this.c += var2;
      this.c(var1);
   }

   protected void c(class_aas var1) {
      if(this.c > 0) {
         var1.a(this.b.o, this.b, this.c);
      }

      this.c = 0;
      if(var1.b() == Item.getByBlock(Blocks.CRAFTING_TABLE)) {
         this.b.b((class_my)class_mt.h);
      }

      if(var1.b() instanceof class_abc) {
         this.b.b((class_my)class_mt.i);
      }

      if(var1.b() == Item.getByBlock(Blocks.FURNACE)) {
         this.b.b((class_my)class_mt.j);
      }

      if(var1.b() instanceof class_aaq) {
         this.b.b((class_my)class_mt.l);
      }

      if(var1.b() == Items.R) {
         this.b.b((class_my)class_mt.m);
      }

      if(var1.b() == Items.bb) {
         this.b.b((class_my)class_mt.n);
      }

      if(var1.b() instanceof class_abc && ((class_abc)var1.b()).g() != Item.class_a_in_class_aar.a) {
         this.b.b((class_my)class_mt.o);
      }

      if(var1.b() instanceof class_abw) {
         this.b.b((class_my)class_mt.r);
      }

      if(var1.b() == Item.getByBlock(Blocks.ENCHANTING_TABLE)) {
         this.b.b((class_my)class_mt.E);
      }

      if(var1.b() == Item.getByBlock(Blocks.BOOKSHELF)) {
         this.b.b((class_my)class_mt.G);
      }

      if(var1.b() == Items.aq && var1.i() == 1) {
         this.b.b((class_my)class_mt.M);
      }

   }

   public void a(class_xa var1, class_aas var2) {
      this.c(var2);
      class_aas[] var3 = class_act.a().b(this.a, var1.o);

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class_aas var5 = this.a.a(var4);
         class_aas var6 = var3[var4];
         if(var5 != null) {
            this.a.a(var4, 1);
         }

         if(var6 != null) {
            if(this.a.a(var4) == null) {
               this.a.a(var4, var6);
            } else if(!this.b.bp.a(var6)) {
               this.b.a(var6, false);
            }
         }
      }

   }
}
