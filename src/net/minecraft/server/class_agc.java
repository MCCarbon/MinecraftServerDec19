package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_agc extends Block {
   protected class_agc() {
      super(class_atk.I);
      this.z();
      this.b(6000001.0F);
      this.M();
      this.t = true;
   }

   public int b() {
      return -1;
   }

   public boolean c() {
      return false;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
   }
}
