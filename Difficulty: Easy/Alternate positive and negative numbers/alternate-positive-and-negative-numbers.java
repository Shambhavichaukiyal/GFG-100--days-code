//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
         List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);  // 0 is considered positive
            } else {
                negative.add(num);
            }
        }
 arr.clear();
  int posIndex = 0, negIndex = 0;
        int i = 0;


        while (posIndex < positive.size() && negIndex < negative.size()) {
            arr.add(positive.get(posIndex++));
            arr.add(negative.get(negIndex++));
        }

        
        while (posIndex < positive.size()) {
            arr.add(positive.get(posIndex++));
        }

        
        while (negIndex < negative.size()) {
            arr.add(negative.get(negIndex++));
        }
    }
}