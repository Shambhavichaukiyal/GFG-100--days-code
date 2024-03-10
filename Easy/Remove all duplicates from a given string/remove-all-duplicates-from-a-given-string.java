//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) 
    {
    LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();
        
        // Iterate through each character in the input string
        for (char c : str.toCharArray()) {
            uniqueChars.add(c); // Add each character to the HashSet
        }

        // Reconstruct the string from unique characters
        StringBuilder sb = new StringBuilder();
        for (char c : uniqueChars) {
            sb.append(c); // Append each unique character to StringBuilder
        }
        
        return sb.toString(); // Return the string containing unique characters
    }
}