//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
          int n = arr.length;
        if (n == 0) {
            return 0;
        }
        return inversion(arr, 0, n - 1);
    }
    public static int inversion(int arr[], int l, int r) {
        int c = 0;
        if (l < r) {  // Base case to stop recursion
            int mid = l + (r - l) / 2;
            c += inversion(arr, l, mid);
            c += inversion(arr, mid + 1, r);
            c += merge(arr, l, mid, r);
        }
        return c;
    }
public static int merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l, swap = 0;while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {  // No inversion (including equal elements)
                arr[k++] = left[i++];
            } else {  // Inversion found
                arr[k++] = right[j++];
                swap += (n1 - i);  // Correct inversion counting
            }
        }

        // Copy remaining elements of left[] (if any)
        while (i < n1) {
            arr[k++] = left[i++];
        }
  while (j < n2) {
            arr[k++] = right[j++];
        }

        return swap; // Return the count of inversions
    }
    }
