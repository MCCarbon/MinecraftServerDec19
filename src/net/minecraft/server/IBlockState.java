package net.minecraft.server;

import java.util.Collection;

public interface IBlockState<T extends Comparable<T>> {

	String getName();

	Collection<T> getValues();

	Class<T> getStateClass();

	String getValueName(T var1);

}
