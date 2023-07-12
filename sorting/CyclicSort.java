import java.util.Arrays;

/*
this algo works when we have number from 1 to n and we have to sort them in o(n) without using extra space
 */
public class CyclicSort {
    public static void main(String[] args) {
        int a[]=new int[]{4,5,3,1,2};
        new CyclicSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    void sort(int arr[]){
        int i=0;
        while(i<arr.length){
            int correctIndex=arr[i]-1;
            if(arr[correctIndex]!=arr[i]){
                int temp=arr[correctIndex];
                arr[correctIndex]=arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }
    }

}
