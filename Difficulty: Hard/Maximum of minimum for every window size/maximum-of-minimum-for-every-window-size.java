//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        Stack<Integer> sta= new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!sta.isEmpty() && arr[sta.peek()]>= arr[i])
            {
                sta.pop();
            }
            if(sta.isEmpty())
            {
                left[i]=-1;
            }
            else
            {
                left[i]=sta.peek();
            }
            sta.add(i);
        }
        sta.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!sta.isEmpty() && arr[sta.peek()]>= arr[i])
            {
                sta.pop();
            }
            if(sta.isEmpty())
            {
                right[i]=n;
            }
            else
            {
                right[i]=sta.peek();
            }
            sta.add(i);
        }
        int res[]=new int[n+1];
 for (int i = 0; i < n; i++) {
        int len = right[i] - left[i] - 1;
        res[len] = Math.max(res[len], arr[i]); 
    }

    for (int i = n - 1; i >= 1; i--) {
        res[i] = Math.max(res[i], res[i + 1]);
    }

    int result[] = new int[n];
    for (int i = 1; i <= n; i++) { 
        result[i - 1] = res[i];
    }

    return result; 
}}