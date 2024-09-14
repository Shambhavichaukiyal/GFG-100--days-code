//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
     long l=0;
     long h=0;
     for(int i=0;i<n;i++)
     {
         h+=arr[i];
         l = Math.max(l, arr[i]);
     }
     long ans=h;
     while(l<=h)
     {
         long mid=l+(h-l)/2;
         if(canpaint(arr,k,mid))
         {
             ans=mid;
             h=mid-1;
         }
         else
         {
             l=mid+1;
         }
     }
     return ans;
    }
    public static boolean canpaint(int arr[],int k,long mid)
    {
        int painter=1;
        long time=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>mid)
            {
                return false;
            }
            if(time+arr[i]>mid)
            {
                painter++;
                time=arr[i];
                 if (painter > k) {
                    return false; 
                }
            }
            else
            {
                time+=arr[i];
            }
        }
        
        return true;
    }
}


