import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Person implements Comparable<Person> {
        int x, y, score;

        Person(int x, int y, int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            return this.score - o.score;
        }

    }

    private static int N;
    private static int h, w;
    private static char[][] map;
    private static ArrayList<Person> prisoner;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N > 0) {
            ans = 0x7f7f7f7f;
            prisoner = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            for (int i = 1; i < h + 1; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j+1] = s.charAt(j);
                    if (map[i][j+1] == '$') {
                        prisoner.add(new Person(i, j+1, 0));
                    }
                }
            }

            int[][] one = bfs(prisoner.get(0));
            int[][] two = bfs(prisoner.get(1));
            int[][] three = bfs(new Person(0,0, 0));
            calculate(one, two, three);
            System.out.println(ans);
            N--;
        }
    }

    private static int[][] bfs(Person p) {
        PriorityQueue<Person> pq = new PriorityQueue<>();
        visited = new boolean[h + 2][w + 2];
        int[][] result = new int[h + 2][w + 2];
        pq.add(p);
        visited[p.x][p.y] = true;
        result[p.x][p.y] = p.score;

        while (!pq.isEmpty()) {
            Person ps = pq.poll();
            int curX = ps.x;
            int curY = ps.y;

            for (int i = 0; i < 4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];

                if (nxtX < 0 || nxtX >= h + 2 || nxtY < 0 || nxtY >= w + 2) continue;
                if (visited[nxtX][nxtY]) continue;
                if (map[nxtX][nxtY] == '*') continue;

                if (map[nxtX][nxtY] == '#') {
                    pq.add(new Person(nxtX, nxtY, ps.score + 1));
                    result[nxtX][nxtY] = ps.score + 1;
                } else {
                    pq.add(new Person(nxtX, nxtY, ps.score));
                    result[nxtX][nxtY] = ps.score;
                }
                visited[nxtX][nxtY] = true;
            }
        }
        return result;
    }

    private static void calculate(int [][] one, int[][] two, int[][] three) {
        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                int tmp = one[i][j] + two[i][j] + three[i][j];
                if(map[i][j] == '*') continue;
                if(map[i][j] == '#') tmp-=2;
                if(visited[i][j])ans = Math.min(ans, tmp);
            }
        }

    }
}