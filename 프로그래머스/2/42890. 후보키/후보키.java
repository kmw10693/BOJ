import java.util.*;
import java.io.*;

class Solution {
    Set<String> dup = new HashSet<>();
    
    public void dfs(String s, String[][] relation, int idx, int cnt, int goal) {
        if(cnt == goal) {
                Set<String> dupone = new HashSet<>();

                for(String[] r : relation) {
                    String tmp = "";
                    
                    for(int i=0; i<r.length; i++) {
                        for(int j=0; j<s.length(); j++) {

                            if(s.charAt(j) == i+'0') {
                                tmp += r[i] + "|";
                                break;
                            }
                        }    
                    }
                    dupone.add(tmp);
                }
                
                if(dupone.size() == relation.length) {
                    
                    boolean check = true;
                                        
                    for(String d : dup) {
                        boolean check2 = true;
                        for(char c : d.toCharArray()) {
                            if(s.indexOf(c) == -1) {
                                check2 = false;
                                break;
                            } 
                        }
                        if(check2) {
                            check = false;
                            break;
                        }
                    }
                    if(check) dup.add(s);
                }
            return;
        }
        
        for(int i=idx+1; i<relation[0].length; i++) {
            dfs(s+i, relation, i, cnt+1, goal);
        }
    }
    
    public int solution(String[][] relation) {
        for(int i=1; i<=relation[0].length; i++) {
            dfs("", relation, -1, 0, i);
        }
        
        return dup.size();
    }
}