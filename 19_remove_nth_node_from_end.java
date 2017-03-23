public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null ) return null; 
        ListNode cur = head, nFront = head;
        while(n-- > 0 && nFront != null) nFront = nFront.next;
        if (nFront == null) return head.next;
        while(nFront.next != null){
            cur = cur.next;
            nFront = nFront.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
