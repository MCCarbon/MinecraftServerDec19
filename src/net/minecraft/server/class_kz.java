package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutGameStateChange;
import net.minecraft.server.PlayerInteractManager;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.EntityHuman;

public class class_kz extends PlayerInteractManager {
   private boolean c;
   private boolean d;
   private int e;
   private int f;

   public class_kz(World var1) {
      super(var1);
   }

   public void a() {
      super.a();
      ++this.f;
      long var1 = this.world.L();
      long var3 = var1 / 24000L + 1L;
      if(!this.c && this.f > 20) {
         this.c = true;
         this.player.playerConnection.sendPacket((Packet)(new PacketPlayOutGameStateChange(5, 0.0F)));
      }

      this.d = var1 > 120500L;
      if(this.d) {
         ++this.e;
      }

      if(var1 % 24000L == 500L) {
         if(var3 <= 6L) {
            this.player.a((IChatBaseComponent)(new ChatMessage("demo.day." + var3, new Object[0])));
         }
      } else if(var3 == 1L) {
         if(var1 == 100L) {
            this.player.playerConnection.sendPacket((Packet)(new PacketPlayOutGameStateChange(5, 101.0F)));
         } else if(var1 == 175L) {
            this.player.playerConnection.sendPacket((Packet)(new PacketPlayOutGameStateChange(5, 102.0F)));
         } else if(var1 == 250L) {
            this.player.playerConnection.sendPacket((Packet)(new PacketPlayOutGameStateChange(5, 103.0F)));
         }
      } else if(var3 == 5L && var1 % 24000L == 22000L) {
         this.player.a((IChatBaseComponent)(new ChatMessage("demo.day.warning", new Object[0])));
      }

   }

   private void f() {
      if(this.e > 100) {
         this.player.a((IChatBaseComponent)(new ChatMessage("demo.reminder", new Object[0])));
         this.e = 0;
      }

   }

   public void a(BlockPosition var1, EnumDirection var2) {
      if(this.d) {
         this.f();
      } else {
         super.a(var1, var2);
      }
   }

   public void a(BlockPosition var1) {
      if(!this.d) {
         super.a(var1);
      }
   }

   public boolean breakBlock(BlockPosition var1) {
      return this.d?false:super.breakBlock(var1);
   }

   public UseResult useItem(EntityHuman var1, World var2, ItemStack var3, EnumUsedHand var4) {
      if(this.d) {
         this.f();
         return UseResult.CANT_USE;
      } else {
         return super.useItem(var1, var2, var3, var4);
      }
   }

   public UseResult interact(EntityHuman var1, World var2, ItemStack var3, EnumUsedHand var4, BlockPosition var5, EnumDirection var6, float var7, float var8, float var9) {
      if(this.d) {
         this.f();
         return UseResult.CANT_USE;
      } else {
         return super.interact(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }
}
