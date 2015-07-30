package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_ck;

public class class_cl implements class_ck {
   private final World a;
   private final BlockPosition b;

   public class_cl(World var1, BlockPosition var2) {
      this.a = var1;
      this.b = var2;
   }

   public World i() {
      return this.a;
   }

   public double a() {
      return (double)this.b.getX() + 0.5D;
   }

   public double b() {
      return (double)this.b.getY() + 0.5D;
   }

   public double c() {
      return (double)this.b.getZ() + 0.5D;
   }

   public BlockPosition d() {
      return this.b;
   }

   public int f() {
      IBlockData var1 = this.a.p(this.b);
      return var1.getBlock().toLegacyData(var1);
   }

   public class_amg h() {
      return this.a.s(this.b);
   }
}
