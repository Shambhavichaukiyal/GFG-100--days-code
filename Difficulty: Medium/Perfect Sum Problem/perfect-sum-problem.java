//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends






class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] arr, int target) {
              int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        
        int cnt = solve(n, arr, target, dp);
        
        int zeros = 0;
        for (int num : arr) {
            if (num == 0) zeros++;
        }
        
        return (int) (cnt * Math.pow(2, zeros));
    }
     private int solve(int i, int[] arr, int target, int[][] dp) {
        if (dp[i][target] != -1) return dp[i][target];
        if (target == 0) return dp[i][target] = 1;
        if (i == 0) return dp[i][target] = 0;
        
        if (arr[i - 1] == 0 || arr[i - 1] > target) {
            return dp[i][target] = solve(i - 1, arr, target, dp);
        } else {
            return dp[i][target] = solve(i - 1, arr, target - arr[i - 1], dp) + solve(i - 1, arr, target, dp);
        }
    }}