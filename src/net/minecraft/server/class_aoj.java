package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aet;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;

public class class_aoj extends class_aok {
   public class_aoj(class_aen var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public boolean a(int var1, int var2) {
      return var1 == this.a && var2 == this.b;
   }

   public int b(int var1, int var2) {
      return 0;
   }

   public void b() {
   }

   public class_agj a(class_cj var1) {
      return class_agk.a;
   }

   public int b(class_cj var1) {
      return 255;
   }

   public int c(class_cj var1) {
      return 0;
   }

   public int a(class_aet var1, class_cj var2) {
      return var1.c;
   }

   public void a(class_aet var1, class_cj var2, int var3) {
   }

   public int a(class_cj var1, int var2) {
      return 0;
   }

   public void a(class_pr var1) {
   }

   public void b(class_pr var1) {
   }

   public void a(class_pr var1, int var2) {
   }

   public boolean d(class_cj var1) {
      return false;
   }

   public class_amg a(class_cj var1, class_aok.class_a_in_class_aok var2) {
      return null;
   }

   public void a(class_amg var1) {
   }

   public void a(class_cj var1, class_amg var2) {
   }

   public void e(class_cj var1) {
   }

   public void c() {
   }

   public void d() {
   }

   public void e() {
   }

   public void a(class_pr var1, class_awf var2, List var3, Predicate var4) {
   }

   public void a(Class var1, class_awf var2, List var3, Predicate var4) {
   }

   public boolean a(boolean var1) {
      return false;
   }

   public Random a(long var1) {
      return new Random(this.p().K() + (long)(this.a * this.a * 4987142) + (long)(this.a * 5947611) + (long)(this.b * this.b) * 4392871L + (long)(this.b * 389711) ^ var1);
   }

   public boolean f() {
      return true;
   }

   public boolean c(int var1, int var2) {
      return true;
   }
}
