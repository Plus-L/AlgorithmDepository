package examination;

import java.util.Scanner;

/**

 * 5 6 3 3
 * 1 1 1 1 1 1
 * 1 2 2 2 2 1
 * 2 3 3 1 2 2
 * 1 2 2 3 4 5
 * 5 6 6 6 3 4
 * 1 10 1
 * 1 20 1
 * 1 8 1
 */

public class Main {

    public ListNode longestList (ListNode head) {
        // write code here

        // 要求相邻两个结点的值相加为奇数，只有一种情况，一个为奇数一个为偶数
        // 那么要做的事情其实很简单，遍历，并判断是否满足一奇一偶
        // 有一个点需要注意，因为需要返回最长的链表，所以起始节点为奇和为偶数的情况都需要判断一下

        ListNode sNode = head;

        ListNode sHead = sNode;
        int sLength = 1;
        // 遍历链表，将不满足奇偶交替的结点删除
        while (sHead.next != null) {
            while ((sHead.val + sHead.next.val) % 2 == 0) {
                sHead.next = sHead.next.next;
            }
            sHead = sHead.next;
            sLength ++;
        }

        return sNode;

    }
}

