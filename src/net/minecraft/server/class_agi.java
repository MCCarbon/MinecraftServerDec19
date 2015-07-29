package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_cj;

public class class_agi extends class_ahd {
   public static final class_anz a = class_anz.a("age", 0, 3);

   protected class_anz l() {
      return a;
   }

   public int n() {
      return 3;
   }

   protected class_aar o() {
      return class_aau.cK;
   }

   protected class_aar p() {
      return class_aau.cL;
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(var4.nextInt(3) == 0) {
         this.e(var1, var2, var3);
      } else {
         super.b(var1, var2, var3, var4);
      }

   }

   protected int b(class_aen var1) {
      return super.b(var1) / 3;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
