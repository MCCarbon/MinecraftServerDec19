package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

public class PacketPlayOutBossBar implements Packet {
   private UUID a;
   private BossBarType b;
   private IChatBaseComponent c;
   private float d;
   private class_oh.class_a_in_class_oh e;
   private class_oh.class_b_in_class_oh f;
   private boolean g;
   private boolean h;

   public PacketPlayOutBossBar() {
   }

   public PacketPlayOutBossBar(BossBarType var1, class_oh var2) {
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
      this.b = (BossBarType)var1.readEnum(BossBarType.class);
      switch(PacketPlayOutBossBar.SyntheticClass_1.a[this.b.ordinal()]) {
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
      switch(PacketPlayOutBossBar.SyntheticClass_1.a[this.b.ordinal()]) {
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
      this.a((PacketListenerPlayOut) var1);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[BossBarType.values().length];

      static {
         try {
            a[BossBarType.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[BossBarType.b.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[BossBarType.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[BossBarType.d.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[BossBarType.e.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[BossBarType.f.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public enum BossBarType {
      a,
      b,
      c,
      d,
      e,
      f;
   }
}
