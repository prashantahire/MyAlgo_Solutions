package my.algo.backtracking;

public class SumSubsetProblem {
    public static boolean isSubsetSum(int arr[], int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;
        return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n]);
    }
    public static void main(String... args) {
        int arr[] = { 5, 10, 12, 13, 15, 18 };
        int sum = 30;
        int n=6;
        System.out.println(isSubsetSum(arr, n-1, sum));
    }
}
