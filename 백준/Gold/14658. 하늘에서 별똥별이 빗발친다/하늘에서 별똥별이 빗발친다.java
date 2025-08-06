import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, K;
    static ArrayList<Pos> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        process();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Pos(r, c));
        }
    }

    private static void process() {
        for(Pos p1 : list) {
            for(Pos p2 : list) {
                int cnt = 0;
                for (Pos pos : list) {
                    if(p1.r <= pos.r && pos.r <= p1.r + L && p2.c <= pos.c && pos.c <= p2.c + L) cnt++;
                }
                max = Math.max(cnt, max);
            }
        }
    }

    private static void print() {
        System.out.println(K - max);
    }

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}