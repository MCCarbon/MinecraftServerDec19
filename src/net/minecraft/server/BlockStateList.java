package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.server.Block;
import net.minecraft.server.class_ank;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cm;
import net.minecraft.server.class_cw;

public class BlockStateList {
	private static final Pattern a = Pattern.compile("^[a-z0-9_]+$");
	private static final Function b = new Function() {
		public String a(IBlockState var1) {
			return var1 == null ? "<NULL>" : var1.a();
		}

		// $FF: synthetic method
		public Object apply(Object var1) {
			return this.a((IBlockState) var1);
		}
	};
	private final Block c;
	private final ImmutableSortedMap d;
	private final ImmutableList e;

	public BlockStateList(Block var1, IBlockState... var2) {
		this.c = var1;
		HashMap var3 = Maps.newHashMap();
		IBlockState[] var4 = var2;
		int var5 = var2.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			IBlockState var7 = var4[var6];
			a(var1, var7);
			var3.put(var7.a(), var7);
		}

		this.d = ImmutableSortedMap.copyOf(var3);
		LinkedHashMap var11 = Maps.newLinkedHashMap();
		ArrayList var12 = Lists.newArrayList();
		Iterable var13 = class_cm.a(this.e());
		Iterator var14 = var13.iterator();

		while (var14.hasNext()) {
			List var8 = (List) var14.next();
			Map var9 = class_cw.b(this.d.values(), var8);
			BlockStateList.class_a_in_class_anm var10 = new BlockStateList.class_a_in_class_anm(var1, ImmutableMap.copyOf(var9), null);
			var11.put(var9, var10);
			var12.add(var10);
		}

		var14 = var12.iterator();

		while (var14.hasNext()) {
			BlockStateList.class_a_in_class_anm var15 = (BlockStateList.class_a_in_class_anm) var14.next();
			var15.a(var11);
		}

		this.e = ImmutableList.copyOf((Collection) var12);
	}

	public static String a(Block var0, IBlockState var1) {
		String var2 = var1.a();
		if (!a.matcher(var2).matches()) {
			throw new IllegalArgumentException("Block: " + var0.getClass() + " has invalidly named property: " + var2);
		} else {
			Iterator var3 = var1.c().iterator();

			String var5;
			do {
				if (!var3.hasNext()) {
					return var2;
				}

				Comparable var4 = (Comparable) var3.next();
				var5 = var1.a(var4);
			} while (a.matcher(var5).matches());

			throw new IllegalArgumentException("Block: " + var0.getClass() + " has property: " + var2 + " with invalidly named value: " + var5);
		}
	}

	public ImmutableList a() {
		return this.e;
	}

	private List e() {
		ArrayList var1 = Lists.newArrayList();
		ImmutableCollection var2 = this.d.values();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			IBlockState var4 = (IBlockState) var3.next();
			var1.add(var4.c());
		}

		return var1;
	}

	public IBlockData getFirst() {
		return (IBlockData) this.e.get(0);
	}

	public Block getBlock() {
		return this.c;
	}

	public Collection d() {
		return this.d.values();
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("block", Block.BLOCK_REGISTRY.getKey(this.c)).add("properties", Iterables.transform(this.d.values(), b)).toString();
	}

	static class class_a_in_class_anm extends class_ank {
		private final Block a;
		private final ImmutableMap<IBlockState<?>, Comparable<?>> b;
		private ImmutableTable<IBlockState<?>, Comparable<?>, IBlockData> c;

		private class_a_in_class_anm(Block var1, ImmutableMap<IBlockState<?>, Comparable<?>> var2) {
			this.a = var1;
			this.b = var2;
		}

		public Collection<IBlockState<?>> getStates() {
			return Collections.unmodifiableCollection(this.b.keySet());
		}

		public <T extends Comparable<T>> T get(IBlockState<T> var1) {
			if (!this.b.containsKey(var1)) {
				throw new IllegalArgumentException("Cannot get property " + var1 + " as it does not exist in " + this.a.getBlockStateList());
			} else {
				return var1.b().cast(this.b.get(var1));
			}
		}

		public <T extends Comparable<T>, V extends T> IBlockData set(IBlockState<T> var1, V var2) {
			if (!this.b.containsKey(var1)) {
				throw new IllegalArgumentException("Cannot set property " + var1 + " as it does not exist in " + this.a.getBlockStateList());
			} else if (!var1.c().contains(var2)) {
				throw new IllegalArgumentException("Cannot set property " + var1 + " to " + var2 + " on block " + Block.BLOCK_REGISTRY.getKey(this.a) + ", it is not an allowed value");
			} else {
				return (IBlockData) (this.b.get(var1) == var2 ? this : (IBlockData) this.c.get(var1, var2));
			}
		}

		public ImmutableMap getStatesAndValues() {
			return this.b;
		}

		public Block getBlock() {
			return this.a;
		}

		public boolean equals(Object var1) {
			return this == var1;
		}

		public int hashCode() {
			return this.b.hashCode();
		}

		public void a(Map var1) {
			if (this.c != null) {
				throw new IllegalStateException();
			} else {
				HashBasedTable var2 = HashBasedTable.create();
				Iterator var3 = this.b.keySet().iterator();

				while (var3.hasNext()) {
					IBlockState var4 = (IBlockState) var3.next();
					Iterator var5 = var4.c().iterator();

					while (var5.hasNext()) {
						Comparable var6 = (Comparable) var5.next();
						if (var6 != this.b.get(var4)) {
							var2.put(var4, var6, var1.get(this.b(var4, var6)));
						}
					}
				}

				this.c = ImmutableTable.copyOf(var2);
			}
		}

		private Map b(IBlockState var1, Comparable var2) {
			HashMap var3 = Maps.newHashMap(this.b);
			var3.put(var1, var2);
			return var3;
		}

		// $FF: synthetic method
		class_a_in_class_anm(Block var1, ImmutableMap var2, Object var3) {
			this(var1, var2);
		}
	}
}
