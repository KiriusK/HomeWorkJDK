package homework_5.variant_2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        ForkSyncList forkList = new ForkSyncList();
        for (int i = 1; i < 6; i++) {
            forkList.add(new Fork("Вилка " + i));
        }
        List<PhilosopherWithList> phWList = new ArrayList<>();
        phWList.add(new PhilosopherWithList("Философ 1", forkList, 0, 4));
        for (int i = 2; i < 6; i++) {
            phWList.add(new PhilosopherWithList("Философ " + i, forkList, i-1, i-2));
        }
        for (PhilosopherWithList ph: phWList) {
            ph.start();
        }
    }
}
