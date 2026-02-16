import java.util.*;
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        
        int sum = 0;
        int anssize = Integer.MAX_VALUE;
        
        while(right < sequence.length) {
            sum += sequence[right];
            
            while(left < sequence.length && sum > k) {
                sum -= sequence[left++];
            }
            
            if(sum == k) {
                int size = right + 1 - left;
                if(anssize > size) {
                    anssize = size;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
        }
        return answer;
    }
}