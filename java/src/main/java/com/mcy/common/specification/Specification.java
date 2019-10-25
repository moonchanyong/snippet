package com.naver.ncp.delivery.specification;

import java.util.function.Function;

// TODO: Support Short circuit among oparators
abstract class Specification<T> {
	boolean isSatisfiedBy(T other) {
		return false;
	}

	Specification<T> and(Specification<T> other) {
		return of(candidate-> isSatisfiedBy(candidate) && other.isSatisfiedBy(candidate));
	}

	Specification<T> andNot(Specification<T> other) {
		return of(candidate-> isSatisfiedBy(candidate) && !other.isSatisfiedBy(candidate));
	}

	Specification<T> or(Specification<T> other) {
		return of(candidate-> isSatisfiedBy(candidate) || other.isSatisfiedBy(candidate));
	}

	// flase flase
	Specification<T> orNot(Specification<T> other) {
		return of(candidate-> !(isSatisfiedBy(candidate) || other.isSatisfiedBy(candidate)));
	}

	Specification<T> not() {
		return of(candidate -> !isSatisfiedBy(candidate));
	}

	Specification<T> xor(Specification<T> other) {
		return of(candidate -> isSatisfiedBy(candidate) ^ other.isSatisfiedBy(candidate));
	}

	public static<V> Specification<V> of(
		Function<V, Boolean> predicate) {
		return new Specification<V>() {
			@Override
			public boolean isSatisfiedBy(V candidate) {
				return predicate.apply(candidate);
			}
		};
	}
}
