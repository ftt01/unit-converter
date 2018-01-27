# Unit convert

A java library that converts one unit to another. It can convert temperatures, masses, lengths and much more.

## Getting started

### using gradle
Add these line to your gradle.build dependencies
```kotlin
repositories {
    ...
    maven {
        url 'https://oss.sonatype.org/content/repositories/snapshots/'
    }
}

dependencies {
    compile group: 'com.github.sitrakary',  name:'unit-converter', version:'1.0'
    ...
}

```

## Basic usage

Unit converter is very easy to use.
```java
import com.github.sitrakary.unitconverter.Converter;
import com.github.sitrakary.unitconverter.unit.temperature.Kelvin;
import com.github.sitrakary.unitconverter.unit.temperature.Celsius;

public class ConversionTest {
  public static void main(String args[]) {
    Converter converter = new Converter();
    Kelvin result = converter.convert(new Celcius(4)).to(Kelvin.class);
    System.out.println(result.getValue()); // 274.15
  }  
}
```

That's all :v:

## API
* Convert
  * _*Converter()*_ - Create new converter.
  * _*convert(Unit source)*_ -

## Supported conversion

* Temperature
  * Celsius :heavy_check_mark:
  * Kelvin :heavy_check_mark:
  * Fahrenheit :heavy_check_mark:
* Length
  * Kilometre
  * Metre :heavy_check_mark:
  * Centimetre
  * Millimetre
  * Micrometre
  * Nanometre
  * Mile :heavy_check_mark:
  * Yard
  * Foot
  * Inch :heavy_check_mark:
  * Nautical inch
* Mass
  * Tonne
  * Kilogram
  * Gram
  * Milligram
  * Microgram
  * Imperial ton
  * US ton
  * Stone
  * Pound
  * Ounce
* Digital storage
  * Bit
  * Kilobit
  * Kibibit
  * Megabit
  * Mebibit
  * Gigabit
  * Gibibit
  * Terabit
  * Tebibit
  * Petabit
  * Pebibit
  * Byte
  * KiloByte
  * Kibibyte
  * Megabyte
  * Mebibyte
  * Gigabyte
  * Gibibyte
  * Terabyte
  * Tebibyte
  * Petabyte
  * Pebibyte
  
## License
This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/sitrakary/unit-converter/blob/master/LICENSE.md) file for details