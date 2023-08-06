public class FloorInSortedArray {

    // Function to find the floor value in a sorted array
    public static int findFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int floorValue = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // If the mid element is equal to the target, it is the floor value
                return arr[mid];
            } else if (arr[mid] < target) {
                // If the mid element is smaller than the target, update the floor value and move to the right half
                floorValue = arr[mid];
                left = mid + 1;
            } else {
                // If the mid element is greater than the target, move to the left half
                right = mid - 1;
            }
        }

        return floorValue;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 10, 13};
        int targetNumber = 6;
        int floorValue = findFloor(sortedArray, targetNumber);

        if (floorValue == -1) {
            System.out.println("There is no floor value for " + targetNumber);
        } else {
            System.out.println("The floor value of " + targetNumber + " is " + floorValue);
        }
    }
}
