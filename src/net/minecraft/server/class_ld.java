package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aeh;
import net.minecraft.server.TileEntity;
import net.minecraft.server.Chunk;
import net.minecraft.server.class_aoy;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutBlockChange;
import net.minecraft.server.PacketPlayOutMultiBlockChange;
import net.minecraft.server.PacketPlayOutMapChunk;
import net.minecraft.server.WorldServer;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_ns;
import net.minecraft.server.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ld {
   private static final Logger a = LogManager.getLogger();
   private final WorldServer b;
   private final List c = Lists.newArrayList();
   private final class_ns d = new class_ns();
   private final List e = Lists.newArrayList();
   private final List f = Lists.newArrayList();
   private int g;
   private long h;
   private final int[][] i = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

   public class_ld(WorldServer var1) {
      this.b = var1;
      this.a(var1.s().getPlayerList().getViewDistance());
   }

   public WorldServer a() {
      return this.b;
   }

   public void b() {
      long var1 = this.b.L();
      int var3;
      class_ld.class_a_in_class_ld var4;
      if(var1 - this.h > 8000L) {
         this.h = var1;

         for(var3 = 0; var3 < this.f.size(); ++var3) {
            var4 = (class_ld.class_a_in_class_ld)this.f.get(var3);
            var4.b();
            var4.a();
         }
      } else {
         for(var3 = 0; var3 < this.e.size(); ++var3) {
            var4 = (class_ld.class_a_in_class_ld)this.e.get(var3);
            var4.b();
         }
      }

      this.e.clear();
      if(this.c.isEmpty()) {
         class_aoy var5 = this.b.worldProvider;
         if(!var5.e()) {
            this.b.b.b();
         }
      }

   }

   public boolean a(int var1, int var2) {
      long var3 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      return this.d.a(var3) != null;
   }

   private class_ld.class_a_in_class_ld a(int var1, int var2, boolean var3) {
      long var4 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      class_ld.class_a_in_class_ld var6 = (class_ld.class_a_in_class_ld)this.d.a(var4);
      if(var6 == null && var3) {
         var6 = new class_ld.class_a_in_class_ld(var1, var2);
         this.d.a(var4, var6);
         this.f.add(var6);
      }

      return var6;
   }

   public void a(BlockPosition var1) {
      int var2 = var1.getX() >> 4;
      int var3 = var1.getZ() >> 4;
      class_ld.class_a_in_class_ld var4 = this.a(var2, var3, false);
      if(var4 != null) {
         var4.a(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
      }

   }

   public void a(EntityPlayer var1) {
      int var2 = (int)var1.s >> 4;
      int var3 = (int)var1.u >> 4;
      var1.d = var1.s;
      var1.e = var1.u;

      for(int var4 = var2 - this.g; var4 <= var2 + this.g; ++var4) {
         for(int var5 = var3 - this.g; var5 <= var3 + this.g; ++var5) {
            this.a(var4, var5, true).a(var1);
         }
      }

      this.c.add(var1);
      this.b(var1);
   }

   public void b(EntityPlayer var1) {
      ArrayList var2 = Lists.newArrayList((Iterable)var1.f);
      int var3 = 0;
      int var4 = this.g;
      int var5 = (int)var1.s >> 4;
      int var6 = (int)var1.u >> 4;
      int var7 = 0;
      int var8 = 0;
      class_aeh var9 = this.a(var5, var6, true).c;
      var1.f.clear();
      if(var2.contains(var9)) {
         var1.f.add(var9);
      }

      int var10;
      for(var10 = 1; var10 <= var4 * 2; ++var10) {
         for(int var11 = 0; var11 < 2; ++var11) {
            int[] var12 = this.i[var3++ % 4];

            for(int var13 = 0; var13 < var10; ++var13) {
               var7 += var12[0];
               var8 += var12[1];
               var9 = this.a(var5 + var7, var6 + var8, true).c;
               if(var2.contains(var9)) {
                  var1.f.add(var9);
               }
            }
         }
      }

      var3 %= 4;

      for(var10 = 0; var10 < var4 * 2; ++var10) {
         var7 += this.i[var3][0];
         var8 += this.i[var3][1];
         var9 = this.a(var5 + var7, var6 + var8, true).c;
         if(var2.contains(var9)) {
            var1.f.add(var9);
         }
      }

   }

   public void c(EntityPlayer var1) {
      int var2 = (int)var1.d >> 4;
      int var3 = (int)var1.e >> 4;

      for(int var4 = var2 - this.g; var4 <= var2 + this.g; ++var4) {
         for(int var5 = var3 - this.g; var5 <= var3 + this.g; ++var5) {
            class_ld.class_a_in_class_ld var6 = this.a(var4, var5, false);
            if(var6 != null) {
               var6.b(var1);
            }
         }
      }

      this.c.remove(var1);
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 - var3;
      int var7 = var2 - var4;
      return var6 >= -var5 && var6 <= var5?var7 >= -var5 && var7 <= var5:false;
   }

   public void d(EntityPlayer var1) {
      int var2 = (int)var1.s >> 4;
      int var3 = (int)var1.u >> 4;
      double var4 = var1.d - var1.s;
      double var6 = var1.e - var1.u;
      double var8 = var4 * var4 + var6 * var6;
      if(var8 >= 64.0D) {
         int var10 = (int)var1.d >> 4;
         int var11 = (int)var1.e >> 4;
         int var12 = this.g;
         int var13 = var2 - var10;
         int var14 = var3 - var11;
         if(var13 != 0 || var14 != 0) {
            for(int var15 = var2 - var12; var15 <= var2 + var12; ++var15) {
               for(int var16 = var3 - var12; var16 <= var3 + var12; ++var16) {
                  if(!this.a(var15, var16, var10, var11, var12)) {
                     this.a(var15, var16, true).a(var1);
                  }

                  if(!this.a(var15 - var13, var16 - var14, var2, var3, var12)) {
                     class_ld.class_a_in_class_ld var17 = this.a(var15 - var13, var16 - var14, false);
                     if(var17 != null) {
                        var17.b(var1);
                     }
                  }
               }
            }

            this.b(var1);
            var1.d = var1.s;
            var1.e = var1.u;
         }
      }
   }

   public boolean a(EntityPlayer var1, int var2, int var3) {
      class_ld.class_a_in_class_ld var4 = this.a(var2, var3, false);
      return var4 != null && var4.b.contains(var1) && !var1.f.contains(var4.c);
   }

   public void a(int var1) {
      var1 = MathHelper.clamp(var1, 3, 32);
      if(var1 != this.g) {
         int var2 = var1 - this.g;
         ArrayList var3 = Lists.newArrayList((Iterable)this.c);
         Iterator var4 = var3.iterator();

         while(true) {
            while(var4.hasNext()) {
               EntityPlayer var5 = (EntityPlayer)var4.next();
               int var6 = (int)var5.s >> 4;
               int var7 = (int)var5.u >> 4;
               int var8;
               int var9;
               if(var2 > 0) {
                  for(var8 = var6 - var1; var8 <= var6 + var1; ++var8) {
                     for(var9 = var7 - var1; var9 <= var7 + var1; ++var9) {
                        class_ld.class_a_in_class_ld var10 = this.a(var8, var9, true);
                        if(!var10.b.contains(var5)) {
                           var10.a(var5);
                        }
                     }
                  }
               } else {
                  for(var8 = var6 - this.g; var8 <= var6 + this.g; ++var8) {
                     for(var9 = var7 - this.g; var9 <= var7 + this.g; ++var9) {
                        if(!this.a(var8, var9, var6, var7, var1)) {
                           this.a(var8, var9, true).b(var5);
                        }
                     }
                  }
               }
            }

            this.g = var1;
            return;
         }
      }
   }

   public static int b(int var0) {
      return var0 * 16 - 16;
   }

   class class_a_in_class_ld {
      private final List b = Lists.newArrayList();
      private final class_aeh c;
      private short[] d = new short[64];
      private int e;
      private int f;
      private long g;

      public class_a_in_class_ld(int var2, int var3) {
         this.c = new class_aeh(var2, var3);
         class_ld.this.a().b.c(var2, var3);
      }

      public void a(EntityPlayer var1) {
         if(this.b.contains(var1)) {
            class_ld.a.debug("Failed to add player. {} already is in chunk {}, {}", new Object[]{var1, Integer.valueOf(this.c.a), Integer.valueOf(this.c.b)});
         } else {
            if(this.b.isEmpty()) {
               this.g = class_ld.this.b.L();
            }

            this.b.add(var1);
            var1.f.add(this.c);
         }
      }

      public void b(EntityPlayer var1) {
         if(this.b.contains(var1)) {
            Chunk var2 = class_ld.this.b.getChunkAt(this.c.a, this.c.b);
            if(var2.i()) {
               var1.playerConnection.sendPacket((Packet)(new PacketPlayOutMapChunk(var2, true, 0)));
            }

            this.b.remove(var1);
            var1.f.remove(this.c);
            if(this.b.isEmpty()) {
               long var3 = (long)this.c.a + 2147483647L | (long)this.c.b + 2147483647L << 32;
               this.a(var2);
               class_ld.this.d.d(var3);
               class_ld.this.f.remove(this);
               if(this.e > 0) {
                  class_ld.this.e.remove(this);
               }

               class_ld.this.a().b.b(this.c.a, this.c.b);
            }

         }
      }

      public void a() {
         this.a(class_ld.this.b.getChunkAt(this.c.a, this.c.b));
      }

      private void a(Chunk var1) {
         var1.c(var1.w() + class_ld.this.b.L() - this.g);
         this.g = class_ld.this.b.L();
      }

      public void a(int var1, int var2, int var3) {
         if(this.e == 0) {
            class_ld.this.e.add(this);
         }

         this.f |= 1 << (var2 >> 4);
         if(this.e < 64) {
            short var4 = (short)(var1 << 12 | var3 << 8 | var2);

            for(int var5 = 0; var5 < this.e; ++var5) {
               if(this.d[var5] == var4) {
                  return;
               }
            }

            this.d[this.e++] = var4;
         }

      }

      public void a(Packet var1) {
         for(int var2 = 0; var2 < this.b.size(); ++var2) {
            EntityPlayer var3 = (EntityPlayer)this.b.get(var2);
            if(!var3.f.contains(this.c)) {
               var3.playerConnection.sendPacket(var1);
            }
         }

      }

      public void b() {
         if(this.e != 0) {
            int var1;
            int var2;
            int var3;
            if(this.e == 1) {
               var1 = (this.d[0] >> 12 & 15) + this.c.a * 16;
               var2 = this.d[0] & 255;
               var3 = (this.d[0] >> 8 & 15) + this.c.b * 16;
               BlockPosition var4 = new BlockPosition(var1, var2, var3);
               this.a((Packet)(new PacketPlayOutBlockChange(class_ld.this.b, var4)));
               if(class_ld.this.b.getType(var4).getBlock().isTileEntity()) {
                  this.a(class_ld.this.b.getTileEntity(var4));
               }
            } else {
               int var7;
               if(this.e == 64) {
                  var1 = this.c.a * 16;
                  var2 = this.c.b * 16;
                  this.a((Packet)(new PacketPlayOutMapChunk(class_ld.this.b.getChunkAt(this.c.a, this.c.b), false, this.f)));

                  for(var3 = 0; var3 < 16; ++var3) {
                     if((this.f & 1 << var3) != 0) {
                        var7 = var3 << 4;
                        List var5 = class_ld.this.b.a(var1, var7, var2, var1 + 16, var7 + 16, var2 + 16);

                        for(int var6 = 0; var6 < var5.size(); ++var6) {
                           this.a((TileEntity)var5.get(var6));
                        }
                     }
                  }
               } else {
                  this.a((Packet)(new PacketPlayOutMultiBlockChange(this.e, this.d, class_ld.this.b.getChunkAt(this.c.a, this.c.b))));

                  for(var1 = 0; var1 < this.e; ++var1) {
                     var2 = (this.d[var1] >> 12 & 15) + this.c.a * 16;
                     var3 = this.d[var1] & 255;
                     var7 = (this.d[var1] >> 8 & 15) + this.c.b * 16;
                     BlockPosition var8 = new BlockPosition(var2, var3, var7);
                     if(class_ld.this.b.getType(var8).getBlock().isTileEntity()) {
                        this.a(class_ld.this.b.getTileEntity(var8));
                     }
                  }
               }
            }

            this.e = 0;
            this.f = 0;
         }
      }

      private void a(TileEntity var1) {
         if(var1 != null) {
            Packet var2 = var1.getUpdatePacket();
            if(var2 != null) {
               this.a(var2);
            }
         }

      }
   }
}
