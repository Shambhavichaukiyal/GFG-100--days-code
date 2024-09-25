//{ Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 


// } Driver Code Ends


//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    int result[]=new int[n];
	    Stack<Integer> sta= new Stack<>();
	    sta.push(arr[n-1]);
	    result[n-1]=-1;
	    for(int i=n-2;i>=0;i--)
	    {
	        while(!sta.isEmpty() && sta.peek() >=arr[i])
	        {
	            sta.pop();
	        }
	        if(sta.isEmpty())
	        {
	            result[i]=-1;
	        }
	        else
	        {
	            result[i]=sta.peek();
	        }
	        sta.push(arr[i]);
	    }
	    return result;
	} 
}
