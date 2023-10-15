
class Solution {
    int index ;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) 
        {
            index =0;
            return null;
        }
        head.next = removeNthFromEnd(head.next,n);
        index++;
        if(n == index)
        {
            return head.next;
        }
        return head;
    }
}
