package homework_5.variant_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    private List<Fork> forkList;
    private Semaphore sem;
    private int counter;
    private Random rand;

    public Philosopher(String name, Semaphore sem, Fork leftFork, Fork rightFork) {
        super(name);
        this.counter = 3;
        this.sem = sem;
        rand = new Random();
        forkList = new ArrayList<>();
        forkList.add(leftFork);
        forkList.add(rightFork);
    }



    @Override
    public void run() {
        while (counter>0) {
            try {
                sem.acquire();
                Thread.sleep(rand.nextInt(1, 3)*1000L);
                eat();
                sem.release();
                think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void think() throws InterruptedException{
        System.out.println(getName()+" думает.");
        Thread.sleep(rand.nextInt(1, 3)*1000L);
    }

    private void eat() throws InterruptedException {
        for (Fork fork: forkList) {
            if (!fork.takeFork(getName())) {
                return;
            }
        }
        Thread.sleep(rand.nextInt(1, 3)*1000L);
        System.out.println(getName()+" ест.");
        for (Fork fork: forkList) {
            fork.putFork(getName());
        }
        counter--;
    }
}
