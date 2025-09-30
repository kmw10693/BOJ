import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static Map<Integer, String> dirs;

    // 오른쪽, 아래, 왼쪽, 위
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    // 방향
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        // 사과 위치 초기화 그냥 배열로 함
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
        }

        dirs = new HashMap<>();

        // 방향 전환
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // x, y로 전환
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            dirs.put(time, dir);
        }
        System.out.println(init());
    }

    // 시작
    public static int init() {
        // 지렁이니 queue니 좌표를 저장해야 겠지?
        Queue<Node> q = new LinkedList<>();

        // 지렁이니 0,0 좌표 시작이니 0,0 넣어야 함
        q.add(new Node(0, 0));
        // 시간을 1로 초기화 해야 함
        int time = 1;
        // 현재 x, y
        int curX = 0, curY = 0;
        // 방향 0 오른, 1 아래, 2 왼, 3 위
        int dir = 0;

        // 일단 while(true)
        while (true) {
            // 다음 좌표로 이동
            int nxtX = curX + dirX[dir % 4];
            int nxtY = curY + dirY[dir % 4];

            // 만약 다음 좌표가 맵 벗어난다면 break
            if (nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) break;

            // 만약 내 몸이랑 만난다면 false
            if (q.contains(new Node(nxtX, nxtY))) {
                break;
            }

            // 만약 사과를 만난다면
            if (map[nxtX][nxtY] == 1) {
                // 사과 없애주고 큐에 헤드 추가
                map[nxtX][nxtY] = 0;
                q.add(new Node(nxtX, nxtY));
            } else {
                // 꼬리 제거
                q.add(new Node(nxtX, nxtY));
                q.poll();
            }
            // N 초가 끝난뒤니까 방향 전환을 해야지 만약 존재한다면
            if (dirs.containsKey(time)) {
                // 만약 방향이 D라면 오른쪽 90도로 회전
                if (dirs.get(time).equals("D")) {
                    dir = (dir + 1) % 4;
                }
                // 만약 방향이 L이라면 왼쪽 90도로 회전
                else if (dirs.get(time).equals("L")) {
                    dir = (dir + 3) % 4;
                }
            }
            curX = nxtX;
            curY = nxtY;
            time++;
        }
        return time;
    }

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if(!(obj instanceof Node)) return false;
            Node n = (Node) obj;
            return x == n.x && y == n.y;
        }
    }

}
