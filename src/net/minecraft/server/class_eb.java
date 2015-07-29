package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dl;
import net.minecraft.server.class_dm;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dp;
import net.minecraft.server.class_dq;
import net.minecraft.server.class_dr;
import net.minecraft.server.class_ds;
import net.minecraft.server.class_dt;
import net.minecraft.server.class_du;
import net.minecraft.server.class_dv;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_dz;
import net.minecraft.server.class_ea;

public abstract class class_eb {
   public static final String[] a = new String[]{"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};

   abstract void a(DataOutput var1) throws IOException;

   abstract void a(DataInput var1, int var2, class_dw var3) throws IOException;

   public abstract String toString();

   public abstract byte a();

   protected static class_eb a(byte var0) {
      switch(var0) {
      case 0:
         return new class_dq();
      case 1:
         return new class_dm();
      case 2:
         return new class_dz();
      case 3:
         return new class_dt();
      case 4:
         return new class_dv();
      case 5:
         return new class_dr();
      case 6:
         return new class_dp();
      case 7:
         return new class_dl();
      case 8:
         return new class_ea();
      case 9:
         return new class_du();
      case 10:
         return new class_dn();
      case 11:
         return new class_ds();
      default:
         return null;
      }
   }

   public abstract class_eb b();

   public boolean c_() {
      return false;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_eb)) {
         return false;
      } else {
         class_eb var2 = (class_eb)var1;
         return this.a() == var2.a();
      }
   }

   public int hashCode() {
      return this.a();
   }

   protected String a_() {
      return this.toString();
   }

   public abstract static class class_a_in_class_eb extends class_eb {
      public abstract long c();

      public abstract int d();

      public abstract short e();

      public abstract byte f();

      public abstract double g();

      public abstract float h();
   }
}
