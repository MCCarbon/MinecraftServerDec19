package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.World;
import net.minecraft.server.class_arx;
import net.minecraft.server.class_ary;
import net.minecraft.server.class_asa;
import net.minecraft.server.class_asb;
import net.minecraft.server.class_asc;
import net.minecraft.server.class_asd;
import net.minecraft.server.class_ase;
import net.minecraft.server.class_asf;
import net.minecraft.server.class_asg;
import net.minecraft.server.class_ash;
import net.minecraft.server.class_asi;
import net.minecraft.server.class_asj;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;
import net.minecraft.server.class_asq;
import net.minecraft.server.class_asr;
import net.minecraft.server.class_dn;
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

   public static String a(class_aso var0) {
      return (String)c.get(var0.getClass());
   }

   public static String a(class_asn var0) {
      return (String)e.get(var0.getClass());
   }

   public static class_aso a(class_dn var0, World var1) {
      class_aso var2 = null;

      try {
         Class var3 = (Class)b.get(var0.k("id"));
         if(var3 != null) {
            var2 = (class_aso)var3.newInstance();
         }
      } catch (Exception var4) {
         a.warn("Failed Start with id " + var0.k("id"));
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.a(var1, var0);
      } else {
         a.warn("Skipping Structure with id " + var0.k("id"));
      }

      return var2;
   }

   public static class_asn b(class_dn var0, World var1) {
      class_asn var2 = null;

      try {
         Class var3 = (Class)d.get(var0.k("id"));
         if(var3 != null) {
            var2 = (class_asn)var3.newInstance();
         }
      } catch (Exception var4) {
         a.warn("Failed Piece with id " + var0.k("id"));
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.a(var1, var0);
      } else {
         a.warn("Skipping Piece with id " + var0.k("id"));
      }

      return var2;
   }

   static {
      b(class_asb.class, "Mineshaft");
      b(class_asq.class_a_in_class_asq.class, "Village");
      b(class_asc.class_a_in_class_asc.class, "Fortress");
      b(class_asi.class_a_in_class_asi.class, "Stronghold");
      b(class_asg.class_a_in_class_asg.class, "Temple");
      b(class_ase.class_a_in_class_ase.class, "Monument");
      b(class_arx.class_a_in_class_arx.class, "EndCity");
      class_asa.a();
      class_asr.a();
      class_asd.a();
      class_asj.a();
      class_ash.a();
      class_asf.a();
      class_ary.a();
   }
}
