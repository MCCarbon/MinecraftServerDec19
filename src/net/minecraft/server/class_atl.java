package net.minecraft.server;

public class class_atl {
   public static final class_atl[] a = new class_atl[64];
   public static final class_atl b = new class_atl(0, 0);
   public static final class_atl c = new class_atl(1, 8368696);
   public static final class_atl d = new class_atl(2, 16247203);
   public static final class_atl e = new class_atl(3, 13092807);
   public static final class_atl f = new class_atl(4, 16711680);
   public static final class_atl g = new class_atl(5, 10526975);
   public static final class_atl h = new class_atl(6, 10987431);
   public static final class_atl i = new class_atl(7, 31744);
   public static final class_atl j = new class_atl(8, 16777215);
   public static final class_atl k = new class_atl(9, 10791096);
   public static final class_atl l = new class_atl(10, 9923917);
   public static final class_atl m = new class_atl(11, 7368816);
   public static final class_atl n = new class_atl(12, 4210943);
   public static final class_atl o = new class_atl(13, 9402184);
   public static final class_atl p = new class_atl(14, 16776437);
   public static final class_atl q = new class_atl(15, 14188339);
   public static final class_atl r = new class_atl(16, 11685080);
   public static final class_atl s = new class_atl(17, 6724056);
   public static final class_atl t = new class_atl(18, 15066419);
   public static final class_atl u = new class_atl(19, 8375321);
   public static final class_atl v = new class_atl(20, 15892389);
   public static final class_atl w = new class_atl(21, 5000268);
   public static final class_atl x = new class_atl(22, 10066329);
   public static final class_atl y = new class_atl(23, 5013401);
   public static final class_atl z = new class_atl(24, 8339378);
   public static final class_atl A = new class_atl(25, 3361970);
   public static final class_atl B = new class_atl(26, 6704179);
   public static final class_atl C = new class_atl(27, 6717235);
   public static final class_atl D = new class_atl(28, 10040115);
   public static final class_atl E = new class_atl(29, 1644825);
   public static final class_atl F = new class_atl(30, 16445005);
   public static final class_atl G = new class_atl(31, 6085589);
   public static final class_atl H = new class_atl(32, 4882687);
   public static final class_atl I = new class_atl(33, '\ud93a');
   public static final class_atl J = new class_atl(34, 8476209);
   public static final class_atl K = new class_atl(35, 7340544);
   public final int L;
   public final int M;

   private class_atl(int var1, int var2) {
      if(var1 >= 0 && var1 <= 63) {
         this.M = var1;
         this.L = var2;
         a[var1] = this;
      } else {
         throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
      }
   }
}
