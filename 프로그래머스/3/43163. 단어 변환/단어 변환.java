import java.util.*;
import java.io.*;

class Solution {
    int ans = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        for(int i=0; i<words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if(checkChar(begin, words[i])) {
                visited[i] = true;
                recur(1, words[i], words, visited, target);
                visited[i] = false;
            }
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
    public void recur(int cnt, String s, String[] words, boolean[] visited, String target) {
        if(s.equals(target)) {
            ans = Math.min(cnt, ans);
            return;
        }
        if(cnt > words.length) return;
        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            if(checkChar(s, words[i])) recur(cnt+1, words[i], words, visited, target);
            visited[i] = false;
        }
    }
    public boolean checkChar(String begin, String words) {
        int notdup = 0;
        for(int i=0; i<begin.length(); i++) {
            if(begin.charAt(i) != words.charAt(i)) notdup++;
        }
        if(notdup == 1) {
            return true;
        }
        return false;
    }
}