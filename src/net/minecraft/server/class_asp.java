package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_asu;
import net.minecraft.server.class_asv;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;

public abstract class class_asp extends class_asn {
   private static final class_asu d = new class_asu();
   protected class_asv a;
   protected class_asu b;
   protected class_cj c;

   public class_asp() {
      this.b = d.a(true).b(true);
   }

   public class_asp(int var1) {
      super(var1);
      this.b = d.a(true).b(true);
   }

   protected void a(class_asv var1, class_cj var2, class_asu var3) {
      this.a = var1;
      this.a(class_cq.c);
      this.c = var2;
      this.b = var3;
      this.h();
   }

   protected void a(class_dn var1) {
      var1.a("TPX", this.c.n());
      var1.a("TPY", this.c.o());
      var1.a("TPZ", this.c.p());
   }

   protected void b(class_dn var1) {
      this.c = new class_cj(var1.g("TPX"), var1.g("TPY"), var1.g("TPZ"));
   }

   public boolean a(World var1, Random var2, class_arw var3) {
      this.b.a(var3);
      this.a.b(var1, this.c, this.b);
      Map var4 = this.a.a(this.c, this.b);
      Iterator var5 = var4.keySet().iterator();

      while(var5.hasNext()) {
         class_cj var6 = (class_cj)var5.next();
         String var7 = (String)var4.get(var6);
         this.a(var7, var6, var1, var2, var3);
      }

      return true;
   }

   protected abstract void a(String var1, class_cj var2, World var3, Random var4, class_arw var5);

   private void h() {
      Block.class_c_in_class_agj var1 = this.b.c();
      class_cj var2 = this.a.a(var1);
      this.l = new class_arw(0, 0, 0, var2.n(), var2.o() - 1, var2.p());
      switch(class_asp.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
      default:
         break;
      case 2:
         this.l.a(-var2.n(), 0, 0);
         break;
      case 3:
         this.l.a(0, 0, -var2.p());
         break;
      case 4:
         this.l.a(-var2.n(), 0, -var2.p());
      }

      this.l.a(this.c.n(), this.c.o(), this.c.p());
   }

   public void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.c = this.c.a(var1, var2, var3);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[Block.class_c_in_class_agj.values().length];

      static {
         try {
            a[Block.class_c_in_class_agj.a.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.d.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.c.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
