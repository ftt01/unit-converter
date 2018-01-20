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

import com.github.strka.realconvert.Convertible;
import com.github.strka.realconvert.Temperature;
import com.github.strka.realconvert.util.BigDecimalBuilder;
import java.math.BigDecimal;

public final class Celsius extends Temperature implements Convertible<Kelvin, Celsius> {

  private final static String NAME = "Kelvin";
  private final static String SYMBOL = "K";

  public Celsius() {
    super(Celsius.NAME, Celsius.SYMBOL, 0);
  }

  public Celsius(double value) {
    super(Celsius.NAME, Celsius.SYMBOL, value);
  }

  public Celsius(BigDecimal value) {
    super("Celsius", "°C", value);
  }

  @Override
  public Kelvin normalize() {
    Kelvin k = new Kelvin(new BigDecimalBuilder().build(273.15).add(this.getValue()));
    return k;
  }


  @Override
  public Celsius from(Kelvin k) {
    Celsius c = new Celsius(k.getValue().subtract(new BigDecimalBuilder().build(273.15)));
    return c;
  }
}
