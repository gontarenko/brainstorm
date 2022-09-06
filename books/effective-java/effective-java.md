```
Progress: 43/413
Next topic - Item 6
```

---

[//]: # (TODO: center Notes)

# *Notes*

## Chapter 2:

### <u>Item 1:</u> Consider static factory methods instead of constructors.

#### Advantages:

- return an object of any subtype of their return type
- not required to create a new object each time they’re invoked
- better naming (method named BigInteger.probablePrime(int, int, Random) most maintainable than Constructor BigInteger(
  int, int, Random))
- In cases where a class seems to require multiple constructors with the same signature, replace the constructors with
  static factory methods and carefully chosen names to highlight their differences
- returned object can vary from call to call as a function of the input parameters
- the class of the returned object need not exist when the class containing the method is written (JDBC -
  DriverManager.registerDriver and DriverManager.getConnection)

#### Disadvantages:

- The main limitation of providing only static factory methods is that classes without public or protected constructors
  cannot be subclassed

```java
class Example {
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
```

#### Common names for static factory methods:

- from — A type-conversion method that takes a single parameter and returns a corresponding instance of this type, for
  example:

```
Date d = Date.from(instant);
```

- of — An aggregation method that takes multiple parameters and returns an instance of this type that incorporates them,
  for example:

```
Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
```

- valueOf — A more verbose alternative to from and of, for example:

```
BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
```

- instance or getInstance—Returns an instance that is described by its parameters (if any) but cannot be said to have
  the same value, for example:

```
StackWalker luke = StackWalker.getInstance(options);
```

- create or newInstance — Like instance or getInstance, except that the method guarantees that each call returns a new
  instance, for example:

```
Object newArray = Array.newInstance(classObject, arrayLen);
```

- getType — Like getInstance, but used if the factory method is in a different class. Type is the type of object
  returned by the factory method, for example:

```
FileStore fs = Files.getFileStore(path);
```

- newType — Like newInstance, but used if the factory method is in a different class. Type is the type of object
  returned by the factory method, for example:

```
BufferedReader br = Files.newBufferedReader(path);
```

- type — A concise alternative to getType and newType, for example:

```
List<Complaint> litany = Collections.list(legacyLitany);
```

### <u>Item 2:</u> Consider a builder when faced with many constructor parameters

- The Builder pattern simulates named optional parameters. [Example](./src/chapter2/NutritionFacts.java)
- The Builder pattern is well suited to class hierarchies. [Example](./src/chapter2/Pizza.java)
- The Builder pattern has disadvantages as well. In order to create an object, you must first create its builder. While
  the cost of creating this builder is unlikely to be noticeable in practice, it could be a problem in
  performance-critical situations.

### <u>Item 3:</u> Enforce the singleton property with a private constructor or an enum type

```java
// Singleton with public final field
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { ...}

    public void leaveTheBuilding() { ...}
}

// Singleton with static factory
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() { ...}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() { ...}
}
```

[//]: # (TODO: add link to Item 89)

- To make a singleton class that uses either of these approaches serializable
  (Chapter 12), it is not sufficient merely to add implements Serializable to its declaration. To maintain the singleton
  guarantee, declare all instance fields transient and provide a readResolve method ([Item 89]()). Otherwise, each time
  a serialized instance is deserialized, a new instance will be created, leading, in the case of our example, to
  spurious Elvis sightings. To prevent this from happening, add this readResolve method to the Elvis class:

```java
public class Elvis {
    // readResolve method to preserve singleton property
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}
```

- This approach is similar to the public field approach, but it is more concise, provides the serialization machinery
  for free, and provides an ironclad guarantee against multiple instantiation, even in the face of sophisticated
  serialization or reflection attacks.

```java
// Enum singleton - the preferred approach
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() { ...}
}
```

### <u>Item 4:</u> Enforce noninstantiability with a private constructor

```java
public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    // static methods...
}
```

### <u>Item 5:</u> Prefer dependency injection to hardwiring resources

<details><summary>Examples</summary>

```java
// Inappropriate use of static utility - inflexible & untestable!
public class SpellChecker {
    private static final Lexicon dictionary = ...;

    private SpellChecker() { ...} // Noninstantiable

    public static boolean isValid(String word) { ...}

    public static List<String> suggestions(String typo) { ...}
}

// Inappropriate use of singleton - inflexible & untestable!
public class SpellChecker {
    private final Lexicon dictionary = ...;

    private SpellChecker(...) { ...}

    public static SpellChecker INSTANCE = new SpellChecker(...);

    public boolean isValid(String word) { ...}

    public List<String> suggestions(String typo) { ...}
}

// Dependency injection provides flexibility and testability
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { ...}

    public List<String> suggestions(String typo) { ...}
}
```

</details>

- A useful variant of the pattern is to pass a resource factory to the constructor. The Supplier<T> interface,
  introduced in Java 8, is perfect for representing factories.
  
```java
Mosaic create(Supplier<? extends Tile> tileFactory) { ... }
```