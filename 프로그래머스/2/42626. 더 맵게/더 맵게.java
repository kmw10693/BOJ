import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        Queue<Long> pq = new PriorityQueue<>();
        
        for(long s : scoville) {
            pq.add(s);
        }
        
        while(!pq.isEmpty()) {
            if(pq.peek() >= K) return count;
            
            if(pq.size() < 2) return -1;
            long first = pq.poll();
            long second = pq.poll();
                        
            count++;
            pq.offer(first + (second * 2));
        }
        return -1;
        
        
    }
}