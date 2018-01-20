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

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import org.junit.Before;
import org.junit.Test;

public class BigDecimalBuilderTest {

  private double value;
  private BigDecimal bigValue;

  @Before
  public void setUp() {
    value = 45.6786786868686874657675456548465448764654132135764;
  }

  @Test
  public void testWithMathContext() {
    bigValue = new BigDecimalBuilder().mathContext(MathContext.DECIMAL128).build(value);
    assertEquals(0, new BigDecimal(value, MathContext.DECIMAL128).compareTo(bigValue));
  }

  @Test
  public void build() {
    bigValue = new BigDecimal(1.2, BigDecimalBuilder.getMathContext());
    assertEquals(0, new BigDecimalBuilder().build(1.2).compareTo(bigValue));
  }
}