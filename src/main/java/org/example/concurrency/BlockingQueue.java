package org.example.concurrency;


import java.util.LinkedList;

public class BlockingQueue {
    private final LinkedList<Object> queue;
    private final int LIMIT;

    public BlockingQueue(int LIMIT) {
        this.queue = new LinkedList<>();
        this.LIMIT = LIMIT;
    }

    public synchronized void enqueue(Object obj) {
            while (queue.size() == LIMIT) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            queue.add(obj);
            notify();
        }
    public synchronized Object dequeue(){
        while (queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return queue.removeFirst();
    }

    public int size(){
        return queue.size();
    }
}
