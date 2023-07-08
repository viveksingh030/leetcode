import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 6, 65, 23, 2, 1, 75,-5,65,-90};
        new MergeSort().mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int left[]= Arrays.copyOfRange(arr,l,mid+1);
        int right[]= Arrays.copyOfRange(arr,mid+1,r+1);
        int li=0,ri=0,k=0;
        while (li<left.length && ri<right.length){
            if(left[li]<=right[ri]){
                arr[l+k]=left[li];
                li++;
            }else{
                arr[l+k]=right[ri];
                ri++;
            }
            k++;
        }
        while (li<left.length){
            arr[l+k++]=left[li++];
        }
        while (ri<right.length){
            arr[l+k++]=right[ri++];
        }
    }
}
