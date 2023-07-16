import java.util.*;

class TopoSort {
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Deque<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < adj.size(); i++) {
            if (visited.get(i) == null) {
                dfs(i, adj, visited, queue);
            }
        }
        return queue.stream().mapToInt(a -> a.intValue()).toArray();
    }

    static void dfs(int src, ArrayList<ArrayList<Integer>> adj, Map<Integer, Boolean> visited, Deque<Integer> topo) {
        visited.put(src, true);
        for (int target : adj.get(src)) {
            if (visited.get(target) == null) {
                dfs(target, adj, visited, topo);
            }
        }
        topo.offerFirst(src);
    }
}
