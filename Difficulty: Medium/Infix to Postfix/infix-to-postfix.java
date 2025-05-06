//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static String infixToPostfix(String s) {
        String ans="";
        Stack<Character> sta= new Stack<>();
        int i=0;
        int n=s.length();
        while(i<n)
        {
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                ans+=ch;
            }
            else if(ch=='(')
            {
                sta.push(ch);
            }
            else if(ch==')')
            {
                while(!sta.isEmpty() && sta.peek()!='(')
                {
                    ans+=sta.pop();
                }
                 if (!sta.isEmpty()) {
        sta.pop(); // remove the '('
    }
            }
            else 
            {
            while(!sta.isEmpty() && priority(ch)<=priority(sta.peek()))
            {
                ans+=sta.pop();
            }
            sta.push(ch);
        }
        i++;
        }
        while(!sta.isEmpty())
        {
            ans+=sta.pop();
        }
        return ans;
        
    }
    public static int priority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }
}