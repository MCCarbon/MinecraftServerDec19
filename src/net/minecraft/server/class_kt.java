package net.minecraft.server;

import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ITickAble;
import net.minecraft.server.EntityPlayer;

public class class_kt extends JList implements ITickAble {
   private MinecraftServer a;
   private int b;

   public class_kt(MinecraftServer var1) {
      this.a = var1;
      var1.a((ITickAble)this);
   }

   public void tick() {
      if(this.b++ % 20 == 0) {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < this.a.getPlayerList().v().size(); ++var2) {
            var1.add(((EntityPlayer)this.a.getPlayerList().v().get(var2)).getName());
         }

         this.setListData(var1);
      }

   }
}
