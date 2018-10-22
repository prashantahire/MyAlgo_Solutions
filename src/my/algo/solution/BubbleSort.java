package my.algo.solution;

/**
 * Bubble sort time complexity O(n^2)
 * 
 * @author prashant
 *
 */
public class BubbleSort {

    public void bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Buble Sort output: ");
        printArray(array);
    }
}
