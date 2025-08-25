import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static int N;
    static int[] stick;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<Node> not;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        // 입력 받기
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 던지는거 입력 받기
        N = Integer.parseInt(br.readLine());
        stick = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stick[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            // 터짐
            bomb(R - stick[i] , i);

            // 바닥에 있는거 BFS에 넣기
            BFS();

            // 이제 바닥에 없는 놈들 내려가기
            down();
        }
        print();
    }

    private static void print() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void down() {
        int cnt = 0;

        for(Node n : not) {
            map[n.x][n.y] = '.';
        }

        OUTER: for(int i=1; i<R; i++) {
            for(Node n : not) {
                if(n.x + i >= R || map[n.x +i][n.y] == 'x') {
                    break OUTER;
                }
            }
            cnt = i;
        }
        for(Node n : not) {
            map[n.x + cnt][n.y] = 'x';
        }
    }

    // 나머지 짝수이면 왼쪽, 홀수이면 오른쪽
    private static void bomb(int pos, int cnt) {
        if (cnt % 2 == 0) {
            for (int i = 0; i < C; i++) {
                if (map[pos][i] == 'x') {
                    map[pos][i] = '.';
                    break;
                }
            }
        } else {
            for (int i = C - 1; i >= 0; i--) {
                if (map[pos][i] == 'x') {
                    map[pos][i] = '.';
                    break;
                }
            }
        }
    }

    private static void BFS() {
        not = new ArrayList<>();
        visited = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        // 바닥부터 x이면 방문체크
        for (int i = 0; i < C; i++) {
            if (map[R - 1][i] == 'x') {
                visited[R - 1][i] = true;
                q.offer(new Node(R - 1, i));
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            int curX = n.x;
            int curY = n.y;

            for(int i=0; i<4; i++) {
                if(curX + dir[i][0] < 0 || curX + dir[i][0] >= R || curY + dir[i][1] < 0 || curY + dir[i][1] >= C) continue;
                if(visited[curX + dir[i][0]][curY + dir[i][1]] || map[curX + dir[i][0]][curY + dir[i][1]] == '.') continue;;

                visited[curX + dir[i][0]][curY + dir[i][1]] = true;
                q.offer(new Node(curX + dir[i][0], curY + dir[i][1]));
            }
        }

        // 없으면 추가
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(visited[i][j] == false && map[i][j] == 'x') {
                    not.add(new Node(i, j));
                }
            }
        }
    }
}