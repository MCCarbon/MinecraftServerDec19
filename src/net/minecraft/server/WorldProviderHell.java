package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldChunkManagerHell;
import net.minecraft.server.class_aoe;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.WorldProvider;
import net.minecraft.server.class_aoz;
import net.minecraft.server.class_apl;

public class WorldProviderHell extends WorldProvider {
   public void b() {
      this.c = new WorldChunkManagerHell(BiomeBase.HELL, 0.0F);
      this.d = true;
      this.e = true;
   }

   protected void a() {
      float var1 = 0.1F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public IChunkProvider c() {
      return new class_apl(this.b, this.b.Q().s(), this.b.K());
   }

   public boolean d() {
      return false;
   }

   public boolean a(int var1, int var2) {
      return false;
   }

   public float a(long var1, float var3) {
      return 0.5F;
   }

   public boolean e() {
      return false;
   }

   public class_aoe o() {
      return new class_aoe() {
         public double f() {
            return super.f() / 8.0D;
         }

         public double g() {
            return super.g() / 8.0D;
         }
      };
   }

   public class_aoz p() {
      return class_aoz.b;
   }
}
