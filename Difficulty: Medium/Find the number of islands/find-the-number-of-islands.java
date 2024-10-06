//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    c++;
                    dfs(i,j,grid,vis);
                    
                }
            }
        }
        return c;
    }
    public static void dfs(int startRow, int startCol, char[][] grid, int[][] vis) {
    int n = grid.length;
    int m = grid[0].length;
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{startRow, startCol});
    int[] delRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] delCol = {-1, 0, 1, -1, 1, -1, 0, 1};
    vis[startRow][startCol] = 1;
    while (!stack.isEmpty()) {
        int[] current = stack.pop();
        int row = current[0];
        int col = current[1];
        for (int i = 0; i < 8; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                vis[newRow][newCol] = 1;
                stack.push(new int[]{newRow, newCol});
            }
        }
    }
}}
