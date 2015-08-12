package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.WorldType;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldChunkManager;
import net.minecraft.server.WorldChunkManagerHell;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aoe;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.class_aoz;
import net.minecraft.server.ChunkProviderDebug;
import net.minecraft.server.ChunkProviderFlat;
import net.minecraft.server.class_app;
import net.minecraft.server.class_arr;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EntityPlayer;

public abstract class WorldProvider {
   public static final float[] a = new float[]{1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F};
   protected World b;
   private WorldType g;
   private String h;
   protected WorldChunkManager c;
   protected boolean d;
   protected boolean e;
   protected final float[] f = new float[16];
   private final float[] i = new float[4];

   public final void a(World var1) {
      this.b = var1;
      this.g = var1.Q().u();
      this.h = var1.Q().B();
      this.b();
      this.a();
   }

   protected void a() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   protected void b() {
      WorldType var1 = this.b.Q().u();
      if(var1 == WorldType.FLAT) {
         class_arr var2 = class_arr.a(this.b.Q().B());
         this.c = new WorldChunkManagerHell(BiomeBase.getBiome(var2.a(), BiomeBase.ad), 0.5F);
      } else if(var1 == WorldType.DEBUG) {
         this.c = new WorldChunkManagerHell(BiomeBase.PLAINS, 0.0F);
      } else {
         this.c = new WorldChunkManager(this.b);
      }

   }

   public IChunkProvider c() {
      return (IChunkProvider)(this.g == WorldType.FLAT?new ChunkProviderFlat(this.b, this.b.K(), this.b.Q().s(), this.h):(this.g == WorldType.DEBUG?new ChunkProviderDebug(this.b):(this.g == WorldType.CUSTOMIZED?new class_app(this.b, this.b.K(), this.b.Q().s(), this.h):new class_app(this.b, this.b.K(), this.b.Q().s(), this.h))));
   }

   public boolean a(int var1, int var2) {
      return this.b.c(new BlockPosition(var1, 0, var2)) == Blocks.GRASS;
   }

   public float a(long var1, float var3) {
      int var4 = (int)(var1 % 24000L);
      float var5 = ((float)var4 + var3) / 24000.0F - 0.25F;
      if(var5 < 0.0F) {
         ++var5;
      }

      if(var5 > 1.0F) {
         --var5;
      }

      float var6 = var5;
      var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
      var5 = var6 + (var5 - var6) / 3.0F;
      return var5;
   }

   public int a(long var1) {
      return (int)(var1 / 24000L % 8L + 8L) % 8;
   }

   public boolean d() {
      return true;
   }

   public boolean e() {
      return true;
   }

   public BlockPosition h() {
      return null;
   }

   public int i() {
      return this.g == WorldType.FLAT?4:this.b.G() + 1;
   }

   public WorldChunkManager k() {
      return this.c;
   }

   public boolean l() {
      return this.d;
   }

   public boolean m() {
      return this.e;
   }

   public float[] n() {
      return this.f;
   }

   public class_aoe o() {
      return new class_aoe();
   }

   public void a(EntityPlayer var1) {
   }

   public void b(EntityPlayer var1) {
   }

   public abstract class_aoz p();

   public void q() {
   }

   public void r() {
   }

   public boolean c(int var1, int var2) {
      return true;
   }
}
