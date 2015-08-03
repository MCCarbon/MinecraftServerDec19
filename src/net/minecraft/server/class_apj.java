package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aoh;
import net.minecraft.server.Chunk;
import net.minecraft.server.class_aph;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_nw;
import net.minecraft.server.class_qc;

public class class_apj implements class_aoh {
   private static final List a = Lists.newArrayList();
   private static final int b;
   private static final int c;
   private final World d;

   public class_apj(World var1) {
      this.d = var1;
   }

   public Chunk d(int var1, int var2) {
      class_aph var3 = new class_aph();

      int var7;
      for(int var4 = 0; var4 < 16; ++var4) {
         for(int var5 = 0; var5 < 16; ++var5) {
            int var6 = var1 * 16 + var4;
            var7 = var2 * 16 + var5;
            var3.a(var4, 60, var5, Blocks.BARRIER.getBlockData());
            IBlockData var8 = b(var6, var7);
            if(var8 != null) {
               var3.a(var4, 70, var5, var8);
            }
         }
      }

      Chunk var9 = new Chunk(this.d, var3, var1, var2);
      var9.b();
      BiomeBase[] var10 = this.d.w().b((BiomeBase[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var11 = var9.k();

      for(var7 = 0; var7 < var11.length; ++var7) {
         var11[var7] = (byte)var10[var7].az;
      }

      var9.b();
      return var9;
   }

   public static IBlockData b(int var0, int var1) {
      IBlockData var2 = null;
      if(var0 > 0 && var1 > 0 && var0 % 2 != 0 && var1 % 2 != 0) {
         var0 /= 2;
         var1 /= 2;
         if(var0 <= b && var1 <= c) {
            int var3 = MathHelper.abs(var0 * b + var1);
            if(var3 < a.size()) {
               var2 = (IBlockData)a.get(var3);
            }
         }
      }

      return var2;
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public void a(class_aoh var1, int var2, int var3) {
   }

   public boolean a(class_aoh var1, Chunk var2, int var3, int var4) {
      return false;
   }

   public boolean a(boolean var1, class_nw var2) {
      return true;
   }

   public void c() {
   }

   public boolean d() {
      return false;
   }

   public boolean e() {
      return true;
   }

   public String f() {
      return "DebugLevelSource";
   }

   public List a(class_qc var1, BlockPosition var2) {
      BiomeBase var3 = this.d.b(var2);
      return var3.a(var1);
   }

   public BlockPosition a(World var1, String var2, BlockPosition var3) {
      return null;
   }

   public int g() {
      return 0;
   }

   public void a(Chunk var1, int var2, int var3) {
   }

   public Chunk a(BlockPosition var1) {
      return this.d(var1.getX() >> 4, var1.getZ() >> 4);
   }

   static {
      Iterator var0 = Block.BLOCK_REGISTRY.iterator();

      while(var0.hasNext()) {
         Block var1 = (Block)var0.next();
         a.addAll(var1.getBlockStateList().a());
      }

      b = MathHelper.ceil(MathHelper.sqrt((float)a.size()));
      c = MathHelper.ceil((float)a.size() / (float)b);
   }
}
