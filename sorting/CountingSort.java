import java.util.Arrays;
import java.util.OptionalInt;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 6, 65, 23,95,2, 1, 75};
        new CountingSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        int []arr1 = {1,2,3,4};
        new CountingSort().sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    void sort(int []arr){
        OptionalInt reduce = Arrays.stream(arr).reduce(Math::max);
        int max=reduce.getAsInt();
        int count[]=new int[max+1];
        for(int num:arr){
            count[num]++;
        }
        for(int i=1;i<max+1;i++){
            count[i]+=count[i-1];
        }
        int output[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int index=count[arr[i]]-1;
           output[index]=arr[i];
           count[arr[i]]--;
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=output[i];
        }
    }
}
