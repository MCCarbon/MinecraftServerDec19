package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aio;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_ny;
import net.minecraft.server.CreativeTab;

public abstract class class_ake extends class_aio {
   public static final class_any b = class_any.a("variant", class_ake.class_c_in_class_ake.class);

   public class_ake() {
      super(class_atk.e);
      IBlockData var1 = this.M.b();
      if(!this.l()) {
         var1 = var1.set(a, class_aio.class_a_in_class_aio.b);
      }

      this.j(var1.set(b, class_ake.class_c_in_class_ake.a));
      this.a(CreativeTab.b);
   }

   public IBlockData a(int var1) {
      IBlockData var2 = this.S().set(b, class_ake.class_c_in_class_ake.a);
      if(!this.l()) {
         var2 = var2.set(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int c(IBlockData var1) {
      int var2 = 0;
      if(!this.l() && var1.get(a) == class_aio.class_a_in_class_aio.a) {
         var2 |= 8;
      }

      return var2;
   }

   protected class_anm e() {
      return this.l()?new class_anm(this, new IBlockState[]{b}):new class_anm(this, new IBlockState[]{a, b});
   }

   public String b(int var1) {
      return super.a();
   }

   public IBlockState n() {
      return b;
   }

   public Object a(class_aas var1) {
      return class_ake.class_c_in_class_ake.a;
   }

   public static enum class_c_in_class_ake implements class_ny {
      a;

      public String l() {
         return "default";
      }
   }

   public static class class_a_in_class_ake extends class_ake {
      public boolean l() {
         return true;
      }
   }

   public static class class_b_in_class_ake extends class_ake {
      public boolean l() {
         return false;
      }
   }
}
