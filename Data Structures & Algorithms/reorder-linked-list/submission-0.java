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
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secoundhalf = reverse(slow.next);
    // ye line mid ke bad wale sare element ko ek alag part me divide kr rhi hai
         slow.next = null; 
        ListNode firsthalf = head;
        while(secoundhalf != null){
            ListNode temp1 = firsthalf.next;
            ListNode temp2 = secoundhalf.next;
            firsthalf.next = secoundhalf;
            secoundhalf.next = temp1;
            firsthalf = temp1;
            secoundhalf = temp2;
        }
    }
    ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
