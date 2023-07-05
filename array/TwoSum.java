class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(target-nums[i])!=null){
                return new int[]{i,hm.get(target-nums[i])};
            }
            else{
            hm.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }
}
