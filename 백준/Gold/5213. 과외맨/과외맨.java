import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int r, c;
        ArrayList<Integer> path;

        Node(int r, int c, ArrayList<Integer> path) {
            this.r = r;
            this.c = c;
            this.path = path;
        }

        void add(int i) {
            this.path.add(i);
        }
    }

    static Queue<Node> q;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int[][] tileMap;
    static boolean[][] visisted;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        map = new int[N + 1][N * 2 + 1];
        tileMap = new int[N + 1][N * 2 + 1];
        visisted = new boolean[N + 1][N * 2 + 1];

        int tile = N;
        int tileNum = 1;
        int c = 1;

        for (int r = 1; r <= N; r++) {
            if (r % 2 == 0) {
                tile = N - 1;
                c = 2;
            } else {
                tile = N;
                c = 1;
            }

            for (int i = 0; i < tile; i++) {
                st = new StringTokenizer(br.readLine());
                tileMap[r][c] = tileNum;
                map[r][c++] = Integer.parseInt(st.nextToken());
                tileMap[r][c] = tileNum;
                map[r][c++] = Integer.parseInt(st.nextToken());
                tileNum++;
            }
        }

        visisted[1][1] = true;
        visisted[1][2] = true;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(1);
        q.offer(new Node(1, 1, path));
        q.offer(new Node(1, 2, path));

        Node ans = bfs();

        System.out.println(ans.path.size());

        ans.path.forEach(r -> System.out.print(r + " "));
    }

    private static Node bfs() {
        Node ans = null;
        int max = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (tileMap[now.r][now.c] > max) {
                max = tileMap[now.r][now.c];
                ans = now;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dir[d][0];
                int nc = now.c + dir[d][1];

                if (nr > N || nr < 1 || nc > 2 * N || nc < 1 || map[nr][nc] == 0 ||
                        visisted[nr][nc]
                ) continue;

                if(map[now.r][now.c] == map[nr][nc]) {
                    ArrayList<Integer> path = new ArrayList<>();
                    path.addAll(now.path);
                    path.add(tileMap[nr][nc]);

                    visisted[nr][nc] = true;
                    q.offer(new Node(nr, nc, path));

                    if(tileMap[nr][nc+1] == tileMap[nr][nc]) {
                        visisted[nr][nc+1] = true;
                        q.offer(new Node(nr, nc+1, path));
                    } else if(tileMap[nr][nc-1] == tileMap[nr][nc]) {
                        visisted[nr][nc-1] = true;
                        q.offer(new Node(nr, nc-1, path));
                    }
                }
            }
        }
        return ans;
    }
}