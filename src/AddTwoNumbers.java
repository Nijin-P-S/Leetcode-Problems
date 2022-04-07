/*
You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

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

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer carry = 0;
        ListNode sum = new ListNode();
        ListNode head = null;
        ListNode tail = null;
        while(l1!=null && l2!=null){
            if(head==null){
                sum.val = (l1.val+l2.val)%10;
                carry = (l1.val+l2.val)/10;
                head = sum;
                tail = sum;
                l1=l1.next;
                l2 = l2.next;
            }
            else{
                ListNode node = new ListNode();
                node.val = (l1.val+l2.val+carry)%10;
                carry = (l1.val+l2.val+carry)/10;
                tail.next = node;
                tail = node;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            while(l1!=null){
                ListNode node = new ListNode();
                node.val = (l1.val+carry)%10;
                carry = (l1.val+carry)/10;
                tail.next = node;
                tail = node;
                l1 = l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
                ListNode node = new ListNode();
                node.val = (l2.val+carry)%10;
                carry = (l2.val+carry)/10;
                tail.next = node;
                tail = node;
                l2 = l2.next;
            }
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail=node;
        }
        return head;
    }
}
