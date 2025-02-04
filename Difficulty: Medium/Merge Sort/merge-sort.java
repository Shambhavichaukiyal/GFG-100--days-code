//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int low, int high) {
        // code here
      
         if(low>=high) {
            return;
        }
        
        int mid = (low + high)/2;
        
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        mergeArrays(low, mid, high, arr);
    }
    
    void mergeArrays(int low, int mid, int high, int[] arr) {
        int[] merge = new int[high - low + 1];
        
        int i=low, j=mid+1, k=0;
        while(i<=mid && j<=high) {
            if(arr[i] < arr[j]) {
                merge[k++] = arr[i++];
            } else {
                merge[k++] = arr[j++];
            }
        }
        
        while(i<=mid) {
            merge[k++] = arr[i++];
        }
        
        while(j<=high) {
            merge[k++] = arr[j++];
        }
        
        // Copy elements back
        k = 0;
        for(i=low; i<=high; i++) {
            arr[i] = merge[k++];
        }
    }
}