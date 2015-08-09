package net.minecraft.server;

import java.io.File;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aop;
import net.minecraft.server.WorldProvider;
import net.minecraft.server.WorldData;
import net.minecraft.server.IPlayerFileData;
import net.minecraft.server.NBTTagCompound;

public interface IDataManager {
   WorldData d();

   void c() throws class_aeo;

   class_aop a(WorldProvider var1);

   void a(WorldData var1, NBTTagCompound var2);

   void a(WorldData var1);

   IPlayerFileData e();

   void a();

   File b();

   File a(String var1);

   String g();
}
