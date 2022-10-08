package examination;


import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode longestList (ListNode head) {
        // write code here

        // 要求相邻两个结点的值相加为奇数，只有一种情况，一个为奇数一个为偶数
        // 那么要做的事情其实很简单，遍历，并判断是否满足一奇一偶
        // 有一个点需要注意，因为需要返回最长的链表，所以起始节点为奇和为偶数的情况都需要判断一下

        ListNode sNode = head;
        ListNode rNode = head;
        // head为偶
        ListNode temp = head;
        if (head.val % 2 == 0) {
            while (temp.next != null) {
                if (temp.val % 2 == 1) {
                    sNode = head;
                } else {
                    temp = temp.next;
                }
            }
        } else {
            while (temp.next != null) {
                if (temp.val % 2 == 0) {
                    rNode = head;
                } else {
                    temp = temp.next;
                }
            }
        }

        ListNode sHead = sNode;
        ListNode rHead = rNode;
        int sLength = 1;
        int rLength = 1;
        // 遍历链表，将不满足奇偶交替的结点删除
        while (sHead.next != null) {
            while ((sHead.val + sHead.next.val) % 2 == 0) {
                sHead.next = sHead.next.next;
            }
            sHead = sHead.next;
            sLength ++;
        }

        while (rHead.next != null) {
            while ((rHead.val + rHead.next.val) % 2 == 0) {
                rHead.next = rHead.next.next;
            }
            rHead = rHead.next;
            rLength ++;
        }

        if (sLength == rLength) {
            return sNode;
        } else if (sLength < rLength) {
            return rNode;
        } else {
            return sNode;
        }

    }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
