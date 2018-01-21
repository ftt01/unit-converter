/*
 * MIT License
 *
 * Copyright (c) 2018 Sitraka Ratsimba
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.strka.realconvert.unit.temperature;

import com.github.strka.realconvert.BigDecimalBuilder;
import com.github.strka.realconvert.unit.Temperature;
import java.math.BigDecimal;

public class Fahrenheit extends Temperature {

  private static final BigDecimal BIG_FIVE = BigDecimalBuilder.getInstance().build(5);
  private static final BigDecimal BIG_NINE = BigDecimalBuilder.getInstance().build(9);
  private static final BigDecimal FAHRENHEIT_CONST = BigDecimalBuilder.getInstance().build(459.67);

  public Fahrenheit(double value) {
    this.name = "fahrenheit";
    this.symbol = "°F";
    this.value = BigDecimalBuilder.getInstance().build(value);
  }

  public Fahrenheit(BigDecimal value) {
    this.name = "fahrenheit";
    this.symbol = "°F";
    this.value = value;
  }

  @Override
  public Kelvin normalize() {
    BigDecimal fiveDividedByNine = BIG_FIVE
        .divide(BIG_NINE, BigDecimalBuilder.getInstance().getMathContext());
    BigDecimal fahrenheitValueAddedConst = this.getValue().add(FAHRENHEIT_CONST);
    BigDecimal kelvinValue = fahrenheitValueAddedConst
        .multiply(fiveDividedByNine, BigDecimalBuilder.getInstance().getMathContext());
    return new Kelvin(kelvinValue);
  }

  @Override
  public Fahrenheit from(Kelvin standardUnit) {
    BigDecimal nineDividedByFive = BIG_NINE
        .divide(BIG_FIVE, BigDecimalBuilder.getInstance().getMathContext());
    BigDecimal kelvinMultipliedByConst = standardUnit.getValue()
        .multiply(nineDividedByFive, BigDecimalBuilder.getInstance().getMathContext());
    BigDecimal fahrenheitValue = kelvinMultipliedByConst.subtract(FAHRENHEIT_CONST);
    return new Fahrenheit(fahrenheitValue);
  }
}
