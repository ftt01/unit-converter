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

package com.github.strka.realconvert;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class TypeTest {

  private int initialUnitsLength;
  private Unit unit;
  private Unit anotherUnitWithSameNameAsUnitButWithDifferentValue;
  private Type sut;

  @Before
  public void setUp() {
    sut = spy(Type.class);
    initialUnitsLength = sut.getUnits().size();

    unit = mock(Unit.class);
    anotherUnitWithSameNameAsUnitButWithDifferentValue = mock(Unit.class);

    when(unit.getName()).thenReturn("unit");
    when(unit.getValue()).thenReturn(new BigDecimal(34));
    when(anotherUnitWithSameNameAsUnitButWithDifferentValue.getName()).thenReturn("unit");
    when(anotherUnitWithSameNameAsUnitButWithDifferentValue.getValue())
        .thenReturn(new BigDecimal(15));
  }

  @Test
  public void getName() {
  }

  @Test
  public void registerShouldRegisterNewUnit() {
    sut.register(unit);
    assertEquals(++initialUnitsLength, sut.getUnits().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void returnShouldNotRegisterIfUnitsAlreadyHaveAUnitWithSameName() {
    sut.register(unit);
    sut.register(anotherUnitWithSameNameAsUnitButWithDifferentValue);
  }
}