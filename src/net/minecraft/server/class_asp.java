package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_asu;
import net.minecraft.server.class_asv;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;

public abstract class class_asp extends class_asn {
   private static final class_asu d = new class_asu();
   protected class_asv a;
   protected class_asu b;
   protected BlockPosition c;

   public class_asp() {
      this.b = d.a(true).b(true);
   }

   public class_asp(int var1) {
      super(var1);
      this.b = d.a(true).b(true);
   }

   protected void a(class_asv var1, BlockPosition var2, class_asu var3) {
      this.a = var1;
      this.a(EnumDirection.NORTH);
      this.c = var2;
      this.b = var3;
      this.h();
   }

   protected void a(NBTTagCompound var1) {
      var1.put("TPX", this.c.getX());
      var1.put("TPY", this.c.getY());
      var1.put("TPZ", this.c.getZ());
   }

   protected void b(NBTTagCompound var1) {
      this.c = new BlockPosition(var1.getInt("TPX"), var1.getInt("TPY"), var1.getInt("TPZ"));
   }

   public boolean a(World var1, Random var2, class_arw var3) {
      this.b.a(var3);
      this.a.b(var1, this.c, this.b);
      Map var4 = this.a.a(this.c, this.b);
      Iterator var5 = var4.keySet().iterator();

      while(var5.hasNext()) {
         BlockPosition var6 = (BlockPosition)var5.next();
         String var7 = (String)var4.get(var6);
         this.a(var7, var6, var1, var2, var3);
      }

      return true;
   }

   protected abstract void a(String var1, BlockPosition var2, World var3, Random var4, class_arw var5);

   private void h() {
      Block.EnumRotation var1 = this.b.c();
      BlockPosition var2 = this.a.a(var1);
      this.l = new class_arw(0, 0, 0, var2.getX(), var2.getY() - 1, var2.getZ());
      switch(class_asp.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
      default:
         break;
      case 2:
         this.l.a(-var2.getX(), 0, 0);
         break;
      case 3:
         this.l.a(0, 0, -var2.getZ());
         break;
      case 4:
         this.l.a(-var2.getX(), 0, -var2.getZ());
      }

      this.l.a(this.c.getX(), this.c.getY(), this.c.getZ());
   }

   public void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.c = this.c.add(var1, var2, var3);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[Block.EnumRotation.values().length];

      static {
         try {
            a[Block.EnumRotation.NONE.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
