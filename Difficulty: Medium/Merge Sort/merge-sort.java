//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r)
        {
            return ;
        }
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        mergearray(arr,l,mid,r);
    }
    public void mergearray(int arr[],int l,int mid,int h)
    {
        int[] merge = new int[h - l + 1];
        int i=l;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=h)
        {
            if(arr[i]>arr[j])
            {
                merge[k++]=arr[j++];
            }
            else
            {
                merge[k++]=arr[i++];
            }
        }
         while (i <= mid) {
        merge[k++] = arr[i++];
    }
     while (j <= h) {
        merge[k++] = arr[j++];
    }
        for (int p = 0; p < merge.length; p++) {
    arr[l + p] = merge[p];
}

}
    }

