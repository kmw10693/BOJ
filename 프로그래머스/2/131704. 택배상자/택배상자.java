import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> s = new Stack<>();
        int box = 1;
        
        int ans = 0;
        for(int o : order) {
            while(box < o) {
                s.push(box);
                box++;
            }
            
            if(box == o) {
                box++;
                ans++;
            } else if(!s.isEmpty() && s.peek() == o) {
                s.pop();
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}