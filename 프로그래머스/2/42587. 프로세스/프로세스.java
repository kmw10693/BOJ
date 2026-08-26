import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        int ansidx = 0;
        while(!q.isEmpty()) {
            boolean hasHigher = false;

            int[] curelement = q.poll();
            for(int[] each : q) {
                if(curelement[0] < each[0]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher) {
                q.offer(new int[]{curelement[0], curelement[1]});
            } else {
                ansidx++;
                if(location == curelement[1]) {
                    return ansidx;
                }
            }
            
        }
        return -1;
    }
}