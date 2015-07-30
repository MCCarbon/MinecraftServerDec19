package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_oh;

public class class_fw implements Packet {
   private UUID a;
   private class_fw.class_a_in_class_fw b;
   private IChatBaseComponent c;
   private float d;
   private class_oh.class_a_in_class_oh e;
   private class_oh.class_b_in_class_oh f;
   private boolean g;
   private boolean h;

   public class_fw() {
   }

   public class_fw(class_fw.class_a_in_class_fw var1, class_oh var2) {
      this.b = var1;
      this.a = var2.d();
      this.c = var2.e();
      this.d = var2.f();
      this.e = var2.g();
      this.f = var2.h();
      this.g = var2.i();
      this.h = var2.j();
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readUUID();
      this.b = (class_fw.class_a_in_class_fw)var1.readEnum(class_fw.class_a_in_class_fw.class);
      switch(class_fw.SyntheticClass_1.a[this.b.ordinal()]) {
      case 1:
         this.c = var1.readChat();
         this.d = var1.readFloat();
         this.e = (class_oh.class_a_in_class_oh)var1.readEnum(class_oh.class_a_in_class_oh.class);
         this.f = (class_oh.class_b_in_class_oh)var1.readEnum(class_oh.class_b_in_class_oh.class);
         this.a(var1.readUnsignedByte());
      case 2:
      default:
         break;
      case 3:
         this.d = var1.readFloat();
         break;
      case 4:
         this.c = var1.readChat();
         break;
      case 5:
         this.e = (class_oh.class_a_in_class_oh)var1.readEnum(class_oh.class_a_in_class_oh.class);
         this.f = (class_oh.class_b_in_class_oh)var1.readEnum(class_oh.class_b_in_class_oh.class);
         break;
      case 6:
         this.a(var1.readUnsignedByte());
      }

   }

   private void a(int var1) {
      this.g = (var1 & 1) > 0;
      this.h = (var1 & 2) > 0;
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeUUID(this.a);
      var1.writeEnum((Enum)this.b);
      switch(class_fw.SyntheticClass_1.a[this.b.ordinal()]) {
      case 1:
         var1.writeChat(this.c);
         var1.writeFloat(this.d);
         var1.writeEnum((Enum)this.e);
         var1.writeEnum((Enum)this.f);
         var1.writeByte(this.i());
      case 2:
      default:
         break;
      case 3:
         var1.writeFloat(this.d);
         break;
      case 4:
         var1.writeChat(this.c);
         break;
      case 5:
         var1.writeEnum((Enum)this.e);
         var1.writeEnum((Enum)this.f);
         break;
      case 6:
         var1.writeByte(this.i());
      }

   }

   private int i() {
      int var1 = 0;
      if(this.g) {
         var1 |= 1;
      }

      if(this.h) {
         var1 |= 2;
      }

      return var1;
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
      static final int[] a = new int[class_fw.class_a_in_class_fw.values().length];

      static {
         try {
            a[class_fw.class_a_in_class_fw.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_fw.class_a_in_class_fw.b.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_fw.class_a_in_class_fw.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_fw.class_a_in_class_fw.d.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_fw.class_a_in_class_fw.e.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_fw.class_a_in_class_fw.f.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_fw {
      a,
      b,
      c,
      d,
      e,
      f;
   }
}
