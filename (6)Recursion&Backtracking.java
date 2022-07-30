/* Question1 ==> Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Time Complexity ==> O(n) */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start=new ListNode(0);
        recursion(list1,list2,start);
        return start.next;
    }
    public void recursion(ListNode l1,ListNode l2, ListNode d){
        if(l1==null){
            d.next=l2;
            return;
        }
        if(l2==null){
            d.next=l1;
            return;
        }
        if(l1.val<=l2.val){
            d.next=l1;
            recursion(l1.next,l2,d.next);
            return;
        }
        else{
            d.next=l2;
            recursion(l1,l2.next,d.next);
            return;
        }
    }
}

/* Question2 ==> Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Time Complexity ==> O(n) */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode newNext=reverseList(head.next);
        ListNode headNext=head.next;
        headNext.next=head;
        head.next=null;
        return newNext;
    }
    
}
