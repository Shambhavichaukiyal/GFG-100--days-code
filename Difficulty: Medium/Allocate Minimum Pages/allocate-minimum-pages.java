//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
         if (m > n) {
        return -1;
    }
        int l=0;
        int h=0;
        for(int i=0;i<n;i++)
        {
            h+=arr[i];
        }
        int ans=0;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(canallocate(mid,arr,m))
            {
                ans=mid;
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
    
    public static boolean canallocate(int mid,int arr[],int m)
    {
        int student=1;
        int pages=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>mid)
            {
                return false;
            }
            if(pages+arr[i]>mid)
            {
                pages=arr[i];
                student++;
            }
            else
            {
                pages+=arr[i];
            }
        }
        if(student>m)
        {
            return false;
        }
        return true;
    }}
