package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.CreativeTab;

public class class_ajr extends Block {
   public class_ajr() {
      super(class_atk.e);
      this.a(CreativeTab.b);
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aar.a(class_agk.Z);
   }

   public class_atl g(IBlockData var1) {
      return class_atl.E;
   }
}
