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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.strka.realconvert.BigDecimalBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FahrenheitTest {

  private Fahrenheit fahrenheit;
  private Kelvin kelvin;

  @Before
  public void setUp() {
    fahrenheit = new Fahrenheit(1.0004);
    kelvin = mock(Kelvin.class);
    when(kelvin.getValue()).thenReturn(BigDecimalBuilder.getInstance().build(255.9280));
  }

  @After
  public void tearDown() {
  }

  @Test
  public void normalize() {
    assertEquals(0, fahrenheit.normalize().getValue().compareTo(kelvin.getValue()));
  }

  @Test
  public void from() {
    assertEquals(0, fahrenheit.from(new Kelvin(255.9280)).getValue()
        .compareTo(new Fahrenheit(1.0004).getValue()));
  }
}