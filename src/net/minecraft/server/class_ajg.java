package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_ajg extends class_agd {
   protected class_ajg() {
      super(class_atk.e);
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amv();
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      int var6 = 15 + var1.s.nextInt(15) + var1.s.nextInt(15);
      this.b(var1, var2, var6);
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }
}
