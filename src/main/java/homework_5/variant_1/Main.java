package homework_5.variant_1;

import homework_5.variant_2.PhilosopherWithList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        List<Fork> forkList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            forkList.add(new Fork("Вилка " + i));
        }

        Semaphore sem = new Semaphore(1);
        List<Philosopher> philosopherList = new ArrayList<>();
        philosopherList.add(new Philosopher("Философ 1", sem, forkList.get(4), forkList.get(0)));
        for (int i = 2; i < 6; i++) {
            philosopherList.add(new Philosopher("Философ " + i, sem, forkList.get(i-1), forkList.get(i-2)));
        }
        for (Philosopher ph: philosopherList) {
            ph.start();
        }

    }
}
