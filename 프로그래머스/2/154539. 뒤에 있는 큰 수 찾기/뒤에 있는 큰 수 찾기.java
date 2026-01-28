import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        
        for(int i=0; i<numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                ans[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return ans;
    }
}