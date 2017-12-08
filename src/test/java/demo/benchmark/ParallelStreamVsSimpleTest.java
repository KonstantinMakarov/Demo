package demo.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ParallelStreamVsSimpleTest {

    private List<String> persons = new ArrayList<>();

    private List<String> sortDistinct(int limit) {
        for (int i=0; i<limit; i++){
            persons.add(i + "Alice" + i);
        }
        return persons.stream().sorted().distinct().collect(Collectors.toList());
    }

    private List<String> parallelSortDistinct(int limit) {
        for (int i=0; i<limit; i++) {
            persons.add(i + "Bob" + i);
        }
        return persons.parallelStream().sorted().distinct().collect(Collectors.toList());
    }

    @Benchmark
    public List<String> parallel_1000() {
        return parallelSortDistinct(1000);
    }

    @Benchmark
    public List<String> nonParallel_1000() {
        return sortDistinct(1000);
    }

    @Benchmark
    public List<String> parallel_mln() {
        return parallelSortDistinct(1000000);
    }

    @Benchmark
    public List<String> nonParallel_mln() {
        return sortDistinct(1000000);
    }

    @Test
    void parallelStreamVsSimpleDemo() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ParallelStreamVsSimpleTest.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
