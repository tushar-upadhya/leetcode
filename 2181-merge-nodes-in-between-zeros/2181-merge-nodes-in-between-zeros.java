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
    public ListNode mergeNodes(ListNode head) {
        ListNode originalHead = head;
        ListNode current = head.next;
        int sum = 0;

        while(current != null){
            if(current.val == 0){
                head.val = sum;
                sum = 0;

                if(current.next != null){
                    head = head.next;
                }
            }
            sum += current.val;
            current = current.next;
        }
        head.next = null;
        return originalHead;
    }
}