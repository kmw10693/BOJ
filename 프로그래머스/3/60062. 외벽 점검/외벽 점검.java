import java.util.*;

class Solution {
    int[] order;
    int[] extendweak;
    int weaklen;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) { 
        extendweak = new int[weak.length*2];
        weaklen = weak.length;
        
        for(int i=0; i<weak.length; i++) {
            extendweak[i] = weak[i];
            extendweak[i+weak.length] = n+weak[i];
        }
        
        order = new int[dist.length];
        dfs(0, dist, new boolean[dist.length]);
        
        if(answer > dist.length) return -1;
        return answer;
    }
    
    void dfs(int cnt, int[] dist, boolean[] visited) {
        if(cnt == dist.length) {
            canorder();
            return;
        }
        
        for(int i=0; i<dist.length; i++) {
            if(visited[i]) continue;
            order[cnt] = dist[i];
            visited[i] = true;
            dfs(cnt+1, dist, visited);
            visited[i] = false;
        }
    }
    
    void canorder() {        
        for(int start= 0; start<weaklen; start++) {
            int people = 1;
            int position = extendweak[start] + order[0];
            for(int j=start; j<start+weaklen; j++) {
                if(extendweak[j] > position) {
                    people++;
                    
                    if(people > order.length) {
                        break;
                    }
                    
                    position = extendweak[j] + order[people-1];
                }
            }
            answer = Math.min(answer, people);
        }
    }
}