

package my.algo.solution;


public class MergeSort {

    /**
     * Merge sort divide and conquer plus two merge array method. Time complexity: O(nlogn)
     * 
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public void mergeSort(int array[], int startIndex, int endIndex) {

        if (startIndex < endIndex) {

            int midIdx = (startIndex + endIndex) / 2;
            mergeSort(array, startIndex, midIdx);
            mergeSort(array, midIdx + 1, endIndex);
            mergeArray(array, startIndex, midIdx, endIndex);
        }
    }

    /**
     * Merge function to merge two sorted arrays Time complexity O(n)
     * 
     * @param array
     * @param startIndex
     * @param midIdx
     * @param endIndex
     */
    private void mergeArray(int array[], int startIndex, int midIdx, int endIndex) {

        int lsize = midIdx - startIndex + 1;
        int rsize = endIndex - midIdx;

        int leftArr[] = new int[lsize];
        int rightArr[] = new int[rsize];

        for (int i = 0; i < lsize; i++)
            leftArr[i] = array[startIndex + i];

        for (int j = 0; j < rsize; j++)
            rightArr[j] = array[midIdx + 1 + j];

        int i = 0, j = 0;
        int k = startIndex;
        while (i < lsize && j < rsize) {
            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                k++;
                i++;
            }
            else {
                array[k] = rightArr[j];
                k++;
                j++;
            }
        }

        while (i < lsize) {
            array[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < rsize) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
