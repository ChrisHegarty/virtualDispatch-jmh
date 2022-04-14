package p;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 3)
public class LoopPerfTest {

    int size = 2_000_000;

    int[] counts;

    int increment;

    @Setup
    public void setup() {
        counts = new int[size];
        increment = 1;
    }

    @Benchmark
    public int[] virtualBench() {
        LarryIterator docItr = new LarryIterator(increment);
        return foo(docItr, counts);
    }

    @Benchmark
    public int[] interfaceBench() {
        LarryIterator docItr = new LarryIterator(increment);
        return bar(docItr, docItr, counts);
    }

    // Note: code is deliberately verbose and new liney, to facilitate easier matching to decompiled artifacts

    // Both foo and bar are functionally equivalent, iterating over DocIterator `nextDoc` at a time.
    // Foo invokes nextDoc with an `invokevirtual`, whereas bar does so with `invokeinterface`.

    static final int[] foo(final LarryIterator singleValues, final int[] segCounts) {
        for (int doc = singleValues.nextDoc();
             doc < 2_000_000;
             doc = singleValues.nextDoc()) {
            int v = singleValues.value();
            segCounts[v]++;
        }
        return segCounts;
    }

    static final int[] bar(final LarryIterator singleValues, final DocIterator it, final int[] segCounts) {
        for (int doc = it.nextDoc();
             doc < 2_000_000;
             doc = it.nextDoc()) {
            int v = singleValues.value();
            segCounts[v]++;
        }
        return segCounts;
    }

    interface DocIterator {

        public int nextDoc();

        int value();
    }
    static abstract class BaseDocIterator implements DocIterator {
        int increment;

        int value;

        BaseDocIterator(int increment) {
            this.increment = increment;
        }
        @Override
        public int nextDoc() {
            int v = value + increment;
            value = v;
            return value;
        }

        @Override
        public int value() {
            return value;
        }
    }


    static final class LarryIterator extends BaseDocIterator {

        LarryIterator(int increment) {
            super(increment);
        }

        @Override
        public int nextDoc() {
            return super.nextDoc();
        }

    }

//    static final class WrapperDocIterator implements DocIterator {
//
//        private final DocIterator itr;
//
//        WrapperDocIterator(DocIterator itr) {
//            this.itr = itr;
//        }
//
//        @Override
//        public int value() {
//            return itr.value();
//        }
//
//        @Override
//        public int nextDoc() {
//            return itr.nextDoc();
//        }
//    }
}
