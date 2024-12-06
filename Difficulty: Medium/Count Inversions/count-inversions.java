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
        if(arr.length==0)
        {
            return 0;
        }
        return inv(arr,0,arr.length-1);
    }
    static int inv(int arr[],int l,int r)
    {
        int res=0;
        if(l<r)
        {
            int mid=l+(r-l)/2;
            res+=inv(arr,l,mid);
            res+=inv(arr,mid+1,r);
            res+=count(arr,l,mid,r);
            
        }
        return res;
    }
    static int count(int arr[],int l,int mid,int r)
    {
        int n1=mid-l+1;
        int n2=r-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0;i<n1;i++)
        {
            left[i]=arr[i+l];
        }
        for(int i=0;i<n2;i++)
        {
            right[i]=arr[i+mid+1];
        }
        int i=0;
        int j=0;
        int k=l;
        int swap=0;
        while(i<n1 && j<n2)
        {
            if(left[i]<=right[j])
            {
                arr[k++]=left[i++];
            }
            else
            {
                arr[k++]=right[j++];
                swap+=(n1 - i);
            }
        }
        while(i<n1)
        
        {
            arr[k++]=left[i++];
        }
        while(j<n2)
        {
            arr[k++]=right[j++];
        }
        return swap;
    }
}