package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_n;
import net.minecraft.server.Entity;

public interface class_m {
   String getName();

   IChatBaseComponent getScoreboardDisplayName();

   void a(IChatBaseComponent var1);

   boolean a(int var1, String var2);

   BlockPosition c();

   Vec3D d();

   World e();

   Entity f();

   boolean u_();

   void a(class_n.class_a_in_class_n var1, int var2);
}
