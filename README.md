# Unit convert

A java library which convert an unit to another one. Unit converter can convert temperatures, length, mass.

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
  