package my.algo.solution;

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
}
