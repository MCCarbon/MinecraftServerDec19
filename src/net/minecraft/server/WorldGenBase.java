package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.class_aph;

public class WorldGenBase {
   protected int a = 8;
   protected Random b = new Random();
   protected World c;

   public void a(IChunkProvider var1, World var2, int var3, int var4, class_aph var5) {
      int var6 = this.a;
      this.c = var2;
      this.b.setSeed(var2.K());
      long var7 = this.b.nextLong();
      long var9 = this.b.nextLong();

      for(int var11 = var3 - var6; var11 <= var3 + var6; ++var11) {
         for(int var12 = var4 - var6; var12 <= var4 + var6; ++var12) {
            long var13 = (long)var11 * var7;
            long var15 = (long)var12 * var9;
            this.b.setSeed(var13 ^ var15 ^ var2.K());
            this.a(var2, var11, var12, var3, var4, var5);
         }
      }

   }

   protected void a(World var1, int var2, int var3, int var4, int var5, class_aph var6) {
   }
}
