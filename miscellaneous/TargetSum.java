class TargetSum {
    int res=0;
    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWays(nums,0,0,target);
        return res;
    }

      public void findTargetSumWays(int[] nums, int index,int currSum,int target) {
        if(currSum==target && index==nums.length){
            res++;
        }
        if(index>=nums.length){
            return;
        }
        findTargetSumWays(nums,index+1,currSum+nums[index],target);
         findTargetSumWays(nums,index+1,currSum-nums[index],target);
    }
}