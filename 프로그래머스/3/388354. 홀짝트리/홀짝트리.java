import java.util.*;

class Solution {
    int[] parent;
    int[] size;
    
    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) {
            return;
        }
        
        if(size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }
    
    public int[] solution(int[] nodes, int[][] edges) {
        parent = new int[1000001];
        size = new int[1000001];
        
        int[] degree = new int[1000001];
        
        int[] sameCount = new int[1000001];
        int[] diffCount = new int[1000001];
        
        for(int node : nodes) {
            parent[node] = node;
            size[node] = 1;
        }
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            degree[a]++;
            degree[b]++;
            
            union(a,b);
        }
        
        for(int node : nodes) {
            int root = find(node);
            
            int nodep = node % 2;
            int degreep = degree[node] % 2;
            
            if(nodep == degreep) sameCount[root]++;
            else diffCount[root]++;
        }
        
        int oddEven = 0;
        int reverseOdd = 0;
        
        for(int node : nodes) {
            if(find(node) != node) continue;
            if(sameCount[node] == 1) oddEven++;
            if(diffCount[node] == 1) reverseOdd++;
        }
        
        return new int[]{oddEven, reverseOdd};
    }
}