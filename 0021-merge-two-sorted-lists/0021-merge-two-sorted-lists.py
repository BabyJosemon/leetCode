# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#We create an empty link list and create another pointer for it that tracks its end(tail). This is because at each iteration when the resultListTailPointer=resultListTailPointer.next is called the pointer will move to the current position(tail) of the list and we need to return the head which we need to remember. 
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        resultList=ListNode()#this stays as head of new list
        resultListTailPointer=resultList# this will move forward along with the list progression
        while(True):
            if(list1 is None):#if one of the lists is empty or if we have completed traversing one of the lists completely
                resultListTailPointer.next=list2
                break
            if(list2 is None):
                resultListTailPointer.next=list1
                break
                
            if(list1.val<=list2.val):
                resultListTailPointer.next=list1#the result will point to the list with smaller element
                list1=list1.next#the list itself gets shortened
            else:
                resultListTailPointer.next=list2
                list2=list2.next
            resultListTailPointer=resultListTailPointer.next#this is so that at every iteration the tail moves to next node instead of staying at the head
        return resultList.next# as the head is a dummy and has a value of None we send the next one which was the first node to be added
                
            
            