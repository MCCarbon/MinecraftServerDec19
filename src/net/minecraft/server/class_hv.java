package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_hv implements Packet {
   private class_hv.class_a_in_class_hv a;
   private IChatBaseComponent b;
   private int c;
   private int d;
   private int e;

   public class_hv() {
   }

   public class_hv(class_hv.class_a_in_class_hv var1, IChatBaseComponent var2) {
      this(var1, var2, -1, -1, -1);
   }

   public class_hv(int var1, int var2, int var3) {
      this(class_hv.class_a_in_class_hv.c, (IChatBaseComponent)null, var1, var2, var3);
   }

   public class_hv(class_hv.class_a_in_class_hv var1, IChatBaseComponent var2, int var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = (class_hv.class_a_in_class_hv)var1.readEnum(class_hv.class_a_in_class_hv.class);
      if(this.a == class_hv.class_a_in_class_hv.a || this.a == class_hv.class_a_in_class_hv.b) {
         this.b = var1.readChat();
      }

      if(this.a == class_hv.class_a_in_class_hv.c) {
         this.c = var1.readInt();
         this.d = var1.readInt();
         this.e = var1.readInt();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeEnum((Enum)this.a);
      if(this.a == class_hv.class_a_in_class_hv.a || this.a == class_hv.class_a_in_class_hv.b) {
         var1.writeChat(this.b);
      }

      if(this.a == class_hv.class_a_in_class_hv.c) {
         var1.writeInt(this.c);
         var1.writeInt(this.d);
         var1.writeInt(this.e);
      }

   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }

   public static enum class_a_in_class_hv {
      a,
      b,
      c,
      d,
      e;

      public static class_hv.class_a_in_class_hv a(String var0) {
         class_hv.class_a_in_class_hv[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            class_hv.class_a_in_class_hv var4 = var1[var3];
            if(var4.name().equalsIgnoreCase(var0)) {
               return var4;
            }
         }

         return a;
      }

      public static String[] a() {
         String[] var0 = new String[values().length];
         int var1 = 0;
         class_hv.class_a_in_class_hv[] var2 = values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            class_hv.class_a_in_class_hv var5 = var2[var4];
            var0[var1++] = var5.name().toLowerCase();
         }

         return var0;
      }
   }
}
