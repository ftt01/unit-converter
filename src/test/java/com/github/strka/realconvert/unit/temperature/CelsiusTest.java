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
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CelsiusTest {

  private Celsius celsius;
  private Kelvin kelvin;

  @Before
  public void setUp() {
    celsius = new Celsius(0);
    kelvin = Mockito.mock(Kelvin.class);
    Mockito.when(kelvin.getValue()).thenReturn(BigDecimalBuilder.getInstance().build(273.15));
  }

  @Test
  public void normalize() {
    assertEquals(0, celsius.normalize().getValue().compareTo(kelvin.getValue()));
  }

  @Test
  public void from() {
    assertEquals(0, celsius.from(new Kelvin(273.15)).getValue()
        .compareTo(BigDecimalBuilder.getInstance().build(0)));
  }
}