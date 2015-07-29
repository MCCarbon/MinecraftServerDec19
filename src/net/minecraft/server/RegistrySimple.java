package net.minecraft.server;

import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.server.IRegistry;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrySimple<K, V> implements IRegistry<K, V> {

	private static final Logger logger = LogManager.getLogger();

	protected final Map<K, V> registryMapKV = this.create();
	private Object[] allV;

	protected Map<K, V> create() {
		return Maps.newHashMap();
	}

	public V get(K key) {
		return this.registryMapKV.get(key);
	}

	public void register(K key, V value) {
		Validate.notNull(key);
		Validate.notNull(value);
		this.allV = null;
		if (this.registryMapKV.containsKey(key)) {
			logger.debug("Adding duplicate key \'" + key + "\' to registry");
		}

		this.registryMapKV.put(key, value);
	}

	public Set<K> getKeys() {
		return Collections.unmodifiableSet(this.registryMapKV.keySet());
	}

	@SuppressWarnings("unchecked")
	public V get(Random rnd) {
		if (this.allV == null) {
			Collection<V> var2 = this.registryMapKV.values();
			if (var2.isEmpty()) {
				return null;
			}

			this.allV = var2.toArray(new Object[var2.size()]);
		}

		return (V) this.allV[rnd.nextInt(this.allV.length)];
	}

	public boolean has(K key) {
		return this.registryMapKV.containsKey(key);
	}

	public Iterator<V> iterator() {
		return this.registryMapKV.values().iterator();
	}

}
