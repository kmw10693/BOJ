import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static List<Node> chicken;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int distance = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        chicken = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) chicken.add(new Node(i, j, 0));
            }
        }

        // 조합으로 고르자
        List<Node> tmp = new ArrayList<>();
        for(int i=1; i<=m; i++) {
            comb(0, 0, tmp, i);
        }

        System.out.println(distance);
    }
    static void comb(int start, int cnt, List<Node> picked, int k) {
        if(picked.size() == k) {
            calculate(picked);
            return;
        }
        for(int i=start; i<chicken.size(); i++) {
            picked.add(chicken.get(i));
            comb(i+1, cnt+1, picked, k);
            picked.remove(picked.size()-1);
        }
    }

    private static void calculate(List<Node> tmp) {
        Queue<Node> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<tmp.size(); i++) q.add(tmp.get(i));
        int tmpAns = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++) {
                int nxtX = cur.x + dx[i];
                int nxtY = cur.y + dy[i];
                if(nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= n) continue;
                if(visited[nxtX][nxtY]) continue;

                if(arr[nxtX][nxtY] == 1) {
                    tmpAns += (cur.dis + 1);
                }
                visited[nxtX][nxtY] = true;
                q.add(new Node(nxtX, nxtY, cur.dis + 1));
            }
        }
        distance = Math.min(distance, tmpAns);
    }

    static class Node implements Comparable<Node> {
        int x, y, dis;
        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }
}