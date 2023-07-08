import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OptimizeWaterDistributionKruskalAlgo {
    int rank[];
    int root[];
    void build(int n){
       rank=new int[n];
	   root=new int[n];
	   for(int i=0;i<n;i++){
	       root[i]=i;
	   }
    }
    void union(int x,int y){
	    int rootX=find(x);
	    int rootY=find(y);
	    if(rootX!=rootY){
	         if(rank[rootX]<rank[rootY]){
	             root[rootX]=rootY;
	         }else if(rank[rootX]>rank[rootY]){
	              root[rootY]=rootX;
	         }else{
	            root[rootX]=rootY;
	            rank[rootY]+=1;
	         }
	     }
	}
	
	int find(int x){
	    if(x==root[x]){
	        return x;
	    }
	    return root[x]=find(root[x]);
	}
    class Edge implements Comparable<Edge>{
        int src,dest,weight;
        Edge(int src,int dest,int weight){
            this.weight=weight;
            this.src=src;
            this.dest=dest;
        }
        public int compareTo(Edge e){
            return this.weight-e.weight;
        }
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<Edge> arr=new ArrayList<>();
        for(int[] edge:pipes){
            arr.add(new Edge(edge[0],edge[1],edge[2]));
        }
        for(int i=1;i<=n;i++){
             arr.add(new Edge(0,i,wells[i-1]));
        }
        Collections.sort(arr);
        build(n+1);
        int sum=0;
        for(Edge edge:arr){
            if(find(edge.src)!=find(edge.dest)){
                sum+=edge.weight;
                union(edge.src,edge.dest);
            }
        }
        return sum;
    }
}