//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    private static PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
    private  static PriorityQueue<Integer> minheap=new PriorityQueue<>();
    //Function to insert heap.
    public static void insertHeap(int x)
    {
      maxheap.add(x);
      balanceHeaps();
    
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
      if(maxheap.size()>minheap.size()+1)
      {
          minheap.add(maxheap.poll());
      }
      if(!minheap.isEmpty() && maxheap.peek()>minheap.peek())
      {
          maxheap.add(minheap.poll());
          minheap.add(maxheap.poll());
      }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(maxheap.size()>minheap.size())
        {
            return maxheap.peek();
        }
        else
        {
            return (maxheap.peek()+minheap.peek())/2.0;
        }
    }
    
}