package net.minecraft.server;

import net.minecraft.server.RegistrySimple;

public class RegistryDefault<K, V> extends RegistrySimple<K, V> {

	private final V defaultValue;

	public RegistryDefault(V var1) {
		this.defaultValue = var1;
	}

	public V get(K key) {
		V value = super.get(key);
		return value == null ? this.defaultValue : value;
	}

}
