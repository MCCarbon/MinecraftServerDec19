package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.SessionException;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.class_aoj;
import net.minecraft.server.Chunk;
import net.minecraft.server.IChunkLoader;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_e;
import net.minecraft.server.WorldServer;
import net.minecraft.server.class_ns;
import net.minecraft.server.IProgressUpdate;
import net.minecraft.server.EnumCreatureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lf implements IChunkProvider {
   private static final Logger b = LogManager.getLogger();
   private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
   private Chunk d;
   private IChunkProvider e;
   private IChunkLoader f;
   public boolean a = true;
   private class_ns g = new class_ns();
   private List h = Lists.newArrayList();
   private WorldServer i;

   public class_lf(WorldServer var1, IChunkLoader var2, IChunkProvider var3) {
      this.d = new class_aoj(var1, 0, 0);
      this.i = var1;
      this.f = var2;
      this.e = var3;
   }

   public boolean isChunkLoaded(int var1, int var2) {
      return this.g.b(class_aeh.a(var1, var2));
   }

   public List a() {
      return this.h;
   }

   public void b(int var1, int var2) {
      if(this.i.worldProvider.c(var1, var2)) {
         this.c.add(Long.valueOf(class_aeh.a(var1, var2)));
      }

   }

   public void b() {
      Iterator var1 = this.h.iterator();

      while(var1.hasNext()) {
         Chunk var2 = (Chunk)var1.next();
         this.b(var2.a, var2.b);
      }

   }

   public Chunk c(int var1, int var2) {
      long var3 = class_aeh.a(var1, var2);
      this.c.remove(Long.valueOf(var3));
      Chunk var5 = (Chunk)this.g.a(var3);
      if(var5 == null) {
         var5 = this.e(var1, var2);
         if(var5 == null) {
            if(this.e == null) {
               var5 = this.d;
            } else {
               try {
                  var5 = this.e.getOrCreateChunk(var1, var2);
               } catch (Throwable var9) {
                  class_b var7 = class_b.a(var9, "Exception generating new chunk");
                  class_c var8 = var7.a("Chunk to be generated");
                  var8.a((String)"Location", (Object)String.format("%d,%d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)}));
                  var8.a((String)"Position hash", (Object)Long.valueOf(var3));
                  var8.a((String)"Generator", (Object)this.e.getName());
                  throw new class_e(var7);
               }
            }
         }

         this.g.a(var3, var5);
         this.h.add(var5);
         var5.c();
         var5.a(this, this, var1, var2);
      }

      return var5;
   }

   public Chunk getOrCreateChunk(int var1, int var2) {
      Chunk var3 = (Chunk)this.g.a(class_aeh.a(var1, var2));
      return var3 == null?(!this.i.ae() && !this.a?this.d:this.c(var1, var2)):var3;
   }

   private Chunk e(int var1, int var2) {
      if(this.f == null) {
         return null;
      } else {
         try {
            Chunk var3 = this.f.a(this.i, var1, var2);
            if(var3 != null) {
               var3.b(this.i.L());
               if(this.e != null) {
                  this.e.recreateStructures(var3, var1, var2);
               }
            }

            return var3;
         } catch (Exception var4) {
            b.error((String)"Couldn\'t load chunk", (Throwable)var4);
            return null;
         }
      }
   }

   private void a(Chunk var1) {
      if(this.f != null) {
         try {
            this.f.b(this.i, var1);
         } catch (Exception var3) {
            b.error((String)"Couldn\'t save entities", (Throwable)var3);
         }

      }
   }

   private void b(Chunk var1) {
      if(this.f != null) {
         try {
            var1.b(this.i.L());
            this.f.a(this.i, var1);
         } catch (IOException var3) {
            b.error((String)"Couldn\'t save chunk", (Throwable)var3);
         } catch (SessionException var4) {
            b.error((String)"Couldn\'t save chunk; already in use by another instance of Minecraft?", (Throwable)var4);
         }

      }
   }

   public void a(IChunkProvider var1, int var2, int var3) {
      Chunk var4 = this.getOrCreateChunk(var2, var3);
      if(!var4.t()) {
         var4.n();
         if(this.e != null) {
            this.e.a(var1, var2, var3);
            var4.e();
         }
      }

   }

   public boolean a(IChunkProvider var1, Chunk var2, int var3, int var4) {
      if(this.e != null && this.e.a(var1, var2, var3, var4)) {
         Chunk var5 = this.getOrCreateChunk(var3, var4);
         var5.e();
         return true;
      } else {
         return false;
      }
   }

   public boolean saveChunks(boolean var1, IProgressUpdate var2) {
      int var3 = 0;
      ArrayList var4 = Lists.newArrayList((Iterable)this.h);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         Chunk var6 = (Chunk)var4.get(var5);
         if(var1) {
            this.a(var6);
         }

         if(var6.a(var1)) {
            this.b(var6);
            var6.f(false);
            ++var3;
            if(var3 == 24 && !var1) {
               return false;
            }
         }
      }

      return true;
   }

   public void c() {
      if(this.f != null) {
         this.f.b();
      }

   }

   public boolean unloadChunks() {
      if(!this.i.c) {
         for(int var1 = 0; var1 < 100; ++var1) {
            if(!this.c.isEmpty()) {
               Long var2 = (Long)this.c.iterator().next();
               Chunk var3 = (Chunk)this.g.a(var2.longValue());
               if(var3 != null) {
                  var3.d();
                  this.b(var3);
                  this.a(var3);
                  this.g.d(var2.longValue());
                  this.h.remove(var3);
               }

               this.c.remove(var2);
            }
         }

         if(this.f != null) {
            this.f.a();
         }
      }

      return this.e.unloadChunks();
   }

   public boolean canSave() {
      return !this.i.c;
   }

   public String getName() {
      return "ServerChunkCache: " + this.g.a() + " Drop: " + this.c.size();
   }

   public List getMobsFor(EnumCreatureType var1, BlockPosition var2) {
      return this.e.getMobsFor(var1, var2);
   }

   public BlockPosition a(World var1, String var2, BlockPosition var3) {
      return this.e.a(var1, var2, var3);
   }

   public int getLoadedChunks() {
      return this.g.a();
   }

   public void recreateStructures(Chunk var1, int var2, int var3) {
   }

   public Chunk getChunkAt(BlockPosition var1) {
      return this.getOrCreateChunk(var1.getX() >> 4, var1.getZ() >> 4);
   }
}
