//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	int vis[]=new int[n];
	for(int i=0;i<n;i++)
	{
	    vis[i]=-1;
	}
	int sum=0;
	for(int num:a)
	{
	    sum=sum+num;
	}
	if(sum%k!=0)
	{
return false;
    }
    else
    {
        return generate(a,k,vis,sum/k,0,0);
    }}
    public static boolean generate(int a[],int k,int vis[],int targetsum,int currentsum,int index)

        {
            if(k==1)
            {
                return true;
            }
            if(currentsum==targetsum)
            {
                return generate(a,k-1,vis,targetsum,0,0);
            }
            for(int i=index;i<a.length;i++)
            {
               if (vis[i] == -1 && currentsum + a[i] <= targetsum) {
                vis[i] = 1;
                if (generate(a, k, vis, targetsum, currentsum + a[i], i + 1)) {
                    return true;
                }
                vis[i] = -1;
            }
            }
            return false;
        }
    }
