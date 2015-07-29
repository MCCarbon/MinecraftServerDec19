package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;

public interface class_agl {
   boolean a(World var1, class_cj var2, IBlockData var3, boolean var4);

   boolean a(World var1, Random var2, class_cj var3, IBlockData var4);

   void b(World var1, Random var2, class_cj var3, IBlockData var4);
}
