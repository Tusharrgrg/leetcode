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

    ListNode headNode;
    int l=0;

   public Solution(ListNode head) {
        headNode=head;
        ListNode temp=headNode;
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        
    }
    
    public int getRandom() {
        double r=Math.random()*l;
        ListNode temp=headNode;
        for(int i=0;i<(int)r;i++){
            temp=temp.next;
        }
        return temp.val;
      
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */