public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0]-'0';
            max=Math.max(max,dp[i][0]);
        }
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i]=matrix[0][i]-'0';
            max=Math.max(max,dp[0][i]);
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}