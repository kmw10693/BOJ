import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int answerleft = 0;
        int answerright = 0;
        int minlength = Integer.MAX_VALUE;
        
        int sum = 0;
        int left = 0;
        for(int right=0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k) {
                int distance = right + 1 - left;
                if(distance < minlength) {
                    answerleft = left;
                    answerright = right;
                    minlength = distance;
                }
            }
        }
        return new int[]{answerleft, answerright};
    }
}