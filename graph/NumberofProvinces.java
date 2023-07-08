class NumberofProvinces {
    int root[];
    int rank[];
    
    void build(int n){
        root=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
        }
    }
    
  public int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
}
    
    void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rank[rootX]<rank[rootY]){
            root[rootX]=rootY;
        }
        else if(rank[rootX]>rank[rootY]){
            root[rootY]=rootX;
        }else{
            root[rootX]=rootY;
            rank[rootY]+=1;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int numberOfComponents = n;
        build(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && find(i) !=find(j)) {
                    numberOfComponents--;
                    union(i, j);
                }
            }
        }

        return numberOfComponents;
    }
        
}