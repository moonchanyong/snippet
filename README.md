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

### JS

1. MatchBuilder

```ts
const CASE_A = 'caseA'
const CASE_B = 'caseB'
const CASE_C = 'caseC'

// when not use MatchBuilder
const someSwitch = (key, ...args) => {
  switch(key) {
    case CASE_A:
      return `it's ${key} and args are ${...args}`
    case CASE_B:
      return `it's ${key} and args are ${...args}`
    case CASE_C:
      return `it's ${key} and args are ${...args}`
    default:
      return `it's default`;
  }
}

someSwitch(CASE_A, 1, 2, 3); // each case logic has low reusability

// when use MatchBuilder
import MatchBuilder from '{your}/{local}/{path}/util.ts'

const matcher = new MatchBuilder()
  .route(CASE_A, (key, ...args) => `it's ${key} and args are ${...args}`)
  .route(CASE_B, (key, ...args) => `it's ${key} and args are ${...args}`)
  .route(CASE_C, (key, ...args) => `it's ${key} and args are ${...args}`)
  .default(() => `it's default`)
  .build();

console.log(matcher(CASE_A, 1, 2, 3)); // `it's caseA and args are 1,2,3`
console.log(matcher(CASE_B, 'a', 'b', 'c')); // `it's caseB and args are a,b,c`
console.log(matcher(CASE_C)); // `it's caseC and args are a,b,c`
console.log(matcher('any key')); // `it's default`



```