import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LongestPalindrome {
    public static void main(String[] args) {
        List<String> longestPalindromes = longestPalindrome("abcdcefeghg");
        System.out.println(longestPalindromes);
    }
    public static List<String> longestPalindrome(String s) {
        List<String> res=new ArrayList<>();
        Map<Integer,List<Integer>> lengthStartMap=new HashMap<>();
        int n=s.length();
        boolean mt[][]=new boolean[n][n];
         int maxLen=0;
         int start=0;
         for(int i=0;i<n;i++){
            mt[i][i]=true;
            maxLen=1;
            lengthStartMap.computeIfAbsent(maxLen,ArrayList::new);
            lengthStartMap.get(maxLen).add(i);
         }
         for(int i=0;i<n-1;i++){
           if(s.charAt(i)==s.charAt(i+1)){
               mt[i][i+1]=true;
               start=i;
               maxLen=2;
               lengthStartMap.computeIfAbsent(maxLen,ArrayList::new);
               lengthStartMap.get(maxLen).add(start);
           }
         }
        for(int len=3;len<=n;len++){
            for(int j=0;j<=n-len;j++){
                int rightIndex=j+len-1;
                if(mt[j+1][rightIndex-1] && (s.charAt(j)==s.charAt(rightIndex))){
                   mt[j][rightIndex]=true;
                    if(maxLen<=len){
                        maxLen=len;
                        start=j;
                        lengthStartMap.computeIfAbsent(maxLen,ArrayList::new);
                        lengthStartMap.get(maxLen).add(start);
                    }
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> lengthStartEntry : lengthStartMap.entrySet()) {
            if(lengthStartEntry.getKey()==maxLen) {
              for(int startIndex:lengthStartEntry.getValue()){
                  res.add(s.substring(startIndex,startIndex+maxLen));
              }
            }
        }
        return res;
    }
}