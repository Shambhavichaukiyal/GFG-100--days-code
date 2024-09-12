//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Finding the min and max elements in the matrix
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }

        int requiredCount = (R * C + 1) / 2; // to get the median

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessThanOrEqual(matrix, R, C, mid);

            if (count < requiredCount) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Count number of elements less than or equal to `mid`
    public static int countLessThanOrEqual(int[][] matrix, int R, int C, int mid) {
        int count = 0;
        for (int i = 0; i < R; i++) {
            count += countInRow(matrix[i], mid, C);
        }
        return count;
    }

    // Count number of elements in the row less than or equal to `mid`
    public static int countInRow(int[] row, int mid, int C) {
        int low = 0, high = C - 1;
        while (low <= high) {
            int midIndex = low + (high - low) / 2;
            if (row[midIndex] <= mid) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }
        return low; // Number of elements <= `mid`
    }
}     
    