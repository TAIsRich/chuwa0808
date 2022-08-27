### Annotions

```
@componnent
The @Component annotation is the most common method of defining beans.

@Component
public class Vehicle {
}

@Autowired
The @Autowired annotation tells Spring to find and inject a collaborating bean into another. If more than one bean of the same type is available, Spring throws an error. In the following scenario, two beans of type Operator are detected by Spring:

@Component
class Arithmetic(){
@Autowired
private Operator operator;
//...
}
@Component
class Addition implements Operator {
}
@Component
class Subtraction implements Operator {
}
```

