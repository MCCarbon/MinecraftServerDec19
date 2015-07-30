package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;

public class class_in implements class_ff {
   private int a;
   private class_in.class_a_in_class_in b;
   private Vec3D c;
   private class_oo d;

   public class_in() {
   }

   public class_in(class_pr var1) {
      this.a = var1.F();
      this.b = class_in.class_a_in_class_in.b;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = (class_in.class_a_in_class_in)var1.a(class_in.class_a_in_class_in.class);
      if(this.b == class_in.class_a_in_class_in.c) {
         this.c = new Vec3D((double)var1.readFloat(), (double)var1.readFloat(), (double)var1.readFloat());
      }

      if(this.b == class_in.class_a_in_class_in.a || this.b == class_in.class_a_in_class_in.c) {
         this.d = (class_oo)var1.a(class_oo.class);
      }

   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a((Enum)this.b);
      if(this.b == class_in.class_a_in_class_in.c) {
         var1.writeFloat((float)this.c.x);
         var1.writeFloat((float)this.c.y);
         var1.writeFloat((float)this.c.z);
      }

      if(this.b == class_in.class_a_in_class_in.a || this.b == class_in.class_a_in_class_in.c) {
         var1.a((Enum)this.d);
      }

   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_pr a(World var1) {
      return var1.a(this.a);
   }

   public class_in.class_a_in_class_in a() {
      return this.b;
   }

   public class_oo b() {
      return this.d;
   }

   public Vec3D c() {
      return this.c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }

   public static enum class_a_in_class_in {
      a,
      b,
      c;
   }
}
