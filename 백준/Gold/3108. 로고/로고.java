import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Node[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new Node[N + 1];
        visited = new boolean[N + 1];

        map[0] = new Node(0, 0, 0, 0);

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            map[i] = new Node(x1, x2, y1, y2);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        int ans = 0;

        for (int i = 0; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            q.add(map[i]);

            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int j = 0; j <= N; j++) {
                    if (i == j) continue;
                    if (check(cur, map[j]) || visited[j]) continue;
                    visited[j] = true;
                    q.add(map[j]);
                }
            }
            ans++;
        }
        System.out.println(ans - 1);

    }

    static boolean check(Node cur, Node nxt) {
        if ((cur.x1 < nxt.x1 && cur.x2 > nxt.x2 && cur.y1 < nxt.y1 && cur.y2 > nxt.y2) ||
                (cur.x1 > nxt.x1 && cur.x2 < nxt.x2 && cur.y1 > nxt.y1 && cur.y2 < nxt.y2) ||
                (cur.x2 < nxt.x1 || cur.x1 > nxt.x2 || cur.y2 < nxt.y1 || cur.y1 > nxt.y2)) return true;
        return false;
    }

    static class Node {
        int x1, x2, y1, y2;

        Node(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}