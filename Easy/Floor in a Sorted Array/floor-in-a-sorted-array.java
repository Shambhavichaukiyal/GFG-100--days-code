//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution {
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int l = 0;
        int r = n - 1;

        // If x is smaller than the first element in the array
        if (x < arr[0]) {
            return -1; // No floor exists
        }

        // If x is greater than or equal to the last element in the array
        if (x >= arr[n - 1]) {
            return n - 1; // Last element is the floor
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid; // Found exact match
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // At this point, r is the index of the largest element smaller than x
        return r;
    }
}
