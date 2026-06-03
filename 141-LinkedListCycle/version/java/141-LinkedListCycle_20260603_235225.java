// Last updated: 03/06/2026, 23:52:25
1/**Use fast slow pointers that we used to find middle of link list. When fast moves twice the speed of slow eventually fast and slow will meet. If they meet, we have a cycle. Else Not */
2/**
3 * Definition for singly-linked list.
4 * class ListNode {
5 *     int val;
6 *     ListNode next;
7 *     ListNode(int x) {
8 *         val = x;
9 *         next = null;
10 *     }
11 * }
12 */
13public class Solution {
14    public boolean hasCycle(ListNode head) {
15        ListNode fast = head;
16        ListNode slow = head;
17        while(fast!=null && fast.next!=null){
18            fast=fast.next.next;
19            slow=slow.next;
20            if(fast==slow){
21                return true;
22            }
23        }
24        return false;
25    }
26}