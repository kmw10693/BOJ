import java.io.*;
import java.util.*;

class Solution {
    Set<String> anslist = new HashSet<>();
    
    public boolean canmake(String a, String b) {
        if(a.length() != b.length()) return false;
        for(int i=0; i<a.length(); i++) {
            if(b.charAt(i) != '*' && a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
    
    public void dfs(int cnt, List<String> s, boolean[] visited, String[] user_id, String[] banned_id) {
        if(cnt == banned_id.length) {
            String[] arr = new String[s.size()];
            for(int i=0; i<arr.length; i++) {
                arr[i] = s.get(i);
            }
            Arrays.sort(arr);
            String allsen = "";
            
            for(int i=0; i<arr.length; i++) {
                allsen += arr[i] +"|";
            }
            anslist.add(allsen);
            
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(visited[i]) continue;
            if(!canmake(user_id[i], banned_id[cnt])) continue;
            visited[i] = true;
            s.add(user_id[i]);
            dfs(cnt+1, s, visited, user_id, banned_id);
            s.removeLast();
            visited[i] = false;
        }
        
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, new ArrayList<>(), new boolean[user_id.length], user_id, banned_id);
        return anslist.size();
    }
}