// Last updated: 08/06/2026, 23:17:14
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11 /**Fast Slow pointer problem where we find the middle by running the fast pointer at twice the speed of slow pointer.
12 When fast pointer finishes running, slow pointer will be at the middle node. To delete we need another node that keeps
13 track of the node before slowNode. So we set it to slowNode in the loop before slowNode is iterated. This way it is 
14 always one step behind slowNode. For normal situations returning the original head should be fine, but in situations
15 where the linklist only has 1 element we just return null raw. */
16class Solution {
17    public ListNode deleteMiddle(ListNode head) {
18        if(head.next==null){
19            return null;
20        }
21        ListNode fastNode=head;
22        ListNode slowNode=head;
23        ListNode previousNode=head;
24        while(fastNode!=null && fastNode.next!=null){
25            fastNode=fastNode.next.next;
26            previousNode=slowNode;
27            slowNode=slowNode.next;
28        }
29        previousNode.next=slowNode.next;
30        return head;
31    }
32}