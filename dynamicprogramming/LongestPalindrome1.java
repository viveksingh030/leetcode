class LongestPalindrome1 {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean mt[][]=new boolean[n][n];
         int maxLen=0;
         int start=0;
         for(int i=0;i<n;i++){
            mt[i][i]=true;
             maxLen=1;
         }
         for(int i=0;i<n-1;i++){
           if(s.charAt(i)==s.charAt(i+1)){
               mt[i][i+1]=true;
               start=i;
               maxLen=2;
           }
         }
        for(int len=3;len<=n;len++){
            for(int j=0;j<=n-len;j++){
                int rightIndex=j+len-1;
                if(mt[j+1][rightIndex-1] && (s.charAt(j)==s.charAt(rightIndex))){
                   mt[j][rightIndex]=true;
                    if(maxLen<len){
                        maxLen=len;
                        start=j;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}