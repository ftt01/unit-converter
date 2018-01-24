# Unit convert

A java library which convert an unit to another one. Unit converter can convert temperatures, length, mass.

## Basic usage

Unit converter is very easy to use.
```java
import com.github.sitrka.realconvert.Converter;
import com.github.sitrka.unit.temperature.Kelvin;
import com.github.sitrka.unit.temperature.Celsius;

public class ConversionTest {
  public static void main(String args[]) {
    Converter converter = new Converter();
    Kelvin result = converter.convert(new Celcius(4)).to(Kelvin.class);
    System.out.println(result.getValue()); // 274.15
  }  
}
```

That's all :)

## API
* Convert
  * _*Converter()*_ - Create new converter.
  * _*convert(Unit source)*_ -

## Supported conversion

* Temperature
  * Celsius
  * Kelvin
  * Fahrenheit
* Length
  * Metre
  * Inch