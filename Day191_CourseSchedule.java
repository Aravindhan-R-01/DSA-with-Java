// Course Schedule:
// You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
// The pair [0, 1], indicates that must take course 1 before taking course 0.
// There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
// Return true if it is possible to finish all courses, otherwise return false.
// Example 1:
// Input: numCourses = 2, prerequisites = [[0,1]]
// Output: true
// Explanation: First take course 1 (no prerequisites) and then take course 0.
// Example 2:
// Input: numCourses = 2, prerequisites = [[0,1],[1,0]]
// Output: false
// Explanation: In order to take course 1 you must take course 0, and to take course 0 you must take course 1. So it is impossible.
// Constraints:
// 1 <= numCourses <= 1000
// 0 <= prerequisites.length <= 1000
// prerequisites[i].length == 2
// 0 <= a[i], b[i] < numCourses
// All prerequisite pairs are unique.



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        int count =0;
        for(int i =0;i<numCourses;i++) if(indegree[i]==0) queue.offer(i);
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int neighbours : graph.get(node)){
                indegree[neighbours]--;
                if(indegree[neighbours]==0) queue.offer(neighbours);
            }
        }
        return count==numCourses;
    }
}
