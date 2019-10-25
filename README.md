# Snippet

snippet codes

## List

### JAVA

1. Specification
reference with [WIKI](https://en.wikipedia.org/wiki/Specification_pattern)

* usage
```java
// JUNIT_TEST
@Test
test() {
  TestAggregateRoot mock = new TestAggregateRoot();
  mock.setFlag("a");
  mock.setFlag("b");
  mock.setFlag("c");
  Specification<TestAggregateRoot> hasA = Specification.of(a -> a.hasFlag("a"));
  Specification<TestAggregateRoot> hasB = Specification.of(a -> a.hasFlag("b"));
  Specification<TestAggregateRoot> hasC = Specification.of(a -> a.hasFlag("c"));
  Specification<TestAggregateRoot> hasD = Specification.of(a -> a.hasFlag("d"));

  Assertions.assertTrue(hasA.and(hasB).and(hasC).isSatisfiedBy(mock), "Test operator and");
  Assertions.assertFalse(hasA.and(hasB).and(hasC).and(hasD).isSatisfiedBy(mock),
    "Test operator and");
  Assertions.assertTrue(hasA.andNot(hasD).isSatisfiedBy(mock),
    "Test operator andNot");
  Assertions.assertTrue(hasD.not().isSatisfiedBy(mock), "Test operator not ");
  Assertions.assertTrue(hasA.or(hasD).isSatisfiedBy(mock), "Test operator or");
  Assertions.assertTrue(hasA.and(hasD).or(hasB).isSatisfiedBy(mock), "Test operators and, or");
  Assertions.assertTrue(hasA.and(hasD).or(hasB).isSatisfiedBy(mock), "Test operators and, or");
}
```
