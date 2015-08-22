package net.minecraft.server;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class class_jt implements class_ff {
	private static final Gson a = (new GsonBuilder()).registerTypeAdapter(class_ju.class_c_in_class_ju.class, new class_ju.class_c_in_class_ju.class_c_in_class_ju$class_a_in_class_c_in_class_ju()).registerTypeAdapter(class_ju.class_a_in_class_ju.class, new class_ju.class_a_in_class_ju.class_a_in_class_ju$class_a_in_class_a_in_class_ju()).registerTypeAdapter(class_ju.class, new class_ju.class_b_in_class_ju()).registerTypeHierarchyAdapter(class_eu.class, new class_eu.class_a_in_class_eu())
			.registerTypeHierarchyAdapter(class_ez.class, new class_ez.class_a_in_class_ez()).registerTypeAdapterFactory(new class_nz()).create();
	private class_ju b;

	public class_jt() {
	}

	public class_jt(class_ju var1) {
		b = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		b = (class_ju) class_nq.a(a, var1.c(32767), class_ju.class);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a.toJson(b));
	}

	public void a(class_jr var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_jr) var1);
	}
}
