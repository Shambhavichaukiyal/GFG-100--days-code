//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.Nth_mileSpeed(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution {
    public long Nth_mileSpeed(int n) {
 long ans = 0;
        long curi = 7;
        long count = 1;
        
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                ans = (long) Math.pow(count++, 4);
            } else {
                if (i != 2) {
                    curi = curi * 3;
                }
            }
        }
        
        if (n % 2 == 0) {
            return curi;
        }
        
        return ans;
    }
}