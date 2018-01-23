# Unit convert

A java library which convert an unit to another one. Unit converter can convert temperatures, length, mass.

## Basic usage

Unit converter is very easy to use.
```java
Converter converter = new Converter();
Kelvin result = converter.convert(new Celsius(4.4)).to(Kelvin.class);
System.out.println(result.getValue());
```

That's all :)