// Last updated: 09/06/2026, 23:28:34
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
11 /**Reversing a link list involves going through each node and pointing each one to the previous node. We will also need
12 the next node after current as well so that the iteration through the link list still continues after changing 
13 current.next to pointt to previous. This gives us 3 pointers to track.   */
14class Solution {
15    public ListNode reverseList(ListNode head) {
16      ListNode currentNode = head;
17      ListNode previousNode = null;
18      while(currentNode!=null){
19        //we need nextNode first before changing pointer so that currentNode keeps iterating
20        ListNode nextNode = currentNode.next;
21        currentNode.next = previousNode;
22        previousNode = currentNode;
23        currentNode = nextNode;
24      }
25      //at the end currentNode becomes null
26      return previousNode;  
27    }
28}