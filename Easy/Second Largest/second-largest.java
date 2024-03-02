//{ Driver Code Starts
//Initial Template for Java
import java.util.stream.Collectors; 
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends








class Solution {
    int print2largest(int arr[], int n) {
        if (n < 2) {
            return -1; // Array should have at least 2 elements
        }

        Arrays.sort(arr);

        // Traverse the sorted array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If we find an element different from the largest one, it's the second largest
            if (arr[i] != arr[n - 1]) {
                return arr[i];
            }
        }

        return -1; // All elements in the array are the same
    }
}