//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


   class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
       int i = 0;
       int j = 0;
       int o = 0;
       int k[] = new int[m + n];
       
      
       while (i < n && j < m)
       {
           if (a[i] <= b[j])
           {
               k[o++] = a[i++];
           }
           else
           {
               k[o++] = b[j++];
           }
       }
       
      
       while (i < n)
       {
           k[o++] = a[i++];
       }
       
       // Copy the remaining elements of array b (if any)
       while (j < m)
       {
           k[o++] = b[j++];
       }
       
       int middleIndex = (k.length - 1) / 2;
       
       // Calculate the median based on the length of the merged array
       if (k.length % 2 == 0)
       {
           return (k[middleIndex] + k[middleIndex + 1]) / 2.0;
       }
       else
       {
           return k[middleIndex];
       }
    }
}
