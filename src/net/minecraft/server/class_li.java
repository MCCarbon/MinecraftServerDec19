package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_abw;
import net.minecraft.server.World;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.Block;
import net.minecraft.server.BlockChest;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityChest;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutBlockChange;
import net.minecraft.server.PacketPlayOutPlayerInfo;
import net.minecraft.server.WorldServer;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.IInventory;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.ITileInventory;
import net.minecraft.server.EntityHuman;

public class class_li {
   public World a;
   public EntityPlayer b;
   private WorldSettings.EnumGameMode c;
   private boolean d;
   private int e;
   private BlockPosition f;
   private int g;
   private boolean h;
   private BlockPosition i;
   private int j;
   private int k;

   public class_li(World var1) {
      this.c = WorldSettings.EnumGameMode.NOT_SET;
      this.f = BlockPosition.ZERO;
      this.i = BlockPosition.ZERO;
      this.k = -1;
      this.a = var1;
   }

   public void a(WorldSettings.EnumGameMode var1) {
      this.c = var1;
      var1.setAbilities(this.b.bH);
      this.b.t();
      this.b.b.getPlayerList().a((Packet)(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.class_a_in_class_gz.b, new EntityPlayer[]{this.b})));
   }

   public WorldSettings.EnumGameMode b() {
      return this.c;
   }

   public boolean c() {
      return this.c.isSurvivalOrAdventure();
   }

   public boolean d() {
      return this.c.isCreative();
   }

   public void b(WorldSettings.EnumGameMode var1) {
      if(this.c == WorldSettings.EnumGameMode.NOT_SET) {
         this.c = var1;
      }

      this.a(this.c);
   }

   public void a() {
      ++this.g;
      float var3;
      int var4;
      if(this.h) {
         int var1 = this.g - this.j;
         Block var2 = this.a.getType(this.i).getBlock();
         if(var2.getMaterial() == Material.AIR) {
            this.h = false;
         } else {
            var3 = var2.getDamage((EntityHuman)this.b, (World)this.b.o, (BlockPosition)this.i) * (float)(var1 + 1);
            var4 = (int)(var3 * 10.0F);
            if(var4 != this.k) {
               this.a.c(this.b.getId(), this.i, var4);
               this.k = var4;
            }

            if(var3 >= 1.0F) {
               this.h = false;
               this.b(this.i);
            }
         }
      } else if(this.d) {
         Block var5 = this.a.getType(this.f).getBlock();
         if(var5.getMaterial() == Material.AIR) {
            this.a.c(this.b.getId(), this.f, -1);
            this.k = -1;
            this.d = false;
         } else {
            int var6 = this.g - this.e;
            var3 = var5.getDamage((EntityHuman)this.b, (World)this.b.o, (BlockPosition)this.i) * (float)(var6 + 1);
            var4 = (int)(var3 * 10.0F);
            if(var4 != this.k) {
               this.a.c(this.b.getId(), this.f, var4);
               this.k = var4;
            }
         }
      }

   }

   public void a(BlockPosition var1, EnumDirection var2) {
      if(this.d()) {
         if(!this.a.a((EntityHuman)null, (BlockPosition)var1, (EnumDirection)var2)) {
            this.b(var1);
         }

      } else {
         Block var3 = this.a.getType(var1).getBlock();
         if(this.c.isAdventureOrSpectator()) {
            if(this.c == WorldSettings.EnumGameMode.SPECTATOR) {
               return;
            }

            if(!this.b.cp()) {
               ItemStack var4 = this.b.bA();
               if(var4 == null) {
                  return;
               }

               if(!var4.c(var3)) {
                  return;
               }
            }
         }

         this.a.a((EntityHuman)null, (BlockPosition)var1, (EnumDirection)var2);
         this.e = this.g;
         float var6 = 1.0F;
         if(var3.getMaterial() != Material.AIR) {
            var3.attack((World)this.a, (BlockPosition)var1, (EntityHuman)this.b);
            var6 = var3.getDamage((EntityHuman)this.b, (World)this.b.o, (BlockPosition)var1);
         }

         if(var3.getMaterial() != Material.AIR && var6 >= 1.0F) {
            this.b(var1);
         } else {
            this.d = true;
            this.f = var1;
            int var5 = (int)(var6 * 10.0F);
            this.a.c(this.b.getId(), var1, var5);
            this.k = var5;
         }

      }
   }

   public void a(BlockPosition var1) {
      if(var1.equals(this.f)) {
         int var2 = this.g - this.e;
         Block var3 = this.a.getType(var1).getBlock();
         if(var3.getMaterial() != Material.AIR) {
            float var4 = var3.getDamage((EntityHuman)this.b, (World)this.b.o, (BlockPosition)var1) * (float)(var2 + 1);
            if(var4 >= 0.7F) {
               this.d = false;
               this.a.c(this.b.getId(), var1, -1);
               this.b(var1);
            } else if(!this.h) {
               this.d = false;
               this.h = true;
               this.i = var1;
               this.j = this.e;
            }
         }
      }

   }

   public void e() {
      this.d = false;
      this.a.c(this.b.getId(), this.f, -1);
   }

   private boolean c(BlockPosition var1) {
      IBlockData var2 = this.a.getType(var1);
      var2.getBlock().a((World)this.a, var1, (IBlockData)var2, (EntityHuman)this.b);
      boolean var3 = this.a.setAir(var1);
      if(var3) {
         var2.getBlock().postBreak(this.a, var1, var2);
      }

      return var3;
   }

   public boolean b(BlockPosition var1) {
      if(this.c.isCreative() && this.b.bA() != null && this.b.bA().getItem() instanceof class_abw) {
         return false;
      } else {
         IBlockData var2 = this.a.getType(var1);
         TileEntity var3 = this.a.getTileEntity(var1);
         if(this.c.isAdventureOrSpectator()) {
            if(this.c == WorldSettings.EnumGameMode.SPECTATOR) {
               return false;
            }

            if(!this.b.cp()) {
               ItemStack var4 = this.b.bA();
               if(var4 == null) {
                  return false;
               }

               if(!var4.c(var2.getBlock())) {
                  return false;
               }
            }
         }

         this.a.a(this.b, 2001, var1, Block.getCombinedId(var2));
         boolean var8 = this.c(var1);
         if(this.d()) {
            this.b.a.a((Packet)(new PacketPlayOutBlockChange(this.a, var1)));
         } else {
            ItemStack var5 = this.b.bA();
            ItemStack var6 = var5 == null?null:var5.clone();
            boolean var7 = this.b.b((Block)var2.getBlock());
            if(var5 != null) {
               var5.a(this.a, var2.getBlock(), var1, this.b);
               if(var5.count == 0) {
                  this.b.a((EnumUsedHand)EnumUsedHand.MAIN_HAND, (ItemStack)null);
               }
            }

            if(var8 && var7) {
               var2.getBlock().breakBlockNaturally(this.a, (EntityHuman)this.b, (BlockPosition)var1, (IBlockData)var2, (TileEntity)var3, (ItemStack)var6);
            }
         }

         return var8;
      }
   }

   public class_oq a(EntityHuman var1, World var2, ItemStack var3, EnumUsedHand var4) {
      if(this.c == WorldSettings.EnumGameMode.SPECTATOR) {
         return class_oq.b;
      } else {
         int var5 = var3.count;
         int var6 = var3.i();
         class_or var7 = var3.a(var2, var1, var4);
         ItemStack var8 = (ItemStack)var7.b();
         if(var8 != var3 || var8.count != var5 || var8.l() > 0 || var8.i() != var6) {
            var1.a((EnumUsedHand)var4, (ItemStack)var8);
            if(this.d()) {
               var8.count = var5;
               if(var8.e()) {
                  var8.setData(var6);
               }
            }

            if(var8.count == 0) {
               var1.a((EnumUsedHand)var4, (ItemStack)null);
            }

            if(!var1.bS()) {
               ((EntityPlayer)var1).a(var1.bq);
            }
         }

         return var7.a();
      }
   }

   public class_oq a(EntityHuman var1, World var2, ItemStack var3, EnumUsedHand var4, BlockPosition var5, EnumDirection var6, float var7, float var8, float var9) {
      if(this.c == WorldSettings.EnumGameMode.SPECTATOR) {
         TileEntity var14 = var2.getTileEntity(var5);
         if(var14 instanceof ITileInventory) {
            Block var15 = var2.getType(var5).getBlock();
            ITileInventory var16 = (ITileInventory)var14;
            if(var16 instanceof TileEntityChest && var15 instanceof BlockChest) {
               var16 = ((BlockChest)var15).f(var2, var5);
            }

            if(var16 != null) {
               var1.openContainer((IInventory)var16);
               return class_oq.a;
            }
         } else if(var14 instanceof IInventory) {
            var1.openContainer((IInventory)var14);
            return class_oq.a;
         }

         return class_oq.b;
      } else {
         if(!var1.ax() || var1.bA() == null) {
            IBlockData var10 = var2.getType(var5);
            if(var10.getBlock().interact(var2, var5, var10, var1, var4, var3, var6, var7, var8, var9)) {
               return class_oq.a;
            }
         }

         if(var3 == null) {
            return class_oq.b;
         } else if(this.d()) {
            int var13 = var3.i();
            int var11 = var3.count;
            class_oq var12 = var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
            var3.setData(var13);
            var3.count = var11;
            return var12;
         } else {
            return var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
         }
      }
   }

   public void a(WorldServer var1) {
      this.a = var1;
   }
}
