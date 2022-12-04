package Algo4Princeton.part1.week1.course;

/**
 * @program: AlgorithmDepository
 * @description: 并查集
 * @author: PlusL
 * @create: 2022-11-30 19:05
 **/
public class QuickFindUF {

    private int[] id;

    /**
     * init QuickFindUF by capacity N
     * @param N capacity
     */
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public Boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        // 循环遍历id数组，将所有目前处在p子集里的id值修改为qid（也即pq子集合并，全部归为q子集）
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

}
