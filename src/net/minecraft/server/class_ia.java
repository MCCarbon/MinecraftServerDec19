package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;

public class class_ia implements class_ff {
   private int a;
   private final List b = Lists.newArrayList();

   public class_ia() {
   }

   public class_ia(int var1, Collection var2) {
      this.a = var1;
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_ql var4 = (class_ql)var3.next();
         this.b.add(new class_ia.class_a_in_class_ia(var4.a().a(), var4.b(), var4.c()));
      }

   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1.c(64);
         double var5 = var1.readDouble();
         ArrayList var7 = Lists.newArrayList();
         int var8 = var1.e();

         for(int var9 = 0; var9 < var8; ++var9) {
            UUID var10 = var1.g();
            var7.add(new class_qm(var10, "Unknown synced attribute modifier", var1.readDouble(), var1.readByte()));
         }

         this.b.add(new class_ia.class_a_in_class_ia(var4, var5, var7));
      }

   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.writeInt(this.b.size());
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         class_ia.class_a_in_class_ia var3 = (class_ia.class_a_in_class_ia)var2.next();
         var1.a(var3.a());
         var1.writeDouble(var3.b());
         var1.b(var3.c().size());
         Iterator var4 = var3.c().iterator();

         while(var4.hasNext()) {
            class_qm var5 = (class_qm)var4.next();
            var1.a(var5.a());
            var1.writeDouble(var5.d());
            var1.writeByte(var5.c());
         }
      }

   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }

   public class class_a_in_class_ia {
      private final String b;
      private final double c;
      private final Collection d;

      public class_a_in_class_ia(String var2, double var3, Collection var5) {
         this.b = var2;
         this.c = var3;
         this.d = var5;
      }

      public String a() {
         return this.b;
      }

      public double b() {
         return this.c;
      }

      public Collection c() {
         return this.d;
      }
   }
}
