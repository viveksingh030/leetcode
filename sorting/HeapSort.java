import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 6, 65, 23, 2, 1, 75,-5,65,-90};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        int []arr1 = {1,2,3,4,0};
        new HeapSort().sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private void sort(int[] arr) {
        int n=arr.length;
        for(int i=arr.length/2-1;i>=0;i--){
            heapify(arr,i,arr.length);
        }
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, 0, i);
        }
    }

    public void heapify(int arr[],int index,int n){
        int leftChild=2*index+1;
        int rightChild=2*index+2;
        int largest=index;
        if(leftChild<n && arr[leftChild]>arr[largest]){
            largest=leftChild;
        }
        if(rightChild<n && arr[rightChild]>arr[largest]){
            largest=rightChild;
        }
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            heapify(arr,largest,n);
        }
    }
}
