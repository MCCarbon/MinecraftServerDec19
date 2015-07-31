package net.minecraft.server;

import com.google.common.collect.Multimap;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_wl;
import net.minecraft.server.CreativeTab;

public class class_zv extends Item {
   private Set c;
   protected float a = 4.0F;
   private float d;
   protected Item.class_a_in_class_aar b;

   protected class_zv(float var1, Item.class_a_in_class_aar var2, Set var3) {
      this.b = var2;
      this.c = var3;
      this.h = 1;
      this.e(var2.a());
      this.a = var2.b();
      this.d = var1 + var2.c();
      this.a(CreativeTab.i);
   }

   public float a(ItemStack var1, Block var2) {
      return this.c.contains(var2)?this.a:1.0F;
   }

   public boolean a(ItemStack var1, class_qa var2, class_qa var3) {
      var1.a(2, (class_qa)var3);
      return true;
   }

   public boolean a(ItemStack var1, World var2, Block var3, BlockPosition var4, class_qa var5) {
      if((double)var3.getStrength(var2, var4) != 0.0D) {
         var1.a(1, (class_qa)var5);
      }

      return true;
   }

   public Item.class_a_in_class_aar g() {
      return this.b;
   }

   public int c() {
      return this.b.e();
   }

   public String h() {
      return this.b.toString();
   }

   public boolean a(ItemStack var1, ItemStack var2) {
      return this.b.f() == var2.getItem()?true:super.a(var1, var2);
   }

   public Multimap a(class_pw var1) {
      Multimap var2 = super.a(var1);
      if(var1 == class_pw.a) {
         var2.put(class_wl.e.a(), new class_qm(uuid, "Tool modifier", (double)this.d, 0));
      }

      return var2;
   }
}
