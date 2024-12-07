//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int m = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, m));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int m) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        int cumxor=0;
        for(int i=0;i<arr.length;i++)
        {
            cumxor^=arr[i];
            if(cumxor==m)
            {
                count++;
            }
            if(map.containsKey(cumxor^m))
            {
                count+=map.get(cumxor^m);
            }
           map.put(cumxor, map.getOrDefault(cumxor, 0) + 1);
        }
        return count;
    }
}