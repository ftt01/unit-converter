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

import java.lang.reflect.Method;

public
class Converter<T> {

  private T source;
  private T target;

  Converter() {
  }

  public
  T getSource() {
    return source;
  }

  public
  T getTarget() {
    return target;
  }

  public Converter convert(Class<? extends T> source, double value) {
    try {
      this.source = source.getConstructor(double.class).newInstance(value);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return this;
  }

  public T to(Class<? extends T> target) {
    Method fromStandardUnit;
    try {
      fromStandardUnit = target.getMethod("from", this.source.getClass());
      this.target = (T) fromStandardUnit.invoke(target.getConstructor().newInstance(), this.source);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return this.target;
  }
}
