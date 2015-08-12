package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.StructureGenerator;
import net.minecraft.server.StructurePiece;
import net.minecraft.server.StructureStart;
import net.minecraft.server.WorldGenVillagePieces;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;

public class WorldGenVillage extends StructureGenerator {
   public static final List d;
   private int f;
   private int g;
   private int h;

   public WorldGenVillage() {
      this.g = 32;
      this.h = 8;
   }

   public WorldGenVillage(Map var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("size")) {
            this.f = MathHelper.max((String)((String)var3.getValue()), this.f, 0);
         } else if(((String)var3.getKey()).equals("distance")) {
            this.g = MathHelper.max((String)var3.getValue(), this.g, this.h + 1);
         }
      }

   }

   public String a() {
      return "Village";
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1;
      int var4 = var2;
      if(var1 < 0) {
         var1 -= this.g - 1;
      }

      if(var2 < 0) {
         var2 -= this.g - 1;
      }

      int var5 = var1 / this.g;
      int var6 = var2 / this.g;
      Random var7 = this.c.a(var5, var6, 10387312);
      var5 *= this.g;
      var6 *= this.g;
      var5 += var7.nextInt(this.g - this.h);
      var6 += var7.nextInt(this.g - this.h);
      if(var3 == var5 && var4 == var6) {
         boolean var8 = this.c.getWorldChunkManager().a(var3 * 16 + 8, var4 * 16 + 8, 0, d);
         if(var8) {
            return true;
         }
      }

      return false;
   }

   protected StructureStart b(int var1, int var2) {
      return new WorldGenVillage.WorldGenVillageStart(this.c, this.b, var1, var2, this.f);
   }

   static {
      d = Arrays.asList(new BiomeBase[]{BiomeBase.PLAINS, BiomeBase.DESERT, BiomeBase.SAVANNA});
   }

   public static class WorldGenVillageStart extends StructureStart {
      private boolean c;

      public WorldGenVillageStart() {
      }

      public WorldGenVillageStart(World var1, Random var2, int var3, int var4, int var5) {
         super(var3, var4);
         List var6 = WorldGenVillagePieces.a(var2, var5);
         WorldGenVillagePieces.WorldGenVillageStart var7 = new WorldGenVillagePieces.WorldGenVillageStart(var1.getWorldChunkManager(), 0, var2, (var3 << 4) + 2, (var4 << 4) + 2, var6, var5);
         this.a.add(var7);
         var7.a(var7, this.a, var2);
         List var8 = var7.g;
         List var9 = var7.f;

         int var10;
         while(!var8.isEmpty() || !var9.isEmpty()) {
            StructurePiece var11;
            if(var8.isEmpty()) {
               var10 = var2.nextInt(var9.size());
               var11 = (StructurePiece)var9.remove(var10);
               var11.a((StructurePiece)var7, (List)this.a, (Random)var2);
            } else {
               var10 = var2.nextInt(var8.size());
               var11 = (StructurePiece)var8.remove(var10);
               var11.a((StructurePiece)var7, (List)this.a, (Random)var2);
            }
         }

         this.c();
         var10 = 0;
         Iterator var13 = this.a.iterator();

         while(var13.hasNext()) {
            StructurePiece var12 = (StructurePiece)var13.next();
            if(!(var12 instanceof WorldGenVillagePieces.class_o_in_class_asr)) {
               ++var10;
            }
         }

         this.c = var10 > 2;
      }

      public boolean d() {
         return this.c;
      }

      public void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Valid", this.c);
      }

      public void b(NBTTagCompound var1) {
         super.b(var1);
         this.c = var1.getBoolean("Valid");
      }
   }
}
