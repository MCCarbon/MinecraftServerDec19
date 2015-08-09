package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenEndCity;
import net.minecraft.server.class_ary;
import net.minecraft.server.WorldGenMineshaftPieces;
import net.minecraft.server.WorldGenMineshaftStart;
import net.minecraft.server.class_asc;
import net.minecraft.server.class_asd;
import net.minecraft.server.WorldGenGuardianTemple;
import net.minecraft.server.class_asf;
import net.minecraft.server.WorldGenLargeFeature;
import net.minecraft.server.class_ash;
import net.minecraft.server.WorldGenStronghold;
import net.minecraft.server.class_asj;
import net.minecraft.server.StructurePiece;
import net.minecraft.server.StructureStart;
import net.minecraft.server.WorldGenVillage;
import net.minecraft.server.class_asr;
import net.minecraft.server.NBTTagCompound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_asl {
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
      b(WorldGenVillage.class_a_in_class_asq.class, "Village");
      b(class_asc.class_a_in_class_asc.class, "Fortress");
      b(WorldGenStronghold.class_a_in_class_asi.class, "Stronghold");
      b(WorldGenLargeFeature.class_a_in_class_asg.class, "Temple");
      b(WorldGenGuardianTemple.class_a_in_class_ase.class, "Monument");
      b(WorldGenEndCity.class_a_in_class_arx.class, "EndCity");
      WorldGenMineshaftPieces.a();
      class_asr.a();
      class_asd.a();
      class_asj.a();
      class_ash.a();
      class_asf.a();
      class_ary.a();
   }
}
