import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));
        
        int loc = 0;
        int ans = 0;
        for(int i=0; i<targets.length; i++) {
            if(loc <= targets[i][0]) {
                loc = targets[i][1];
                ans++;
            }
        }
        return ans;
    }
}