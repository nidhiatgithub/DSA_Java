package src.recursion;

// n*m grid, find count of all possible paths from top left to bottom right
public class GridPaths {
    public static void main(String[] args) {
        int n = 3, m=3;
        System.out.println(gridPathCounter(n,m));
    }

    private static int gridPathCounter(int n, int m) {
        if (n==1 || m==1)
            return 1;
        return gridPathCounter(n-1, m) + gridPathCounter(n, m-1);
    }
}
