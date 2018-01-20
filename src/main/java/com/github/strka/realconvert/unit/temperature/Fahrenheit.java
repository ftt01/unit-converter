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

import com.github.strka.realconvert.unit.Temperature;
import com.github.strka.realconvert.util.BigDecimalBuilder;
import java.math.BigDecimal;

public final class Fahrenheit extends Temperature {

  private final static String NAME = "Kelvin";
  private final static String SYMBOL = "K";

  public Fahrenheit() {
    super(Fahrenheit.NAME, Fahrenheit.SYMBOL, 0);
  }

  public Fahrenheit(double value) {
    super(Fahrenheit.NAME, Fahrenheit.SYMBOL, value);
  }

  public Fahrenheit(BigDecimal value) {
    super(Fahrenheit.NAME, Fahrenheit.SYMBOL, value);
  }

  @Override
  public Fahrenheit from(Object k) {
    Kelvin kObject = (Kelvin) k;
    BigDecimal five = new BigDecimalBuilder().build(5);
    BigDecimal nine = new BigDecimalBuilder().build(9);
    BigDecimal nineDividedByFive = nine.divide(five, BigDecimalBuilder.getMathContext());
    BigDecimal fahrenheitMultiplied = kObject.getValue()
        .multiply(nineDividedByFive, BigDecimalBuilder.getMathContext());
    BigDecimal fahrenheitValue = fahrenheitMultiplied
        .subtract(new BigDecimalBuilder().build(459.67), BigDecimalBuilder.getMathContext());
    return new Fahrenheit(fahrenheitValue);
  }

  @Override
  public Kelvin normalize() {
    BigDecimal five = new BigDecimalBuilder().build(5);
    BigDecimal nine = new BigDecimalBuilder().build(9);
    BigDecimal fiveDividedByNine = five.divide(nine, BigDecimalBuilder.getMathContext());
    BigDecimal valuePlusConst = this.getValue().add(new BigDecimalBuilder().build(459.67));
    BigDecimal kelvinValue = valuePlusConst
        .multiply(fiveDividedByNine, BigDecimalBuilder.getMathContext());
    return new Kelvin(kelvinValue);
  }
}
