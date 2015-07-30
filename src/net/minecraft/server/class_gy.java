package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_pb;
import net.minecraft.server.class_qa;

public class class_gy implements Packet {
   public class_gy.class_a_in_class_gy a;
   public int b;
   public int c;
   public int d;
   public IChatBaseComponent e;

   public class_gy() {
   }

   public class_gy(class_pb var1, class_gy.class_a_in_class_gy var2) {
      this.a = var2;
      class_qa var3 = var1.c();
      switch(class_gy.SyntheticClass_1.a[var2.ordinal()]) {
      case 1:
         this.d = var1.f();
         this.c = var3 == null?-1:var3.getId();
         break;
      case 2:
         this.b = var1.h().getId();
         this.c = var3 == null?-1:var3.getId();
         this.e = var1.b();
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = (class_gy.class_a_in_class_gy)var1.readEnum(class_gy.class_a_in_class_gy.class);
      if(this.a == class_gy.class_a_in_class_gy.b) {
         this.d = var1.readVarInt();
         this.c = var1.readInt();
      } else if(this.a == class_gy.class_a_in_class_gy.c) {
         this.b = var1.readVarInt();
         this.c = var1.readInt();
         this.e = var1.readChat();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeEnum((Enum)this.a);
      if(this.a == class_gy.class_a_in_class_gy.b) {
         var1.writeVarInt(this.d);
         var1.writeInt(this.c);
      } else if(this.a == class_gy.class_a_in_class_gy.c) {
         var1.writeVarInt(this.b);
         var1.writeInt(this.c);
         var1.writeChat(this.e);
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

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_gy.class_a_in_class_gy.values().length];

      static {
         try {
            a[class_gy.class_a_in_class_gy.b.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_gy.class_a_in_class_gy.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_gy {
      a,
      b,
      c;
   }
}
