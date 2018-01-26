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

import com.github.sitrakary.unitconverter.unit.Temperature;
import com.github.sitrakary.unitconverter.unit.temperature.Celsius;
import com.github.sitrakary.unitconverter.unit.temperature.Kelvin;
import java.util.HashSet;

public class Converter {

  private UnitRegistry unitRegistry;
  private Unit source;

  Converter() {
    unitRegistry = new UnitRegistry();

    HashSet<Class<? extends Unit>> temperatures = new HashSet<>();
    temperatures.add(Celsius.class);
    temperatures.add(Kelvin.class);
    unitRegistry.register(Temperature.class, temperatures);
  }

  public Converter convert(Unit unit) {
    this.source = unit;
    return this;
  }

  public Unit getSource() {
    return source;
  }

  public Unit to(Class<? extends Unit> unitClass) throws IncompatibleUnitException {
    Convertible<Unit> convertible;
    Unit conversionResult = null;
    Unit normalized = source.normalize();
    Unit unitTarget = null;

    try {
      unitTarget = unitClass.getConstructor().newInstance();
    } catch (Throwable e) {
      e.printStackTrace();
    }

    if (!source.getType().getName().equals(unitTarget.getType().getName())) {
      throw new IncompatibleUnitException();
    }
    try {
      convertible = (Convertible<Unit>) unitTarget;
      conversionResult = convertible.from(normalized);
    } catch (Throwable ignored) {

    }

    return conversionResult;
  }
}
