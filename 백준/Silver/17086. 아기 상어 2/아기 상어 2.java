import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[][] ans;
    static int[] dx = {1,-1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        ans = new int[N][M];

        Queue<Node> q = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Node(i, j));
                    visited[i][j] = -1;
                    ans[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            int curX = n.x;
            int curY = n.y;
            int dis = ans[curX][curY];

            for(int i=0; i<8; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];

                if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= M || visited[nxtX][nxtY] == -1) continue;

                if(ans[nxtX][nxtY] <= dis+1) continue;
                ans[nxtX][nxtY] = dis + 1;
                q.add(new Node(nxtX, nxtY));
            }

        }

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j] != -1) {
                    answer = Math.max(answer, ans[i][j]);
                }
            }
        }
        System.out.println(answer);

    }

    public static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}