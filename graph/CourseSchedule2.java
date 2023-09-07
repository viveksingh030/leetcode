import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[]=new int[numCourses];
        int []indegree=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]+=1;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
     int i = 0;
    // Process until the Q becomes empty
    while (!queue.isEmpty()) {
      int node = queue.remove();
      res[i++] = node;

      // Reduce the in-degree of each neighbor by 1
        for (Integer neighbor : graph.get(node)) {
          indegree[neighbor]--;

          // If in-degree of a neighbor becomes 0, add it to the Q
          if (indegree[neighbor] == 0) {
            queue.add(neighbor);
          }
      }
    }
        if(i==numCourses){
             return res;
        }
       return new int[]{};
    }
}