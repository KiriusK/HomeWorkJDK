package homework_5.variant_2;

import homework_5.variant_1.Fork;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class PhilosopherWithList extends Thread{
    private ForkSyncList forkList;
    private int leftFork;
    private int rightFork;
    private Semaphore sem;
    private int counter;
    private Random rand;

    public PhilosopherWithList(String name, ForkSyncList forkList, int leftFork, int rightFork) {
        super(name);
        this.counter = 3;
        rand = new Random();
        this.forkList = forkList;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }



    @Override
    public void run() {
        while (counter>0) {
            try {
                eat();
                Thread.sleep(rand.nextInt(1, 3)*1000L);
                think();
                Thread.sleep(rand.nextInt(1, 3)*1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void think() throws InterruptedException{
        System.out.println(getName()+" думает.");
        Thread.sleep(rand.nextInt(1, 3)*1000L);

    }

    private void eat() {
        if (!forkList.takeForks(leftFork, rightFork)) {
        return;
        }
        System.out.println(getName()+" ест.");
        forkList.putForks(leftFork, rightFork);
        counter--;
    }
}
