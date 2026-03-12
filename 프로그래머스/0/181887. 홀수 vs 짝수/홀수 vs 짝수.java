import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] num_list) {
        int holsum =0;
        int jjaksum =0;
        for(int i=0; i<num_list.length; i++) {
            if(i % 2 == 0) jjaksum += num_list[i];
            else holsum += num_list[i];
        }
        
        return Math.max(holsum, jjaksum);
    }
}