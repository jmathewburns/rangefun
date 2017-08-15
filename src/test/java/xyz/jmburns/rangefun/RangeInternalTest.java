/*
 * Copyright 2017 Jacques Burns
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package xyz.jmburns.rangefun;

import org.junit.Test;

import static org.junit.Assert.*;

import static xyz.jmburns.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

public class RangeInternalTest {
    @Test
    public void shouldCreateRangeImplementation() {
        new RangeInternal(1, 2, 3);
    }

    @Test
    public void shouldReturnCorrectIterator() {
        RangeInternal range = new RangeInternal(0, 4, 2);
        int[] expectedIntegers = {0, 2, 4};

        assertTrue(rangeReturnsExpectedInts(range, expectedIntegers));
    }

    @Test
    public void shouldReflectGivenValuesInToString() {
        String expected = "RangeInternal{start=0, end=10, step=5}";
        RangeInternal range = new RangeInternal(0, 10, 5);

        assertEquals(expected, range.toString());
    }

    @Test
    public void shouldBeEqual() {
        RangeInternal range1 = new RangeInternal(0, 10, 5);
        RangeInternal range2 = new RangeInternal(0, 10, 5);

        assertTrue(range1.equals(range2));
    }

    @Test
    public void shouldBeUnEqual() {
        RangeInternal range1 = new RangeInternal(0, 10, 5);
        RangeInternal range2 = new RangeInternal(0, 4, 2);

        assertFalse(range1.equals(range2));
    }

    @Test
    public void shouldReturnSameHashForEqualRanges() {
        RangeInternal range1 = new RangeInternal(0, 10, 5);
        RangeInternal range2 = new RangeInternal(0, 10, 5);

        assertEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    public void shouldReturnDifferentHashForDifferentRanges() {
        RangeInternal range1 = new RangeInternal(0, 10, 5);
        RangeInternal range2 = new RangeInternal(0, 4, 2);

        assertNotEquals(range1.hashCode(), range2.hashCode());
    }
}
