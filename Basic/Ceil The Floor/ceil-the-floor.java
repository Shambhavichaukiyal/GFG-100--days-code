//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends



class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Arrays.sort(arr); // Sort the array in ascending order

        int l = 0;
        int r = n - 1;
        int floor = -1;
        int ceil = -1;

        // Finding the floor
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return new Pair(arr[mid], arr[mid]);
            } else if (arr[mid] < x) {
                floor = arr[mid];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // Finding the ceil
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return new Pair(arr[mid], arr[mid]);
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                ceil = arr[mid];
                r = mid - 1;
            }
        }

        return new Pair(floor, ceil);
    }
}
