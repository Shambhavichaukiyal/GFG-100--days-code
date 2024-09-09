//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int c0=0;
        int c1=0;
        int c2=0;
        for(int a:arr)
        {
            if(a==0)
            {
                c0++;
            }
            else if(a==1)
            {
                c1++;
            }
            else
            {
                c2++;
            }
        }
        for(int i=0;i<c0;i++)
        {
            arr.set(i,0);
        }
        for(int i=c0;i<c0+c1;i++)
        {
            arr.set(i,1);
        }
        for(int i=c0+c1;i<arr.size();i++)
        {
            arr.set(i,2);
        }
    }
}