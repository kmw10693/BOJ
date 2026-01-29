import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        long ans = 0;
        for(int weight: weights) {
            double c = weight * 1.0;
            double c1 = weight * (3/4.0);
            double c2 = weight * (1/2.0);
            double c3 = weight * (2/3.0);
            
            if(map.containsKey(c)) ans += map.get(c);
            if(map.containsKey(c1)) ans += map.get(c1);
            if(map.containsKey(c2)) ans += map.get(c2);
            if(map.containsKey(c3)) ans += map.get(c3);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return ans;
    }
}