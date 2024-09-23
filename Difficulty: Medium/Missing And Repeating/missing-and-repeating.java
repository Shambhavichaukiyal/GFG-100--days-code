//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int a[] = new int[2];
    int n = arr.length;

    
    long s = (long) n * (n + 1) / 2; 
    long sn = (long) n * (n + 1) * (2 * n + 1) / 6;  

    long s1 = 0;
    long sn1 = 0;

    
    for (int i = 0; i < n; i++) {
        s1 += arr[i];
        sn1 += (long) arr[i] * arr[i];
    }

    long diff = s1 - s;  
    long diffsq = sn1 - sn; 

    
    long sumRepeatedMissing = diffsq / diff;  

    long repeated = (diff + sumRepeatedMissing) / 2;  
    long missing = sumRepeatedMissing - repeated;

    a[0] = (int) repeated;
    a[1] = (int) missing;

    return a;
}
}