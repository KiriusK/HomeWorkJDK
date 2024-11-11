package homework_6;

import javax.xml.transform.dom.DOMResult;
import java.util.*;

public class MontyGame {

    public static final int RANDOM = 0;
    public static final int ALWAYSCHANGE = 1;
    public static final int NEVERCHANGE = 2;

    public static final String SHOWHOST = "Ведущий";
    public static final String PLAYER = "Игрок";
    private int doorsNumber;
    private final boolean GOAT = false;
    private final boolean CAR = true;
    private int gameType;
    private List<Boolean> doors;
    private Random rand;

    public MontyGame() {
        rand = new Random();
        doorsNumber = 3;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    private String game() {
        int doorRemain =-1;
        int indexSum = 3;
        int playerChoice = rand.nextInt(0,3);
        if (gameType == MontyGame.NEVERCHANGE) {
            return getStringResult(doors.get(playerChoice));
        }
        for (int i = 0; i < doorsNumber; i++) {
            if (i != playerChoice && !doors.get(i)) {
              doorRemain = indexSum - playerChoice - i;
            }
        }
        if (gameType == MontyGame.ALWAYSCHANGE) {
            return getStringResult(doors.get(playerChoice));
        } else {
            if (rand.nextInt(2,4) == 2) {
                return getStringResult(doors.get(playerChoice));
            } else {
                try {
                    return getStringResult(doors.get(doorRemain));
                } catch (IndexOutOfBoundsException ex) {
                    throw new RuntimeException("Error: " + ex.getMessage());
                }
            }
        }
    }

    private String getStringResult (boolean result) {
        if(result) {
            return MontyGame.PLAYER;
        } else {
            return MontyGame.SHOWHOST;
        }
    }

    private void arrangeGoats() {
        doors = new ArrayList<>(3);
        for (int i = 0; i < doorsNumber; i++) {
            if (rand.nextInt(3,5) == 3) {
                doors.add(CAR);
                for (int j = ++i; j < doorsNumber; j++) {
                    doors.add(GOAT);
                    i++;
                }
            } else {
                if (doorsNumber - i == 1) {
                    doors.add(CAR);
                } else {
                doors.add(GOAT);
                }
            }
        }
        Collections.shuffle(doors);
    }

    public HashMap<String, String> startGame(int gameType, int numberOfGames) {
        HashMap<String, String> result = new HashMap<>();

        setGameType(gameType);
        for (int i = 0; i < numberOfGames; i++) {
            arrangeGoats();
            result.put(String.valueOf(i+1), game());
        }

        return result;
    }
}
