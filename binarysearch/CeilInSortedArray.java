public class CeilInSortedArray {

    // Function to find the ceiling value in a sorted array
    public static int findCeil(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ceilValue = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // If the mid element is equal to the target, it is the ceil value
                return arr[mid];
            } else if (arr[mid] < target) {
                // If the mid element is smaller than the target, move to the right half
                left = mid + 1;
            } else {
                // If the mid element is greater than the target, update the ceil value and move to the left half
                ceilValue = arr[mid];
                right = mid - 1;
            }
        }

        return ceilValue;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 10, 13};
        int targetNumber = 6;
        int ceilValue = findCeil(sortedArray, targetNumber);

        if (ceilValue == -1) {
            System.out.println("There is no ceil value for " + targetNumber);
        } else {
            System.out.println("The ceil value of " + targetNumber + " is " + ceilValue);
        }
    }
}
