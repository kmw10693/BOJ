import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] map;
    static ArrayList<Node> teachers;
    static ArrayList<Node> students;
    static ArrayList<Node> empty;
    static boolean[] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        empty = new ArrayList<>();

        map = new char[N+1][N+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'S') {
                    students.add(new Node(i, j));
                }
                else if(map[i][j] == 'T') {
                    teachers.add(new Node(i, j));
                }
                else empty.add(new Node(i, j));
            }
        }
        visited = new boolean[empty.size()];
        track(0,0);
        System.out.println("NO");
    }

    public static void track(int cnt, int start) {
        if(cnt == 3) {
            if(dfs()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i=start; i< empty.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            Node n = empty.get(i);
            map[n.x][n.y] = 'O';
            track(cnt+1, i+1);
            visited[i] = false;
            map[n.x][n.y] = 'X';
        }
    }

    public static boolean dfs() {
        for(Node t : teachers) {
            int x = t.x;
            int y = t.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while (isIn(nx, ny)) {

                    if(map[nx][ny] == 'S') {
                        return false;
                    }
                    if(map[nx][ny] == 'O') break;

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }
    public static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >=0 && y < N;
    }
}