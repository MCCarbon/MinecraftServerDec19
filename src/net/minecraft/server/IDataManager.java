package net.minecraft.server;

import java.io.File;
import net.minecraft.server.SessionException;
import net.minecraft.server.IChunkLoader;
import net.minecraft.server.WorldProvider;
import net.minecraft.server.WorldData;
import net.minecraft.server.IPlayerFileData;
import net.minecraft.server.NBTTagCompound;

public interface IDataManager {
	
   WorldData getWorldData();

   void checkSession() throws SessionException;

   IChunkLoader createChunkLoader(WorldProvider var1);

   void saveWorldData(WorldData var1, NBTTagCompound var2);

   void saveWorldData(WorldData var1);

   IPlayerFileData getPlayerFileData();

   void a();

   File getDirectory();

   File getDataFile(String var1);

   String g();
}
