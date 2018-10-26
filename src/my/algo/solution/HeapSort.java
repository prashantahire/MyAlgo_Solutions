

package my.algo.solution;


public class HeapSort {

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
}
