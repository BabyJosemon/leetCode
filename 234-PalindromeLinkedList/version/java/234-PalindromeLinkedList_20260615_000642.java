// Last updated: 15/06/2026, 00:06:42
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
11 /**This problem has two ways of solving it and both have tradeoffs.
12 Option 1:
13 We iterate through the link list and store each value in a arraylist. Then use left-right 2 pointers to detect
14  palindrome. We can also use list.reverse(). This option gives us O(n) time and space complexity because we iterate
15  through the whole array and we uses another data structure of the same size.*/
16// class Solution {
17//     public boolean isPalindrome(ListNode head) {
18//         ArrayList<Integer> listOfValues = new ArrayList<>();
19//         ListNode currentNode = head;
20//         while(currentNode!=null){
21//             listOfValues.add(currentNode.val);
22//             currentNode = currentNode.next;
23//         }
24//         int left = 0;
25//         int right = listOfValues.size()-1;
26//         while(left<right){
27//             if(listOfValues.get(left)!=listOfValues.get(right)){
28//                 return false;
29//             }
30//             left++;
31//             right--;
32//         }
33//         return true;
34//     }
35// }
36/**Option 2: 
37Notice that in the case of odd number of elements, the nodes are same from the middle node onwards. This is same
38 for even number of elements as well. So, Instead of using another datastructure we could first find the middle of 
39 the linklist, we did this using fast-slow pointers. Then from the middle node onwards we reverse the link list to the 
40 end. This involves previous,current,next pointers. Once we havedone that we can use left-right pointer approach as 
41 before to detect palindrome. prev will be at end after reverse. This still uses O(n) time complexity because we are
42 iterating through the whole link list but space is O(1) since we are not using any new datastructures. This is an 
43 optimisation but generally Option 1 is always preferred, this is because option 2 involves modifying the input which
44 is frowned upon. Unless we undo the reversing at the end OR interviewer asks do not do Option 2.*/
45 class Solution {
46    public boolean isPalindrome(ListNode head) {
47        if(head ==null || head.next == null){
48            return true;
49        }
50        //Finding mid
51        ListNode fast = head;
52        ListNode slow = head;
53        while(fast!=null && fast.next!=null){
54            fast = fast.next.next;
55            slow = slow.next;
56        }
57        //slow is mid, now reverse from there.
58        ListNode current = slow;
59        ListNode previous = null;
60        while(current!=null){
61            ListNode next = current.next;
62            current.next = previous;
63            previous = current;
64            current = next;
65        }
66        //Once reversed use left-right to check palindrome
67        ListNode left = head;
68        ListNode right = previous;
69        while(right!=null){
70            //the while loop here is different than regular left-right pointer question (where left<right) because we
71            //cannot compare Nodes like that and also the middle pointer point to null after we reversed. So we are
72            //checking when right!=null. We check right because in cases of even number of elements eg 4 mid is element
73            //3 and when left and right both reach 2 and 3 positions, left.next will still be 3 but right.next will be
74            //null first.
75            if(left.val != right.val){
76                return false;
77            }
78            left = left.next;
79            right = right.next;
80        }
81        return true;
82    }
83 }