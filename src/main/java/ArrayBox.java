import java.util.*;

public class ArrayBox {

    public static void main(String[] args) {
        new ArrayBox().countOddNumber();
    }
    private int generateRandomNumber() {
        return Math.abs((int) (Math.random() * 10) - 1);
    }
    public int[] randomArray() {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomNumber();
            System.out.println(array[i]);
        }
        return array;
    }

    public int countOddNumber() {
        int[] arr = randomArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("Count of odd elements: " + count);
        return count;
    }
    public int[] arraySorted()
    {
        int[] arr = randomArray();
        Arrays.sort(arr);
        return arr;
    }
}
