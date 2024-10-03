//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
 int ele1 = 0, ele2 = 0, cnt1 = 0, cnt2 = 0;

        // Step 1: Finding the potential candidates
        for (int num : nums) {
            if (num == ele1) {
                cnt1++;
            } else if (num == ele2) {
                cnt2++;
            } else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Resetting counts for final verification
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) {
                cnt1++;
            } else if (num == ele2) {
                cnt2++;
            }
        }

        // Step 3: Collecting results
        List<Integer> result = new ArrayList<>();
        int threshold = nums.size() / 3;
        if (cnt1 > threshold) {
            result.add(ele1);
        }
        if (cnt2 > threshold && ele1 != ele2) {
            result.add(ele2);
        }

        // Step 4: Returning the result
        if (result.isEmpty()) {
            result.add(-1);
        } else {
            Collections.sort(result);
        }

        return result;
    }}