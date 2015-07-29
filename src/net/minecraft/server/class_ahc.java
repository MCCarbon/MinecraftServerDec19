package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_op;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yh;
import net.minecraft.server.CreativeTab;

public class class_ahc extends Block {
   protected class_ahc() {
      super(Material.d);
      this.a(CreativeTab.c);
   }

   public boolean a(World var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         var4.a((class_op)(new class_ahc.class_a_in_class_ahc(var1, var2)));
         var4.b(class_nc.Z);
         return true;
      }
   }

   public static class class_a_in_class_ahc implements class_op {
      private final World a;
      private final class_cj b;

      public class_a_in_class_ahc(World var1, class_cj var2) {
         this.a = var1;
         this.b = var2;
      }

      public String e_() {
         return null;
      }

      public boolean l_() {
         return false;
      }

      public class_eu f_() {
         return new class_fb(Blocks.CRAFTING_TABLE.getInternalName() + ".name", new Object[0]);
      }

      public class_xz a(class_wz var1, class_xa var2) {
         return new class_yh(var1, this.a, this.b);
      }

      public String k() {
         return "minecraft:crafting_table";
      }
   }
}
