package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.World;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;

public class class_ano {
   private final World a;
   private final BlockPosition b;
   private final boolean c;
   private IBlockData d;
   private TileEntity e;
   private boolean f;

   public class_ano(World var1, BlockPosition var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public IBlockData a() {
      if(this.d == null && (this.c || this.a.isLoaded(this.b))) {
         this.d = this.a.getType(this.b);
      }

      return this.d;
   }

   public TileEntity b() {
      if(this.e == null && !this.f) {
         this.e = this.a.getTileEntity(this.b);
         this.f = true;
      }

      return this.e;
   }

   public BlockPosition d() {
      return this.b;
   }

   public static Predicate a(final Predicate var0) {
      return new Predicate() {
         public boolean a(class_ano var1) {
            return var1 != null && var0.apply(var1.a());
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_ano)var1);
         }
      };
   }
}
