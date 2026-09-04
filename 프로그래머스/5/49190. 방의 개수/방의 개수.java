import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {-1,-1,0,1,1,1,0,-1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};
    
    public int solution(int[] arrows) {
        
        Set<String> node = new HashSet<>();
        Set<String> edge = new HashSet<>();
        node.add(0 + "," + 0);
        
        int x = 0, y = 0;
        int ans = 0;
        for(int arrow : arrows) {
            for(int i=0; i<2; i++) {
                int beforex = x, beforey = y;
                
                String start = x + "," + y + "->";
                x += dx[arrow];
                y += dy[arrow];
                start += x + "," + y;                
                
                String reverse = x + "," + y + "->";
                reverse += beforex + "," + beforey;
                
                String endnode = x + "," + y;
                if(node.contains(endnode) && !edge.contains(start)) ans++;
                
                node.add(endnode);
                edge.add(start);
                edge.add(reverse);
            }
        }
        return ans;
    }
}