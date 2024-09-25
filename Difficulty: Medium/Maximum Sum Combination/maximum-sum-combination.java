//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair
    {
        int i;
        int j;
        int val;
        Pair(int i,int j,int val)
        {
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->b.val-a.val);
        Set<String> vis=new HashSet<>();
        pq.add(new Pair(N-1,N-1,A[N-1]+B[N-1]));
        vis.add((N-1)+","+(N-1));
        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < K && !pq.isEmpty(); k++) 
        {
         Pair s= pq.poll();   
         result.add(s.val);
         int i=s.i;
         int j=s.j;
         if(i-1>=0 && !vis.contains((i-1)+","+j))
         {
             pq.add(new Pair(i-1,j,A[i-1]+B[j]));
             vis.add((i-1)+","+j);
         }
         if(j-1>=0 && !vis.contains(i+","+(j-1)))
         {
             pq.add(new Pair(i,j-1,A[i]+B[j-1]));
             vis.add((i)+","+(j-1));
         }
        
    }
    return result;
}}
