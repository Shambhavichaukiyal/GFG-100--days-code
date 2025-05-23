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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
          Stack<String> stack = new Stack<>();
        
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char c = pre_exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expr = op1 + op2 + c;
                stack.push(expr);
            }
        }
        
        return stack.isEmpty() ? "" : stack.pop();
    }
        
    
}
