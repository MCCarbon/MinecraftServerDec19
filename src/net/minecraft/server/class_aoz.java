package net.minecraft.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.server.WorldProvider;
import net.minecraft.server.WorldProviderHell;
import net.minecraft.server.WorldProviderNormal;
import net.minecraft.server.WorldProviderTheEnd;

public enum class_aoz {
   a(0, "Overworld", "", WorldProviderNormal.class),
   b(-1, "Nether", "_nether", WorldProviderHell.class),
   c(1, "The End", "_end", WorldProviderTheEnd.class);

   private final int d;
   private final String e;
   private final String f;
   private final Class g;

   private class_aoz(int var3, String var4, String var5, Class var6) {
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
   }

   public int a() {
      return this.d;
   }

   public String b() {
      return this.e;
   }

   public String c() {
      return this.f;
   }

   public WorldProvider d() {
      try {
         Constructor var1 = this.g.getConstructor(new Class[0]);
         return (WorldProvider)var1.newInstance(new Object[0]);
      } catch (NoSuchMethodException var2) {
         throw new Error("Could not create new dimension", var2);
      } catch (InvocationTargetException var3) {
         throw new Error("Could not create new dimension", var3);
      } catch (InstantiationException var4) {
         throw new Error("Could not create new dimension", var4);
      } catch (IllegalAccessException var5) {
         throw new Error("Could not create new dimension", var5);
      }
   }

   public static class_aoz a(int var0) {
      class_aoz[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aoz var4 = var1[var3];
         if(var4.a() == var0) {
            return var4;
         }
      }

      throw new IllegalArgumentException("Invalid dimension id " + var0);
   }
}
