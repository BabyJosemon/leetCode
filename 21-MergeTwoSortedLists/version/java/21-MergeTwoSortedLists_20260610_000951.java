// Last updated: 10/06/2026, 00:09:51
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
11 /** If either list is empty, return the other. We first need to find the head of new link list. It will be the smaller
12 of both list1 starting values, and based on that iterate that link list forward. Once we have the head, we set 
13 currentNode to it and then iterate through both the lists and set the value of currentNode.next as whichever has the 
14 smaller value and then iterate that list. Keep moving currentNode. As soon as one of the lists get empty we get out of
15 the loop and we simply set current.next to whichever list that still has values left. At the end return the head that 
16 we found at the start. */
17class Solution {
18    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
19        //Should be mergeTwoLists(ListNode head1, ListNode head2)
20        if(list1 == null) return list2;
21        if(list2 == null) return list1;
22        ListNode head;
23        if(list1.val<list2.val){
24            head = list1;
25            list1 = list1.next;
26        }else{
27            head = list2;
28            list2 = list2.next;
29        }
30        ListNode currentNode = head;
31        while(list1!=null && list2!=null){
32            if(list1.val<list2.val){
33                currentNode.next = list1;
34                list1 = list1.next;
35            }else{
36                currentNode.next = list2;
37                list2 = list2.next;
38            }
39            currentNode = currentNode.next;
40        }
41        //Now either list1 still has elements left of list2
42        currentNode.next = (list1!=null)? list1:list2;
43        return head;
44    }
45}