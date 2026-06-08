// Last updated: 08/06/2026, 21:52:56
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) { val = x; }
7 * }
8 */
9 /**This is a weird question but basically since you are not given the head, you can only use the current node. Deleting
10 a node is the same as changing its pointers. So for the node to be deleted, first change its identity (value) to the
11 node next to it. 4->5->1->9 becomes 4->1->1->9. now we have 2 same nodes but we have essentially removed 5
12 .And now to reduce the size of the link list we just remove the duplicate. Since we only have access to one node and 
13 we have copied the next node's value into it, the next node can be deleted. To do that, just point node.next to 
14 node.next.next. This make 4->1->9  */
15class Solution {
16    public void deleteNode(ListNode node) {
17        node.val=node.next.val;
18        node.next=node.next.next;
19    }
20}