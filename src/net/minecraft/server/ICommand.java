package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_m;

public interface ICommand extends Comparable {
   String getCommand();

   String c(class_m var1);

   List b();

   void execute(class_m var1, String[] var2) throws class_bz;

   boolean canUse(class_m var1);

   List tabComplete(class_m var1, String[] var2, BlockPosition var3);

   boolean isListStart(String[] var1, int var2);
}
