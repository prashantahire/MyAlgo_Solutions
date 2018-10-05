

package my.algo.solution;


import java.util.Random;


public class PeakProblem {
    static int recCnt = 1;

    public static void main(String args[]) {
        int arrSize = 10;
        int[] array = getArray(arrSize);
    }

    public static int[] getArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        for (int e : array) {
            System.out.print(e + ",");
        }
        System.out.println("");
        System.out.println("=============");
        return array;
    }
}

public static int oneDPeakSimpleAlgo(int arr[]) {
        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                System.out.println("index : " + i);
                return arr[i];
            }
        }
        if (arr[0] > arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        return 0;
    }
