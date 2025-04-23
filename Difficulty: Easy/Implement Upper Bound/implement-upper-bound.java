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
            int ans = sln.upperBound(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int upperBound(int[] arr, int target) {
        int l=0;
        int r=arr.length-1;
        int max=arr.length; 
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]>target)
            {
                max=mid;
                r=mid-1;
                
            }
            else
            {
               l=mid+1; 
            }
            
        }
        return max;
    }
}
