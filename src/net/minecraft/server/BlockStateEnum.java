package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

import net.minecraft.server.BlockState;
import net.minecraft.server.INamable;

public class BlockStateEnum<T extends Enum<T>> extends BlockState<T> {

	private final ImmutableSet<T> values;
	private final Map<String, T> valuesByName = Maps.newHashMap();

	protected BlockStateEnum(String name, Class<T> clazz, Collection<T> states) {
		super(name, clazz);
		this.values = ImmutableSet.copyOf(states);

		for (T value : values) {
			String vname = getValueName(value);
			if (valuesByName.containsKey(vname)) {
				throw new IllegalArgumentException("Multiple values have the same name \'" + vname + "\'");
			}

			this.valuesByName.put(vname, value);
		}
	}

	public Collection<T> getValues() {
		return this.values;
	}

	public String getValueName(T value) {
		return ((INamable) value).getName();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof BlockStateEnum && super.equals(obj)) {
			BlockStateEnum<?> other = (BlockStateEnum<?>) obj;
			return this.values.equals(other.values) && this.valuesByName.equals(other.valuesByName);
		} else {
			return false;
		}
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = 31 * hash + this.values.hashCode();
		hash = 31 * hash + this.valuesByName.hashCode();
		return hash;
	}

	public static <T extends Enum<T>> BlockStateEnum<T> of(String name, Class<T> clazz) {
		return of(name, clazz, Predicates.<T>alwaysTrue());
	}

	public static <T extends Enum<T>> BlockStateEnum<T> of(String name, Class<T> clazz, Predicate<T> filter) {
		return of(name, clazz, Collections2.filter(Lists.newArrayList(clazz.getEnumConstants()), filter));
	}

	@SafeVarargs
	public static <T extends Enum<T>> BlockStateEnum<T> of(String name, Class<T> clazz, T... array) {
		return of(name, clazz, Lists.newArrayList(array));
	}

	public static <T extends Enum<T>> BlockStateEnum<T> of(String name, Class<T> clazz, Collection<T> collection) {
		return new BlockStateEnum<T>(name, clazz, collection);
	}

}
