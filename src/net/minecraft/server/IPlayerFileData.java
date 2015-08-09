package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.EntityHuman;

public interface IPlayerFileData {
   void save(EntityHuman var1);

   NBTTagCompound load(EntityHuman var1);

   String[] getSeenPlayers();
}
