//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.lowerBound(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int lowerBound(int[] nums, int target) {
          int l = 0;
        int r = nums.length - 1;
        int min = -1;
        
        while (l <= r) {  
            int mid = l + (r - l) / 2;
            
            if (nums[mid] >= target) {
                min = mid;  // Save position for potential lower bound
                r = mid - 1; // Move left to find first occurrence
            } else {
                l = mid + 1; // Move right
            }
        }
        
        // If `min` is -1, return the index where the target could be inserted (which is `l`)
        return min == -1 ? l : min;  
    }
}