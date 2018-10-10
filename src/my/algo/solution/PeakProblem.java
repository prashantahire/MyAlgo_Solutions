

package my.algo.solution;


import java.util.Random;


public class PeakProblem {
    static int recCnt = 1;

    public static void main(String args[]) {
        int arrSize = 10;
        int[] array = getArray(arrSize);
        long startTimeSimple = System.currentTimeMillis();
        System.out.println(
                    "One dimanesion peak oneDPeakSimpleAlgo:" + oneDPeakSimpleAlgo(array) + " Time taken :" + (System.currentTimeMillis() - startTimeSimple));

        long startTimeRec = System.currentTimeMillis();
        System.out.println("One dimanesion peak oneDPeakRecAlgo:" + oneDPeakRecAlgo(array, (arrSize / 2) - 1) + " Time taken :" +
                    (System.currentTimeMillis() - startTimeRec));

        int arr2[][] = get2DArray(50, 20);
        long startTime2DSimple = System.currentTimeMillis();
        System.out.println("Two dimanesion peak twoDPeakSimpleAlgo:" + twoDPeakSimpleAlgo(arr2, 20) + " Time taken :" +
                    (System.currentTimeMillis() - startTime2DSimple));

        long startTime2DImproved = System.currentTimeMillis();
        System.out.println("Two dimanesion peak twoDPeakImprovedAlgo:" + twoDPeakImprovedAlgo(arr2, 10) + " Time taken :" +
                    (System.currentTimeMillis() - startTime2DImproved));

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


    public static int oneDPeakRecAlgo(int arr[], int compareIndx) {
        System.out.println("Rec called " + recCnt++);
        if (arr[compareIndx] < arr[compareIndx + 1]) {
            return oneDPeakRecAlgo(arr, compareIndx + 1);
        }
        else if (arr[compareIndx] < arr[compareIndx - 1]) {
            return oneDPeakRecAlgo(arr, compareIndx - 1);
        }
        else {
            System.out.println("Element : " + arr[compareIndx] + " index:" + compareIndx);
            return arr[compareIndx];
        }
    }

    public static int twoDPeakSimpleAlgo(int[][] arr, int csize) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) {
                continue;
            }
            for (int j = 0; j < csize; j++) {
                if (j == 0 || j == csize - 1) {
                    continue;
                }
                if (arr[i][j] > arr[i][j + 1] && arr[i][j] > arr[i][j - 1] && arr[i][j] > arr[i + 1][j] && arr[i][j] > arr[i - 1][j]) {
                    return arr[i][j];
                }
            }
        }
        return 0;
    }

    public static int twoDPeakImprovedAlgo(int arr[][], int column) {
        int maxRowNum = getMaxRowNumForColumn(arr, column);
        if (maxRowNum <= 0 || (maxRowNum - 1) >= arr.length) {
            return arr[maxRowNum][column];
        }
        if (arr[maxRowNum - 1][column] > arr[maxRowNum][column]) {
            return twoDPeakImprovedAlgo(arr, column / 2);
        }
        else if (arr[maxRowNum + 1][column] > arr[maxRowNum][column]) {
            return twoDPeakImprovedAlgo(arr, column / 2);
        }
        else {
            return arr[maxRowNum][column];
        }
    }

    public static int getMaxRowNumForColumn(int arr[][], int column) {
        int max = 0;
        int rowNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][column] > max) {
                max = arr[i][column];
                rowNum = i;
            }
        }
        return rowNum;
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

    public static int[][] get2DArray(int rsize, int csize) {
        System.out.println("2D Array.....");
        System.out.println("=============================================");
        Random random = new Random();
        int intmax = rsize * csize;
        int[][] array = new int[rsize][csize];
        for (int i = 0; i < rsize; i++) {
            for (int j = 0; j < csize; j++) {
                array[i][j] = random.nextInt(intmax);
                System.out.print("  " + array[i][j]);
            }
            System.out.println();
        }
        System.out.println("=============================================");
        return array;
    }


}
