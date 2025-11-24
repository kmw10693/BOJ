import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        ArrayList<Server> servers = new ArrayList<>();
        ArrayList<Integer> test = new ArrayList<>();
        
        int answer = 0;

        for(int i=0; i<players.length; i++) {
            for(int j=servers.size()-1; j>=0; j--) {
                if(servers.get(j).time <= i) {
                    servers.remove(j);
                }
            }
 
            while(players[i]/m > servers.size()) {
                servers.add(new Server(i+k));
                answer++;
            } 
            test.add(servers.size());
        }
        for(int t: test) {
            System.out.print(t);
            System.out.print(" ");
        }
        
        return answer;
    }
    class Server {
        int time;
        Server(int time) {
            this.time = time;
        }
    }
}