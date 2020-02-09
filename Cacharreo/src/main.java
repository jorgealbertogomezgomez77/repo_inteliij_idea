import java.util.*;
public class main
{
    public static int[][] shortestpath(int[][] adj, int[][] path)
    {
        int n = adj.length;
        int[][] ans = new int[n][n];
        copy(ans, adj);
        for (int k=0; k<n;k++)
            for (int i=0; i<n; i++)
                for (int j=0; j<n;j++)
                    if (ans[i][k]+ans[k][j] < ans[i][j]) {
                        ans[i][j] = ans[i][k]+ans[k][j];
                        path[i][j] = path[k][j];
                    }
        return ans;
    }
    public static void copy(int[][] a, int[][] b)
    {
        for (int i=0;i<a.length;i++)
            for (int j=0;j<a[0].length;j++)
                a[i][j] = b[i][j];
    }
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        // Tests out algorithm with graph shown in class.
        int[][] m = new int[5][5];
        m[0][0] = 0;
        m[0][1] = 4;
        m[0][2] = 8;
        m[0][3] = 10000;
        m[0][4] = 10000;
        m[1][0] = 4;
        m[1][1] = 0;
        m[1][2] = 1;
        m[1][3] = 2;
        m[1][4] = 10000;
        m[2][0] = 8;
        m[2][1] = 1;
        m[2][2] = 0;
        m[2][3] = 4;
        m[2][4] = 2;
        m[3][0] = 10000;
        m[3][1] = 2;
        m[3][2] = 4;
        m[3][3] = 0;
        m[3][4] = 7;
        m[4][0] = 10000;
        m[4][1] = 10000;
        m[4][2] = 2;
        m[4][3] = 7;
        m[4][4] = 0;
        int[][] shortpath;
        int[][] path = new int[5][5];

        for (int i=0; i<5; i++)
            for (int j=0; j<5; j++)
                if (m[i][j] == 10000)
                    path[i][j] = -1;
                else
                    path[i][j] = i;
        for (int i=0; i<5; i++)
            path[i][i] = i;

        shortpath = shortestpath(m, path);
        // Prints out shortest distances.
        System.out.println("  0 1 2 3 4");
        System.out.println("  ---------");
        for (int i=0; i<5;i++) {
            System.out.print(i + "|");
            for (int j=0; j<5;j++)
                System.out.print(shortpath[i][j]+" ");
            System.out.println();
        }
        System.out.println("Ruta más corta de un vértice a otro (0 a 4)");
        System.out.print("Vértice inicial: ");
        int start = stdin.nextInt();
        System.out.print("Vértice final: ");
        int end = stdin.nextInt();
        String myPath = end + "";
        System.out.println();
        System.out.println("  0 1 2 3 4");
        System.out.println("  ---------");
        for (int i=0; i<5;i++) {
            System.out.print(i + "|");
            for (int j=0; j<5;j++)
                System.out.print(path[i][j]+" ");
            System.out.println();
        }
        while (path[start][end] != start) {
            myPath = path[start][end] + " -> " + myPath;
            end = path[start][end];
        }
        myPath = start + " -> " + myPath;
        System.out.println("Esta es la ruta: " + myPath);
    }
}
