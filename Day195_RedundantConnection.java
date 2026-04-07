// Redundant Connection:
// You are given a connected undirected graph with n nodes labeled from 1 to n. Initially, it contained no cycles and consisted of n-1 edges.
// We have now added one additional edge to the graph. The edge has two different vertices chosen from 1 to n, and was not an edge that previously existed in the graph.
// The graph is represented as an array edges of length n where edges[i] = [ai, bi] represents an edge between nodes ai and bi in the graph.
// Return an edge that can be removed so that the graph is still a connected non-cyclical graph. If there are multiple answers, return the edge that appears last in the input edges.
// Example 1:
// Input: edges = [[1,2],[1,3],[3,4],[2,4]]
// Output: [2,4]
// Example 2:
// Input: edges = [[1,2],[1,3],[1,4],[3,4],[4,5]]
// Output: [3,4]
// Constraints:
// n == edges.length
// 3 <= n <= 100
// 1 <= edges[i][0] < edges[i][1] <= edges.length
// There are no repeated edges and no self-loops in the input.



class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
    parent = new int[edges.length + 1];
    rank = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int []edge:edges){
            if(!merge(edge)) return edge;
        }
        return new int[0];
    }
    private int find(int node){
       if(parent[node]==node) return node;
       return find(parent[node]);
    }
    private boolean merge(int[]edge){
        int p1 = find(edge[0]);
        int p2 = find(edge[1]);
        if(p1==p2)return false;
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
            rank[p1] = rank[p1]+rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2] = rank[p1]+rank[p2];
        }
        return true;
    }
}
