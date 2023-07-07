import java.util.ArrayList;
import java.util.List;

//78. Subsets
class SubsetsOfArrayElements {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets=new ArrayList<>();
        int n=nums.length;
        int numofSubset=(int)Math.pow(2,n);
        for(int i=0;i<numofSubset;i++){
            List<Integer> subset=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & 1<<j)!=0){
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}