# 1. Checked exception vs. unchecked exception

Checked: haven’t run the code yet, but has compile error that can be fixed

- IOException (fileNotFound,)
- SQLException(id does not exist, data does not exist)

Unchecked: error during running  (NPE, IndexOutOfBound)


##### 2. There can be multiple catch blocks, but can have only one finally block or no finally block.

##### 3. Final result will be the finally return values

##### 4. Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.

##### 5. The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.

# 7. Java 8 new features:
- Permanent Generation.
- Parallel Array Sorting.
- Base64 encoding and decoding.
- Date & Time API.
- Functional Interfaces.
- Lambda expressions.

# 8. Design pattern
- Singleton
- Factory
- abstract
- Etc

# 9. SOLID principle:
- S - Single-responsiblity Principle
- O - Open-closed Principle
- L - Liskov Substitution Principle
- I - Interface Segregation Principle
- D - Dependency Inversion Principle

# 10. Thread-safe singleton patterns:
- Method1:
Map<String, String> map = new ConcurrentHashMap<>();

- Method2:
Map unsafeMap = new HashMap();

2 Map threadSafeMap = Collections.synchronizedMap(unsafeMap);

# 11. 
The Open/Closed Principle states that software entities (classes, modules, etc.) should be open for extension, but closed for modification

That means any class or module should be written in a way that it can be used as is, can be extended, but neve modified

# 12.
1
