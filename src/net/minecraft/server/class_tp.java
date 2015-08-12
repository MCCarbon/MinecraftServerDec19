package net.minecraft.server;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class class_tp {
   private World a;
   private final List b = Lists.newArrayList();
   private BlockPosition c;
   private BlockPosition d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private TreeMap j;
   private List k;
   private int l;

   public class_tp() {
      this.c = BlockPosition.ZERO;
      this.d = BlockPosition.ZERO;
      this.j = new TreeMap();
      this.k = Lists.newArrayList();
   }

   public class_tp(World var1) {
      this.c = BlockPosition.ZERO;
      this.d = BlockPosition.ZERO;
      this.j = new TreeMap();
      this.k = Lists.newArrayList();
      this.a = var1;
   }

   public void a(World var1) {
      this.a = var1;
   }

   public void a(int var1) {
      this.g = var1;
      this.m();
      this.l();
      if(var1 % 20 == 0) {
         this.k();
      }

      if(var1 % 30 == 0) {
         this.j();
      }

      int var2 = this.h / 10;
      if(this.l < var2 && this.b.size() > 20 && this.a.random.nextInt(7000) == 0) {
         Vec3D var3 = this.a(this.d, 2, 4, 2);
         if(var3 != null) {
            EntityVillagerGolem var4 = new EntityVillagerGolem(this.a);
            var4.setPosition(var3.x, var3.y, var3.z);
            this.a.addEntity((Entity)var4);
            ++this.l;
         }
      }

   }

   private Vec3D a(BlockPosition var1, int var2, int var3, int var4) {
      for(int var5 = 0; var5 < 10; ++var5) {
         BlockPosition var6 = var1.add(this.a.random.nextInt(16) - 8, this.a.random.nextInt(6) - 3, this.a.random.nextInt(16) - 8);
         if(this.a(var6) && this.a(new BlockPosition(var2, var3, var4), var6)) {
            return new Vec3D((double)var6.getX(), (double)var6.getY(), (double)var6.getZ());
         }
      }

      return null;
   }

   private boolean a(BlockPosition var1, BlockPosition var2) {
      if(!World.a((IBlockAccess)this.a, (BlockPosition)var2.down())) {
         return false;
      } else {
         int var3 = var2.getX() - var1.getX() / 2;
         int var4 = var2.getZ() - var1.getZ() / 2;

         for(int var5 = var3; var5 < var3 + var1.getX(); ++var5) {
            for(int var6 = var2.getY(); var6 < var2.getY() + var1.getY(); ++var6) {
               for(int var7 = var4; var7 < var4 + var1.getZ(); ++var7) {
                  if(this.a.getType(new BlockPosition(var5, var6, var7)).getBlock().isOccluding()) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private void j() {
      List var1 = this.a.getEntities(EntityVillagerGolem.class, new AxisAlignedBB((double)(this.d.getX() - this.e), (double)(this.d.getY() - 4), (double)(this.d.getZ() - this.e), (double)(this.d.getX() + this.e), (double)(this.d.getY() + 4), (double)(this.d.getZ() + this.e)));
      this.l = var1.size();
   }

   private void k() {
      List var1 = this.a.getEntities(EntityVillager.class, new AxisAlignedBB((double)(this.d.getX() - this.e), (double)(this.d.getY() - 4), (double)(this.d.getZ() - this.e), (double)(this.d.getX() + this.e), (double)(this.d.getY() + 4), (double)(this.d.getZ() + this.e)));
      this.h = var1.size();
      if(this.h == 0) {
         this.j.clear();
      }

   }

   public BlockPosition a() {
      return this.d;
   }

   public int b() {
      return this.e;
   }

   public int c() {
      return this.b.size();
   }

   public int d() {
      return this.g - this.f;
   }

   public int e() {
      return this.h;
   }

   public boolean a(BlockPosition var1) {
      return this.d.distanceSquared(var1) < (double)(this.e * this.e);
   }

   public List f() {
      return this.b;
   }

   public class_to b(BlockPosition var1) {
      class_to var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         class_to var5 = (class_to)var4.next();
         int var6 = var5.a(var1);
         if(var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public class_to c(BlockPosition var1) {
      class_to var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         class_to var5 = (class_to)var4.next();
         int var6 = var5.a(var1);
         if(var6 > 256) {
            var6 *= 1000;
         } else {
            var6 = var5.c();
         }

         if(var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public class_to e(BlockPosition var1) {
      if(this.d.distanceSquared(var1) > (double)(this.e * this.e)) {
         return null;
      } else {
         Iterator var2 = this.b.iterator();

         class_to var3;
         do {
            if(!var2.hasNext()) {
               return null;
            }

            var3 = (class_to)var2.next();
         } while(var3.d().getX() != var1.getX() || var3.d().getZ() != var1.getZ() || Math.abs(var3.d().getY() - var1.getY()) > 1);

         return var3;
      }
   }

   public void a(class_to var1) {
      this.b.add(var1);
      this.c = this.c.add((BaseBlockPosition)var1.d());
      this.n();
      this.f = var1.h();
   }

   public boolean g() {
      return this.b.isEmpty();
   }

   public void a(EntityLiving var1) {
      Iterator var2 = this.k.iterator();

      class_tp.class_a_in_class_tp var3;
      do {
         if(!var2.hasNext()) {
            this.k.add(new class_tp.class_a_in_class_tp(var1, this.g));
            return;
         }

         var3 = (class_tp.class_a_in_class_tp)var2.next();
      } while(var3.a != var1);

      var3.b = this.g;
   }

   public EntityLiving b(EntityLiving var1) {
      double var2 = Double.MAX_VALUE;
      class_tp.class_a_in_class_tp var4 = null;

      for(int var5 = 0; var5 < this.k.size(); ++var5) {
         class_tp.class_a_in_class_tp var6 = (class_tp.class_a_in_class_tp)this.k.get(var5);
         double var7 = var6.a.h(var1);
         if(var7 <= var2) {
            var4 = var6;
            var2 = var7;
         }
      }

      return var4 != null?var4.a:null;
   }

   public EntityHuman c(EntityLiving var1) {
      double var2 = Double.MAX_VALUE;
      EntityHuman var4 = null;
      Iterator var5 = this.j.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         if(this.d(var6)) {
            EntityHuman var7 = this.a.a(var6);
            if(var7 != null) {
               double var8 = var7.h(var1);
               if(var8 <= var2) {
                  var4 = var7;
                  var2 = var8;
               }
            }
         }
      }

      return var4;
   }

   private void l() {
      Iterator var1 = this.k.iterator();

      while(true) {
         class_tp.class_a_in_class_tp var2;
         do {
            if(!var1.hasNext()) {
               return;
            }

            var2 = (class_tp.class_a_in_class_tp)var1.next();
         } while(var2.a.isAlive() && Math.abs(this.g - var2.b) <= 300);

         var1.remove();
      }
   }

   private void m() {
      boolean var1 = false;
      boolean var2 = this.a.random.nextInt(50) == 0;
      Iterator var3 = this.b.iterator();

      while(true) {
         class_to var4;
         do {
            if(!var3.hasNext()) {
               if(var1) {
                  this.n();
               }

               return;
            }

            var4 = (class_to)var3.next();
            if(var2) {
               var4.a();
            }
         } while(this.f(var4.d()) && Math.abs(this.g - var4.h()) <= 1200);

         this.c = this.c.substract(var4.d());
         var1 = true;
         var4.a(true);
         var3.remove();
      }
   }

   private boolean f(BlockPosition var1) {
      Block var2 = this.a.getType(var1).getBlock();
      return var2 instanceof BlockDoor ?var2.getMaterial() == Material.WOOD:false;
   }

   private void n() {
      int var1 = this.b.size();
      if(var1 == 0) {
         this.d = new BlockPosition(0, 0, 0);
         this.e = 0;
      } else {
         this.d = new BlockPosition(this.c.getX() / var1, this.c.getY() / var1, this.c.getZ() / var1);
         int var2 = 0;

         class_to var4;
         for(Iterator var3 = this.b.iterator(); var3.hasNext(); var2 = Math.max(var4.a(this.d), var2)) {
            var4 = (class_to)var3.next();
         }

         this.e = Math.max(32, (int)Math.sqrt((double)var2) + 1);
      }
   }

   public int a(String var1) {
      Integer var2 = (Integer)this.j.get(var1);
      return var2 != null?var2.intValue():0;
   }

   public int a(String var1, int var2) {
      int var3 = this.a(var1);
      int var4 = MathHelper.clamp(var3 + var2, -30, 10);
      this.j.put(var1, Integer.valueOf(var4));
      return var4;
   }

   public boolean d(String var1) {
      return this.a(var1) <= -15;
   }

   public void a(NBTTagCompound var1) {
      this.h = var1.getInt("PopSize");
      this.e = var1.getInt("Radius");
      this.l = var1.getInt("Golems");
      this.f = var1.getInt("Stable");
      this.g = var1.getInt("Tick");
      this.i = var1.getInt("MTick");
      this.d = new BlockPosition(var1.getInt("CX"), var1.getInt("CY"), var1.getInt("CZ"));
      this.c = new BlockPosition(var1.getInt("ACX"), var1.getInt("ACY"), var1.getInt("ACZ"));
      NBTTagList var2 = var1.getList("Doors", 10);

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         class_to var5 = new class_to(new BlockPosition(var4.getInt("X"), var4.getInt("Y"), var4.getInt("Z")), var4.getInt("IDX"), var4.getInt("IDZ"), var4.getInt("TS"));
         this.b.add(var5);
      }

      NBTTagList var8 = var1.getList("Players", 10);

      for(int var9 = 0; var9 < var8.getSize(); ++var9) {
         NBTTagCompound var10 = var8.getCompound(var9);
         if(var10.has("UUID")) {
            class_lv var6 = MinecraftServer.getServer().aF();
            GameProfile var7 = var6.a(UUID.fromString(var10.getString("UUID")));
            if(var7 != null) {
               this.j.put(var7.getName(), Integer.valueOf(var10.getInt("S")));
            }
         } else {
            this.j.put(var10.getString("Name"), Integer.valueOf(var10.getInt("S")));
         }
      }

   }

   public void b(NBTTagCompound var1) {
      var1.put("PopSize", this.h);
      var1.put("Radius", this.e);
      var1.put("Golems", this.l);
      var1.put("Stable", this.f);
      var1.put("Tick", this.g);
      var1.put("MTick", this.i);
      var1.put("CX", this.d.getX());
      var1.put("CY", this.d.getY());
      var1.put("CZ", this.d.getZ());
      var1.put("ACX", this.c.getX());
      var1.put("ACY", this.c.getY());
      var1.put("ACZ", this.c.getZ());
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         class_to var4 = (class_to)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.put("X", var4.d().getX());
         var5.put("Y", var4.d().getY());
         var5.put("Z", var4.d().getZ());
         var5.put("IDX", var4.f());
         var5.put("IDZ", var4.g());
         var5.put("TS", var4.h());
         var2.add((NBTTag)var5);
      }

      var1.put((String)"Doors", (NBTTag)var2);
      NBTTagList var9 = new NBTTagList();
      Iterator var10 = this.j.keySet().iterator();

      while(var10.hasNext()) {
         String var11 = (String)var10.next();
         NBTTagCompound var6 = new NBTTagCompound();
         class_lv var7 = MinecraftServer.getServer().aF();
         GameProfile var8 = var7.a(var11);
         if(var8 != null) {
            var6.put("UUID", var8.getId().toString());
            var6.put("S", ((Integer)this.j.get(var11)).intValue());
            var9.add((NBTTag)var6);
         }
      }

      var1.put((String)"Players", (NBTTag)var9);
   }

   public void h() {
      this.i = this.g;
   }

   public boolean i() {
      return this.i == 0 || this.g - this.i >= 3600;
   }

   public void b(int var1) {
      Iterator var2 = this.j.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.a(var3, var1);
      }

   }

   class class_a_in_class_tp {
      public EntityLiving a;
      public int b;

      class_a_in_class_tp(EntityLiving var2, int var3) {
         this.a = var2;
         this.b = var3;
      }
   }
}
