// Reverse Nodes in K-Group:
// You are given the head of a singly linked list head and a positive integer k.
// You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. 
// If there are fewer than k nodes left, leave the nodes as they are.
// Return the modified list after reversing the nodes in each group of k.
// You are only allowed to modify the nodes' next pointers, not the values of the nodes.
// Example 1:
// Input: head = [1,2,3,4,5,6], k = 3
// Output: [3,2,1,6,5,4]
// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
// Constraints:
// The length of the linked list is n.
// 1 <= k <= n <= 100
// 0 <= Node.val <= 100


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

class Day148_ReverseNodesInK_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int group = 0;
        while (cur != null && group < k) {
            cur = cur.next;
            group++;
        }
        if (group == k) {
            cur = reverseKGroup(cur, k);
            while (group-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}
