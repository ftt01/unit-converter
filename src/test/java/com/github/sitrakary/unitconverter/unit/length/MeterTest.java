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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.sitrakary.unitconverter.BigDecimalBuilder;
import org.junit.Before;
import org.junit.Test;

public class MeterTest {

  Meter meter;
  Meter oneMeter;
  Inch mockedInch;

  @Before
  public void setUp() {
    meter = new Meter();
    oneMeter = new Meter(1);
    mockedInch = mock(Inch.class);
    when(mockedInch.getValue()).thenReturn(BigDecimalBuilder.getInstance().build(39.37007874));
  }

  @Test
  public void fromShouldReturnAMeterFromAGivenMeter() {
    assertEquals(0, meter.from(oneMeter).getValue().compareTo(oneMeter.getValue()));
  }

  @Test
  public void normalize() {
    assertEquals(0,
        oneMeter.normalize().getValue().compareTo(BigDecimalBuilder.getInstance().build(1)));
  }
}