//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> result =new ArrayList<>();
        generate(n,0,0,"",result);
        return result;
        
    }
    public void generate(int n,int ob,int cb,String ans,List<String> result)
    {
    if(2*n==ans.length())
    {
         result.add(ans);
        return;
    }
    if(ob<n)
    {
      generate(n,ob+1,cb,ans+'(',result);
    }
    if(ob>cb)
    {
         generate(n,ob,cb+1,ans+')',result) ;
    }
}}