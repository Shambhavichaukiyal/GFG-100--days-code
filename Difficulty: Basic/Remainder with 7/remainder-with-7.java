//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			Solution obj = new Solution();
			System.out.println(obj.remainderWith7(str));
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


class Solution {
    // Complete the function
    int remainderWith7(String n) {
        // Your code here
         int remainder = 0;
        
        for (int i = 0; i < n.length(); i++) {
            
            int digit = n.charAt(i) - '0';
            
            remainder = (remainder * 10 + digit) % 7;
        }
        
        return remainder;
    }
}
        

