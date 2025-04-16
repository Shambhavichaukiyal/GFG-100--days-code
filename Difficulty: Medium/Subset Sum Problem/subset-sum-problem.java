//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
       int n=arr.length;
        
        Boolean dp[][]=new Boolean[n][sum+1];
        return subset(dp,arr,sum,n-1);
        
    }
    public static boolean subset(Boolean dp[][],int arr[],int sum,int i)
    {
        if(sum==0)
        {
            return true;
        }
        if(i<0)
        {
            return false;
        }
        if(dp[i][sum]!=null)
        {
            return dp[i][sum];
        }
        boolean nottake=subset(dp,arr,sum,i-1);
        boolean take=false;
        if(sum>=arr[i])
        {
            take=subset(dp,arr,sum-arr[i],i-1);
        }
        return dp[i][sum]=nottake || take;
    }}