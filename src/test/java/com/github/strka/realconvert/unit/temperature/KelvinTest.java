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

import static org.junit.Assert.assertEquals;

import com.github.strka.realconvert.BigDecimalBuilder;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KelvinTest {

  Kelvin kelvin;
  BigDecimal expectedValue;

  @Before
  public void setUp() {
    kelvin = new Kelvin(4);
    expectedValue = BigDecimalBuilder.getInstance().build(4);
  }

  @After
  public void tearDown() {
  }

  @Test
  public void normalize() {
    assertEquals(0, kelvin.normalize().getValue().compareTo(expectedValue));
  }

  @Test
  public void from() {
    assertEquals(0, kelvin.from(new Kelvin(4)).getValue().compareTo(expectedValue));
  }
}