import java.util.HashMap;
import java.util.Map;

public class DisjointSetQuickFindHashMap {
    private Map<Integer,Integer> root;

    DisjointSetQuickFindHashMap(){
        root=new HashMap<>();
    }

    int find(int x){
        Integer rootX = root.get(x);
        if(rootX==null){
            root.put(x,x);
            rootX=x;
        }
        return  rootX;
    }

    private  void union(int x,int y){
        int parentX=find(x);
        int parentY=find(y);
        if(parentX!=parentY){
            root.put(y,parentX);
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        DisjointSetQuickFindHashMap uf = new DisjointSetQuickFindHashMap();
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
        uf.union(7, 4);
        System.out.println(uf.connected(4, 9));
        System.out.println(uf.connected(4, 7));//true
        System.out.println("total time="+(System.nanoTime()-start));
    }

    private boolean connected(int x, int y) {
        return find(x)==find(y);
    }
}
