package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldServer extends World implements class_of {
   private static final Logger a = LogManager.getLogger();
   private final MinecraftServer I;
   private final class_lb J;
   private final class_ld K;
   private final Set L = Sets.newHashSet();
   private final TreeSet M = new TreeSet();
   private final Map N = Maps.newHashMap();
   public ChunkProviderServer b;
   public boolean c;
   private boolean O;
   private int P;
   private final class_aev Q;
   private final class_aeu R = new class_aeu();
   protected final class_tq d = new class_tq(this);
   private WorldServer.class_a_in_class_lg[] S = new WorldServer.class_a_in_class_lg[]{new WorldServer.class_a_in_class_lg(null), new WorldServer.class_a_in_class_lg(null)};
   private int T;
   private static final List U;
   private List V = Lists.newArrayList();

   public WorldServer(MinecraftServer var1, IDataManager var2, WorldData var3, int var4, MethodProfiler var5) {
      super(var2, var3, class_aoz.a(var4).d(), var5, false);
      this.I = var1;
      this.J = new class_lb(this);
      this.K = new class_ld(this);
      this.worldProvider.a((World)this);
      this.v = this.l();
      this.Q = new class_aev(this);
      this.C();
      this.D();
      this.ag().a(var1.aI());
   }

   public World b() {
      this.z = new PersistentCollection(this.w);
      String var1 = PersistentVillage.a(this.worldProvider);
      PersistentVillage var2 = (PersistentVillage)this.z.a(PersistentVillage.class, var1);
      if(var2 == null) {
         this.A = new PersistentVillage(this);
         this.z.a((String)var1, (PersistentBase)this.A);
      } else {
         this.A = var2;
         this.A.a((World)this);
      }

      this.C = new class_kl(this.I);
      class_awo var3 = (class_awo)this.z.a(class_awo.class, "scoreboard");
      if(var3 == null) {
         var3 = new class_awo();
         this.z.a((String)"scoreboard", (PersistentBase)var3);
      }

      var3.a(this.C);
      ((class_kl)this.C).a(var3);
      this.ag().c(this.x.C(), this.x.D());
      this.ag().c(this.x.I());
      this.ag().b(this.x.H());
      this.ag().c(this.x.J());
      this.ag().b(this.x.K());
      if(this.x.F() > 0L) {
         this.ag().a(this.x.E(), this.x.G(), this.x.F());
      } else {
         this.ag().a(this.x.E());
      }

      return this;
   }

   public void d() {
      super.d();
      if(this.Q().t() && this.ab() != class_om.d) {
         this.Q().a(class_om.d);
      }

      this.worldProvider.k().b();
      if(this.g()) {
         if(this.R().getBooleanValue("doDaylightCycle")) {
            long var1 = this.x.g() + 24000L;
            this.x.c(var1 - var1 % 24000L);
         }

         this.f();
      }

      this.B.a("mobSpawner");
      if(this.R().getBooleanValue("doMobSpawning") && this.x.u() != WorldType.DEBUG) {
         this.R.a(this, this.F, this.G, this.x.f() % 400L == 0L);
      }

      this.B.c("chunkSource");
      this.v.unloadChunks();
      int var3 = this.a(1.0F);
      if(var3 != this.ac()) {
         this.c(var3);
      }

      this.x.b(this.x.f() + 1L);
      if(this.R().getBooleanValue("doDaylightCycle")) {
         this.x.c(this.x.g() + 1L);
      }

      this.B.c("tickPending");
      this.a(false);
      this.B.c("tickBlocks");
      this.i();
      this.B.c("chunkMap");
      this.K.b();
      this.B.c("village");
      this.A.a();
      this.d.a();
      this.B.c("portalForcer");
      this.Q.a(this.L());
      this.B.b();
      this.ak();
   }

   public BiomeBase.BiomeMeta a(EnumCreatureType var1, BlockPosition var2) {
      List var3 = this.O().getMobsFor(var1, var2);
      return var3 != null && !var3.isEmpty()?(BiomeBase.BiomeMeta)class_oc.a(this.random, var3):null;
   }

   public boolean a(EnumCreatureType var1, BiomeBase.BiomeMeta var2, BlockPosition var3) {
      List var4 = this.O().getMobsFor(var1, var3);
      return var4 != null && !var4.isEmpty()?var4.contains(var2):false;
   }

   public void e() {
      this.O = false;
      if(!this.players.isEmpty()) {
         int var1 = 0;
         int var2 = 0;
         Iterator var3 = this.players.iterator();

         while(var3.hasNext()) {
            EntityHuman var4 = (EntityHuman)var3.next();
            if(var4.isSpectator()) {
               ++var1;
            } else if(var4.isSleeping()) {
               ++var2;
            }
         }

         this.O = var2 > 0 && var2 >= this.players.size() - var1;
      }

   }

   protected void f() {
      this.O = false;
      Iterator var1 = this.players.iterator();

      while(var1.hasNext()) {
         EntityHuman var2 = (EntityHuman)var1.next();
         if(var2.isSleeping()) {
            var2.a(false, false, true);
         }
      }

      this.c();
   }

   private void c() {
      this.x.g(0);
      this.x.b(false);
      this.x.f(0);
      this.x.a(false);
   }

   public boolean g() {
      if(this.O && !this.isClientSide) {
         Iterator var1 = this.players.iterator();

         EntityHuman var2;
         do {
            if(!var1.hasNext()) {
               return true;
            }

            var2 = (EntityHuman)var1.next();
         } while(!var2.isSpectator() && var2.ch());

         return false;
      } else {
         return false;
      }
   }

   protected void i() {
      super.i();
      if(this.x.u() == WorldType.DEBUG) {
         Iterator var20 = this.E.iterator();

         while(var20.hasNext()) {
            ChunkCoordIntPair var21 = (ChunkCoordIntPair)var20.next();
            this.getChunkAt(var21.a, var21.b).b(false);
         }

      } else {
         int var1 = 0;
         int var2 = 0;

         for(Iterator var3 = this.E.iterator(); var3.hasNext(); this.B.b()) {
            ChunkCoordIntPair var4 = (ChunkCoordIntPair)var3.next();
            int var5 = var4.a * 16;
            int var6 = var4.b * 16;
            this.B.a("getChunk");
            Chunk var7 = this.getChunkAt(var4.a, var4.b);
            this.a(var5, var6, var7);
            this.B.c("tickChunk");
            var7.b(false);
            this.B.c("thunder");
            int var8;
            BlockPosition var9;
            if(this.random.nextInt(100000) == 0 && this.T() && this.S()) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.a(new BlockPosition(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               if(this.C(var9)) {
                  this.d(new class_vi(this, (double)var9.getX(), (double)var9.getY(), (double)var9.getZ()));
               }
            }

            this.B.c("iceandsnow");
            if(this.random.nextInt(16) == 0) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.q(new BlockPosition(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               BlockPosition var10 = var9.down();
               if(this.w(var10)) {
                  this.setTypeUpdate((BlockPosition)var10, (IBlockData)Blocks.ICE.getBlockData());
               }

               if(this.T() && this.f(var9, true)) {
                  this.setTypeUpdate((BlockPosition)var9, (IBlockData)Blocks.SNOW_LAYER.getBlockData());
               }

               if(this.T() && this.getBiome((BlockPosition)var10).e()) {
                  this.getType(var10).getBlock().rainTick(this, var10);
               }
            }

            this.B.c("tickBlocks");
            var8 = this.R().getIntValue("randomTickSpeed");
            if(var8 > 0) {
               ChunkSection[] var22 = var7.getSections();
               int var23 = var22.length;

               for(int var11 = 0; var11 < var23; ++var11) {
                  ChunkSection var12 = var22[var11];
                  if(var12 != null && var12.b()) {
                     for(int var13 = 0; var13 < var8; ++var13) {
                        this.m = this.m * 3 + 1013904223;
                        int var14 = this.m >> 2;
                        int var15 = var14 & 15;
                        int var16 = var14 >> 8 & 15;
                        int var17 = var14 >> 16 & 15;
                        ++var2;
                        IBlockData var18 = var12.a(var15, var17, var16);
                        Block var19 = var18.getBlock();
                        if(var19.isTicking()) {
                           ++var1;
                           var19.randomTick((World)this, new BlockPosition(var15 + var5, var17 + var12.getYPosition(), var16 + var6), (IBlockData)var18, (Random)this.random);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   protected BlockPosition a(BlockPosition var1) {
      BlockPosition var2 = this.q(var1);
      AxisAlignedBB var3 = (new AxisAlignedBB(var2, new BlockPosition(var2.getX(), this.V(), var2.getZ()))).grow(3.0D, 3.0D, 3.0D);
      List var4 = this.getEntities(EntityLiving.class, var3, new Predicate() {
         public boolean a(EntityLiving var1) {
            return var1 != null && var1.isAlive() && WorldServer.this.i(var1.c());
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((EntityLiving)var1);
         }
      });
      return !var4.isEmpty()?((EntityLiving)var4.get(this.random.nextInt(var4.size()))).c():var2;
   }

   public boolean a(BlockPosition var1, Block var2) {
      class_aex var3 = new class_aex(var1, var2);
      return this.V.contains(var3);
   }

   public void a(BlockPosition var1, Block var2, int var3) {
      this.a(var1, var2, var3, 0);
   }

   public void a(BlockPosition var1, Block var2, int var3, int var4) {
      class_aex var5 = new class_aex(var1, var2);
      byte var6 = 0;
      if(this.e && var2.getMaterial() != Material.AIR) {
         if(var2.P()) {
            var6 = 8;
            if(this.areChunksLoadedBetween((BlockPosition)var5.a.add(-var6, -var6, -var6), (BlockPosition)var5.a.add(var6, var6, var6))) {
               IBlockData var7 = this.getType(var5.a);
               if(var7.getBlock().getMaterial() != Material.AIR && var7.getBlock() == var5.a()) {
                  var7.getBlock().tick((World)this, var5.a, var7, (Random)this.random);
               }
            }

            return;
         }

         var3 = 1;
      }

      if(this.areChunksLoadedBetween((BlockPosition)var1.add(-var6, -var6, -var6), (BlockPosition)var1.add(var6, var6, var6))) {
         if(var2.getMaterial() != Material.AIR) {
            var5.a((long)var3 + this.x.f());
            var5.a(var4);
         }

         if(!this.L.contains(var5)) {
            this.L.add(var5);
            this.M.add(var5);
         }
      }

   }

   public void b(BlockPosition var1, Block var2, int var3, int var4) {
      class_aex var5 = new class_aex(var1, var2);
      var5.a(var4);
      if(var2.getMaterial() != Material.AIR) {
         var5.a((long)var3 + this.x.f());
      }

      if(!this.L.contains(var5)) {
         this.L.add(var5);
         this.M.add(var5);
      }

   }

   public void j() {
      if(this.players.isEmpty()) {
         if(this.P++ >= 300) {
            return;
         }
      } else {
         this.k();
      }

      this.worldProvider.r();
      super.j();
   }

   public void k() {
      this.P = 0;
   }

   public boolean a(boolean var1) {
      if(this.x.u() == WorldType.DEBUG) {
         return false;
      } else {
         int var2 = this.M.size();
         if(var2 != this.L.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
         } else {
            if(var2 > 1000) {
               var2 = 1000;
            }

            this.B.a("cleaning");

            class_aex var4;
            for(int var3 = 0; var3 < var2; ++var3) {
               var4 = (class_aex)this.M.first();
               if(!var1 && var4.b > this.x.f()) {
                  break;
               }

               this.M.remove(var4);
               this.L.remove(var4);
               this.V.add(var4);
            }

            this.B.b();
            this.B.a("ticking");
            Iterator var11 = this.V.iterator();

            while(var11.hasNext()) {
               var4 = (class_aex)var11.next();
               var11.remove();
               byte var5 = 0;
               if(this.areChunksLoadedBetween((BlockPosition)var4.a.add(-var5, -var5, -var5), (BlockPosition)var4.a.add(var5, var5, var5))) {
                  IBlockData var6 = this.getType(var4.a);
                  if(var6.getBlock().getMaterial() != Material.AIR && Block.a(var6.getBlock(), var4.a())) {
                     try {
                        var6.getBlock().tick((World)this, var4.a, var6, (Random)this.random);
                     } catch (Throwable var10) {
                        class_b var8 = class_b.a(var10, "Exception while ticking a block");
                        class_c var9 = var8.a("Block being ticked");
                        class_c.a(var9, var4.a, var6);
                        throw new class_e(var8);
                     }
                  }
               } else {
                  this.a(var4.a, var4.a(), 0);
               }
            }

            this.B.b();
            this.V.clear();
            return !this.M.isEmpty();
         }
      }
   }

   public List a(Chunk var1, boolean var2) {
      ChunkCoordIntPair var3 = var1.j();
      int var4 = (var3.a << 4) - 2;
      int var5 = var4 + 16 + 2;
      int var6 = (var3.b << 4) - 2;
      int var7 = var6 + 16 + 2;
      return this.a(new StructureBoundingBox(var4, 0, var6, var5, 256, var7), var2);
   }

   public List a(StructureBoundingBox var1, boolean var2) {
      ArrayList var3 = null;

      for(int var4 = 0; var4 < 2; ++var4) {
         Iterator var5;
         if(var4 == 0) {
            var5 = this.M.iterator();
         } else {
            var5 = this.V.iterator();
         }

         while(var5.hasNext()) {
            class_aex var6 = (class_aex)var5.next();
            BlockPosition var7 = var6.a;
            if(var7.getX() >= var1.minX && var7.getX() < var1.maxX && var7.getZ() >= var1.minZ && var7.getZ() < var1.maxZ) {
               if(var2) {
                  this.L.remove(var6);
                  var5.remove();
               }

               if(var3 == null) {
                  var3 = Lists.newArrayList();
               }

               var3.add(var6);
            }
         }
      }

      return var3;
   }

   public void a(Entity var1, boolean var2) {
      if(!this.ai() && (var1 instanceof EntityAnimal || var1 instanceof class_uk)) {
         var1.die();
      }

      if(!this.ah() && var1 instanceof NPC) {
         var1.die();
      }

      super.a(var1, var2);
   }

   private boolean ah() {
      return this.I.ah();
   }

   private boolean ai() {
      return this.I.ag();
   }

   protected IChunkProvider l() {
      IChunkLoader var1 = this.w.createChunkLoader(this.worldProvider);
      this.b = new ChunkProviderServer(this, var1, this.worldProvider.c());
      return this.b;
   }

   public List a(int var1, int var2, int var3, int var4, int var5, int var6) {
      ArrayList var7 = Lists.newArrayList();

      for(int var8 = 0; var8 < this.h.size(); ++var8) {
         TileEntity var9 = (TileEntity)this.h.get(var8);
         BlockPosition var10 = var9.getPosition();
         if(var10.getX() >= var1 && var10.getY() >= var2 && var10.getZ() >= var3 && var10.getX() < var4 && var10.getY() < var5 && var10.getZ() < var6) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public boolean a(EntityHuman var1, BlockPosition var2) {
      return !this.I.a((World)this, (BlockPosition)var2, (EntityHuman)var1) && this.ag().a(var2);
   }

   public void a(WorldSettings var1) {
      if(!this.x.w()) {
         try {
            this.b(var1);
            if(this.x.u() == WorldType.DEBUG) {
               this.aj();
            }

            super.a(var1);
         } catch (Throwable var6) {
            class_b var3 = class_b.a(var6, "Exception initializing level");

            try {
               this.a((class_b)var3);
            } catch (Throwable var5) {
               ;
            }

            throw new class_e(var3);
         }

         this.x.d(true);
      }

   }

   private void aj() {
      this.x.f(false);
      this.x.c(true);
      this.x.b(false);
      this.x.a(false);
      this.x.i(1000000000);
      this.x.c(6000L);
      this.x.a(WorldSettings.EnumGameMode.SPECTATOR);
      this.x.g(false);
      this.x.a(class_om.a);
      this.x.e(true);
      this.R().setValue("doDaylightCycle", "false");
   }

   private void b(WorldSettings var1) {
      if(!this.worldProvider.e()) {
         this.x.a(BlockPosition.ZERO.up(this.worldProvider.i()));
      } else if(this.x.u() == WorldType.DEBUG) {
         this.x.a(BlockPosition.ZERO.up());
      } else {
         this.y = true;
         WorldChunkManager var2 = this.worldProvider.k();
         List var3 = var2.a();
         Random var4 = new Random(this.K());
         BlockPosition var5 = var2.a(0, 0, 256, var3, var4);
         int var6 = 0;
         int var7 = this.worldProvider.i();
         int var8 = 0;
         if(var5 != null) {
            var6 = var5.getX();
            var8 = var5.getZ();
         } else {
            a.warn("Unable to find spawn biome");
         }

         int var9 = 0;

         while(!this.worldProvider.a(var6, var8)) {
            var6 += var4.nextInt(64) - var4.nextInt(64);
            var8 += var4.nextInt(64) - var4.nextInt(64);
            ++var9;
            if(var9 == 1000) {
               break;
            }
         }

         this.x.a(new BlockPosition(var6, var7, var8));
         this.y = false;
         if(var1.c()) {
            this.m();
         }

      }
   }

   protected void m() {
      class_aqa var1 = new class_aqa(U, 10);

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = this.x.c() + this.random.nextInt(6) - this.random.nextInt(6);
         int var4 = this.x.e() + this.random.nextInt(6) - this.random.nextInt(6);
         BlockPosition var5 = this.r(new BlockPosition(var3, 0, var4)).up();
         if(var1.generate(this, this.random, var5)) {
            break;
         }
      }

   }

   public BlockPosition n() {
      return this.worldProvider.h();
   }

   public void a(boolean var1, IProgressUpdate var2) throws SessionException {
      if(this.v.canSave()) {
         if(var2 != null) {
            var2.a("Saving level");
         }

         this.a();
         if(var2 != null) {
            var2.c("Saving chunks");
         }

         this.v.saveChunks(var1, var2);
         ArrayList var3 = Lists.newArrayList((Iterable)this.b.a());
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            Chunk var5 = (Chunk)var4.next();
            if(var5 != null && !this.K.a(var5.locX, var5.locZ)) {
               this.b.b(var5.locX, var5.locZ);
            }
         }

      }
   }

   public void o() {
      if(this.v.canSave()) {
         this.v.c();
      }
   }

   protected void a() throws SessionException {
      this.J();
      WorldServer[] var1 = this.I.d;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         WorldServer var4 = var1[var3];
         if(var4 instanceof class_la) {
            ((class_la)var4).c();
         }
      }

      this.x.a(this.ag().h());
      this.x.d(this.ag().f());
      this.x.c(this.ag().g());
      this.x.e(this.ag().m());
      this.x.f(this.ag().n());
      this.x.j(this.ag().q());
      this.x.k(this.ag().p());
      this.x.b(this.ag().j());
      this.x.e(this.ag().i());
      this.w.saveWorldData(this.x, this.I.getPlayerList().t());
      this.z.a();
   }

   public boolean addEntity(Entity var1) {
      UUID var2 = var1.getUniqueId();
      if(this.N.containsKey(var2)) {
         a.warn("Tried to add entity with duplicate UUID " + var2.toString());
         return false;
      } else {
         return super.addEntity(var1);
      }
   }

   public void a(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Entity var3 = (Entity)var2.next();
         UUID var4 = var3.getUniqueId();
         if(this.N.containsKey(var4)) {
            a.warn("Tried to add entity with duplicate UUID " + var4.toString());
         } else {
            this.entityList.add(var3);
            this.b(var3);
         }
      }

   }

   protected void b(Entity var1) {
      super.b(var1);
      this.entitiesById.a(var1.getId(), var1);
      this.N.put(var1.getUniqueId(), var1);
      Entity[] var2 = var1.aD();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.entitiesById.a(var2[var3].getId(), var2[var3]);
         }
      }

   }

   protected void c(Entity var1) {
      super.c(var1);
      this.entitiesById.d(var1.getId());
      this.N.remove(var1.getUniqueId());
      Entity[] var2 = var1.aD();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.entitiesById.d(var2[var3].getId());
         }
      }

   }

   public boolean d(Entity var1) {
      if(super.d(var1)) {
         this.I.getPlayerList().a(var1.locX, var1.locY, var1.locZ, 512.0D, this.worldProvider.p().a(), new PacketPlayOutSpawnEntityWeather(var1));
         return true;
      } else {
         return false;
      }
   }

   public void a(Entity var1, byte var2) {
      this.t().b(var1, new PacketPlayOutEntityStatus(var1, var2));
   }

   public Explosion createExplosion(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      Explosion var11 = new Explosion(this, var1, var2, var4, var6, var8, var9, var10);
      var11.doStage1();
      var11.doStage2(false);
      if(!var10) {
         var11.clearBlocks();
      }

      Iterator var12 = this.players.iterator();

      while(var12.hasNext()) {
         EntityHuman var13 = (EntityHuman)var12.next();
         if(var13.e(var2, var4, var6) < 4096.0D) {
            ((EntityPlayer)var13).playerConnection.sendPacket((Packet)(new PacketPlayOutExplosion(var2, var4, var6, var8, var11.getBlocks(), (Vec3D)var11.getAffectedPlayers().get(var13))));
         }
      }

      return var11;
   }

   public void playBlockAction(BlockPosition var1, Block var2, int var3, int var4) {
      class_aef var5 = new class_aef(var1, var2, var3, var4);
      Iterator var6 = this.S[this.T].iterator();

      class_aef var7;
      do {
         if(!var6.hasNext()) {
            this.S[this.T].add(var5);
            return;
         }

         var7 = (class_aef)var6.next();
      } while(!var7.equals(var5));

   }

   private void ak() {
      while(!this.S[this.T].isEmpty()) {
         int var1 = this.T;
         this.T ^= 1;
         Iterator var2 = this.S[var1].iterator();

         while(var2.hasNext()) {
            class_aef var3 = (class_aef)var2.next();
            if(this.a(var3)) {
               this.I.getPlayerList().a((double)var3.a().getX(), (double)var3.a().getY(), (double)var3.a().getZ(), 64.0D, this.worldProvider.p().a(), new PacketPlayOutBlockAction(var3.a(), var3.d(), var3.b(), var3.c()));
            }
         }

         this.S[var1].clear();
      }

   }

   private boolean a(class_aef var1) {
      IBlockData var2 = this.getType(var1.a());
      return var2.getBlock() == var1.d()?var2.getBlock().a(this, var1.a(), var2, var1.b(), var1.c()):false;
   }

   public void p() {
      this.w.a();
   }

   protected void q() {
      boolean var1 = this.T();
      super.q();
      if(this.o != this.p) {
         this.I.getPlayerList().a((Packet)(new PacketPlayOutGameStateChange(7, this.p)), this.worldProvider.p().a());
      }

      if(this.q != this.r) {
         this.I.getPlayerList().a((Packet)(new PacketPlayOutGameStateChange(8, this.r)), this.worldProvider.p().a());
      }

      if(var1 != this.T()) {
         if(var1) {
            this.I.getPlayerList().a((Packet)(new PacketPlayOutGameStateChange(2, 0.0F)));
         } else {
            this.I.getPlayerList().a((Packet)(new PacketPlayOutGameStateChange(1, 0.0F)));
         }

         this.I.getPlayerList().a((Packet)(new PacketPlayOutGameStateChange(7, this.p)));
         this.I.getPlayerList().a((Packet)(new PacketPlayOutGameStateChange(8, this.r)));
      }

   }

   protected int r() {
      return this.I.getPlayerList().getViewDistance();
   }

   public MinecraftServer s() {
      return this.I;
   }

   public class_lb t() {
      return this.J;
   }

   public class_ld u() {
      return this.K;
   }

   public class_aev v() {
      return this.Q;
   }

   public void a(EnumParticle var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int... var17) {
      this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
   }

   public void a(EnumParticle var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int... var18) {
      PacketPlayOutWorldParticles var19 = new PacketPlayOutWorldParticles(var1, var2, (float)var3, (float)var5, (float)var7, (float)var10, (float)var12, (float)var14, (float)var16, var9, var18);

      for(int var20 = 0; var20 < this.players.size(); ++var20) {
         EntityPlayer var21 = (EntityPlayer)this.players.get(var20);
         BlockPosition var22 = var21.c();
         double var23 = var22.distanceSquared(var3, var5, var7);
         if(var23 <= 256.0D || var2 && var23 <= 65536.0D) {
            var21.playerConnection.sendPacket((Packet)var19);
         }
      }

   }

   public Entity getEntityByUUID(UUID var1) {
      return (Entity)this.N.get(var1);
   }

   public ListenableFuture a(Runnable var1) {
      return this.I.a(var1);
   }

   public boolean isMainThread() {
      return this.I.isMainThread();
   }

   static {
      U = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.STICK, 0, 1, 3, 10), new class_od(Item.getItemOf(Blocks.PLANKS), 0, 1, 3, 10), new class_od(Item.getItemOf(Blocks.LOG), 0, 1, 3, 10), new class_od(Items.STONE_AXE, 0, 1, 1, 3), new class_od(Items.WOODEN_AXE, 0, 1, 1, 5), new class_od(Items.STONE_PICKAXE, 0, 1, 1, 3), new class_od(Items.WOODEN_PICKAXE, 0, 1, 1, 5), new class_od(Items.APPLE, 0, 2, 3, 5), new class_od(Items.BREAD, 0, 2, 3, 3), new class_od(Item.getItemOf(Blocks.LOG2), 0, 1, 3, 10)}));
   }

   static class class_a_in_class_lg extends ArrayList {
      private class_a_in_class_lg() {
      }

      // $FF: synthetic method
      class_a_in_class_lg(Object var1) {
         this();
      }
   }
}
