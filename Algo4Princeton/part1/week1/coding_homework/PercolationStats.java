package Algo4Princeton.part1.week1.coding_homework;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @program: AlgorithmDepository
 * @description: Monte Carlo simulation
 * @author: PlusL
 * @create: 2022-12-04 13:29
 **/
public class PercolationStats {

    private double[] thresholds;
    private final int T;
    private final int N;
    private double area;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n | trials must be positive");
        }
        T = trials;
        N = n;
        area = n * n;
        thresholds = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;
                // don't need to judge if the site in (row, col) is open,because .open method contained this judge
                percolation.open(row, col);
            }
            thresholds[i] = percolation.numberOfOpenSites() / area;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 *stddev()) / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 *stddev()) / Math.sqrt(T);
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("please input correct parameter 'n' 'p'");
        }
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percStats = new PercolationStats(n, T);
        System.out.println("mean: " + percStats.mean());
        System.out.println("stddev: " + percStats.stddev());
        System.out.println("95% confidence interval = [" + percStats.confidenceLo()
                + ", " + percStats.confidenceHi() + "]");
    }

}
