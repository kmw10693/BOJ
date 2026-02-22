import java.util.*;
import java.io.*;

class Solution {
    Set<Long> s = new HashSet<>();
    
    public int solution(int[] elements) {
        
        for(int i=1; i<=elements.length; i++) {
            putsum(elements, i);
        }
        return s.size();
    }
    
    public void putsum(int[] elements, int length) {
        // 0 ~ 5
        for(int i=0; i<elements.length; i++) {
            long sum = 0L;
            
            // 0 ~
            for(int j=i; j<i+length; j++) {
                int index = j % elements.length;
                sum += elements[index];
            }
            s.add(sum);
        }
    }
}