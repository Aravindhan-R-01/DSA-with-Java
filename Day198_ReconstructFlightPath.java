// Reconstruct Flight Path:
// You are given a list of flight tickets tickets where tickets[i] = [from_i, to_i] represent the source airport and the destination airport.
// Each from_i and to_i consists of three uppercase English letters.
// Reconstruct the itinerary in order and return it.
// All of the tickets belong to someone who originally departed from "JFK". Your objective is to reconstruct the flight path that this person took, assuming each ticket was used exactly once.
// If there are multiple valid flight paths, return the lexicographically smallest one.
// For example, the itinerary ["JFK", "SEA"] has a smaller lexical order than ["JFK", "SFO"].
// You may assume all the tickets form at least one valid flight path.
// Example 1:
// Input: tickets = [["BUF","HOU"],["HOU","SEA"],["JFK","BUF"]]
// Output: ["JFK","BUF","HOU","SEA"]
// Example 2:
// Input: tickets = [["HOU","JFK"],["SEA","JFK"],["JFK","SEA"],["JFK","HOU"]]
// Output: ["JFK","HOU","JFK","SEA","JFK"]
// Explanation: Another possible reconstruction is ["JFK","SEA","JFK","HOU","JFK"] but it is lexicographically larger.
// Constraints:
// 1 <= tickets.length <= 300
// from_i != to_i



class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) adj.get(ticket.get(0)).add(ticket.get(1));
        List<String> res = new ArrayList<>();
        res.add("JFK");
        if (dfs("JFK", res, adj, tickets.size() + 1)) return res;
        return new ArrayList<>();
    }
    private boolean dfs(String src, List<String> res, Map<String, List<String>> adj, int targetLen) {
        if (res.size() == targetLen) return true;
        if (!adj.containsKey(src)) return false;
        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            if (dfs(v, res, adj, targetLen)) return true;
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
