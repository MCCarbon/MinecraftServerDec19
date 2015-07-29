package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_agz extends Block {
   public static final class_any a = class_any.a("color", class_zy.class);

   public class_agz(class_atk var1) {
      super(var1);
      this.j(this.M.b().set(a, class_zy.a));
      this.a(CreativeTab.b);
   }

   public int a(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public class_atl g(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_zy.b(var1));
   }

   public int c(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }
}
