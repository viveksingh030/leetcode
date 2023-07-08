import java.util.PriorityQueue;

class MinCostToConnectAllPoints {
    int rank[];
    int root[];
    int component;

    void build(int n){
        rank=new int[n];
        root=new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
        }
        this.component=n;
    }
    int find(int x){
        if(x==root[x]){
            return x;
        }
        return root[x]=find(root[x]);
    }
    
    boolean union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            if(rank[rootX]<rank[rootY]){
                root[rootX]=rootY;
            }
            else if(rank[rootX]>rank[rootY]){
                root[rootY]=rootX;
            }else{
                 root[rootX]=rootY;
                 rank[rootY]+=1;
            }
            component--;
            if(component==1){
                return true;
            }
        }
        return false;
    }
    class Edge{
        int src;
        int dest;
        int distance;
        Edge(int src,int dest,int distance){
            this.src=src;
            this.dest=dest;
            this.distance=distance;
        }

        public String toString(){
            return   "["+"src:"+src+" dest:"+dest+" distance:"+distance+"]";
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        build(n);
        PriorityQueue<Edge> minHeap=new PriorityQueue<>((a, b)->a.distance-b.distance);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                minHeap.add(new Edge(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(
                points[i][1]-points[j][1])));
            }
        }
        int cost=0;
        while(component!=1 && minHeap.isEmpty()==false){
           Edge edge=minHeap.poll();
           if(find(edge.src)!=find(edge.dest)){
             cost+=edge.distance;
             union(edge.src,edge.dest);
           }
        }
        return cost;
    }
}