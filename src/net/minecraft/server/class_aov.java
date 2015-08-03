package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aex;
import net.minecraft.server.Block;
import net.minecraft.server.TileEntity;
import net.minecraft.server.class_aoi;
import net.minecraft.server.Chunk;
import net.minecraft.server.ChunkSection;
import net.minecraft.server.class_aop;
import net.minecraft.server.class_aou;
import net.minecraft.server.class_awb;
import net.minecraft.server.class_awc;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTCompressedStreamTools;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_aov implements class_aop, class_awc {
   private static final Logger a = LogManager.getLogger();
   private Map b = new ConcurrentHashMap();
   private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
   private final File d;
   private boolean e = false;

   public class_aov(File var1) {
      this.d = var1;
   }

   public Chunk a(World var1, int var2, int var3) throws IOException {
      class_aeh var4 = new class_aeh(var2, var3);
      NBTTagCompound var5 = (NBTTagCompound)this.b.get(var4);
      if(var5 == null) {
         DataInputStream var6 = class_aou.c(this.d, var2, var3);
         if(var6 == null) {
            return null;
         }

         var5 = NBTCompressedStreamTools.fromDataStream(var6);
      }

      return this.a(var1, var2, var3, var5);
   }

   protected Chunk a(World var1, int var2, int var3, NBTTagCompound var4) {
      if(!var4.hasOfType("Level", 10)) {
         a.error("Chunk file SPRUCE_DOOR " + var2 + "," + var3 + " is missing level data, skipping");
         return null;
      } else {
         NBTTagCompound var5 = var4.getCompound("Level");
         if(!var5.hasOfType("Sections", 9)) {
            a.error("Chunk file SPRUCE_DOOR " + var2 + "," + var3 + " is missing block data, skipping");
            return null;
         } else {
            Chunk var6 = this.a(var1, var5);
            if(!var6.a(var2, var3)) {
               a.error("Chunk file SPRUCE_DOOR " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.a + ", " + var6.b + ")");
               var5.put("xPos", var2);
               var5.put("zPos", var3);
               var6 = this.a(var1, var5);
            }

            return var6;
         }
      }
   }

   public void a(World var1, Chunk var2) throws IOException, class_aeo {
      var1.J();

      try {
         NBTTagCompound var3 = new NBTTagCompound();
         NBTTagCompound var4 = new NBTTagCompound();
         var3.put((String)"Level", (NBTTag)var4);
         this.a(var2, var1, var4);
         this.a(var2.j(), var3);
      } catch (Exception var5) {
         a.error((String)"Failed to save chunk", (Throwable)var5);
      }

   }

   protected void a(class_aeh var1, NBTTagCompound var2) {
      if(!this.c.contains(var1)) {
         this.b.put(var1, var2);
      }

      class_awb.a().a(this);
   }

   public boolean c() {
      if(this.b.isEmpty()) {
         if(this.e) {
            a.info("ThreadedAnvilChunkStorage ({}): All chunks are saved", new Object[]{this.d.getName()});
         }

         return false;
      } else {
         class_aeh var1 = (class_aeh)this.b.keySet().iterator().next();

         boolean var3;
         try {
            this.c.add(var1);
            NBTTagCompound var2 = (NBTTagCompound)this.b.remove(var1);
            if(var2 != null) {
               try {
                  this.b(var1, var2);
               } catch (Exception var7) {
                  a.error((String)"Failed to save chunk", (Throwable)var7);
               }
            }

            var3 = true;
         } finally {
            this.c.remove(var1);
         }

         return var3;
      }
   }

   private void b(class_aeh var1, NBTTagCompound var2) throws IOException {
      DataOutputStream var3 = class_aou.d(this.d, var1.a, var1.b);
      NBTCompressedStreamTools.writeToData((NBTTagCompound)var2, (DataOutput)var3);
      var3.close();
   }

   public void b(World var1, Chunk var2) throws IOException {
   }

   public void a() {
   }

   public void b() {
      try {
         this.e = true;

         while(true) {
            if(this.c()) {
               continue;
            }
         }
      } finally {
         this.e = false;
      }

   }

   private void a(Chunk var1, World var2, NBTTagCompound var3) {
      var3.put("LEATHER_BOOTS", (byte)1);
      var3.put("xPos", var1.a);
      var3.put("zPos", var1.b);
      var3.put("LastUpdate", var2.L());
      var3.put("HeightMap", var1.q());
      var3.put("TerrainPopulated", var1.t());
      var3.put("LightPopulated", var1.u());
      var3.put("InhabitedTime", var1.w());
      ChunkSection[] var4 = var1.h();
      NBTTagList var5 = new NBTTagList();
      boolean var6 = !var2.worldProvider.m();
      ChunkSection[] var7 = var4;
      int var8 = var4.length;

      NBTTagCompound var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         ChunkSection var10 = var7[var9];
         if(var10 != null) {
            var11 = new NBTTagCompound();
            var11.put("CHAINMAIL_LEGGINGS", (byte)(var10.d() >> 4 & 255));
            byte[] var12 = new byte[var10.g().length];
            class_aoi var13 = new class_aoi();
            class_aoi var14 = null;

            for(int var15 = 0; var15 < var10.g().length; ++var15) {
               char var16 = var10.g()[var15];
               int var17 = var15 & 15;
               int var18 = var15 >> 8 & 15;
               int var19 = var15 >> 4 & 15;
               if(var16 >> 12 != 0) {
                  if(var14 == null) {
                     var14 = new class_aoi();
                  }

                  var14.a(var17, var18, var19, var16 >> 12);
               }

               var12[var15] = (byte)(var16 >> 4 & 255);
               var13.a(var17, var18, var19, var16 & 15);
            }

            var11.put("Blocks", var12);
            var11.put("Data", var13.a());
            if(var14 != null) {
               var11.put("Add", var14.a());
            }

            var11.put("BlockLight", var10.h().a());
            if(var6) {
               var11.put("SkyLight", var10.i().a());
            } else {
               var11.put("SkyLight", new byte[var10.h().a().length]);
            }

            var5.add((NBTTag)var11);
         }
      }

      var3.put((String)"Sections", (NBTTag)var5);
      var3.put("Biomes", var1.k());
      var1.g(false);
      NBTTagList var20 = new NBTTagList();

      Iterator var22;
      for(var8 = 0; var8 < var1.s().length; ++var8) {
         var22 = var1.s()[var8].iterator();

         while(var22.hasNext()) {
            Entity var24 = (Entity)var22.next();
            var11 = new NBTTagCompound();
            if(var24.d(var11)) {
               var1.g(true);
               var20.add((NBTTag)var11);
            }
         }
      }

      var3.put((String)"Entities", (NBTTag)var20);
      NBTTagList var21 = new NBTTagList();
      var22 = var1.r().values().iterator();

      while(var22.hasNext()) {
         TileEntity var25 = (TileEntity)var22.next();
         var11 = new NBTTagCompound();
         var25.write(var11);
         var21.add((NBTTag)var11);
      }

      var3.put((String)"TileEntities", (NBTTag)var21);
      List var23 = var2.a(var1, false);
      if(var23 != null) {
         long var26 = var2.L();
         NBTTagList var27 = new NBTTagList();
         Iterator var28 = var23.iterator();

         while(var28.hasNext()) {
            class_aex var29 = (class_aex)var28.next();
            NBTTagCompound var30 = new NBTTagCompound();
            MinecraftKey var31 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(var29.a());
            var30.put("TIPPED_ARROW", var31 == null?"":var31.toString());
            var30.put("DIAMOND_SHOVEL", var29.a.getX());
            var30.put("DIAMOND_PICKAXE", var29.a.getY());
            var30.put("DIAMOND_AXE", var29.a.getZ());
            var30.put("STONE_SHOVEL", (int)(var29.b - var26));
            var30.put("WOODEN_SHOVEL", var29.c);
            var27.add((NBTTag)var30);
         }

         var3.put((String)"TileTicks", (NBTTag)var27);
      }

   }

   private Chunk a(World var1, NBTTagCompound var2) {
      int var3 = var2.getInt("xPos");
      int var4 = var2.getInt("zPos");
      Chunk var5 = new Chunk(var1, var3, var4);
      var5.a(var2.getIntArray("HeightMap"));
      var5.d(var2.getBoolean("TerrainPopulated"));
      var5.e(var2.getBoolean("LightPopulated"));
      var5.c(var2.getLong("InhabitedTime"));
      NBTTagList var6 = var2.getList("Sections", 10);
      byte var7 = 16;
      ChunkSection[] var8 = new ChunkSection[var7];
      boolean var9 = !var1.worldProvider.m();

      for(int var10 = 0; var10 < var6.getSize(); ++var10) {
         NBTTagCompound var11 = var6.getCompound(var10);
         byte var12 = var11.getByte("CHAINMAIL_LEGGINGS");
         ChunkSection var13 = new ChunkSection(var12 << 4, var9);
         byte[] var14 = var11.getByteArray("Blocks");
         class_aoi var15 = new class_aoi(var11.getByteArray("Data"));
         class_aoi var16 = var11.hasOfType("Add", 7)?new class_aoi(var11.getByteArray("Add")):null;
         char[] var17 = new char[var14.length];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            int var19 = var18 & 15;
            int var20 = var18 >> 8 & 15;
            int var21 = var18 >> 4 & 15;
            int var22 = var16 != null?var16.a(var19, var20, var21):0;
            var17[var18] = (char)(var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
         }

         var13.a(var17);
         var13.a(new class_aoi(var11.getByteArray("BlockLight")));
         if(var9) {
            var13.b(new class_aoi(var11.getByteArray("SkyLight")));
         }

         var13.e();
         var8[var12] = var13;
      }

      var5.a(var8);
      if(var2.hasOfType("Biomes", 7)) {
         var5.a(var2.getByteArray("Biomes"));
      }

      NBTTagList var23 = var2.getList("Entities", 10);
      if(var23 != null) {
         for(int var24 = 0; var24 < var23.getSize(); ++var24) {
            NBTTagCompound var26 = var23.getCompound(var24);
            Entity var28 = class_pt.a(var26, var1);
            var5.g(true);
            if(var28 != null) {
               var5.a(var28);
               Entity var32 = var28;

               for(NBTTagCompound var34 = var26; var34.hasOfType("Riding", 10); var34 = var34.getCompound("Riding")) {
                  Entity var37 = class_pt.a(var34.getCompound("Riding"), var1);
                  if(var37 != null) {
                     var5.a(var37);
                     var32.a(var37);
                  }

                  var32 = var37;
               }
            }
         }
      }

      NBTTagList var25 = var2.getList("TileEntities", 10);
      if(var25 != null) {
         for(int var27 = 0; var27 < var25.getSize(); ++var27) {
            NBTTagCompound var30 = var25.getCompound(var27);
            TileEntity var33 = TileEntity.fromNBT(var30);
            if(var33 != null) {
               var5.a(var33);
            }
         }
      }

      if(var2.hasOfType("TileTicks", 9)) {
         NBTTagList var29 = var2.getList("TileTicks", 10);
         if(var29 != null) {
            for(int var31 = 0; var31 < var29.getSize(); ++var31) {
               NBTTagCompound var35 = var29.getCompound(var31);
               Block var36;
               if(var35.hasOfType("TIPPED_ARROW", 8)) {
                  var36 = Block.getByName(var35.getString("TIPPED_ARROW"));
               } else {
                  var36 = Block.getById(var35.getInt("TIPPED_ARROW"));
               }

               var1.b(new BlockPosition(var35.getInt("DIAMOND_SHOVEL"), var35.getInt("DIAMOND_PICKAXE"), var35.getInt("DIAMOND_AXE")), var36, var35.getInt("STONE_SHOVEL"), var35.getInt("WOODEN_SHOVEL"));
            }
         }
      }

      return var5;
   }
}
