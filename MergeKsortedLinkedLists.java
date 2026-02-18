// Merge K Sorted Linked Lists:
// You are given an array of k linked lists lists, where each list is sorted in ascending order.
// Return the sorted linked list that is the result of merging all of the individual linked lists.
// Example 1:
// Input: lists = [[1,2,4],[1,3,5],[3,6]]
// Output: [1,1,2,3,3,4,5,6]
// Example 2:
// Input: lists = []
// Output: []
// Example 3:
// Input: lists = [[]]
// Output: []
// Constraints:
// 0 <= lists.length <= 1000
// 0 <= lists[i].length <= 100
// -1000 <= lists[i][j] <= 1000


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class MergeKsortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        ListNode res = new ListNode(0);
        ListNode cur = res;
        for (ListNode lst : lists) {
            while (lst != null) {
                nodes.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(nodes);
        for (int node : nodes) {
            cur.next = new ListNode(node);
            cur = cur.next;
        }
        return res.next;
    }
}
