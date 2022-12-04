package Algo4Princeton.part1.week1.coding_homework;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @program: AlgorithmDepository
 * @description: 第一周课后作业：渗滤threshold计算
 * @author: PlusL
 * @create: 2022-12-01 13:37
 **/
public class Percolation {

    /*
    Something I should pay attension to:
    1. build a Boolean Two-dimensional array to represent open or not
    2. use a unique number to represent a site
    3. The unique number also used to represent the connection(union) of sites
    4. use a virtual head node and virtual bottom node
     */
    private WeightedQuickUnionUF uf;
    private Boolean[][] grid;
    private int opensites;
    // dx, dy means the neighbor of current node
    private final int[] dx = {-1, 0, 0, 1};
    private final int[] dy = {0, 1, -1, 0};
    private final int VIRTUAL_TOP_NODE = 0;
    private final int VIRTUAL_BOTTONM_NODE;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("grid's length cannot be negative or 0");
        }
        VIRTUAL_BOTTONM_NODE = n * n + 1;
        uf = new WeightedQuickUnionUF(n * n + 2);
        opensites = 0;
        grid = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }

    /**
     * 判断是否越界
     *
     * @param row 行
     * @param col 列
     * @return 是否越界
     */
    private Boolean isInGrid(int row, int col) {
        return row > 0 && row <= grid.length && col > 0 && col <= grid.length;
    }

    /**
     * 计算坐标所对应的并查集下标
     * @param row 行
     * @param col 列
     * @return 计算uf下标
     */
    private int calcIndex(int row, int col) {
        return (row - 1) * grid.length + col;
    }

    /**
     * 连接当前节点相邻的已开放的节点
     *
     * @param row 行
     * @param col 列
     */
    private void connectNeighbors(int row, int col) {
        int currIndex = calcIndex(row, col);
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isInGrid(newRow, newCol) && isOpen(newRow, newCol)) {
                uf.union(calcIndex(newRow, newCol), currIndex);
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isInGrid(row, col)) {
            throw new IllegalArgumentException("input (row, col) is out of range");
        }
        // open需要处理的：1.将grid[row][col]设置true  2.如果当前节点是第一层的或者最后一层的节点，连接虚拟头结点/虚拟尾结点
        int currIndex = calcIndex(row, col);
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            // top, connect to virtual top node
            if (row == 1) {
                uf.union(VIRTUAL_TOP_NODE, currIndex);
            }
            // bottom, connect to virtual bottom node
            if (row == grid.length) {
                uf.union(VIRTUAL_BOTTONM_NODE, currIndex);
            }
            connectNeighbors(row, col);
            opensites++;
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!isInGrid(row, col)) {
            throw new IllegalArgumentException("input (row, col) is out of range");
        }
        return grid[row - 1][col - 1];
    }


    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int currentIndex = calcIndex(row, col);
        return uf.find(currentIndex) == uf.find(VIRTUAL_TOP_NODE);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opensites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(VIRTUAL_TOP_NODE) == uf.find(VIRTUAL_BOTTONM_NODE);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation perc = new Percolation(3);
        perc.open(1, 3);
        perc.open(2, 3);
        perc.open(3, 3);
        perc.open(3, 1);
        System.out.println("opensites: " + perc.numberOfOpenSites());
        System.out.println("isOpen 1 and 3 ? :" + perc.isOpen(1, 3));
        System.out.println("is percolates? : " + perc.percolates());
    }

}
