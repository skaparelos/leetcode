public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode extra = new ListNode(-1);
        extra.next = head;
        head = extra;
        ListNode b = head, m = head.next, f = head.next.next;
        int ctr = 0;
        while(f != null){
            if (ctr%2 == 0){
                ListNode t = f.next;
                f.next = m;
                m.next = t;
                b.next = f;
                f = m;
                m = b.next;
            }
            b = b.next;
            m = m.next;
            f = f.next;
            ctr++;
        }
        
        return head.next;
    }
}
