//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
  int n = arr.length;
        int[] result = new int[2];
        long sum1 = 0;  // Sum of elements
        long sum2 = 0;  // Sum of squares of elements
        long sumN = (long) n * (n + 1) / 2;  // Theoretical sum of first n natural numbers
        long sumN2 = (long) n * (n + 1) * (2 * n + 1) / 6;  // Theoretical sum of squares of first n natural numbers
        
        for (int num : arr) {
            sum1 += num;
            sum2 += (long) num * num;  // Use long to prevent overflow
        }
        
        long sumDiff = sumN - sum1;  // Missing - Duplicate
        long sumSquaresDiff = sumN2 - sum2;  // Missing^2 - Duplicate^2
        
        // Calculate the sum of missing and duplicate numbers
        long sumMissingAndDuplicate = sumSquaresDiff / sumDiff;
        
        // Calculate the missing and duplicate numbers
        result[1] = (int) ((sumDiff + sumMissingAndDuplicate) / 2);  // Missing
        result[0] = (int) (result[1] - sumDiff);  // Duplicate
        
        return result;
    }
}