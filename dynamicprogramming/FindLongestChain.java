import java.util.Arrays;

class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b)->a[0]-b[0]);
        int ans=0,n=pairs.length;
        int dp[]=new int[pairs.length];
        Arrays.fill(dp,1);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(pairs[j][0]>pairs[i][1]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}