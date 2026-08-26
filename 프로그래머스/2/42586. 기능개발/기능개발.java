import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> arr = new ArrayList<>();
        
        int firstremains = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        int count = 1;
        
        for(int i=1; i<progresses.length; i++) {
            
            int nextremains = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            
            if(firstremains < nextremains) {
                firstremains = nextremains;
                arr.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        arr.add(count);
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}