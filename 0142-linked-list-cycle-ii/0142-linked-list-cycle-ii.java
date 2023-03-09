/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        if(head == null || head.next == null){
            return null;
        }
        
        while(true){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                break;
            }else if(fast == null || fast.next == null){
                return null;
            }else{
                continue;
            }
        }
        
        ListNode temp = head;
        
        while(true){
            
            if(slow == temp){
               break;
            }
            temp = temp.next;
            slow = slow.next;
        }
        
        return temp;
    }
}