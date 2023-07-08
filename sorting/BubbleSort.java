import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 6, 65, 23, 2, 1, 75,-5,65,-90};
        new BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        int []arr1 = {1,2,3,4};
        new BubbleSort().sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (swap == false) {
                break;
            }
        }
    }
}
