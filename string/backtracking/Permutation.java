import java.util.ArrayList;

class Permutation
{
    public static void main(String[] args) {
        ArrayList<String> abc = new Permutation().permutation("ABC");
        System.out.println(abc);
    }
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> res=new ArrayList<>();
        char c[]=S.toCharArray();
        permutation(c,0,S.length()-1,res);
        return res;
    }

    public void permutation(char[] chars,int start,int end,ArrayList<String> res){
        if(start==end){
            res.add(new String(chars));
            return;
        }
        for(int i=start;i<=end;i++){
            char temp=chars[i];
            chars[i]=chars[start];
            chars[start]=temp;
            permutation(chars,start+1,end,res);
            temp=chars[i];
            chars[i]=chars[start];
            chars[start]=temp;
        }
    }

}