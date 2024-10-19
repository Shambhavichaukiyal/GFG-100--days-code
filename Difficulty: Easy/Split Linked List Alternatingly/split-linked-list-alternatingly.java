//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    Node[] alternatingSplitList(Node head) {
        Node t1=head;
        Node t2=head.next;
        Node temp1=t1;
        Node temp2=t2;
        if(head==null || head.next==null)
        {
            return new Node[]{head, null};
            
        }
        while(t1!=null && t1.next!=null && t2!=null && t2.next!=null)
        {
            t1.next=t1.next.next;
            t1=t1.next;
            t2.next=t2.next.next;
            t2=t2.next;
            
        }
        
        if(t1!=null)
        {
            t1.next=null;
        }
        if(t2!=null)
        {
            t2.next=null;
        }
        return new Node[]{temp1, temp2}; 
    }
}