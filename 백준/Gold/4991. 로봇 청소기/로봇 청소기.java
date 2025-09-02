import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int x, y, count;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int w,h;
    private static char[][] map;
    private static ArrayList<Node> dusts;
    private static int s_w, s_h;

    private static int[][][][] visited;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    private static int ans;
    private static boolean[] visited2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            visited = new int[h][w][h][w];
            map = new char[h][w];
            dusts = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') {
                        dusts.add(new Node(i, j));
                    }
                    if (map[i][j] == 'o') {
                        s_h = i;
                        s_w = j;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < h; k++) {
                        Arrays.fill(visited[i][j][k], -1);
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    bfs(i, j);
                }
            }

            ans = Integer.MAX_VALUE;
            visited2 = new boolean[dusts.size()];
            dfs(0, new int[dusts.size()]);

            if(ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            }
            else System.out.println(ans);
        }

    }

    private static void dfs(int depth, int[] permu) {
        if(depth == dusts.size()) {
            int r_x = s_h;
            int r_y = s_w;
            int distance = 0;

            for(int i=0; i<permu.length; i++) {
                Node d = dusts.get(permu[i]);
                int dis = visited[r_x][r_y][d.x][d.y];
                if(dis == -1) return;
                distance += dis;
                r_x = d.x;
                r_y = d.y;
            }
            ans = Math.min(ans, distance);
        }

        for(int i=0; i<dusts.size(); i++) {
            if(visited2[i]) continue;
            permu[depth] = i;
            visited2[i] = true;
            dfs(depth+1, permu);
            visited2[i] = false;
        }

    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y][x][y] = 0;
        while(!q.isEmpty()) {
            Node n = q.poll();
            int curX = n.x;
            int curY = n.y;
            for(int i=0; i<4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];

                if(nxtX < 0 || nxtX >= h || nxtY < 0 || nxtY >= w) continue;
                if(map[nxtX][nxtY] == 'x') continue;
                if(visited[x][y][nxtX][nxtY] != -1) continue;

                q.add(new Node(nxtX, nxtY));
                visited[x][y][nxtX][nxtY] = visited[x][y][curX][curY] + 1;
            }
        }
    }
}