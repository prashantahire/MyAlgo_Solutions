package my.algo.solution;

import java.util.Random;

public class InsertionSort {
    
    public static void main(String ...args) {
        InsertionSort sort = new InsertionSort();
        int array[] = sort.getArray(10);
        sort.insertionSort(array);        
    }
    public void insertionSort(int array[]) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                else {
                    break;
                }

            }
        }
        System.out.println("Insertion Sort output: ");
        printArray(array);
    }
    public int[] getArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        printArray(array);
        return array;
    }
    
    public void printArray(int array[]) {
        for (int e : array) {
            System.out.print(e + ",");
        }
        System.out.println("");
        System.out.println("=============");
    }
}
