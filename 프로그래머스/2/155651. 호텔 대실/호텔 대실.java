import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] new_book = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            for(int j=0; j<2; j++) {
                new_book[i][j] = convert(book_time[i][j]);
            }
        }
        Arrays.sort(new_book, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        int ans = 0;
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<new_book.length; i++) {
            int[] book = new_book[i];
            
            boolean check = true;
            for(int j=0; j<list.size(); j++) {
                int[] listTime = list.get(j);
                if(book[0] >= listTime[1] + 10) {
                    list.set(j, new int[]{book[0], book[1]});
                    check = false;
                    break;
                }
            }
            if(check) {
                ans++;
                list.add(new int[]{book[0], book[1]});
            }
        }
        return ans;
    }
    public int convert(String s) {
        String[] hour = s.split(":");
        return Integer.parseInt(hour[0])*60 + Integer.parseInt(hour[1]);
    }
}