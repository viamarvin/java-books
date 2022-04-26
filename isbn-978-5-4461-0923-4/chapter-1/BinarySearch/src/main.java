import me.podrezov.search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public void getIterativeMethod(int[] sortedArray, int key, int low, int high) {
        long start = System.currentTimeMillis();
        int res = BinarySearch.iteratively(sortedArray, key, low, high);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println("Итеративный метод поиска: " + res + ". Время " + elapsed + " мс.");
    }

    public void getRecursivelyMethod(int[] sortedArray, int key, int low, int high) {
        long start = System.currentTimeMillis();
        int res = BinarySearch.recursively(sortedArray, key, low, high);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println("Рекурсивный метод поиска: " + res + ". Время " + elapsed + " мс.");
    }

    public void getWithArrayMethod(int[] sortedArray, int key) {
        long start = System.currentTimeMillis();
        int res = BinarySearch.withArrays(sortedArray, key);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println("Стандартный метод поиска через класс Arrays: " + res + ". Время " + elapsed + " мс.");
    }

    public void getWithCollectionsMethod(int[] sortedArray, int key) {
        long start = System.currentTimeMillis();
        int res = BinarySearch.withCollections(sortedArray, key);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println("Стандартный метод поиска через класс Collections: " + res + ". Время " + elapsed + " мс.");
    }

    public static void main(String[] args) {
        String numbers = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите отсортированный массив для поиска: ");

        try {
            numbers = bufferedReader.readLine();
            String[] arrayNumbers = numbers.split(" ");

            int[] sortedArray = new int[arrayNumbers.length];
            for (int i = 0; i < arrayNumbers.length; i++) {
                sortedArray[i] = Integer.parseInt(arrayNumbers[i]);
            }

            System.out.println("Введите число для поиска: ");
            int key = Integer.parseInt(bufferedReader.readLine());

            int low = 0;
            int high = sortedArray.length;

            Main mainInstance = new Main();
            mainInstance.getIterativeMethod(sortedArray, key, low, high);
            mainInstance.getRecursivelyMethod(sortedArray, key, low, high);
            mainInstance.getWithArrayMethod(sortedArray, key);
            mainInstance.getWithCollectionsMethod(sortedArray, key);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}