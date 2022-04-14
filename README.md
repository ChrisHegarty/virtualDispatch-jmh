Benchmark to demonstrate the overhead of _invokeinterface_ over _invokevirtual_,
particularly when being called in a tight loop.

Run as follows:
----
```
$ ./gradlew benchmarks

$ java -jar build/libs/virtualDispatch-jmh-1.0-SNAPSHOT-benchmarks.jar
```

Results:
----

(scroll to end for benchmark results)

```
$ sw_vers
ProductName:	macOS
ProductVersion:	11.5.2
BuildVersion:	20G95

$ uname -a
Darwin chegar-MBP.local 20.6.0 Darwin Kernel Version 20.6.0: Wed Jun 23 00:26:27 PDT 2021; root:xnu-7195.141.2~5/RELEASE_ARM64_T8101 arm64

$ sysctl -n machdep.cpu.brand_string
Apple M1

$ system_profiler SPHardwareDataType
Hardware:

    Hardware Overview:

      Model Name: MacBook Pro
      Model Identifier: MacBookPro17,1
      Chip: Apple M1
      Total Number of Cores: 8 (4 performance and 4 efficiency)
      Memory: 16 GB
      System Firmware Version: 6723.140.2
      OS Loader Version: 6723.140.2
      Serial Number (system): FVFG731MQ05P
      Hardware UUID: 1D7BA696-DBDB-5E9C-BD46-5A18758DE699
      Provisioning UDID: 00008103-000A05E001C0801E
      Activation Lock Status: Disabled


java -jar build/libs/virtualDispatch-jmh-1.0-SNAPSHOT-benchmarks.jar 
# JMH version: 1.35
# VM version: JDK 17.0.2-internal, OpenJDK 64-Bit Server VM, 17.0.2-internal+0-adhoc.chegar.jdk17u-dev
# VM invoker: /Users/chegar/git/jdk17u-dev/build/macosx-aarch64-server-fastdebug/images/jdk/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 500 ms each
# Measurement: 10 iterations, 500 ms each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: p.LoopPerfTest.interfaceBench

# Run progress: 0.00% complete, ETA 00:00:45
# Fork: 1 of 3
# Warmup Iteration   1: 1.537 ms/op
# Warmup Iteration   2: 1.524 ms/op
# Warmup Iteration   3: 1.550 ms/op
# Warmup Iteration   4: 1.553 ms/op
# Warmup Iteration   5: 1.512 ms/op
Iteration   1: 1.515 ms/op
Iteration   2: 1.513 ms/op
Iteration   3: 1.510 ms/op
Iteration   4: 1.511 ms/op
Iteration   5: 1.514 ms/op
Iteration   6: 1.512 ms/op
Iteration   7: 1.511 ms/op
Iteration   8: 1.515 ms/op
Iteration   9: 1.514 ms/op
Iteration  10: 1.509 ms/op

# Run progress: 16.67% complete, ETA 00:00:42
# Fork: 2 of 3
# Warmup Iteration   1: 1.533 ms/op
# Warmup Iteration   2: 1.509 ms/op
# Warmup Iteration   3: 1.515 ms/op
# Warmup Iteration   4: 1.508 ms/op
# Warmup Iteration   5: 1.510 ms/op
Iteration   1: 1.508 ms/op
Iteration   2: 1.508 ms/op
Iteration   3: 1.548 ms/op
Iteration   4: 1.510 ms/op
Iteration   5: 1.513 ms/op
Iteration   6: 1.510 ms/op
Iteration   7: 1.511 ms/op
Iteration   8: 1.510 ms/op
Iteration   9: 1.508 ms/op
Iteration  10: 1.511 ms/op

# Run progress: 33.33% complete, ETA 00:00:33
# Fork: 3 of 3
# Warmup Iteration   1: 1.537 ms/op
# Warmup Iteration   2: 1.551 ms/op
# Warmup Iteration   3: 1.509 ms/op
# Warmup Iteration   4: 1.511 ms/op
# Warmup Iteration   5: 1.514 ms/op
Iteration   1: 1.509 ms/op
Iteration   2: 1.509 ms/op
Iteration   3: 1.509 ms/op
Iteration   4: 1.509 ms/op
Iteration   5: 1.509 ms/op
Iteration   6: 1.520 ms/op
Iteration   7: 1.523 ms/op
Iteration   8: 1.509 ms/op
Iteration   9: 1.680 ms/op
Iteration  10: 1.805 ms/op


Result "p.LoopPerfTest.interfaceBench":
  1.528 ±(99.9%) 0.041 ms/op [Average]
  (min, avg, max) = (1.508, 1.528, 1.805), stdev = 0.061
  CI (99.9%): [1.487, 1.569] (assumes normal distribution)


# JMH version: 1.35
# VM version: JDK 17.0.2-internal, OpenJDK 64-Bit Server VM, 17.0.2-internal+0-adhoc.chegar.jdk17u-dev
# VM invoker: /Users/chegar/git/jdk17u-dev/build/macosx-aarch64-server-fastdebug/images/jdk/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 500 ms each
# Measurement: 10 iterations, 500 ms each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: p.LoopPerfTest.virtualBench

# Run progress: 50.00% complete, ETA 00:00:25
# Fork: 1 of 3
# Warmup Iteration   1: 3.063 ms/op
# Warmup Iteration   2: 3.447 ms/op
# Warmup Iteration   3: 1.824 ms/op
# Warmup Iteration   4: 1.502 ms/op
# Warmup Iteration   5: 1.439 ms/op
Iteration   1: 1.376 ms/op
Iteration   2: 1.359 ms/op
Iteration   3: 1.354 ms/op
Iteration   4: 1.344 ms/op
Iteration   5: 1.318 ms/op
Iteration   6: 1.328 ms/op
Iteration   7: 1.340 ms/op
Iteration   8: 1.328 ms/op
Iteration   9: 1.338 ms/op
Iteration  10: 1.344 ms/op

# Run progress: 66.67% complete, ETA 00:00:17
# Fork: 2 of 3
# Warmup Iteration   1: 1.393 ms/op
# Warmup Iteration   2: 1.364 ms/op
# Warmup Iteration   3: 1.337 ms/op
# Warmup Iteration   4: 1.336 ms/op
# Warmup Iteration   5: 1.330 ms/op
Iteration   1: 1.333 ms/op
Iteration   2: 1.331 ms/op
Iteration   3: 1.336 ms/op
Iteration   4: 1.371 ms/op
Iteration   5: 1.329 ms/op
Iteration   6: 1.499 ms/op
Iteration   7: 1.348 ms/op
Iteration   8: 1.332 ms/op
Iteration   9: 1.341 ms/op
Iteration  10: 1.355 ms/op

# Run progress: 83.33% complete, ETA 00:00:08
# Fork: 3 of 3
# Warmup Iteration   1: 1.497 ms/op
# Warmup Iteration   2: 1.569 ms/op
# Warmup Iteration   3: 1.614 ms/op
# Warmup Iteration   4: 1.368 ms/op
# Warmup Iteration   5: 1.365 ms/op
Iteration   1: 1.374 ms/op
Iteration   2: 1.651 ms/op
Iteration   3: 1.431 ms/op
Iteration   4: 1.345 ms/op
Iteration   5: 1.370 ms/op
Iteration   6: 1.332 ms/op
Iteration   7: 1.328 ms/op
Iteration   8: 1.331 ms/op
Iteration   9: 1.328 ms/op
Iteration  10: 1.326 ms/op


Result "p.LoopPerfTest.virtualBench":
  1.361 ±(99.9%) 0.044 ms/op [Average]
  (min, avg, max) = (1.318, 1.361, 1.651), stdev = 0.065
  CI (99.9%): [1.317, 1.404] (assumes normal distribution)


# Run complete. Total time: 00:00:51

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                    Mode  Cnt  Score   Error  Units
LoopPerfTest.interfaceBench  avgt   30  1.528 ± 0.041  ms/op
LoopPerfTest.virtualBench    avgt   30  1.361 ± 0.044  ms/op
```