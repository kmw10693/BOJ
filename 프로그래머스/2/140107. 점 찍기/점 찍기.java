import java.util.*;
import java.io.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0; i<=d; i+=k) {
            long s = (long)d * d;
            long l = (long)i * i;
            
            int y = (int)Math.sqrt(s-l);
            answer += (y/k) + 1;
        }
        return answer;
    }
}