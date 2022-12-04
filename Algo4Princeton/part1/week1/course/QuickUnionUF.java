package Algo4Princeton.part1.week1.course;

/**
 * @program: AlgorithmDepository
 * @description: As the name -- QuickUnion
 * @author: PlusL
 * @create: 2022-11-30 19:35
 **/
public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N;i ++) {
            id[i] = i;
        }
    }

    private int root(int index) {
        // 当前下标不等于其存储元素，意味着他的元素被修改过，也就是他并不是根节点（根节点元素不会被修改）
        while (index != id[index]) index = id[index];
        return index;
    }

    public Boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

}
