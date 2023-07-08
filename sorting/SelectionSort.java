import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 6, 65, 23, 2, 1, 75,-5,65,-90};
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        int []arr1 = {1,2,3,4};
        new SelectionSort().sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    void sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }
}
