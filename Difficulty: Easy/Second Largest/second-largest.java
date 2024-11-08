//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] nums) {
              if (nums.length < 2) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(2);

        for (int num : nums) {
            // Only add unique elements to the heap
            if (!minHeap.contains(num)) {
                minHeap.offer(num);

                // Maintain heap size of 2 by removing the smallest element if necessary
                if (minHeap.size() > 2) {
                    minHeap.poll();
                }
            }
        }

        // If we don't have two unique elements, return -1
        if (minHeap.size() < 2) {
            return -1;
        }

        return minHeap.poll();  // The root of the heap will be the second largest
    }
}