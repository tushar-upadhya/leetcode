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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int arr[]= new int[2];
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] {-1, -1};
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        int index = 2;
        int greater = -1;
        int min = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        
        while (third != null) {
            if ((second.val > first.val && second.val > third.val) || (second.val < first.val && second.val < third.val)) {
                if (greater != -1) {
                    int diff = index - greater;
                    if (minDistance > diff) {
                        minDistance = diff;
                    }
                }
                greater = index;
                if (min > greater) {
                    min = greater;
                }
            }
            index++;
            first = first.next;
            second = second.next;
            third = third.next;
        }
        arr[0] = minDistance == Integer.MAX_VALUE ? -1 : minDistance;
        arr[1] = (min == Integer.MAX_VALUE || min == greater) ? arr[0] : greater - min;
        return arr;
    }
}