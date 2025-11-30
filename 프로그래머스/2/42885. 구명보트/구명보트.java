import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int ans = 0;
        for(int i=people.length-1; i>=start; i--) {
            if(people[i] + people[start] <= limit) {
                start++;
                ans++;
            }
            else ans++;
            // 50 50 70 80
        }
        return ans;
    }
}