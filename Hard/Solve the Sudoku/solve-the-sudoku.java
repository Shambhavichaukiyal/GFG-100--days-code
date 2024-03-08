//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        int row=-1;
        int col=-1;
        int n=grid.length;
        boolean isempty=true;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    row=i;
                    col=j;
                    isempty=false;
                    break;
                }
            }
        }
        if(isempty)
        {
            return true;
        }
        //backtrack karte ha 
        for(int num=1;num<=9;num++)
        {
            if(isSafe(grid,row,col,num))
            {
                grid[row][col]=num;
                if(SolveSudoku(grid))
                {
                    return true;
                }
                else
                {
                    grid[row][col]=0;
                }
            }
        }
        return false;
        
    }
    public static boolean isSafe(int grid[][],int row,int col,int num)
    {
        //row ko check karte ha na
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][col]==num)
            {
                return false;
            }
        }
        //col ko check karte ha na 
        for(int i=0;i<grid.length;i++)
        {
            if(grid[row][i]==num)
            {
                return false;
            }
        }
        int sqrt =(int)Math.sqrt(grid.length);
        int boxrow= row-row%sqrt;
        int boxcol=col-col%sqrt;
        for(int i=boxrow;i<boxrow+sqrt;i++)
        {
            for(int j=boxcol;j<boxcol+sqrt;j++)
            {
                if(grid[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
         int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            
        }
    }
    
}