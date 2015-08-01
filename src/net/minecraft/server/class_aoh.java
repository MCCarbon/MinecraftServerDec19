package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Chunk;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nw;
import net.minecraft.server.class_qc;

public interface class_aoh {
   boolean a(int var1, int var2);

   Chunk d(int var1, int var2);

   Chunk a(BlockPosition var1);

   void a(class_aoh var1, int var2, int var3);

   boolean a(class_aoh var1, Chunk var2, int var3, int var4);

   boolean a(boolean var1, class_nw var2);

   boolean d();

   boolean e();

   String f();

   List a(class_qc var1, BlockPosition var2);

   BlockPosition a(World var1, String var2, BlockPosition var3);

   int g();

   void a(Chunk var1, int var2, int var3);

   void c();
}
