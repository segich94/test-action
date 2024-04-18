package org.example.sinchronizer;

public class ComplexTask {
    public int execute(){
        System.out.println(Thread.currentThread().getName() + "execute");
        return 1;
    }
}
