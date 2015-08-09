package net.minecraft.server;

import java.io.File;
import net.minecraft.server.IChunkLoader;
import net.minecraft.server.RegionFileCache;
import net.minecraft.server.class_aov;
import net.minecraft.server.WorldProvider;
import net.minecraft.server.WorldProviderHell;
import net.minecraft.server.WorldProviderTheEnd;
import net.minecraft.server.WorldNBTStorage;
import net.minecraft.server.WorldData;
import net.minecraft.server.class_awb;
import net.minecraft.server.NBTTagCompound;

public class ServerNBTManager extends WorldNBTStorage {
   public ServerNBTManager(File var1, String var2, boolean var3) {
      super(var1, var2, var3);
   }

   public IChunkLoader createChunkLoader(WorldProvider var1) {
      File var2 = this.getDirectory();
      File var3;
      if(var1 instanceof WorldProviderHell) {
         var3 = new File(var2, "DIM-1");
         var3.mkdirs();
         return new class_aov(var3);
      } else if(var1 instanceof WorldProviderTheEnd) {
         var3 = new File(var2, "DIM1");
         var3.mkdirs();
         return new class_aov(var3);
      } else {
         return new class_aov(var2);
      }
   }

   public void saveWorldData(WorldData var1, NBTTagCompound var2) {
      var1.e(19133);
      super.saveWorldData(var1, var2);
   }

   public void a() {
      try {
         class_awb.a().b();
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }

      RegionFileCache.a();
   }
}
