import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        List<ServerType> servers = new ArrayList<>();
        int ans = 0;
        
        for(int i=0; i<players.length; i++) {
            
            for(int j=servers.size()-1; j>=0; j--) {
                if(servers.get(j).endtime <= i) servers.remove(j);
            }
            
            while(players[i]/m > servers.size()) {
                servers.add(new ServerType(i+k));
                ans++;
            }
        }
        return ans;
    }
    
    class ServerType {
        int endtime;
        
        ServerType(int endtime) {
            this.endtime = endtime;
        }
    }
}