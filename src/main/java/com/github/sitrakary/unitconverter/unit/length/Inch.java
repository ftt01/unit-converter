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

package com.github.sitrakary.unitconverter.unit.length;

import com.github.sitrakary.unitconverter.BigDecimalBuilder;
import com.github.sitrakary.unitconverter.Convertible;
import com.github.sitrakary.unitconverter.Unit;
import com.github.sitrakary.unitconverter.unit.Length;
import java.math.BigDecimal;

public class Inch extends Unit implements Convertible<Meter> {

  private static String NAME = "inch";
  private static String SYMBOL = "in";
  private static BigDecimal INCH_SCALE = BigDecimalBuilder.getInstance().build(0.0254);

  public Inch() {
    super(new Length(), NAME, SYMBOL, 0d);
  }

  public Inch(double value) {
    super(new Length(), NAME, SYMBOL, value);
  }

  public Inch(BigDecimal value) {
    super(new Length(), NAME, SYMBOL, value);
  }

  @Override
  public Meter normalize() {
    BigDecimal meterValue = INCH_SCALE
        .multiply(this.getValue(), BigDecimalBuilder.getInstance().getMathContext());
    return new Meter(meterValue);
  }

  @Override
  public Unit from(Meter source) {
    BigDecimal inchValue = source.getValue().divide(INCH_SCALE);
    return new Inch(inchValue);
  }
}
