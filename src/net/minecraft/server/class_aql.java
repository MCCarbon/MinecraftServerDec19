package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;

public abstract class class_aql {
   private final boolean a;

   public class_aql() {
      this(false);
   }

   public class_aql(boolean var1) {
      this.a = var1;
   }

   public abstract boolean b(World var1, Random var2, class_cj var3);

   public void e() {
   }

   protected void a(World var1, class_cj var2, IBlockData var3) {
      if(this.a) {
         var1.a((class_cj)var2, (IBlockData)var3, 3);
      } else {
         var1.a((class_cj)var2, (IBlockData)var3, 2);
      }

   }
}
