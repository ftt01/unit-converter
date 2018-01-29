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

public class Foot extends Unit implements Convertible<Meter> {

  private static final String NAME = "foot";
  private static final String SYMBOL = "ft";
  private static final BigDecimal FOOT_CONST = BigDecimalBuilder.getInstance().build(0.3048);

  public Foot() {
    super(new Length(), NAME, SYMBOL, 0d);
  }

  public Foot(double value) {
    super(new Length(), NAME, SYMBOL, value);
  }

  public Foot(BigDecimal value) {
    super(new Length(), NAME, SYMBOL, value);
  }

  @Override
  public Foot from(Meter source) {
    BigDecimal value = source.getValue()
        .divide(FOOT_CONST, BigDecimalBuilder.getInstance().getMathContext());
    return new Foot(value);
  }

  @Override
  public Meter normalize() {
    BigDecimal meterValue = this.getValue()
        .multiply(FOOT_CONST, BigDecimalBuilder.getInstance().getMathContext());
    return new Meter(meterValue);
  }
}
