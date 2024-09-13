//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l=1;
        int h=stalls[n-1]-stalls[0];
        int result = 0;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(canweplace(stalls,mid,k)==true)
            {
                l=mid+1;
                result = mid;
            }
            else
            {
              h=  mid-1;
            }
        }
        return result;
    }
    public static boolean canweplace(int stalls[],int dis,int k)
    {
        int cnt=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++)
        {
            if(stalls[i] - last >= dis)
            {
                cnt++;
                last = stalls[i];
            }
            if(cnt>=k)
            {
                return true;
            }
        }
        return false;
        
    }
}