package com.lexmatos.ocp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class ConcurrencyTest {

  @Test
  void parallelStream() {  // d e f

    final var c = new ArrayList<Thread>();
    var s = c.stream();
    var p = s.parallel();  // c.stream().parallel()
    var q = c.parallelStream();
    Assertions.assertNotEquals(q,p);
  }
  private Lock vault = new ReentrantLock();
  private int total = 0;
  private void deposit(int value){
    try {
      vault.lock();           // vault.tryLock();
      total += value;
    } finally{
        vault.unlock();
    }
  }
  @Test
  void depositTest(){
    IntStream.range(1,10).parallel().forEach(this::deposit);
    Assertions.assertEquals(total,45);
  }

  @Test
  void codeCompileTest() throws ExecutionException, InterruptedException {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    service.schedule(() -> {
      System.out.println("Open Zoo");
      return 1;
    }, 2L, TimeUnit.SECONDS);

    var result = service.submit(() -> System.out.println("Wake Staff"));

    Assertions.assertNull(result.get());
  }
  @Test
  void followingCodeTest(){

    var value1 = new AtomicLong(0);
    long[] value2 = {0};
    IntStream.iterate(1, i->i+1).limit(100).parallel().forEach(i -> value1.incrementAndGet());
    IntStream.iterate(1, i->i+1).limit(100).parallel().forEach(i -> ++value2[0]);
    Assertions.assertEquals("100 91",value1+" "+value2[0]);
  }
  @Test
  void correctOrderTest() {
    var data = List.of(2,5,1,9,8);
    data.stream().parallel().mapToInt(s -> s).peek(System.out::print).forEachOrdered(System.out::println);
  }

  private static int counter;
  @Test
  void countIceCreamFlavorTest(){
    counter = 0;
    Runnable task = () -> counter++;
    LongStream.range(0,500).parallel().forEach(m -> new Thread(task).start());

    Assertions.assertEquals(500,counter);
  }

  @Test
  void codeSnippet(){
    List<Integer> lions = new ArrayList<>(List.of(1,2,3));
    List<Integer> tigers = new CopyOnWriteArrayList<>(lions);
    Set<Integer> bears = new ConcurrentSkipListSet<>();
    bears.addAll(lions);
    for (Integer item: tigers) tigers.add(4);
    for (Integer item: bears) bears.add(5);
    System.out.println("lions: "+lions.toString());
    System.out.println("tigers: "+tigers.toString());
    System.out.println("bears: "+bears.toString());
    Assertions.assertEquals("3 6 4",lions.size()+" "+tigers.size()+" "+bears.size());
  }
  private void takeNap()  {
    LocalTime currentTime = LocalTime.now();
    LocalTime future = currentTime.plusSeconds(5);
    while (currentTime.isBefore(future)) {
      currentTime = LocalTime.now();
    }
    System.out.println("TAKE a NAP DONE!");
  }
  @Test
  void takeNapTest() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(4);
    try {
      service.execute(() -> takeNap());
      service.execute(() -> takeNap());
      service.execute(() -> takeNap());
      service.execute(() -> takeNap());

    } finally {
      service.shutdown();
    }
    service.awaitTermination(2, TimeUnit.SECONDS);
    System.out.println("DONE!");
  }

  @Test
  void duckTest(){

    System.out.print(List.of("duck","flamingo","pelican")
      .parallelStream().parallel()
      .reduce(0,(c1,c2) -> c1 + c2.length(), (s1,s2) -> s1+s2));

    System.out.println(List.of('w','o','l','f').parallelStream().reduce("",(s1,c) -> s1+c, (s2,s3) -> s2+s3));
    System.out.println(List.of('A','l','e','x','a','n','d','r','e').parallelStream().reduce("",(s1,s2) -> s1+s2, (s4,s3) -> s4+s3));
    System.out.println(List.of('A','l','e','x','a','n','d','r','e').parallelStream().reduce("",(s1,s2) -> s1+s2, (s4,s3) -> s3+s4));
    System.out.println(List.of('A','l','e','x','a','n','d','r','e').parallelStream().reduce("",(s1,s2) -> s2+s1, (s4,s3) -> s4+s3));
    System.out.println(List.of("A","l","e","x","a","n","d","r","e").stream().reduce("",(s1,s2) -> s1+s2));
    System.out.println(List.of('A','l','e','x','a','n','d','r','e').parallelStream().reduce("",(s1,s2) -> s2+s1, (s4,s3) -> s3+s4));
  }

  @Test
  void tortoiseTest() throws ExecutionException, InterruptedException {
    Object o1 = new Object();
    Object o2 = new Object();
    var service = Executors.newFixedThreadPool(2);
    var f1 = service.submit( () -> {
      synchronized (o1) {
        synchronized (o2) { System.out.print("Tortoise");}
      }
    });
    var f2 = service.submit( () -> {
      synchronized (o2) {
        synchronized (o1) { System.out.print("Hare");}
      }
    });
    Assertions.assertNull(f1.get());
    Assertions.assertNull(f2.get());
  }

  @Test
  void catsTest(){
    var cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
    var bears = Stream.of("panda","grizzly","polar").parallel();
    var data = Stream.of(cats,bears).flatMap(s -> s).collect(Collectors.groupingByConcurrent( s -> !s.startsWith("p")));

    System.out.println(data.toString());

    Assertions.assertEquals("3 4", data.get(false).size() + " " + data.get(true).size());
  }
  class RocketShip{
    private volatile int fuel;
    protected void launch(int checks){
      var p = new ArrayList<Thread>();
      for (int i =0; i < checks; i++)
        p.add(new Thread(() -> fuel++));
      p.forEach(Thread::interrupt);
      p.forEach(Thread::start);
      p.forEach(Thread::interrupt);
    }
  }

  @Test
  void rocketShipTest() throws InterruptedException {
    var ship = new RocketShip();
    ship.launch(100);
    Thread.sleep(60*100);

    Assertions.assertEquals(100,ship.fuel);
  }

  private static int count =0;
  @Test
  void printCounterTest() throws ExecutionException, InterruptedException {

    var service = Executors.newSingleThreadExecutor();
    try{
      var r = new ArrayList<Future<?>>();
      IntStream.iterate(0, i -> i+1).limit(5).forEach(
        i -> {
          r.add(service.submit(() -> {
            count++;
          }));
        }
      );
      for(Future<?> result : r){
        System.out.print(result.get()+" ");
      }
    } finally {
      service.shutdown();
    }
  }

  private static int s2 =0;
  AtomicInteger s1 = new AtomicInteger(0);
  private void countSheep() throws InterruptedException {
    var service = Executors.newCachedThreadPool();
    //var service = Executors.newSingleThreadScheduledExecutor(); // 100 e 100

    try {
      for (int i = 0; i < 1000; i++)
        service.execute(() -> {
          s1.getAndIncrement(); s2++;
        });
      Thread.sleep(60*100);
      System.out.println(s1 + " " + s2);
    } finally { service.shutdown();}
  }

  @Test
  void countSheepTest() throws InterruptedException {
    countSheep();
  }

  @Test
  void printConstantsTest() {
    var s = Executors.newScheduledThreadPool(10);
    DoubleStream.of(3.14159, 2.71828).forEach( c -> s.submit(() -> System.out.println(10*c)));
    s.execute(() -> System.out.println("Printed"));
  }

  public static void await(CyclicBarrier cd) {
    try {
      cd.await();
    } catch (Exception e) {
    }
  }
  @Test
  void stockRoomTrackerTest(){
    var cb = new CyclicBarrier(10, () -> System.out.println("Stock Room Full!"));
    IntStream.iterate(1, i -> 1).limit(10)
      .parallel().forEach(i -> await(cb)); // j3
  }
}