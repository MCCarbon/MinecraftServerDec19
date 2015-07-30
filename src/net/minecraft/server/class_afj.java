package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_aqs;
import net.minecraft.server.class_aqt;
import net.minecraft.server.class_ark;
import net.minecraft.server.BlockPosition;

public class class_afj extends class_aez {
   private boolean aD;
   private class_aqt aE = new class_aqt();
   private class_aqs aF = new class_aqs(4);

   public class_afj(int var1, boolean var2) {
      super(var1);
      this.aD = var2;
      if(var2) {
         this.ak = Blocks.SNOW.getBlockData();
      }

      this.au.clear();
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      if(this.aD) {
         int var4;
         int var5;
         int var6;
         for(var4 = 0; var4 < 3; ++var4) {
            var5 = var2.nextInt(16) + 8;
            var6 = var2.nextInt(16) + 8;
            this.aE.b(var1, var2, var1.m(var3.add(var5, 0, var6)));
         }

         for(var4 = 0; var4 < 2; ++var4) {
            var5 = var2.nextInt(16) + 8;
            var6 = var2.nextInt(16) + 8;
            this.aF.b(var1, var2, var1.m(var3.add(var5, 0, var6)));
         }
      }

      super.a(var1, var2, var3);
   }

   public class_apw a(Random var1) {
      return new class_ark(false);
   }

   protected class_aez d(int var1) {
      class_aez var2 = (new class_afj(var1, true)).a(13828095, true).a(this.ah + " Spikes").c().a(0.0F, 0.5F).a(new class_aez.class_a_in_class_aez(this.an + 0.1F, this.ao + 0.1F));
      var2.an = this.an + 0.3F;
      var2.ao = this.ao + 0.4F;
      return var2;
   }
}
