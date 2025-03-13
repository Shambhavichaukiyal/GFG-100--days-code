//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
       int n = arr.length;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return cost(dp, k, arr, n - 1);
    }

    public int cost(int dp[], int k, int arr[], int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int mn = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int cs = cost(dp, k, arr, n - i) + Math.abs(arr[n] - arr[n - i]);
                mn = Math.min(cs, mn);
            }
        }
        dp[n] = mn;
        return dp[n];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends