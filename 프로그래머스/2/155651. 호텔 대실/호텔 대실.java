import java.util.*;
import java.io.*;

class Solution {
    class Room {
        int start, end;
        Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[][] book_time) {
        int[][] booktime = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++) {
            booktime[i][0] = convert(book_time[i][0]);
            booktime[i][1] = convert(book_time[i][1]);
        }
        Arrays.sort(booktime, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        List<List<Room>> rooms = new ArrayList<>();
        int result = 0;
        for(int[] b : booktime) {
            int start = b[0];
            int end = b[1];
            
            boolean newroom = true;
            for(List<Room> room : rooms) {
                Room lastroom = room.getLast();
                if(start >= lastroom.end + 10) {
                    lastroom.start = start;
                    lastroom.end = end;
                    newroom = false;
                    break;
                }
            }
            
            if(newroom) {
                List<Room> room = new ArrayList<>();
                room.add(new Room(start, end));
                rooms.add(room);
                result++;
            }
        }
        return result;
    }
    
    public int convert(String time) {
        String[] splits = time.split(":");
        return Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);
    }
    
}