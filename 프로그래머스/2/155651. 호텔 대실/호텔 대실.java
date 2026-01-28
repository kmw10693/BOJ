import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        Time[] times = new Time[book_time.length];
        for(int i=0; i<book_time.length; i++) {
            int start = convert(book_time[i][0]);
            int end = convert(book_time[i][1]);

            times[i] = new Time(start, end);
        }
        Arrays.sort(times, (o1, o2) -> {
            if(o1.start != o2.start) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        
        int room = 0;
        List<Time> vacant = new ArrayList<>();
        for(int i=0; i<times.length; i++) {
            Time cur = times[i];
            
            // vacant에 방있는지 확인
            if(!vacant.isEmpty()) {
                boolean check = false;
                for(int j=0; j<vacant.size(); j++) {
                    Time roomv = vacant.get(j);
                    if(cur.start >= roomv.end + 10) {
                        vacant.set(j, new Time(cur.start, cur.end));
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    room++;
                    vacant.add(new Time(cur.start, cur.end));
                }
            } else {
                vacant.add(new Time(cur.start, cur.end));
                room++;   
            }
        }
       
        return room;
    }

    public int convert(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    class Time {
        int start, end;
        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}