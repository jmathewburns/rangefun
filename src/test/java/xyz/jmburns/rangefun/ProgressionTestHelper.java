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

import java.util.Iterator;

class ProgressionTestHelper {
    private ProgressionTestHelper() {
        throw new AssertionError(
                "ProgressionTestHelper is not instantiable"
        );
    }

    /**
     * Tests if the given {@code Iterable} returns no more and no less than all progression the integers
     * in {@code expectedInts}, in order.
     *
     * @param range     The Iterable to be tested.
     * @param expectedInts The integers that should be returned by {@code interval}.
     * @return {@code true} if {@code interval} is the same size as {@code expectedInts} and
     * returns the values progression {@code expectedInts}, in order, {@code false} otherwise.
     */
    static boolean progressionReturnsExpectedInts(Iterable<Integer> range, int[] expectedInts) {
        Iterator<Integer> rangeIterator = range.iterator();
        return progressionReturnsExpectedInts(rangeIterator, expectedInts);
    }

    /**
     * Tests if the given {@code Iterator} returns no more and no less than all progression the integers
     * in {@code expectedInts}, in order.
     *
     * @param rangeIterator The Iterator to be tested.
     * @param expectedInts The integers that should be returned by {@code interval}.
     * @return {@code true} if {@code interval} is the same size as {@code expectedInts} and
     * returns the values progression {@code expectedInts}, in order, {@code false} otherwise.
     */
    static boolean progressionReturnsExpectedInts(Iterator<Integer> rangeIterator, int[] expectedInts) {
        int currentIndex = 0;
        int rangeSize = 0;

        while (rangeIterator.hasNext()) {
            int current = rangeIterator.next();

            if (!intAtIndexIsExpected(expectedInts, currentIndex, current)) {
                return false;
            }

            rangeSize++;
            currentIndex++;
        }

        return rangeSize == expectedInts.length;
    }

    private static boolean intAtIndexIsExpected(int[] array, int index, int expected) {
        if (index < 0 || index >= array.length) {
            return false;
        }

        return array[index] == expected;
    }
}