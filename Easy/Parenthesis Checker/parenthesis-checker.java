//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        char chars[] = x.toCharArray();
        Stack<Character> stack=new Stack<>();
       for (char ele : chars) {
            if (ele == '[' || ele == '{' || ele == '(') {
                stack.push(ele);
            } else {
                if (stack.empty()) {
                    return false; // Unmatched closing bracket
                }
                
                char top = stack.pop();
                if ((top == '[' && ele != ']') || (top == '(' && ele != ')') || (top == '{' && ele != '}')) {
                    return false; // Mismatched brackets
                }
            }
        }
        
        return stack.empty(); // Check if there are any unmatched opening brackets
    }
}