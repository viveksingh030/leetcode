import java.util.Arrays;

class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length-2;i++){
            sum+=findPair(nums,i+1,target-nums[i]);
        }
        return sum;
    }

    public int findPair(int[]nums, int left,int target){
        int sum=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]<target){
                sum+=right-left;
                left++;
            }else{
                right--;
            }
        }
        return sum;
    }
}