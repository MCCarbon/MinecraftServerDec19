package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.EntityHuman;

public interface IPlayerFileData {
   void a(EntityHuman var1);

   NBTTagCompound b(EntityHuman var1);

   String[] f();
}
