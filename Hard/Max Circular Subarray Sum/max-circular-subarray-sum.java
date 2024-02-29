//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
      int totalSum = 0;
        int maxKadane = kadane(a, n); // Apply Kadane's algorithm to find the maximum sum subarray

        // If all elements are negative, maxKadane will be the maximum circular sum
        if (maxKadane < 0)
            return maxKadane;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
            a[i] = -a[i]; // Invert the signs of elements
        }

        // Apply Kadane's algorithm to find the maximum sum subarray of the inverted array
        int invertedKadane = kadane(a, n);

        // Restore the original array by inverting the signs again
        for (int i = 0; i < n; i++) {
            a[i] = -a[i];
        }

        // Calculate the maximum circular subarray sum
        int maxCircular = totalSum + invertedKadane;

        // Return the maximum of maxKadane and maxCircular
        return Math.max(maxKadane, maxCircular);
    }
      public static int kadane(int[] a, int n) {
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(a[i], sum + a[i]);
            max = Math.max(max, sum);
        }
        return max;
    }}
