import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static char[][] map;
    private static int[][] group;
    private static int[][] visited;
    private static int[][] ans;
    private static int[] groupCnt;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        group = new int[N][M];

        Queue<Node> q = new ArrayDeque<>();

        visited = new int[N][M];
        groupCnt = new int[N*M+1];

        int start = 1;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    if (visited[i][j] != 0) continue;
                    q.add(new Node(i, j));
                    visited[i][j] = 1;
                    group[i][j] = start;
                    groupCnt[start] = 1;

                    while (!q.isEmpty()) {
                        Node n = q.poll();

                        int curX = n.x;
                        int curY = n.y;

                        for (int k = 0; k < 4; k++) {
                            int nxtX = curX + dx[k];
                            int nxtY = curY + dy[k];

                            if (nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= M) continue;
                            if (visited[nxtX][nxtY] != 0 || map[nxtX][nxtY] == '1') continue;

                            visited[nxtX][nxtY] = visited[curX][curY] + 1;
                            group[nxtX][nxtY] = start;
                            groupCnt[start]++;
                            q.add(new Node(nxtX, nxtY));
                        }
                    }
                    start++;
                }
            }
        }

        ans = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == '1') {
                    ArrayList<Integer> arr = new ArrayList<>();
                    int tmpAns = 1;
                    for(int k=0; k<4; k++) {
                        int nxtX = i + dx[k];
                        int nxtY = j + dy[k];
                        if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= M) continue;
                        if(map[nxtX][nxtY] == '0') {
                            if(!arr.contains(group[nxtX][nxtY])) {
                                tmpAns += groupCnt[group[nxtX][nxtY]];
                                arr.add(group[nxtX][nxtY]);
                            }
                        }
                    }
                    ans[i][j] = tmpAns;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(ans[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}