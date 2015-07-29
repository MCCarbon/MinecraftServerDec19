package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_gd implements class_ff {
   private int a;
   private String b;
   private class_eu c;
   private int d;
   private int e;

   public class_gd() {
   }

   public class_gd(int var1, String var2, class_eu var3) {
      this(var1, var2, var3, 0);
   }

   public class_gd(int var1, String var2, class_eu var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public class_gd(int var1, String var2, class_eu var3, int var4, int var5) {
      this(var1, var2, var3, var4);
      this.e = var5;
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.c(32);
      this.c = var1.d();
      this.d = var1.readUnsignedByte();
      if(this.b.equals("EntityHorse")) {
         this.e = var1.readInt();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a);
      var1.a(this.b);
      var1.a(this.c);
      var1.writeByte(this.d);
      if(this.b.equals("EntityHorse")) {
         var1.writeInt(this.e);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
