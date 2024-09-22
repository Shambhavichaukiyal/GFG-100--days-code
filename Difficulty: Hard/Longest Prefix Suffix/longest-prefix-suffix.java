//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
      int len=0;
      int i=1;
      int lis[]=new int[str.length()];
      lis[0]=0;
      while(i<str.length())
      {
          if(str.charAt(i)==str.charAt(len))
          {
              len++;
              lis[i]=len;
              i++;
          }
          else
          {
              if(len!=0)
              {
                  len=lis[len-1];
                  
              }
              else
              {
                  lis[i]=0;
                  i++;
              }
          }
      }
      return len;
    }
}