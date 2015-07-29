package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.CreativeTab;

public class class_aly extends Block {
   public class_aly() {
      super(class_atk.G);
      this.a(CreativeTab.c);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_pr var4) {
      var4.aC();
   }

   public boolean c() {
      return false;
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.H;
   }

   protected boolean K() {
      return true;
   }
}
