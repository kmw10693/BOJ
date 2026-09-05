import java.util.*;
import java.io.*;


class Solution {
    
    int ans = 0;
    Set<Integer> dup = new HashSet<>();
    
    public void dfs(String s, String numbers, boolean[] visited) {    
        if(s.length() >= 1) {
            int num = Integer.parseInt(s);
            boolean isprime = true;

            if(num == 0) isprime = false;
            if(num == 1) isprime = false;
        
            for(int i=2; i<num; i++) {
                if(num % i == 0) {
                    isprime = false;
                    break;
                }
            }
            if(isprime && !dup.contains(num)) {
                ans++;
                dup.add(num);
            }
        }
    
        for(int i=0; i<numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(s+numbers.charAt(i), numbers, visited);
            visited[i] = false;
        }
    }
    public int solution(String numbers) {
        
        dfs("", numbers, new boolean[numbers.length()]);
        return ans;
    }
}