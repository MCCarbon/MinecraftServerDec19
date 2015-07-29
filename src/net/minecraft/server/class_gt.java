package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_om;

public class class_gt implements class_ff {
   private int a;
   private boolean b;
   private class_aeq.class_a_in_class_aeq c;
   private int d;
   private class_om e;
   private int f;
   private class_aes g;
   private boolean h;

   public class_gt() {
   }

   public class_gt(int var1, class_aeq.class_a_in_class_aeq var2, boolean var3, int var4, class_om var5, int var6, class_aes var7, boolean var8) {
      this.a = var1;
      this.d = var4;
      this.e = var5;
      this.c = var2;
      this.f = var6;
      this.b = var3;
      this.g = var7;
      this.h = var8;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readInt();
      short var2 = var1.readUnsignedByte();
      this.b = (var2 & 8) == 8;
      int var3 = var2 & -9;
      this.c = class_aeq.class_a_in_class_aeq.a(var3);
      this.d = var1.readByte();
      this.e = class_om.a(var1.readUnsignedByte());
      this.f = var1.readUnsignedByte();
      this.g = class_aes.a(var1.c(16));
      if(this.g == null) {
         this.g = class_aes.b;
      }

      this.h = var1.readBoolean();
   }

   public void b(class_em var1) throws IOException {
      var1.writeInt(this.a);
      int var2 = this.c.a();
      if(this.b) {
         var2 |= 8;
      }

      var1.writeByte(var2);
      var1.writeByte(this.d);
      var1.writeByte(this.e.a());
      var1.writeByte(this.f);
      var1.a(this.g.a());
      var1.writeBoolean(this.h);
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
