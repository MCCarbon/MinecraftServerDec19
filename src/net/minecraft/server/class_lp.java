package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.NetworkManager;
import net.minecraft.server.EnumProtocol;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketHandshakingInSetProtocol;
import net.minecraft.server.PacketHandshakingInListener;
import net.minecraft.server.class_jk;
import net.minecraft.server.class_lq;
import net.minecraft.server.class_lr;

public class class_lp implements PacketHandshakingInListener {
   private final MinecraftServer a;
   private final NetworkManager b;

   public class_lp(MinecraftServer var1, NetworkManager var2) {
      this.a = var1;
      this.b = var2;
   }

   public void handle(PacketHandshakingInSetProtocol var1) {
      switch(class_lp.SyntheticClass_1.a[var1.getNextProtocol().ordinal()]) {
      case 1:
         this.b.a(EnumProtocol.LOGIN);
         class_fa var2;
         if(var1.getProtocolVersion() > 50) {
            var2 = new class_fa("Outdated server! I\'m still on 15w31b");
            this.b.a((Packet)(new class_jk(var2)));
            this.b.a((IChatBaseComponent)var2);
         } else if(var1.getProtocolVersion() < 50) {
            var2 = new class_fa("Outdated client! Please use 15w31b");
            this.b.a((Packet)(new class_jk(var2)));
            this.b.a((IChatBaseComponent)var2);
         } else {
            this.b.setPacketListener((PacketListener)(new class_lq(this.a, this.b)));
         }
         break;
      case 2:
         this.b.a(EnumProtocol.STATUS);
         this.b.setPacketListener((PacketListener)(new class_lr(this.a, this.b)));
         break;
      default:
         throw new UnsupportedOperationException("Invalid intention " + var1.getNextProtocol());
      }

   }

   public void disconnect(IChatBaseComponent var1) {
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumProtocol.values().length];

      static {
         try {
            a[EnumProtocol.LOGIN.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumProtocol.STATUS.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
