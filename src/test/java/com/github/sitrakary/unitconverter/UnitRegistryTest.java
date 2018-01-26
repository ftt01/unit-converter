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

import static org.junit.Assert.assertEquals;

import com.github.sitrakary.unitconverter.unit.Temperature;
import com.github.sitrakary.unitconverter.unit.temperature.Celsius;
import java.util.HashSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitRegistryTest {

  UnitRegistry unitRegistry;
  HashSet<Class<? extends Unit>> units;

  @Before
  public void setUp() {
    unitRegistry = new UnitRegistry();
    units = new HashSet<>();
  }

  @After
  public void tearDown() {
  }

  @Test
  public void getRegistry() {
  }

  @Test
  public void registerShouldAddNewTypeToRegistry() {
    unitRegistry.register(Temperature.class, null);
    assertEquals(1, unitRegistry.getRegistry().size());
  }

  @Test
  public void registerShouldNotAddDuplicateType() {
    unitRegistry.register(Temperature.class, null);
    unitRegistry.register(Temperature.class, null);
    assertEquals(1, unitRegistry.getRegistry().size());
  }

  @Test
  public void registerShouldNotAddDuplicateUnit() {
    units.add(Celsius.class);
    units.add(Celsius.class);
    unitRegistry.register(Temperature.class, units);
    HashSet<?> tempUnits = (HashSet<?>) unitRegistry.getRegistry().get(Temperature.class);
    assertEquals(1, tempUnits.size());
  }
}