package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_akl extends Block {
   private final boolean a;

   public class_akl(boolean var1) {
      super(class_atk.t);
      this.a = var1;
      if(var1) {
         this.a(1.0F);
      }

   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)class_agk.bJ.S(), 2);
         } else if(!this.a && var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)class_agk.bK.S(), 2);
         }

      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a((class_cj)var2, (Block)this, 4);
         } else if(!this.a && var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)class_agk.bK.S(), 2);
         }

      }
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)class_agk.bJ.S(), 2);
         }

      }
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aar.a(class_agk.bJ);
   }

   protected class_aas i(IBlockData var1) {
      return new class_aas(class_agk.bJ);
   }
}
