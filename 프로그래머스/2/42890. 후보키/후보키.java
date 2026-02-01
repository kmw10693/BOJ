import java.util.*;
import java.io.*;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int ans = 0;
    
    public int solution(String[][] relation) {
        // 1개 ~ N개로 개수 판별
        for(int i=0; i<relation[0].length; i++) {
            
            // DFS
            boolean[] visited = new boolean[relation[0].length];
            List<Integer> indexlist = new ArrayList<>();
            dfs(indexlist, 0, i+1, relation, visited);
        }
        return ans;
    }
    
    public void dfs(List<Integer> indexlist, int cnt, int last, String[][] relation, boolean[] visited) {
        if(cnt >= last) {
            Map<String, Integer> map = new HashMap<>();

            boolean check = true;
            for(int i=0; i<relation.length; i++) {
                String tmp = "";
                for(int index : indexlist) {
                    tmp += relation[i][index] + '|';
                }
                
                if(map.containsKey(tmp)) {
                    check = false;
                } else {
                    map.put(tmp, 1);
                }
            }
            
            boolean check2 = true;
            for(int i=0; i<list.size(); i++) {
                List<Integer> lists = list.get(i);
                Set<Integer> setlist = new HashSet<>();
                
                for(int l : lists) setlist.add(l);
                
                if(indexlist.containsAll(setlist)) {
                    check2= false;
                    break;
                }
                if(!check2) break;
            }
            if(check && check2) {
                List<Integer> newlist = new ArrayList<>();
                for(int v : indexlist) newlist.add(v);
                list.add(newlist);
                ans++;
            }
            
            return;
        }
        
        for(int j=0; j<relation[0].length; j++) {
                if(visited[j]) continue;
                visited[j] = true;
                indexlist.add(j);
                dfs(indexlist, cnt+1, last, relation, visited);
                visited[j] = false;
                indexlist.remove(indexlist.size()-1);
        }
        
    }
}