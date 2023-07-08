class CountConnectedComponents {
    int[] root;
    int rank[];
    int[][] edges;
    int component;
    
    void build(int n){
        this.component=n;
        root=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
        }
    }
    
    int find(int x){
        if(x==root[x]){
            return x;
        }
        root[x]=find(root[x]);
        return root[x];
    }
    
    void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            if(rank[rootX]<rank[rootY]){
                root[rootX]=rootY;
            }
            if(rank[rootX]>rank[rootY]){
                root[rootY]=rootX;
            }else{
                root[rootX]=rootY;
                rank[rootY]+=1;
            }
            component--;
        }
    }
    public int countComponents(int n, int[][] edges) {
        build(n);
        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }
        return component;
    }
}