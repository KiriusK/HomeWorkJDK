package homework_5.variant_2;

public class Fork {
    private boolean isTaken;
    private final String name;

    public Fork(String name) {
        this.name = name;
        this.isTaken = false;
    }

    public boolean takeFork() {
        if (isTaken) {
            System.out.println(name + " занята");
            return false;
        } else {
            isTaken = true;
            System.out.println(name + " взята" );
            return true;
        }
    }

    public void putFork() {
        this.isTaken = false;
        System.out.println(name + " положена");
    }
}
