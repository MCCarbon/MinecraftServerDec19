package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenMineshaftPieces;
import net.minecraft.server.StructurePiece;
import net.minecraft.server.StructureStart;

public class WorldGenMineshaftStart extends StructureStart {
   public WorldGenMineshaftStart() {
   }

   public WorldGenMineshaftStart(World var1, Random var2, int var3, int var4) {
      super(var3, var4);
      WorldGenMineshaftPieces.WorldGenMineshaftRoom var5 = new WorldGenMineshaftPieces.WorldGenMineshaftRoom(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
      this.a.add(var5);
      var5.a((StructurePiece)var5, (List)this.a, (Random)var2);
      this.c();
      this.a(var1, var2, 10);
   }
}
