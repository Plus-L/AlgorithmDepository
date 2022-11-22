package Sort;

import common.Node;

public class InsertSort_LinkedList {

    public void InsertSort(Node root) {
        Node p,q,r,u;
        p = root.next;
        while(p.next != null) {//
            r = root;
            q = root.next;
            while(q.next != null && q.val <= p.val) {//
                r = q;
                q = q.next;
            }

            u = p.next;
            p.next = r;//
            ;//
            p = u;
        }
    }

}