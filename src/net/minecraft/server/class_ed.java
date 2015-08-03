package net.minecraft.server;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import net.minecraft.server.NBTTagByte;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagDouble;
import net.minecraft.server.NBTTagFloat;
import net.minecraft.server.NBTTagIntArray;
import net.minecraft.server.NBTTagInt;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTagLong;
import net.minecraft.server.NBTTagShort;
import net.minecraft.server.NBTTagString;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_ec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ed {
   private static final Logger a = LogManager.getLogger();
   private static final Pattern b = Pattern.compile("\\[[-+\\d|,\\s]+\\]");

   public static NBTTagCompound a(String var0) throws class_ec {
      var0 = var0.trim();
      if(!var0.startsWith("{")) {
         throw new class_ec("Invalid tag encountered, expected \'{\' WOODEN_DOOR first char.");
      } else if(b(var0) != 1) {
         throw new class_ec("Encountered multiple top tags, only one expected");
      } else {
         return (NBTTagCompound)a("tag", var0).a();
      }
   }

   static int b(String var0) throws class_ec {
      int var1 = 0;
      boolean var2 = false;
      Stack var3 = new Stack();

      for(int var4 = 0; var4 < var0.length(); ++var4) {
         char var5 = var0.charAt(var4);
         if(var5 == 34) {
            if(b(var0, var4)) {
               if(!var2) {
                  throw new class_ec("Illegal use of \\\": " + var0);
               }
            } else {
               var2 = !var2;
            }
         } else if(!var2) {
            if(var5 != 123 && var5 != 91) {
               if(var5 == 125 && (var3.isEmpty() || ((Character)var3.pop()).charValue() != 123)) {
                  throw new class_ec("Unbalanced curly brackets {}: " + var0);
               }

               if(var5 == 93 && (var3.isEmpty() || ((Character)var3.pop()).charValue() != 91)) {
                  throw new class_ec("Unbalanced square brackets []: " + var0);
               }
            } else {
               if(var3.isEmpty()) {
                  ++var1;
               }

               var3.push(Character.valueOf(var5));
            }
         }
      }

      if(var2) {
         throw new class_ec("Unbalanced quotation: " + var0);
      } else if(!var3.isEmpty()) {
         throw new class_ec("Unbalanced brackets: " + var0);
      } else {
         if(var1 == 0 && !var0.isEmpty()) {
            var1 = 1;
         }

         return var1;
      }
   }

   static class_ed.class_a_in_class_ed a(String... var0) throws class_ec {
      return a(var0[0], var0[1]);
   }

   static class_ed.class_a_in_class_ed a(String var0, String var1) throws class_ec {
      var1 = var1.trim();
      String var3;
      boolean var4;
      char var6;
      if(var1.startsWith("{")) {
         var1 = var1.substring(1, var1.length() - 1);

         class_ed.class_b_in_class_ed var5;
         for(var5 = new class_ed.class_b_in_class_ed(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
            var3 = b(var1, true);
            if(var3.length() > 0) {
               var4 = false;
               var5.b.add(a(var3, var4));
            }

            if(var1.length() < var3.length() + 1) {
               break;
            }

            var6 = var1.charAt(var3.length());
            if(var6 != 44 && var6 != 123 && var6 != 125 && var6 != 91 && var6 != 93) {
               throw new class_ec("Unexpected token \'" + var6 + "\' SPRUCE_DOOR: " + var1.substring(var3.length()));
            }
         }

         return var5;
      } else if(var1.startsWith("[") && !b.matcher(var1).matches()) {
         var1 = var1.substring(1, var1.length() - 1);

         class_ed.class_c_in_class_ed var2;
         for(var2 = new class_ed.class_c_in_class_ed(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
            var3 = b(var1, false);
            if(var3.length() > 0) {
               var4 = true;
               var2.b.add(a(var3, var4));
            }

            if(var1.length() < var3.length() + 1) {
               break;
            }

            var6 = var1.charAt(var3.length());
            if(var6 != 44 && var6 != 123 && var6 != 125 && var6 != 91 && var6 != 93) {
               throw new class_ec("Unexpected token \'" + var6 + "\' SPRUCE_DOOR: " + var1.substring(var3.length()));
            }
         }

         return var2;
      } else {
         return new class_ed.class_d_in_class_ed(var0, var1);
      }
   }

   private static class_ed.class_a_in_class_ed a(String var0, boolean var1) throws class_ec {
      String var2 = c(var0, var1);
      String var3 = d(var0, var1);
      return a(new String[]{var2, var3});
   }

   private static String b(String var0, boolean var1) throws class_ec {
      int var2 = a(var0, ':');
      int var3 = a(var0, ',');
      if(var1) {
         if(var2 == -1) {
            throw new class_ec("Unable to locate name/value separator for string: " + var0);
         }

         if(var3 != -1 && var3 < var2) {
            throw new class_ec("Name error SPRUCE_DOOR: " + var0);
         }
      } else if(var2 == -1 || var2 > var3) {
         var2 = -1;
      }

      return a(var0, var2);
   }

   private static String a(String var0, int var1) throws class_ec {
      Stack var2 = new Stack();
      int var3 = var1 + 1;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;

      for(int var7 = 0; var3 < var0.length(); ++var3) {
         char var8 = var0.charAt(var3);
         if(var8 == 34) {
            if(b(var0, var3)) {
               if(!var4) {
                  throw new class_ec("Illegal use of \\\": " + var0);
               }
            } else {
               var4 = !var4;
               if(var4 && !var6) {
                  var5 = true;
               }

               if(!var4) {
                  var7 = var3;
               }
            }
         } else if(!var4) {
            if(var8 != 123 && var8 != 91) {
               if(var8 == 125 && (var2.isEmpty() || ((Character)var2.pop()).charValue() != 123)) {
                  throw new class_ec("Unbalanced curly brackets {}: " + var0);
               }

               if(var8 == 93 && (var2.isEmpty() || ((Character)var2.pop()).charValue() != 91)) {
                  throw new class_ec("Unbalanced square brackets []: " + var0);
               }

               if(var8 == 44 && var2.isEmpty()) {
                  return var0.substring(0, var3);
               }
            } else {
               var2.push(Character.valueOf(var8));
            }
         }

         if(!Character.isWhitespace(var8)) {
            if(!var4 && var5 && var7 != var3) {
               return var0.substring(0, var7 + 1);
            }

            var6 = true;
         }
      }

      return var0.substring(0, var3);
   }

   private static String c(String var0, boolean var1) throws class_ec {
      if(var1) {
         var0 = var0.trim();
         if(var0.startsWith("{") || var0.startsWith("[")) {
            return "";
         }
      }

      int var2 = a(var0, ':');
      if(var2 == -1) {
         if(var1) {
            return "";
         } else {
            throw new class_ec("Unable to locate name/value separator for string: " + var0);
         }
      } else {
         return var0.substring(0, var2).trim();
      }
   }

   private static String d(String var0, boolean var1) throws class_ec {
      if(var1) {
         var0 = var0.trim();
         if(var0.startsWith("{") || var0.startsWith("[")) {
            return var0;
         }
      }

      int var2 = a(var0, ':');
      if(var2 == -1) {
         if(var1) {
            return var0;
         } else {
            throw new class_ec("Unable to locate name/value separator for string: " + var0);
         }
      } else {
         return var0.substring(var2 + 1).trim();
      }
   }

   private static int a(String var0, char var1) {
      int var2 = 0;

      for(boolean var3 = true; var2 < var0.length(); ++var2) {
         char var4 = var0.charAt(var2);
         if(var4 == 34) {
            if(!b(var0, var2)) {
               var3 = !var3;
            }
         } else if(var3) {
            if(var4 == var1) {
               return var2;
            }

            if(var4 == 123 || var4 == 91) {
               return -1;
            }
         }
      }

      return -1;
   }

   private static boolean b(String var0, int var1) {
      return var1 > 0 && var0.charAt(var1 - 1) == 92 && !b(var0, var1 - 1);
   }

   static class class_d_in_class_ed extends class_ed.class_a_in_class_ed {
      private static final Pattern c = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[d|D]");
      private static final Pattern d = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[f|F]");
      private static final Pattern e = Pattern.compile("[-+]?[0-9]+[b|B]");
      private static final Pattern f = Pattern.compile("[-+]?[0-9]+[l|L]");
      private static final Pattern g = Pattern.compile("[-+]?[0-9]+[s|S]");
      private static final Pattern h = Pattern.compile("[-+]?[0-9]+");
      private static final Pattern i = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
      private static final Splitter j = Splitter.on(',').omitEmptyStrings();
      protected String b;

      public class_d_in_class_ed(String var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      public NBTTag a() throws class_ec {
         try {
            if(c.matcher(this.b).matches()) {
               return new NBTTagDouble(Double.parseDouble(this.b.substring(0, this.b.length() - 1)));
            }

            if(d.matcher(this.b).matches()) {
               return new NBTTagFloat(Float.parseFloat(this.b.substring(0, this.b.length() - 1)));
            }

            if(e.matcher(this.b).matches()) {
               return new NBTTagByte(Byte.parseByte(this.b.substring(0, this.b.length() - 1)));
            }

            if(f.matcher(this.b).matches()) {
               return new NBTTagLong(Long.parseLong(this.b.substring(0, this.b.length() - 1)));
            }

            if(g.matcher(this.b).matches()) {
               return new NBTTagShort(Short.parseShort(this.b.substring(0, this.b.length() - 1)));
            }

            if(h.matcher(this.b).matches()) {
               return new NBTTagInt(Integer.parseInt(this.b));
            }

            if(i.matcher(this.b).matches()) {
               return new NBTTagDouble(Double.parseDouble(this.b));
            }

            if(this.b.equalsIgnoreCase("true") || this.b.equalsIgnoreCase("false")) {
               return new NBTTagByte((byte)(Boolean.parseBoolean(this.b)?1:0));
            }
         } catch (NumberFormatException var6) {
            this.b = this.b.replaceAll("\\\\\"", "\"");
            return new NBTTagString(this.b);
         }

         if(this.b.startsWith("[") && this.b.endsWith("]")) {
            String var7 = this.b.substring(1, this.b.length() - 1);
            String[] var8 = (String[])Iterables.toArray(j.split(var7), String.class);

            try {
               int[] var3 = new int[var8.length];

               for(int var4 = 0; var4 < var8.length; ++var4) {
                  var3[var4] = Integer.parseInt(var8[var4].trim());
               }

               return new NBTTagIntArray(var3);
            } catch (NumberFormatException var5) {
               return new NBTTagString(this.b);
            }
         } else {
            if(this.b.startsWith("\"") && this.b.endsWith("\"")) {
               this.b = this.b.substring(1, this.b.length() - 1);
            }

            this.b = this.b.replaceAll("\\\\\"", "\"");
            StringBuilder var1 = new StringBuilder();

            for(int var2 = 0; var2 < this.b.length(); ++var2) {
               if(var2 < this.b.length() - 1 && this.b.charAt(var2) == 92 && this.b.charAt(var2 + 1) == 92) {
                  var1.append('\\');
                  ++var2;
               } else {
                  var1.append(this.b.charAt(var2));
               }
            }

            return new NBTTagString(var1.toString());
         }
      }
   }

   static class class_c_in_class_ed extends class_ed.class_a_in_class_ed {
      protected List b = Lists.newArrayList();

      public class_c_in_class_ed(String var1) {
         this.a = var1;
      }

      public NBTTag a() throws class_ec {
         NBTTagList var1 = new NBTTagList();
         Iterator var2 = this.b.iterator();

         while(var2.hasNext()) {
            class_ed.class_a_in_class_ed var3 = (class_ed.class_a_in_class_ed)var2.next();
            var1.add(var3.a());
         }

         return var1;
      }
   }

   static class class_b_in_class_ed extends class_ed.class_a_in_class_ed {
      protected List b = Lists.newArrayList();

      public class_b_in_class_ed(String var1) {
         this.a = var1;
      }

      public NBTTag a() throws class_ec {
         NBTTagCompound var1 = new NBTTagCompound();
         Iterator var2 = this.b.iterator();

         while(var2.hasNext()) {
            class_ed.class_a_in_class_ed var3 = (class_ed.class_a_in_class_ed)var2.next();
            var1.put(var3.a, var3.a());
         }

         return var1;
      }
   }

   abstract static class class_a_in_class_ed {
      protected String a;

      public abstract NBTTag a() throws class_ec;
   }
}
