// Min Cost to Connect Points:
// You are given a 2-D integer array points, where points[i] = [xi, yi]. Each points[i] represents a distinct point on a 2-D plane.
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between the two points, i.e. |xi - xj| + |yi - yj|.
// Return the minimum cost to connect all points together, such that there exists exactly one path between each pair of points.
// Example 1:
// Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]
// Output: 10
// Constraints:
// 1 <= points.length <= 1000
// -1,000,000 <= xi, yi <= 1,000,000
// All pairs (xi, yi) are distinct.



class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int node = 0;
        int res = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        int edges = 0;
        while(edges<n-1){
            visited[node] = true;
            int nextNode = -1;
            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                int curDist = Math.abs(points[node][0]-points[i][0])+Math.abs(points[node][1] - points[i][1]);
                dist[i]=Math.min(dist[i],curDist);
                if(nextNode == -1 || dist[i] < dist[nextNode]){
                    nextNode = i;
                }
            }
            res=res+dist[nextNode];
            node = nextNode;
            edges++;
        }
        return res;
    }
}
