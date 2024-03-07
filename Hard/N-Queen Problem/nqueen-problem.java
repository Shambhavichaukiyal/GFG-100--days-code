//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<>();
        boolean board[][] =new boolean[n][n];
        nqueen(board,0,result);
        return result;
    }
  public static void nqueen(boolean[][] board, int r, ArrayList<ArrayList<Integer>> result) {
        if (r == board.length) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        solution.add(j + 1); // Add column index of queen
                        break;
                    }
                }
            }
            result.add(solution);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, r, i)) {
                board[r][i] = true;
                nqueen(board, r + 1, result);
                board[r][i] = false; // Backtracking
            }
        }
    }
    static boolean isSafe(boolean board[][],int r,int c)
    {
        // vertical ko check karte ha 
        for(int j=0;j<board.length;j++)
        {
            if(board[j][c])
            {
                return false;
            }
        }
        //diagonal ko check karte ha
        int maxlength=Math.min(r,c);
        for(int j=1;j<=maxlength;j++)
        {
             if(board[r-j][c-j])
            {
                return false;
            }
        }
        //diagonal  right side wale kp check karte ha
         int minlength=Math.min(r,board.length-c-1);
        for(int j=1;j<=minlength;j++)
        {
             if(board[r-j][c+j])
            {
                return false;
            }
        }
        return true;
        
    }
}