package homework_5.variant_2;

import java.util.concurrent.CopyOnWriteArrayList;

public class ForkSyncList extends CopyOnWriteArrayList<Fork> {


    synchronized public boolean takeForks(int leftFork, int rightFork) {
        if (!this.get(leftFork).takeFork()) {
            return false;
        }
        if (!this.get(rightFork).takeFork()) {
            return false;
        }
        return true;
    }

    public void putForks(int leftFork, int rightFork) {
        this.get(leftFork).putFork();
        this.get(rightFork).putFork();
    }
}
