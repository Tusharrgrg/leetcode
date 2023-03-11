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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return merge(head,null);
    }
    
    public TreeNode merge(ListNode head,ListNode tail){
        if(head == tail){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow= slow.next;
        }
        
        
        TreeNode thead = new TreeNode(slow.val);
        thead.left = merge(head,slow);
        thead.right = merge(slow.next, tail);
        return thead;
    }
}