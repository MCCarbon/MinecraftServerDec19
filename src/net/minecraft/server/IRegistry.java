package net.minecraft.server;

public interface IRegistry<K, V> extends Iterable<V> {
   void register(K key, V value);
}
