package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_aku;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cj;

public class class_ale extends class_aku {
   public static final class_anz a = class_anz.a("rotation", 0, 15);

   public class_ale() {
      this.j(this.M.b().set(a, Integer.valueOf(0)));
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      if(!var1.p(var2.b()).getBlock().v().a()) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   public IBlockData a(int var1) {
      return this.S().set(a, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, Integer.valueOf(var2.a(((Integer)var1.get(a)).intValue(), 16)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, Integer.valueOf(var2.a(((Integer)var1.get(a)).intValue(), 16)));
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }
}
