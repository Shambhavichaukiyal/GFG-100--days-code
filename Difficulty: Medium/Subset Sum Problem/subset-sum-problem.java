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


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return sum(dp, arr, n - 1, target);
    }
        public static Boolean sum(Boolean dp[][], int arr[], int index, int target) {
        if (target == 0) return true;
        if (index < 0) return false;

        if (dp[index][target] != null) return dp[index][target];

        boolean notTake = sum(dp, arr, index - 1, target);
        boolean take = false;

        if (arr[index] <= target) {
            take = sum(dp, arr, index - 1, target - arr[index]);
        }

        return dp[index][target] = take || notTake;
    }
}