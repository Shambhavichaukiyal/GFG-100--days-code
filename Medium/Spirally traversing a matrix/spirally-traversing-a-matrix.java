//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
       ArrayList<Integer> a = new ArrayList<Integer>();
        int rowBegin = 0;
        int rowEnd = r - 1;
        int columnBegin = 0;
        int columnEnd = c - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            // Traverse Right
            for (int i = columnBegin; i <= columnEnd; i++) {
                a.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                a.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            // Traverse Left
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    a.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // Traverse Up
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    a.add(matrix[i][columnBegin]);
                }
                columnBegin++;
            }
        }
        return a;
    }}
