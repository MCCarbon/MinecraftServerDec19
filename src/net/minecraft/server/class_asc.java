package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_asd;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;
import net.minecraft.server.class_vy;
import net.minecraft.server.class_wh;
import net.minecraft.server.class_wj;
import net.minecraft.server.class_wn;

public class class_asc extends class_ask {
   private List d = Lists.newArrayList();

   public class_asc() {
      this.d.add(new BiomeBase.class_c_in_class_aez(class_vy.class, 10, 2, 3));
      this.d.add(new BiomeBase.class_c_in_class_aez(class_wj.class, 5, 4, 4));
      this.d.add(new BiomeBase.class_c_in_class_aez(class_wn.class, 10, 4, 4));
      this.d.add(new BiomeBase.class_c_in_class_aez(class_wh.class, 3, 4, 4));
   }

   public String a() {
      return "Fortress";
   }

   public List b() {
      return this.d;
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1 >> 4;
      int var4 = var2 >> 4;
      this.b.setSeed((long)(var3 ^ var4 << 4) ^ this.c.K());
      this.b.nextInt();
      return this.b.nextInt(3) != 0?false:(var1 != (var3 << 4) + 4 + this.b.nextInt(8)?false:var2 == (var4 << 4) + 4 + this.b.nextInt(8));
   }

   protected class_aso b(int var1, int var2) {
      return new class_asc.class_a_in_class_asc(this.c, this.b, var1, var2);
   }

   public static class class_a_in_class_asc extends class_aso {
      public class_a_in_class_asc() {
      }

      public class_a_in_class_asc(World var1, Random var2, int var3, int var4) {
         super(var3, var4);
         class_asd.class_q_in_class_asd var5 = new class_asd.class_q_in_class_asd(var2, (var3 << 4) + 2, (var4 << 4) + 2);
         this.a.add(var5);
         var5.a(var5, this.a, var2);
         List var6 = var5.e;

         while(!var6.isEmpty()) {
            int var7 = var2.nextInt(var6.size());
            class_asn var8 = (class_asn)var6.remove(var7);
            var8.a((class_asn)var5, (List)this.a, (Random)var2);
         }

         this.d();
         this.a(var1, var2, 48, 70);
      }
   }
}
