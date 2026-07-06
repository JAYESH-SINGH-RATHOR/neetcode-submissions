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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        // System.out.println(size);
        // int target = size - n + 1;
        // System.out.println("Target = " + target);
        // temp = head;
        // while(temp != null && temp.next != null){
        //     if(temp.val == target){
        //         temp.next = temp.next.next;
        //     }else{
        //         temp = temp.next;
        //     }
        // }
        // return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int target = size - n;
        temp = dummy;
        for(int i = 0; i < target; i++){
            temp = temp.next;
        }
        temp.next =  temp.next.next;
        return dummy.next;
    }
}
