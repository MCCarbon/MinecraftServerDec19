package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amz;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_ast;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_all extends class_agd {
   public static final class_any a = class_any.a("mode", class_amz.class_a_in_class_amz.class);
   private final class_ast b = new class_ast();

   public class_all() {
      super(class_atk.f, class_atl.x);
      this.j(this.M.b());
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amz();
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      return false;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
   }

   public int a(Random var1) {
      return 0;
   }

   public int b() {
      return 3;
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().set(a, class_amz.class_a_in_class_amz.d);
   }

   public class_ast l() {
      return this.b;
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_amz.class_a_in_class_amz.a(var1));
   }

   public int c(IBlockData var1) {
      return ((class_amz.class_a_in_class_amz)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }
}
