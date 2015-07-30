package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_m;

public interface class_k extends Comparable {
   String c();

   String c(class_m var1);

   List b();

   void a(class_m var1, String[] var2) throws class_bz;

   boolean a(class_m var1);

   List a(class_m var1, String[] var2, BlockPosition var3);

   boolean b(String[] var1, int var2);
}
