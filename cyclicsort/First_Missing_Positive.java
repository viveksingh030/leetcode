class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
      int i=0;
      while(i<nums.length){
          int j=nums[i]-1;
          if(j>=0 && j<nums.length && nums[i]!=nums[j]){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
          }else{
            i++;
          }
      }
      for(i=0;i<nums.length;i++){
        if(nums[i]!=i+1){
          return i+1;
        }
      }
      return nums.length+1;
    }
}

