import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static Student[] students;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans;
    static Map<Integer, Integer> hash = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        // 학생 N^2 저장
        students = new Student[N*N];

        for(int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine());
            // 임시 번호, 맵 저장
            int num = Integer.parseInt(st.nextToken());
            int[] map = new int[4];
            for(int j=0; j<4; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }
            students[i] = new Student(num, map);
            // num과 I를 연결
            hash.put(num, i);
            // 몇번째 학생인지 구분하기 위해서 i로 인자 전달
            rotate(i, num);
        }
        sat();
        System.out.print(ans);
    }
    static void debug() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void sat() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int num = map[i][j];
                Student student = students[hash.get(num)];
                int[] likes = student.map;
                int cnt = 0;
                for(int p=0; p<4; p++) {
                    int nxtX = i + dx[p];
                    int nxtY = j + dy[p];
                    if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
                    for(int k=0; k<4; k++) {
                        if(likes[k] == map[nxtX][nxtY]) {
                            cnt++;
                            break;
                        }
                    }
                }
                ans += (int) Math.pow(10, cnt-1);
            }
        }
    }
    // i로 전달 받았으므로 맞음.
    static void rotate(int num, int t) {
        // 비어있는 칸중 좋아하는 학생 여러개인지 확인
        Student student = students[num];
        // 첫번째가 중복인지 판단
        List<Node> one = new ArrayList<>();
        // 최솟값
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 만약 값이 있을경우 순회 x
                if(map[i][j] > 0) continue;
                // 순회한 값
                int tmp = check(i, j, student);
                if(tmp > max) max = tmp;
            }
        }
        // 학생 여러명인지 확인
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] > 0) continue;
                int tmp = check(i, j,student);
                // 중복인 경우 좌표 저장
                if(max == tmp) one.add(new Node(i, j));
            }
        }

        // 만약 1번이 중복인 경우 1번 중에
        if(one.size() <= 1) {
            map[one.get(0).x][one.get(0).y] = t;
            return;
        }

        // 인접한 칸 중에서 비어있는 칸이 가장 많은 칸
        int tmp2 = Integer.MIN_VALUE;
        List<Node> two = new ArrayList<>();
        for(int i=0; i<one.size(); i++) {
            Node tmp = one.get(i);
            int x = tmp.x;
            int y = tmp.y;
            int cnt = 0;
            for(int p=0; p<4; p++) {
                int nxtX = x + dx[p];
                int nxtY = y + dy[p];
                if (nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
                if(map[nxtX][nxtY] == 0) cnt++;
            }
            tmp2 = Math.max(tmp2, cnt);
        }

        for(int i=0; i<one.size(); i++) {
            Node tmp = one.get(i);
            int x = tmp.x;
            int y = tmp.y;
            int cnt = 0;
            for(int p=0; p<4; p++) {
                int nxtX = x + dx[p];
                int nxtY = y + dy[p];
                if (nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
                if(map[nxtX][nxtY] == 0) cnt++;
            }
            if(tmp2 == cnt) two.add(new Node(x, y));
        }
        if(two.size() <= 1) {
            map[two.get(0).x][two.get(0).y] = t;
            return;
        }

        // 행의 번호가 가장 작은 칸으로,열의 번호가 가장 작은 칸
        two.sort((o1, o2) -> {
            if(o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        map[two.get(0).x][two.get(0).y] = t;
    }
    static int check(int i, int j, Student student) {
        // i, j에 인접한 칸 중에 좋아하는 학생이 몇명인지 반환
        int[] tmp = student.map;
        int cnt = 0;
        for(int p=0; p<4; p++) {
            int nxtX = i + dx[p];
            int nxtY = j + dy[p];

            if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
            // 또 돌려야 함
            // 인접한 좌표의 map과 학생이 선호하는 학생이 같은지 확인 -> 같으면 check = true
            boolean check = false;
            for(int t=0; t<4; t++) {
                if(tmp[t] == map[nxtX][nxtY]) {
                    check = true;
                    break;
                }
            }
            if(check) cnt++;
        }
        return cnt;
    }
    // 몇번째 좌표인지 판단
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Student {
        int num;
        int[] map = new int[4];

        Student(int num, int[] map) {
            this.num = num;
            this.map = map;
        }
    }
}