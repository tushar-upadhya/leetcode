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

    private ListNode helper(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val > list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode result = list1;

        while(list1 != null && list2 != null){
            ListNode temp = list1;

            while(list1 != null && list1.val <= list2.val){
                temp = list1;
                list1 = list1.next;
            }

            temp.next = list2;

            temp = list1;
            list1 = list2;
            list2 = temp;
        }
        return result;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if(n == 0){
            return null;
        }

        if(n == 1){
            return lists[0];
        }

        ListNode result = lists[0];

        for(int i=1;i<n;++i){
            result = helper(result, lists[i]);
        }
        return result;
    }
}