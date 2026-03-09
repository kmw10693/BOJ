import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int total = n - k;
        
        // 멘토 수
        int[] mentos = new int[k+1];
        
        Arrays.fill(mentos, 1);
        
        while(total > 0) {
            
            int realmentoindex = -1;
            int eachmintime = Integer.MAX_VALUE;
            for(int i=1; i<=k; i++) {
                mentos[i]++;
                if(eachmintime > gettotalwaittime(reqs, mentos, k)) {
                    realmentoindex = i;
                    eachmintime = gettotalwaittime(reqs, mentos, k);
                }
                mentos[i]--;
            }
            mentos[realmentoindex]++;
            total--;
        }
        
      
     
        int ans = 0;
        ans = gettotalwaittime(reqs, mentos, k);
        return ans;
    }
    
    private int gettotalwaittime(int[][] reqs, int[] mentos, int k) {
        
        int temptime = 0;
        for(int i=1; i<=k; i++) {
            temptime += checkmintime(reqs, mentos, i);
        }
        return temptime;
    }
    
    public int checkmintime(int[][] reqs, int[] mentos, int menteidx) {
        int eachmintime = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int [] req : reqs) {
            int startmin = req[0];
            int duration = req[1];
            int targetdiv = req[2];
            
            if(targetdiv != menteidx) continue;
            
            if(pq.size() < mentos[menteidx]) {
                pq.offer(startmin + duration);
                continue;
            }
            
            int lastmin = pq.poll();
            eachmintime += Math.max(0, lastmin - startmin);
            pq.offer(Math.max(startmin, lastmin) + duration);
        }
        return eachmintime;
    }
}