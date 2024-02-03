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
    public ListNode reverseKGroup(ListNode head, int k) {
        int total = 0;
        ListNode current = head;
        
        while(current != null){
            total++;
            current = current.next;
        }
        int count = 0;
        ListNode prev = null;
        ListNode c = head;
        ListNode next = null;
        
        while(c != null && count < k){
            next = c.next;
            c.next = prev;
            prev = c;
            c = next;
            count++;
        }
        total -= k;
        if(total >= k){
            head.next = reverseKGroup(next, k);
        }else{
            head.next = next;
        }
        return prev;
    }
}