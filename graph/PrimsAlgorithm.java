import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
provide this input
9
0 1 4
0 7 8
1 7 11
1 2 8
2 8 2
2 3 7
2 5 4
3 4 9
3 5 14
4 5 10
5 6 2
6 7 1
6 8 6
7 8 7
done
     */
public class PrimsAlgorithm {
    static class Edge {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        int V = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the edge,source,target,cost");
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        String line;
        while (!"done".equals(line=bufferedReader.readLine())){
            String[] split = line.split("\\s++");
            graph.get(Integer.parseInt(split[0])).
                    add(new Edge(Integer.parseInt(split[1]),
                            Integer.parseInt(split[2])));
            graph.get(Integer.parseInt(split[1])).
                    add(new Edge(Integer.parseInt(split[0]),
                            Integer.parseInt(split[2])));
        }
        primsMST(graph);
    }

    static void primsMST(List<List<Edge>> graph) {
        int V = graph.size();
        int cost[] = new int[V];
        int parent[] = new int[V];
        boolean visited[] = new boolean[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        parent[0] = -1;
        int totalCost=0;
        for (int i = 0; i < V-1; i++) {
            int u=findMinEdgeVertex(cost,visited);
            visited[u]=true;
            if(parent[u]!=-1){
                totalCost+=cost[u];
            }
            for(Edge edge:graph.get(u)) {
                if (!visited[edge.target] && edge.cost < cost[edge.target]) {
                    cost[edge.target] = edge.cost;
                    parent[edge.target] = u;
                }
            }
        }
        primsMST(parent,cost);
    }

    private static void primsMST(int[] parent, int[] cost) {
        int totalCost=0;
        for(int i=1;i<parent.length;i++){
            System.out.println(parent[i]+"->"+i);
            totalCost+=cost[i];
        }
        System.out.println("total cost="+totalCost);
    }

    private static int findMinEdgeVertex(int[] cost, boolean[] visited) {
        int minValue=Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i=0;i<cost.length;i++){
            if(!visited[i] && cost[i]<minValue){
                minValue=cost[i];
                minIndex=i;
            }
        }
        return  minIndex;
    }
}
