class Number_of_Operations_to_Make_Network_Connected {
    int rank[];
    int parent[];
    int component;

    void build(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        this.rank=new int[n];
        this.component=n;
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            if(rank[px]<rank[py]){
                parent[px]=py;
            }
            if(rank[px]>rank[py]){
                parent[py]=px;
            }else{
                parent[px]=py;
                rank[px]+=1;
            }
            component--;
            return true;
        }
        return false;
    }
    public int makeConnected(int n, int[][] connections) {
        build(n);
        int extraWire=0;
        for(int[] connection:connections){
           if(!union(connection[0],connection[1])){
               extraWire++;
           }
        }
        System.out.println(extraWire+" "+component);
        if(component-1>extraWire){
            return -1;
        }
        return component-1;
    }
}