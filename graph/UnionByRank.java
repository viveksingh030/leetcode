public class UnionByRank {
    private int[] root;
    private int[] rank;
    UnionByRank(int n){
        root=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x){
        while (x==root[x]){
           return x;
        }
        return root[x]=find(root[x]);
    }

    public void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rank[rootX]>rank[rootY]){
            root[rootY]=rootX;
        }else if(rank[rootX]<rank[rootY]){
            root[rootX]=rootY;
        }else{
            root[rootX]=rootY;
            rank[rootY]+=1;
        }
    }

    public static void main(String[] args) {
        long start=System.nanoTime();
        UnionByRank union=new UnionByRank(10);
        union.union(1, 2);
        union.union(2, 5);
        union.union(5, 6);
        union.union(6, 7);
        union.union(3, 8);
        union.union(8, 9);
        System.out.println(union.connected(1, 5)); // true
        System.out.println(union.connected(5, 7)); // true
        System.out.println(union.connected(4, 9)); // false
        System.out.println(union.connected(4, 7)); // false
        // 1-2-5-6-7 3-8-9-4
        union.union(9, 4);
        union.union(7,4);
        System.out.println(union.connected(4, 9));//true
        System.out.println(union.connected(4, 7));//true
        System.out.println("total time="+(System.nanoTime()-start));
    }

    private boolean connected(int x, int y) {
        return find(x)==find(y);
    }

}
