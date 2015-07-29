package net.minecraft.server;

import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_lh;

public class class_kt extends JList implements class_kn {
   private MinecraftServer a;
   private int b;

   public class_kt(MinecraftServer var1) {
      this.a = var1;
      var1.a((class_kn)this);
   }

   public void c() {
      if(this.b++ % 20 == 0) {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < this.a.ap().v().size(); ++var2) {
            var1.add(((class_lh)this.a.ap().v().get(var2)).e_());
         }

         this.setListData(var1);
      }

   }
}
