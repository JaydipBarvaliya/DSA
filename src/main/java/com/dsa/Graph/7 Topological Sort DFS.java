package com.dsa.Graph;// Time Complexity: O(N+E)
// N = Number of node , E = Number of Edges
// Space Complexity: O(N) + O(N)
// Visited Array and Stack data structure. Both will be using O(N).
// Auxiliary Space Complexity:  O(N)
// Recursion call of DFS

class Solution{

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){

        boolean[] visited = new boolean[V];
        int[]     answer = new int[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++){
            if(visited[i] == false){
                dfs(i, adj, visited, stack);
            }
        }

        for(int i=0; i<V; i++){
            answer[i] = stack.pop();
        }
        return answer;
    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack ){
        
        visited[curr] = true;
        for(int neigh: adj.get(curr)){
             if(visited[neigh] == false){
                dfs(neigh, adj, visited, stack);
            }
        }
        stack.push(curr);
    }
}