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

package com.github.sitrakary.unitconverter.unit.temperature;

import com.github.sitrakary.unitconverter.BigDecimalBuilder;
import com.github.sitrakary.unitconverter.Convertible;
import com.github.sitrakary.unitconverter.Unit;
import com.github.sitrakary.unitconverter.unit.Temperature;
import java.math.BigDecimal;

public class Celsius extends Unit implements Convertible<Kelvin> {

  private static final String NAME = "celsius";
  private static final String SYMBOL = "°C";

  public Celsius() {
    super(new Temperature(), NAME, SYMBOL, 0d);
  }

  public Celsius(double value) {
    super(new Temperature(), NAME, SYMBOL, value);
  }

  public Celsius(BigDecimal value) {
    super(new Temperature(), NAME, SYMBOL, value);
  }

  @Override
  public Kelvin normalize() {
    BigDecimal kelvinValue = this.getValue().add(BigDecimalBuilder.getInstance().build(273.15));
    return new Kelvin(kelvinValue);
  }

  @Override
  public Celsius from(Kelvin source) {
    BigDecimal celsiusValue = source.getValue()
        .subtract(BigDecimalBuilder.getInstance().build(273.15));
    return new Celsius(celsiusValue);
  }
}
