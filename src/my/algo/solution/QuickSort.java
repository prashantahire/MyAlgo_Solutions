

package my.algo.solution;


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
}
