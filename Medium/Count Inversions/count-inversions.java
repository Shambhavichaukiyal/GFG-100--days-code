//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
     static long inversionCount(long arr[], long N) {
        if (N == 0)
            return 0;
        return inversion(arr, 0, N - 1);
    }

    // Helper function to count inversions using merge sort
    public static long inversion(long arr[], long l, long r) {
        long count = 0;
        if (l < r) {
            long mid = l + (r - l) / 2;
            count += inversion(arr, l, mid);
            count += inversion(arr, mid + 1, r);
            count += merge(arr, l, mid, r);
        }
        return count;
    }

    // Function to merge two halves and count inversions
    public static long merge(long arr[], long l, long mid, long r) {
        int n1 = (int) (mid - l + 1);
        int n2 = (int) (r - mid);

        long left[] = new long[n1];
        long right[] = new long[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[(int) l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[(int) mid + 1 + j];

        int i = 0, j = 0, k = (int) l;
        long swap = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                
                swap=swap+(mid+1)-(l+i);
            }
        }

        while (i < n1) arr[k++] = left[i++];

        while (j < n2) arr[k++] = right[j++];

        return swap;
    }
}