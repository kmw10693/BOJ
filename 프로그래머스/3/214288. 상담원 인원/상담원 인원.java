import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int k, int n, int[][] reqs) {
        int remain = n-k;
        int[] mentos = new int[k+1];
        Arrays.fill(mentos, 1);
        
        for(int i=1; i<=remain; i++) {
            int realminidx = -1;
            int eachtemptime = Integer.MAX_VALUE;
            
            for(int j=1; j<=k; j++) {
                mentos[j]++;
                if(eachtemptime > gettotaltime(reqs, k, mentos)) {
                    realminidx = j;
                    eachtemptime = gettotaltime(reqs, k, mentos);
                }
                mentos[j]--;
            }
            mentos[realminidx]++;
        }
        return gettotaltime(reqs, k, mentos);
    }
    
    public int gettotaltime(int[][] reqs, int k, int[] mentos) {
        int totalwait = 0;
        for(int i=1; i<=k; i++) {
            totalwait += geteachtime(reqs, i, mentos);
        }
        return totalwait;
    }
    
    public int geteachtime(int[][] reqs, int menteidx, int[] mentos) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        int totalwait = 0;
        
        for(int[] req : reqs) {
            int starttime = req[0];
            int duration = req[1];
            int idx = req[2];
            
            if(menteidx != idx) continue;
            
            if(pq.size() < mentos[idx]) {
                pq.offer(starttime + duration);
                continue;
            }
            
            int mentoendtime = pq.poll();
            pq.offer(Math.max(mentoendtime, starttime) + duration);
            totalwait += Math.max(0, mentoendtime - starttime);
        }
        return totalwait;
    }
}