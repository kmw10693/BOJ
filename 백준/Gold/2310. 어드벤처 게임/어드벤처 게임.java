import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int n;
    static StringBuilder sb;
    static Map<Integer, Room> rooms;

    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            n = Integer.parseInt(br.readLine());

            if(n == 0) {
                System.out.println(sb.toString());
                return;
            }

            rooms = new HashMap<>();
            for(int i=1; i<=n; i++) {
                String[] s = br.readLine().split(" ");

                char type = s[0].charAt(0);
                int cost = Integer.parseInt(s[1]);

                List<Integer> nextRoom = new ArrayList<>();
                for(int j=2; j<s.length-1; j++) {
                    nextRoom.add(Integer.parseInt(s[j]));
                }

                Room room = new Room(type, cost, nextRoom);
                rooms.put(i, room);
            }
            solution();
        }
    }

    public static void solution() {
        visited = new boolean[n+1];
        visited[1] = true;
        flag = false;

        dfs(1, 0);

        if(flag) sb.append("Yes").append("\n");
        else sb.append("No").append("\n");
    }

    public static void dfs(int start, int cost) {
        if(flag) return;

        Room room = rooms.get(start);

        if(room.type == 'L') {
            cost = Math.max(cost, room.cost);
        }
        else if(room.type == 'T') {
            cost -= room.cost;
            if(cost < 0) return;
        }

        if(start == n) flag = true;

        for(int roomNumber : room.nextRoom) {
            if(!visited[roomNumber])
            {
                visited[roomNumber] = true;
                dfs(roomNumber, cost);
                visited[roomNumber] = false;
            }
        }

    }

    public static class Room {
        char type;
        int cost;
        List<Integer> nextRoom;

        Room(char type, int cost, List<Integer>nextRoom) {
            this.type = type;
            this.cost = cost;

            this.nextRoom = new ArrayList<>();
            this.nextRoom.addAll(nextRoom);
        }
    }
}