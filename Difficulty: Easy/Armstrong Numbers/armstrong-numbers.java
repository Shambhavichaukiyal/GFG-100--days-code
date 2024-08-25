//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        int m=n;
        int sum=0;
        while(n>0)
        {
            int rem=n%10;
            sum=(int)Math.pow(rem,3)+sum;
            n=n/10;
        }
        if(sum==m)
        {
            return "true";
        }
        return "false";
    }
}