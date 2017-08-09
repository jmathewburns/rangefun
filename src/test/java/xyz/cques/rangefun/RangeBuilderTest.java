package xyz.cques.rangefun;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static xyz.cques.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

/**
 * Created by Jacques on 08-08-2017.
 */
public class RangeBuilderTest {
    @Test
    public void shouldCreateRangeBuilder() {
        new RangeBuilder();
    }

    @Test
    public void shouldCreateEquivalentRangeImpl() {
        int start = 0;
        int end = 8;
        int step = 4;

        RangeImpl expected = new RangeImpl(start, end, step);
        RangeImpl actual = (RangeImpl) new RangeBuilder()
                                            .from(start)
                                            .to(end)
                                            .step(step)
                                            .build();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateReversedRange() {
        int[] expectedIntegers = { 8, 6, 4, 2, 0, };
        Iterable<Integer> range = new RangeBuilder()
                                        .from(0)
                                        .to(8)
                                        .step(2)
                                        .reverse()
                                        .build();

        rangeReturnsExpectedInts(range, expectedIntegers);
    }

    @Test
    public void shouldCreateRangeWithExclusiveEnd() {
        int[] expectedIntegers = { 1, 2, 3, 4, };
        Iterable<Integer> range = new RangeBuilder()
                                        .from(0)
                                        .to(5)
                                        .step(1)
                                        .exclusiveEnd()
                                        .build();

        rangeReturnsExpectedInts(range, expectedIntegers);
    }

    @Test
    public void shouldImplicitlyCreateEquivalentRangeIterators() {
        RangeBuilder builder = new RangeBuilder()
                                    .from(1)
                                    .to(2)
                                    .step(3);

        assertEquals(builder.build().iterator(),
                     builder.iterator());
    }
}