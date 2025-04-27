//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
     int n = grid.length;
        int m = grid[0].length;
        HashSet<List<String>> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    List<String> path = new ArrayList<>();
                    dfs(grid, i, j, path, i, j);
                    set.add(path);
                }
            }
        }
        return set.size();
    }
        public static void dfs(int grid[][], int r, int c, List<String> path, int baseR, int baseC) {
        int delrow[] = {1, -1, 0, 0};
        int delcol[] = {0, 0, -1, 1};
        int n = grid.length;
        int m = grid[0].length;

        grid[r][c] = 0;
        path.add((r - baseR) + "," + (c - baseC));

        for (int i = 0; i < 4; i++) {
            int nr = r + delrow[i];
            int nc = c + delcol[i];
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                dfs(grid, nr, nc, path, baseR, baseC);
            }
        }
    }
}
