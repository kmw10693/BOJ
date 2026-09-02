import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] cards) {
        
        boolean[] visited = new boolean[cards.length];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<cards.length; i++) {
            if(visited[i]) continue;
            
            int count = 1;
            int nxt = cards[i];
            visited[i] = true;
            while(!visited[nxt-1]) {
                count++;
                visited[nxt-1] = true;
                nxt = cards[nxt-1];
            }
            ans.add(count);
        }
        if(ans.size() < 2) return 0;
        ans.sort(Collections.reverseOrder());
        
        
        return ans.get(0) * ans.get(1);
    }
}