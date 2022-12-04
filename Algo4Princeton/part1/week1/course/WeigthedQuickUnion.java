package Algo4Princeton.part1.week1.course;

/**
 * @program: AlgorithmDepository
 * @description: 加权快速合并（be weight rather than tall）
 * @author: PlusL
 * @create: 2022-11-30 20:10
 **/
public class WeigthedQuickUnion {

    private int[] id;
    private int[] sz;

    public WeigthedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N;i ++) {
            id[i] = i;
            sz[i] = 1;
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
        if (i == j) return;
        if  (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else                { id[j] = i; sz[i] += sz[j]; }
    }

}
