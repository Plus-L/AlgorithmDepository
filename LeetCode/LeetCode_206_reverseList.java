package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: leetcode206. 反转链表
 * @author: PlusL
 * @create: 2022-08-30 22:15
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class LeetCode_206_reverseList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        ListNode head = new ListNode(scanner.nextInt());
        ListNode temp = head;

        for (int i = 1; i < count; i++) {
            temp.next = new ListNode(scanner.nextInt());
            temp = temp.next;
        }

        reverse(head);
    }

    // 定义：输入一个单链表头结点，将该链表反转，返回新的头结点
    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}
