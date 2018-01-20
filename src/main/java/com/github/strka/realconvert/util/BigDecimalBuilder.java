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

package com.github.strka.realconvert.util;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalBuilder {

  private static MathContext mathContext = MathContext.DECIMAL32;

  public static MathContext getMathContext() {
    return mathContext;
  }

  public void setMathContext(MathContext mathContext) {
    BigDecimalBuilder.mathContext = mathContext;
  }

  public BigDecimal build(double value) {
    BigDecimal bigValue = new BigDecimal(value, mathContext);
    return bigValue;
  }

  public BigDecimalBuilder mathContext(MathContext mathContext) {
    BigDecimalBuilder.mathContext = mathContext;
    return this;
  }
}
