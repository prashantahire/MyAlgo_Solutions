public class SelectionSort{
    
    public void flip(int arr[], int start, int k){        
        int i= start;
        int j = k-1;
        while(i<j) {
            int temp  = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
