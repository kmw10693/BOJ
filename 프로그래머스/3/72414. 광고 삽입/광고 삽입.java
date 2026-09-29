import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play_m = tosecond(play_time);
        int adv_m = tosecond(adv_time);
        int[] playsub = new int[play_m+2];
        
        for(String log : logs) {
            String[] split = log.split("-");
            int start = tosecond(split[0]);
            int end = tosecond(split[1]);
            playsub[start]++;
            playsub[end]--;
        }
        
        for(int i=1; i<=play_m; i++) {
            playsub[i] += playsub[i-1]; 
        }
        
        long[] sum = new long[play_m+2];
        
        for(int i=0; i<play_m; i++) {
            sum[i+1] = sum[i] + playsub[i]; 
        }
        
        long maxtime = -1;
        long realstarttime = 0;
        
        for(int start=0; start+adv_m<=play_m; start++) {
            int starttime = start;
            int endtime = start+adv_m;
            
            long gaptime = sum[endtime] - sum[starttime];
            
            if(gaptime > maxtime) {
                maxtime = gaptime;
                realstarttime = starttime;
            }
        }
        
        return toString(realstarttime);        
    }
    String toString(long time) {
        long hour = time / 3600;
        time %= 3600;
        long minute = time / 60;
        long second = time % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    int tosecond(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]) * 3600;
        int minute = Integer.parseInt(split[1]) * 60;
        int second = Integer.parseInt(split[2]);
        
        return hour + minute + second;
    }
}