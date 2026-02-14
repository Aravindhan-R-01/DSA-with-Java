// Copy Linked List with Random Pointer:
// You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
// Create a deep copy of the list.
// The deep copy should consist of exactly n new nodes, each including:
// The original value val of the copied node
// A next pointer to the new node corresponding to the next pointer of the original node
// A random pointer to the new node corresponding to the random pointer of the original node
// Note: None of the pointers in the new list should point to nodes in the original list.
// Return the head of the copied linked list.
// In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node 
// (0-indexed) that the random pointer points to, or null if it does not point to any node.
// Example 1:
// Input: head = [[3,null],[7,3],[4,0],[5,1]]
// Output: [[3,null],[7,3],[4,0],[5,1]]
// Example 2:
// Input: head = [[1,null],[2,2],[3,2]]
// Output: [[1,null],[2,2],[3,2]]
// Constraints:
// 0 <= n <= 100
// -100 <= Node.val <= 100
// random is null or is pointing to some node in the linked list.


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node l1 = head;
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }
        Node newHead = head.next;
        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }
        l1 = head;
        while (l1 != null) {
            Node l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return newHead;
    }
}
