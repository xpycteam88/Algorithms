package algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int[] randomIntsArray1 = IntStream.generate(() -> new Random()
                .nextInt(100_000)).limit(100_000).toArray();
        int[] randomIntsArray2 = IntStream.generate(() -> new Random()
                .nextInt(100_000)).limit(100_000).toArray();
        int[] randomIntsArray3 = IntStream.generate(() -> new Random()
                .nextInt(100_000)).limit(100_000).toArray();

        long start = System.currentTimeMillis();
        sortBubble(randomIntsArray1);
        System.out.println("Пузырьковая сортировка: " + (System.currentTimeMillis() - start) / 1000d + " секунд");

        long start2 = System.currentTimeMillis();
        sortSelection(randomIntsArray2);
        System.out.println("Сортировка выбором: " + (System.currentTimeMillis() - start2) / 1000d + " секунд");

        long start3 = System.currentTimeMillis();
        sortInsertion(randomIntsArray3);
        System.out.println("Сортировка вставкой: " + (System.currentTimeMillis() - start3) / 1000d + " секунд");

        /*
        int[] arr = new Random().ints(20, -10, 100).toArray();
        System.out.println(Arrays.toString(arr));

        new Random().ints(20, -510, 10).forEach(System.out::println);

         */

    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


}
