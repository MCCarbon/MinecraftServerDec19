package net.minecraft.server;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.Registry;
import net.minecraft.server.RegistryID;
import net.minecraft.server.RegistrySimple;

public class RegistryMaterials<K, V> extends RegistrySimple<K, V> implements Registry<V> {

	protected final RegistryID<V> idRegistry = new RegistryID<V>();
	protected final Map<V, K> registrymapVK;

	public RegistryMaterials() {
		this.registrymapVK = ((BiMap<K, V>) this.registryMapKV).inverse();
	}

	public void register(int id, K key, V value) {
		this.idRegistry.regiter(value, id);
		this.register(key, value);
	}

	protected Map<K, V> create() {
		return HashBiMap.create();
	}

	public V get(K key) {
		return super.get(key);
	}

	public K getKey(V value) {
		return this.registrymapVK.get(value);
	}

	public boolean has(K key) {
		return super.has(key);
	}

	public int getId(V value) {
		return this.idRegistry.getId(value);
	}

	public V get(int id) {
		return this.idRegistry.get(id);
	}

	public Iterator<V> iterator() {
		return this.idRegistry.iterator();
	}

}
