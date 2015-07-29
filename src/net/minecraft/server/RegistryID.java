package net.minecraft.server;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Registry;

public class RegistryID<V> implements Registry<V> {

	private final IdentityHashMap<V, Integer> registryVK = new IdentityHashMap<V, Integer>(512);
	private final List<V> registryKV = Lists.newArrayList();

	public void regiter(V value, int id) {
		this.registryVK.put(value, Integer.valueOf(id));

		while (this.registryKV.size() <= id) {
			this.registryKV.add(null);
		}

		this.registryKV.set(id, value);
	}

	public int getId(V value) {
		Integer id = this.registryVK.get(value);
		return id == null ? -1 : id.intValue();
	}

	public final V get(int id) {
		return id >= 0 && id < this.registryKV.size() ? this.registryKV.get(id) : null;
	}

	public Iterator<V> iterator() {
		return Iterators.filter(this.registryKV.iterator(), Predicates.notNull());
	}

}
