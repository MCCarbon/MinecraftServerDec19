package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.CreativeTab;

public class class_agm extends Block {
   public class_agm() {
      super(class_atk.d);
      this.a(CreativeTab.b);
   }

   public int a(Random var1) {
      return 3;
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.aN;
   }
}
