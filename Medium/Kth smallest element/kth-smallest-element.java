//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        if(l<r)
        {
            int mid = l+(r-l)/2;
            kthSmallest(arr,l,mid,k);
            kthSmallest(arr,mid+1,r,k);
            mergeSort(arr,l,r,mid);
        }
        return arr[k-1];
    } 
    public static void mergeSort(int arr[],int l,int r,int mid)
    {
        int i=0;
        int j=0;
        int g=l;
        int n1=mid-l+1;
        int n2=r-mid;
        int larr[] = new int[n1];
        int rarr[] = new int[n2];
        for(int p =0;p<n1;p++)
        {
            larr[p]=arr[p+l];
        }
         for(int p =0;p<n2;p++)
        {
            rarr[p]=arr[p+mid+1];
        }
        while(i<n1 && j<n2)
        {
            if(larr[i]<=rarr[j])
            {
                arr[g]=larr[i];
                i++;
            }
            else
            {
               arr[g]=rarr[j];
                j++;  
            }
            g++;
        }
        while(i<n1)
        {
            arr[g]=larr[i];
            i++;
            g++;
        }
        while(j<n2)
        {
            arr[g]=rarr[j];
            j++;
            g++;
        }
        
    }
}
