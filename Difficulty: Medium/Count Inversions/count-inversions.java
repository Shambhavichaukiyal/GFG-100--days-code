//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            long arr[] = new long[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
//10 1 2 3 4 5 6 7 


class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[]) {
        if(arr.length==0)
        {
            return 0;
        }
        return inversion(arr,0,arr.length-1);
    }
    public static long inversion(long arr[],long l, long r)
    {
        long count=0;
        if(l<r)
        {
          long  mid=l+(r-l)/2;
            count+=inversion(arr,l,mid);
            count+=inversion(arr,mid+1,r);
            count+=merge(arr,l,mid,r);
        }
        return count;
    }
    public static long merge(long arr[],long l,long mid,long r)
    {
        
          int n1 = (int) (mid - l + 1);
        int n2 = (int) (r - mid);
        
        long[] left = new long[n1];
        long[] right = new long[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[(int) l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[(int) mid + 1 + j];
        }
int i = 0, j = 0, k = (int) l;
        long c = 0;
 while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                c += (n1 - i); // Counting inversions
            }
        }
         while (i < n1) {
            arr[k++] = left[i++];
        }
         while (j < n2) {
            arr[k++] = right[j++];
        }

        return c;
    }}