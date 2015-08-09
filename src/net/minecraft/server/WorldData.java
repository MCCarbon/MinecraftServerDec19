package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.GameRules;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.WorldType;
import net.minecraft.server.class_aoz;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_om;

public class WorldData {
   public static final class_om a;
   private long b;
   private WorldType c;
   private String d;
   private int e;
   private int f;
   private int g;
   private long h;
   private long i;
   private long j;
   private long k;
   private NBTTagCompound l;
   private int m;
   private String n;
   private int o;
   private int p;
   private boolean q;
   private int r;
   private boolean s;
   private int t;
   private WorldSettings.EnumGameMode u;
   private boolean v;
   private boolean w;
   private boolean x;
   private boolean y;
   private class_om z;
   private boolean A;
   private double B;
   private double C;
   private double D;
   private long E;
   private double F;
   private double G;
   private double H;
   private int I;
   private int J;
   private final Map K;
   private GameRules L;

   protected WorldData() {
      this.c = WorldType.NORMAL;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = Maps.newEnumMap(class_aoz.class);
      this.L = new GameRules();
   }

   public WorldData(NBTTagCompound var1) {
      this.c = WorldType.NORMAL;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = Maps.newEnumMap(class_aoz.class);
      this.L = new GameRules();
      this.b = var1.getLong("RandomSeed");
      if(var1.hasOfType("generatorName", 8)) {
         String var2 = var1.getString("generatorName");
         this.c = WorldType.getType(var2);
         if(this.c == null) {
            this.c = WorldType.NORMAL;
         } else if(this.c.f()) {
            int var3 = 0;
            if(var1.hasOfType("generatorVersion", 99)) {
               var3 = var1.getInt("generatorVersion");
            }

            this.c = this.c.a(var3);
         }

         if(var1.hasOfType("generatorOptions", 8)) {
            this.d = var1.getString("generatorOptions");
         }
      }

      this.u = WorldSettings.EnumGameMode.getById(var1.getInt("GameType"));
      if(var1.hasOfType("MapFeatures", 99)) {
         this.v = var1.getBoolean("MapFeatures");
      } else {
         this.v = true;
      }

      this.e = var1.getInt("SpawnX");
      this.f = var1.getInt("SpawnY");
      this.g = var1.getInt("SpawnZ");
      this.h = var1.getLong("Time");
      if(var1.hasOfType("DayTime", 99)) {
         this.i = var1.getLong("DayTime");
      } else {
         this.i = this.h;
      }

      this.j = var1.getLong("LastPlayed");
      this.k = var1.getLong("SizeOnDisk");
      this.n = var1.getString("LevelName");
      this.o = var1.getInt("version");
      this.p = var1.getInt("clearWeatherTime");
      this.r = var1.getInt("rainTime");
      this.q = var1.getBoolean("raining");
      this.t = var1.getInt("thunderTime");
      this.s = var1.getBoolean("thundering");
      this.w = var1.getBoolean("hardcore");
      if(var1.hasOfType("initialized", 99)) {
         this.y = var1.getBoolean("initialized");
      } else {
         this.y = true;
      }

      if(var1.hasOfType("allowCommands", 99)) {
         this.x = var1.getBoolean("allowCommands");
      } else {
         this.x = this.u == WorldSettings.EnumGameMode.CREATIVE;
      }

      if(var1.hasOfType("Player", 10)) {
         this.l = var1.getCompound("Player");
         this.m = this.l.getInt("Dimension");
      }

      if(var1.hasOfType("GameRules", 10)) {
         this.L.a(var1.getCompound("GameRules"));
      }

      if(var1.hasOfType("Difficulty", 99)) {
         this.z = class_om.a(var1.getByte("Difficulty"));
      }

      if(var1.hasOfType("DifficultyLocked", 1)) {
         this.A = var1.getBoolean("DifficultyLocked");
      }

      if(var1.hasOfType("BorderCenterX", 99)) {
         this.B = var1.getDouble("BorderCenterX");
      }

      if(var1.hasOfType("BorderCenterZ", 99)) {
         this.C = var1.getDouble("BorderCenterZ");
      }

      if(var1.hasOfType("BorderSize", 99)) {
         this.D = var1.getDouble("BorderSize");
      }

      if(var1.hasOfType("BorderSizeLerpTime", 99)) {
         this.E = var1.getLong("BorderSizeLerpTime");
      }

      if(var1.hasOfType("BorderSizeLerpTarget", 99)) {
         this.F = var1.getDouble("BorderSizeLerpTarget");
      }

      if(var1.hasOfType("BorderSafeZone", 99)) {
         this.G = var1.getDouble("BorderSafeZone");
      }

      if(var1.hasOfType("BorderDamagePerBlock", 99)) {
         this.H = var1.getDouble("BorderDamagePerBlock");
      }

      if(var1.hasOfType("BorderWarningBlocks", 99)) {
         this.I = var1.getInt("BorderWarningBlocks");
      }

      if(var1.hasOfType("BorderWarningTime", 99)) {
         this.J = var1.getInt("BorderWarningTime");
      }

      if(var1.hasOfType("DimensionData", 10)) {
         NBTTagCompound var5 = var1.getCompound("DimensionData");
         Iterator var6 = var5.getKeys().iterator();

         while(var6.hasNext()) {
            String var4 = (String)var6.next();
            this.K.put(class_aoz.a(Integer.parseInt(var4)), var5.getCompound(var4));
         }
      }

   }

   public WorldData(WorldSettings var1, String var2) {
      this.c = WorldType.NORMAL;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = Maps.newEnumMap(class_aoz.class);
      this.L = new GameRules();
      this.a(var1);
      this.n = var2;
      this.z = a;
      this.y = false;
   }

   public void a(WorldSettings var1) {
      this.b = var1.d();
      this.u = var1.e();
      this.v = var1.g();
      this.w = var1.f();
      this.c = var1.h();
      this.d = var1.j();
      this.x = var1.i();
   }

   public WorldData(WorldData var1) {
      this.c = WorldType.NORMAL;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = Maps.newEnumMap(class_aoz.class);
      this.L = new GameRules();
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.u = var1.u;
      this.v = var1.v;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
      this.r = var1.r;
      this.q = var1.q;
      this.t = var1.t;
      this.s = var1.s;
      this.w = var1.w;
      this.x = var1.x;
      this.y = var1.y;
      this.L = var1.L;
      this.z = var1.z;
      this.A = var1.A;
      this.B = var1.B;
      this.C = var1.C;
      this.D = var1.D;
      this.E = var1.E;
      this.F = var1.F;
      this.G = var1.G;
      this.H = var1.H;
      this.J = var1.J;
      this.I = var1.I;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.a(var1, this.l);
      return var1;
   }

   public NBTTagCompound a(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      this.a(var2, var1);
      return var2;
   }

   private void a(NBTTagCompound var1, NBTTagCompound var2) {
      var1.put("RandomSeed", this.b);
      var1.put("generatorName", this.c.a());
      var1.put("generatorVersion", this.c.d());
      var1.put("generatorOptions", this.d);
      var1.put("GameType", this.u.getId());
      var1.put("MapFeatures", this.v);
      var1.put("SpawnX", this.e);
      var1.put("SpawnY", this.f);
      var1.put("SpawnZ", this.g);
      var1.put("Time", this.h);
      var1.put("DayTime", this.i);
      var1.put("SizeOnDisk", this.k);
      var1.put("LastPlayed", MinecraftServer.az());
      var1.put("LevelName", this.n);
      var1.put("version", this.o);
      var1.put("clearWeatherTime", this.p);
      var1.put("rainTime", this.r);
      var1.put("raining", this.q);
      var1.put("thunderTime", this.t);
      var1.put("thundering", this.s);
      var1.put("hardcore", this.w);
      var1.put("allowCommands", this.x);
      var1.put("initialized", this.y);
      var1.put("BorderCenterX", this.B);
      var1.put("BorderCenterZ", this.C);
      var1.put("BorderSize", this.D);
      var1.put("BorderSizeLerpTime", this.E);
      var1.put("BorderSafeZone", this.G);
      var1.put("BorderDamagePerBlock", this.H);
      var1.put("BorderSizeLerpTarget", this.F);
      var1.put("BorderWarningBlocks", (double)this.I);
      var1.put("BorderWarningTime", (double)this.J);
      if(this.z != null) {
         var1.put("Difficulty", (byte)this.z.a());
      }

      var1.put("DifficultyLocked", this.A);
      var1.put((String)"GameRules", (NBTTag)this.L.a());
      NBTTagCompound var3 = new NBTTagCompound();
      Iterator var4 = this.K.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         var3.put(String.valueOf(((class_aoz)var5.getKey()).a()), (NBTTag)var5.getValue());
      }

      var1.put((String)"DimensionData", (NBTTag)var3);
      if(var2 != null) {
         var1.put((String)"Player", (NBTTag)var2);
      }

   }

   public long b() {
      return this.b;
   }

   public int c() {
      return this.e;
   }

   public int d() {
      return this.f;
   }

   public int e() {
      return this.g;
   }

   public long f() {
      return this.h;
   }

   public long g() {
      return this.i;
   }

   public NBTTagCompound i() {
      return this.l;
   }

   public void b(long var1) {
      this.h = var1;
   }

   public void c(long var1) {
      this.i = var1;
   }

   public void a(BlockPosition var1) {
      this.e = var1.getX();
      this.f = var1.getY();
      this.g = var1.getZ();
   }

   public String k() {
      return this.n;
   }

   public void a(String var1) {
      this.n = var1;
   }

   public int l() {
      return this.o;
   }

   public void e(int var1) {
      this.o = var1;
   }

   public int A() {
      return this.p;
   }

   public void i(int var1) {
      this.p = var1;
   }

   public boolean n() {
      return this.s;
   }

   public void a(boolean var1) {
      this.s = var1;
   }

   public int o() {
      return this.t;
   }

   public void f(int var1) {
      this.t = var1;
   }

   public boolean p() {
      return this.q;
   }

   public void b(boolean var1) {
      this.q = var1;
   }

   public int q() {
      return this.r;
   }

   public void g(int var1) {
      this.r = var1;
   }

   public WorldSettings.EnumGameMode r() {
      return this.u;
   }

   public boolean s() {
      return this.v;
   }

   public void f(boolean var1) {
      this.v = var1;
   }

   public void a(WorldSettings.EnumGameMode var1) {
      this.u = var1;
   }

   public boolean t() {
      return this.w;
   }

   public void g(boolean var1) {
      this.w = var1;
   }

   public WorldType u() {
      return this.c;
   }

   public void a(WorldType var1) {
      this.c = var1;
   }

   public String B() {
      return this.d;
   }

   public boolean v() {
      return this.x;
   }

   public void c(boolean var1) {
      this.x = var1;
   }

   public boolean w() {
      return this.y;
   }

   public void d(boolean var1) {
      this.y = var1;
   }

   public GameRules x() {
      return this.L;
   }

   public double C() {
      return this.B;
   }

   public double D() {
      return this.C;
   }

   public double E() {
      return this.D;
   }

   public void a(double var1) {
      this.D = var1;
   }

   public long F() {
      return this.E;
   }

   public void e(long var1) {
      this.E = var1;
   }

   public double G() {
      return this.F;
   }

   public void b(double var1) {
      this.F = var1;
   }

   public void c(double var1) {
      this.C = var1;
   }

   public void d(double var1) {
      this.B = var1;
   }

   public double H() {
      return this.G;
   }

   public void e(double var1) {
      this.G = var1;
   }

   public double I() {
      return this.H;
   }

   public void f(double var1) {
      this.H = var1;
   }

   public int J() {
      return this.I;
   }

   public int K() {
      return this.J;
   }

   public void j(int var1) {
      this.I = var1;
   }

   public void k(int var1) {
      this.J = var1;
   }

   public class_om y() {
      return this.z;
   }

   public void a(class_om var1) {
      this.z = var1;
   }

   public boolean z() {
      return this.A;
   }

   public void e(boolean var1) {
      this.A = var1;
   }

   public void a(class_c var1) {
      var1.a("Level seed", new Callable() {
         public String a() throws Exception {
            return String.valueOf(WorldData.this.b());
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level generator", new Callable() {
         public String a() throws Exception {
            return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[]{Integer.valueOf(WorldData.this.c.g()), WorldData.this.c.a(), Integer.valueOf(WorldData.this.c.d()), Boolean.valueOf(WorldData.this.v)});
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level generator options", new Callable() {
         public String a() throws Exception {
            return WorldData.this.d;
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level spawn location", new Callable() {
         public String a() throws Exception {
            return class_c.a((double)WorldData.this.e, (double)WorldData.this.f, (double)WorldData.this.g);
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level time", new Callable() {
         public String a() throws Exception {
            return String.format("%d game time, %d day time", new Object[]{Long.valueOf(WorldData.this.h), Long.valueOf(WorldData.this.i)});
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level dimension", new Callable() {
         public String a() throws Exception {
            return String.valueOf(WorldData.this.m);
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level storage version", new Callable() {
         public String a() throws Exception {
            String var1 = "Unknown?";

            try {
               switch(WorldData.this.o) {
               case 19132:
                  var1 = "McRegion";
                  break;
               case 19133:
                  var1 = "Anvil";
               }
            } catch (Throwable var3) {
               ;
            }

            return String.format("0x%05X - %s", new Object[]{Integer.valueOf(WorldData.this.o), var1});
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level weather", new Callable() {
         public String a() throws Exception {
            return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[]{Integer.valueOf(WorldData.this.r), Boolean.valueOf(WorldData.this.q), Integer.valueOf(WorldData.this.t), Boolean.valueOf(WorldData.this.s)});
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level game mode", new Callable() {
         public String a() throws Exception {
            return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[]{WorldData.this.u.getName(), Integer.valueOf(WorldData.this.u.getId()), Boolean.valueOf(WorldData.this.w), Boolean.valueOf(WorldData.this.x)});
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
   }

   public NBTTagCompound a(class_aoz var1) {
      NBTTagCompound var2 = (NBTTagCompound)this.K.get(var1);
      return var2 == null?new NBTTagCompound():var2;
   }

   public void a(class_aoz var1, NBTTagCompound var2) {
      this.K.put(var1, var2);
   }

   static {
      a = class_om.c;
   }
}
