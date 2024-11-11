package homework_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MontyGame montyGame = new MontyGame();
        System.out.println("Результат если не менять дверь:");
        HashMap<String, String> resultGame1  = montyGame.startGame(MontyGame.NEVERCHANGE, 1000);
        printStatistic(resultGame1);
        System.out.println("Результат если всегда менять дверь:");
        HashMap<String, String> resultGame2  = montyGame.startGame(MontyGame.ALWAYSCHANGE, 1000);
        printStatistic(resultGame2);
        System.out.println("Результат если менять дверь выборочно:");
        HashMap<String, String> resultGame3  = montyGame.startGame(MontyGame.RANDOM, 1000);
        printStatistic(resultGame3);
    }

    private static void printStatistic (HashMap<String, String> result) {
        int playerWin = Collections.frequency(new ArrayList<String>(result.values()), MontyGame.PLAYER);
        int showHostWin = Collections.frequency(new ArrayList<String>(result.values()), MontyGame.SHOWHOST);
        System.out.println("Игрок победил: " + playerWin + " раз.");
        System.out.println("Ведущий победил: " + showHostWin + " раз.");
    }

}
