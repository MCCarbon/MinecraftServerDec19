package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class class_aee {
   private int a = 20;
   private String b = "Pig";
   private final List c = Lists.newArrayList();
   private class_aee.class_a_in_class_aee d;
   private double e;
   private double f;
   private int g = 200;
   private int h = 800;
   private int i = 4;
   private Entity j;
   private int k = 6;
   private int l = 16;
   private int m = 4;

   private String f() {
      if(this.i() == null) {
         if(this.b != null && this.b.equals("Minecart")) {
            this.b = "MinecartRideable";
         }

         return this.b;
      } else {
         return this.i().d;
      }
   }

   public void a(String var1) {
      this.b = var1;
   }

   private boolean g() {
      BlockPosition var1 = this.b();
      return this.a().b((double)var1.getX() + 0.5D, (double)var1.getY() + 0.5D, (double)var1.getZ() + 0.5D, (double)this.l);
   }

   public void c() {
      if(this.g()) {
         BlockPosition var1 = this.b();
         double var6;
         if(this.a().isClientSide) {
            double var13 = (double)((float)var1.getX() + this.a().random.nextFloat());
            double var14 = (double)((float)var1.getY() + this.a().random.nextFloat());
            var6 = (double)((float)var1.getZ() + this.a().random.nextFloat());
            this.a().addParticle(EnumParticle.l, var13, var14, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            this.a().addParticle(EnumParticle.A, var13, var14, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            if(this.a > 0) {
               --this.a;
            }

            this.f = this.e;
            this.e = (this.e + (double)(1000.0F / ((float)this.a + 200.0F))) % 360.0D;
         } else {
            if(this.a == -1) {
               this.h();
            }

            if(this.a > 0) {
               --this.a;
               return;
            }

            boolean var2 = false;
            int var3 = 0;

            while(true) {
               if(var3 >= this.i) {
                  if(var2) {
                     this.h();
                  }
                  break;
               }

               Entity var4 = EntityTypes.a(this.f(), this.a());
               if(var4 == null) {
                  return;
               }

               int var5 = this.a().getEntities(var4.getClass(), (new AxisAlignedBB((double)var1.getX(), (double)var1.getY(), (double)var1.getZ(), (double)(var1.getX() + 1), (double)(var1.getY() + 1), (double)(var1.getZ() + 1))).grow((double)this.m, (double)this.m, (double)this.m)).size();
               if(var5 >= this.k) {
                  this.h();
                  return;
               }

               var6 = (double)var1.getX() + (this.a().random.nextDouble() - this.a().random.nextDouble()) * (double)this.m + 0.5D;
               double var8 = (double)(var1.getY() + this.a().random.nextInt(3) - 1);
               double var10 = (double)var1.getZ() + (this.a().random.nextDouble() - this.a().random.nextDouble()) * (double)this.m + 0.5D;
               EntityInsentient var12 = var4 instanceof EntityInsentient ?(EntityInsentient)var4:null;
               var4.b(var6, var8, var10, this.a().random.nextFloat() * 360.0F, 0.0F);
               if(var12 == null || var12.cf() && var12.cg()) {
                  this.a(var4, true);
                  this.a().b(2004, var1, 0);
                  if(var12 != null) {
                     var12.A();
                  }

                  var2 = true;
               }

               ++var3;
            }
         }

      }
   }

   private Entity a(Entity var1, boolean var2) {
      if(this.i() != null) {
         NBTTagCompound var3 = new NBTTagCompound();
         var1.d(var3);
         Iterator var4 = this.i().c.getKeys().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            NBTTag var6 = this.i().c.getTag(var5);
            var3.put(var5, var6.clone());
         }

         var1.f(var3);
         if(var1.world != null && var2) {
            var1.world.addEntity(var1);
         }

         NBTTagCompound var12;
         for(Entity var11 = var1; var3.hasOfType("Riding", 10); var3 = var12) {
            var12 = var3.getCompound("Riding");
            Entity var13 = EntityTypes.a(var12.getString("id"), var1.world);
            if(var13 != null) {
               NBTTagCompound var7 = new NBTTagCompound();
               var13.d(var7);
               Iterator var8 = var12.getKeys().iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  NBTTag var10 = var12.getTag(var9);
                  var7.put(var9, var10.clone());
               }

               var13.f(var7);
               var13.b(var11.locX, var11.locY, var11.locZ, var11.yaw, var11.pitch);
               if(var1.world != null && var2) {
                  var1.world.addEntity(var13);
               }

               var11.a(var13);
            }

            var11 = var13;
         }
      } else if(var1 instanceof EntityLiving && var1.world != null && var2) {
         if(var1 instanceof EntityInsentient) {
            ((EntityInsentient)var1).a((class_on)var1.world.E(new BlockPosition(var1)), (class_qd)null);
         }

         var1.world.addEntity(var1);
      }

      return var1;
   }

   private void h() {
      if(this.h <= this.g) {
         this.a = this.g;
      } else {
         int var10003 = this.h - this.g;
         this.a = this.g + this.a().random.nextInt(var10003);
      }

      if(!this.c.isEmpty()) {
         this.a((class_aee.class_a_in_class_aee)class_oc.a(this.a().random, this.c));
      }

      this.a(1);
   }

   public void a(NBTTagCompound var1) {
      this.b = var1.getString("EntityId");
      this.a = var1.getShort("Delay");
      this.c.clear();
      if(var1.hasOfType("SpawnPotentials", 9)) {
         NBTTagList var2 = var1.getList("SpawnPotentials", 10);

         for(int var3 = 0; var3 < var2.getSize(); ++var3) {
            this.c.add(new class_aee.class_a_in_class_aee(var2.getCompound(var3)));
         }
      }

      if(var1.hasOfType("SpawnData", 10)) {
         this.a(new class_aee.class_a_in_class_aee(var1.getCompound("SpawnData"), this.b));
      } else {
         this.a((class_aee.class_a_in_class_aee)null);
      }

      if(var1.hasOfType("MinSpawnDelay", 99)) {
         this.g = var1.getShort("MinSpawnDelay");
         this.h = var1.getShort("MaxSpawnDelay");
         this.i = var1.getShort("SpawnCount");
      }

      if(var1.hasOfType("MaxNearbyEntities", 99)) {
         this.k = var1.getShort("MaxNearbyEntities");
         this.l = var1.getShort("RequiredPlayerRange");
      }

      if(var1.hasOfType("SpawnRange", 99)) {
         this.m = var1.getShort("SpawnRange");
      }

      if(this.a() != null) {
         this.j = null;
      }

   }

   public void b(NBTTagCompound var1) {
      String var2 = this.f();
      if(!class_nz.b(var2)) {
         var1.put("EntityId", var2);
         var1.put("Delay", (short)this.a);
         var1.put("MinSpawnDelay", (short)this.g);
         var1.put("MaxSpawnDelay", (short)this.h);
         var1.put("SpawnCount", (short)this.i);
         var1.put("MaxNearbyEntities", (short)this.k);
         var1.put("RequiredPlayerRange", (short)this.l);
         var1.put("SpawnRange", (short)this.m);
         if(this.i() != null) {
            var1.put("SpawnData", this.i().c.clone());
         }

         if(this.i() != null || !this.c.isEmpty()) {
            NBTTagList var3 = new NBTTagList();
            if(!this.c.isEmpty()) {
               Iterator var4 = this.c.iterator();

               while(var4.hasNext()) {
                  class_aee.class_a_in_class_aee var5 = (class_aee.class_a_in_class_aee)var4.next();
                  var3.add((NBTTag)var5.a());
               }
            } else {
               var3.add((NBTTag)this.i().a());
            }

            var1.put((String)"SpawnPotentials", (NBTTag)var3);
         }

      }
   }

   public boolean b(int var1) {
      if(var1 == 1 && this.a().isClientSide) {
         this.a = this.g;
         return true;
      } else {
         return false;
      }
   }

   private class_aee.class_a_in_class_aee i() {
      return this.d;
   }

   public void a(class_aee.class_a_in_class_aee var1) {
      this.d = var1;
   }

   public abstract void a(int var1);

   public abstract World a();

   public abstract BlockPosition b();

   public class class_a_in_class_aee extends class_oc.WeightedRandomChoice {
      private final NBTTagCompound c;
      private final String d;

      public class_a_in_class_aee(NBTTagCompound var2) {
         this(var2.getCompound("Properties"), var2.getString("Type"), var2.getInt("Weight"));
      }

      public class_a_in_class_aee(NBTTagCompound var2, String var3) {
         this(var2, var3, 1);
      }

      private class_a_in_class_aee(NBTTagCompound var2, String var3, int var4) {
         super(var4);
         if(var3.equals("Minecart")) {
            if(var2 != null) {
               var3 = EntityMinecartAbstract.EnumMinecartType.a(var2.getInt("Type")).b();
            } else {
               var3 = "MinecartRideable";
            }
         }

         this.c = var2;
         this.d = var3;
      }

      public NBTTagCompound a() {
         NBTTagCompound var1 = new NBTTagCompound();
         var1.put((String)"Properties", (NBTTag)this.c);
         var1.put("Type", this.d);
         var1.put("Weight", this.a);
         return var1;
      }
   }
}
