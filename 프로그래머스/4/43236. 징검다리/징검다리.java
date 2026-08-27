import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int init = 0;
            int count = 0;
            
            for(int rock : rocks) {
                if(rock - init < mid) {
                    count++;
                } else {
                    init = rock;
                }
            }
            if(distance - init < mid) count++;
            
            if(count > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;   
    }
}