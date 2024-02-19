//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


import java.util.ArrayList;

class GFG {
    ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1); 
        result.add(-1);

        int l = 0;
        int r = n - 1; 
        int mid = 0;
        
    while(l<=r)
    {
        mid=l+(r-l)/2;
        if(arr[mid]>x)
        {
          r=mid-1;  
        }
        else if(arr[mid]<x)
        {
           l=mid+1; 
        }
        else
        {
            result.set(0,mid);
            r=mid-1;
        }
    }
      l = 0;
         r = n - 1; 
         mid = 0;
     while(l<=r)
    {
         mid=l+(r-l)/2;
        if(arr[mid]>x)
        {
          r=mid-1;  
        }
        else if(arr[mid]<x)
        {
           l=mid+1; 
        }
        else
        {
            result.set(1,mid);
            l=mid+1;
        }
    }
        return result;
    }
}

       



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends