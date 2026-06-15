// Last updated: 16/06/2026, 00:13:28
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
11/**Again link list problems boil down to either 
121) Fast Slow Pointers or Two pointers (eg. Cycles, middle element)
132) Reversing a link list
143) Merging two link lists.
15Here while we need to find the nth element from behind. What we actually need to find is the node directly before it.
16 This is because to remove an element we just need to point its previous element to the element next to the element to
17be deleted. So for the 2nd element from last, we need to find the 3rd element from the last. There are two ways to do:
181) Traverse the whole link list, find the length of link list. And then length-n-1 is the index of the element before
19the element to remove. So in first eg. 5-2-1 = 2. But for the special case of head node eg when n=5 this formula will
20not work. So Instead if lenght=n then we know we are being asked to delete head so just return head.next.
212) Using two pointers where the fast node gets a head start by n and then both fast and slow move one at a time. By the
22time fast reaches last node, slow will be at the node before the node to be deleted. But here as well if we move fast 
23at the start if fast is null after advancing n nodes, we know that n is equal to the length of the list, and we
24can remove the head node by returning head.next directly.
25
26An optimisation can be done to both these methods because just like merge link list question where we see that we have 
27to address the special situation of head we can improve by using a dummy node.*/
28// class Solution {
29//     public ListNode removeNthFromEnd(ListNode head, int n) {
30//         ListNode current = head;
31//         int length = 0;
32//         while (current != null) {
33//             current = current.next;
34//             length++;
35//         }
36//         //special case for head
37//         if (length == n) {
38//             return head.next;
39//         }
40//         current = head;
41//         for (int i = 0; i < length - n - 1; i++) {
42//             current = current.next;
43//         }
44//         current.next = current.next.next;
45//         return head;
46//     }
47// }
48// class Solution {
49//     public ListNode removeNthFromEnd(ListNode head, int n) {
50//         ListNode fast = head, slow = head;
51//         for(int i = 0; i< n; i++){
52//             fast=fast.next;
53//         }
54//         //special case for head
55//         if(fast==null){
56//             return head.next;
57//         }
58//         while(fast.next!=null){
59//             fast=fast.next;
60//             slow=slow.next;
61//         }
62//         slow.next=slow.next.next;
63//         return head;
64//     }
65// }
66class Solution {
67    public ListNode removeNthFromEnd(ListNode head, int n) {
68        ListNode dummy = new ListNode(0);
69        dummy.next = head;
70        ListNode fast = dummy, slow = dummy;
71        for (int i = 0; i < n; i++) {
72            fast = fast.next;
73        }
74        while (fast.next != null) {
75            fast = fast.next;
76            slow = slow.next;
77        }
78        slow.next = slow.next.next;
79        return dummy.next;
80    }
81}