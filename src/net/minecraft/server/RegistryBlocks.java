package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.RegistryMaterials;
import org.apache.commons.lang3.Validate;

public class RegistryBlocks<K, V> extends RegistryMaterials<K, V> {

	private final K key;
	private V def;

	public RegistryBlocks(K type) {
		this.key = type;
	}

	public void register(int var1, K var2, V var3) {
		if (this.key.equals(var2)) {
			this.def = var3;
		}

		super.register(var1, var2, var3);
	}

	public void checkValid() {
		Validate.notNull(this.key);
	}

	public int getId(V value) {
		int id = super.getId(value);
		return id == -1 ? super.getId(this.def) : id;
	}

	public K getKey(V value) {
		K key = super.getKey(value);
		return key == null ? this.key : key;
	}

	public V get(K key) {
		V value = super.get(key);
		return value == null ? this.def : value;
	}

	public V get(int id) {
		V value = super.get(id);
		return value == null ? this.def : value;
	}

	public V get(Random random) {
		V var2 = super.get(random);
		return var2 == null ? this.def : var2;
	}

}
