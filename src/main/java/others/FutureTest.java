package others;

import java.util.concurrent.*;

/**
 * @description:
 * @author: alex
 * @date: 2019-08-22
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<Callable<Integer>> tasks = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            MyThread thread = new MyThread(i);
//            tasks.add(thread);
//        }
//        List<Future<Integer>> futures = executorService.invokeAll(tasks);
//        for (Future<Integer> future : futures) {
//            System.out.println(future.get());
//        }
//        System.out.println();
        MyThread thread = new MyThread(2);
        Future<Integer> future = executorService.submit(thread);
//        boolean done = future.isDone();
//        System.out.println(done);
        Integer integer = future.get();
        System.out.println(integer);
    }

    static class MyThread implements Callable<Integer> {
        Integer integer;
        MyThread(Integer integer) {
            this.integer = integer;
        }
        @Override
        public Integer call() throws Exception {
            System.out.println("start.");
            Thread.sleep(3000);
            System.out.println(integer);
            System.out.println("end.");
            return integer;
        }
    }

}
