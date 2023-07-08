import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 6, 65, 23, 2, 1, 75,-5,65,-90};
        new InsertionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        int []arr1 = {1,2,3,4};
        new InsertionSort().sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    void sort(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            int k=arr[i];
            while (j>=0 && arr[j]>k){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=k;
        }
    }
}

