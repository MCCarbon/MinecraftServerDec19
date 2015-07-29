package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ana;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;

public class class_ahr extends class_agd {
   protected class_ahr(class_atk var1) {
      super(var1);
      this.a(1.0F);
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_ana();
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public class_atl g(IBlockData var1) {
      return class_atl.E;
   }
}
