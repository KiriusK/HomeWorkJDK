package homework_5.variant_1;

public class Fork{
    private boolean isTaken;
    private final String name;

    public Fork(String name) {
        this.name = name;
        this.isTaken = false;
    }

    public boolean takeFork(String phName) {
        if (isTaken) {
            System.out.println(name + " занята");
            return false;
        } else {
            isTaken = true;
            System.out.println(phName + " взял " + name);
            return true;
        }
    }

    public void putFork(String phName) {
        this.isTaken = false;
        System.out.println(phName + " положил " + name);
    }
}
