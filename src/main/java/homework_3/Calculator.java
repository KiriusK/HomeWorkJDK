package homework_3;

public class Calculator {

    public static <T extends Number> double sum(T firstDig, T secondDig) {
        return  firstDig.doubleValue() +  secondDig.doubleValue();
    }
    public static <T extends Number> double multiply(T firstDig, T secondDig) {
        return firstDig.doubleValue() * secondDig.doubleValue();
    }
    public static <T extends Number> double divide(T firstDig, T secondDig) {
        return firstDig.doubleValue() / secondDig.doubleValue();
    }
    public static <T extends Number> double subtract(T firstDig, T secondDig) {
        return firstDig.doubleValue() - secondDig.doubleValue();
    }

}
