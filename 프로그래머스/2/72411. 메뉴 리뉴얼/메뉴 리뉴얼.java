import java.util.*;
import java.io.*;

class Solution {
    public void dfs(String s, String origin, int idx, Map<String, Integer> map, int goal) {
        if(s.length() == goal) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for(int i=idx+1; i<origin.length(); i++) {
            dfs(s+origin.charAt(i), origin, i, map, goal);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0; i<orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = new String(c);
        }
        
        List<String> ans = new ArrayList<>();
        for(int c : course) {
            
            Map<String, Integer> map = new HashMap<>();
            for(String o : orders) {
                dfs("", o, -1, map, c);
            }
            
            int maxin = -1;
            for(String s : map.keySet()) {
                maxin = Math.max(maxin, map.get(s));
            }
            
            if(maxin >= 2) {
                for(String s : map.keySet()) {
                    if(map.get(s) == maxin) ans.add(s);
                }                    
            }
        }
        
        String[] realans = new String[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            realans[i] = ans.get(i);
        }
    
        
        Arrays.sort(realans);
        return realans;
    }
}