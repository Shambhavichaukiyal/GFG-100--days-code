//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
   
    public static long getMaxArea(long hist[], long n) 
    {
        Stack<Integer> sts=new Stack<>();
        int left[]=new int[hist.length];
        int right[]=new int[hist.length];
        for(int i=0;i<hist.length;i++)
        {
            while(!sts.isEmpty() && hist[sts.peek()]>=hist[i])
            {
                sts.pop();
            }
            if(sts.isEmpty())
            {
                left[i]=-1;
            }
            else
            {
                left[i]=sts.peek();
            }
            sts.push(i);
        }
        sts.clear();
          for(int i=hist.length-1;i>=0;i--)
        {
            while(!sts.isEmpty() && hist[sts.peek()]>=hist[i])
            {
                sts.pop();
            }
            if(sts.isEmpty())
            {
                right[i]=hist.length;
            }
            else
            {
                right[i]=sts.peek();
            }
            sts.push(i);
        }
        long maxArea=0;
        long area=0;
         for(int i=0;i<hist.length;i++)
        {
            long width=right[i]-left[i]-1;
             area=width*hist[i];
             maxArea=Math.max(area,maxArea);
    }
    return maxArea;
        
}}



