//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans= new ArrayList<>();
        int dc[]={-1,0,1,0};
        int dr[]={0,-1,0,1};
        
        path(mat,ans,0,0,"",dr,dc);
        return ans;
    }
    public static void path(int mat[][],ArrayList<String> ans,int r,int c,String p,int dr[],int dc[])
{
    if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == 0) {
            return;
        }
         if (r == mat.length - 1 && c == mat[0].length - 1) {
            ans.add(p);
            return;
        }
        mat[r][c] = 0;

        // Explore all possible directions
        for (int i = 0; i < 4; i++) {
            int newRow = r + dr[i];
            int newCol = c + dc[i];
           
            char direction = (i == 0) ? 'L' : (i == 1) ? 'U' : (i == 2) ? 'R' : 'D';
            path(mat, ans, newRow, newCol, p + direction, dr, dc);
        }

    
        mat[r][c] = 1;
    }
}