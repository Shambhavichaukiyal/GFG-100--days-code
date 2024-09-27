//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int N[][]) {
        int n=N.length;
        int top=0;
    	int down=n-1;
    	while(top<down)
    	{
    	    if(N[top][down]==1)
    	    {
    	        top++;
    	    }
    	    else 
    	    {
    	        down--;
    	    }
    	    
    	}
    
    	for(int i=0;i<n;i++)
    	{
    	    if(top!=i)
    	    {
    	    if(N[top][i]== 1 || N[i][top]==0)
    	    {
    	        
    	   
    	        return -1;
    	    }
    	}}
    	return top;
    }
}