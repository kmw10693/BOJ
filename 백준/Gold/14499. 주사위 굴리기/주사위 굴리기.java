import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int x,y,K;

    // 맵
    static int[][] map;

    // dice
    //   1
    // 2 3 4
    //   5
    //   6
    static int[] dice;

    // 방향 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // dice는 7개의 일차원 배열로 일단 0으로 초기화
        dice = new int[7];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // K번동안 이동해야 함
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            // 방향
            int dir = Integer.parseInt(st.nextToken());
            // 현재 x,y 값이랑 방향 넘겨줘야 함
            move(x, y, dir);
        }

    }
    //  만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
    static void move(int curX, int curY, int dir) {
        int nxtX = curX + dx[dir-1];
        int nxtY = curY + dy[dir-1];

        // 만약 다음 방향이 맵 바깥으로 이동하면 return
        if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= M) return;
        // 다음 좌표 주고 출력하면 될듯?
        nextMove(nxtX, nxtY, dir-1);
        x = nxtX;
        y = nxtY;
    }
    // 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면,
    // 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
    // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

    static void nextMove(int nxtX, int nxtY, int dir) {
        // 동쪽, 서쪽, 북쪽, 남쪽 이동함에 따라 주사위 바닥면도 바뀜
        // 동쪽
        if(dir == 0) {
            int tmp = dice[4];
            dice[4] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = tmp;
        }
        // 서쪽
        else if(dir == 1) {
            int tmp = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = tmp;
        }
        // 북쪽
        else if(dir == 2) {
            int tmp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = tmp;
        }
        // 남쪽
        else if(dir == 3) {
            int tmp = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }
        // , 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
        if(map[nxtX][nxtY] == 0) {
            map[nxtX][nxtY] = dice[6];
        }
        // 0 이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
        else {
            dice[6] = map[nxtX][nxtY];
            map[nxtX][nxtY] = 0;
        }
        // 주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때,
        // 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.
        System.out.println(dice[3]);
    }
}