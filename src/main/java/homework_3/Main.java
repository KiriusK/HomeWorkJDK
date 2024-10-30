package homework_3;

public class Main {
    public static void main(String[] args) {
        float f = 34.5f;
        int i = 43;
        String s = "34";
        System.out.println(Calculator.sum(f,i));
        System.out.println(Calculator.divide(i,f));

        Integer[] arrInt = {1,2,3,4,5};
        Integer[] arrInt1 = {1,2,3,4,5};
        String[] arrString = {"re", "cre"};
        String[] arrString2 = {"re", "cre"};
        System.out.println(Compare.compareArrays(arrString2, arrString));
        System.out.println(Compare.compareArrays(arrInt1, arrInt));
        System.out.println(Compare.compareArrays(arrInt1, arrString));
    }
}
