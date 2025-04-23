//{ Driver Code Starts
//Initial Template for Java

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
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    List<String> ans= new ArrayList<>();
    generate(n,ans,"",'0');
    return ans;

  }
  public static void generate(int n,List<String> ans,String res,char prev)
  {
      if(n==0)
      {
          ans.add(res);
          return;
      }
      
      generate(n-1,ans,res+'0','0');
      if (prev != '1') {
      generate(n - 1, ans, res + '1', '1');
    }
      
      
  }
}
     
     