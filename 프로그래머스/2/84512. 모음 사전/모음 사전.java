import java.util.*;
import java.io.*;

class Solution {
    int ans = 0;
    boolean isanswer = false;
    
    public int solution(String word) {
        dfs("", word);
        return ans-1;
    }
    
    public void dfs(String start, String word) {
        if(isanswer) return;
        
        ans++;
        if(start.equals(word)) {
            isanswer = true;
            return;
        }
        
        if(start.length() == 5) {
            return;
        }
        
        start += "A";
        dfs(start, word);
        start = start.substring(0, start.length()-1);
        
        start += "E";
        dfs(start, word);
        start = start.substring(0, start.length()-1);
        
        start += "I";
        dfs(start, word);
        start = start.substring(0, start.length()-1);
        
        start += "O";
        dfs(start, word);
        start = start.substring(0, start.length()-1);
        
        start += "U";
        dfs(start, word);
        start = start.substring(0, start.length()-1);
    }
}