/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev, cur, temp;
        if ( head == null || head.next == null)
            return head;
        prev = head;
        cur = head.next;
        head.next = null;
        
        while(cur != null){
            temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
        }
        
        return prev;
    }
}
