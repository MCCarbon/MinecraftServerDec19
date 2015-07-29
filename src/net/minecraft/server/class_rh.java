package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alm;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_ant;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_rm;

public class class_rh extends class_rm {
   private static final Predicate b;
   private class_qb c;
   private World d;
   int a;

   public class_rh(class_qb var1) {
      this.c = var1;
      this.d = var1.o;
      this.a(7);
   }

   public boolean a() {
      if(this.c.bd().nextInt(this.c.j_()?50:1000) != 0) {
         return false;
      } else {
         class_cj var1 = new class_cj(this.c.s, this.c.t, this.c.u);
         return b.apply(this.d.p(var1))?true:this.d.p(var1.b()).getBlock() == Blocks.GRASS;
      }
   }

   public void c() {
      this.a = 40;
      this.d.a((class_pr)this.c, (byte)10);
      this.c.u().n();
   }

   public void d() {
      this.a = 0;
   }

   public boolean b() {
      return this.a > 0;
   }

   public int f() {
      return this.a;
   }

   public void e() {
      this.a = Math.max(0, this.a - 1);
      if(this.a == 4) {
         class_cj var1 = new class_cj(this.c.s, this.c.t, this.c.u);
         if(b.apply(this.d.p(var1))) {
            if(this.d.R().b("mobGriefing")) {
               this.d.b(var1, false);
            }

            this.c.x();
         } else {
            class_cj var2 = var1.b();
            if(this.d.p(var2).getBlock() == Blocks.GRASS) {
               if(this.d.R().b("mobGriefing")) {
                  this.d.b(2001, var2, Block.getId((Block)Blocks.GRASS));
                  this.d.a((class_cj)var2, (IBlockData)Blocks.DIRT.getBlockData(), 2);
               }

               this.c.x();
            }
         }

      }
   }

   static {
      b = class_ant.a((Block)Blocks.TALLGRASS).a(class_alm.a, Predicates.equalTo(class_alm.class_a_in_class_alm.b));
   }
}
