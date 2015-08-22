package net.minecraft.server;

import com.google.common.base.Predicate;

public interface class_xx extends class_qw {
	Predicate d = new Predicate() {
		public boolean a(Entity var1) {
			return var1 instanceof class_xx;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return a((Entity) var1);
		}
	};
	Predicate e = new Predicate() {
		public boolean a(Entity var1) {
			return (var1 instanceof class_xx) && !var1.aD();
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return a((Entity) var1);
		}
	};
}
