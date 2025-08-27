import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Position implements Comparable<Position> {
        int x, y, count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Position o) {
            return this.count - o.count;
        }
    }

    static char[][] map;
    static ArrayList<Position> prisoner;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] prisionOne, prisionTwo, prisonThree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            prisoner = new ArrayList<>();
            map = new char[h + 2][w + 2];
            prisoner.add(new Position(0, 0, 0));
            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int s = 0; s < w; s++) {
                    map[j + 1][s + 1] = str.charAt(s);
                    if (map[j + 1][s + 1] == '$') {
                        prisoner.add(new Position(s + 1, j + 1, 0));
                    }
                }
            }
            prisionOne = bfs(prisoner.get(0), h, w);
            prisionTwo = bfs(prisoner.get(1), h, w);
            prisonThree = bfs(prisoner.get(2), h, w);
            bw.write(minDoor(h, w) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][] bfs(Position p, int h, int w) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        visited = new boolean[h + 2][w + 2];
        int[][] result = new int[h + 2][w + 2];
        visited[p.y][p.x] = true;
        pq.add(p);
        while (!pq.isEmpty()) {
            Position cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            result[y][x] = count;
            for (int i = 0; i < 4; i++) {
                int tempX = x + dx[i];
                int tempY = y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < w + 2 && tempY < h + 2 && !visited[tempY][tempX]) {
                    if (map[tempY][tempX] != '*') {
                        if (map[tempY][tempX] == '#') {
                            pq.add(new Position(tempX, tempY, count + 1));
                        } else
                            pq.add(new Position(tempX, tempY, count));
                        visited[tempY][tempX] = true;
                    }
                }
            }
        }
        return result;
    }

    static int minDoor(int h, int w) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (map[i][j] == '*') continue;
                int sum = prisionOne[i][j] + prisionTwo[i][j] + prisonThree[i][j];
                if (map[i][j] == '#') sum -= 2;

                if (result > sum && visited[i][j]) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
