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

public class Celsius extends Temperature {

  private static final BigDecimal KELVIN_CONSTANT = BigDecimalBuilder.getInstance().build(273.15);

  public Celsius() {
    this.name = "celsius";
    this.symbol = "°C";
  }

  public Celsius(double value) {
    this.name = "celsius";
    this.symbol = "°C";
    this.value = BigDecimalBuilder.getInstance().build(value);
  }

  public Celsius(BigDecimal value) {
    super();
    this.name = "celsius";
    this.symbol = "°C";
    this.value = value;
  }

  @Override
  public Kelvin normalize() {
    BigDecimal kelvinValue = this.getValue().add(KELVIN_CONSTANT);
    return new Kelvin(kelvinValue);
  }

  @Override
  public Celsius from(Kelvin standardUnit) {
    BigDecimal value = standardUnit.getValue()
        .subtract(KELVIN_CONSTANT);
    return new Celsius(value);
  }
}
