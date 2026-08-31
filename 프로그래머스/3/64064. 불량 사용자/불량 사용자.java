import java.util.*;
import java.io.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(-1, banned_id, "", 0, user_id, new boolean[user_id.length]);
        return map.size();
    }
    
    public void dfs(int lastidx, String[] banned_id, String s, int cnt, String[] user_id, boolean[] visited) {
        if(cnt == banned_id.length) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(i).append(",");
                }
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(visited[i]) continue;
            
            if(check(banned_id[cnt], user_id[i])) {
                visited[i]= true;
                dfs(i, banned_id, s+user_id[i], cnt+1, user_id, visited);
                visited[i] = false;
            }
        }
    }
    public boolean check(String ban, String s) {
        if(ban.length() != s.length()) return false;
        for(int i=0; i<ban.length(); i++) {
            if(ban.charAt(i) != '*' && ban.charAt(i) != s.charAt(i)) return false;
        }
        return true;
    }
    
    
}