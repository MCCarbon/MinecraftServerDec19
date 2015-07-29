package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_aju extends Block {
   public class_aju() {
      this(class_atk.e.r());
   }

   public class_aju(class_atl var1) {
      super(class_atk.e, var1);
      this.a((CreativeTab)CreativeTab.b);
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return this == class_agk.q?class_aau.j:(this == class_agk.ag?class_aau.k:(this == class_agk.x?class_aau.aY:(this == class_agk.bP?class_aau.bR:(this == class_agk.co?class_aau.cj:class_aar.a((Block)this)))));
   }

   public int a(Random var1) {
      return this == class_agk.x?4 + var1.nextInt(5):1;
   }

   public int a(int var1, Random var2) {
      if(var1 > 0 && class_aar.a((Block)this) != this.a((IBlockData)this.R().a().iterator().next(), var2, var1)) {
         int var3 = var2.nextInt(var1 + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.a(var2) * (var3 + 1);
      } else {
         return this.a(var2);
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(this.a(var3, var1.s, var5) != class_aar.a((Block)this)) {
         int var6 = 0;
         if(this == class_agk.q) {
            var6 = class_nu.a((Random)var1.s, 0, 2);
         } else if(this == class_agk.ag) {
            var6 = class_nu.a((Random)var1.s, 3, 7);
         } else if(this == class_agk.bP) {
            var6 = class_nu.a((Random)var1.s, 3, 7);
         } else if(this == class_agk.x) {
            var6 = class_nu.a((Random)var1.s, 2, 5);
         } else if(this == class_agk.co) {
            var6 = class_nu.a((Random)var1.s, 2, 5);
         }

         this.b(var1, var2, var6);
      }

   }

   public int j(class_aen var1, class_cj var2) {
      return 0;
   }

   public int a(IBlockData var1) {
      return this == class_agk.x?class_zy.l.b():0;
   }
}
