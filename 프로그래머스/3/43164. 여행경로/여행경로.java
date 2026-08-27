import java.util.*;
import java.io.*;

class Solution {
    List<String[]> anslist = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
       for(int i=0; i<tickets.length; i++) {
           if(tickets[i][0].equals("ICN")) {
               boolean[] visited = new boolean[tickets.length];
               
               visited[i] = true;
               List<String> templist = new ArrayList<>();
               templist.add(tickets[i][0]);
               templist.add(tickets[i][1]);
               dfs(tickets, visited, templist, 1);
           }
       }
       anslist.sort((a,b) -> {
           int cmp = 0;
           for(int i=0; i<a.length; i++) {
               cmp = a[i].compareTo(b[i]);
               if(cmp != 0) return cmp;
           }
           return 0;
       });
       return anslist.get(0);
    }
    
    public void dfs(String[][] tickets, boolean[] visited, List<String> templist, int cnt) {
        if(cnt == tickets.length) {
            String[] temparr = new String[templist.size()];
            for(int i=0; i<temparr.length; i++) {
                temparr[i] = templist.get(i);
            }
            anslist.add(temparr);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(visited[i]) continue;
            if(!templist.getLast().equals(tickets[i][0])) continue;
            
            templist.add(tickets[i][1]);
            visited[i] = true;
            dfs(tickets, visited, templist, cnt+1);
            visited[i] = false;
            templist.removeLast();
        }
    }
}