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

package com.github.sitrakary.unitconverter;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.sitrakary.unitconverter.unit.Length;
import com.github.sitrakary.unitconverter.unit.Temperature;
import com.github.sitrakary.unitconverter.unit.length.Inch;
import com.github.sitrakary.unitconverter.unit.temperature.Celsius;
import com.github.sitrakary.unitconverter.unit.temperature.Kelvin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConverterTest {

  private Converter converter;
  private Celsius mockedCelsius;
  private Inch mockedInch;

  @Before
  public void setUp() {
    converter = new Converter();
    mockedCelsius = mock(Celsius.class);
    mockedInch = mock(Inch.class);
    when(mockedCelsius.normalize()).thenReturn(new Kelvin());
    when(mockedCelsius.getType()).thenReturn(new Temperature());
    when(mockedInch.getType()).thenReturn(new Length());
  }

  @After
  public void tearDown() {
  }

  @Test
  public void convertShouldSetTheSourceUnit() {
    converter.convert(new Celsius());
    assertNotNull(converter.getSource());
  }

  @Test
  public void convertShouldReturnAConverter() {
    assertNotNull(converter.convert(new Celsius()));
  }

  @Test
  public void toShouldConvertSourceTheTarget() throws IncompatibleUnitException {
    Kelvin result = (Kelvin) converter.convert(new Celsius()).to(Kelvin.class);
    assertNotNull(result.getName());
  }

  /**
   * Does this test should be improved?
   */
  @Test
  public void toConvertAnUnitToAnotherOne() throws IncompatibleUnitException {
    converter.convert(mockedCelsius).to(Kelvin.class);
    verify(mockedCelsius).normalize();
  }

  @Test(expected = IncompatibleUnitException.class)
  public void fromIncompatibleUnitExceptionWhenAttemptingToConvertUnitThatHaveDifferentType()
      throws IncompatibleUnitException {
    converter.convert(mockedCelsius).to(mockedInch.getClass());
  }
}