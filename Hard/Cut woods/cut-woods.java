//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int M; 
            M = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.maxHeight(N, A, M);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {

    public static long cut(int A[], int a) {
        long wc = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > a) {
                wc =wc+ (A[i] - a);
            }
        }
        return wc;
    }

   public static int maxHeight(int N, int[] A, int M) {
    Arrays.sort(A);
    int l = 0;
    int r = A[N - 1];
    int result = 0;

    while (l <= r) {
        int mid = l + (r - l) / 2;
        long wc = cut(A, mid);

        if (wc >= M) {
            result = mid; 
            l = mid + 1; 
        } else {
            r = mid - 1;
        }
    }
    return result;
}}
