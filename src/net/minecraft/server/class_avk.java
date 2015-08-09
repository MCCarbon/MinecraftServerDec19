package net.minecraft.server;

import net.minecraft.server.GameRules;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.WorldType;
import net.minecraft.server.class_aoz;
import net.minecraft.server.WorldData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_om;

public class class_avk extends WorldData {
   private final WorldData b;

   public class_avk(WorldData var1) {
      this.b = var1;
   }

   public NBTTagCompound a() {
      return this.b.a();
   }

   public NBTTagCompound a(NBTTagCompound var1) {
      return this.b.a(var1);
   }

   public long b() {
      return this.b.b();
   }

   public int c() {
      return this.b.c();
   }

   public int d() {
      return this.b.d();
   }

   public int e() {
      return this.b.e();
   }

   public long f() {
      return this.b.f();
   }

   public long g() {
      return this.b.g();
   }

   public NBTTagCompound i() {
      return this.b.i();
   }

   public String k() {
      return this.b.k();
   }

   public int l() {
      return this.b.l();
   }

   public boolean n() {
      return this.b.n();
   }

   public int o() {
      return this.b.o();
   }

   public boolean p() {
      return this.b.p();
   }

   public int q() {
      return this.b.q();
   }

   public WorldSettings.EnumGameMode r() {
      return this.b.r();
   }

   public void b(long var1) {
   }

   public void c(long var1) {
   }

   public void a(BlockPosition var1) {
   }

   public void a(String var1) {
   }

   public void e(int var1) {
   }

   public void a(boolean var1) {
   }

   public void f(int var1) {
   }

   public void b(boolean var1) {
   }

   public void g(int var1) {
   }

   public boolean s() {
      return this.b.s();
   }

   public boolean t() {
      return this.b.t();
   }

   public WorldType u() {
      return this.b.u();
   }

   public void a(WorldType var1) {
   }

   public boolean v() {
      return this.b.v();
   }

   public void c(boolean var1) {
   }

   public boolean w() {
      return this.b.w();
   }

   public void d(boolean var1) {
   }

   public GameRules x() {
      return this.b.x();
   }

   public class_om y() {
      return this.b.y();
   }

   public void a(class_om var1) {
   }

   public boolean z() {
      return this.b.z();
   }

   public void e(boolean var1) {
   }

   public void a(class_aoz var1, NBTTagCompound var2) {
      this.b.a(var1, var2);
   }

   public NBTTagCompound a(class_aoz var1) {
      return this.b.a(var1);
   }
}
