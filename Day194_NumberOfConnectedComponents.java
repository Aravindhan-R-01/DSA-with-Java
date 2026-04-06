// Number of Connected Components in an Undirected Graph:
// You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.
// Return the number of connected components in the graph.
// Example 1:
// Input:
// n = 5, edges = [[0,1],[1,2],[3,4]]
// Output: 2
// Example 2:
// Input:
// n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
// Output: 1
// Constraints:
// 1 <= n <= 2000
// 1 <= edges.length <= 5000
// edges[i].length == 2
// 0 <= aᵢ <= bᵢ < n
// aᵢ != bᵢ
// There are no repeated edges.



class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(adj, visit, node);
                res++;
            }
        }
        return res;
    }
    private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        for (int nei : adj.get(node)) if (!visit[nei]) dfs(adj, visit, nei);
    }
}
