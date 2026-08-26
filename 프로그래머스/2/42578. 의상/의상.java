import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        int ans = 1;
        for(String k : map.keySet()) {
            ans *= (map.get(k) + 1);
        }
        return ans - 1;
    }
}