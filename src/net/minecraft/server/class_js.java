package net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ez;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jq;
import net.minecraft.server.class_jt;
import net.minecraft.server.class_nk;
import net.minecraft.server.class_nt;

public class class_js implements class_ff {
   private static final Gson a = (new GsonBuilder()).registerTypeAdapter(class_jt.class_c_in_class_jt.class, new class_jt.class_c_in_class_jt.class_c_in_class_jt$class_a_in_class_c_in_class_jt()).registerTypeAdapter(class_jt.class_a_in_class_jt.class, new class_jt.class_a_in_class_jt.class_a_in_class_jt$class_a_in_class_a_in_class_jt()).registerTypeAdapter(class_jt.class, new class_jt.class_b_in_class_jt()).registerTypeHierarchyAdapter(class_eu.class, new class_eu.class_a_in_class_eu()).registerTypeHierarchyAdapter(class_ez.class, new class_ez.class_a_in_class_ez()).registerTypeAdapterFactory(new class_nt()).create();
   private class_jt b;

   public class_js() {
   }

   public class_js(class_jt var1) {
      this.b = var1;
   }

   public void a(class_em var1) throws IOException {
      this.b = (class_jt)class_nk.a(a, var1.c(32767), class_jt.class);
   }

   public void b(class_em var1) throws IOException {
      var1.a(a.toJson((Object)this.b));
   }

   public void a(class_jq var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_jq)var1);
   }
}
