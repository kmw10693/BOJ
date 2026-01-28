import java.util.*;
import java.io.*;

class Solution {
    int ans = 0;
    int maxIndex;
    public int solution(int[] numbers, int target) {
        maxIndex = numbers.length - 1;
        recur(numbers, 0, 0, target);
        return ans;
    }
    public void recur(int[] numbers, int index, int sum, int target) {
        if(index > maxIndex) {

            if(sum == target) ans++;
            return;
        }
        recur(numbers, index+1, sum+numbers[index], target);
        recur(numbers, index+1, sum-numbers[index], target);
    }
}