import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int startTime = getMin("09:00");
        
        int[] timetablelist = new int[timetable.length];
        boolean[] visited = new boolean[timetable.length];
        
        for(int i=0; i<timetable.length; i++) {
            timetablelist[i] = getMin(timetable[i]);
        }
        Arrays.sort(timetablelist);
        String answer = "";
        
        for(int i=1; i<=n; i++) {
            // 마지막
            if(i == n) {
                int tmpsize = m;
                for(int j=0; j<timetablelist.length; j++) {
                    if(!visited[j] && timetablelist[j] <= startTime && tmpsize > 0) {
                        visited[j] = true;
                        tmpsize--;
                    }
                }
                
                if(tmpsize > 0) {
                    return getTimeStr(startTime);
                } else {
                    // 마지막으로 boolean이 true인 경우를 반환하면 되겠지
                    for(int j=timetablelist.length-1; j>=0; j--) {
                        if(visited[j] == true) {
                            int lasttime = timetablelist[j];
                            while(--lasttime >= 0) {
                                if(lasttime <= startTime) {
                                    return getTimeStr(lasttime);
                                }
                            }
                        }
                    }
                }
            } else {
                int tmpsize = m;
                for(int j=0; j<timetablelist.length; j++) {
                    if(!visited[j] && timetablelist[j] <= startTime && tmpsize > 0) {
                        visited[j] = true;
                        tmpsize--;
                    }
                }  
            }
            startTime += t;
        }
        return "23:59";
    }
    
    private int getMin(String time) {
        String[] splitlist = time.split(":");
        return Integer.parseInt(splitlist[0]) * 60 + Integer.parseInt(splitlist[1]);
    }
    
    private String getTimeStr(int min) {
        int hour = min / 60;
        int minute = min % 60;
        
        String strTime = "";
        for(int i=0; i<2; i++) {
            strTime += String.valueOf(hour % 10);
            hour /= 10;
        }
        strTime = new StringBuilder(strTime).reverse().toString();
        
        strTime += ":";
        
        String strMin = "";
        for(int i=0; i<2; i++) {
            strMin += String.valueOf(minute % 10);
            minute /= 10;
        }
        
        strMin = new StringBuilder(strMin).reverse().toString();
        strTime += strMin;
        
        return strTime;
    }
}