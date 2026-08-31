import java.util.*;
import java.io.*;

class Solution {
    boolean isdup = false;
    int ans = 0;
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] relation) {
        for(int i=1; i<=relation[0].length; i++) {
            dfs(0, i, "", new boolean[relation[0].length], relation);    
        }
        return ans;
    }
    
    public void dfs(int cnt, int goal, String s, boolean[] visited, String[][] relation) {
        if(cnt >= goal) {
            comb("", s, new boolean[s.length()]);
            
            if(isdup) {
                isdup = false;
                return;
            }
            
            if(check(s, relation)) {
                ans++;
                map.put(s,1);
            }
            return;
        }
        
        for(int i=0; i<relation[0].length; i++) {
            if(visited[i]) continue;
            if(!s.isEmpty() &&  s.charAt(s.length() - 1) - '0' >= i) continue;
            
            visited[i] = true;
            dfs(cnt+1, goal, s+i, visited, relation);
            visited[i] = false;
        }
             
    }
    
    public boolean check(String s, String[][] relation) {
        Set<String> s2 = new HashSet<>();
        
        for(int i=0; i<relation.length; i++) {
            String key = "";
            for(int j=0; j<s.length(); j++) {
                int k = (s.charAt(j) - '0');
                key += relation[i][k];
            }
            s2.add(key);
        }
        return s2.size() == relation.length;
    }
               
    public void comb(String s, String s2, boolean[] visited) {
        if(s.length() >= s2.length()) return;
        
        if(map.containsKey(s)) {
            isdup = true;
            return;
        }
        
        for(int i=0; i<s2.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            comb(s+s2.charAt(i), s2, visited);
            visited[i] = false;
        }
    }
}