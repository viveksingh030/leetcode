//75. Sort Colors
class DutNationalFlag {
    public void sortColors(int[] nums) {
        int lo=0,curr=0,end=nums.length-1;
        while(curr<=end){
            if(nums[curr]==0){
                int temp=nums[curr];
                nums[curr++]=nums[lo];
                nums[lo++]=temp;
            }else if(nums[curr]==2){
                int temp=nums[end];
                nums[end--]=nums[curr];
                nums[curr]=temp;
            }else{
                curr++;
            }
        }
    }
}