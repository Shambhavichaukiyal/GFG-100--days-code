//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    class Pair {
    int node;
    int parent;
    
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        int vis[]= new int[V];
        for(int i=0;i<V;i++)
        {
            vis[i]=-1;
        }
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==-1)
            {
               if (bfs(i, adj, vis))

               {
                   return true;
               }
            }
        }
        return false;
        
        
    }
    private boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        vis[node] = 1;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curr = p.node;
            int parent = p.parent;
            
            for (int neighbor : adj.get(curr)) {
                if (vis[neighbor] == -1) {
                    vis[neighbor] = 1;
                    q.add(new Pair(neighbor, curr));
                }
                else if (neighbor != parent) {
                    return true; // cycle found
                }
            }
        }
        
        return false;
    }
}