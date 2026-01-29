import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            if(n < 0) {
                if(k > 0) {
                   if(!pq.isEmpty()) n += pq.poll();
                   k--;
                } else {
                    break;
                }
            }
            ans++;
        }
        return ans;
    }
}