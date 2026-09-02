import java.util.*;
import java.io.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i=0; i<orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = new String(c);
        }
        
        for(int c : course) {
            for(int i=0; i<orders.length; i++) {
                dfs("", c, 0, -1, orders, orders[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(int c : course) {
            
            int maxcount = -1;
            for(String key : map.keySet()) {
                int eachcount = map.get(key);
                if(key.length() != c) continue;
                if(eachcount > maxcount) maxcount = eachcount; 
            }
            
            if(maxcount < 2) continue;
            
            for(String key : map.keySet()) {
                if(map.get(key) == maxcount && key.length() == c) ans.add(key);
            }
        }
        
        String[] result = new String[ans.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = ans.get(i);
        }
        
        Arrays.sort(result, (a,b) -> a.compareTo(b));
    
        return result;
    }
    
    public void dfs(String s, int course, int cnt, int lastidx, String[] orders, String order)  {
        if(cnt >= course) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for(int i=0; i<order.length(); i++) {
            if(lastidx >= i) continue;
            dfs(s+order.charAt(i), course, cnt+1, i, orders, order);
        }
    }
}