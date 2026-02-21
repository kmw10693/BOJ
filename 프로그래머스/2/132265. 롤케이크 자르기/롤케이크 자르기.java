import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        
        for(int t : topping) {
            m1.put(t, m1.getOrDefault(t, 0) + 1);
        }
        
        int answer = 0;
        for(int t : topping) {
            m2.put(t, m2.getOrDefault(t, 0) + 1);
            
            if(m1.get(t) == 1) m1.remove(t);
            else m1.put(t, m1.get(t)-1);
            
            if(m1.size() == m2.size()) answer++;
        }
        return answer;
    }
}