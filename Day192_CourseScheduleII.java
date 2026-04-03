// Course Schedule II:
// You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
// Return a valid ordering of courses you can take to finish all courses. If there are many valid answers, return any of them. If it's not possible to finish all courses, return an empty array.
// Example 1:
// Input: numCourses = 3, prerequisites = [[1,0]]
// Output: [0,1,2]
// Explanation: We must ensure that course 0 is taken before course 1.
// Example 2:
// Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]
// Output: []
// Explanation: It's impossible to finish all courses.
// Constraints
// 1 <= numCourses <= 1000
// 0 <= prerequisites.length <= 1000
// All prerequisite pairs are unique.



class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int finish = 0;
        int[] output = new int[numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            output[numCourses - finish - 1] = node;
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.add(nei);
            }
        }
        if (finish != numCourses) return new int[0];
        return output;
    }
}
