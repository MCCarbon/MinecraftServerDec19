package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.EntityDamageSource;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;

public class EntityDamageSourceIndirect extends EntityDamageSource {
   private Entity r;

   public EntityDamageSourceIndirect(String var1, Entity var2, Entity var3) {
      super(var1, var2);
      this.r = var3;
   }

   public Entity i() {
      return this.q;
   }

   public Entity getEntity() {
      return this.r;
   }

   public IChatBaseComponent b(EntityLiving var1) {
      IChatBaseComponent var2 = this.r == null?this.q.getScoreboardDisplayName():this.r.getScoreboardDisplayName();
      ItemStack var3 = this.r instanceof EntityLiving?((EntityLiving)this.r).bA():null;
      String var4 = "death.attack." + this.p;
      String var5 = var4 + ".item";
      return var3 != null && var3.hasDisplayName() && LocaleI18n.c(var5)?new ChatMessage(var5, new Object[]{var1.getScoreboardDisplayName(), var2, var3.B()}):new ChatMessage(var4, new Object[]{var1.getScoreboardDisplayName(), var2});
   }
}
