import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DijkshtrasAlgorithm {
    static class Vertice<T> {
        T target;
        int cost;

        public Vertice(T target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        int V = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the edge Info As ,<source> <target> <cost>. Enter done if all edges are entered");
        Map<String,List<Vertice<String>>> graph = new HashMap<>();
//        for (int i = 0; i < V; i++) {
//            graph.add(new ArrayList<>());
//        }
        String line;
        while (!"done".equals(line=bufferedReader.readLine())){
            String[] split = line.split("\\s++");
            graph.computeIfAbsent(split[0],(a)-> new ArrayList<>()).
                    add(new Vertice(split[1],
                            Integer.parseInt(split[2])));
            graph.computeIfAbsent(split[1],(a)-> new ArrayList<>()).
                    add(new Vertice(split[0],
                            Integer.parseInt(split[2])));
        }
        System.out.println("Enter the source for the shortest path");
        String source=bufferedReader.readLine();
        findShorttestPath(source,graph);
    }

    private static void findShorttestPath(String source, Map<String,List<Vertice<String>>> graph) {
        PriorityQueue<Vertice> priorityQueue=new PriorityQueue<>();
        Map<String,String> parentMap=new HashMap<>(graph.size());
        parentMap.put(source,source);
        Map<String,Boolean> visited=new HashMap<>(graph.size());
        Map<String,Integer> distanceMap=new HashMap<>(graph.size());
        for(String vertices:graph.keySet()){
            visited.put(vertices,false);
            if(!vertices.equals(source)) {
                priorityQueue.add(new Vertice(vertices, Integer.MAX_VALUE));
                distanceMap.put(vertices,Integer.MAX_VALUE);
            }
            else{
                priorityQueue.add(new Vertice(0,0));
                distanceMap.put(vertices,0);
            }
        }
        parentMap.put(source,source);
        while (!priorityQueue.isEmpty()){
            Vertice<String> vertice = priorityQueue.poll();
            visited.put(vertice.target,true);
            for (Vertice<String> vert : graph.get(vertice.target)) {
                if(!visited.get(vert.target) && vert.cost<distanceMap.get(vert));
            }
        }
    }
}
