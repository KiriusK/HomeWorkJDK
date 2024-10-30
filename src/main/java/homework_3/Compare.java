package homework_3;

public class Compare {

    static <T> boolean compareArrays(T[] arr1, T[]arr2) {
        if (arr1.length != arr2.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].getClass().getName().equals(arr2[i].getClass().getName())) {
                        return false;
                }
                if (!arr1[i].equals(arr2[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
