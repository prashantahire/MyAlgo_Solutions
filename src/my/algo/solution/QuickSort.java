

package my.algo.solution;


import java.util.Random;


public class QuickSort {

    /**
     * Uses partitioning to sort.... Best case T(n) = O(nlogn) Worst case T(n) = O(n^2)
     * 
     * @param array
     * @param low
     * @param high
     */
    public void quickSort(int array[], int low, int high) {
        if (low < high) {
            int partitionPosition = partition(array, low, high);
            quickSort(array, low, partitionPosition - 1);
            quickSort(array, partitionPosition + 1, high);
        }
    }

    /**
     * This method consider mid of the array as PIVOT and returns the partitioning position for the selected pivot. T(n)
     * = O(n) Partition Rule: Left elements <= Pivot and right elements > Pivot
     * 
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int partition(int array[], int low, int high) {
        // (low + high) / 2
        // consider pivot as mid of the array
        int pivot = array[low];
        int iLow = low;
        int jHigh = high;

        while (iLow < jHigh) {
            // increment low till El[low] <= pivot
            while (iLow < high && array[iLow] <= pivot) {
                iLow = iLow + 1;
            }
            // decrement j till El[high] > pivot
            while (jHigh > low && array[jHigh] > pivot) {
                jHigh = jHigh - 1;
            }
            // swap the elements violating partition rule
            if (iLow < jHigh) {
                int temp = array[iLow];
                array[iLow] = array[jHigh];
                array[jHigh] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[jHigh];
        array[jHigh] = temp;
        return jHigh;
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

    public static void main(String... args) {

        QuickSort sort = new QuickSort();
        int array[] = sort.getArray(10);
        sort.quickSort(array, 0, array.length - 1);
        System.out.println("Quick sort output: ");
        sort.printArray(array);
    }
}
