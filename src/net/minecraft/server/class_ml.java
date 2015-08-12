package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.CommandObjectiveExecutor;
import net.minecraft.server.Entity;

public class class_ml implements ICommandListener {
   private static final class_ml a = new class_ml();
   private StringBuffer b = new StringBuffer();

   public static class_ml h() {
      return a;
   }

   public void i() {
      this.b.setLength(0);
   }

   public String j() {
      return this.b.toString();
   }

   public String getName() {
      return "Rcon";
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public void sendMessage(IChatBaseComponent var1) {
      this.b.append(var1.c());
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public BlockPosition c() {
      return new BlockPosition(0, 0, 0);
   }

   public Vec3D d() {
      return new Vec3D(0.0D, 0.0D, 0.0D);
   }

   public World e() {
      return MinecraftServer.getServer().e();
   }

   public Entity f() {
      return null;
   }

   public boolean u_() {
      return true;
   }

   public void a(CommandObjectiveExecutor.class_a_in_class_n var1, int var2) {
   }
}
