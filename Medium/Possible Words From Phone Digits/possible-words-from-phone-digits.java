//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends

class Solution
{
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> result = new ArrayList<>();
        String keypad[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(N == 0 || a.length == 0) {
            return result;
        }
        generate(0, a, N, "", result, keypad);
        return result;
    }

    public static void generate(int l, int a[], int N, String ans, ArrayList<String> result, String keypad[]) {
        if(l == N) {
            result.add(ans);
            return;
        }
        String letters = keypad[a[l]];
        for(int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            generate(l + 1, a, N, ans + letter, result, keypad);
        }
    }
}
         