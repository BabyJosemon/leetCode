// Last updated: 16/06/2026, 23:26:21
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
11/**This question also uses one of the 3 operations on link list. But requires the intuition that there is an expected
12 order of the solution and this is like merging two link lists. The two link lists here being the first half of the 
13 link list and the reversed second half of the list. So in 1,2,3,4,5 the merge is between 1,2,3 and 5,4. In merging 
14 practice we were sorting by smallest and that was the pattern there, here the pattern is that there is a particular 
15 order of nodes expected. And that order was explained above. To do this merge first we need to : 
16 1) Find the middle node (fast slow)
17 2) Reverse the link list from mid to end in place. 1->2->3<-4<-5
18 3) In place merge by using two pointers left and right and iterate after making each point to correct nodes.*/
19class Solution {
20    public void reorderList(ListNode head) {
21        //edge case empty or single node linklist
22        if (head == null || head.next == null) {
23            return;
24        }
25        //finding middle
26        ListNode fast = head, slow = head;
27        while (fast != null && fast.next != null) {
28            fast = fast.next.next;
29            slow = slow.next;
30        }
31        //slow is at mid, now reverse from slow
32        ListNode currentNode = slow;
33        ListNode previousNode = null;
34        while (currentNode != null) {
35            ListNode nextNode = currentNode.next;
36            currentNode.next = previousNode;
37            previousNode = currentNode;
38            currentNode = nextNode;
39        }
40        //now previousNode is at the end of linklist = 1->2->3<-4<-5
41        //now we merge using 2 pointers;
42        ListNode leftNode = head;
43        ListNode rightNode = previousNode;
44        while (rightNode.next != null) {
45            //pointing 1 to 5
46            ListNode tempNode = leftNode.next;
47            leftNode.next = rightNode;
48            leftNode = tempNode;
49            //pointing 5 to 2, leftNode is at 2 rn
50            tempNode = rightNode.next;
51            rightNode.next = leftNode;
52            rightNode = tempNode;
53        }
54    }
55}