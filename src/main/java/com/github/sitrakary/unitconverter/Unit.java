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

import java.math.BigDecimal;

public abstract class Unit {

  private String name;
  private String symbol;
  private BigDecimal value;
  private Type type;

  public Unit() {

  }

  protected Unit(Type type, String name, String symbol, double value) {
    this.type = type;
    this.name = name;
    this.symbol = symbol;
    this.value = BigDecimalBuilder.getInstance().build(value);
  }

  protected Unit(Type type, String name, String symbol, BigDecimal value) {
    this.type = type;
    this.name = name;
    this.symbol = symbol;
    this.value = value;
  }

  public abstract Unit normalize();

  public String getName() {
    return name;
  }

  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getValue() {
    return value;
  }

  public Type getType() {
    return type;
  }
}
