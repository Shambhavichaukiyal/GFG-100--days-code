//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG {
    int minEle;
    private Stack<Integer> s;
    private Stack<Integer> sta;
    
    GfG() {
        s = new Stack<>();
        sta = new Stack<>();
    }

    /* Returns min element from stack */
    int getMin() {
        if (!sta.isEmpty()) {
            return sta.peek();
        }
        return -1;
    }
    
    /* Returns popped element from stack */
    int pop() {
        if (!s.isEmpty()) {
            int popped = s.pop();
            if (popped == sta.peek()) {
                sta.pop(); // If the popped element from s is the min, pop it from sta
            }
            return popped;
        }
        return -1;
    }

    /* Push element x into the stack */
    void push(int x) {
        if (sta.isEmpty() || sta.peek() >= x) {
            sta.push(x);
        }
        s.push(x);
    }   
}
