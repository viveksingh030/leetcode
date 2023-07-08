public class DisjointSetQuickFindArray {
    private int[] root;
    DisjointSetQuickFindArray(int n){
        root=new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
        }
    }
    public int find(int x){
        return  root[x];
    }

    public void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            for(int i=0;i<root.length;i++){
               if(rootY==root[i]){
                   root[i]=rootX;
               }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        DisjointSetQuickFindArray uf = new DisjointSetQuickFindArray(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        System.out.println(uf.connected(4, 7)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        uf.union(7,4);
        System.out.println(uf.connected(4, 9));//true
        System.out.println(uf.connected(4, 7));//true
        System.out.println("total time="+(System.nanoTime()-start));
    }

    private boolean connected(int x, int y) {
        return find(x)==find(y);
    }
}
