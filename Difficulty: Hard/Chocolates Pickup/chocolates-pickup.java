//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
    
        int[][][] dp = new int[n][m][m];
        
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        
        return findMax(0, 0, m - 1, grid, dp);
    }

    private int findMax(int row, int col1, int col2, int[][] grid, int[][][] dp) {
        int n = grid.length, m = grid[0].length;
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return Integer.MIN_VALUE; // Out of bounds
        }
         if (row == n - 1) {
            if (col1 == col2) return grid[row][col1];
            else return grid[row][col1] + grid[row][col2];
        }
         int maxChocolates = Integer.MIN_VALUE;
        if (dp[row][col1][col2] != -1) return dp[row][col1][col2];
         for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {
                maxChocolates = Math.max(maxChocolates, findMax(row + 1, col1 + move1, col2 + move2, grid, dp));
            }
        }
         int chocolates = grid[row][col1] + (col1 == col2 ? 0 : grid[row][col2]);
          return dp[row][col1][col2] = chocolates + maxChocolates;
}
}