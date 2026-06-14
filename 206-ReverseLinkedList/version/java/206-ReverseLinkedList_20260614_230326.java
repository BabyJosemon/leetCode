// Last updated: 14/06/2026, 23:03:26
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
11/** 
12Remember list1 and list2 are head nodes of the link lists and not the lists itself
13If either list is empty, return the other. We first need to find the head of new link list. It will be the smaller
14of both list1 starting values, and based on that iterate that link list forward. Once we have the head, we set 
15currentNode to it and then iterate through both the lists and set the value of currentNode.next as whichever has the 
16smaller value and then iterate that list. Keep moving currentNode. As soon as one of the lists get empty we get out of
17the loop and we simply set current.next to whichever list that still has values left. At the end return the head that 
18we found at the start.
19
20OR
21
22There is an much better solution, you will notice that the logic to find the head of the merged list is the same as 
23the logic for finding the next node to append in the merged list. We did it to get a starting point for the merged
24list. We can avoid this by using a DUMMY node which will also act as a starting point and when the iteration finishes we
25return dummy.next as the head of the merged linked list. */
26// class Solution {
27//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
28//         //Should be mergeTwoLists(ListNode head1, ListNode head2)
29//         if (list1 == null)
30//             return list2;
31//         if (list2 == null)
32//             return list1;
33//         ListNode head;
34//         if (list1.val < list2.val) {
35//             head = list1;
36//             list1 = list1.next;
37//         } else {
38//             head = list2;
39//             list2 = list2.next;
40//         }
41//         ListNode currentNode = head;
42//         while (list1 != null && list2 != null) {
43//             if (list1.val < list2.val) {
44//                 currentNode.next = list1;
45//                 list1 = list1.next;
46//             } else {
47//                 currentNode.next = list2;
48//                 list2 = list2.next;
49//             }
50//             currentNode = currentNode.next;
51//         }
52//         //Now either list1 still has elements left of list2
53//         currentNode.next = (list1 != null) ? list1 : list2;
54//         return head;
55//     }
56// }
57class Solution {
58    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
59        ListNode dummy = new ListNode();
60        ListNode current = dummy;
61        while (list1 != null && list2 != null) {
62            if (list1.val < list2.val) {
63                current.next = list1;
64                list1 = list1.next;
65            } else {
66                current.next = list2;
67                list2 = list2.next;
68            }
69            current = current.next;
70        }
71        current.next = (list1 != null) ? list1 : list2;
72        return dummy.next;
73    }
74}