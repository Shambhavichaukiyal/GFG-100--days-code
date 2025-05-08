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
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
         Stack<String> sta= new Stack<>();
         
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                sta.push(Character.toString(ch));
            }
            else 
            {
                String a=sta.pop();
                String b=sta.pop();
                String ans= "(" + b + ch + a + ")";
                sta.push(ans);
            }
        }
        return sta.peek();
    }
}
