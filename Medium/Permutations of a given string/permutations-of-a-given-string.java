//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
         List<String> a = new ArrayList<>();
        Set<String> set = new HashSet<>(); // Use a set to keep track of unique permutations
        permute(S, 0, S.length() - 1, a, set);
        Collections.sort(a); // Sort the list lexicographically
        return a;
    }

    public void permute(String S, int l, int r, List<String> a, Set<String> set) {
        if (l == r) {
            if (!set.contains(S)) { // Add the permutation only if it's not in the set
                a.add(S);
                set.add(S);
            }
        } else {
            for (int i = l; i <= r; i++) {
                S = swap(S, l, i);
                permute(S, l + 1, r, a, set);
                S = swap(S, l, i); // backtrack to the original string
            }
        }
    }

    public String swap(String S, int l, int r) {
        char[] charArray = S.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;
        return String.valueOf(charArray);
    }
}
    