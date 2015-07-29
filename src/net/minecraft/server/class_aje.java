package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_akp;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.INamable;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public abstract class class_aje extends class_akp {
   public static final BlockStateEnum a = BlockStateEnum.of("axis", class_aje.class_a_in_class_aje.class);

   public class_aje() {
      super(Material.d);
      this.a(CreativeTab.b);
      this.setStrength(2.0F);
      this.setStepSound(STEP_SOUND_WOOD);
   }

   public void b(World var1, class_cj var2, IBlockData var3) {
      byte var4 = 4;
      int var5 = var4 + 1;
      if(var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
         Iterator var6 = class_cj.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

         while(var6.hasNext()) {
            class_cj var7 = (class_cj)var6.next();
            IBlockData var8 = var1.p(var7);
            if(var8.getBlock().getMaterial() == Material.j && !((Boolean)var8.get(class_aja.b)).booleanValue()) {
               var1.a((class_cj)var7, (IBlockData)var8.set(class_aja.b, Boolean.valueOf(true)), 4);
            }
         }

      }
   }

   public IBlockData a(World var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.fromLegacyData(var7).set(a, class_aje.class_a_in_class_aje.a(var3.k()));
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_aje.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_aje.SyntheticClass_1.a[((class_aje.class_a_in_class_aje)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, class_aje.class_a_in_class_aje.c);
            case 2:
               return var1.set(a, class_aje.class_a_in_class_aje.a);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[class_cq.class_a_in_class_cq.values().length];

      static {
         try {
            c[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            c[class_cq.class_a_in_class_cq.b.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            c[class_cq.class_a_in_class_cq.c.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
            ;
         }

         b = new int[Block.class_c_in_class_agj.values().length];

         try {
            b[Block.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[class_aje.class_a_in_class_aje.values().length];

         try {
            a[class_aje.class_a_in_class_aje.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_aje.class_a_in_class_aje.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_aje implements INamable {
      a("x"),
      b("y"),
      c("z"),
      d("none");

      private final String e;

      private class_a_in_class_aje(String var3) {
         this.e = var3;
      }

      public String toString() {
         return this.e;
      }

      public static class_aje.class_a_in_class_aje a(class_cq.class_a_in_class_cq var0) {
         switch(class_aje.SyntheticClass_1.c[var0.ordinal()]) {
         case 1:
            return a;
         case 2:
            return b;
         case 3:
            return c;
         default:
            return d;
         }
      }

      public String getName() {
         return this.e;
      }
   }
}
