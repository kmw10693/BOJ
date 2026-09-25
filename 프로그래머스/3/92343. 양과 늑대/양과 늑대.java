import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    List<Integer>[] tree;
    int[] info;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        int n = info.length;
        
        tree = new ArrayList[n];
        for(int i=0; i<n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            tree[parent].add(child);
        }
        List<Integer> next = new ArrayList<>();
        next.add(0);
        
        dfs(0, 0, next);
        return answer;
    }
    
    void dfs(int sheep, int wolf, List<Integer> next) {
        for(int i=0; i<next.size(); i++) {
            int node = next.get(i);
            
            int nextsheep = sheep;
            int nextwolf = wolf;
            
            if(info[node] == 0) {
                nextsheep++;
            } else {
                nextwolf++;
            }
            
            if(nextwolf >= nextsheep) continue;
            answer = Math.max(answer, nextsheep);
            
            List<Integer> newNext = new ArrayList<>(next);
            newNext.remove(Integer.valueOf(node));
            newNext.addAll(tree[node]);
            
            dfs(nextsheep, nextwolf, newNext);
        }
    }
}