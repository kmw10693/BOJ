import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> ins = new HashMap<>();
        Map<Integer, Integer> outs = new HashMap<>();
        int[] answer = new int[4];
        
        for(int[] edge : edges) {
            int out = edge[0];
            int in = edge[1];
            outs.put(out, outs.getOrDefault(out, 0)+1);
            ins.put(in, ins.getOrDefault(in, 0) +1);
        }
        
        for(int key: outs.keySet()) {
            if(!ins.containsKey(key)) {
                if(outs.get(key) >= 2) answer[0] = key;
            }
            else if(outs.get(key) == 2) {
                answer[3]++;
            }
        }
        for(int key: ins.keySet()) {
            if(!outs.containsKey(key) && ins.get(key) >=1) answer[2]++;
        }
        answer[1] = outs.get(answer[0]) - answer[2] - answer[3];
        return answer;
        
    }
}