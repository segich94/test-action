package org.example.sinchronizer;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private CyclicBarrier cyclicBarrier;
    private ExecutorService executor;
    private int result = 0;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.cyclicBarrier = new CyclicBarrier(numberOfTasks);
        this.executor = Executors.newFixedThreadPool(numberOfTasks);
    }

    public void executeTasks(int numberOfTasks){
        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                ComplexTask complexTask = new ComplexTask();
                complexTask.execute();
                try {
                    cyclicBarrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            });

        }
        System.out.println("shutdown by " + Thread.currentThread().getName());
        executor.shutdown();
    }
}
