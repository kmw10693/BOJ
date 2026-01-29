import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[][] plans) {
        Node[] times = new Node[plans.length];
        int i = 0;
        for(String[] p : plans) {
            String name = p[0];
            int start = convert(p[1]);
            int duration = Integer.parseInt(p[2]);
            times[i++] = new Node(name, start, duration); 
        }
        Arrays.sort(times, (o1, o2) -> (o1.startTime - o2.startTime));
        
        List<String> result = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        
        for(int j=0; j<times.length-1; j++) {
            Node cur = times[j];
            Node nxt = times[j+1];
            
            int end = nxt.startTime - cur.startTime;
            
            if(end >= cur.dur) {
                result.add(cur.name);
                end -= cur.dur;
                while(!s.isEmpty() && end > 0) {
                    Node scur = s.pop();
                    if(end >= scur.dur) {
                        end -= scur.dur;
                        result.add(scur.name);
                    } else {
                        s.add(new Node(scur.name, scur.startTime, scur.dur - end));
                        end = 0;
                    }
                }
            } else {
                s.add(new Node(cur.name, cur.startTime, cur.dur - end));
            }
        }
        
        Node last = times[times.length-1];
        result.add(last.name);
        while(!s.isEmpty()) {
            result.add(s.pop().name);
        }
        return result.toArray(new String[0]);
    }
    
    public int convert(String s) {
        String[] div = s.split(":");
        return Integer.parseInt(div[0])*60 + Integer.parseInt(div[1]);
    }
    
    class Node {
        String name;
        int startTime, dur;
        Node(String name, int startTime, int dur) {
            this.name = name;
            this.startTime = startTime;
            this.dur = dur;
        }
    }
}