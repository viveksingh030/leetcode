import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//input
//0 1
//1 2
//1 4
//1 5
//2 3
//2 6
//3 2
//3 7
//4 0
//4 5
//5 6
//6 5
//6 7
//7 7
//done
public class StronglyConnectedComponent {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        int V = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the edge,source,target,cost");
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        String line;
        while (!"done".equals(line = bufferedReader.readLine())) {
            String[] split = line.split("\\s++");
            graph.get(Integer.parseInt(split[0])).
                    add(Integer.parseInt(split[1]));
        }
        List<List<Integer>> stronglyConnectedComponent = new StronglyConnectedComponent().findStronglyConnectedComponent(graph);
        printStronglyConnectedComponent(stronglyConnectedComponent);
    }

    private static void printStronglyConnectedComponent(List<List<Integer>> stronglyConnectedComponent) {
        for (List<Integer> component : stronglyConnectedComponent) {
            System.out.println(component);
        }
    }

    private List<List<Integer>> findStronglyConnectedComponent(List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(i, graph, stack, visited);
            }
        }
        Arrays.fill(visited, false);
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> transposeGraph = reverseGraph(graph);
        while (!stack.isEmpty()) {
            int vertice=stack.pop();
            if (!visited[vertice]) {
                List<Integer> component = new ArrayList<>();
                dfsForStronglyConnectedComponent(vertice, transposeGraph, component, visited);
                res.add(component);
            }
        }
        return res;
    }

    private void dfsForStronglyConnectedComponent(int vertice, List<List<Integer>> transposeGraph, List<Integer> component, boolean[] visited) {
        visited[vertice] = true;
        component.add(vertice);
        for (int target : transposeGraph.get(vertice)) {
            if (!visited[target]) {
                dfsForStronglyConnectedComponent(target, transposeGraph, component, visited);
            }
        }
    }

    private List<List<Integer>> reverseGraph(List<List<Integer>> graph) {
        List<List<Integer>> transposeGraph = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            transposeGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.size(); i++) {
            for (int target : graph.get(i)) {
                transposeGraph.get(target).add(i);
            }
        }
        return transposeGraph;
    }

    private void dfs(int source, List<List<Integer>> graph, Stack<Integer> stack, boolean[] visited) {
        visited[source] = true;
        for (int target : graph.get(source)) {
            if (!visited[target]) {
                dfs(target, graph, stack, visited);
            }
        }
        stack.push(source);
    }

}
