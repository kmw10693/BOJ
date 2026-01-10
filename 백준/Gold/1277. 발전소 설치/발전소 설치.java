import java.util.*;
import java.io.*;

public class Main {
    static int N,W;
    static double M, INF = 200005;
    static Point[] p;
    static boolean[][] connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        M = Double.parseDouble(br.readLine());
        p = new Point[N+1];

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            p[i] = new Point(x, y);
        }
        connect = new boolean[N+1][N+1];
        for(int i=0; i<W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            connect[x][y] = true;
            connect[y][x] = true;
        }
        // 다익스트라 1 ~ N까지 최소 경로
        System.out.println(dijkstra());
    }
    private static long dijkstra() {
        // 1 ~ N까지 INF
        double[] distance = new double[N+1];
        boolean[] visited = new boolean[N+1];
        for(int i=1; i<N+1; i++) {
            distance[i] = INF;
        }
        distance[1] = 0;

        // 만약 1번과 연결되었다면 distance는 0으로 해야 함
        for(int i=2; i<N+1; i++) {
            if(connect[1][i] || connect[i][1]) distance[i] = 0;
        }

        // 모든 정점을 탐색
        for(int i=1; i<N+1; i++) {
            int cur = -1;
            double dist = INF;
            // 인접한 것중에 가장 가까운것을 탐색
            for(int j=1; j<N+1; j++) {
                if(!visited[j] && dist >= distance[j]) {
                    cur = j;
                    dist = distance[j];
                }
            }
            // 갱신
            if(cur == N) break;
            visited[cur] = true;

            // 선택된 정점에 대해서 모든 정점에 대해 거래 갱신
            for(int j=1; j<N+1; j++) {
                if(cur == j) continue;
                if(distance[j] > distance[cur] + getDistance(cur, j)) {
                    distance[j] = distance[cur] + getDistance(cur, j);
                }
            }
        }
        return (long) (distance[N] * 1000);
    }

    static double getDistance(int cur, int j) {
        if(connect[cur][j]) return 0;
        return Math.sqrt(Math.pow(p[cur].x - p[j].x, 2) + Math.pow(p[cur].y - p[j].y, 2));
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}