package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenEndCity;
import net.minecraft.server.WorldGenEndCityPieces;
import net.minecraft.server.WorldGenMineshaftPieces;
import net.minecraft.server.WorldGenMineshaftStart;
import net.minecraft.server.WorldGenNether;
import net.minecraft.server.WorldGenNetherPieces;
import net.minecraft.server.WorldGenMonument;
import net.minecraft.server.WorldGenMonumetPieces;
import net.minecraft.server.WorldGenLargeFeature;
import net.minecraft.server.WorldGenRegistration;
import net.minecraft.server.WorldGenStronghold;
import net.minecraft.server.WorldGenStrongholdPieces;
import net.minecraft.server.StructurePiece;
import net.minecraft.server.StructureStart;
import net.minecraft.server.WorldGenVillage;
import net.minecraft.server.WorldGenVillagePieces;
import net.minecraft.server.NBTTagCompound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldGenFactory {
   private static final Logger a = LogManager.getLogger();
   private static Map b = Maps.newHashMap();
   private static Map c = Maps.newHashMap();
   private static Map d = Maps.newHashMap();
   private static Map e = Maps.newHashMap();

   private static void b(Class var0, String var1) {
      b.put(var1, var0);
      c.put(var0, var1);
   }

   static void a(Class var0, String var1) {
      d.put(var1, var0);
      e.put(var0, var1);
   }

   public static String a(StructureStart var0) {
      return (String)c.get(var0.getClass());
   }

   public static String a(StructurePiece var0) {
      return (String)e.get(var0.getClass());
   }

   public static StructureStart a(NBTTagCompound var0, World var1) {
      StructureStart var2 = null;

      try {
         Class var3 = (Class)b.get(var0.getString("id"));
         if(var3 != null) {
            var2 = (StructureStart)var3.newInstance();
         }
      } catch (Exception var4) {
         a.warn("Failed Start with id " + var0.getString("id"));
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.a(var1, var0);
      } else {
         a.warn("Skipping Structure with id " + var0.getString("id"));
      }

      return var2;
   }

   public static StructurePiece b(NBTTagCompound var0, World var1) {
      StructurePiece var2 = null;

      try {
         Class var3 = (Class)d.get(var0.getString("id"));
         if(var3 != null) {
            var2 = (StructurePiece)var3.newInstance();
         }
      } catch (Exception var4) {
         a.warn("Failed Piece with id " + var0.getString("id"));
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.a(var1, var0);
      } else {
         a.warn("Skipping Piece with id " + var0.getString("id"));
      }

      return var2;
   }

   static {
      b(WorldGenMineshaftStart.class, "Mineshaft");
      b(WorldGenVillage.WorldGenVillageStart.class, "Village");
      b(WorldGenNether.WorldGenNetherStart.class, "Fortress");
      b(WorldGenStronghold.WorldGenStrongholdStart.class, "Stronghold");
      b(WorldGenLargeFeature.WorldGenLargeFeatureStart.class, "Temple");
      b(WorldGenMonument.WorldGenMonumentStart.class, "Monument");
      b(WorldGenEndCity.WorldGenEndCityStart.class, "EndCity");
      WorldGenMineshaftPieces.a();
      WorldGenVillagePieces.a();
      WorldGenNetherPieces.a();
      WorldGenStrongholdPieces.a();
      WorldGenRegistration.a();
      WorldGenMonumetPieces.a();
      WorldGenEndCityPieces.a();
   }
}
