package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_nu;
import net.minecraft.server.CreativeTab;

public class class_aij extends Block {
   public class_aij(class_atk var1) {
      super(var1);
      this.a(CreativeTab.b);
   }

   public int a(int var1, Random var2) {
      return class_nu.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 4);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(3);
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.aV;
   }

   public class_atl g(IBlockData var1) {
      return class_atl.d;
   }
}
