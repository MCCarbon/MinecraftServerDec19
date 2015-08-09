package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.World;
import net.minecraft.server.SessionException;
import net.minecraft.server.Chunk;

public interface IChunkLoader {
   Chunk a(World var1, int var2, int var3) throws IOException;

   void a(World var1, Chunk var2) throws IOException, SessionException;

   void b(World var1, Chunk var2) throws IOException;

   void a();

   void b();
}
