

package my.algo.solution;


import java.util.Random;


public class HeapSort {

    /**
     * Heap sort by using HEAP data structure and implementing max_heapify function.
     * 
     * T(n) = O(n*logn)
     *
     * @param array
     */
    public void heapSort(int array[]) {
        int heapsize = array.length - 1;
        while (heapsize >= 0) {

            // get max heapify
            buildMaxHeapify(array, heapsize);

            // swap max root node which is max and last node
            int temp = array[0];
            array[0] = array[heapsize];
            array[heapsize] = temp;

            // decrease heap size
            heapsize--;
        }
        System.out.println("Heap Sorted array :");
        printArray(array);
    }

    /**
     * This method build array to max heapify array. Definition max_heapfy : The key of a node is ≥ than the keys of its
     * children.
     * 
     * @param array
     */
    public void buildMaxHeapify(int array[], int heapsize) {
        for (int i = heapsize / 2; i >= 0; i--) {
            maxHeapify(array, i, heapsize);
        }
    }

    /**
     * This method builds max heapify For Heap as TREE: root of tree: first element in the array, corresponding to i = 1
     * parent(i) =i/2: returns index of node's parent left(i)=2i: returns index of node's left child right(i)=2i+1:
     * returns index of node's right child
     * 
     * @param array
     * @param i
     */
    public void maxHeapify(int array[], int i, int heapsize) {
        int largestKeyIndex = i;
        if (2 * i + 1 <= heapsize && array[2 * i + 1] > array[i]) {
            largestKeyIndex = 2 * i + 1;
        }
        if (2 * i + 2 <= heapsize && array[2 * i + 2] > array[largestKeyIndex]) {
            largestKeyIndex = 2 * i + 2;
        }
        int temp;
        if (largestKeyIndex != i) {
            temp = array[largestKeyIndex];
            array[largestKeyIndex] = array[i];
            array[i] = temp;
            // check to swap child nodes of currently swapped node.
            maxHeapify(array, largestKeyIndex, heapsize);
        }
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

        HeapSort sort = new HeapSort();
        int array[] = sort.getArray(10);
        sort.heapSort(array);
    }

}
