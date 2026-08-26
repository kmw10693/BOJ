import java.io.*;
import java.util.*;

class Solution {
    int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return ans;
    }
    public void dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) ans++;
            return;
        }
        
        dfs(numbers, target, index+1, sum+numbers[index]);
        dfs(numbers, target, index+1, sum-numbers[index]);
    }
}